# nu=5
# sum=1
# for x in range(1,5):
#     sum=sum*x
# print(sum)


class Parrot:

    # class attribute
    name = ""
    age = 0

# create parrot1 object
parrot1 = Parrot()
parrot1.name = "Blu"
parrot1.age = 10

# create another object parrot2
parrot2 = Parrot()
parrot2.name = "Woo"
parrot2.age = 15

# access attributes
pr1="{} is {} years old"
print(pr1.format(parrot1.name,parrot1.age))
print(f"{parrot2.name} is {parrot2.age} years old")
print(pr1.format(parrot2.name,parrot2.age))
