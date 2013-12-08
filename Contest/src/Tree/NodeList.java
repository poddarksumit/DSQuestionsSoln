/**
 * 
 */
package Tree;

/**
 * This class is used to
 * 
 * @author Sumit 07-Mar-2013
 * 
 */
public class NodeList {

	int data;
	NodeList next;
	boolean inVisted;
	NodeList prev;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public NodeList getNext() {
		return next;
	}

	public void setNext(NodeList next) {
		this.next = next;
	}

	public NodeList(int data, NodeList next, boolean inVisted) {
		super();
		this.data = data;
		this.next = next;
		this.inVisted = inVisted;
	}

	public NodeList(int data) {
		super();
		this.data = data;
	}

	public NodeList(int data, NodeList next) {
		super();
		this.data = data;
		this.next = next;
	}

	public boolean isInVisted() {
		return inVisted;
	}

	public void setInVisted(boolean inVisted) {
		this.inVisted = inVisted;
	}

	public NodeList getPrev() {
		return prev;
	}

	public void setPrev(NodeList prev) {
		this.prev = prev;
	}

	private NodeList(int data, NodeList next, NodeList prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

}
