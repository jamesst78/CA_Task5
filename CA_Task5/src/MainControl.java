
public class MainControl {
	
	boolean RegDst;
	boolean RegWrite;
	boolean ALUSrc;
	boolean PCSrc;
	boolean MemRead;
	boolean MemWrite;
	boolean MemToReg;
	String type;
	
	
	public void evaluateSignals(String opcode) {
		switch(this.type) {
		case("R"):	RegDst=true;
					ALUSrc=false;
					MemToReg=false;
					RegWrite=true;
					MemRead=false;
					MemWrite=false;
					PCSrc=false;
			
		
		case("lw"):	RegDst=false;
		ALUSrc=true;
		MemToReg=true;
		RegWrite=true;
		MemRead=true;
		MemWrite=false;
		PCSrc=false;
		
		
		case("sw"):	RegDst=false;
		ALUSrc=true;
		MemToReg=false;
		RegWrite=true;
		MemRead=false;
		MemWrite=true;
		PCSrc=false;
		
		
		case("beq"): RegDst=false;
		ALUSrc=false;
		MemToReg=false;
		RegWrite=false;
		MemRead=false;
		MemWrite=false;
		PCSrc=true;
				

		}
	}
}
