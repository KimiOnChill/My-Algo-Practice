/*
!!Write down algo
a) function to check polindrome
  1) if all elements are the same output 0;
  2) if str.length is odd and subarrays to the left
    and to the right of middle element are reversed copies
    output 0;
  3) if str.length is even and subarrays from the first half
    and from the second half are reversed copies output 0;

b) function to add first group of numbers 
  in reverse to the end of the str
*/

function isPolindrome (arr) {
  let start = 0;
  let end = arr.length-1;

  while(start < end) {
    if (arr[start] !== arr[end])return false;
    
    start++;
    end--;
  }
  return true;
};

function checkArray (arr1, arr2) {
  if (!isPolindrome(arr1)) {
    //add numbers 
  }
  else{return arr1, arr2}
}

function polindromNumbers (input) {
  const arr1 = input[1].split(" ").map((x)=> x*1);
  let arr2 = [];

  checkArray(arr1, arr2);
  
  return `${arr2.some((x) => arr1.includes(x)) ? `${arr1.length - arr2.length}\n${arr2.join(' ')}` : '0'}`;
}
  
// tests
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