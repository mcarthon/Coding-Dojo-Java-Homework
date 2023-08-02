public class DeviceTest {

	public static void main ( String[] args ) {
		
		Phone iPhone = new Phone ( "iPhone 12 Pro Max" );
		
		iPhone.makePhoneCall().makePhoneCall().makePhoneCall().playGame( "Sam's Game" ).playGame( "Mexican Train" ).chargePhone();
		
	}
	
}