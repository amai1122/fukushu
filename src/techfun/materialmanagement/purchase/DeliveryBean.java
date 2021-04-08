package techfun.materialmanagement.purchase;

public class DeliveryBean {
	private String buyer_cd;
	private String component_cd;
	private String supplier_cd;
	private String supplier_nm;
	private int order_qty;
	/**
	 * @return buyer_cd
	 */
	public String getBuyer_cd() {
		return buyer_cd;
	}
	/**
	 * @param buyer_cd セットする buyer_cd
	 */
	public void setBuyer_cd(String buyer_cd) {
		this.buyer_cd = buyer_cd;
	}
	/**
	 * @return component_cd
	 */
	public String getComponent_cd() {
		return component_cd;
	}
	/**
	 * @param component_cd セットする component_cd
	 */
	public void setComponent_cd(String component_cd) {
		this.component_cd = component_cd;
	}
	/**
	 * @return supplier_cd
	 */
	public String getSupplier_cd() {
		return supplier_cd;
	}
	/**
	 * @param supplier_cd セットする supplier_cd
	 */
	public void setSupplier_cd(String supplier_cd) {
		this.supplier_cd = supplier_cd;
	}
	/**
	 * @return supplier_nm
	 */
	public String getSupplier_nm() {
		return supplier_nm;
	}
	/**
	 * @param supplier_nm セットする supplier_nm
	 */
	public void setSupplier_nm(String supplier_nm) {
		this.supplier_nm = supplier_nm;
	}
	/**
	 * @return order_qty
	 */
	public int getOrder_qty() {
		return order_qty;
	}
	/**
	 * @param order_qty セットする order_qty
	 */
	public void setOrder_qty(int order_qty) {
		this.order_qty = order_qty;
	}




}
