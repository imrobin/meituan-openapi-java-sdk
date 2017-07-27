package com.sankuai.meituan.waimai.opensdk.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.sankuai.meituan.waimai.opensdk.constants.ErrorEnum;
import com.sankuai.meituan.waimai.opensdk.constants.ParamRequiredEnum;
import com.sankuai.meituan.waimai.opensdk.exception.ApiOpException;
import com.sankuai.meituan.waimai.opensdk.exception.ApiSysException;
import com.sankuai.meituan.waimai.opensdk.vo.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yangzhiqi on 15/10/15.
 */
public class OrderAPI extends API {

    /**
     * 将订单设为商家已收到
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @return
     */
    public String orderReceived(SystemParam systemParam, Long orderId)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderReceived);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 商家确认订单
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @return
     */
    public String orderConfirm(SystemParam systemParam, Long orderId)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderConfirm);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 商家取消订单
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @param reason      取消原因
     * @param reasonCode  取消原因code, 通过取消订单原因列表接口方法获取
     * @return
     */
    public String orderCancel(SystemParam systemParam, Long orderId, String reason,
                              String reasonCode)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("reason", reason);
        applicationParamsMap.put("reason_code", reasonCode);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderCancel);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 订单配送中
     *
     * @param systemParam  系统参数
     * @param orderId      订单id
     * @param courierName  配送员姓名
     * @param courierPhone 配送电话
     * @return
     */
    public String orderDelivering(SystemParam systemParam, Long orderId, String courierName,
                                  String courierPhone)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        if (courierName != null && !"".equals(courierName) && !"null".equals(courierName) && !"NULL".equals(courierName)) {
            applicationParamsMap.put("courier_name", courierName);
        }
        if (courierPhone != null && !"".equals(courierPhone) && !"null".equals(courierPhone) && !"NULL".equals(courierPhone)) {
            applicationParamsMap.put("courier_name", courierName);
        }
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderDelivering);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 订单已送达(如接入美团配送则无需接)
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @return
     */
    public String orderArrived(SystemParam systemParam, Long orderId) throws ApiOpException,
            ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderArrived);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 订单确认退款请求
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @param reason      确认退款详情
     * @return
     */
    public String orderRefundAgree(SystemParam systemParam, Long orderId, String reason)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderRefundAgree, systemParam, orderId, reason);

        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("reason", reason);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderRefundAgree);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 驳回订单退款申请
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @param reason      驳回退款详情
     * @return
     */
    public String orderRefundReject(SystemParam systemParam, Long orderId, String reason)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderRefundReject, systemParam, orderId, reason);

        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("reason", reason);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderRefundReject);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 获取订单商家补贴款
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @return
     */
    public OrderSubsidyParam orderSubsidy(SystemParam systemParam, Long orderId) throws ApiOpException,
            ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderSubsidy, systemParam, orderId);

        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderSubsidy);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        OrderSubsidyParam orderSubsidyParam = null;
        try {
            orderSubsidyParam = JSONObject.parseObject(data, OrderSubsidyParam.class);
        } catch (Exception e) {
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return orderSubsidyParam;
    }

    /**
     * 查询订单状态
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @return
     */
    public Integer orderViewStatus(SystemParam systemParam, Long orderId)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderViewStatus, systemParam, orderId);

        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderViewStatus);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        Integer orderStatus = null;
        try {
            String status = JSONObject.parseObject(data).get("status").toString();
            orderStatus = Integer.parseInt(status);
        } catch (Exception e) {
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return orderStatus;
    }

    /**
     * 查询活动信息
     *
     * @param systemParam 系统参数
     * @param actDetailId 活动ID
     * @return
     */
    public PoiPolicyParam orderGetActDetailByAcId(SystemParam systemParam, int actDetailId)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderGetActDetailByAcId, systemParam, actDetailId);

        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("act_detail_id", String.valueOf(actDetailId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderGetActDetailByAcId);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        PoiPolicyParam poiPolicyParam = null;
        try {
            poiPolicyParam = JSONObject.parseObject(data, PoiPolicyParam.class);
        } catch (Exception e) {
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return poiPolicyParam;
    }

    /**
     * 获取订单详细信息
     *
     * @param systemParam   系统参数
     * @param orderId       订单id
     * @param isMtLogistics 是否为美团配送（当需要查询美团配送的详细信息时此字段需要为1）
     * @return
     */
    public OrderDetailParam orderGetOrderDetail(SystemParam systemParam, long orderId, long isMtLogistics)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderGetOrderDetail, systemParam, orderId, isMtLogistics);

        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderGetOrderDetail);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        OrderDetailParam orderDetailParam = null;
        try {
            JSONObject jo = JSONObject.parseObject(data);
            jo.put("detail", JSONArray.parseArray(jo.getString("detail"), OrderFoodDetailParam.class));
            jo.put("extras", JSONArray.parseArray(jo.getString("extras"), OrderExtraParam.class));
            orderDetailParam = JSONObject.toJavaObject(jo, OrderDetailParam.class);
        } catch (Exception e) {
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return orderDetailParam;
    }

    /**
     * 下发美团配送订单(接入美团配送选接)
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @return
     */
    public String orderLogisticsPush(SystemParam systemParam, long orderId) throws ApiOpException,
            ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderLogisticsPush, systemParam, orderId);

        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderLogisticsPush);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 取消美团配送订单(接入美团配送选接)
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @return
     */
    public String orderLogisticsCancel(SystemParam systemParam, long orderId) throws ApiOpException,
            ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderLogisticsCancel, systemParam, orderId);

        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderLogisticsCancel);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 获取配送订单状态(接入美团配送选接)
     *
     * @param systemParam 系统参数
     * @param orderId     订单id
     * @return
     */
    public LogisticsParam orderLogisticsStatus(SystemParam systemParam, long orderId)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderLogisticsStatus, systemParam, orderId);

        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderLogisticsStatus);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        LogisticsParam logisticsParam = null;
        try {
            logisticsParam = JSONObject.parseObject(data, LogisticsParam.class);
        } catch (Exception e) {
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return logisticsParam;
    }

    /**
     * 批量查询众包配送费
     *
     * @param systemParam
     * @param orderIds
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public List<OrderZhongbaoShippingFeeParam> orderZhongbaoShippingFee(SystemParam systemParam, String orderIds)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderZhongbaoShippingFee, systemParam, orderIds);
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_ids", orderIds);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderZhongbaoShippingFee);

        String data = requestApi(methodName, systemParam, applicationParamsMap);
        List<OrderZhongbaoShippingFeeParam> orderZhongbaoShippingFeeParams = null;
        try {
            orderZhongbaoShippingFeeParams = JSONObject.parseArray(data, OrderZhongbaoShippingFeeParam.class);
        } catch (Exception e) {
            throw new ApiSysException(ErrorEnum.SYS_ERR);
        }
        return orderZhongbaoShippingFeeParams;
    }

    /**
     * 众包配送预下单
     *
     * @param systemParam
     * @param orderId
     * @param oldShippingFee
     * @param tipAmount
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String orderZhongbaoDispatchPrepare(SystemParam systemParam, long orderId, double oldShippingFee, double tipAmount)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderPrepareZhongbaoDispatch, systemParam, orderId);
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("old_shipping_fee", String.valueOf(oldShippingFee));
        applicationParamsMap.put("tip_amount", String.valueOf(tipAmount));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderPrepareZhongbaoDispatch);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 众包配送确认下单
     *
     * @param systemParam
     * @param orderId
     * @param tipAmount
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String orderZhongbaoDispatchConfirm(SystemParam systemParam, long orderId, double tipAmount)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderConfirmZhongbaoDispatch, systemParam, orderId);
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("tip_amount", String.valueOf(tipAmount));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderConfirmZhongbaoDispatch);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 众包配送单追加小费
     *
     * @param systemParam
     * @param orderId
     * @param tipAmount
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String orderZhongbaoUpdateTip(SystemParam systemParam, long orderId, double tipAmount)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderUpdateZhongbaoTip, systemParam, orderId);
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("tip_amount", String.valueOf(tipAmount));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderUpdateZhongbaoTip);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 获取订单评价信息
     *
     * @param systemParam
     * @param orderId
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String orderCommentOrder(SystemParam systemParam, long orderId)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderCommentOrder, systemParam, orderId);
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderCommentOrder);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 根据评价id添加商家回复
     *
     * @param systemParam
     * @param orderId
     * @param commentId
     * @param reply
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String orderCommentAddReply(SystemParam systemParam, long orderId, long commentId, String reply)
            throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();

        beforeMethod(ParamRequiredEnum.OrderCommentAddReply, systemParam, orderId);
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("order_id", String.valueOf(orderId));
        applicationParamsMap.put("comment_id", String.valueOf(commentId));
        applicationParamsMap.put("reply", reply);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.OrderCommentAddReply);

        return requestApi(methodName, systemParam, applicationParamsMap);
    }

}
