/*
retunrn what num is missing in the matrix
*/

function smallestInteger(matrix) {
  const arr = matrix.flat(2).sort((a,b) => a - b);
  let result;
  for (let i = 1; i <= arr.length; i++) {
    if (arr[i] < 0) continue;
    if (arr[i] - arr[i-1] > 1 && arr[i-1] + 1 >= 0 && arr.includes(0)) return result = arr[i-1] + 1;
  }
  return result == undefined && arr.includes(0) ? arr[arr.length - 1] + 1 : 0; 
}

//tests
const matrix1 = [[0,2], [5,1]];
const expectedOutput1 = '3';

const matrix2 = [
 [4,5,3,21,3,8], 
 [2,2,6,5,10,9], 
 [7,5,6,8,2,6], 
 [1,4,7,8,9,0], 
 [1,3,6,5,5,1], 
 [2,7,3,4,4,3]];
const expectedOutput2 = '11';

const matrix3 = [
 [4,5,3,-4,3,8], 
 [2,0,6,5,4,9], 
 [7,5,6,8,2,6], 
 [1,4,7,8,9,11], 
 [1,3,10,5,5,1], 
 [12,7,3,4,4,3]];
const expectedOutput3 = '13';

const matrix4 =[
 [1,2], 
 [3,4]];
const expectedOutput4 = '0';

const matrix5 = [
  [1,5],
  [12,1],
  [1,1],
  [1,10],
  [9,13],
  [14,-3],
  [11,4]];
const expectedOutput5 = '0';

// check
console.log(`Expected output: ${expectedOutput1}
Result is : ${smallestInteger(matrix1)}
`);
console.log(`Expected output: ${expectedOutput2}
Result is : ${smallestInteger(matrix2)}
`);
console.log(`Expected output: ${expectedOutput3}
Result is : ${smallestInteger(matrix3)}
`);
console.log(`Expected output: ${expectedOutput4}
Result is : ${smallestInteger(matrix4)}
`);
console.log(`Expected output: ${expectedOutput5}
Result is : ${smallestInteger(matrix5)}
`);