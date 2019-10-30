'''
Created on 2019年10月30日

@author: Administrator
'''
import requests
import unittest
class login(unittest.TestCase):
    def test_login_nomal(self,ldata):
        headers = \
        {
            "Content-Type": "application/json;charset=UTF-8"
        }
        load = 'http://116.62.211.37:8605/login'
        response = requests.post(url=load,headers=headers,data='{"username":"18200455856","password":"By5tm3e172srsc5227ranMKTVVoHPs"}')
        res_data = response.json()
        print(res_data)
        assert res_data['status']==200
if __name__ == '__main__':
    
    ldata = '{"username":"18200455856","password":"By5tm3e172srsc5227ranMKTVVoHPs"}'
    login().test_login_nomal(ldata)