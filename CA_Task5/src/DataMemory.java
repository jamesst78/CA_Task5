import java.util.Hashtable;

public class DataMemory {
	
		
		//int pc;
		Hashtable<String , String> memory ;
		int Maxsize;
		int currentSize;
		String inputAddress;
		String WriteData;
		boolean MemWrite;
		boolean MemRead;
		String ReadData;
		

		
		
		public DataMemory(int size) {
		//	this.pc = 0;
			this.MemWrite = false;
			this.MemRead = false;
			this.memory = new Hashtable<String, String>();
			this.Maxsize = size;
			this.currentSize = 0;
			System.out.println("Data memory created successfully of size " + this.Maxsize);
		}
			
			public void loadIntoDataMemory(String address ,int k) {
										
				String key = address;				
				if(currentSize < this.Maxsize) {
					
					this.memory.put(key, Integer.toBinaryString(k));
					System.out.println("Data added to the memory hash with value of " + Integer.toBinaryString(k) + " in address " + key);
					this.currentSize++;
				}
				else {
					System.out.println("Data Memory full , cant input more Data");
				}
				
				
			}
			
			public void retrieveDataFromAddress(String address) {
				String data = "";
				data = this.memory.get(address);
				System.out.println("retrieved data of value " + data );
				this.ReadData = data;
			}
			
			public void writeDataIntoAddress(String address , String data) {
				this.memory.put(address, data);
				this.WriteData = data;
				this.inputAddress = address;
				System.out.println("added into data memory data of value " + data + " into address" + address);
			}
			
		
			
		
}
