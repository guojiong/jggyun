package com.demo.test.testcases.order.order; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class OrderPage_001_OrderPull_Test extends BaseParpare{ 
    @Test 
    public void orderPull() { 
        SuperAction.parseExcel("jgg/order/testcases/Order.xlsx","001_OrderPull",seleniumUtil);
    }
}