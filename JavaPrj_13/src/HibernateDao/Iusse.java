package HibernateDao;

import java.util.Date;

/**
 * Iusse generated by MyEclipse Persistence Tools
 */

public class Iusse implements java.io.Serializable {

	// Fields

	private Integer keyId;

	private Itemgeneral itemgeneral;

	private Location location;

	private Warehouse warehouse;

	private Stockreason stockreason;

	private String isType;

	private Double qty;

	private Double actualQty;

	private Double adJuAmt;

	private Date transDate;

	private String billNo;

	// Constructors

	/** default constructor */
	public Iusse() {
	}

	/** minimal constructor */
	public Iusse(Integer keyId, Itemgeneral itemgeneral, Location location,
			Warehouse warehouse, Stockreason stockreason, String isType,
			Double qty, Double actualQty, Double adJuAmt, String billNo) {
		this.keyId = keyId;
		this.itemgeneral = itemgeneral;
		this.location = location;
		this.warehouse = warehouse;
		this.stockreason = stockreason;
		this.isType = isType;
		this.qty = qty;
		this.actualQty = actualQty;
		this.adJuAmt = adJuAmt;
		this.billNo = billNo;
	}

	/** full constructor */
	public Iusse(Integer keyId, Itemgeneral itemgeneral, Location location,
			Warehouse warehouse, Stockreason stockreason, String isType,
			Double qty, Double actualQty, Double adJuAmt, Date transDate,
			String billNo) {
		this.keyId = keyId;
		this.itemgeneral = itemgeneral;
		this.location = location;
		this.warehouse = warehouse;
		this.stockreason = stockreason;
		this.isType = isType;
		this.qty = qty;
		this.actualQty = actualQty;
		this.adJuAmt = adJuAmt;
		this.transDate = transDate;
		this.billNo = billNo;
	}

	// Property accessors

	public Integer getKeyId() {
		return this.keyId;
	}

	public void setKeyId(Integer keyId) {
		this.keyId = keyId;
	}

	public Itemgeneral getItemgeneral() {
		return this.itemgeneral;
	}

	public void setItemgeneral(Itemgeneral itemgeneral) {
		this.itemgeneral = itemgeneral;
	}

	public Location getLocation() {
		return this.location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Warehouse getWarehouse() {
		return this.warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Stockreason getStockreason() {
		return this.stockreason;
	}

	public void setStockreason(Stockreason stockreason) {
		this.stockreason = stockreason;
	}

	public String getIsType() {
		return this.isType;
	}

	public void setIsType(String isType) {
		this.isType = isType;
	}

	public Double getQty() {
		return this.qty;
	}

	public void setQty(Double qty) {
		this.qty = qty;
	}

	public Double getActualQty() {
		return this.actualQty;
	}

	public void setActualQty(Double actualQty) {
		this.actualQty = actualQty;
	}

	public Double getAdJuAmt() {
		return this.adJuAmt;
	}

	public void setAdJuAmt(Double adJuAmt) {
		this.adJuAmt = adJuAmt;
	}

	public Date getTransDate() {
		return this.transDate;
	}

	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public String getBillNo() {
		return this.billNo;
	}

	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}

}