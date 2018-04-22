package AVLTree;

import org.jetbrains.annotations.NotNull;
import structure.DataStructure;

public class AVLNode<T extends DataStructure> extends DataStructure {

    private T info;
    private int factorBalance;
    private int leftHeight;
    private int rightHeight;
    private AVLNode leftChild;
    private AVLNode rightChild;

    public AVLNode() {
        info = null;
        factorBalance = 0;
        leftHeight = 0;
        rightHeight = 0;
        leftChild = null;
        rightChild = null;
    }

    public AVLNode(T data) {
        this.info = data;
        leftHeight = 0;
        rightHeight = 0;
        factorBalance = 0;
        leftChild = null;
        rightChild = null;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T data) {
        info = data;
    }

    public int getFactorBalance() {
        return factorBalance;
    }

    public void setFactorBalance(int factorBalance) {
        this.factorBalance = factorBalance;
    }

    public int getLeftHeight() {
        return leftHeight;
    }

    public void setLeftHeight(int leftHeight) {
        this.leftHeight = leftHeight;
    }

    public int getRightHeight() {
        return rightHeight;
    }

    public void setRightHeight(int rightHeight) {
        this.rightHeight = rightHeight;
    }

    public AVLNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AVLNode leftChild) {
        this.leftChild = leftChild;
    }

    public AVLNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AVLNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "info=" + info.toString();
    }

    @Override
    public String nodeName() {
        return info.nodeName();
    }

    @Override
    public String createNode() {
        return info.createNode();
    }

    @Override
    public int compareTo(@NotNull Object o) {
        return info.compareTo(o);
    }
}
