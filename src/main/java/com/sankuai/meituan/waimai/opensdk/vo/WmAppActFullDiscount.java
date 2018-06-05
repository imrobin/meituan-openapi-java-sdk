package com.sankuai.meituan.waimai.opensdk.vo;

import java.util.List;

/**
 * Created by yujun05 on 2018-02-07.
 * 指定商品满减活动对象
 */
public class WmAppActFullDiscount {

    private String app_poi_code;
    private WmAppActFullDiscountItem act_info;
    private List<ActDiscountParam> act_details; //调用接口时，入参：满减层级
    private String act_remark;//满减层级，查询返回值，例：满10减1，满20减2
    private String app_food_codes;
    private List<ActDiscountParam> app_foods;

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public WmAppActFullDiscountItem getAct_info() {
        return act_info;
    }

    public void setAct_info(WmAppActFullDiscountItem act_info) {
        this.act_info = act_info;
    }

    public String getApp_food_codes() {
        return app_food_codes;
    }

    public void setApp_food_codes(String app_food_codes) {
        this.app_food_codes = app_food_codes;
    }

    public List<ActDiscountParam> getAct_details() {
        return act_details;
    }

    public void setAct_details(List<ActDiscountParam> act_details) {
        this.act_details = act_details;
    }

    public List<ActDiscountParam> getApp_foods() {
        return app_foods;
    }

    public void setApp_foods(List<ActDiscountParam> app_foods) {
        this.app_foods = app_foods;
    }

    public String getAct_remark() {
        return act_remark;
    }

    public void setAct_remark(String act_remark) {
        this.act_remark = act_remark;
    }

    @Override
    public String toString() {
        return "WmAppActFullDiscount{" +
                "app_poi_code='" + app_poi_code + '\'' +
                ", act_info=" + act_info +
                ", act_details=" + act_details +
                ", act_remark='" + act_remark + '\'' +
                ", app_food_codes='" + app_food_codes + '\'' +
                ", app_foods=" + app_foods +
                '}';
    }
}
