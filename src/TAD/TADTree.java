package TAD;

import org.jetbrains.annotations.NotNull;
import structure.DataStructure;

public class TADTree extends DataStructure {
    private int id;

    public TADTree() {
    }

    public TADTree(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNodeName() {
        return String.valueOf(id);
    }

    @Override
    public String toString() {
        return String.format("%d",
                id);
    }

    @Override
    public String nodeName() {
        return String.format("node%d",
                id);
    }

    @Override
    public String createNode() {
        return String.format("%s [label = \"<izq> | %s | <der>\"]",
                nodeName(), toString());
    }

    @Override
    public int compareTo(@NotNull Object o) {
        TADTree value = (TADTree) o;
        return Integer.compare(id, value.getId());
    }
}
