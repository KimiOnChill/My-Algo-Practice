let arr1 = [1, 2, 3, 4];
let arr2 = [];

arr1.push(...arr1.slice(1,2));

console.log(arr1);
console.log(arr2);