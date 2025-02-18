// Для чтения входных данных в Node.js необходимо использовать
// модуль readline, который работает с потоком ввода-вывода
// (stdin/stdout) и позволяет читать строки.
const readline = require('readline');
const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Считывание данных из нескольких строк в переменную
let input = [];
rl.on('line', line => {
    input.push(line);
});

// Код решения можно писать внутри функции закрытия потока ввода
rl.on('close', () => {
  console.log(input)
  // Чтобы вывести результат в поток вывода (stdout),
  // можно использовать метод console.log().
});