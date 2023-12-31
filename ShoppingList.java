package LabProgram1023;

public class ShoppingList {

	public void add(Item item) {

		// *** Student task #1 ***

		/*
		 * Requirements:
		 * 
		 * 1. if null item is not allowed: do nothing if null 2. if the list is full,
		 * double the array size-dynamic array allocation 3. No duplicated items-all
		 * items' names must be unique. If an item with the same name already exists in
		 * the list, simply add quantity to the existing item in the list 4. insert the
		 * item to the array to maintain sorted-items are sorted based on item names.
		 *** 
		 * Enter your code below ***
		 */
		if (item != null) {
			if (this.isFull()) {
				this.doubling();
			}
			if (this.indexOf(item) == -1) {
				this.list[this.numberOfItems++] = new Item(item.getName(), item.getQuantity(), item.getUnitPrice());

				for (int i = 0; i < this.size() - 1; i++) {
					for (int j = i + 1; j < this.size(); j++) {
						if (this.list[i].compareTo(this.list[j]) > 0) {
							Item temp = this.list[i];
							this.list[i] = this.list[j];
							this.list[j] = temp;
						}
					}
				}

			} else if (this.indexOf(item.getName()) != -1) {
				int temQuantity = this.list[this.indexOf(item.getName())].getQuantity();
				this.list[this.indexOf(item.getName())].setQuantity(temQuantity + item.getQuantity());
			}
		}

	}

	public void remove(Item item) {// remove all items with the same name.

		// *** Student task #2 ***

		/*
		 * Requirements:
		 * 
		 * 1. If item not found(item name), display the item does not exists in the list
		 * otherwise, remove the item from the list. 2. Hint: You do need to shift all
		 * items after removed one.
		 *** 
		 * Enter your code below ***
		 */
		if (this.indexOf(item) != -1) {
			this.list[this.indexOf(item)] = new Item("z", 0, 0);
			

			if (this.indexOf(item) == -1) {
				for (int i = 0; i < this.size() - 1; i++) {
					for (int j = i + 1; j < this.size(); j++) {
						if (this.list[i].compareTo(this.list[j]) > 0) {
							Item temp = this.list[i];
							this.list[i] = this.list[j];
							this.list[j] = temp;
						}
					}
				}
			}
		}
		this.numberOfItems--;
	}

	public void remove(String name) { // remove item by its name

		// *** Student task #3 ***

		/*
		 * Requirements:
		 * 
		 * 1. If item not found(item name), display the item does not exists in the list
		 * otherwise, remove the item from the list. 2. Hint: You do need to shift all
		 * items after removed one.
		 *** 
		 * Enter your code below ***
		 */

		if (this.indexOf(name) != -1) {
			this.list[this.indexOf(name)] = new Item("z", 0, 0);
			

			if (this.indexOf(name) == -1) {
				for (int i = 0; i < this.size() - 1; i++) {
					for (int j = i + 1; j < this.size(); j++) {
						if (this.list[i].compareTo(this.list[j]) > 0) {
							Item temp = this.list[i];
							this.list[i] = this.list[j];
							this.list[j] = temp;
						}
					}
				}
			}
		}
		this.numberOfItems--;
	}

	// *****************DONOT modify codes below this
	// line****************************
	private Item[] list;
	private int numberOfItems;

	public ShoppingList(int initialSize) {
		list = new Item[initialSize];
	}

	private void doubling() {
		// Double the list size but keep all items in the list.
		Item[] tmp = new Item[list.length * 2];
		for (int i = 0; i < list.length; i++) {
			tmp[i] = list[i];
		}
		list = tmp;
	}

	public int indexOf(Item item) {
		// return the index of the item that has the same item name in the list array,
		// return -1 if not found
		for (int i = 0; i < numberOfItems; i++) {
			if (list[i].compareTo(item) == 0)
				return i;
		}
		return -1; // not found
	}

	public int indexOf(String name) {
		// return the index of the item that has the same item name in the list array,
		// return -1 if not found
		name = name.toLowerCase();
		for (int i = 0; i < numberOfItems; i++) {
			if (list[i].getName().toLowerCase().compareTo(name) == 0)
				return i;
		}
		return -1; // not found
	}

	public boolean isFull() {
		return numberOfItems == list.length;
	}

	public boolean isEmpty() {
		return numberOfItems == 0;
	}

	public int size() {
		return numberOfItems;
	}

	public void printNames() {
		System.out.print("[");
		for (int i = 0; i < numberOfItems; i++) {
			System.out.print(list[i].getName());
			if (i < numberOfItems - 1)
				System.out.print(", ");
		}
		System.out.println("]");
	}

	public void print() {
		for (int i = 0; i < numberOfItems; i++) {
			System.out.println((i + 1) + ". " + list[i].toString());
		}
	}

	public void printItems() {
		for (int i = 0; i < numberOfItems; i++) {
			System.out.printf("%3s%-16s%3d %.2f\n", "" + (i + 1) + ". ", list[i].getName(), list[i].getQuantity(),
					list[i].getUnitPrice());
		}
	}

	public Item[] getList() {
		return list;
	}
}