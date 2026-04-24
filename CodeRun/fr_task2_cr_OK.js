const moves = `R 12 D 2 R 2 U 1 R 2`;
const field = [
  "ooo------Y--AND------",
  "-----EXY--A--N---D--E",
  "-X-----Y--A-N---D----",
  "------EXY----A---N---",
  "--DE--X---------YA---",
  "-----ND---EXY--AN--D-",
  "----E-----X-Y----A--N",
  "D-----E-XY---AN---D--",
  "E--------------------",
  "-------X---Y------A-N",
  "----D-EX----------YA-",
  "--N-DEX--Y-A--N-----D",
  "E------X--Y----------",
];
let fieldPart = '';

console.log(fieldPart);

function solution (field, moves) {
  //initial data
  let arrOfMoves =  moves.split(" ").map(x => (x.match(/\d/) ? Number(x) : x));
  let currentTile = {y: 0, x: 2};
  let newTile = {y: 0, x: 0};
  let snakeLength = 3;
  
  for (let i = 0; i < arrOfMoves.length; i = i + 2) {
    let fieldPart = '';
    switch (arrOfMoves[i]) {
      case 'R':
        newTile.x = currentTile.x + arrOfMoves[i+1];
        fieldPart += field[currentTile.y].slice(currentTile.x, newTile.x);
        for(let i = 0; i < fieldPart.length; i++){
          if (fieldPart[i] !== '-') snakeLength++;
        };
        currentTile.x = newTile.x;
        break;
      case 'L':
        newTile.x = currentTile.x - arrOfMoves[i+1];
        fieldPart += field[currentTile.y].slice(newTile.x, currentTile.x);
        for(let i = 0; i < fieldPart.length; i++){
          if (fieldPart[i] !== '-') snakeLength++;
        };
        currentTile.x = newTile.x;
        break;
      case 'U':
        newTile.y = currentTile.y - arrOfMoves[i+1];
        for (let i = currentTile.y; i <= newTile.y; i++){
          fieldPart += field[i][currentTile.x];
        };
        for(let i = 0; i < fieldPart.length; i++){
          if (fieldPart[i] !== '-') snakeLength++;
        };
        currentTile.y = newTile.y;
        break;
      case 'D':
        newTile.y = currentTile.y + arrOfMoves[i+1];
        for (let i = newTile.y; i <= currentTile.y; i++){
          fieldPart += field[i][currentTile.x];
        };
        for(let i = 0; i < fieldPart.length; i++){
          if (fieldPart[i] !== '-') snakeLength++;
        };
        currentTile.y = newTile.y;
        break;
    }
  }
  return [[currentTile.y, currentTile.x], snakeLength];
}

console.log(solution(field, moves));