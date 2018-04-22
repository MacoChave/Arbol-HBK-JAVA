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
            root = balance(root);
        }
        else
            root = add(data, root);
    }

    private AVLNode<T> add(T data, AVLNode<T> current) {
        if (current.compareTo(data) > 0)
        {
            if (current.getLeftChild() == null)
                current.setLeftChild(new AVLNode<>(data));
            else
                current.setLeftChild(add(data, current.getLeftChild()));
        }
        else if (current.compareTo(data) < 0)
        {
            if ((current.getRightChild() == null))
                current.setRightChild(new AVLNode<>(data));
            else
                current.setRightChild(add(data, current.getRightChild()));
        }

        getFactorBalance(current);
        current = balance(current);
        return current;
    }

    public void edit(T data) {
        AVLNode<T> node = get(data);

        if (node != null)
            node.setInfo(data);
    }

    public AVLNode<T> get(T data) {
        if (root.compareTo(data) > 0)
            return get(data, root.getLeftChild());
        else if (root.compareTo(data) < 0)
            return get(data, root.getRightChild());
        else
            return root;
    }

    @Nullable
    @Contract(pure = true)
    private AVLNode<T> get(T data, AVLNode<T> current) {
        if (current == null)
            return null;

        if (current.compareTo(data) > 0)
            return get(data, current.getLeftChild());
        else if (current.compareTo(data) < 0)
            return get(data, current.getRightChild());
        else
            return current;
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

    private AVLNode<T> balance(AVLNode<T> current) {
        if (current.getFactorBalance() > 1)
        {
            if (current.getRightChild().getFactorBalance() == 1)
                current = rotate_SL(current);
            else
                current = rotate_DR(current);
        }
        else if (current.getFactorBalance() < -1)
        {
            if (current.getLeftChild().getFactorBalance() == 1)
                current = rotate_DL(current);
            else
                current = rotate_SR(current);
        }

        return current;
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

    private AVLNode<T> rotate_DR(AVLNode<T> current) {
        current.setRightChild(rotate_SR(current.getRightChild()));
        getFactorBalance(current);
        return rotate_SL(current);
    }

    private AVLNode<T> rotate_DL(AVLNode<T> current) {
        current.setLeftChild(rotate_SL(current.getLeftChild()));
        getFactorBalance(current);
        return rotate_SR(current);
    }

    private AVLNode<T> rotate_SR(AVLNode<T> current) {
        AVLNode<T> node = current.getLeftChild();
        current.setLeftChild(node.getRightChild());
        node.setRightChild(current);

        getFactorBalance(current);
        getFactorBalance(node);
        return node;
    }

    private AVLNode<T> rotate_SL(AVLNode<T> current) {
        AVLNode<T> node = current.getRightChild();
        current.setRightChild(node.getLeftChild());
        node.setLeftChild(current);

        getFactorBalance(current);
        getFactorBalance(node);
        return node;
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
