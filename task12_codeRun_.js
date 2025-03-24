/*
!!Write down algo
1) create comparing var diff
2) for each long str element x - n
3) if x-n < diff -> new diff
4) output n - diff
*/

function nearNumber (input) {

  const n = input[2]*1;
  const str = input[1];
  let diff = Math.abs(n - str[0]);

  for (let i = 0; i < str.length; i+= 2) {
    if (Math.abs(n - str[i] < diff)) diff = Math.abs(n - str[i]);
    console.log(diff)
  }
  
  return n - diff;
  
};


//tests
const data1 = [ '5', '1 2 3 4 5', '6' ];
const data2 = [ '5', '5 4 3 2 1', '3' ];
const data3 = [ '6', '7 5 4 -2 -8 -4', '-3' ];



console.log(`result is ${nearNumber(data3)}`);
/*
Expected output: -2 or -4
*/