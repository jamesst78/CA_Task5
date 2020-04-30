
public class WriteBackClass {
	
	
	
	String ALUResult;		//TODO: From ExecutionClass
	RegisterFile RegFile;	 //TODO: from MainClass
//	ALUControl AluControl;	 //TODO: from MainClass
	MainControl Maincontrol; //TODO: from MainClass
	boolean MemToReg;			//if true , the value of register write data is the value in memory read data , false , value in WriteReg is from ALU result
	boolean RegDst;           //If true, then its R type , then we use WriteReg , if false , we use ReadReg2
	DataMemory DMemory;     //TODO: from MainClass
	
	
	
	
	public void WriteBack() {
		
		this.MemToReg = Maincontrol.MemToReg;
		this.RegDst = Maincontrol.RegDst;
		
		
		if(RegDst) {
			System.out.println("Using the Rd Register for Writeback");
			//we will use the rd register 
			if(MemToReg) {
				//we will write into WriteReg , the data in ReadData in the DataMemoryClass
				RegFile.writeRegister.theRegister = DMemory.ReadData;
				RegFile.writeData = DMemory.ReadData;
			}
			else {
				
				RegFile.writeRegister.theRegister = ALUResult;
				RegFile.writeData = RegFile.writeRegister.theRegister;
				System.out.println("Took the Write Value from ALU directly and not from data memory ");
				System.out.println("The written data is in reg " + RegFile.writeRegister.RegID + " and the data is " + RegFile.writeData);

			}
		}
		else //we will use readReg2
			{
			System.out.println("Using the rt Register for Writeback");
			if(MemToReg) {
				//we will write into ReadReg2 the data in ReadDAta from the DataMemoryClass
				RegFile.readRegister2.theRegister = DMemory.ReadData;
				RegFile.readData2 = DMemory.ReadData;
			}
//			else {
//				RegFile.readRegister2.theRegister = ALUResult;
//				RegFile.writeData = RegFile.readRegister2.theRegister;
//				System.out.println("Took the Write Value from ALU directly and not from data memory ");
//				System.out.println("The written data is in reg " + RegFile.readRegister2.RegID + " and the data is " + RegFile.writeData);
//			}
			
		}
	}

}


	