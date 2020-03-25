package s18.Interfaces.model.devices;

public class MyScanner extends Device {

	// construtores
	public MyScanner(String serialNumber) {
		super(serialNumber);
		// TODO Auto-generated constructor stub
	}

	// metodos
	@Override
	public void processDoc(String doc) {
		// TODO Auto-generated method stub
		System.out.println("Scanning process: " + doc);
	}

	public String scan() {
		return "Scanned content";
	}

}
