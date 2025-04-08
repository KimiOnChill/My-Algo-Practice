const data1 = ['20 8'];

let arr = data1[0].split(" ").map((x)=>x*1).sort((a,b)=>a-b);

let a = arr[0];
let b = arr[1];

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
  intersection.push(arr1.filter((x) => !intersection.includes(x)));
  intersection.push(arr2.filter((x) => !intersection.includes(x)));
  return intersection.reduce((acc, x) => acc* x, 1);
}

console.log(dividers(8));