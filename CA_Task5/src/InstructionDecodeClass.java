
public class InstructionDecodeClass {
	
	RegisterFile RegFile ;		 //TODO: from MainClass
	InstructionMemory IMemory;		 //TODO: from MainClass
	String ALUop;
	String currentInstructionType;
	String extendedIntermediate;
	ALUControl AluControl;			 //TODO: from MainClass
	MainControl Maincontrol;		 //TODO: from MainClass
	String ALU4bitoperation;
	String opcode;
	
	public void InstDecode(Instruction I) {
		
		//TODO: Output Aluop(2 bits) according to BEQ,SW/Lw,R--------Done
		//TODO: Sign extend the last 16 bits----------------Done
		//TODO: Decide if its Lw/sw,beq,r------------------Done
		String opcode = "";
		Register readReg1 = null;
		Register readReg2 = null;
		Register writeReg = null;
		String readreg1ID = "";
		String readreg2ID = "";

		String readData1 = "";
		String readData2 = "";
		for(int i = 0 ; i<6 ; i++) {
			opcode = opcode + I.getBits().charAt(i);
		}
		this.opcode = opcode;
		
		switch(opcode){
		case("000000") : I = new RTypeInstruction(I.getBits());
		this.ALUop = "10";
		this.currentInstructionType = "R";
		System.out.println("Instruction is an R type");
		RTypeInstruction Rti = (RTypeInstruction)I;
		readreg1ID = Rti.rs;
		readreg2ID = Rti.rt;
		String writeregID = Rti.rd;
		
		for(int i = 0 ; i<this.RegFile.registers.length; i++) {
			if(this.RegFile.registers[i].RegID.equals(readreg1ID)) {
				 readReg1 = this.RegFile.registers[i];
			}
			if(this.RegFile.registers[i].RegID.equals(readreg2ID)) {
				 readReg2 = this.RegFile.registers[i];
			}
			if(this.RegFile.registers[i].RegID.equals(writeregID)) {
				 writeReg = this.RegFile.registers[i];
			}
		
		}
		
		readData1 = readReg1.theRegister;
		readData2 = readReg2.theRegister;
		RegFile.readData1 = readData1;
		RegFile.readData2 = readData2;
		RegFile.readRegister1 = readReg1;
		RegFile.readRegister2 = readReg2;
		
		//ONLY FOR R Type
		RegFile.writeRegister = writeReg;
		
		
		System.out.println("ReadData1 is : " + RegFile.readData1 +" and in Register of ID " + readReg1.RegID);
		
		System.out.println("ReadData2 is : " + RegFile.readData2 +" and in Register of ID " + readReg2.RegID);

		Maincontrol.type = this.currentInstructionType;
		AluControl.ALUop = this.ALUop;
		AluControl.funct = Rti.funct;
		Maincontrol.evaluateSignals(opcode);
		this.ALU4bitoperation = AluControl.evaluateALU4Bit();
		
		break;
	
		default : I = new ITypeInstruction(I.getBits()); 
		System.out.println("Instruction is an I type");
		ITypeInstruction Iti = (ITypeInstruction)I;
		readreg1ID = Iti.rs;
		readreg2ID = Iti.rt;
		if(Iti.op.equals("100011")) { //if LW
			this.ALUop = "00";
			//TODO: set type to lw
			Iti.type = "lw";
			this.currentInstructionType = "lw";
		}
		if(Iti.op.equals("101011")) {
			this.ALUop = "00";
			Iti.type = "sw";
			this.currentInstructionType = "sw";
		}
		if(Iti.op.equals("000100")) {
			this.ALUop = "01";
			Iti.type = "beq";
			this.currentInstructionType = "beq";
		}
		
		for(int i = 0 ; i<this.RegFile.registers.length; i++) {
			if(this.RegFile.registers[i].RegID.equals(readreg1ID)) {
				 readReg1 = this.RegFile.registers[i];
			}
			if(this.RegFile.registers[i].RegID.equals(readreg2ID)) {
				 readReg2 = this.RegFile.registers[i];
			}
		}
		readData1 = readReg1.theRegister;	
		readData2 = readReg2.theRegister;
		RegFile.readData1 = readData1;
		RegFile.readData2 = readData2;
		RegFile.readRegister1 = readReg1;
		RegFile.readRegister2 = readReg2;
		
		
		System.out.println("ReadData1 is : " + RegFile.readData1 +" and in Register of ID " + readReg1.RegID);
		
		System.out.println("ReadData2 is : " + RegFile.readData2 +" and in Register of ID " + readReg2.RegID);
		
		this.extendedIntermediate=this.SignExtend(Iti);
		Maincontrol.type = this.currentInstructionType;
		AluControl.ALUop = this.ALUop;
		Maincontrol.evaluateSignals(opcode);
		this.ALU4bitoperation = AluControl.evaluateALU4Bit();

		
		break;
		}
		
		
	}
	
	public String SignExtend(Instruction I) {
		String bits32 = "";
		for (int j = 16; j < I.getBits().length(); j++) {
			bits32 += I.getBits().charAt(j);
		}
		char duplicate = bits32.charAt(0);

		while(bits32.length()<32) {
			bits32 = duplicate + bits32;
		}
		return bits32;
	}
	
	//TODO: don't forget to use this method
	public void ContUnit(String opcode) {
		this.Maincontrol.evaluateSignals(opcode);
	}
	
	
	
	

}
