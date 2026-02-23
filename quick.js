//until j has not reached pivot
//if j < pivot -> move i to next index, swap values at i and j
//if j >= pivot -> ignore and move j to the next index
//when j reaches pivot: move i to next index, this will be the place where pivot should be
//swap values at i and pivot, now on the left are values less then pivot, on the right great 
//than send two subarrays into quickSort until there is an array of one element

// this is code from freeCodeCamp
const array = [1, 2, 4, 7, 1, 3, 9, 6, 5, 11];
const quickSort = (arr) => {
  if (arr.length <= 1) {
    return arr;
  }

  let pivot = arr[0];
  let leftArr = [];
  let rightArr = [];

  for (let i = 1; i < arr.length; i++) {
    if (arr[i] < pivot) {
      leftArr.push(arr[i]);
    } else {
      rightArr.push(arr[i]);
    }
  }

  return [...quickSort(leftArr), pivot, ...quickSort(rightArr)];
};

console.log(quickSort(array))