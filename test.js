let input = ['1 5 1 5 1 5'];
let arr = input[0].split(" ");
let realArr = [];
for (const element of input){
  realArr.push(element*1)
}

console.log(realArr)