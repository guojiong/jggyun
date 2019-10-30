'''
Created on 2019年10月30日

@author: Administrator
'''
import pymysql
import configparser as cparser
import os

# ========reading db_config.ini setting=========
base_dir = str(os.path.dirname(os.path.dirname(__file__)))
base_dir = base_dir.replace('\\', '/')
file_path = base_dir + '/db_config.ini'

cf = cparser.ConfigParser()

cf.read(file_path)
host = cf.get('DataBase', 'host')
port = cf.get('DataBase', 'port')
user = cf.get('DataBase', 'user')
password = cf.get('DataBase', 'password')
db = cf.get('DataBase', 'db')

# ============mysql base operating==============
class DB:
    def __init__(self):
        try:
            self.conn = pymysql.connect(host=host, 
                                        port=int(port), 
                                        user=str(user), 
                                        passwd=password, 
                                        db=db, 
                                        charset='utf8',
                                        cursorclass=pymysql.cursors.DictCursor)
        except pymysql.err.OperationalError as e:
            print("Mysql Error %d: %s" % (e.args[0], e.args[1]))
    
    # clear table data
    def clear(self, table_name):
        real_sql = "delete from " + table_name + ";"
        with self.conn.cursor() as cursor:
            cursor.execute("SET FOREIGN_KEY_CHECKS=0")
            cursor.execute(real_sql)
        self.conn.commit()
        
    # insert sql statement, table_data format json
    def insert(self, table_name, table_data):
        for key in table_data:
            table_data[key] = "'" + str(table_data[key]) + "'"
        key = ','.join(table_data.keys())
        value = ','.join(table_data.values())
        real_sql = "INSERT INTO " + table_name + "(" + key + ") VALUES (" + value + ")"
        print(real_sql)
        with self.conn.cursor() as cursor:
            cursor.execute(real_sql)
        self.conn.commit()
    
    # close database
    def close(self):
        self.conn.close()
    
    # init data
    def init_data(self, datas):
        for table, data in datas.items():
            self.clear(table)
            for d in data:
                self.insert(table, d)
        self.close()

if __name__ == '__main__':
    db = DB()
    table_name = "testmodel_test"
    data = {'id':1, 'name':'one'}
    db.clear(table_name)
    db.insert(table_name, data)
    db.close()
