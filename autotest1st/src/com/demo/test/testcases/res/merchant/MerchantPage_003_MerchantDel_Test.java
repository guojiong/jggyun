package com.demo.test.testcases.res.merchant; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class MerchantPage_003_MerchantDel_Test extends BaseParpare{ 
    @Test 
    public void merchantDel() { 
        SuperAction.parseExcel("jgg/res/testcases/merchant.xlsx","003_MerchantDel",seleniumUtil);
    }
}