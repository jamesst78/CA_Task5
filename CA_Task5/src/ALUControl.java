
public class ALUControl {

	String funct;
	String ALUop;
	
	
	public String evaluateALU4Bit() {
		String bit4 = "";
		if(this.ALUop.equals("00")) {
			bit4 = "0010";
			
		}
		else if(this.ALUop.equals("01")) {
			bit4 = "0110";
		}
		else
			switch(funct) {
			case("100000") : bit4 = "0010";break;
			case("100010") : bit4 = "0110";break;
			case("100100") : bit4 = "0000";break;
			case("100101") : bit4 = "0001";break;
			case("101010") : bit4 = "0111";break;
			}
		
		return bit4;
	}
}
