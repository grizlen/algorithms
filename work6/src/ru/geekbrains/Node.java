package ru.geekbrains;

public class Node<T extends Comparable<? super T>> {

    private final T value;
    private Node<T> parent;
    private Node<T> leftChild;
    private Node<T> rightChild;
    private int level;

    public Node(T value) {
        this.value = value;
        level = 0;
    }

    public Node(T value, Node<T> parent) {
        this.value = value;
        setParent(parent);
    }

    public T getValue() {
        return value;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
        level = parent != null ? parent.level + 1 : 0;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        if (leftChild != null) {
            leftChild.setParent(this);
        }
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        if (rightChild != null) {
            rightChild.setParent(this);
        }
        this.rightChild = rightChild;
    }

    public int getLevel() {
        return level;
    }

    public int compareValue(T value) {
        return this.value.compareTo(value);
    }

    public int numChildes() {
        if (leftChild == null) {
            return rightChild == null ? 0 : 1;
        }
        return rightChild == null ? 1 : 2;
    }

    public boolean isLeft() {
        return parent != null && parent.compareValue(value) == 1;
    }

    public Node<T> getSingleChild() {
        return leftChild != null ? leftChild : rightChild != null ? rightChild : null;
    }

    public Node<T> findMinNode() {
        for (Node<T> n = this;;n = n.leftChild) {
            if (n.leftChild == null) {
                return n;
            }
        }
    }

    public Node<T> findMaxNode() {
        for (Node<T> n = this;;n = n.rightChild) {
            if (n.rightChild == null) {
                return n;
            }
        }
    }

    public int maxHeight() {
        int result = level;
        int rightHeigh = result;
        if (leftChild != null) {
            result = leftChild.maxHeight();
        }
        if (rightChild != null) {
            rightHeigh = rightChild.maxHeight();
        }
        return rightHeigh > result ? rightHeigh : result;
    }
}
