/*
function binarySearch (list, item) {
  let low = 0;
  let high = list.length-1;
  while (low <= high){
     let mid = Math.floor((high - low)/2);
     let guess = list[mid];
     if (guess == item){
        return mid;
     }
     else if (guess > item){
        high = mid-1;
     }
     else{
        low = mid+1;
     }
     return "Not found";
  }
}

const testlist = [1,3,5,7,9];

console.log(binarySearch(testlist, 3)); //=>1

console. log(binarySearch(testlist, 1)); //=>None
*/

function binarySearch (input, target) {
  // input.sort((a, b) => a.value - b.value);

  let steps = 1;
  let start = 0;
  let pivot;
  let end = input.length-1;

  function count (){
    pivot = Math.ceil(input[end] / input[start]);
    if (pivot == target) {
      return steps;
    }
    else if (pivot > target) {
      steps++;
      end = Math.ceil(end / 2);
      count();
    }
    else if (pivot < target) {
      steps++;
      start = (start + 1) *2 - 1;
      count();
    }
    else {return `${target} is not found`};
  }
}

function fillInput (start, step, end) {
  const result = [];
  let i = start;
  while (i <= end){
    result.push(i);
    i += step;
  }
  return result;
}

console.log(fillInput (1, 1, 100));
console.log(binarySearch (fillInput (1, 1, 100), 57)); //7
