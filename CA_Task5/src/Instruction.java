
public class Instruction {

		char [] bits;
		int length = 32;
		String type;
		
		
		public Instruction() {
			this.bits = new char [length];
			for(int i = 0 ; i<32 ; i++) {
				bits[i] = '0';
			}
			
		}
		
		public Instruction(String k) {
			this.bits = new char [length];
			if(k.length() > this.length) {
				System.out.println("Instruction size more than 32");
				
			}
			else {
			for(int i = 0 ; i<32; i++) {
				
				if(k.charAt(i)!= '0' && k.charAt(i)!='1' ) {
					System.out.println("Instruction contains an invalid bit");
					return;
				}
				else {
					this.bits[i] = k.charAt(i);
				}
			}
			}
		}
		
		public String getBits() {
			String bitss ="";
			for(int i = 0 ; i<this.bits.length ; i++) {
				bitss+= bits[i];
			}
			return bitss;
		}
}
