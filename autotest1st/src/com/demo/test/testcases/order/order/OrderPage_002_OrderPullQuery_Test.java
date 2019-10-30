package com.demo.test.testcases.order.order; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class OrderPage_002_OrderPullQuery_Test extends BaseParpare{ 
    @Test 
    public void orderPullQuery() { 
        SuperAction.parseExcel("jgg/order/testcases/Order.xlsx","002_OrderPullQuery",seleniumUtil);
    }
}