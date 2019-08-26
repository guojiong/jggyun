package com.demo.test.testcases.res.merchant; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class MerchantPage_001_MerchantSuccessFunction_Test extends BaseParpare{ 
    @Test 
    public void merchantSuccessFunction() { 
        SuperAction.parseExcel("jgg/res/testcases/merchant.xlsx","001_MerchantSuccessFunction",seleniumUtil);
    }
}