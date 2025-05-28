/*
Add to result string lower case inputString and vowels to uppercase
*/

function changeVowels (input) {
  let result = "";

  let regex = /[уёеаоэяию]/;

  for (let i = 0; i < input.length; i++) {
    result += regex.test(input[i].toLowerCase()) ? 
      input[i].toUpperCase() :
      input[i].toLowerCase();
  }
  return result;
};


//tests
const data1 = 'Азбука Вкуса';

console.log(changeVowels(data1)); 
/*
Expected output:
АзбУкА вкУсА
*/