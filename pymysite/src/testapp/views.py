from django.shortcuts import render
from testapp import models

# user_list = []

# Create your views here.

def index(request):
#     return HttpResponse('Hello World!')
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
#         print(username, password)
#         temp = {'username':username, 'passwd':password}
        models.UserInfo.objects.create(user=username, passwd=password)
    
    user_list = models.UserInfo.objects.all()
    return render(request, 'index.html', {'data':user_list})
