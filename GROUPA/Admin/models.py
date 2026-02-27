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



    def __str__(self):
        return self.name
