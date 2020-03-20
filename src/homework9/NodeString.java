package homework9;

public class NodeString {

    private String string;
    private NodeString previous;
    private NodeString next;

    public NodeString() {}

    public NodeString(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public NodeString getPrevious() {
        return previous;
    }

    public void setPrevious(NodeString previous) {
        this.previous = previous;
    }

    public NodeString getNext() {
        return next;
    }

    public void setNext(NodeString next) {
        this.next = next;
    }
}
