package s18.Interfaces.model.devices;

public class MyComboDevice extends Device implements InterfaceScanner, InterfacePrinter {

	// construtores
	public MyComboDevice(String serialNumber) {
		super(serialNumber);
		// TODO Auto-generated constructor stub
	}

	// metodos
	@Override
	public void print(String doc) {
		System.out.println("Combo printing: " + doc);
	}

	@Override
	public String scan() {
		return "Combo scanned content";
	}

	@Override
	public void processDoc(String doc) {
		System.out.println("Combo processing: " + doc);
	}

}
