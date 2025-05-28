/*
1) create comparing var diff
2) for each long str element x - n
3) if x-n < diff -> new diff
4) output n - diff
*/

function nearNumber (input) {
  const n = input[2]*1;
  const nums = input[1].split(" ").map((x)=> x*1);
  let diff = Math.abs(n - nums[0]);

  for (const num of nums) {
    if (Math.abs(n - num) < diff) diff = Math.abs(n - num);
  }
  
  return nums.includes(n-diff) ? n-diff: n+diff;
};


//tests
const data1 = [ '5', '1 2 3 4 5', '6' ];
const data2 = [ '5', '5 4 3 2 1', '3' ];
const data3 = [ '5', '7 5 4 -2 -8', '-3' ];


console.log(`result is ${nearNumber(data1)}`); 
/*
Expected output: 5
*/
console.log(`result is ${nearNumber(data2)}`);
/*
Expected output: 3
*/
console.log(`result is ${nearNumber(data3)}`);
/*
Expected output: -2 or -4
*/