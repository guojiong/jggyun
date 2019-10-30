package com.demo.test.testcases.res.merchant; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class MerchantPage_001_MerchantAdd_Test extends BaseParpare{ 
    @Test 
    public void merchantAdd() { 
        SuperAction.parseExcel("jgg/res/testcases/merchant.xlsx","001_MerchantAdd",seleniumUtil);
    }
}