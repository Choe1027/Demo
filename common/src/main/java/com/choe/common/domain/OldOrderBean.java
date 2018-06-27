package com.choe.common.domain;


import jdk.nashorn.internal.ir.annotations.Ignore;

/** 订单信息 */
public class OldOrderBean  {
	private static final long serialVersionUID = 1L;

	private Long id ;
	/** 废品种类 */
	private String category_name;

	/** 重量(千克/公斤) */
	private Double weight;

	/** 单价 */
	private Double one_money;

	/** 总价 */
	private Double money;

	/** 供货商(A端)信息ID */
	private Long supplier_id;

	/** 商贩(B端)信息ID 如果没有接单默认为0 */
	private Long pedlar_id;

	/** 完成时间 */
	private Long finish_time;

	/** 地址信息ID */
	private Long address_id;

	/** 根据经纬度算出 */
	private Long supplier_point;

	/** 订单状态ID */
	private Integer status;

	/** 订单评分 */
	private Integer discuss_score;

	/** 冗余供货方的昵称(A端) */
	private String supplier_name;

	/** 冗余商贩的昵称(B端) */
	private String pedlar_name;

	/** 冗余供货方的地址详情(A端) */
	private String address_details;

	/** 冗余供货方的头像(A端) */
	private String supplier_head;

	/** 冗余商贩的头像(B端) */
	private String pedlar_head;

	/** 废品通编号 */
	private Long delivery_id;

	/** A端的纬度 */
	@Ignore
	private Double supplier_lat;

	/** A端的经度 */
	@Ignore
	private Double supplier_lng;

	/** 分配订单的时间 */
	private Long assign_time;

	private Long create_time;

	/**
	 * 订单类型 1-我要出售 2-一键呼叫 3-代下单
	 */
	private Integer type;



	/** 价格信息ID */
	private Long price_id;

	/** 冗余价格信息表中的价格区间 */
	private String price_interval;

	/** 冗余价格信息表中的价格 */
	private Double price_price;

	/** 冗余B端确认的分类类型名称 */
	private String pedlar_category_name;

	/** B端确认的分类类型ID */
	private Long pedlar_category_id;

	/** 冗余B端的货车id */
	private Long pedlar_car_id;

	/** 冗余B端的货车类型名 */
	private String pedlar_car_type;

	/** B端的汽车载货量 */
	private Double pedlar_car_capacity;

	/** B端接单时的位置 */
	private Long pedlar_point;

	/** 支付积分 */
	private Integer pay_score;

	/** B端的纬度 */
	@Ignore
	private Double pedlar_lat;
	/** B端的经度 */
	@Ignore
	private Double pedlar_lng;

	/** A端手机号 */
	private String pedlar_mobile;

	/** B端手机号 */
	private String supplier_mobile;



	/**
	 * 订单所属行政区域
	 */
	private String city_code;

	/**
	 * 所属省
	 */
	private String area_province;

	/**
	 * 所属市
	 */
	private String area_city;

	/**
	 * 所属县
	 */
	private String area_county;

