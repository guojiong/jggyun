'''
Created on 2019年10月30日

@author: Administrator
'''
import requests
import unittest

class Login(unittest.TestCase):
    def login_nomal(self,ldata):
        headers = \
        {
            "Content-Type": "application/json;charset=UTF-8"
        }
        load = 'http://qyt1902.jggyun.com:8605/login'
        response = requests.post(url=load,headers=headers,data='{"username":"18200455856","password":"By5tm3e172srsc5227ranMKTVVoHPs"}')
        res_data = response.json()
        return res_data
    
    def getToken(self, ldata):
        res_data = self.login_nomal(ldata)
        token = 'Bearer ' + res_data['token'] 
        return token
        
#     def test_login_nomal(self, ldata):
#         res_data = self.login_nomal(ldata)
#         assert res_data['status']==200
        
if __name__ == '__main__':
    ldata = '{"username":"18200455856","password":"By5tm3e172srsc5227ranMKTVVoHPs"}'
    print(Login().getToken(ldata))