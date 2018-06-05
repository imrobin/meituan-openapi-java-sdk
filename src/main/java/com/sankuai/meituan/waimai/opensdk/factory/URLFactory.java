package com.sankuai.meituan.waimai.opensdk.factory;

import com.sankuai.meituan.waimai.opensdk.exception.ApiSysException;
import com.sankuai.meituan.waimai.opensdk.util.PropertiesUtil;
import com.sankuai.meituan.waimai.opensdk.util.StringUtil;
import org.apache.http.HttpHost;
import org.apache.http.conn.routing.HttpRoute;

import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yangzhiqi on 15/10/16.
 */
public class URLFactory {

    private static String urlPrefix = "";
    private static Map<String,String> urlMap;
    private static Map<String,String> urlTypeMap;

    static {
        urlMap = new HashMap<>();
        urlTypeMap = new HashMap<>();

        //门店
        urlMap.put("poiSave","poi/save");
        urlMap.put("poiGetIds","poi/getids");
        urlMap.put("poiMget","poi/mget");
        urlMap.put("poiOpen","poi/open");
        urlMap.put("poiClose","poi/close");
        urlMap.put("poiOffline","poi/offline");
        urlMap.put("poiOnline","poi/online");
        urlMap.put("poiQualifySave","poi/qualify/save"); // 已废弃
        urlMap.put("poiSendTimeSave","poi/sendtime/save");
        urlMap.put("poiAdditionalSave","poi/additional/save");
        urlMap.put("poiUpdatepromoteinfo","poi/updatepromoteinfo");
        urlMap.put("poiTagList","poiTag/list");
        urlMap.put("poiUpdatePromotionInfo","poi/updatepromoteinfo");
        urlMap.put("poiUpdateShippingtime","poi/shippingtime/update");
        urlMap.put("poiIsDelayPushLogistics","poi/logistics/isDelayPush");
        urlMap.put("poiSetDelayPushLogistics","poi/logistics/setDelayPush");
        urlMap.put("poiComment","poi/comment/app_poi_code");
        urlMap.put("poiCommentAddReply","poi/comment/add_reply");
        urlMap.put("poiCommentScore","comment/score");




        urlTypeMap.put("poiSave","POST");
        urlTypeMap.put("poiGetIds","GET");
        urlTypeMap.put("poiMget","GET");
        urlTypeMap.put("poiOpen","POST");
        urlTypeMap.put("poiClose","POST");
        urlTypeMap.put("poiOffline","POST");
        urlTypeMap.put("poiOnline","POST");
        urlTypeMap.put("poiQualifySave","POST"); // 已废弃
        urlTypeMap.put("poiSendTimeSave","POST");
        urlTypeMap.put("poiAdditionalSave","POST");
        urlTypeMap.put("poiUpdatepromoteinfo","POST");
        urlTypeMap.put("poiTagList","POST");
        urlTypeMap.put("poiUpdatePromotionInfo","POST");
        urlTypeMap.put("poiUpdateShippingtime","POST");
        urlTypeMap.put("poiIsDelayPushLogistics","POST");
        urlTypeMap.put("poiSetDelayPushLogistics","POST");
        urlTypeMap.put("poiComment","GET");
        urlTypeMap.put("poiCommentAddReply","POST");
        urlTypeMap.put("poiCommentScore","GET");



        //配送
        urlMap.put("shippingSave","shipping/save");
        urlMap.put("shippingList","shipping/list");
        urlMap.put("shippingBatchSave","shipping/batchsave");
        urlMap.put("shippingFetch","shipping/fetch");



        urlTypeMap.put("shippingSave","POST");
        urlTypeMap.put("shippingList","GET");
        urlTypeMap.put("shippingBatchSave","POST");
        urlTypeMap.put("shippingFetch","GET");


        //菜品
        urlMap.put("foodCatUpdate","foodCat/update");
        urlMap.put("foodCatDelete","foodCat/delete");
        urlMap.put("foodSave","food/save");
        urlMap.put("foodInitData","food/initdata");
        urlMap.put("foodDelete","food/delete");
        urlMap.put("foodList","food/list");
        urlMap.put("foodListByPage","food/list");
        urlMap.put("foodBatchSave","food/batchsave");
        urlMap.put("foodBatchInitData","food/batchinitdata");
        urlMap.put("foodCatList","foodCat/list");
        urlMap.put("foodSkuSave","food/sku/save");
        urlMap.put("foodSkuDelete","food/sku/delete");
        urlMap.put("updateFoodSkuPrice","food/sku/price");
        urlMap.put("updateFoodSkuStock","food/sku/stock");
        urlMap.put("incFoodSkuStock","food/sku/inc_stock");
        urlMap.put("descFoodSkuStock","food/sku/desc_stock");
        urlMap.put("foodBindProperty","food/bind/property");
        urlMap.put("foodPropertyList","food/property/list");
        urlMap.put("foodGet","food/get");
        urlMap.put("foodSkuSellStatusUpdate","food/sku/sellStatus");

        urlTypeMap.put("foodCatUpdate","POST");
        urlTypeMap.put("foodCatDelete","POST");
        urlTypeMap.put("foodSave","POST");
        urlTypeMap.put("foodInitData","POST");
        urlTypeMap.put("foodDelete","POST");
        urlTypeMap.put("foodList","GET");
        urlTypeMap.put("foodListByPage","GET");
        urlTypeMap.put("foodBatchSave","POST");
        urlTypeMap.put("foodBatchInitData","POST");
        urlTypeMap.put("foodCatList","GET");
        urlTypeMap.put("foodSkuSave","POST");
        urlTypeMap.put("foodSkuDelete","POST");
        urlTypeMap.put("updateFoodSkuPrice","POST");
        urlTypeMap.put("updateFoodSkuStock","POST");
        urlTypeMap.put("incFoodSkuStock","POST");
        urlTypeMap.put("descFoodSkuStock","POST");
        urlTypeMap.put("foodBindProperty","POST");
        urlTypeMap.put("foodPropertyList","GET");
        urlTypeMap.put("foodGet","GET");
        urlTypeMap.put("foodSkuSellStatusUpdate","POST");

        //药品
        urlMap.put("medicineCatSave","medicineCat/save");
        urlMap.put("medicineCatUpdate","medicineCat/update");
        urlMap.put("medicineCatDelete","medicineCat/delete");
        urlMap.put("medicineCatList","medicineCat/list");
        urlMap.put("medicineSave","medicine/save");
        urlMap.put("medicineUpdate","medicine/update");
        urlMap.put("medicineBatchSave","medicine/batchsave");
        urlMap.put("medicineBatchUpdate","medicine/batchupdate");
        urlMap.put("medicineDelete","medicine/delete");
        urlMap.put("medicineList","medicine/list");
        urlMap.put("medicineStock","medicine/stock");

        urlTypeMap.put("medicineCatSave","POST");
        urlTypeMap.put("medicineCatUpdate","POST");
        urlTypeMap.put("medicineCatDelete","POST");
        urlTypeMap.put("medicineCatList","GET");
        urlTypeMap.put("medicineSave","POST");
        urlTypeMap.put("medicineUpdate","POST");
        urlTypeMap.put("medicineBatchSave","POST");
        urlTypeMap.put("medicineBatchUpdate","POST");
        urlTypeMap.put("medicineDelete","POST");
        urlTypeMap.put("medicineList","GET");
        urlTypeMap.put("medicineStock","POST");


        // 零售
        urlMap.put("retailCatUpdate","retailCat/update");
        urlMap.put("retailCatDelete","retailCat/delete");
        urlMap.put("retailCatList","retailCat/list");
        urlMap.put("retailInitData","retail/initdata");
        urlMap.put("retailList","retail/list");
        urlMap.put("retailListByPage","retail/list");
        urlMap.put("retailBatchInitData","retail/batchinitdata");
        urlMap.put("updateRetailSkuPrice","retail/sku/price");
        urlMap.put("updateRetailSkuStock","retail/sku/stock");
        urlMap.put("retailGet","retail/get");

        urlTypeMap.put("retailCatUpdate","POST");
        urlTypeMap.put("retailCatDelete","POST");
        urlTypeMap.put("retailCatList","GET");
        urlTypeMap.put("retailInitData","POST");
        urlTypeMap.put("retailList","GET");
        urlTypeMap.put("retailListByPage","GET");
        urlTypeMap.put("retailBatchInitData","POST");
        urlTypeMap.put("updateRetailSkuPrice","POST");
        urlTypeMap.put("updateRetailSkuStock","POST");
        urlTypeMap.put("retailGet","GET");


        // 活动

        urlMap.put("actDiscountBatchSave","act/discount/batchsave");
        urlMap.put("actDiscountDelete","act/discount/delete");
        urlMap.put("actDiscountStock","act/discount/stock");
        urlMap.put("actDiscountList","act/discount/list");
        urlMap.put("actDiscountActivityOrderLimit","act/discount/activity_order_limit");

        urlTypeMap.put("actDiscountBatchSave","POST");
        urlTypeMap.put("actDiscountDelete","POST");
        urlTypeMap.put("actDiscountStock","POST");
        urlTypeMap.put("actDiscountList","GET");
        urlTypeMap.put("actDiscountActivityOrderLimit","POST");

        urlMap.put("fullDiscountBatchSave","act/full/discount/batchsave");
        urlMap.put("fullDiscountList","act/full/discount/list");
        urlMap.put("fullDiscountDelete","act/full/discount/delete");
        urlMap.put("fullDiscountFoodsBatchSave","act/full/discount/foods/batchsave");
        urlMap.put("fullDiscountFoodsList","act/full/discount/foods/list");
        urlMap.put("fullDiscountFoodsDelete","act/full/discount/foods/delete");
        urlMap.put("fullDiscountFoodsBatchUpdateDayLimit","act/full/discount/foods/orderlimit");

        urlTypeMap.put("fullDiscountBatchSave","POST");
        urlTypeMap.put("fullDiscountList","POST");
        urlTypeMap.put("fullDiscountDelete","POST");
        urlTypeMap.put("fullDiscountFoodsBatchSave","POST");
        urlTypeMap.put("fullDiscountFoodsList","POST");
        urlTypeMap.put("fullDiscountFoodsDelete","POST");
        urlTypeMap.put("fullDiscountFoodsBatchUpdateDayLimit","POST");


        //订单
        urlMap.put("orderReceived", "order/poi_received");
        urlMap.put("orderConfirm", "order/confirm");
        urlMap.put("orderCancel", "order/cancel");
        urlMap.put("orderDelivering","order/delivering");
        urlMap.put("orderArrived","order/arrived");
        urlMap.put("orderRefundAgree","order/refund/agree");
        urlMap.put("orderRefundReject","order/refund/reject");
        urlMap.put("orderSubsidy","order/subsidy");
        urlMap.put("orderViewStatus","order/viewstatus");
        urlMap.put("orderGetActDetailByAcId","order/getActDetailByAcid");
        urlMap.put("orderGetOrderDetail","order/getOrderDetail");
        urlMap.put("orderLogisticsPush","order/logistics/push");
        urlMap.put("orderLogisticsCancel","order/logistics/cancel");
        urlMap.put("orderLogisticsStatus","order/logistics/status");
        urlMap.put("orderGetDaySeq","order/getOrderDaySeq");
        urlMap.put("orderGetOrderIdByDaySeq","order/getOrderIdByDaySeq");
        urlMap.put("orderZhongbaoShippingFee","order/zhongbao/shippingFee");
        urlMap.put("orderZhongbaoDispatch","order/zhongbao/dispatch");
        urlMap.put("orderZhongbaoDispatchPrepare","order/zhongbao/dispatch/prepare"); // 待废弃
        urlMap.put("orderZhongbaoDispatchConfirm","order/zhongbao/dispatch/confirm"); // 待废弃
        urlMap.put("orderZhongbaoUpdateTip","order/zhongbao/update/tip");
        urlMap.put("orderCommentOrder","order/comment/order"); // 已废弃
        urlMap.put("orderCommentAddReply","order/comment/add_reply"); // 已废弃
        urlMap.put("orderGetPartRefundFoods","order/getPartRefundFoods");
        urlMap.put("orderApplyPartRefund","order/applyPartRefund");
        urlMap.put("orderRemindReply","order/remindReply");
        urlMap.put("orderGetSupportedCompensation","order/getSupportedCompensation");
        urlMap.put("orderApplyCompensation","order/applyCompensation");
        urlMap.put("orderGetCompensationResult","order/getCompensationResult");
        urlMap.put("orderBatchPullPhoneNumber","order/batchPullPhoneNumber");
        urlMap.put("orderPreparationMealComplete","order/preparationMealComplete");
        urlMap.put("orderGetPreparationMealTime","order/getPreparationMealTime");
        urlMap.put("orderBatchFetchAbnormalOrder","order/batchFetchAbnormalOrder");
        urlMap.put("orderChangeToPoiSelfShipping","order/logistics/change/poi_self");



        urlTypeMap.put("orderReceived", "GET");
        urlTypeMap.put("orderConfirm", "GET");
        urlTypeMap.put("orderCancel", "GET");
        urlTypeMap.put("orderDelivering","GET");
        urlTypeMap.put("orderArrived","GET");
        urlTypeMap.put("orderRefundAgree","GET");
        urlTypeMap.put("orderRefundReject","GET");
        urlTypeMap.put("orderSubsidy","GET");
        urlTypeMap.put("orderViewStatus","GET");
        urlTypeMap.put("orderGetActDetailByAcId","GET");
        urlTypeMap.put("orderGetOrderDetail","GET");
        urlTypeMap.put("orderLogisticsPush","GET");
        urlTypeMap.put("orderLogisticsCancel","GET");
        urlTypeMap.put("orderLogisticsStatus","GET");
        urlTypeMap.put("orderGetDaySeq","GET");
        urlTypeMap.put("orderGetOrderIdByDaySeq","GET");
        urlTypeMap.put("orderZhongbaoShippingFee","GET");
        urlTypeMap.put("orderZhongbaoDispatch","GET");
        urlTypeMap.put("orderZhongbaoDispatchPrepare","GET"); // 待废弃
        urlTypeMap.put("orderZhongbaoDispatchConfirm","GET"); // 待废弃
        urlTypeMap.put("orderZhongbaoUpdateTip","GET");
        urlTypeMap.put("orderCommentOrder","GET"); // 已废弃
        urlTypeMap.put("orderCommentAddReply","POST"); // 已废弃
        urlTypeMap.put("orderGetPartRefundFoods","GET");
        urlTypeMap.put("orderApplyPartRefund","POST");
        urlTypeMap.put("orderRemindReply","POST");
        urlTypeMap.put("orderGetSupportedCompensation","GET");
        urlTypeMap.put("orderApplyCompensation","POST");
        urlTypeMap.put("orderGetCompensationResult","GET");
        urlTypeMap.put("orderBatchPullPhoneNumber","POST");
        urlTypeMap.put("orderPreparationMealComplete","GET");
        urlTypeMap.put("orderGetPreparationMealTime","GET");
        urlTypeMap.put("orderBatchFetchAbnormalOrder","POST");
        urlTypeMap.put("orderChangeToPoiSelfShipping","POST");


        //图片
        urlMap.put("imageUpload", "image/upload");
        urlTypeMap.put("imageUpload","POST");

    }

