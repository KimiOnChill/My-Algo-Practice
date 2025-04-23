/*
sort
compare 3max with 3min and 2min*1max
output in assending way
*/

function max3Multiply (input) {
  let arr = input[0].split(" ").sort((a,b) => a-b);
  const len = arr.length;
  const max3 = [arr[len-3], arr[len-2], arr[len-1]];
  const min3 = [arr[0], arr[1], arr[2]];
  
  const max3mult = max3.reduce((acc, x) => acc * x, 1);
  const min3mult = min3.reduce((acc, x) => acc * x, 1);
  const mix3mult = arr[0] * arr[1] * arr[len-1];

  if (max3mult >= min3mult && max3mult >= mix3mult){
    return max3.sort((a,b) => b-a).join(" ");
  }
  else if (min3mult >= max3mult && min3mult >= mix3mult){
    return min3.sort((a,b) => b-a).join(" ");
  }
  if (mix3mult >= min3mult && mix3mult >= max3mult){
    return `${arr[0]} ${arr[1]} ${arr[len-1]}`;
  }
};


//tests
const data1 = [ '3 5 1 7 9 0 9 -3 10' ];
const expectedOutput1 = `10 9 9`;

const data2 = [ '-5 -30000 -12' ];
const expectedOutput2 = `-5 -12 -30000`;

const data3 = [ '1 2 3' ];
const expectedOutput3 = `3 2 1`;

const data4 = [ '7 8 9 -7 -8 -9' ];
const expectedOutput4 = `9 -8 -9`;

// check
console.log(`Expected output: ${expectedOutput1}
Result is : ${max3Multiply(data1)}
`);

console.log(`Expected output: ${expectedOutput2}
Result is : ${max3Multiply(data2)}
`);

console.log(`Expected output: ${expectedOutput3}
Result is : ${max3Multiply(data3)}
`);

console.log(`Expected output: ${expectedOutput4}
Result is : ${max3Multiply(data4)}
`);