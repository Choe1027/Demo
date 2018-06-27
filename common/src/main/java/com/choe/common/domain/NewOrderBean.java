package com.choe.common.domain;

import java.util.List;

import jdk.nashorn.internal.ir.annotations.Ignore;


/** 订单信息 */
public class NewOrderBean  {
	private static final long serialVersionUID = 1L;

	private Long id;
	/** 订单编号*/
	private String orderNo;
	/** 1-我要出售 2-一键呼叫 3-代下单 4-预约下单*/
	private Integer type;
	/**总金额*/
	private Double amount;
	/** 优惠金额*/
	private Double discounted_amount;
	/**A端用户编号*/
	private Long supplier_id;
	/**A端用户电话*/
	private String supplier_mobile;
	/**A端用户名称*/
	private String supplier_name;
	/**B端人员编号*/
	private Long pedlarId;
	/**B端手机号*/
	private String pedlar_mobile;
	/**订单状态  1-待分配 2-待响应 3-待骑手上门 4-待骑手确认信息 5-待卖家确认 6- 已完成 7-已评价
	 *  -1-用户取消待分配 -2用户取消待响应 -3-系统取消匹配超时 -4-系统取消接单超时
	 *  -5-系统取消上门超时 -6-骑手取消待B端确认信息 -7-系统取消待B端确认信息 -8客服取消*/
	private Integer status;
	/**订单预约开始时间 */
	private Long reserve_startTime;
	/**订单预约结束时间 */
	private Long reserve_endTime;
	/**订单分配时间*/
	private Long assign_time;
	/**订单响应时间*/
	private Long response_time;
	/**到达时间*/
	private Long arrive_time;
	/**B端确认时间*/
	private Long confirm_time;
	/**订单完成时间*/
	private Long finish_time;
	/**用户评分*/
	private Integer evaluation_score;
	/**A端经纬度信息 合并后*/
	private Long supplier_point;
	/**B端接单时的位置信息*/
	private Long pedlar_point;
	/**A端详细地址*/
	private String addr_detail;
	/**所属省份*/
	private String area_pro;
	/**所属城市*/
	private String area_city;
	/**所属区县*/
	private String area_county;
	/**所属城镇*/
	private String area_town;
	/**订单备注*/
	private String remark;
	/**废品通编号*/
	private Long delivery_id;

	private Long create_time;

//	=======以上属性对应数据库表字段===
	/**地址id*/
	@Ignore
	private Long address_id;
	/**B端用户的名称*/
	@Ignore
	private String pedlar_name;
	/**订单的总重量*/
	@Ignore
	private Double weight;
	/** A端的纬度 */
	@Ignore
	private Double supplier_lat;
	/** A端的经度 */
	@Ignore
	private Double supplier_lng;
	/** B端的纬度 */
	@Ignore
	private Double pedlar_lat;
	/** B端的经度 */
	@Ignore
	private Double pedlar_lng;

	/**
	 * 当前订单子订单信息
	 */
	private List<SubOrderBean> subOrders;
	/**订单发起方*/
	@Ignore
	private String publisher;

	/**
	 * B端的头像
	 */
	@Ignore
	private String pedlar_head;

	/**订单类型名称*/
	@Ignore
	private String type_name;


	public String getOrderNo() {
		return orderNo;
	}


	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}


	public Integer getType() {
		return type;
	}


	public void setType(Integer type) {
		this.type = type;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public Double getDiscounted_amount() {
		return discounted_amount;
	}


	public void setDiscounted_amount(Double discounted_amount) {
		this.discounted_amount = discounted_amount;
	}


	public Long getSupplier_id() {
		return supplier_id;
	}


	public void setSupplier_id(Long supplier_id) {
		this.supplier_id = supplier_id;
	}


	public String getSupplier_mobile() {
		return supplier_mobile;
	}


	public void setSupplier_mobile(String supplier_mobile) {
		this.supplier_mobile = supplier_mobile;
	}


	public String getSupplier_name() {
		return supplier_name;
	}


	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}


	public Long getPedlarId() {
		return pedlarId;
	}


	public void setPedlarId(Long pedlarId) {
		this.pedlarId = pedlarId;
	}


	public String getPedlar_mobile() {
		return pedlar_mobile;
	}


	public void setPedlar_mobile(String pedlar_mobile) {
		this.pedlar_mobile = pedlar_mobile;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Long getAssign_time() {
		return assign_time;
	}


	public void setAssign_time(Long assign_time) {
		this.assign_time = assign_time;
	}


	public Long getResponse_time() {
		return response_time;
	}


	public void setResponse_time(Long response_time) {
		this.response_time = response_time;
	}


	public Long getArrive_time() {
		return arrive_time;
	}


	public void setArrive_time(Long arrive_time) {
		this.arrive_time = arrive_time;
	}


	public Long getConfirm_time() {
		return confirm_time;
	}


	public void setConfirm_time(Long confirm_time) {
		this.confirm_time = confirm_time;
	}


	public Long getFinish_time() {
		return finish_time;
	}


	public void setFinish_time(Long finish_time) {
		this.finish_time = finish_time;
	}


	public Integer getEvaluation_score() {
		return evaluation_score;
	}


	public void setEvaluation_score(Integer evaluation_score) {
		this.evaluation_score = evaluation_score;
	}


	public Long getSupplier_point() {
		return supplier_point;
	}


	public void setSupplier_point(Long supplier_point) {
		this.supplier_point = supplier_point;
	}


	public Long getPedlar_point() {
		return pedlar_point;
	}


	public void setPedlar_point(Long pedlar_point) {
		this.pedlar_point = pedlar_point;
	}


	public String getAddr_detail() {
		return addr_detail;
	}


	public void setAddr_detail(String addr_detail) {
		this.addr_detail = addr_detail;
	}


	public String getArea_pro() {
		return area_pro;
	}


	public void setArea_pro(String area_pro) {
		this.area_pro = area_pro;
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


	public String getRemark() {
		return remark;
	}


	public void setRemark(String remark) {
		this.remark = remark;
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



	public List<SubOrderBean> getSubOrders() {
		return subOrders;
	}


	public void setSubOrders(List<SubOrderBean> subOrders) {
		this.subOrders = subOrders;
	}


	public void removeSensitive() {
		supplier_point = null;
	}


	public Long getAddress_id() {
		return address_id;
	}


	public void setAddress_id(Long address_id) {
		this.address_id = address_id;
	}


	public String getPedlar_name() {
		return pedlar_name;
	}


	public void setPedlar_name(String pedlar_name) {
		this.pedlar_name = pedlar_name;
	}


	public Long getDelivery_id() {
		return delivery_id;
	}


	public void setDelivery_id(Long delivery_id) {
		this.delivery_id = delivery_id;
	}


	public Double getWeight() {
		return weight;
	}


	public void setWeight(Double weight) {
		this.weight = weight;
	}


	public Long getReserve_startTime() {
		return reserve_startTime;
	}


	public void setReserve_startTime(Long reserve_startTime) {
		this.reserve_startTime = reserve_startTime;
	}


	public Long getReserve_endTime() {
		return reserve_endTime;
	}


	public void setReserve_endTime(Long reserve_endTime) {
		this.reserve_endTime = reserve_endTime;
	}


	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}


	public String getType_name() {
		return type_name;
	}


	public void setType_name(String type_name) {
		this.type_name = type_name;
	}


	public String getPedlar_head() {
		return pedlar_head;
	}


	public void setPedlar_head(String pedlar_head) {
		this.pedlar_head = pedlar_head;
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
