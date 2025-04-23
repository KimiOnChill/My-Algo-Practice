function fName (input) {
  let dict = new Map();
  for (let i = 1; i <= input.length - 2; i++){
    let str = input[i].split(" ");
    dict.set(str[0], str[1]);
  }
  console.log(dict);
  const whatToFind = input[input.length - 1];
  console.log(whatToFind);
  
  dict.forEach((value, key) => {
    if (whatToFind === value){
      return key
    }
    else if (whatToFind === key){
      return value
    }
  })
};

const data1 = [ '3', 'Hello Hi', 'Bye Goodbye', 'List Array', 'Goodbye' ];

console.log(fName(data1));