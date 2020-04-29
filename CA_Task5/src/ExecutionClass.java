
public class ExecutionClass {
	InstructionFetchClass IFC;  //TODO: from MainClass
	String ALUop;			 //TODO: from InstructionDecodeClass
	RegisterFile RegFile;	 //TODO: from MainClass
	ALU Alu;				 //TODO: from MainClass
	ALUControl AluControl;	 //TODO: from MainClass
	MainControl Maincontrol; //TODO: from MainClass
	String ALU4bitoperation; //TODO: from InstructionDecodeClass
	boolean ALUSrc;
	String ALUResult;
	String extendedIntermediate; //TODO: from InstructionDecodeClass
	String currentInstructionType; //TODO: from InstructionDecodeClass
	String BranchAddressResult; 
	
	
	
	public void Execute() {
		
		//TODO: Make sure you update the PC to the branchaddress if needed , use ProgCount method here
		this.ALUSrc = Maincontrol.ALUSrc;
		
		if(ALUSrc) {
			ALUResult = Alu.ALUEvaluator(ALU4bitoperation, RegFile.readData1,extendedIntermediate );
			if(currentInstructionType.equals("beq")) {
				if(Alu.Z) {
					BranchAddressResult = ALUResult;
				System.out.println("Should branch successfully into Address " + BranchAddressResult);
				IFC.ProgCount(true, BranchAddressResult);
				}
				else {
					System.out.println("Branching was unsuccsesfull");
					IFC.ProgCount(false, BranchAddressResult);
				}
			}
		}
		else {
			ALUResult = Alu.ALUEvaluator(ALU4bitoperation, RegFile.readData1, RegFile.readData2);
			IFC.ProgCount(false, "");
		}
	}
	

}
