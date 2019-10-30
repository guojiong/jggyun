package com.demo.test.testcases.res.merchant; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class MerchantPage_002_MerchantEdit_Test extends BaseParpare{ 
    @Test 
    public void merchantEdit() { 
        SuperAction.parseExcel("jgg/res/testcases/merchant.xlsx","002_MerchantEdit",seleniumUtil);
    }
}