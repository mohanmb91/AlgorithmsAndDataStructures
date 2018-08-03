

class Item {
int value;
Item next;

public Item(int value, Item next){
	this.value = value;
	this.next = next;
}
}

public class microsoft {
	private Item head;
	public microsoft() {
		head = null;
	}
	public Item pop() throws Exception {
		if (head == null) {
			throw new Exception();
		}
		Item temp = head;
		head = head.next;
		return temp;
	}
	public void push(int value) {
		Item top = head;
		head = new Item(value, top);
	}
	// assuming all other methods are implemented I have'nt done the implementation
}
