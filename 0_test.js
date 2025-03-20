const data1 = ['AA aa Aa aA'];
const str = data1[0];
console.log(str);
const regex = /[^.\s?!]+/g;
const found = str.match(regex);

console.log(found);

const res = new Set();
found.forEach(element => {
  res.add(element);
});

console.log(res);
