package com.aaa.util;

import java.util.List;
import java.util.Map;

public class ImputedPriceUtil {
   private int aggregate;
   private List<Map<String,Object>> trade;
   public ImputedPriceUtil(List<Map<String,Object>> trade){
       int aggregate=0;
       for (Map<String,Object> map:trade) {
           String price1= (String) map.get("price");
           String num1= (String) map.get("num");
           int price= Integer.valueOf( price1);
           int num= Integer.valueOf( num1);
           int subtotal= (int) (price*num);
           aggregate+=subtotal;
           map.put("subtotal",subtotal);
       }
       this.aggregate=aggregate;
       this.trade=trade;
   }
    public int getAggregate() {
        return aggregate;
    }
    public List<Map <String,Object>> getTrade() {
        return trade;
    }
}