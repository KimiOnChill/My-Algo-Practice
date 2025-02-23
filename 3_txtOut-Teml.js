const fs = require("fs");
/*
Async = fs.readFile()
Sync = fs.readFileSync()
*/ 
let input = [];

fs.readFile("input.txt", function(error,data){
    if(error) {  // если возникла ошибка
        return console.log(error);
    }
    input.push(data);   // выводим считанные данные
});

let nums = input[0].split(" ");
let result = nums[0]*1 + nums[1]*1;

fs.appendFileSync("output.txt", result);

/*
/синхронное добавление
fs.appendFileSync("hello2.txt", "Hello word\n");
 
/асинхронное добавление
fs.appendFile("hello2.txt", "Hello walk\n", function(error){
    if(error) return console.log(error); // если возникла ошибка
                 
    console.log("Запись файла завершена");
});
*/