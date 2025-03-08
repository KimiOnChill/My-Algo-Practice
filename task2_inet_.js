/*
result = {
  1: [array of students 17 years and older],
  2: [array of students 17 years and older]
}
*/

function studentGroupFilter (studentArr) {
  let result ={};

  for (let student of studentArr) {
    if (student.age <= 17)  { result[student.group].push(student.name) }
  };
  
  return result;   
}


//tests
const studentArr = [
  {
  name: 'Joe',
  age: 19,
  group: 1
  },
  {
  name: 'Kate',
  age: 16,
  group: 1
  },
  {
  name: 'Ann',
  age: 17,
  group: 2
  },
  {
  name: 'Fin',
  age: 14,
  group: 2
  }
];

console.log(studentGroupFilter(studentArr)); 
/*
Expected output:
result: {1: 'Joe', 2: 'Ann'}
*/