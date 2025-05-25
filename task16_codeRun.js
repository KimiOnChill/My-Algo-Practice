/*
!!Write down algo
*/

function fName (input) {
  const twoAmt = Number(input[0]);
  const threeAmt = Number(input[1]);
  const fourAmt = Number(input[2]);
  let fiveAmt = 0;

  function calcGrade () {
    let actualFinalGrade = (2 * twoAmt + 3 * threeAmt + 4 * fourAmt + 5 * fiveAmt) / (twoAmt + threeAmt + fourAmt + fiveAmt);
    let roundFinalGrade = Math.round(actualFinalGrade);
    if (roundFinalGrade < 4) {
      fiveAmt ++;
      calcGrade();
    }
  }

  calcGrade();
  return fiveAmt;
};


//tests
const data1 = [ '2', '0', '0' ];
const expectedOutput1 = `2`;

// check
console.log(`Expected output: ${expectedOutput1}
Result is : ${fName(data1)}
`);