//Output how many element are bigger than their neighbours
//'1 2 3 4 5' => 0
//'5 4 3 2 1' => 0
//'1 5 1 5 1 5' => 2 && str[i] > str[i+1]

function neighbourSmaller (input) {
  let arr = input[0].split(" ");
  let realArr = [];
  for (const element of arr){
    realArr.push(element*1);
  }

  let result = 0;
  let i = 1;

  while ( i < arr.length - 1){

    if (arr[i] > arr[i-1] && arr[i] > arr[i+1]) {
      result++
    }

    i++;
  }
  return result;
}

console.log(`On input '1 5 1 5 1 5' => ${neighbourSmaller (['1 5 1 5 1 5'])}`);
console.log(`On input '5 4 3 2 1' => ${neighbourSmaller (['5 4 3 2 1'])}`);
console.log(`On input '1 2 3 4 5' => ${neighbourSmaller (['1 2 3 4 5'])}`);
