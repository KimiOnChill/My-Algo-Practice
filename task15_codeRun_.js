function whatSequence(input) {
  let differenceArr = [];

  for (let i = 1; i < input.length; i++) {
    if (Number(input[i]) === -2000000000) break;
    differenceArr.push(Number(input[i]) - Number(input[i-1]));
  }

  if (differenceArr.length === 0) return 'CONSTANT';  // Single element case
  
  if (differenceArr.every(x => x === 0)) {
    return 'CONSTANT';
  }
  else if (differenceArr.every(x => x >= 0)) {
    if (differenceArr.every(x => x === differenceArr[0] && x > 0)) {
      return 'ASCENDING';
    }
    return 'WEAKLY ASCENDING';
  }
  else if (differenceArr.every(x => x <= 0)) {
    if (differenceArr.every(x => x === differenceArr[0] && x < 0)) {
      return 'DESCENDING';
    }
    return 'WEAKLY DESCENDING';
  }
  else {
    return 'RANDOM';
  }
}

//tests
const data1 = [ '-530', '-530', '-530', '-2000000000'];
const expectedOutput1 = `CONSTANT`;

const data2 = [ '1', '2', '3', '4', '5', '6', '7', '8', '9', '-2000000000'];
const expectedOutput2 = `ASCENDING`;

const data3 = [ '-5', '13', '15', '-2000000000', '20', '30', '31'];
const expectedOutput3 = `WEAKLY ASCENDING`;

const data4 = [ '7', '6', '5', '4', '3', '2', '1', '-2000000000'];
const expectedOutput4 = `DESCENDING`;

const data5 = [ '31', '30', '20', '15', '-1', '-17', '-2000000000'];
const expectedOutput5 = `WEAKLY DESCENDING`;

const data6 = [ '-14', '15', '-17', '-1', '514', '-2000000000'];
const expectedOutput6 = `RANDOM`;

// check
console.log(`Expected output: ${expectedOutput1}
Result is : ${whatSequence(data1)}
`);

console.log(`Expected output: ${expectedOutput2}
Result is : ${whatSequence(data2)}
`);

console.log(`Expected output: ${expectedOutput3}
Result is : ${whatSequence(data3)}
`);

console.log(`Expected output: ${expectedOutput4}
Result is : ${whatSequence(data4)}
`);

console.log(`Expected output: ${expectedOutput5}
Result is : ${whatSequence(data5)}
`);

console.log(`Expected output: ${expectedOutput6}
Result is : ${whatSequence(data6)}
`);