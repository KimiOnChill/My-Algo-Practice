function fName (input) {
  let dict = new Map();
  for (let i = 1; 1 <= input.length - 2; i++){
    let str = input[i].split(" ");
    dict.set(str[0], str[1]);
  }
  return dict;
};

const data1 = `3
Hello Hi
Bye Goodbye
List Array
Goodbye`;

console.log(fName(data1));