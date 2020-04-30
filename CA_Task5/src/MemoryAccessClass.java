
public class MemoryAccessClass {

	DataMemory DMemory;		 //TODO: from MainClass
	ALUControl AluControl;	 //TODO: from MainClass
	MainControl Maincontrol; //TODO: from MainClass
	RegisterFile RegFile;	 //TODO: from MainClass
	String extendedIntermediate; //TODO: from InstructionDecodeClass
	String ALUResult;            //TODO: from ExecutionClass
	
	
	
	
	
	
	
	public void MemAccess() {
		this.DMemory.MemWrite =Maincontrol.MemWrite;
		this.DMemory.MemRead = Maincontrol.MemRead;
		
		if(DMemory.MemRead) {
			DMemory.retrieveDataFromAddress(ALUResult);
			String data = DMemory.ReadData;
			
		}
		if(DMemory.MemWrite) {
			DMemory.writeDataIntoAddress(ALUResult, RegFile.readData2);
		}
	}
}
