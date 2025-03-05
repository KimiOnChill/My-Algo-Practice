let result = {};

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

result[studentArr.group] = [1,2]

console.log(result);