    /**
     * 通过方法名生成url
     * @param methodName
     * @return
     */
    public static String genUrlPrefix(String methodName) throws ApiSysException{
        if(urlPrefix.equals("")){
            String env = PropertiesUtil.getEnvironmentMode();
            if("0".equals(env)){
                urlPrefix = "http://test.waimaiopen.meituan.com/api/v1/";
            }else if("1".equals(env)){
                urlPrefix = "http://waimaiopen.meituan.com/api/v1/";
            }else if("2".equals(env)){
                urlPrefix = "http://127.0.0.1:9000/api/v1/";
            }

            String url = PropertiesUtil.getAPIUrl();
            if (StringUtil.isNotBlank(url)) {
                urlPrefix = url;
            }
        }
        return urlPrefix + urlMap.get(methodName);
    }

    public static HttpRoute getRequestUrlRoute() {
        HttpRoute httpRoute = new HttpRoute(new HttpHost("test.waimaiopen.meituan.com"));
        try {
            String requestUrl = genUrlPrefix("");
            URL url = new URL(requestUrl);
            httpRoute = new HttpRoute(new HttpHost(url.getHost(), url.getPort()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return httpRoute;
    }

    /**
     * 获取请求的类型
     * @param methodName
     * @return
     */
    public static String genUrlType(String methodName){
        String methodType = urlTypeMap.get(methodName);

        return methodType;
    }

    public static String genUrlForGenSig(String methodName,Map<String, String> systemParamsMap,
                                              Map<String,String> applicationParamsMap) throws ApiSysException{
        Map<String,String> paramMap = new HashMap<>();
        paramMap.putAll(systemParamsMap);
        //如果应用级参数不为空，则组合应用级参数
        if(applicationParamsMap != null){
            paramMap.putAll(applicationParamsMap);
        }
        String str = concatParams(paramMap);
        String basedUrl = genUrlPrefix(methodName) + "?" + str + systemParamsMap.get("appSecret");
        return basedUrl;
    }

    public static String genOnlyHasSysParamsAndSigUrl(String urlPrefix,Map<String,String> systemParamsMap,String sig){
        String str = concatParams(systemParamsMap);
        String basedUrl = urlPrefix+ "?" + str + "&sig=" + sig;
        return basedUrl;
    }

    public static String genNotOnlySysParamsUrlForGetRequest(String urlPrefix,Map<String,String> systemParamsMap,String sig,Map<String,String> otherParamsMap){
        systemParamsMap.putAll(otherParamsMap);
        String str = concatParams(systemParamsMap);
        String handledUrl = urlPrefix+ "?" + str + "&sig=" + sig;
        return handledUrl;
    }

    public static String genUrlForGetRequest(String urlHasParamsNoSig, String sig) {
        String handledUrl = urlHasParamsNoSig + "&sig=" + sig;
        return handledUrl;
    }

    private static String concatParams(Map<String, String> params2) {
        Object[] key_arr = params2.keySet().toArray();
        Arrays.sort(key_arr);
        String str = "";

        for (Object key : key_arr) {
            if(key.equals("appSecret")){
                continue;
            }
            String val = params2.get(key);
            str += "&" + key + "=" + val;
        }
        return str.replaceFirst("&", "");
    }
}
