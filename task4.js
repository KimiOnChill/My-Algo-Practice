// time on first two items is always 1
// t[1]=t[2]=1
// time on following up to 35 will be 
// t[i]=t[i−1]+t[i−2]
// Output time for each item
// 5 => 12
// 21 => 28656
// 32 => 5702886
// 33 => 9227464

function timeCount (i) {
  i = i[0]*1; //convert to number
  let t = [0, 1, 1]; //[0,1,1,2,3,5]
  let counter = 3;

  if (i === 1 || i === 2) {
    return 1;
  }

  while (counter <= i) {
    let calc = t[counter-1] + t[counter-2];
    /*console.log(`calc => ${calc}`);
    console.log(`counter => ${counter}`);*/
    t.push(calc);
    counter ++;
  }

  return t.reduce((acc, x) => acc + x, 0);
}

console.log(`On input '5' => ${timeCount (['5'])}`);
console.log(`On input '21' => ${timeCount (['21'])}`);
console.log(`On input '32' => ${timeCount (['32'])}`);
console.log(`On input '33' => ${timeCount (['33'])}`);