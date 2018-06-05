package com.sankuai.meituan.waimai.opensdk.vo;


/**
 * Created by yujun05 on 2017/11/15
 * 指定商品满减活动对象
 */
public class WmAppActFullDiscountItem {

    private String act_name;
    private String act_ids;
    private Integer status;
    private Integer quantity;
    private Integer start_time;
    private Integer end_time;

    public WmAppActFullDiscountItem() {

    }

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public String getAct_ids() {
        return act_ids;
    }

    public void setAct_ids(String act_ids) {
        this.act_ids = act_ids;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStart_time() {
        return start_time;
    }

    public void setStart_time(Integer start_time) {
        this.start_time = start_time;
    }

    public Integer getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Integer end_time) {
        this.end_time = end_time;
    }

    @Override
    public String toString() {
        return "WmAppActFullDiscountItem{" +
                "act_name='" + act_name + '\'' +
                ", act_ids='" + act_ids + '\'' +
                ", status=" + status +
                ", quantity=" + quantity +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}
