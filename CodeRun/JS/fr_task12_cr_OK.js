const original = [10, 15, 3];
const target = 17;

function find(target, arr) {
  for (let i = 0; i < arr.length; i++) {
    let dif = target - arr[i];
    let newArr = arr;
    newArr.splice(i, 1);
    if (newArr.includes(dif)) return true;
  }
  return false;
}

console.log(find(target, original));

const array = [8, 2, 4, 7, 1, 3, 9, 6, 5];

function quickSort(arr) {
  if (arr.length == 1) return arr;

  let pivot = {value: arr[arr.length - 1], index: arr.length - 1};
  let i = -1;
  let j = {value: arr[0], index: 0}
  
  while (j.index < arr.length - 1){//until j has not reached pivot
    j.value = arr[j.index];
    if (j.value < pivot.value) {//if j < pivot -> move i to next index, swap values at i and j
      i++;
      arr.splice(j.index, 1, arr[i]);
      arr.splice(i, 1, j.value);
    }
    else {//if j >= pivot -> ignore and move j to the next index
      j.index++
    }
  }

  i++;//when j reaches pivot: move i to next index, this will be the place where pivot should be
  //swap values at i and pivot, now on the left are values less then pivot, on the right great 
  arr.splice(pivot.index, 1, arr[i]);
  arr.splice(i, 1, pivot.value);
  pivot.index = i;

  //than send two subarrays into quickSort until there is an array of one element
  let leftArr = array.slice(0, pivot.index);
  let rigthArr = array.slice(pivot.index, arr.length-1);

  let result = quickSort(leftArr).concat([pivot.value]);
  result.concat(quickSort(rigthArr));
  return result;
}

console.log(quickSort(array));
