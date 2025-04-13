let arr1 = [1, 2, 1, 2, 2];
let arr2 = [];


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
  console.log(`Initial length ${initialArr1Length}`);
  console.log(`res1 ${res1}`);
  console.log(`arr1 ${arr1}`);
  console.log(`res2 ${res2}`);
  return `${res2.some((x) => res1.includes(x)) ? `${res1.length - initialArr1Length}\n${res2.join(' ')}` : '0'}`;
}

const data1 = [ '7', '1 2 3 4 5 4 3' ];
polindromNumbers(data1)