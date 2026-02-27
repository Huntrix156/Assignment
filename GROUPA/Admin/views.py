from django.shortcuts import render ,redirect, get_object_or_404

from Admin.models import Student


# Create your views here.
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