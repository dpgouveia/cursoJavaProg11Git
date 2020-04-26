package s18.Interfaces.model.devices;

public class MyPrinter extends Device {

	// construtores
	public MyPrinter(String serialNumber) {
		super(serialNumber);
		// TODO Auto-generated constructor stub
	}

	// metodos
	@Override
	public void processDoc(String doc) {
		// TODO Auto-generated method stub
		System.out.println("Printing process: " + doc);
	}

	public void print(String doc) {
		System.out.println("Printing: " + doc);
	}

}
