package ru.geekbrains;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.function.Consumer;

public class TreeImpl<E extends Comparable<? super E>> implements Tree<E> {

    private Node<E> root;
    private int size;
    private final int maxLevel;

    public TreeImpl(int maxLevel) {
        this.maxLevel = maxLevel;
    }

    @Override
    public boolean add(E value) {
        if (root == null) {
            root = new Node<>(value);
            return true;
        }
        Node<E> current = root;
        Node<E> tmp;
        boolean result = false;
        while (! result) {
            if (current.getLevel() == maxLevel) {
                System.out.println("maxLevel");
                return false;
            }
            switch (current.compareValue(value)) {
                case -1:
                    tmp = current.getRightChild();
                    if (tmp == null) {
                        current.setRightChild(new Node<>(value));
                        result = true;
                    } else {
                        current = tmp;
                    }
                    break;
                case 1:
                    tmp = current.getLeftChild();
                    if (tmp == null) {
                        current.setLeftChild(new Node<>(value));
                        result = true;
                    } else {
                        current = tmp;
                    }
                    break;
                default: result = true;
            }
        }
        return result;
    }

    private Node<E> find(E value) {
        for (Node<E> tmp = root; tmp != null;) {
            switch (tmp.compareValue(value)) {
                case -1:
                    tmp = tmp.getRightChild();
                    break;
                case 1:
                    tmp = tmp.getLeftChild();
                    break;
                default: return tmp;
            }
        }
        return null;
    }

    @Override
    public boolean contains(E value) {
        return find(value) != null;
    }

    @Override
    public void remove(E value) {
        Node<E> node = find(value);
        if (node == null) {
            return;
        }
        switch (node.numChildes()) {
            case 0:
                removeLeaf(node);
                break;
            case 1:
                removeOneChildrenNode(node);
                break;
            default:
                removeBothChildrenNode(node);
        }
    }

    private void removeLeaf(Node<E> node) {
        if (node == root) {
            root = null;
            return;
        }
        if (node.isLeft()) {
            node.getParent().setLeftChild(null);
        } else {
            node.getParent().setRightChild(null);
        }
    }

    private void removeOneChildrenNode(Node<E> node) {
        if (node == root) {
            root = node.getSingleChild();
            return;
        }
        if (node.isLeft()) {
            node.getParent().setLeftChild(node.getSingleChild());
        } else {
            node.getParent().setRightChild(node.getSingleChild());
        }
    }

    private void removeBothChildrenNode(Node<E> node) {
        Node<E> successor = node.getRightChild().findMinNode();
        if (node == root) {
            root = successor;
            return;
        }
        if (node.isLeft()) {
            node.getParent().setLeftChild(successor);
        } else {
            node.getParent().setRightChild(successor);
        }
    }


    @Override
    public boolean isEmpty() {
        return root == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void display() {
        Stack<Node<E>> globalStack = new Stack<>();
        globalStack.push(root);
        int nBlanks = 64;

        boolean isRowEmpty = false;
        System.out.println("................................................................");

        while (!isRowEmpty) {
            Stack<Node<E>> localStack = new Stack<>();

            isRowEmpty = true;
            for (int i = 0; i < nBlanks; i++) {
                System.out.print(" ");
            }

            while (!globalStack.isEmpty()) {
                Node<E> tempNode = globalStack.pop();
                if (tempNode != null) {
                    System.out.print(tempNode.getValue());
                    localStack.push(tempNode.getLeftChild());
                    localStack.push(tempNode.getRightChild());
                    if (tempNode.getLeftChild() != null || tempNode.getRightChild() != null) {
                        isRowEmpty = false;
                    }
                } else {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for (int j = 0; j < nBlanks * 2 - 2; j++) {
                    System.out.print(" ");
                }
            }

            System.out.println();

            while (!localStack.isEmpty()) {
                globalStack.push(localStack.pop());
            }

            nBlanks /= 2;
        }
        System.out.println("................................................................");
    }

    @Override
    public void traverse(TraversMode mode, Consumer<Node<E>> consumer) {
        switch (mode) {
            case PRE_ORDER:
                preOrder(root, consumer);
                break;
            case IN_ORDER:
                inOrder(root, consumer);
                break;
            default:
                postOrder(root, consumer);
        }
    }

    private void preOrder(Node<E> node, Consumer<Node<E>> consumer) {
        if (node == null) {
            return;
        }
        consumer.accept(node);
        preOrder(node.getLeftChild(), consumer);
        preOrder(node.getRightChild(), consumer);
    }

    private void inOrder(Node<E> node, Consumer<Node<E>> consumer) {
        if (node == null) {
            return;
        }
        inOrder(node.getLeftChild(), consumer);
        consumer.accept(node);
        inOrder(node.getRightChild(), consumer);
    }

    private void postOrder(Node<E> node, Consumer<Node<E>> consumer) {
        if (node == null) {
            return;
        }
        postOrder(node.getLeftChild(), consumer);
        postOrder(node.getRightChild(), consumer);
        consumer.accept(node);
    }

    public boolean isBalanced() {
        if (root == null) {
            return true;
        }
        int leftHeight = root.getLeftChild() == null ? 0 : root.getLeftChild().maxHeight();
        int rightHeight = root.getRightChild() == null ? 0 : root.getRightChild().maxHeight();
        return Math.abs(leftHeight - rightHeight) < 2;
    }
}
