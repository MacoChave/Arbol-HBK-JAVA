package AVLTree;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import structure.DataStructure;

public class AVLTree<T extends DataStructure> {

    private AVLNode<T> root;

    public AVLTree() {
        root  = null;
    }

    public AVLTree(AVLNode<T> root) {
        this.root = root;
    }

    public AVLNode<T> getRoot() {
        return root;
    }

    @Override
    public String toString() {
        return "AVLTree{" +
                "root=" + root +
                '}';
    }

    public void add(T data) {
        if (root == null) {
            root = new AVLNode<>(data);
            getFactorBalance(root);
            equilibrar(root);
        }
        else
            add(data, root);
    }

    private void add(T data, AVLNode<T> current) {
        if (current.compareTo(data) > 0)
        {
            if (current.getLeftChild() == null)
                current.setLeftChild(new AVLNode<>(data));
            else
                add(data, current.getLeftChild());
        }
        else if (current.compareTo(data) < 0)
        {
            if ((current.getRightChild() == null))
                current.setRightChild(new AVLNode<>(data));
            else
                add(data, current.getRightChild());
        }

        getFactorBalance(current);
        equilibrar(current);
    }

    public void edit(T data) {

    }

    public AVLNode<T> get(T data) {
        return null;
    }

    @Nullable
    @Contract(pure = true)
    private AVLNode<T> get(T data, AVLNode<T> current) {

        return null;
    }

    public String graph() {
        return String.format("\n%s\n",
                graph(root));
    }

    @NotNull
    @Contract(pure = true)
    private String graph(AVLNode<T> current) {
        String text = "";

        if (current == null) {
            return text;
        }

        text += current.createNode() + "\n";
        if (current.getLeftChild() != null)
            text += String.format("%s : izq -> %s\n",
                    current.nodeName(), current.getLeftChild().nodeName());
        if (current.getRightChild() != null)
            text += String.format("%s : der -> %s\n",
                    current.nodeName(), current.getRightChild().nodeName());

        text += graph(current.getLeftChild());
        text += graph(current.getRightChild());

        return text;
    }

    private void equilibrar(AVLNode<T> current) {

    }

    private void getFactorBalance(AVLNode<T> current) {
        int hi = 0, hd = 0;

        if (current.getLeftChild() != null)
            hi = Math.max(current.getLeftChild().getLeftHeight(), current.getLeftChild().getRightHeight()) + 1;
        if (current.getRightChild() != null)
            hd = Math.max(current.getRightChild().getLeftHeight(), current.getRightChild().getRightHeight()) + 1;

        current.setLeftHeight(hi);
        current.setRightHeight(hd);
        current.setFactorBalance(hd - hi);
    }

    private void rotate_DL(AVLNode<T> current) {

    }

    private void rotate_DR(AVLNode<T> current) {

    }

    private void rotate_SL(AVLNode<T> current) {

    }

    private void rotate_SR(AVLNode<T> current) {

    }

    private void balanceOlder(AVLNode<T> current) {

    }

    private void balanceMinor(AVLNode<T> current) {

    }

    @Nullable
    @Contract(pure = true)
    private AVLNode<T> getOlder(AVLNode<T> current) {

        return null;
    }

    @Nullable
    @Contract(pure = true)
    private AVLNode<T> getMinor(AVLNode<T> current) {

        return null;
    }
}
