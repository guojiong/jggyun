from django.urls import path
from Post import views
app_name = 'Post'

urlpatterns=[
    # 这里放映射的view
    path('index/', views.index),
]