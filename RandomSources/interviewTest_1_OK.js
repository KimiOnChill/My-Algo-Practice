// Написать функцию findUnique, которая вернет все уникальные числа за один проход (без использования Set).

const array = [1, 2, 5, 7, 7, 11, 12, 11, 1, 12]; // [2, 5]
function findUnique(arr) {
  let metMap = new Map();

  arr.forEach((x) => {
    if (metMap.has(x)) {
      let getValue = metMap.get(x);
      getValue++;
      metMap.set(x, getValue);
    }
    else {
      metMap.set(x, 1)
    }
  });
  let resultArr = [];
  const pushToArr = (value, key, map) => {
    if (value == 1) resultArr.push(key);
  }
  //console.log([...metMap.entries()]);
  metMap.forEach(pushToArr);
  return resultArr;
}

console.log(findUnique(array))