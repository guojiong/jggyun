package com.demo.test.testcases.res.login; 

import org.testng.annotations.Test; 
import com.demo.test.base.BaseParpare; 
import com.demo.test.utils.SuperAction; 

public class LoginPage_001_LoginSuccessFunction_Test extends BaseParpare{ 
    @Test 
    public void loginSuccessFunction() { 
        SuperAction.parseExcel("jgg/res/testcases/login.xlsx","001_LoginSuccessFunction",seleniumUtil);
    }
}