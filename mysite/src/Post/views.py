from django.shortcuts import render

# Create your views here.
def index(request):
#     ?es = request.get("#")
#     print(res)
    return render(request, template_name='Post/index.html',context={'tag':'index'})

def TestCase(request):
    return render(request, template_name='Post/index.html',context={'tag':'testcase'})