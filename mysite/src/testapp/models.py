from django.db import models
# from django.contrib import admin
# Create your models here.

class UserInfo(models.Model):
    user = models.CharField(max_length=32)
    passwd = models.CharField(max_length=32)
    
class TestCase(models.Model):
    id=models.CharField(primary_key=True, max_length=32)
    CaseName=models.CharField(max_length=128)
    
class TestStep(models.Model):
    id=models.CharField(primary_key=True, max_length=32)
    TestCaseId=models.ForeignKey(TestCase, on_delete=models.SET(True))
    StepName=models.CharField(max_length=128)
    
class TestSuite(models.Model):
    id=models.CharField(primary_key=True, max_length=32)
    SuiteName=models.CharField(max_length=128)
    
class CaseToSuite(models.Model):
    id=models.CharField(primary_key=True, max_length=32)
    TestCaseId=models.ManyToManyField(TestCase, blank=True)
    TestSuiteId=models.ManyToManyField(TestSuite, blank=True)
    
class TestReport(models.Model):
    id=models.CharField(primary_key=True, max_length=32)
    ReportName=models.CharField(max_length=128)