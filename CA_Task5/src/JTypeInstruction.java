
public class JTypeInstruction extends Instruction {

	String op;
	String address;
	
	public JTypeInstruction() {
		super();
	}
	
	public JTypeInstruction(String k) {
		super(k);
		this.prepareInstruction(k);
	}
	
	public void prepareInstruction(String k) {
		op = "";
		address ="";
		int i = 0;
		for(i = 0 ; i<6 ; i++) {
			op += this.bits[i];
		}
		i = 0;
		for(int j = 6 ; j<32 ; j++) {
			address += bits[j];
			i++;
		}
	}
	
	
}
