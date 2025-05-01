data1 = [ '-530', '-530', '-530', '-2000000000'];

function whatSequence (input) {
  let diferenceArr = [];
  let diference;

  for(let i = 1; i <= input.length-2; i++){
    diference = Number(input[i]) - Number(input[i-1]);
    diferenceArr.push(diference)
    
  }

  if(diferenceArr.every((x) => x === 0)){
    return `CONSTANT`;
  }
  else{return 'not'}

}

console.log(whatSequence (data1));