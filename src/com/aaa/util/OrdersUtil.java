package com.aaa.util;

import java.util.List;
import java.util.Map;

public class OrdersUtil {
	 private int aggregate;
	   private List<Map<String,Object>> trade;
	   public OrdersUtil(List<Map<String,Object>> trade){
	       int aggregate=0;
	       for (Map<String,Object> map:trade) {
	          Object price1= map.get("shopPrice");
	          Object num1= map.get("tradeNum");
	           int price= Integer.valueOf( price1.toString());
	           int num= Integer.valueOf( num1.toString());
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
