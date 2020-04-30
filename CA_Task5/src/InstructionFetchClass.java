
public class InstructionFetchClass {
	
	InstructionMemory IMemory ;  //TODO: from MainClass

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public Instruction InstFetch(String address) {
		System.out.println("Retrieving Instruction of Address" + address);
		Instruction i =	this.IMemory.getNextInstruction(address);
		System.out.println("Instruction retrieved " + i.getBits());
		return i;
	}
	
	public Instruction InstFetchNext() {
		Instruction i =	this.IMemory.getNextInstruction();
		System.out.println("Instruction retrieved " + i.getBits());
		return (i);
	}
	
	public void ProgCount(boolean BEQ, String address) {
		//TODO: Refine this Method
		//TODO: Check if after decoding && Excuting if the instruction is BEQ successfully or not , if yes , target address = pc
		if(BEQ) {
		IMemory.pc = Integer.parseInt(address,2);
		System.out.println("Pc set to the new branching address");
		}
		else {
		IMemory.pc = IMemory.pc +4;
		System.out.println("Pc incremented by 4 normally and is now " + IMemory.pc);
		}
	}

}
