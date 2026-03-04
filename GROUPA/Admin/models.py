from django.contrib.auth.models import User
from django.db import models

# Create your models here.
class Student(models.Model):
    name = models.CharField(max_length=20)
    course = models.CharField(max_length=50)
    age = models.IntegerField()
    email = models.EmailField(null=True,blank=True)
    date = models.DateField(default='2021-12-23')
    image = models.ImageField(upload_to = 'students/',null=True,blank=True)

    def __str__(self):
        return self.name




class Payment(models.Model):
    user = models.ForeignKey(User,on_delete=models.CASCADE)
    phone = models.CharField(max_length=10)
    amount = models.IntegerField()
    checkout_request_id = models.CharField(max_length=100)
    status = models.CharField(max_length=20,default='Pending')
    created_at = models.DateTimeField(auto_now_add=True)



    def __str__(self):
        return self.phone