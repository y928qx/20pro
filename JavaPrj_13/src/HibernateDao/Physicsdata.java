package HibernateDao;

/**
 * Physicsdata generated by MyEclipse Persistence Tools
 */

public class Physicsdata implements java.io.Serializable {

	// Fields

	private Integer keyId;

	private Itemgeneral itemgeneral;

	private Location location;

	private Warehouse warehouse;

	private String statue;

	private Double cutoff;

	private Double actQty;

	// Constructors

	/** default constructor */
	public Physicsdata() {
	}

	/** full constructor */
	public Physicsdata(Integer keyId, Itemgeneral itemgeneral,
			Location location, Warehouse warehouse, String statue,
			Double cutoff, Double actQty) {
		this.keyId = keyId;
		this.itemgeneral = itemgeneral;
		this.location = location;
		this.warehouse = warehouse;
		this.statue = statue;
		this.cutoff = cutoff;
		this.actQty = actQty;
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

	public String getStatue() {
		return this.statue;
	}

	public void setStatue(String statue) {
		this.statue = statue;
	}

	public Double getCutoff() {
		return this.cutoff;
	}

	public void setCutoff(Double cutoff) {
		this.cutoff = cutoff;
	}

	public Double getActQty() {
		return this.actQty;
	}

	public void setActQty(Double actQty) {
		this.actQty = actQty;
	}

}