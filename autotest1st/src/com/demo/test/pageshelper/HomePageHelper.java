package com.demo.test.pageshelper;

import org.apache.log4j.Logger;
import com.demo.test.pages.HomePage;
import com.demo.test.utils.SeleniumUtil;

/**
 * @desciption 首页帮助类：专门提供在这个页面进行操作的方法封装
 */
public class HomePageHelper {
	// 提供本类中日志输出对象
	public static Logger logger = Logger.getLogger(HomePageHelper.class);

	/**
	 * @author Young
	 * @description 等待首页元素加载
	 * @param seleniumUtil
	 *            selenium api封装引用对象
	 * @param timeOut
	 *            等待元素超时的时间
	 * */
	public static void waitHomePageLoad(SeleniumUtil seleniumUtil, int timeOut) {
		logger.info("开始等待首页元素加载");
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_SYSTEMNAME);
		seleniumUtil.waitForElementToLoad(timeOut, HomePage.HP_TEXT_USERNAME);
		logger.info("首页元素加载完毕");

	}

	/**
	 * @Description 登录成功之后验证用户名是不是正确的
	 * */
	public static void checkUserName(SeleniumUtil seleniumUtil, int timeOut,
			String username) {
		logger.info("开始检查用户名是不是：" + username);
		seleniumUtil.isTextCorrect(
				seleniumUtil.getText(HomePage.HP_TEXT_USERNAME), username);
		logger.info("用户名检查完毕,用户名是：" + username);

	}

	/**
	 * @description 登录成功之后验证首页的文本内容
	 * */
	public static void checkHomeText(SeleniumUtil seleniumUtil) {
		seleniumUtil
				.isTextCorrect(
						seleniumUtil.getText(HomePage.HP_TEXT_HOMECONTENTS),
						"玖宫格管理平台默认页面");

	}

}
