package AVLTree;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import structure.DataStructure;

public class HBTree<T extends DataStructure> {

    private HBNode<T> root;

    private int k;

    public HBTree(int k) {
        this.k = k;
        root  = null;
    }

    public HBNode<T> getRoot() {
        return root;
    }

    public int getK() {
        return k;
    }

    @Override
    public String toString() {
        return "HBTree{" +
                "root=" + root +
                '}';
    }

    public void add(T data) {
        if (root == null) {
            root = new HBNode<>(data);
            getFactorBalance(root);
            root = balance(root);
        }
        else
            root = add(data, root);
    }

    private HBNode<T> add(T data, HBNode<T> current) {
        if (current.compareTo(data) > 0)
        {
            if (current.getLeftChild() == null)
                current.setLeftChild(new HBNode<>(data));
            else
                current.setLeftChild(add(data, current.getLeftChild()));
        }
        else if (current.compareTo(data) < 0)
        {
            if ((current.getRightChild() == null))
                current.setRightChild(new HBNode<>(data));
            else
                current.setRightChild(add(data, current.getRightChild()));
        }

        getFactorBalance(current);
        current = balance(current);
        return current;
    }

    public void edit(T oldData, T newData) {
        HBNode<T> node = get(oldData);

        if (node != null)
            node.setInfo(newData);
    }

    public HBNode<T> get(T data) {
        if (root.compareTo(data) > 0)
            return get(data, root.getLeftChild());
        else if (root.compareTo(data) < 0)
            return get(data, root.getRightChild());
        else
            return root;
    }

    @Nullable
    @Contract(pure = true)
    private HBNode<T> get(T data, HBNode<T> current) {
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
    private String graph(HBNode<T> current) {
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

    private HBNode<T> balance(HBNode<T> current) {
        if (current.getFactorBalance() > k)
        {
            if (current.getRightChild().getFactorBalance() == k)
                current = rotate_SL(current);
            else
                current = rotate_DR(current);
        }
        else if (current.getFactorBalance() < -k)
        {
            if (current.getLeftChild().getFactorBalance() == k)
                current = rotate_DL(current);
            else
                current = rotate_SR(current);
        }

        return current;
    }

    private void getFactorBalance(HBNode<T> current) {
        int hi = 0, hd = 0;

        if (current.getLeftChild() != null)
            hi = Math.max(current.getLeftChild().getLeftHeight(), current.getLeftChild().getRightHeight()) + 1;
        if (current.getRightChild() != null)
            hd = Math.max(current.getRightChild().getLeftHeight(), current.getRightChild().getRightHeight()) + 1;

        current.setLeftHeight(hi);
        current.setRightHeight(hd);
        current.setFactorBalance(hd - hi);
    }

    private HBNode<T> rotate_DR(HBNode<T> current) {
        current.setRightChild(rotate_SR(current.getRightChild()));
        getFactorBalance(current);
        return rotate_SL(current);
    }

    private HBNode<T> rotate_DL(HBNode<T> current) {
        current.setLeftChild(rotate_SL(current.getLeftChild()));
        getFactorBalance(current);
        return rotate_SR(current);
    }

    private HBNode<T> rotate_SR(HBNode<T> current) {
        HBNode<T> node = current.getLeftChild();
        current.setLeftChild(node.getRightChild());
        node.setRightChild(current);

        getFactorBalance(current);
        getFactorBalance(node);
        return node;
    }

    private HBNode<T> rotate_SL(HBNode<T> current) {
        HBNode<T> node = current.getRightChild();
        current.setRightChild(node.getLeftChild());
        node.setLeftChild(current);

        getFactorBalance(current);
        getFactorBalance(node);
        return node;
    }

    private void balanceOlder(HBNode<T> current) {

    }

    private void balanceMinor(HBNode<T> current) {

    }

    @Nullable
    @Contract(pure = true)
    private HBNode<T> getOlder(HBNode<T> current) {

        return null;
    }

    @Nullable
    @Contract(pure = true)
    private HBNode<T> getMinor(HBNode<T> current) {

        return null;
    }
}
