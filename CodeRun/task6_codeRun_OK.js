/*
Check each num in input
If it`s not included into nums arr, result++ 
*/

function calculatorTaps (input) {
  const regexNewLine = /\n/g;
  input = input.split(regexNewLine);

  const taps = input[0].split(" ");//what calc got
  const nums = input[1];//what to type
  
  let result = 0;
  
  for (let num of nums) {
    if (!taps.includes(num)){
      result++;
      taps.push(num);
    }
  }

  return result;
};


//tests
const data1 = `1 2 3
1123`;
const data2 = `1 2 3
1001`;
const data3 = `5 7 3
123`;

console.log(calculatorTaps(data1)); 
/*
Expected output:
0
*/
console.log(calculatorTaps(data2)); 
/*
Expected output:
1
*/
console.log(calculatorTaps(data3)); 
/*
Expected output:
2
*/