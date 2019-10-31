'''
Created on 2019年10月30日

@author: Administrator
'''
import unittest
import requests
from time import sleep
from testcase.login import Login

class queryorder(unittest.TestCase):
    
    ldata = \
    {
        "username":"18200455856",
        "password":"By5tm3e172srsc5227ranMKTVVoHPs"
    }
    authorization = Login().getToken(ldata)
    headers = \
    {
        "Content-Type": "application/json;charset=UTF-8",
        "Authorization": authorization
    }
    url = 'http://qyt1902.jggyun.com:8607/pub/order/queryAllOrder'
    #测试全部订单查询，条件查询：
    """{"start":0,
    "limit":100,
    "userId":"456151205748412416",
    "gmtStart":"2019-10-30",
    "gmtEnd":"2019-10-30"}
    """
    def test_query_all_nomal(self):
        response = requests.post(url=self.url,
                                 headers=self.headers,
                                 data='''{"start":0,
                                        "limit":100,
                                        "userId":"444085471392305152",
                                        "orgId":"196598702835761178",
                                        "gmtStart":"2019-10-30",
                                        "gmtEnd":"2019-10-30"}''')
        res_data = response.json()
        print(res_data['result']['total'])
        self.assertEqual(res_data['status'], 200)
        sleep(2)
    
    # 测试全部订单查询，根据订单编号查询：订单编号为空
    '''{"start":0,
    "limit":100,
    "userId":"456151205748412416",
    "orderNo":""
    }
    '''    
    def test_query_by_orderNo_null(self):
        response = requests.post(url=self.url,
                                 headers=self.headers,
                                 data='''{"start":0,
                                         "limit":100,
                                         "userId":"444085471392305152",
                                         "orderNo":""}''')
        res_data = response.json()
        print(res_data['result']['total'])
        assert res_data['result']['total']==0
        self.assertEqual(res_data['status'], 200)
        sleep(2)
    
    # 测试全部订单查询，根据订单编号查询：订单编号为空
    '''{"start":0,
    "limit":100,
    "userId":"456151205748412416",
    "orderNo":"1572450223229937141"
    }
    '''        
    def test_query_by_orderNo_nomal(self):
        response = requests.post(url=self.url,
                                 headers=self.headers,
                                 data='''{"start":0,
                                         "limit":100,
                                         "userId":"444085471392305152",
                                         "orderNo":"1572450223229937141"}''')
        res_data = response.json()
        print(res_data['result']['total'])
        assert res_data['result']['total']==1
        self.assertEqual(res_data['status'], 200)
        sleep(2)    
if __name__ == '__main__':
    unittest.main()  
