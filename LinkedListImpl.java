import java.util.Stack;

class NodeLinkedList {
	int data;	
	NodeLinkedList next;
	
	NodeLinkedList(int input) {
		data = input;
		next = null;
	}

}

public class LinkedListImpl {

	//Print the linked list -- Added for debugging purpose
	public void display(NodeLinkedList node) {
		while(node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	//Append element to the head of the linked list
	public NodeLinkedList insertNodeStart(NodeLinkedList node, int element) {
		NodeLinkedList output = node;
		NodeLinkedList temp = new NodeLinkedList(element);
		temp.next = output;
		output = temp;
		return output;
	}
	
	//Append element to the tail of the linkedlist
	public NodeLinkedList insertNodeEnd(NodeLinkedList node, int element) {
		NodeLinkedList output = node;
		NodeLinkedList temp = new NodeLinkedList(element);
		while(node.next != null) {
			node = node.next;
		}
		node.next = temp;
		return output; 
	}
	
	//Append element after the given the node
	public NodeLinkedList insertNodePos(NodeLinkedList node, int element, int position) {
		NodeLinkedList output = node;
		NodeLinkedList prev = null;
		NodeLinkedList temp = new NodeLinkedList(element);
		int count = 1;
		while(node != null) {
			prev = node;
			node = node.next;
			if(count  == position) {
				prev.next = temp;
				temp.next = node;
			}
			count++;
		}
		return output; 
	}

	public NodeLinkedList deleteNodePos(NodeLinkedList node, int element, int position) {
		NodeLinkedList output = node;
		NodeLinkedList prev = null;
		NodeLinkedList temp = new NodeLinkedList(element);
		int count = 1;
		while(node != null) {
			prev = node;
			node = node.next;
			if(count  == position) {
				prev.next = node.next;
			}
			count++;
		}
		return output; 
	}
	
	NodeLinkedList deleteLast(NodeLinkedList node) {
		NodeLinkedList output = node, prev = node;
		
		if(node == null || node.next == null)
			return null;
		
		while(node.next != null) {
			prev = node;
			node = node.next;
		}
		prev.next = null;
		return output;
	}
	
	//Remove element from the given linked list
	NodeLinkedList delete(NodeLinkedList node, int value)
	{
		NodeLinkedList head = node, prev;
		while(node.data > value && node.next != null) {
			node = node.next;
			head = node;
		}
		
		if(node.data > value && node.next == null) {
			return null;
		}
		
		prev = node;
		while(node != null) {
			if(node.data > value) {
				if(node.next != null) {
					prev.next = node.next;
				} else { 
					prev.next = null;
				}
			} 
			prev = node;
			node = node.next;
		}
		return head;
	}
	
	public static void main(String[] args) {
		NodeLinkedList node1 = new NodeLinkedList(110);
		NodeLinkedList node2 = new NodeLinkedList(13);
		NodeLinkedList node3 = new NodeLinkedList(16);
		NodeLinkedList node4 = new NodeLinkedList(7);
		NodeLinkedList node5 = new NodeLinkedList(19);
		NodeLinkedList node6 = new NodeLinkedList(1);
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;

		LinkedListImpl linkedList = new LinkedListImpl();
		linkedList.display(node1);
		
		
		NodeLinkedList output = linkedList.insertNodeStart(node1, 100);
		System.out.println("*********After insertion Start*********");
		linkedList.display(output);
		
		NodeLinkedList finalOutput = linkedList.insertNodeEnd(node1, 20);
		System.out.println("*********After insertion End***********");
		linkedList.display(finalOutput);

		NodeLinkedList postInsertion = linkedList.insertNodePos(node1, 100, 3);
		System.out.println("*********After insertion at position***********");
		linkedList.display(postInsertion);

		NodeLinkedList postDeletionTail = linkedList.deleteLast(node1);
		System.out.println("*********After deletion of tail ***********");
		linkedList.display(postDeletionTail);	
		
		NodeLinkedList postDeletion = linkedList.deleteNodePos(node1, 100, 3);
		System.out.println("*********After deletion at position***********");
		linkedList.display(postDeletion);

		NodeLinkedList postDeletionGrt = linkedList.delete(node1, 9);
		System.out.println("*********After deletion of nodes greater than 9 ***********");
		linkedList.display(postDeletionGrt);	
		

				
	}
}
