package s18.Interfaces.model.services;

import java.util.concurrent.TimeUnit;

import common.myUtils.MyUtils;
import s18.Interfaces.model.entities.CarRental;
import s18.Interfaces.model.entities.Invoice;

public class RentalService {
	
	// atributos
	private Double pricePerHour;
	private Double pricePerDay;
	private TaxService taxService;
	
	// construtores
	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.taxService = taxService;
	}
	
	// metodos
	public void processInvoice(CarRental carRental) {
		double diffHours = Math.ceil(MyUtils.dateDiff(carRental.getStart(), carRental.getFinish(), TimeUnit.MINUTES) / 60.0);
		double basicPayment = diffHours <= 12 ? diffHours * pricePerHour : pricePerDay * Math.ceil(diffHours / 24.0);
		carRental.setInvoice(new Invoice(basicPayment, taxService.tax(basicPayment)));		
	}
	
}
