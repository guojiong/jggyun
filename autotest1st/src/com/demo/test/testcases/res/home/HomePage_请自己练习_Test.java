package com.demo.test.testcases.res.home; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class HomePage_请自己练习_Test extends BaseParpare{ 
    @Test 
    public void 请自己练习() { 
        SuperAction.parseExcel("jgg/res/testcases/home.xlsx","请自己练习",seleniumUtil);
    }
}