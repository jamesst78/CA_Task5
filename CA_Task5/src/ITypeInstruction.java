
public class ITypeInstruction extends Instruction {

	String op;
	String rs;
	String rt;
	String immediate;
	
	
	
		public ITypeInstruction() {
			super();
		}
		
		public ITypeInstruction(String k) {
			super(k);
			this.prepareInstruction(k);
			
		}
		
	
		
		public void prepareInstruction(String k) {
			this.op = "";
			this.rs = "";
			this.rt = "";
			this.immediate = "";
			
			
			int i = 0;
			for( i = 0 ; i<6 ; i++) {
				op+= this.bits[i];
			}
			i = 0;
			for(int j = 6 ; j<11 ; j++) {
				rs+= this.bits[j];
				i++;
			}
			i = 0 ;
			for(int z = 11 ; z<16 ; z++) {
				rt += this.bits [z];
				i++;
			}
			i = 0;
			for(int h = 16 ; h<32 ; h++) {
				immediate += this.bits[h];
				i++;
			}
		}


		public void lw(String k) {
			this.prepareInstruction(k);
			
		}
}
