/*
I had already did this
First output should be the greatest common divisors (НОД)
Second output should be the least common multiptle (НОК) 
*/

function gcd (a, b) {
  let left = b % a;
  if (left == 0) {
    return a;
  }
  else {return gcd(left, a)};
}

function dividers (x) {
  let resArr = [];
  let div = 2;
  while (x > 1) {
    if (x % div == 0) {
      resArr.push(div);
      div++;
    }
    else {div ++}
  }
  return resArr;
} 

function lcm (a, b) {
  const arr1 = dividers(a);
  const arr2 = dividers(b);
  let intersection = arr1.filter((x) => arr2.includes(x));
  intersection.push(arr1.filter((x) => !intersection.includes(x))).push(arr2.filter((x) => !intersection.includes(x)));
  return intersection.reduce((acc, x) => acc* x, 1);
}

function resolveGcdLcm (input) {
  // get numbersfrom string
  let arr = input[0].split(" ").map((x)=>x*1).sort((a,b)=>a-b);
  let a = arr[0];
  let b = arr[1];

  return `${gcd(a, b)} ${lcm(a, b)}`
};

//tests
const data1 = ['20 8'];
const data2 = ['2 3'];
const data3 = ['5 15'];

console.log(resolveGcmLcm(data1)); 
/*
Expected output:
4 40
*/
console.log(resolveGcmLcm(data2)); 
/*
Expected output:
1 6
*/
console.log(resolveGcmLcm(data3)); 
/*
Expected output:
5 15
*/