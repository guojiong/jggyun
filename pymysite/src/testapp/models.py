from django.db import models
# from django.contrib import admin
# Create your models here.

class UserInfo(models.Model):
    user = models.CharField(max_length=32)
    passwd = models.CharField(max_length=32)