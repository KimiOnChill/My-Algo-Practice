/*
Check typeof
Return how many floors elevator
*/

function goto(level, button){
  //checks
  if (typeof(level) != 'number' || typeof(button) != 'string') return 0;
  if (level > 3 || level < 0 || level !== Math.round(level)) return 0;
  if (Number(button) > 3 || Number(button) < 0 || Number(button) !== Math.round(Number(button))) return 0;

  //calc
  return Number(button) - level;
}


//tests
const level1 = 2;
const button1 = '4';
const expectedOutput1 = `0`;

const level2 = 4;
const button2 = '0';
const expectedOutput2 = `0`;

const level3 = 3;
const button3 = {};
const expectedOutput3 = `0`;

const level4 = 3;
const button4 = '0';
const expectedOutput4 = `-3`;

const level5 = 2;
const button5 = '2';
const expectedOutput5 = `0`;

const level6 = 1;
const button6 = '2';
const expectedOutput6 = `1`;

const level7 = 2;
const button7 = '1';
const expectedOutput7 = `-1`;

// check
console.log(`Expected output: ${expectedOutput1}
Result is : ${goto(level1, button1)}
`);
console.log(`Expected output: ${expectedOutput2}
Result is : ${goto(level2, button2)}
`);
console.log(`Expected output: ${expectedOutput3}
Result is : ${goto(level3, button3)}
`);
console.log(`Expected output: ${expectedOutput4}
Result is : ${goto(level4, button4)}
`);
console.log(`Expected output: ${expectedOutput5}
Result is : ${goto(level5, button5)}
`);
console.log(`Expected output: ${expectedOutput6}
Result is : ${goto(level6, button6)}
`);
console.log(`Expected output: ${expectedOutput7}
Result is : ${goto(level7, button7)}
`);