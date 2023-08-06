public class DoublyLinkedList {

	Node head;
	
	Node tail;
	
	DoublyLinkedList () {
		
		this.head = null;
		
		this.tail = null;
		
	}
	
	DoublyLinkedList push ( Node newNode ) {
		
		if ( this.head == null ) {
			
			this.head = newNode;
			
			this.tail = newNode;
			
			return this;
			
		}
		
		Node lastNode = this.tail;
		
		lastNode.next = newNode;
		
		newNode.previous = lastNode;
		
		this.tail = newNode;
		
		return this;
		
	}
	
	DoublyLinkedList printValuesForward () {
		
		Node runner = this.head;
		
		while ( runner != null ) {
			
			System.out.println( runner.value );
			
			runner = runner.next;
			
		}
		
		return this;
		
	}
	
	DoublyLinkedList printValuesBackward () {
		
		Node runner = this.tail;
		
		while ( runner != null ) {
			
			System.out.println( runner.value );
			
			runner = runner.previous;
			
		}
		
		return this;
		
	}
	
	int pop () {
		
		Node tailNode = this.tail;
		
		this.tail = tailNode.previous;
		
		this.tail.next = null;
		
		return tailNode.value;
		
	}
	
	boolean contains ( int valueToFind ) {
		
		Node runner = this.head;
		
		while ( runner != null ) {
			
			if ( runner.value == valueToFind ) {
				
				return true;
				
			}
			
			runner = runner.next;
			
		}
		
		return false;
		
	}
	
	int size () {
		
		if ( this.head == null ) {
			
			return 0;
			
		}
		
		Node runner = this.head;
		
		int count = 0;
		
		while ( runner != null ) {
			
			count ++;
			
			runner = runner.next;
			
		}
		
		return count;
		
	}
	
	DoublyLinkedList insertAt ( Node newNode, int index ) {
		
		Node runner = this.head;
		
		int count = 0;
		
		while ( count < index - 1) {
			
			count ++;
			
			runner = runner.next;
			
		}
		
		Node oldNext = runner.next;
		
		runner.next = newNode;
		
		newNode.previous = runner;
		
		newNode.next = oldNext;
		
		return this;
		
	}
	
	DoublyLinkedList removeAt ( int index ) {
		
		if ( index == 0 ) {
			
			this.head = this.head.next;
			
			this.head.previous = null;
			
			return this;
			
		}
		
		Node runner = this.head;
		
		int indexCount = 0;
		
		while ( indexCount < index ) {
			
			indexCount ++;
			
			runner = runner.next;
			
		}
		
		runner.previous.next = runner.next;
		
		runner = null;
		
		return this;
		
	}
	
	boolean isPalindrome () {
		
		if ( head == null ) {
			
			return true;
			
		}
		
		Node forwardRunner = this.head;
		
		Node backwardRunner = this.tail;
		
		while ( forwardRunner != backwardRunner ) {
			
			if ( forwardRunner.value != backwardRunner.value ) {
				
				return false;
				
			}
			
			forwardRunner = forwardRunner.next;
			
			backwardRunner = backwardRunner.previous;
			
		}
		
		return true;
		
	}
	
}
