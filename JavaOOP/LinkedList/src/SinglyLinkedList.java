public class SinglyLinkedList {

	Node head;
	
	SinglyLinkedList () {
		
	}
	
	SinglyLinkedList add ( int newNodeValue ) {
		
		Node newNode = new Node ( newNodeValue );
		
		if ( this.head == null ) {
			
			this.head = newNode;
			
			return this;
			
		}
		
		Node runner = this.head;
		
		while ( runner.next != null ) {
			
			runner = runner.next;
			
		}
		
		runner.next = newNode;
		
		return this;
		
	}
	
	SinglyLinkedList removeValue ( int valueToRemove ) {
		
		Node runner = this.head;
		
		while ( runner != null ) {
			
			if ( runner.value == valueToRemove ) {
				
				runner = null;
				
			}
			
			runner = runner.next;
			
		}
		
		return this;
		
	}
	
	SinglyLinkedList remove () {
		
		Node runner = this.head;
		
		while ( runner.next.next != null ) {
			
			runner = runner.next;
			
		}
		
		runner.next = null;
			
		return this;
	}
	
	SinglyLinkedList printValues () {
		
		Node runner = this.head;
		
		while ( runner != null ) {
			
			System.out.println( runner.value );
			
			runner = runner.next;
			
		}
		
		return this;
		
	}
	
	Node find ( int valueToFind ) {
		
		Node runner = this.head;
		
		while ( runner != null ) {
			
			if ( runner.value == valueToFind ) {
				
				System.out.printf ( "\nThe system has found the node. \n%s\n%d\n\n", runner, runner.value );
				
				return runner;
				
			}
			
			runner = runner.next;
			
		}
		
		return null;
		
	}
	
	SinglyLinkedList removeAt ( int n ) {
		
		Node runner = this.head;
		
		int counter = 0;
		
		while ( counter < n ) {
			
			runner = runner.next;
			
			counter ++;
			
		}
		
		runner.next = null;
		
		return this;
		
	}
	
}