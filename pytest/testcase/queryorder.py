'''
Created on 2019年10月30日

@author: Administrator
'''
import unittest
import requests
from time import sleep

class queryorder(unittest.TestCase):
    
    def test_query_all_nomal(self):
        url = 'http://116.62.211.37:8607/pub/order/queryAllOrder'
        response = requests.post(url=url,data='{"start":0,"limit":100,"userId":"456151205748412416","gmtStart":"2019-10-30","gmtEnd":"2019-10-30"}')
        res_data = response.json()
        
        self.assertEqual(res_data['status'], 200)
        sleep(2)
        
if __name__ == '__main__':
    unittest.main()  
