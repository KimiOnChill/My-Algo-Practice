/*
Find discriminant
Comparing it to zero
Return how many roots and roots in sort
*/

function discriminant (str) {
  const arr = str.split(" ");
  const a = arr[0] * 1;
  const b = arr[1] * 1;
  const c = arr[2] * 1;
  const D = b*b - 4 * a * c;
  
  if (D < 0) {return 0;}
  else if (D == 0) {
    return `1
${-b / (2 * a)}`;
  }
  else {
    const res = [ (Math.sqrt(D) - b) / (2 * a), (-Math.sqrt(D) - b) / (2 * a)];
    res.sort();
    return `2
${res[0]} ${res[1]}`;
  }
};


//tests
const data1 = '1 -2 1';
const data2 = '5 0 3';
const data3 = '6 -5 -8';

console.log(discriminant(data1)); 
/*
Expected output:
1
1.000000
*/
console.log(discriminant(data2)); 
/*
Expected output:
0
*/
console.log(discriminant(data3)); 
/*
Expected output:
2
-0.810910 1.644243
*/