import java.util.Hashtable;

public class InstructionMemory {
	
	int pc;
	Hashtable<String , Instruction> memory ;
	int Maxsize;
	int currentSize;
	int x4Counter;
	
	
	
	public InstructionMemory(int size) {
		this.pc = 0;
		this.memory = new Hashtable<String, Instruction>();
		this.Maxsize = size;
		this.currentSize = 0;
		this.x4Counter = 0;
		System.out.println("Instruction memory created successfully of size " + this.Maxsize);
	}
		
		public void loadIntoInstructionMemory(String k) {
			if(this.currentSize ==0) {
			this.x4Counter = 0;
			}
			else {
				this.x4Counter += 4;
			}
						
			String key = Integer.toBinaryString(this.x4Counter);
			
			
			if(currentSize < this.Maxsize) {
				
				this.memory.put(key,new Instruction(k));
				System.out.println("Intruction added to the memory hash");
				this.currentSize++;
			}
			else {
				System.out.println("Intruction Memory full , cant input more instructions");
			}
			
			
		}
		
		public String getInstructionType(Instruction s) throws Exception {
			
			String opcode = "";
			String funct = "";
			for(int i = 0 ; i<6 ; i++) {
				opcode += s.bits[i];
			}
			for(int j = 26 ; j<32 ; j++) {
				funct += s.bits[j];
			}
			
			switch(opcode) {
			case("000000") : if(funct.equals("100000"))
				return "add";
			else{
				if(funct.equals("100010"))
					return "sub";
			};
			case("001000") : return "addi";
		
			case("000100") : return "beq";
			case("100011") : return "lw";
			case("101011") : return "sw";
			}
			throw new Exception("Not a known instruction type");
			//return "not a known instruction";
			
		}
		
		public Instruction getNextInstruction() {
			System.out.println("Accessing next instruction with PC " + pc);
			String key = Integer.toBinaryString(pc);
			Instruction i = memory.get(key);
			//this.pc = pc +4;
		//	System.out.println("PC is incremented by 4 , and is now " + pc);
			return i;
		}
		
		public Instruction getNextInstruction(String Address) {
			int pc = Integer.parseInt(Address, 2);
			System.out.println("Accessing instruction with PC " + pc);
			String key = Integer.toBinaryString(pc);
			Instruction i = memory.get(key);
			//this.pc = pc +4;
		//	System.out.println("PC is incremented by 4 , and is now " + this.pc);
			return i;
		}
		
	}
	
	
	


