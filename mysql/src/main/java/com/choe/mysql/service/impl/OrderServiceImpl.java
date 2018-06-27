package com.choe.mysql.service.impl;

import com.choe.common.domain.NewOrderBean;
import com.choe.common.domain.OldOrderBean;
import com.choe.common.domain.SubOrderBean;
import com.choe.mysql.dao.NewOrderMapper;
import com.choe.mysql.dao.OldOrderMapper;
import com.choe.mysql.dao.SubOrderMapper;
import com.choe.mysql.service.OrderService;
import com.google.common.collect.Maps;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author cyk
 * @date 2018/6/25/025 11:51
 * @email choe0227@163.com
 * @desc
 * @modifier
 * @modify_time
 * @modify_remark
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OldOrderMapper oldOrderMapper;
    @Autowired
    private NewOrderMapper newOrderMapper;
    @Autowired
    private SubOrderMapper subOrderMapper;

    /***
     *  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '流水号 自增',
     *   `orderNo` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '订单编号',
     *   `type` int(4) DEFAULT NULL COMMENT '1-我要出售 2-一键下单 3-代下单 4-预约单',
     *   `amount` double(15,2) DEFAULT NULL COMMENT '总金额',
     *   `discounted_amount` double(15,2) DEFAULT NULL COMMENT '优惠后总金额',
     *   `supplier_id` int(11) DEFAULT NULL COMMENT 'A端用户编号',
     *   `supplier_mobile` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'A端用户电话',
     *   `supplier_name` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'A端用户名称',
     *   `pedlarId` int(11) DEFAULT NULL COMMENT 'B端人员编号',
     *   `pedlar_mobile` varchar(16) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'B端手机号',
     *   `status` int(11) DEFAULT NULL COMMENT '订单状态 1-待分配 2-待响应 3-待骑手上门 4-待骑手确认信息 5-待卖家确认 6- 已完成 7-已评价 -1-用户取消待分配 -2用户取消待响应 -3-系统取消匹配超时 -4-系统取消接单超时 -5-系统取消上门超时 -6-骑手取消待B端确认信息 -7-系统取消待B端确认信息 -8客服取消 -9 骑手上门取消订单',
     *   `reserve_startTime` bigint(22) DEFAULT NULL COMMENT '预约订单开始时间',
     *   `reserve_endTime` bigint(22) DEFAULT NULL COMMENT '预约订单结束时间',
     *   `create_time` bigint(22) DEFAULT NULL COMMENT '订单创建时间',
     *   `assign_time` bigint(22) DEFAULT NULL COMMENT '订单分配时间',
     *   `response_time` bigint(22) DEFAULT NULL COMMENT '订单响应时间',
     *   `arrive_time` bigint(22) DEFAULT NULL COMMENT '到达时间',
     *   `confirm_time` bigint(22) DEFAULT NULL COMMENT 'B端确认时间',
     *   `finish_time` bigint(22) DEFAULT NULL COMMENT '订单完成时间',
     *   `evaluation_score` int(4) DEFAULT NULL COMMENT '用户评分',
     *   `supplier_point` bigint(15) DEFAULT NULL COMMENT 'A端经纬度信息',
     *   `pedlar_point` bigint(15) DEFAULT NULL COMMENT 'B端接单时的位置信息',
     *   `addr_detail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'A端详细地址',
     *   `area_pro` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属省份',
     *   `area_city` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属城市',
     *   `area_county` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属区县',
     *   `area_town` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属城镇',
     *   `remark` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单备注',
     *   `delivery_id` bigint(20) DEFAULT NULL COMMENT '废品通编号',
     */

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void transOrder() {
        // 获取订单列表
        List<OldOrderBean> oldOrderBeans = oldOrderMapper.select(null);
        for (OldOrderBean old :oldOrderBeans){

            NewOrderBean newOrder = new NewOrderBean();
            newOrder.setId(old.getId());
            String orderNo = generOrderNo(old);
            newOrder.setOrderNo(orderNo);
            newOrder.setType(old.getType());
            newOrder.setAmount(old.getMoney());
            newOrder.setDiscounted_amount(old.getMoney());
            newOrder.setSupplier_id(old.getSupplier_id());
            newOrder.setSupplier_mobile(old.getSupplier_mobile());
            newOrder.setSupplier_name(old.getSupplier_name());
            newOrder.setPedlarId(old.getPedlar_id());
            newOrder.setPedlar_mobile(old.getPedlar_mobile());
            newOrder.setStatus(old.getStatus());
            newOrder.setCreate_time(old.getCreate_time());
            newOrder.setAssign_time(old.getAssign_time());
            newOrder.setFinish_time(old.getFinish_time());
            newOrder.setEvaluation_score(old.getDiscuss_score());
            newOrder.setSupplier_point(old.getSupplier_point());
            newOrder.setPedlar_point(old.getPedlar_point());
            newOrder.setAddr_detail(old.getAddress_details());
            newOrder.setArea_pro(old.getArea_province());
            newOrder.setArea_city(old.getArea_city());
            newOrder.setArea_county(old.getArea_county());
            newOrder.setArea_town(old.getArea_town());
            newOrder.setDelivery_id(old.getDelivery_id());

            // 准备子订单信息
            SubOrderBean subOrderBean = new SubOrderBean();
            subOrderBean.setOrderNo(orderNo);
            subOrderBean.setCategory_type_id(old.getPedlar_category_id());
            subOrderBean.setWeight(old.getWeight());
            subOrderBean.setUnit_price(old.getOne_money());
            subOrderBean.setTotal_price(old.getMoney());
            subOrderBean.setCreate_time(old.getCreate_time());

            newOrderMapper.add(newOrder);
            System.out.println("订单添加成功"+newOrder.getId());
            subOrderMapper.add(subOrderBean);
            System.out.println("子订单添加成功"+subOrderBean.getId());
        }
    }

    private static Map<String,Integer> orderMap = Maps.newConcurrentMap();


    private String generOrderNo(OldOrderBean orderBean){

        String orderNo =null;
        Long create_time = orderBean.getCreate_time();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date = new Date(create_time);
        String date_format = sdf.format(date);
        System.out.println(date_format);
        Integer num =null;
        if ( orderMap.containsKey(date_format)){
            num = orderMap.get(date_format);

        }else {
            num = 0;
        }
        orderMap.put(date_format,++num);
        orderNo = date_format+"0" + orderBean.getType() + String.format("%06d", num);
        return orderNo;
    }
}
