/*
1) first digit tells how many digits will there be in the Map
2) create Map with given pairs
3) output opposite to the last given word
*/

function findInDictionary (input) {
  let dict = new Map();
  for (let i = 1; i <= input.length - 2; i++){
    let str = input[i].split(" ");
    dict.set(str[0], str[1]);
  }
  const whatToFind = input[input.length - 1];
  let res;

  dict.forEach((value, key)=>{
    if (value === whatToFind){
      res = key;
    }
    else if (key === whatToFind){
      res = value;
    }
  })

  return res;
};


//tests
const data1 = [ '3', 'Hello Hi', 'Bye Goodbye', 'List Array', 'Goodbye' ];
const data2 = [ '1', 'beep Car', 'Car' ];
const data3 = [ '2', 'Ololo Ololo', 'Numbers 1234567890', 'Numbers' ];

console.log(findInDictionary(data1)); 
/*
Expected output:
Bye
*/
console.log(findInDictionary(data2)); 
/*
Expected output:
beep
*/
console.log(findInDictionary(data3)); 
/*
Expected output:
1234567890
*/