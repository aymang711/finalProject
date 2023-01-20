package common;

public class BL {
	
	private String grossWeightWithPallets;
	private String grossWeight;
	private String netGrossWeight;
	private String numberOfPallets;
	private String numberOfBoxesWithOutPallets;
	private String TotalPackges;
	private String InvoiceNum;
	private String Container;
	
	public BL() {}
	public BL(String grossWeightWithPallets, String grossWeight, String netGrossWeight, String numberOfPallets,
			String numberOfBoxesWithOutPallets, String totalPackges, String invoiceNum, String container) {
		super();
		this.grossWeightWithPallets = grossWeightWithPallets;
		this.grossWeight = grossWeight;
		this.netGrossWeight = netGrossWeight;
		this.numberOfPallets = numberOfPallets;
		this.numberOfBoxesWithOutPallets = numberOfBoxesWithOutPallets;
		TotalPackges = totalPackges;
		InvoiceNum = invoiceNum;
		Container = container;
	}
	public String getGrossWeightWithPallets() {
		return grossWeightWithPallets;
	}
	public void setGrossWeightWithPallets(String grossWeightWithPallets) {
		this.grossWeightWithPallets = grossWeightWithPallets;
	}
	public String getGrossWeight() {
		return grossWeight;
	}
	public void setGrossWeight(String grossWeight) {
		this.grossWeight = grossWeight;
	}
	public String getNetGrossWeight() {
		return netGrossWeight;
	}
	public void setNetGrossWeight(String netGrossWeight) {
		this.netGrossWeight = netGrossWeight;
	}
	public String getNumberOfPallets() {
		return numberOfPallets;
	}
	public void setNumberOfPallets(String numberOfPallets) {
		this.numberOfPallets = numberOfPallets;
	}
	public String getNumberOfBoxesWithOutPallets() {
		return numberOfBoxesWithOutPallets;
	}
	public void setNumberOfBoxesWithOutPallets(String numberOfBoxesWithOutPallets) {
		this.numberOfBoxesWithOutPallets = numberOfBoxesWithOutPallets;
	}
	public String getTotalPackges() {
		return TotalPackges;
	}
	public void setTotalPackges(String totalPackges) {
		TotalPackges = totalPackges;
	}
	public String getInvoiceNum() {
		return InvoiceNum;
	}
	public void setInvoiceNum(String invoiceNum) {
		InvoiceNum = invoiceNum;
	}
	public String getContainer() {
		return Container;
	}
	public void setContainer(String container) {
		Container = container;
	}
	
}
