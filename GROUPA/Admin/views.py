from http.client import responses
from urllib import request

from django.contrib import messages
from django.contrib.auth import login, authenticate,logout
from django.contrib.auth.decorators import login_required
from django.contrib.auth.models import User

from django.shortcuts import render ,redirect, get_object_or_404
from django_daraja.mpesa.core import MpesaClient

from Admin.models import Student, Payment


# Create your views here.
@login_required
def index(request):
    students = Student.objects.all()
    return render(request, 'index.html', {'students': students})
def add_record(request):
    if request.method == 'POST':
        name = request.POST.get('name')
        course = request.POST.get('course')
        age = request.POST.get('age')
        email = request.POST.get('email')
        date = request.POST.get('date')
        image = request.FILES.get('image')

        Student.objects.create(
            name=name,
            course=course,
            age=age ,
            email=email,
            date=date,
            image=image)
        return redirect('index')
    return render(request, 'add_record.html')
def update_record(request,id):
    student = get_object_or_404(Student,id=id)
    if request.method == 'POST':
        student.name = request.POST.get('name')
        student.course = request.POST.get('course')
        student.age = request.POST.get('age')
        student.email = request.POST.get('email')
        student.date = request.POST.get('date')
        student.image = request.FILES.get('image')
        if request.FILES.get('image'):
            student.image = request.FILES.get('image')
        student.save()
        return redirect('index')
    return render(request, 'update_record.html', {'student': student})

def delete_record(request, id):
        student = get_object_or_404(Student, id=id)
        if request.method == "POST":
            student.delete()
            return redirect('home')  # change to your list page name

        return redirect('delete_record.html',{'student': student})
def sign_up(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        email = request.POST.get('email')
        password = request.POST.get('password')

        if User.objects.filter(username=username).exists():
            messages.error(request, 'User already exists')
            return redirect('sign_up')
        user = User.objects.create_user(
            username=username,
            email=email,
            password=password)
        login(request, user)
        return redirect('index')
    return render(request, 'sign_up.html')
def log_in(request):
    if request.method == 'POST':
        username = request.POST.get('username')
        password = request.POST.get('password')
        user = authenticate(request, username=username,
                            password=password)
        if user is not None:
            login(request, user)
            return redirect('index')
        else:
            messages.error(request,
                           'Invalid Username or Password')
            return redirect('log_in')
    return render(request, 'log_in.html')
def logout_view(request):
    logout(request)
    return redirect('log_in')
def payment(request):
   student = get_object_or_404(Student,id=id)
   if request.method == 'POST':
       phone = request.POST.get('phone')
       amount = request.POST.get('amount')
       if not phone or not amount:
           messages.error(request,'All fields are required')
           return render(request, 'payment.html', {'student': student})
       try:
           client = MpesaClient()
           response = client.stk_push(
               phone,int(amount),'emobilis',
               'Payment for fee',
               'https://example.com/callback/'
            ) .json()
           Payment.objects.create(
                       user = request.user,
                       phone = phone,
                       amount = amount,
                       checkout_request_id = response.get('checkout_request_id',''),
                       status = 'pending',
                       )

           messages.success(request, 'STK PUSH SENT!Check your phone')
       except Exception:
           messages.error(request,'Payment failed')

   return render(request, 'payment.html', {'student': student})