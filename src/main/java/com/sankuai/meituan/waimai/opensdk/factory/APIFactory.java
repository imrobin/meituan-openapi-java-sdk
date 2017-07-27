package com.sankuai.meituan.waimai.opensdk.factory;

import com.sankuai.meituan.waimai.opensdk.api.*;

/**
 * Created by yangzhiqi on 15/10/15.
 * 接口工厂
 */
public class APIFactory {

    private static PoiAPI poiAPI = new PoiAPI();
    private static ShippingAPI shippingAPI= new ShippingAPI();
    private static FoodAPI foodAPI = new FoodAPI();
    private static OrderAPI orderAPI = new OrderAPI();
    private static MedicineAPI medicineAPI = new MedicineAPI();
    private static ImageApi imageApi = new ImageApi();

    public static FoodAPI getFoodAPI() {
        return foodAPI;
    }

    public static ImageApi getImageApi() {
        return imageApi;
    }

    public static MedicineAPI getMedicineAPI() {
        return medicineAPI;
    }

    public static OrderAPI getOrderAPI() {
        return orderAPI;
    }

    public static PoiAPI getPoiAPI() {
        return poiAPI;
    }

    public static ShippingAPI getShippingAPI() {
        return shippingAPI;
    }
}
