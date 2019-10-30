'''
Created on 2019年10月16日

@author: Administrator
'''
import unittest
import time
import HTMLTestRunner

#指定测试用例与报告的位置
test_Dir = ''
report_Dir = ''

#加载测试用例
discover = unittest.defaultTestLoader.discover(test_Dir, pattern='testcase/queryorder.py')
# s = unittest.TestSuite()  # 实例化
#     s.addTests(unittest.TestLoader().loadTestsFromTestCase(make))  # 加载用例
#定义报告的的文件格式
now = time.strftime("%y-%m-%d %H-%M-%S")
# report_name = report_Dir+'/'+'test_report.html'
report_name = 'report/' + 'test_report_' + now +'.html'

#执行测试用例生成测试报告
with open(report_name, 'wb') as f:
    runner=HTMLTestRunner.HTMLTestRunner(
        stream=f,title="Weather API Test Report",
        description="China City Weather Test Report", tester="GJ")
    runner.run(discover)
