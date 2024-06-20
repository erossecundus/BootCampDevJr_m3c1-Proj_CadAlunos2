$("#inputPhone").mask("(00) 00000-0000");

// Data
var students = [];
var courses = [];
var periods = [
  { id: 1, name: "Manhã", },
  { id: 2, name: "Tarde", },
  { id: 3, name: "Noite", }
];

// OnLoad
LoadCouses();
LoadStudent();

// Load all Courses
function LoadCouses() {
  $.ajax({
        url: "http://localhost:8080/courses",
        type: "GET",
        async: false,
        success: (response) => {
          courses = response;
          // carrega os cursos no dropdown menu
          for (let curs of courses)
            document.getElementById("selectCourse").innerHTML +=
              `<option value=${curs.id}>${curs.name}</option>`
        }
  });
}

// Load all Students
function LoadStudent() {
  $.getJSON("http://localhost:8080/students", (response) => {
          students = response;
          for (let student of students) {
            addNewRow(student);
          }
        }
  );
}

// Save a Student
function save() {
  var newStudent = {
    id: students.length+1,
    name: document.getElementById("inputName").value,
    email: document.getElementById("inputEmail").value,
    phone: document.getElementById("inputPhone").value,
    idCourse: document.getElementById("selectCourse").value,
    period: document.querySelector("input[name='flexRadioPeriod']:checked").value
  }

  $.ajax({
    url: "http://localhost:8080/students",
    contentType: "application/json",
    data: JSON.stringify(newStudent),
    type: "POST",
    success: (student) => {
      addNewRow(student);
      students.push(student);
      document.getElementById("formStudents").reset();
    }
  });
}

// Add a new Row
function addNewRow(student) {
  var table = document.getElementById("studentsTable");

  var newRow = table.insertRow();

  var idNode = document.createTextNode(student.id);
  newRow.insertCell().appendChild(idNode);

  var nameNode = document.createTextNode(student.name);
  newRow.insertCell().appendChild(nameNode);

  var emailNode = document.createTextNode(student.email);
  var cell = newRow.insertCell();
  cell.courseName="d-none d-md-table-cell";
  cell.appendChild(emailNode);

  var phoneNode = document.createTextNode(student.phone);
  var cell = newRow.insertCell();
  cell.courseName="d-none d-md-table-cell";
  cell.appendChild(phoneNode);

  var courseNode = document.createTextNode(courses[student.idCourse - 1].name);
  var cell = newRow.insertCell();
  cell.courseName="d-none d-md-table-cell";
  cell.appendChild(courseNode);

  var periodNode = document.createTextNode(periods[student.period - 1].name);
  var cell = newRow.insertCell();
  cell.courseName="d-none d-md-table-cell";
  cell.appendChild(periodNode);

}