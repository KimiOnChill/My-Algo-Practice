/*
!!Write down algo
1) regex on spaces and sentence endings
2) iterate throught each word adding them into set
*/

function uniqWordsCount (input) {
  const str = input.toString();
  const regex = /[^'.\s?!]+/g;
  const found = str.match(regex);
  const res = new Set();

  found.forEach(element => {
    res.add(element);
  });

  console.log(res);
  return res.size;
};


//tests
const data1 = ['AA aa Aa aA'];
const data2 = ['a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a'];
const data3 = [
  "She sells sea shells on the sea shore;",
  "The shells that she sells are sea shells I'm sure.",
  "So if she sells sea shells on the sea shore,",
  "I'm sure that the shells are sea shore shells."
];

console.log(uniqWordsCount(data1)); 
/*
Expected output: 4
*/
console.log(uniqWordsCount(data2)); 
/*
Expected output: 1
*/
console.log(uniqWordsCount(data3)); 
/*
Expected output: 19
*/