let string1 = 'Hello my name, is Vitaliy! And what is your name?';
let stringToCheck = string1.toLowerCase();
console.log(stringToCheck);

let regex = /[\s,?!.]+/; 
let arr = stringToCheck.split(regex);
arr.pop();
console.log(arr);

let count = {};
for (let x of arr) {
  count.x = arr.indexOf(x);
};

console.log(count);