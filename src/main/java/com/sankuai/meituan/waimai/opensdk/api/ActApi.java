package com.sankuai.meituan.waimai.opensdk.api;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.sankuai.meituan.waimai.opensdk.constants.ParamRequiredEnum;
import com.sankuai.meituan.waimai.opensdk.exception.ApiOpException;
import com.sankuai.meituan.waimai.opensdk.exception.ApiSysException;
import com.sankuai.meituan.waimai.opensdk.vo.ActDiscountParam;
import com.sankuai.meituan.waimai.opensdk.vo.SystemParam;
import com.sankuai.meituan.waimai.opensdk.vo.WmAppActFullDiscount;
import com.sankuai.meituan.waimai.opensdk.vo.WmAppActFullDiscountItemParam;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yujun05 on 2017-12-29.
 */
public class ActApi extends API {

    /**
     * 批量创建/更新折扣商品
     *
     * @param systemParam       系统参数
     * @param appPoiCode        三方门店ID
     * @param actDiscountParams 批量创建/更新折扣商品数据
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String actDiscountBatchSave(SystemParam systemParam, String appPoiCode, List<ActDiscountParam> actDiscountParams) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("act_data", JSON.toJSONString(actDiscountParams));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActDiscountBatchSave);
        return requestApi(methodName, systemParam, applicationParamsMap, true);
    }

    /**
     * 批量删除折扣商品
     *
     * @param systemParam  系统参数
     * @param appPoiCode   三方门店ID
     * @param appFoodCodes APP方商品id，删除商品数量上限为100，如果删除门店多个商品的折扣活动，用英文逗号隔开。
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String actDiscountDelete(SystemParam systemParam, String appPoiCode, String appFoodCodes) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("app_food_codes", appFoodCodes);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActDiscountDelete);
        return requestApi(methodName, systemParam, applicationParamsMap, true);
    }

    /**
     * 批量修改折扣商品当日活动库存
     *
     * @param systemParam       系统参数
     * @param appPoiCode        三方门店ID
     * @param actDiscountParams 修改库存数据，数量上限为200
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String actDiscountStock(SystemParam systemParam, String appPoiCode, List<ActDiscountParam> actDiscountParams) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("act_data", JSON.toJSONString(actDiscountParams));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActDiscountStock);
        return requestApi(methodName, systemParam, applicationParamsMap, true);
    }

    /**
     * 批量查询门店折扣商品
     *
     * @param systemParam 系统参数
     * @param appPoiCode  三方门店ID
     * @param offset      分页查询偏移量
     * @param limit       分页查询，每页查询的数量不大于200
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public List<ActDiscountParam> actDiscountList(SystemParam systemParam, String appPoiCode, int offset, int limit) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("offset", String.valueOf(offset));
        applicationParamsMap.put("limit", String.valueOf(limit));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActDiscountList);
        String data = requestApi(methodName, systemParam, applicationParamsMap);
        return JSONArray.parseArray(data, ActDiscountParam.class);
    }

    /**
     * 修改门店每单折扣商品限购数量
     *
     * @param systemParam        系统参数
     * @param appPoiCode         三方门店ID
     * @param activityOrderLimit 本门店每单可购买的折扣商品数量
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String actDiscountActivityOrderLimit(SystemParam systemParam, String appPoiCode, int activityOrderLimit) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("activity_order_limit", String.valueOf(activityOrderLimit));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActDiscountActivityOrderLimit);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 批量创建指定商品满减活动
     *
     * @param systemParam 系统参数
     * @param appPoiCode  三方门店ID
     * @param actInfo     活动信息
     * @param actDetails  活动详情-层级
     * @param appFoods    活动商品
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String actFullDiscountBatchSave(SystemParam systemParam, String appPoiCode, WmAppActFullDiscountItemParam actInfo, List<ActDiscountParam> actDetails, List<ActDiscountParam> appFoods) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("act_info", JSON.toJSONString(actInfo));
        applicationParamsMap.put("act_details", JSON.toJSONString(actDetails));
        applicationParamsMap.put("app_foods", JSON.toJSONString(appFoods));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActFullDiscountBatchSave);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 批量查询指定商品满减活动
     *
     * @param systemParam 系统参数
     * @param appPoiCode  三方门店ID
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public List<WmAppActFullDiscount> fullDiscountList(SystemParam systemParam, String appPoiCode) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActFullDiscountList);
        String data = requestApi(methodName, systemParam, applicationParamsMap);
        return JSONArray.parseArray(data, WmAppActFullDiscount.class);
    }

    /**
     * 批量删除指定商品满减活动
     * @param systemParam 系统参数
     * @param appPoiCode  三方门店ID
     * @param actIds 活动id
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String fullDiscountDelete(SystemParam systemParam, String appPoiCode, List<String> actIds) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("act_ids", StringUtils.join(actIds, ","));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActFullDiscountDelete);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 批量添加活动商品至指定商品满减活动
     *
     * @param systemParam 系统参数
     * @param appPoiCode  三方门店ID
     * @param actId       活动id
     * @param appFoods    商品
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String fullDiscountFoodsBatchSave(SystemParam systemParam, String appPoiCode, String actId, List<ActDiscountParam> appFoods) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("act_id", actId);
        applicationParamsMap.put("app_foods", JSON.toJSONString(appFoods));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActFullDiscountFoodsBatchSave);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 批量查询指定商品满减活动中的活动商品
     *
     * @param systemParam 系统参数
     * @param appPoiCode  三方门店ID
     * @param act_id      活动id
     * @param offset      分页查询偏移量
     * @param limit       分页查询，每页查询的数量不大于200
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public WmAppActFullDiscount fullDiscountFoodsList(SystemParam systemParam, String appPoiCode, String act_id, Integer offset, Integer limit) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("actId", act_id);
        applicationParamsMap.put("offset", String.valueOf(offset));
        applicationParamsMap.put("limit", String.valueOf(limit));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActFullDiscountFoodsList);
        String data = requestApi(methodName, systemParam, applicationParamsMap);
        return JSON.parseObject(data, WmAppActFullDiscount.class);
    }

    /**
     * 批量删除活动商品至指定商品满减活动
     *
     * @param systemParam 系统参数
     * @param appPoiCode  三方门店ID
     * @param actId       活动id
     * @param appFoods    商品
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String fullDiscountFoodsDelete(SystemParam systemParam, String appPoiCode, String actId, List<String> appFoods) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("act_id", actId);
        applicationParamsMap.put("app_foods", StringUtils.join(appFoods, ","));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActFullDiscountFoodsDelete);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }

    /**
     * 批量修改指定商品满减活动中商品的当日活动库存
     *
     * @param systemParam 系统参数
     * @param appPoiCode  三方门店ID
     * @param actId       活动id
     * @param appFoods    商品
     * @return
     * @throws ApiOpException
     * @throws ApiSysException
     */
    public String fullDiscountFoodsBatchUpdateDayLimit(SystemParam systemParam, String appPoiCode, String actId, List<ActDiscountParam> appFoods) throws ApiOpException, ApiSysException {
        String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
        //组织应用级参数
        Map<String, String> applicationParamsMap = new HashMap<>();
        applicationParamsMap.put("app_poi_code", appPoiCode);
        applicationParamsMap.put("act_id", actId);
        applicationParamsMap.put("app_foods", JSON.toJSONString(appFoods));
        beforeMethod(systemParam, applicationParamsMap, ParamRequiredEnum.ActFullDiscountFoodsBatchUpdateDayLimit);
        return requestApi(methodName, systemParam, applicationParamsMap);
    }

}
