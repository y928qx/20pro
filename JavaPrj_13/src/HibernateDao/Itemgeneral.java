package HibernateDao;

import java.util.HashSet;
import java.util.Set;

/**
 * Itemgeneral generated by MyEclipse Persistence Tools
 */

public class Itemgeneral implements java.io.Serializable {

	// Fields

	private String itemId;

	private Employee employeeBySaleEmpId;

	private Employee employeeByPoEmpId;

	private Ummaster ummaster;

	private Classcode classcode;

	private String itemDesc;

	private String color;

	private Long taxRate;

	private Long salePic;

	private Long wholPic;

	private String status;

	private Set physicsdatas = new HashSet(0);

	private Set warehouseItems = new HashSet(0);

	private Set iusses = new HashSet(0);

	private Set eceipts = new HashSet(0);

	private Set inventorytags = new HashSet(0);

	// Constructors

	/** default constructor */
	public Itemgeneral() {
	}

	/** minimal constructor */
	public Itemgeneral(String itemId, Ummaster ummaster, Classcode classcode,
			Long taxRate, Long salePic, Long wholPic, String status) {
		this.itemId = itemId;
		this.ummaster = ummaster;
		this.classcode = classcode;
		this.taxRate = taxRate;
		this.salePic = salePic;
		this.wholPic = wholPic;
		this.status = status;
	}

	/** full constructor */
	public Itemgeneral(String itemId, Employee employeeBySaleEmpId,
			Employee employeeByPoEmpId, Ummaster ummaster, Classcode classcode,
			String itemDesc, String color, Long taxRate, Long salePic,
			Long wholPic, String status, Set physicsdatas, Set warehouseItems,
			Set iusses, Set eceipts, Set inventorytags) {
		this.itemId = itemId;
		this.employeeBySaleEmpId = employeeBySaleEmpId;
		this.employeeByPoEmpId = employeeByPoEmpId;
		this.ummaster = ummaster;
		this.classcode = classcode;
		this.itemDesc = itemDesc;
		this.color = color;
		this.taxRate = taxRate;
		this.salePic = salePic;
		this.wholPic = wholPic;
		this.status = status;
		this.physicsdatas = physicsdatas;
		this.warehouseItems = warehouseItems;
		this.iusses = iusses;
		this.eceipts = eceipts;
		this.inventorytags = inventorytags;
	}

	// Property accessors

	public String getItemId() {
		return this.itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public Employee getEmployeeBySaleEmpId() {
		return this.employeeBySaleEmpId;
	}

	public void setEmployeeBySaleEmpId(Employee employeeBySaleEmpId) {
		this.employeeBySaleEmpId = employeeBySaleEmpId;
	}

	public Employee getEmployeeByPoEmpId() {
		return this.employeeByPoEmpId;
	}

	public void setEmployeeByPoEmpId(Employee employeeByPoEmpId) {
		this.employeeByPoEmpId = employeeByPoEmpId;
	}

	public Ummaster getUmmaster() {
		return this.ummaster;
	}

	public void setUmmaster(Ummaster ummaster) {
		this.ummaster = ummaster;
	}

	public Classcode getClasscode() {
		return this.classcode;
	}

	public void setClasscode(Classcode classcode) {
		this.classcode = classcode;
	}

	public String getItemDesc() {
		return this.itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Long getTaxRate() {
		return this.taxRate;
	}

	public void setTaxRate(Long taxRate) {
		this.taxRate = taxRate;
	}

	public Long getSalePic() {
		return this.salePic;
	}

	public void setSalePic(Long salePic) {
		this.salePic = salePic;
	}

	public Long getWholPic() {
		return this.wholPic;
	}

	public void setWholPic(Long wholPic) {
		this.wholPic = wholPic;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Set getPhysicsdatas() {
		return this.physicsdatas;
	}

	public void setPhysicsdatas(Set physicsdatas) {
		this.physicsdatas = physicsdatas;
	}

	public Set getWarehouseItems() {
		return this.warehouseItems;
	}

	public void setWarehouseItems(Set warehouseItems) {
		this.warehouseItems = warehouseItems;
	}

	public Set getIusses() {
		return this.iusses;
	}

	public void setIusses(Set iusses) {
		this.iusses = iusses;
	}

	public Set getEceipts() {
		return this.eceipts;
	}

	public void setEceipts(Set eceipts) {
		this.eceipts = eceipts;
	}

	public Set getInventorytags() {
		return this.inventorytags;
	}

	public void setInventorytags(Set inventorytags) {
		this.inventorytags = inventorytags;
	}

}