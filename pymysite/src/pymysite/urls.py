"""pymysite URL Configuration

The `urlpatterns` list routes URLs to views. For more information please see:
    https://docs.djangoproject.com/en/3.0/topics/http/urls/
Examples:
Function views
    1. Add an import:  from my_app import views
    2. Add a URL to urlpatterns:  path('', views.home, name='home')
Class-based views
    1. Add an import:  from other_app.views import Home
    2. Add a URL to urlpatterns:  path('', Home.as_view(), name='home')
Including another URLconf
    1. Import the include() function: from django.urls import include, path
    2. Add a URL to urlpatterns:  path('blog/', include('blog.urls'))
"""

# 原生配置
from django.contrib import admin
from django.urls import path
from testapp import views
admin.autodiscover()

urlpatterns = [
    path('admin/', admin.site.urls),
    path('login/', views.login),
    path('base/', views.base),
    path('usermanage/',views.usermanage),
    path('validation/', views.validation),
]
"""from django.conf.urls import url, include
from django.contrib import admin
from testapp.views import archive

urlpatterns = [
    url(r'^admin/', include(admin.site.urls)),
    url(r'^blog/', archive),
]"""