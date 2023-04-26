# This is a sample Python script.

# Press Shift+F10 to execute it or replace it with your code.
# Press Double Shift to search everywhere for classes, files, tool windows, actions, and settings.


# Python code to demonstrate how parent constructors
# are called.

# parent class
class Person():

    # __init__ is known as the constructor
    def __init__(self, name, idNumber):
        self.name = name
        self.idNumber = idNumber

    def display(self):
        print(self.name)
        print(self.idNumber)

    def details(self):
        print("My name is {}".format(self.name))
        print("IdNumber: {}".format(self.idNumber))


# child class
class Employee(Person):
    def __init__(self, name, idNumber, salary, post):
        self.salary = salary
        self.post = post

        # invoking the __init__ of the parent class
        Person.__init__(self, name, idNumber)

    def details(self):
        print("My name is {}".format(self.name))
        print("IdNumber: {}".format(self.idNumber))
        print("Post: {}".format(self.post))
        print("Salary: {}".format(self.salary))


# creation of an object variable or an instance
a = Employee('Rahul', 886012, 200000, "Intern")

# calling a function of the class Person using
# its instance
a.display()
a.details()

