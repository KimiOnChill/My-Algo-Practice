const data2 = `28|12
5|9
9|2

10, 5, 15, 28, 9, 12
2, 7, 12, 5, 9
4, 8, 16, 32, 64`;

//split str by lines
const regexNewLine = /\n/g;
const allLines = data2.split(regexNewLine);
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
    linesToCheck.push(x.split(','));
  }
};


console.log(ruleArr);
console.log(linesToCheck);