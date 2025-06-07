/*
regex to first word
return this word inside closin tag
*/

function htmlEndTagByStartTag(startTag) {
  const regex = /\w+\b/i;
  const word = startTag.match (regex);
  return `</${word}>`;
}


//tests
const data1 = "<button type='button' disabled>";
const expectedOutput1 = `</button>`;

const data2 = "i";
const expectedOutput2 = `</i>`;

const data3 = "<div id='my_area' class='data' title='This is a test for title on Div tag'>";
const expectedOutput3 = `</div>`;

const data4 = "<a b='te' qglxst='dxeduq' cgnn='gpn' gd='ygfyy' ua='mep'>";
const expectedOutput4 = `</a>`;

const data5 ="<zebe tt='bzzxqd' qveur='ugrbh' tflq='odmo' zb='mvpafj'>";
const expectedOutput5 = `</zebe>`;

// check
console.log(`Expected output: ${expectedOutput1}
Result is : ${htmlEndTagByStartTag(data1)}
`);
console.log(`Expected output: ${expectedOutput2}
Result is : ${htmlEndTagByStartTag(data2)}
`);
console.log(`Expected output: ${expectedOutput3}
Result is : ${htmlEndTagByStartTag(data3)}
`);
console.log(`Expected output: ${expectedOutput4}
Result is : ${htmlEndTagByStartTag(data4)}
`);
console.log(`Expected output: ${expectedOutput5}
Result is : ${htmlEndTagByStartTag(data5)}
`);