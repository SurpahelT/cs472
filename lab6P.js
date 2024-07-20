function Person(name, age) {
    this.name = name;
    this.age = age;
}

Person.prototype.salute = function() {
    console.log("Hello! My name is " + this.name + ". I am " + this.age + " years old.");
};

function Student(name, age, major) {
    Person.call(this, name, age);
    this.major = major;
}

Student.prototype = Object.create(Person.prototype);
Student.prototype.constructor = Student;


Student.prototype.greeting = function() {
    console.log("Hey, my name is " + this.name + " and I am studying " + this.major + ".");
};

function Professor(name, age, department) {
    Person.call(this, name, age);
    this.department = department;
}

Professor.prototype = Object.create(Person.prototype);
Professor.prototype.constructor = Professor;

Professor.prototype.greeting = function() {
    console.log("Good day, my name is " + this.name + " and I am in the " + this.department + " department.");
};

var student = new Student("Suraphel", 30, "Computer Science");
var professor = new Professor("Dr. Tilahun", 45, "Mathematics");

student.greeting();
professor.greeting();
student.salute();
professor.salute();
