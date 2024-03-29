# Generated by Django 3.0 on 2019-12-11 00:57

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
        ('Post', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='TestCase',
            fields=[
                ('id', models.CharField(max_length=32, primary_key=True, serialize=False)),
                ('CaseName', models.CharField(max_length=128)),
            ],
        ),
        migrations.CreateModel(
            name='TestReport',
            fields=[
                ('id', models.CharField(max_length=32, primary_key=True, serialize=False)),
                ('ReportName', models.CharField(max_length=128)),
            ],
        ),
        migrations.CreateModel(
            name='TestSuite',
            fields=[
                ('id', models.CharField(max_length=32, primary_key=True, serialize=False)),
                ('SuiteName', models.CharField(max_length=128)),
            ],
        ),
        migrations.CreateModel(
            name='TestStep',
            fields=[
                ('id', models.CharField(max_length=32, primary_key=True, serialize=False)),
                ('StepName', models.CharField(max_length=128)),
                ('TestCaseId', models.ForeignKey(on_delete=models.SET(True), to='Post.TestCase')),
            ],
        ),
        migrations.CreateModel(
            name='CaseToSuite',
            fields=[
                ('id', models.CharField(max_length=32, primary_key=True, serialize=False)),
                ('TestCaseId', models.ManyToManyField(blank=True, to='Post.TestCase')),
                ('TestSuiteId', models.ManyToManyField(blank=True, to='Post.TestSuite')),
            ],
        ),
    ]
