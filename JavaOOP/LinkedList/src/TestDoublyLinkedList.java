public class TestDoublyLinkedList {

	public static void main ( String[] args ) {
		
		DoublyLinkedList doublyLinkedList = new DoublyLinkedList();
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(50);
        Node n4 = new Node(60);
        Node n5 = new Node(80);
        Node n6 = new Node(100);
        
        doublyLinkedList.push(n1);
        doublyLinkedList.push(n2);
        doublyLinkedList.push(n3);
        doublyLinkedList.push(n4);
        doublyLinkedList.push(n5);
        doublyLinkedList.push(n6);
        
        doublyLinkedList.printValuesForward();
        
        doublyLinkedList.printValuesBackward();
        
        System.out.println( doublyLinkedList.size() );
        
        System.out.println( doublyLinkedList.pop() );
        
        System.out.println( doublyLinkedList.size() );
        
        Node newNode = new Node( 55 );
        
        System.out.println( doublyLinkedList.insertAt( newNode, 3 ) );
        
        doublyLinkedList.removeAt( 0 );
        
        doublyLinkedList.printValuesForward();
        
        DoublyLinkedList emptyLinkedList = new DoublyLinkedList();
        
        DoublyLinkedList singletonLinkedList = new DoublyLinkedList();
        
        DoublyLinkedList shortPalindromeLinkedList = new DoublyLinkedList();
        
        Node node0 = new Node ( 0 );
        
        Node node1 = new Node ( 1 );
        
        Node node2 = new Node ( 0 );
        
        singletonLinkedList.push( node0 );
        
        shortPalindromeLinkedList.push( node0 ).push( node1 ).push( node2 );
        
        System.out.println( doublyLinkedList.isPalindrome() );
        
        System.out.println( emptyLinkedList.isPalindrome() );
        
        System.out.println( singletonLinkedList.isPalindrome() );
        
        System.out.println( shortPalindromeLinkedList.isPalindrome() );
        
        System.out.println( doublyLinkedList.contains( 51 ) );
		
	}
	
}