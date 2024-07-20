function Person(name, age) {
    this.name = name;
    this.age = age;
    this.salute = function() {
        console.log("Hello! My name is " + this.name + ". I am " + this.age + " years old.");
    };
}

function Student(name, age, major) {
    Person.call(this, name, age);
    this.major = major;
    this.greeting = function() {
        console.log("Hey, my name is " + this.name + " and I am studying " + this.major + ".");
    };
}

function Professor(name, age, department) {
    Person.call(this, name, age);
    this.department = department;
    this.greeting = function() {
        console.log("Good day, my name is " + this.name + " and I am in the " + this.department + " department.");
    };
}


var student = new Student("Suraphel", 25, "WAP");
var professor = new Professor("Dr. Tilahun", 50, "Engineering");

student.greeting();
professor.greeting();
student.salute();
professor.salute();
