package com.demo.test.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.log4j.Logger;
import org.testng.Assert;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

/**
 * @description: 读取Excel数据<br>
 *               说明：<br>
 *               Excel放在Data文件夹下<br>
 *               Excel命名方式：测试类名.xls<br>
 *               Excel的sheet命名方式：测试方法名<br>
 *               Excel第一行为Map键值<br>
 */
public class ExcelDataProvider implements Iterator<Object[]>{
	public static Logger logger = Logger.getLogger(ExcelDataProvider.class.getName());
	private String path = null;
	private FileInputStream inputStream = null;
	private Workbook book = null;
	private Sheet sheet = null;
	private int rowNum = 0;
	private int columnNum = 0;
	private String[] columnName;
	private int currentRowNo = 0;

	/**
     * @description 
     * 2个参数：<br>
     * moduleName - 模块的名称
     * caseNum - 测试用例编号
     */
	public ExcelDataProvider(String moduleName, String caseNum) {
		try {
			path = "data/" + moduleName + ".xls";
			inputStream = new FileInputStream(path);
			book = Workbook.getWorkbook(inputStream);
			
			sheet = book.getSheet(caseNum);//取得sheet
			rowNum = sheet.getRows(); //获取sheet中所有行
			Cell[] cell = sheet.getRow(0);//第一行所有单元格
			columnNum = cell.length;//单元格的个数 值 赋给 列数
			columnName = new String[cell.length];//开辟 列名的大小
			
			for (int i = 0; i < cell.length; i++) {
				columnName[i] = cell[i].getContents().toString(); //第一行的值，被赋予为列名
			}
			
			this.currentRowNo ++;
		} catch (FileNotFoundException e) {
			logger.error("没有找到指定的文件：" + "[" + path + "]");
            Assert.fail("没有找到指定的文件：" + "[" + path + "]");
		} catch (Exception e) {
			logger.error("不能读取文件： [" + path + "]",e);
            Assert.fail("不能读取文件： [" + path + "]");
		}
	}

	/**是否还有下个内容*/
	public boolean hasNext() {
		if(this.rowNum == 0 || this.currentRowNo >= this.rowNum) {
			try {
				inputStream.close();
				book.close();
			}catch (Exception e) {
				e.printStackTrace();
			}
			return false;
		}else {
			//sheet 下一行内容为空判定结束
			if("".equals((sheet.getRow(currentRowNo))[0].getContents())) {
				return false;
			}
			return true;
		}
	}

	/**返回内容*/
	public Object[] next() {
		Cell[] c = sheet.getRow(this.currentRowNo);
		Map<String, String> data = new HashMap<String, String>();
		for (int i = 0; i < this.columnNum; i++) {
			String temp = "";
			
			try {
				temp = c[i].getContents().toString();
			}catch (ArrayIndexOutOfBoundsException e) {
				temp = "";
			}
			
			data.put(this.columnName[i], temp);
		}
		Object object[] = new Object[1];
		object[0] = data;
		this.currentRowNo++;
		return object;
	}
	
	@Override
	public void remove() {
		throw new UnsupportedOperationException("remove unsupported.");
	}
}
