
public class RTypeInstruction extends Instruction {

	
	String op;
	String rs;
	String rt;
	String rd;
	String zeros;
	String funct;
	
	
	public RTypeInstruction() {
		super();
	}
	
	public RTypeInstruction(String k) {
		super(k);
		this.prepareInstruction(k);
		
		
	}
	
		public void prepareInstruction(String k) {
			this.op = "";
			this.rs = "";
			this.rt = "";
			this.rd = "";
			this.zeros = "";
			this.funct = "";
					
			
			
			int i = 0;
			for( i = 0 ; i<6 ; i++) {
				op += this.bits[i];
			}
			
			for(int j = 6 ; j<11 ; j++) {
				rs += this.bits[j];
				
			}
			
			for(int z = 11 ; z<16 ; z++) {
				rt += this.bits [z];
				
			}
			
			for(int h = 16 ; h<21 ; h++) {
				rd += this.bits[h];
				
			}
			
	
			
			for(int p = 21 ; p<26 ; p++) {
				zeros += this.bits[i];
				
			}
			
			for(int y = 26 ; y<32 ; y++) {
				funct += this.bits[y];
				
			}
		}

		
		
		
	}

