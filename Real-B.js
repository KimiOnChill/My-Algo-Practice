/*
!!Write down algo
1) find all X|Y with line jump at the end
2) write each X|Y to ruleArr like X must be before Y 
3) find hollow line
4) each line is a sequence to check with line jump at the end
5) charackters in sequenceLine are divided by comma with space
6) check how many sequenceLines matches all rules
*/

function fName (input) {
  //split str by lines
  const regexNewLine = /\n/g;
  const allLines = input.split(regexNewLine);
  // console.log(allLines);

  let ruleArr = [];
  let linesToCheck = [];

  //fill rules an lines to check arrs
  let regexVertical = /[|]/;
  for (let x of allLines) {
    if (regexVertical.test(x)) {
      ruleArr.push(x.split('|'));
    }
    else if (x == ""){
      continue;
    }
    else {
      linesToCheck.push(x.split(', '));
    }
  };

  //console.log(ruleArr);
  //console.log(linesToCheck);

  let result = 0;

  // Checking logic -> result ++
  // console.log(linesToCheck[0].indexOf(ruleArr[0][0]) > linesToCheck[0].indexOf(ruleArr[0][1]));


  for (let x of linesToCheck) {
    let error = 0;

    for (let i = 0; i <= ruleArr.length-1; i++){
      //console.log(x.indexOf(ruleArr[i][0]));
      //console.log(x.indexOf(ruleArr[i][1]));
      if (x.indexOf(ruleArr[i][0]) < 0 || x.indexOf(ruleArr[i][1]) < 0){
        continue;
      }

      if (x.indexOf(ruleArr[i][0]) > x.indexOf(ruleArr[i][1])){
        error++;
      }
    }

    if (error === 0) {
      result++;
    }

  }
  
  return result;
};


//tests
let data1 = '';
let data2 = `28|12
5|9
9|2

10, 5, 15, 28, 9, 12
2, 7, 12, 5, 9
4, 8, 16, 32, 64`;

console.log(fName(data1)); 
/*
Expected output:

*/
console.log(fName(data2)); 
/*
Expected output:
2
*/