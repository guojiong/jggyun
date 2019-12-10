from django.shortcuts import render
from testapp import models
import requests

# user_list = []

# Create your views here.

sess = requests.session()

def login(request):
#     return HttpResponse('Hello World!')
    return render(request, 'index.html', {'message':''})

def base(request):
#     return HttpResponse('Hello World!')
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        try:
            result = models.UserInfo.objects.get(user=username)
            if password == result.passwd:
                sess.cookies
                user_list = models.UserInfo.objects.all()
                return render(request, 'base.html', {'data':user_list})
            else:
                return render(request, 'index.html', {'message':'用户密码错误！'})
        except Exception as e:
            print("测试")
            return render(request, 'index.html', {'message':'用户不存在！'})

def usermanage(request):
    return render(request, 'usermanage.html')