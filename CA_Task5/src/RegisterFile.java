

public class RegisterFile {
	
	
	Register [] registers;
	Register readRegister1;
	Register readRegister2;
	Register writeRegister;
	Register zeroRegister;
	boolean writeflag;
	String readData1;
	String readData2;
	String writeData;
	
	public RegisterFile() {
		this.registers = new Register[32];
	
		for(int i = 0 ; i<registers.length ; i++) {
			registers[i] = new Register();
			this.assignRegisterID(i);
			
		}
		this.zeroRegister = registers[31];
		this.writeflag = false;
		System.out.println("RegisterFile is created successfully of size 32 ");
	}
	
	public void assignRegisterID(int i) {
		
		
		String IdUnextended = Integer.toBinaryString(i);
		while(IdUnextended.length()<5) {
			IdUnextended = "0" + IdUnextended;
		}
		this.registers[i].RegID = IdUnextended;
		
		
	}
	
	public void clear() {
		this.readRegister1 = null;
		this.readRegister2 = null;
		this.writeRegister = null;
	}
	
	public static void main(String[] args) {
		
		RegisterFile f1 = new RegisterFile();
		Instruction in = new Instruction("01010101010101011111010101010111");
	//	RTypeInstruction rt = (RTypeInstruction)in;
		//System.out.println(rt.op);
		
		
	
		
	}
	
	
	
	

}
