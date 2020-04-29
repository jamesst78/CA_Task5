import java.util.Scanner;

public class ALU {
	
	String operandA;
	String operandB;
	String opCode;
	String output;
	boolean Z;
	
	
	
	public ALU() {
		this.opCode = "";

	}
	
	public static void  ALUEvaluator(String op , int operand1 , int operand2) {
		
		ALU alu = new ALU();
		switch(op) {
		
		case("0000") : alu.ANDOp(operand1,operand2); break;
		case("0001") : alu.OROp(operand1, operand2); break;
		case("0010") : alu.addOp(operand1, operand2);break;
		case("0110") : alu.subOp(operand1, operand2);break;
		case("0111") : alu.sltOp(operand1, operand2);break;
		case("1100") : alu.NOR(operand1, operand2);break;
		
		}
		
	}
	public static String  ALUEvaluator(String op , String operand1 , String operand2) {
		
		ALU alu = new ALU();
		switch(op) {
		
		case("0000") : return alu.ANDOp(signExtend(operand1),signExtend(operand2));
		
		case("0001") : return alu.OROp(signExtend(operand1), signExtend(operand2));
		
		case("0010") : return alu.addOp(signExtend(operand1), signExtend(operand2));
		
		case("0110") : return alu.subOp(signExtend(operand1), signExtend(operand2));
		
		case("0111") : return alu.sltOp(signExtend(operand1), signExtend(operand2));
		
		case("1100") : return  alu.NOR(signExtend(operand1), signExtend(operand2));
		
		}
		System.out.println("Failed ALU Evaluator");
		return "ALU Evaluator Failed";
	}
	
