package s18.Interfaces.model.devices;

public abstract class Device {

	// atributos
	private String serialNumber;

	// construtores
	public Device() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Device(String serialNumber) {
		super();
		this.serialNumber = serialNumber;
	}

	// getters e setters
	public String getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

	// metodos
	public abstract void processDoc(String doc);

}
