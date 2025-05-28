/*
!!Write down algo
1) regex on digits + match
2) iterate through arr
   if current is lower than previous exit with "NO"
   else exit with "YES"
*/

function uprisingString (input) {
  const str = input[0]; 

  const regex = /\d+/gi;

  const found = str.match(regex);

  // console.log(found);

  for (let i = 1; i < str.length + 1; i++){
    if (found[i]*1 <= found[i-1]*1) {return 'NO'} 
  }
  return "YES";
};


//tests
const data1 = ['1 7 9'];
const data2 = ['1 9 7'];
const data3 = ['2 2 2'];
const data4 = ['1 7 9 33'];

console.log(uprisingString(data1)); 
/*
Expected output: YES
*/
console.log(uprisingString(data2)); 
/*
Expected output: NO
*/
console.log(uprisingString(data3)); 
/*
Expected output: NO
*/
console.log(uprisingString(data4)); 
/*
Expected output: YES
*/