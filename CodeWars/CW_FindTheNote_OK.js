/*
Check typeof
Return how many floors elevator
*/

const whatNote = (string, fret) => {
  const notes = ['A','A#','B','C','C#','D','D#','E','F','F#','G','G#'];
  const indexOfNote = notes.indexOf(string.toUpperCase());
  if (indexOfNote < 0) return "String must be one of the notes";
  const find = indexOfNote + fret;
  const findIndex = find - notes.length * Math.floor(find / notes.length);
  return notes[findIndex];
};


//tests
const string1 = "e";
const fret1 = 0;
const expectedOutput1 = "E";

const string2 = "D";
const fret2 = 5;
const expectedOutput2 = "G";

const string3 = "E";
const fret3 = 18;
const expectedOutput3 = "A#";

const string4 = "A";
const fret4 = 1;
const expectedOutput4 = "A#";

const string5 = "B";
const fret5 = 8;
const expectedOutput5 = "G";

// check
console.log(`Expected output: ${expectedOutput1}
Result is : ${whatNote(string1, fret1)}
`);
console.log(`Expected output: ${expectedOutput2}
Result is : ${whatNote(string2, fret2)}
`);
console.log(`Expected output: ${expectedOutput3}
Result is : ${whatNote(string3, fret3)}
`);
console.log(`Expected output: ${expectedOutput4}
Result is : ${whatNote(string4, fret4)}
`);
console.log(`Expected output: ${expectedOutput5}
Result is : ${whatNote(string5, fret5)}
`);
