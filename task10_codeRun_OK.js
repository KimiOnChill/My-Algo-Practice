/*
1st output should be the greatest common divisors (НОД)
2nd output should be the least common multiptle (НОК) 
*/

function gcd (a, b) {
  let left = b % a;
  if (left == 0) {
    return a;
  }
  else {return gcd(left, a)};
}

function dividers (x) {
  let result = new Map();
  let div = 2;
  while (x > 1) {
    if (x % div == 0) {
      result.has(div) ? result.set(div, result.get(div) + 1) : result.set(div, 1);
      x = x / div;
    }
    else {div ++}
  }
  return result;
} 

function lcm (a, b) {
  const divA = dividers(a);
  const divB = dividers(b);

  let res = 1;

  divA.forEach((value, key) => {
    if (value >= divB.get(key) || divB.get(key) == undefined){
      res *= Math.pow(key, value);
    }
  })
  
  divB.forEach((value, key) => {
    if (value > divA.get(key) || divA.get(key) == undefined){
      res *= Math.pow(key, value);
    }
  })
 
  return res;
}

function resolveGcdLcm (input) {
  let arr = input[0].split(" ").map((x)=>x*1).sort((a,b)=>a-b);
  let a = arr[0];
  let b = arr[1];

  return `${gcd(a, b)} ${lcm(a, b)}`
};

//tests
const data1 = ['20 8'];
const data2 = ['2 3'];
const data3 = ['5 15'];

console.log(resolveGcdLcm(data1)); 
/*
Expected output:
4 40
*/
console.log(resolveGcdLcm(data2)); 
/*
Expected output:
1 6
*/
console.log(resolveGcdLcm(data3)); 
/*
Expected output:
5 15
*/