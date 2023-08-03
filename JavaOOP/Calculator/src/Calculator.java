public class Calculator {
	
	private double operandOne, operandTwo, result = 0;
	
	private String operation;

	private Calculator setOperandOne () {
		
		this.operandOne = Double.parseDouble( System.console().readLine( "\nEnter the first operand: \n" ) );
		
		return this;
		
	}
	
	private Calculator setOperandTwo () {
		
		this.operandTwo = Double.parseDouble( System.console().readLine( "\nEnter the second operand: \n" ) );
		
		return this;
		
	}
	
	private Calculator setOperation () {
		
		this.operation = System.console().readLine( "\nPlease enter the operation: \n" );
		
		return this;
		
	}
	
	private double getOperandOne () {
		
		return this.operandOne;
		
	}
	
	private double getOperandTwo () {
		
		return this.operandTwo;
		
	}
	
	private String getOperation () {
		
		return this.operation;
		
	}
	
	private double getResult () {
		
		return this.result;
		
	}
	
	private Calculator performOperation () {
		
		switch ( this.operation ) {
		
		case "+":
			
			this.result =  this.operandOne + this.operandTwo;
			
			this.operandOne = this.result;
			
			return this;
			
		case "-":
			
			this.result = this.operandOne - this.operandTwo;
			
			this.operandOne = this.result;
			
			return this;
			
		case "*":
			
			this.result = this.operandOne * this.operandTwo;
			
			this.operandOne = this.result;
			
			return this;
			
		case "/":
			
			if ( this.getOperandTwo() != 0 ) {
				
				this.result = this.operandOne / this.operandTwo;
				
				this.operandOne = this.result;
				
			}
			
			return this;
			
			
		default:
			
			return this;
		
		}
		
	}
	
	Calculator performCalculation () {
		
		this.setOperandOne();
		
		this.setOperation();
		
		this.setOperandTwo();
		
		this.performOperation();
		
		System.out.printf ( "\n%.1f %s %.1f = %.1f\n\n", this.getOperandOne(), this.getOperation(), this.getOperandTwo(), this.getResult() );
		
		return this;
		
	}
	
}