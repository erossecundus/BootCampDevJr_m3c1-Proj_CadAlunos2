$("#inputPhone").mask("(00) 00000-0000");

var students = [
  {
    id: 1,
    name: "Fulano de Tal",
    email: "exemplo@mail.com",
    phone: "(15) 99999-9999",
    class: "4",
    shift: "1"
  }
];

var classes = [
  { id: 1, name: "HTML/CSS", },
  { id: 2, name: "JavaScript", },
  { id: 3, name: "Angular", },
  { id: 4, name: "Java", }
];

var shifts = [
  { id: 1, name: "Manhã", },
  { id: 2, name: "Tarde", },
  { id: 3, name: "Noite", }
];

LoadStudent()

function LoadStudent() {
  for (let student of students) {
    addNewRow(student);
  }
}

function save() {
  var newStudent = {
    id: students.length+1,
    name: document.getElementById("inputName").value,
    email: document.getElementById("inputEmail").value,
    phone: document.getElementById("inputPhone").value,
    class: document.getElementById("inputClass").value,
    shift: document.querySelector("input[name='flexRadioShift']:checked").value
  }

  addNewRow(newStudent);
}

function addNewRow(student) {
  var table = document.getElementById("studentsTable");

  var newRow = table.insertRow();

  var idNode = document.createTextNode(student.id);
  newRow.insertCell().appendChild(idNode);

  var nameNode = document.createTextNode(student.name);
  newRow.insertCell().appendChild(nameNode);

  var emailNode = document.createTextNode(student.email);
  var cell = newRow.insertCell();
  cell.className="d-none d-md-table-cell";
  cell.appendChild(emailNode);

  var phoneNode = document.createTextNode(student.phone);
  var cell = newRow.insertCell();
  cell.className="d-none d-md-table-cell";
  cell.appendChild(phoneNode);

  var classNode = document.createTextNode(classes[student.class - 1].name);
  var cell = newRow.insertCell();
  cell.className="d-none d-md-table-cell";
  cell.appendChild(classNode);

  var shiftNode = document.createTextNode(shifts[student.shift - 1].name);
  var cell = newRow.insertCell();
  cell.className="d-none d-md-table-cell";
  cell.appendChild(shiftNode);

}