package com.choe.common.domain;

/**
 * 子订单
 * @author cuiyongkang
 *
 */
public class SubOrderBean  {

	private static final long serialVersionUID = 1L;
	private Long id;
	/**订单编号*/
	private String orderNo;
	/**废品种类编号*/
	private Long category_type_id;
	/**重量（千克）*/
	private Double weight;
	/**单价（元/千克）*/
	private Double unit_price;
	/**总价*/
	private Double total_price;
	private Long create_time;

	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getCategory_type_id() {
		return category_type_id;
	}
	public void setCategory_type_id(Long category_type_id) {
		this.category_type_id = category_type_id;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Double getUnit_price() {
		return unit_price;
	}
	public void setUnit_price(Double unit_price) {
		this.unit_price = unit_price;
	}
	public Double getTotal_price() {
		return total_price;
	}
	public void setTotal_price(Double total_price) {
		this.total_price = total_price;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}
}
