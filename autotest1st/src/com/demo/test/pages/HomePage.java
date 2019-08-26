package com.demo.test.pages;

import org.openqa.selenium.By;

/**
 * @description 首页面元素定位声明
 * */
public class HomePage {
	
	/**用户名显示区域*/
	public static final By HP_TEXT_USERNAME= By.xpath("//span[@class='action___1lZ-_ ant-dropdown-trigger']/span[2]");
	/**子系统名称*/
	public static final By HP_TEXT_SYSTEMNAME = By.xpath("//div[@class='subSystem___25ZKl']");
	/**首页文本*/
	public static final By HP_TEXT_HOMECONTENTS = By.xpath("//div[@class='ant-tabs-tabpane ant-tabs-tabpane-active']/div[2]");
}
