package com.sankuai.meituan.waimai.opensdk.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * Created by yujun05 on 2018-02-13.
 */
public class WmAppActFullDiscountItemParam {
    private String act_name;
    private List<String> act_ids;
    private Integer status;
    private Integer quantity;
    private Integer start_time;
    private Integer end_time;

    public String getAct_name() {
        return act_name;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    @JSONField(name = "act_ids")
    public String getActIds() {
        return StringUtils.join(act_ids, ",");
    }

    @JSONField(name = "act_ids")
    public void setActIds(String act_ids) {
        this.act_ids = Lists.newArrayList(StringUtils.split(act_ids, ","));
    }

    @JSONField(serialize = false)
    public List<String> getAct_ids() {
        return act_ids;
    }

    @JSONField(deserialize = false)
    public void setAct_ids(List<String> act_ids) {
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
        return "WmAppActFullDiscountItemParam{" +
                "act_name='" + act_name + '\'' +
                ", act_ids='" + act_ids + '\'' +
                ", status=" + status +
                ", quantity=" + quantity +
                ", start_time=" + start_time +
                ", end_time=" + end_time +
                '}';
    }
}
