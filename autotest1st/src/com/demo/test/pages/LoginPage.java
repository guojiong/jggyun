package com.demo.test.pages;

import org.openqa.selenium.By;
/**
 * @description 登录页面元素定位声明
 * */
public class LoginPage {
    /**用户名输入框*/
    public static final By LP_INPUT_USERNAME = By.id("userName");
    
    /**密码输入框*/
    public static final By LP_INPUT_PASSWORD = By.id("password");
    
    /**登录按钮*/
    public static final By LP_BUTTON_LOGIN = By.xpath("//button[@type='submit']");
    
    /**登录错误信息*/
    public static final By LP_TEXT_ERROR= By.xpath("//span[@class='ant-alert-message']");
    
    /**验证码*/
    public static final By LP_INPUT_VCODE = By.xpath("//input[@placeholder='请输入验证码']");
    
}
