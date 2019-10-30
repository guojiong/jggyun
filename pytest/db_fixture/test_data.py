'''
Created on 2019年10月30日

@author: Administrator
'''
import sys
sys.path.append('../db_fixture')

try:
    from mysql_db import DB
except ImportError:
    from .mysql_db import DB

# create data
datas = {
    'testmodel_test':[
        {'id':1, 'name':'one'},
        {'id':2, 'name':'two'},
        {'id':3, 'name':'three'},
        {'id':4, 'name':'four'},
        ],
    }

# Inster table datas
def init_data():
    DB().init_data(datas)
    
if __name__ == '__main__':
    init_data()