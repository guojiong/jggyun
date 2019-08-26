package com.demo.test.utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import jxl.read.biff.BiffException;

/**
 * 
 * @author xy-incito-wy
 * @Description 自动生成测试代码的工具类，生成指定模块的用例
 *
 */
public class TestCaseFactoryForSingle {
    public static void main(String[] args) {
        //测试代码包路径，如果你的测试代码目录不一样请在这里修改
        final String caseRootFolder = "src/com/demo/test/testcases/";
    	final String caseFolderOrder = "jgg/";
    	final String caseFolderRes = "jgg/res/testcase";
        //功能模块名字
        String filePath = null;

        Map<String, String> fileNames = new HashMap<String, String>();
        getAllFileName(caseFolderOrder, fileNames);
        //TODO 修改为读取定义的用例包检索包下用例 -- 从控制台可以输入
//        Scanner s = new Scanner(System.in); 
//        System.out.println("请输入模块名称（不要按回车键，输入完成之后请再按回车键）："); 
//        functionName = s.nextLine();// 输入模块名字
        
        for (Map.Entry<String, String> entry : fileNames.entrySet()) {
        	filePath = entry.getKey();
        	String sysName = filePath.toString().replace(entry.getValue(), "").substring(4, filePath.indexOf("testcases"));
        	String path = filePath.toString().replace(entry.getValue(), "").substring(filePath.indexOf("testcases") + 9);
        	
        	String caseFolder = caseRootFolder + sysName + path;
        	
        	executeScritp(filePath, caseFolder);
		}

    }
    
    public static void getAllFileName(String path,Map<String, String> fileNames)
    {
        File file = new File(path);
        File [] files = file.listFiles();
        String [] names = file.list();
//        if(names != null)
//        fileName.addAll(Arrays.asList(names));
        for(File a:files)
        {
            if(a.isDirectory())
            {
                getAllFileName(a.getAbsolutePath(),fileNames);
            }else if(!a.getName().contains("Page")){
            	String oldString = a.getPath().substring(0, a.getPath().indexOf("jgg"));
            	fileNames.put(a.getPath().replace(oldString, ""), a.getName());
            }
        }
    }
    
    /**
     * //功能模块名字 functionName
     * //测试代码包路径 caseFolder
     * @param functionName
     * @param caseFolder
     */
    public static void executeScritp(String filePath, String caseFolder) {
    	 //源文件
        File sourceFile = null;
        //sheet的名字
        String sheetName = null;
        String functionName = filePath.substring(filePath.indexOf("testcases") + 10, filePath.indexOf("."));
        //sheet的号码
        int sheetNum = 0;
    	try {
    		functionName = functionName.replaceFirst(
    				functionName.substring(0, 1),
    				functionName.substring(0, 1).toLowerCase());
    		// 如果包名不存在，就新建
    		File functionPackage = new File(caseFolder + "/" + functionName);
    		if (functionPackage.exists()) {
    			System.out.println(functionName + "包已经存在，自动跳过！");
    			System.out.println("正在生成用例到" + functionName + "包下，请稍等...");
    		} else {
    			functionPackage.mkdirs();
    			System.out.println(functionName + "包已创建！");
    			System.out.println("正在生成用例到" + functionName + "包下，请稍等...");
    		}
    		
//    		int sheetCount = getSheetNum(filePath);
    		String path = getExcelRelativePath(filePath);
    		sheetNum = getSheetNum(path);
    		for (int j = 0; j < sheetNum; j++) { // 根据传入的模块文件路径获得模块中sheet数量 也就是用例个数
    			
    			if (j == sheetNum - 1) {
    				//如果只有一个sheet的时候（只有Value的情况下），跳出循环不进行自动生成代码操作，因为没有可以生成的。
    				break;
    			}
    			try {
    				sheetName = getSheetName(j + 1, path); // 取得sheetName，由于第一个sheet是values，所以从j+1开始
    				
    			} catch (BiffException e1) {
    				e1.printStackTrace();
    			}
    			sourceFile = new File(caseFolder
    					+ functionName.toLowerCase()
    					+ File.separator
    					+ functionName.replaceFirst(functionName.substring(
    							0, 1), functionName.substring(0, 1)
    							.toUpperCase()) + "Page_" + sheetName
    					+ "_Test.java");// 创建测试用例源码，指定存放路径
    			FileWriter writer = new FileWriter(sourceFile);
    			
    			// 生成测试用例代码的头文件
    			String packagePath = new File(caseFolder
    					+ functionName.toLowerCase()).getPath();
    			writer.write("package "
    					+ packagePath.substring(packagePath.indexOf("src\\")+4).replace("\\", ".")
    					+ "; \n\n"
    					+ "import org.testng.annotations.Test; \n"
    					+ "import com.demo.test.base.BaseParpare; \n"
    					+ "import com.demo.test.utils.SuperAction; \n\n"
    					+ "public class "
    					+ functionName.replaceFirst(functionName.substring(
    							0, 1), functionName.substring(0, 1)
    							.toUpperCase()) + "Page_" + sheetName
    					+ "_Test extends BaseParpare{ \n");
    			
    			// @Test的主体部分，也就是测试用例的方法
    			String firstLetter = sheetName.substring(
    					sheetName.indexOf("_") + 1).substring(0, 1);
    			String others = sheetName.substring(
    					sheetName.indexOf("_") + 1).substring(1);
    			String function = firstLetter.toLowerCase() + others;
    			writer.write("    @Test \n"
    					+ "    public void"
    					+ " "
    					+ function
    					+ "() { \n"
    					+ "        SuperAction.parseExcel(\""
    					+ filePath.replace("\\", "/") + "\",\"" + sheetName
    					+ "\",seleniumUtil);\n" + "    }\n");
    			
    			// 代码结尾大括号
    			writer.write("}");
    			writer.close();
    		}
    	} catch (IOException e) {
    		Assert.fail("IO异常", e);
    	}
    	System.out.println("模块[" + functionName + "] 的用例已经生成完毕，共计："
    			+ (sheetNum - 1) + "条，请到" + caseFolder
    			+ functionName.toLowerCase() + "路径下查阅！");
    	
    }


    /**
     * 获得excel的相对路径
     * 
     * @param 循环模块名称的角标
     * @return 得到对应index的模块名字
     */
    public static String getExcelRelativePath(String filePath) {
//        String dir = "jgg/order/testcase";
        String path = "";
        // get file list where the path has
//        File file = new File(dir+File.separator+functionName+".xlsx");
        // get the folder list
        File file = new File(filePath); 
        path = file.getPath();
        return path;
    }

    /**
     * 获得当前excel的sheet数量 - 每个模块的用例数
     * 
     * @param filePath
     *            文件路径
     * @return 获得excel的sheet数量
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static int getSheetNum(String filePath)
            throws FileNotFoundException, IOException {
        int casesNum = 0;
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(
                filePath)));
        casesNum = workbook.getNumberOfSheets();

        return casesNum;
    }

    /**
     * 
     * @param sheetIndex
     *            sheet的位置
     * @param filePath
     *            excel文件路径相对的
     * @return 返回sheet的名字
     * @throws BiffException
     * @throws IOException
     */
    public static String getSheetName(int sheetIndex, String filePath)
            throws BiffException, IOException {
        String casesName = "";
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
        casesName = workbook.getSheetName(sheetIndex);

        return casesName;

    }

}
