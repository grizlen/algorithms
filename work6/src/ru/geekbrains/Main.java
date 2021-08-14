package ru.geekbrains;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    private static ArrayList<Tree<Integer>> trees = new ArrayList<>();
    private static Random random = new Random();
    private static int balanced;

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            TreeImpl<Integer> tree = buildTree();
            tree.display();
            if (tree.isBalanced()) {
                balanced++;
                System.out.println("balanced.");
            }
        }
        System.out.printf("сбалансированых: %.0f%% деревьев.", (float) balanced / 20 * 100);
    }

    private static TreeImpl<Integer> buildTree() {
        TreeImpl<Integer> tree = new TreeImpl<>(5);
        trees.add(tree);
        for (int n = 0; n < 16; n++) {
            tree.add(random.nextInt(200) - 100);
        }
        return tree;
    }
}
