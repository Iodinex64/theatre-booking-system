package Utils.LinkedList;
//G is a generic reference to our ADT
//With great help from lecturer notes: https://moodle.wit.ie/pluginfile.php/4796863/mod_resource/content/0/Lists%20and%20List%20Processing.pdf
//Additional help with search function from (Pratik Agarwal): https://www.geeksforgeeks.org/search-an-element-in-a-linked-list-iterative-and-recursive/
//Additional help from https://www.geeksforgeeks.org/write-a-function-to-get-nth-node-in-a-linked-list/

public class LinkedList<G> {

    public Node<G> head = null;

    //Creates a new node, populates it with an ADT, and adds
    //it to the head of the list
    public void AddNode(G dataToAdd) {
        Node<G> myNode = new Node<>();
        myNode.setData(dataToAdd);
        myNode.next = head;
        head = myNode;
    }

    //Increments a value for every step that a node does not
    //contain the searched for object, thus giving us
    //the node index which can be used with other functions
    //in here.
    public int GetIndex(G object) {
        Node temp = head;
        int index = 0;
        //while the current node's data isn't what we want
        while (temp.data != object) {
            index++;
            temp = temp.next;
        }
        return index;
        }

    //Iterates through list until selected index is reached
    //Then finds previous node of node to be deleted.
    //if this position is more than the total number of nodes
    //we do nothing. else we delete the next node "next" and unlink
    //it from the list.
    public void DeleteNode(int index) {
            Node temp = head;
            Node prev = null;
            //if we want to delete the head (also dont run loop)
            if (index == 0) {
                head = head.next;
                return;
            }
            //looping through nodes until we reach our index
            int i = 0;
            while (i < index && temp != null) {
                //assign previous to temps last position and temp to
                //temp.next to cover current and previous nodes
                prev = temp;
                temp = temp.next;
                i++;
            }
            //when we reach our index target (when i is not less than index)
            if (temp != null) {
                //deleting target
                prev.next = temp.next;
            }
    }

    //Object search version of our index based delete method
    public void DeleteNode(G searchData) {
        Node temp = head;
        Node prev = null;
        //if we want to delete the head (also dont run loop)
        if (searchData == head.data) {
            head = head.next;
            return;
        }
        //looping through nodes until we reach our target
        while (temp.data != searchData) {
            prev = temp;
            temp = temp.next;
        }
        //when we reach our target (when temp data equals search data)
        prev.next = temp.next;
    }

    //Simply loops through the linked list until it finds a null node
    //then returns an integer which increments each "step" thus counting
    //the number of nodes in the list.
    public int size() {
        Node temp = head;
        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;
    }


    //Walks through linked list until inputted index matches amount
    //of nodes hopped, then returns the data in it as an object.
    //NOT SUITABLE FOR LOOPING WITH; USE SEQUENTIAL ACCESS INSTEAD
    //eg. for (node i = head; i != null, i = i.next), Obj j = (Obj)i.data etc...
    //as it is far more performant than looping this with an index integer
    public G GetNodeAtPos(int index) {
        Node<G> temp = head;
        int nodePos = 0;
        while (temp != null) {
            if (nodePos == index) {
                return temp.data;
            }
            nodePos++;
            temp = temp.next;
        }
        return null;
    }


    //Simply clears the list.
    public void Reset() {
        head = null;
    }
}