	public int ANDOp(int operand1 , int operand2) {
		
		System.out.println("Operation Name : AND");
		System.out.println("1st operand : " + signExtend(Integer.toBinaryString(operand1)) + "/" +operand1);
		System.out.println("2nd operand : " + signExtend(Integer.toBinaryString(operand2)) + "/" +operand2);

		this.operandA = operand1 + "";
		this.operandB = operand2 + "";
		this.output = (operand1 & operand2) + "";
		if((operand1 & operand2) == 0) {
			this.Z = true;
		}
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(operand1 & operand2))   + "/" + (operand1&operand2));
		System.out.println("Z Flag : " + this.Z);

		return (operand1 & operand2);
		
		
	}
	public String ANDOp(String operand1 , String operand2) {

		int op1 = Integer.parseInt(operand1,2);
		int op2 = Integer.parseInt(operand2,2);
		
		System.out.println("Operation Name : AND");
		System.out.println("1st operand : " + signExtend((operand1)) + "/" +Integer.parseInt(operand1,2));
		System.out.println("1st operand : " + signExtend((operand2)) + "/" +Integer.parseInt(operand2,2));		
		int result = op1 & op2;
		if(result ==0) {
			this.Z = true;
		}		
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(result))   + "/" + result);
		System.out.println("Z Flag : " + this.Z);
		return(Integer.toBinaryString(result));

		
		
		
	}
	
	
	public int OROp(int operand1 , int operand2) {
		System.out.println("Operation Name : OR");
		System.out.println("1st operand : " + signExtend(Integer.toBinaryString(operand1)) + "/" +operand1);
		System.out.println("2nd operand : " + signExtend(Integer.toBinaryString(operand2)) + "/" +operand2);
		this.operandA = operand1 + "";
		this.operandB = operand2 + "";
		this.output = (operand1 | operand2) + "";
		if((operand1 | operand2) == 0) {
			this.Z = true;
		}
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(operand1 | operand2))   + "/" + (operand1|operand2));
		System.out.println("Z Flag : " + this.Z);
		return (operand1 | operand2);
	}
	public String OROp(String operand1 , String operand2) {
		
		int op1 = Integer.parseInt(operand1,2);
		int op2 = Integer.parseInt(operand2,2);
		
		System.out.println("Operation Name : OR");
		System.out.println("1st operand : " + signExtend((operand1)) + "/" +Integer.parseInt(operand1,2));
		System.out.println("1st operand : " + signExtend((operand2)) + "/" +Integer.parseInt(operand2,2));		
		int result = op1 | op2;
		if(result ==0) {
			this.Z = true;
		}		
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(result))   + "/" + result);
		System.out.println("Z Flag : " + this.Z);
		return(Integer.toBinaryString(result));
	}
	public int addOp( int operand1 , int operand2) {
		System.out.println("Operation Name : add");
		System.out.println("1st operand : " + signExtend(Integer.toBinaryString(operand1)) + "/" +operand1);
		System.out.println("2nd operand : " + signExtend(Integer.toBinaryString(operand2)) + "/" +operand2);
		this.operandA = operand1 + "";
		this.operandB = operand2 + "";
		this.output = (operand1 + operand2) + "";
		if((operand1 + operand2) == 0) {
			this.Z = true;
		}
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(operand1 + operand2))   + "/" + (operand1+operand2));
		System.out.println("Z Flag : " + this.Z);
		return (operand1 + operand2);
		
	}
	public String addOp( String operand1 , String operand2) {
		
		
		int op1 = Integer.parseInt(operand1,2);
		int op2 = Integer.parseInt(operand2,2);
		
		System.out.println("Operation Name : Add");
		System.out.println("1st operand : " + signExtend((operand1)) + "/" +Integer.parseInt(operand1,2));
		System.out.println("1st operand : " + signExtend((operand2)) + "/" +Integer.parseInt(operand2,2));		
		int result = op1 + op2;
		if(result ==0) {
			this.Z = true;
		}		
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(result))   + "/" + result);
		System.out.println("Z Flag : " + this.Z);
		return(Integer.toBinaryString(result));
		
	}
	
	public int subOp( int operand1 , int operand2) {
		System.out.println("Operation Name : Sub");
		System.out.println("1st operand : " + signExtend(Integer.toBinaryString(operand1)) + "/" +operand1);
		System.out.println("2nd operand : " + signExtend(Integer.toBinaryString(operand2)) + "/" +operand2);
		this.operandA = operand1 + "";
		this.operandB = operand2 + "";
		this.output = (operand1 - operand2) + "";
		if((operand1 - operand2) == 0) {
			this.Z = true;
		}
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(operand1 - operand2))   + "/" + (operand1-operand2));
		System.out.println("Z Flag : " + this.Z);
		return (operand1 - operand2);
		
	}
	public String subOp( String operand1 , String operand2) {
		int op1 = Integer.parseInt(operand1,2);
		int op2 = Integer.parseInt(operand2,2);
		
		System.out.println("Operation Name : Add");
		System.out.println("1st operand : " + signExtend((operand1)) + "/" +Integer.parseInt(operand1,2));
		System.out.println("1st operand : " + signExtend((operand2)) + "/" +Integer.parseInt(operand2,2));		
		int result = op1 - op2;
		if(result ==0) {
			this.Z = true;
		}		
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(result))   + "/" + result);
		System.out.println("Z Flag : " + this.Z);
		return(Integer.toBinaryString(result));
		
	}
	public int sltOp( int operand1 , int operand2) {
		int out = 0;
		System.out.println("Operation Name : Slt");
		System.out.println("1st operand : " + signExtend(Integer.toBinaryString(operand1)) + "/" +operand1);
		System.out.println("2nd operand : " + signExtend(Integer.toBinaryString(operand2)) + "/" +operand2);
		this.operandA = operand1 + "";
		this.operandB = operand2 + "";
		this.output = (operand1 - operand2) + "";
		if((operand1<operand2)) {
			out = 1;
		}
		if(operand1 == operand2 || out ==0) {
			this.Z = true;
		}
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(out))   + "/" + (out));
		System.out.println("Z Flag : " + this.Z);
		return (out);
		
	}
	public String sltOp( String operand1 , String operand2) {
		int op1 = Integer.parseInt(operand1,2);
		int op2 = Integer.parseInt(operand2,2);
		int result = 0;
		System.out.println("Operation Name : Slt");
		System.out.println("1st operand : " + signExtend((operand1)) + "/" +Integer.parseInt(operand1,2));
		System.out.println("1st operand : " + signExtend((operand2)) + "/" +Integer.parseInt(operand2,2));	
		if(op1 < op2) {
			result = 1;
		}
		
		if(result ==0) {
			this.Z = true;
		}		
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(result))   + "/" + result);
		System.out.println("Z Flag : " + this.Z);
		return(Integer.toBinaryString(result));
		
	}
	public int NOR( int operand1 , int operand2) {
		System.out.println("Operation Name : NOR");
		System.out.println("1st operand : " + signExtend(Integer.toBinaryString(operand1)) + "/" +operand1);
		System.out.println("2nd operand : " + signExtend(Integer.toBinaryString(operand2)) + "/" +operand2);
		this.operandA = operand1 + "";
		this.operandB = operand2 + "";
		this.output = ~(operand1 | operand2) + "";
		if(~(operand1 | operand2) == 0) {
			this.Z = true;
		}
		System.out.println( "Output: " + signExtend(Integer.toBinaryString( ~(operand1 | operand2)))   + "/" + ~(operand1 | operand2));
		System.out.println("Z Flag : " + this.Z);
		return ~(operand1 | operand2);
		
	}
	public String NOR( String operand1 , String operand2) {
		
		int op1 = Integer.parseInt(operand1,2);
		int op2 = Integer.parseInt(operand2,2);
		
		System.out.println("Operation Name : NOR");
		System.out.println("1st operand : " + signExtend((operand1)) + "/" +Integer.parseInt(operand1,2));
		System.out.println("1st operand : " + signExtend((operand2)) + "/" +Integer.parseInt(operand2,2));		
		int result = ~(op1 |op2);
		if(result ==0) {
			this.Z = true;
		}		
		System.out.println( "Output: " + signExtend(Integer.toBinaryString(result))   + "/" + result);
		System.out.println("Z Flag : " + this.Z);
		return(Integer.toBinaryString(result));
		
	}
	
	public static String signExtend(String operand) {
		while(operand.length() <32) {
			operand = "0" + operand;
		}
		return operand;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("To proceed using strings press s , to proceed using ints press i");
		String s = sc.nextLine();
		if(s.equals("s")) {
			System.out.println("Enter operation opcode");
			String op3 = sc.nextLine();
		System.out.println("enter op1 as a string");
		String op1 = sc.nextLine();
		System.out.println("Enter op2 as a string");
		String op2 = sc.nextLine();
		
		ALUEvaluator(op3, op1, op2);
		}
		if(s.equals("i")) {
			System.out.println("Enter operation opcode");
			String op3 = sc.nextLine();
		System.out.println("enter op1 as int");
		int op1 = sc.nextInt();
		System.out.println("Enter op2 as int");
		int op2 = sc.nextInt();
		
		ALUEvaluator(op3, op1, op2);
		

		}
		
		
	

		
		
	}
	
	

}
