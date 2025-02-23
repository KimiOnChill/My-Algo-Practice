function getCompressedString(str) {
  let strToCheck = str.toLowerCase();
  console.log(stringToCheck);

  let regex = /[\s,?!.]+/; 
  let arr = strToCheck.split(regex);
  arr.pop();
  console.log(arr);

  let count = {};
  for (let x of arr) {
    count.x = arr.indexOf(x);
  };
}


//tests
let string1 = 'Hello my name is Vitaliy! And what is your name?';
let string2 = `
Привет, как у тебя дела?
Да, вроде, хорошо, а у тебя?
`;

console.log(getCompressedString(string1)); 
//2 3 0 1 4! 5 6 1 7 0?
console.log(getCompressedString(string2)); 
//2, 3 0 1 4?
//5, 6, 7, 8 0 1?