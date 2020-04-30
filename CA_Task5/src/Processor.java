
public class Processor {

	
	ALU Alu ;
	ALUControl AluCont  ;
	DataMemory DataMem ;
	InstructionMemory IMem ;
	MainControl MainCont ;
	RegisterFile RegFile ;
	
		InstructionFetchClass IFC ;
		InstructionDecodeClass IDC ;
		ExecutionClass EC ;
		MemoryAccessClass MAC ;
		WriteBackClass WBC ;
	
	public Processor() {
			 Alu = new ALU();
		 AluCont = new ALUControl();
		 DataMem = new DataMemory(64);
		 IMem = new InstructionMemory(64);
		 MainCont = new MainControl();
		 RegFile = new RegisterFile();
		 
		  IFC = new InstructionFetchClass();
			 IDC = new InstructionDecodeClass();
			 EC = new ExecutionClass();
			 MAC = new MemoryAccessClass();
			 WBC = new WriteBackClass();
		
		
		//Main classes initializing
	
		
		
		
		//Wiring the non sequential variables;
		
		//IFC
		IFC.IMemory = IMem;
		//IDC
		IDC.RegFile = RegFile;
		IDC.IMemory = IMem;
		IDC.Maincontrol = MainCont;
		IDC.AluControl = AluCont;
		//EC
		EC.IFC = IFC;
		EC.RegFile = RegFile;
		EC.Alu = Alu;
		EC.AluControl = AluCont;
		EC.Maincontrol = MainCont;
		//MAC
		MAC.DMemory = DataMem;
		MAC.AluControl = AluCont;
		MAC.Maincontrol = MainCont;
		MAC.RegFile = RegFile;
		//WBC
		WBC.RegFile = RegFile;
		WBC.DMemory = DataMem;
		WBC.Maincontrol = MainCont;
	}
	public static void main(String[] args) {
		//Main components initializing
	
		Processor p = new Processor();
		
		//TODO: Please unnote the tests individually , or run them at simultaneously
	
		
	 //p.rtest();
	 //p.loadWordTest();														
	 //p.storeWordTest();													
	 //p.beqTest();	
	 
	 //Fully functional
		//PLEASE NOTE : THE ZERO REGISTER IN REGISTER NUMBER 32 ON MY IMPLEMENTATION
	 
		
		
		
		
	}
	
	public void storeWordTest() {
	
		
		IMem.loadIntoInstructionMemory("10101101010010010000000000001100");
		RegFile.registers[9].theRegister = Integer.toBinaryString(10593);
		RegFile.registers[10].theRegister = Integer.toBinaryString(2);
		
		
		//start sequential execution and sequential wiring
		Instruction I = IFC.InstFetchNext();
		IDC.InstDecode(I);
		//NOTE : CONTUNIT IS USED IMPLICITLY IN InstructionDecodeClass;
		EC.ALUop = IDC.ALUop;
		EC.ALU4bitoperation = IDC.ALU4bitoperation;
		EC.extendedIntermediate = IDC.extendedIntermediate;
		EC.currentInstructionType = IDC.currentInstructionType;
		EC.RegFile = IDC.RegFile;
		
		EC.Execute();
		
		MAC.extendedIntermediate = IDC.extendedIntermediate;
		MAC.ALUResult = EC.ALUResult;
		MAC.RegFile = IDC.RegFile;
		MAC.MemAccess();
		
		WBC.ALUResult = EC.ALUResult;
		WBC.WriteBack();
		
		//System.out.println("Value of affected register " + RegFile.registers[7].theRegister);
		System.out.println("Value of address in datamemory " + DataMem.memory.get("1110"));
	}
	
	public void loadWordTest() {
		
		
		
		DataMem.loadIntoDataMemory("1010", 10);
		IMem.loadIntoInstructionMemory("10001101000001110000000000001000");
		RegFile.registers[7].theRegister = Integer.toBinaryString(10593);
		RegFile.registers[8].theRegister = Integer.toBinaryString(2);
		
		
		//start sequential execution and sequential wiring
		Instruction I = IFC.InstFetchNext();
		IDC.InstDecode(I);
		//NOTE : CONTUNIT IS USED IMPLICITLY IN InstructionDecodeClass;
		EC.ALUop = IDC.ALUop;
		EC.ALU4bitoperation = IDC.ALU4bitoperation;
		EC.extendedIntermediate = IDC.extendedIntermediate;
		EC.currentInstructionType = IDC.currentInstructionType;
		EC.RegFile = IDC.RegFile;
		
		EC.Execute();
		
		MAC.extendedIntermediate = IDC.extendedIntermediate;
		MAC.ALUResult = EC.ALUResult;
		MAC.RegFile = IDC.RegFile;
		MAC.MemAccess();
		
		WBC.ALUResult = EC.ALUResult;
		WBC.WriteBack();
		
		System.out.println("Value of affected register " + RegFile.registers[7].theRegister);
	}
	
	public void beqTest() {
		//PLEASE NOTE : THE ZERO REGISTER IN REGISTER NUMBER 32 ON MY IMPLEMENTATION
		IMem.loadIntoInstructionMemory("00010001000111110000000001010111");
		RegFile.registers[0].theRegister = Integer.toBinaryString(10593);
		RegFile.registers[8].theRegister = Integer.toBinaryString(0);
		
		
		//start sequential execution and sequential wiring
		Instruction I = IFC.InstFetchNext();;
		IDC.InstDecode(I);
		//NOTE : CONTUNIT IS USED IMPLICITLY IN InstructionDecodeClass;
		EC.ALUop = IDC.ALUop;
		EC.ALU4bitoperation = IDC.ALU4bitoperation;
		EC.extendedIntermediate = IDC.extendedIntermediate;
		EC.currentInstructionType = IDC.currentInstructionType;
		EC.RegFile = IDC.RegFile;
		
		EC.Execute();
		
		MAC.extendedIntermediate = IDC.extendedIntermediate;
		MAC.ALUResult = EC.ALUResult;
		MAC.RegFile = IDC.RegFile;
		MAC.MemAccess();
		
		WBC.ALUResult = EC.ALUResult;
		WBC.WriteBack();
		
		//System.out.println("Value of affected register " + RegFile.registers[7].theRegister);
	}
	
	
	public void rtest() {
		IMem.loadIntoInstructionMemory("00000000010000110000100000100000");
		RegFile.registers[2].theRegister = Integer.toBinaryString(9);
		RegFile.registers[3].theRegister = Integer.toBinaryString(6);
		
		
		//start sequential execution and sequential wiring
		Instruction I = IFC.InstFetchNext();
		IDC.InstDecode(I);
		//NOTE : CONTUNIT IS USED IMPLICITLY IN InstructionDecodeClass;
		EC.ALUop = IDC.ALUop;
		EC.ALU4bitoperation = IDC.ALU4bitoperation;
		EC.extendedIntermediate = IDC.extendedIntermediate;
		EC.currentInstructionType = IDC.currentInstructionType;
		EC.RegFile = IDC.RegFile;
		
		EC.Execute();
		
		MAC.extendedIntermediate = IDC.extendedIntermediate;
		MAC.ALUResult = EC.ALUResult;
		MAC.RegFile = IDC.RegFile;
		MAC.MemAccess();
		
		WBC.ALUResult = EC.ALUResult;
		WBC.WriteBack();
		
		System.out.println("Value of affected register " + RegFile.registers[1].theRegister);
	}
	
}