	/**
	 * 所属镇
	 */
	private String area_town;


	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}


	public Long getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(Long delivery_id) {
		this.delivery_id = delivery_id;
	}

	public Long getPedlar_car_id() {
		return pedlar_car_id;
	}

	public void setPedlar_car_id(Long pedlar_car_id) {
		this.pedlar_car_id = pedlar_car_id;
	}

	public String getPedlar_car_type() {
		return pedlar_car_type;
	}

	public void setPedlar_car_type(String pedlar_car_type) {
		this.pedlar_car_type = pedlar_car_type;
	}

	public void removeSensitive() {
		supplier_point = null;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getOne_money() {
		return one_money;
	}

	public void setOne_money(Double one_money) {
		this.one_money = one_money;
	}

	public Double getMoney() {
		return money;
	}

	public void setMoney(Double money) {
		this.money = money;
	}

	public Long getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}

	public Long getPedlar_id() {
		return pedlar_id;
	}

	public void setPedlar_id(Long pedlar_id) {
		this.pedlar_id = pedlar_id;
	}

	public Long getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(Long finish_time) {
		this.finish_time = finish_time;
	}

	public Long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}

	public Long getSupplier_point() {
		return supplier_point;
	}

	public void setSupplier_point(Long supplier_point) {
		this.supplier_point = supplier_point;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getDiscuss_score() {
		return discuss_score;
	}

	public void setDiscuss_score(Integer discuss_score) {
		this.discuss_score = discuss_score;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public String getAddress_details() {
		return address_details;
	}

	public void setAddress_details(String address_details) {
		this.address_details = address_details;
	}

	public String getPedlar_name() {
		return pedlar_name;
	}

	public void setPedlar_name(String pedlar_name) {
		this.pedlar_name = pedlar_name;
	}

	public String getSupplier_head() {
		return supplier_head;
	}

	public void setSupplier_head(String supplier_head) {
		this.supplier_head = supplier_head;
	}

	public String getPedlar_head() {
		return pedlar_head;
	}

	public void setPedlar_head(String pedlar_head) {
		this.pedlar_head = pedlar_head;
	}

	public Double getSupplier_lat() {
		return supplier_lat;
	}

	public void setSupplier_lat(Double supplier_lat) {
		this.supplier_lat = supplier_lat;
	}

	public Double getSupplier_lng() {
		return supplier_lng;
	}

	public void setSupplier_lng(Double supplier_lng) {
		this.supplier_lng = supplier_lng;
	}

	public Double getPedlar_lat() {
		return pedlar_lat;
	}

	public void setPedlar_lat(Double pedlar_lat) {
		this.pedlar_lat = pedlar_lat;
	}

	public Double getPedlar_lng() {
		return pedlar_lng;
	}

	public void setPedlar_lng(Double pedlar_lng) {
		this.pedlar_lng = pedlar_lng;
	}



	public Long getAssign_time() {
		return assign_time;
	}

	public void setAssign_time(Long assign_time) {
		this.assign_time = assign_time;
	}



	public Long getPrice_id() {
		return price_id;
	}

	public void setPrice_id(Long price_id) {
		this.price_id = price_id;
	}

	public String getPrice_interval() {
		return price_interval;
	}

	public void setPrice_interval(String price_interval) {
		this.price_interval = price_interval;
	}

	public Double getPrice_price() {
		return price_price;
	}

	public void setPrice_price(Double price_price) {
		this.price_price = price_price;
	}

	public String getPedlar_category_name() {
		return pedlar_category_name;
	}

	public void setPedlar_category_name(String pedlar_category_name) {
		this.pedlar_category_name = pedlar_category_name;
	}

	public Long getPedlar_category_id() {
		return pedlar_category_id;
	}

	public void setPedlar_category_id(Long pedlar_category_id) {
		this.pedlar_category_id = pedlar_category_id;
	}

	public Double getPedlar_car_capacity() {
		return pedlar_car_capacity;
	}

	public void setPedlar_car_capacity(Double pedlar_car_capacity) {
		this.pedlar_car_capacity = pedlar_car_capacity;
	}

	public Long getPedlar_point() {
		return pedlar_point;
	}

	public void setPedlar_point(Long pedlar_point) {
		this.pedlar_point = pedlar_point;
	}

	public Integer getPay_score() {
		return pay_score;
	}

	public void setPay_score(Integer pay_score) {
		this.pay_score = pay_score;
	}

	public String getPedlar_mobile() {
		return pedlar_mobile;
	}

	public void setPedlar_mobile(String pedlar_mobile) {
		this.pedlar_mobile = pedlar_mobile;
	}

	public String getSupplier_mobile() {
		return supplier_mobile;
	}

	public void setSupplier_mobile(String supplier_mobile) {
		this.supplier_mobile = supplier_mobile;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

	public String getArea_province() {
		return area_province;
	}

	public void setArea_province(String area_province) {
		this.area_province = area_province;
	}

	public String getArea_city() {
		return area_city;
	}

	public void setArea_city(String area_city) {
		this.area_city = area_city;
	}

	public String getArea_county() {
		return area_county;
	}

	public void setArea_county(String area_county) {
		this.area_county = area_county;
	}

	public String getArea_town() {
		return area_town;
	}

	public void setArea_town(String area_town) {
		this.area_town = area_town;
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
