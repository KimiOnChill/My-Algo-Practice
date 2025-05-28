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
const expectedOutput1 = 4;

const data2 = ['a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a a'];
const expectedOutput2 = 1;

const data3 = [
  "She sells sea shells on the sea shore;",
  "The shells that she sells are sea shells I'm sure.",
  "So if she sells sea shells on the sea shore,",
  "I'm sure that the shells are sea shore shells."
];
const expectedOutput3 = 19;

// check
console.log(`Expected output: ${expectedOutput1}
Result is : ${uniqWordsCount(data1)}
`); 
console.log(`Expected output: ${expectedOutput2}
Result is : ${uniqWordsCount(data2)}
`); 
console.log(`Expected output: ${expectedOutput3}
Result is : ${uniqWordsCount(data3)}
`); 