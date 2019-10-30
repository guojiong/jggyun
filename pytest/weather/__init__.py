'''
Created on 2019年10月16日

@author: Administrator
'''
import unittest
import requests
from time import sleep

class Test(unittest.TestCase):

#     def testName(self):
#         #print('天气查询接口测试')
#         pass
    
    #正常查询长沙的天气，断言
    def test_weather_changsa(self):
        print('开始测试：正常查询长沙的天气')
        res = requests.get('http://t.weather.sojson.com/api/weather/city/101250101')
        res_data = res.json()
        #断言
        self.assertEqual(res_data['status'], 200)
        self.assertEqual(res_data['message'], 'success感谢又拍云(upyun.com)提供CDN赞助')
        self.assertEqual(res_data['cityInfo']['city'], '长沙市')
        print('pass')
        sleep(2)
    
    #不传citycode，断言
    def test_weather_no_reference(self):
        print('开始测试：不传citycode')
        res = requests.get('http://t.weather.sojson.com/api/weather/city/')
        res_data = res.json()
        #断言
        self.assertEqual(res_data['status'], 404)
        self.assertEqual(res_data['message'], 'Request resource not found.')
        print('pass')
        sleep(2)
    
    #传入一个不存在的citycode，断言
    def test_weather_reference_error(self):
        print('开始测试：传入一个不存在的citycode')
        res = requests.get('http://t.weather.sojson.com/api/weather/city/101230100')
        res_data = res.json()
        #断言
        self.assertEqual(res_data['status'], 400)
        self.assertEqual(res_data['message'], '获取失败1')
        print('pass')
        sleep(2)

if __name__ == "__main__":
    #import sys;sys.argv = ['', 'Test.testName']
    unittest.main()