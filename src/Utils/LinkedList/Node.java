package Utils.LinkedList;

//Node as its own public class in order to use sequential access
//in linked list
public class Node<G> {

    public Node<G> next = null;

    public G data;

    public G getData() {
        return data;
    }

    public void setData(G dataToEnter) {
        data = dataToEnter;
    }
}
