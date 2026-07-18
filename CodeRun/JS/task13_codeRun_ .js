/*
a) function to check polindrome
  1) if str.length is odd and subarrays to the left
    and to the right of middle element are reversed copies
    output 0;
  2) if str.length is even and subarrays from the first half
    and from the second half are reversed copies output 0;

b) function to add first group of numbers 
  in reverse to the end of the str

  I think it's OK, but closed test #4 is wrong
*/

function isNumPolindrome (arr) {  
  const len = arr.length;
  for (let i = 0; i < Math.floor(len / 2); i++) {
    if (arr[i] !== arr[len - 1 - i]) return false;
  }
  return true;
};

function checkArray (arr1, arr2) {
  let arrPart;
  let i = 1;
  let polCheck = isNumPolindrome(arr1);
  
  while (!polCheck){
    arrPart = arr1.slice(i-1, i);
    i === 1 ? arr1.splice(arr1.length, 0, ...arrPart): arr1.splice(arr1.length-(i-1), 0, ...arrPart);
    arr2.push(...arrPart);
    i++;
    polCheck = isNumPolindrome(arr1);
  }
  arr2.reverse();
return [arr1, arr2];
}

function polindromNumbers (input) {
  const arr1 = input[1].split(" ").map((x)=> x*1);
  const initialArr1Length = input[0]*1;
  let arr2 = [];

  let res1;
  let res2;
  [res1, res2] = checkArray(arr1,arr2)
  return `${res2.some((x) => res1.includes(x)) ? `${res1.length - initialArr1Length}\n${res2.join(' ')}` : '0'}`;
}
  
// test
const data1 = [ '7', '1 2 3 4 5 4 3' ];
const expectedOutput1 = `2
2 1`;

const data2 = [ '9', '1 2 3 4 5 4 3 2 1' ];
const expectedOutput2 = `0`;

const data3 = [ '5', '1 2 1 2 2' ];
const expectedOutput3 = `3
1 2 1`;

const data4 = [ '5', '1 2 3 4 5' ];
const expectedOutput4 = `4
4 3 2 1`;

// check
console.log(`Expected output: ${expectedOutput1}
Result is : ${polindromNumbers(data1)}
`); 
console.log(`Expected output: ${expectedOutput2}
Result is : ${polindromNumbers(data2)}
`); 
console.log(`Expected output: ${expectedOutput3}
Result is : ${polindromNumbers(data3)}
`); 
console.log(`Expected output: ${expectedOutput4}
Result is : ${polindromNumbers(data4)}
`); 