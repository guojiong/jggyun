from django.db import models

# Create your models here.
class Category(models.Model):
    """分类"""
    name=models.CharField(max_length=100)

class Tag(models.Model):
    """标签"""
    name=models.CharField(max_length=100)
    
class Post(models.Model):
    """文章"""
    title=models.CharField(max_length=100)
    body=models.TextField()
    create_time=models.DateTimeField()
    modified_time=models.DateTimeField()
    excerpt=models.CharField(max_length=200, blank=True) # 文章摘要，可为空
    category=models.ForeignKey(Category, on_delete=models.SET(True)) # ForeignKey表示1对多（多个post对应1个category）
    tag=models.ManyToManyField(Tag, blank=True)
    views=models.PositiveIntegerField(default=0)  # 阅读量
    
class TestCase():
    id=models.CharField(max_length=32)
    CaseName=models.CharField(max_length=128)
    
class TestStep():
    id=models.CharField(max_length=32)
    TestCaseId=models.ForeignKey(TestCase, blank=False)
    StepName=models.CharField(max_length=128)
    
class TestSuite():
    id=models.CharField(max_length=32)
    SuiteName=models.CharField(max_length=128)
    
class CaseToSuite():
    id=models.CharField(max_length=32)
    TestCaseId=models.ForeignKey(TestCase, blank=False)
    TestSuiteId=models.ForeignKey(TestSuite, blank=False)
    
class TestReport():
    id=models.CharField(max_length=32)
    ReportName=models.CharField(max_length=128)
    