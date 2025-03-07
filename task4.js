// time on first two items is always 1
// t[1]=t[2]=1
// time on following up to 35 will be 
// t[i]=t[i−1]+t[i−2]
// Output time for each item
// 5 -> 12
// 21 -> 28656
// 32 -> 5702886
// 33 -> 9227464

let results = {
  '1': 1,
  '2': 2,
  '3': 4 ,
  '4': 7 ,
  '5': 12 ,
  '6': 20 ,
  '7': 33 ,
  '8': 54 ,
  '9': 88  ,
  '10': 143 ,
  '11': 232 ,
  '12': 376 ,
  '13': 609 ,
  '14': 986 ,
  '15': 1596 ,
  '16': 2583,
  '17': 4180,
  '18': 6764,
  '19': 10945,
  '20': 17710,
  '21': 28656 ,
  '22': 46367,
  '23': 75024 ,
  '24':	121392,
  '25': 196417,
  '26':	317810,
  '27':	514228,
  '28':	832039,
  '29':	1346268,
  '30':	2178308,
  '31':	3524577,
  '32':	5702886,
  '33':	9227464,
  '34':	14930351,
  '35':	24157816
}

function timeCount (i) {
  i = i[0]*1; //convert to number
  let t = [0, 1, 1];
  let counter = 3;

  if (i <= 0 ) {
    return 'Input must be integer from 1 to 0';
  }

  if (i === 1 || i === 2) {
    return i;
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

for (key of Object.keys(results)) {
  console.log(`On input '${key}' => ${timeCount (key)} ${timeCount (key) === results.key ? 'OK' : 'ERORR'}`);
}




/*
console.log(`On input '1' => ${timeCount (['1'])}`);
console.log(`On input '2' => ${timeCount (['2'])}`);
console.log(`On input '3' => ${timeCount (['3'])}`);
console.log(`On input '4' => ${timeCount (['4'])}`);
console.log(`On input '5' => ${timeCount (['5'])}`);
console.log(`On input '21' => ${timeCount (['21'])}`);
console.log(`On input '32' => ${timeCount (['32'])}`);
console.log(`On input '33' => ${timeCount (['33'])}`);
tag	time on each	time summ
0	0	
1	1	1 ok
2	1	2 ok
3	2	4 ok
4	3	7 ok
5	5	12 ok
6	8	20 ok
7	13	33 ok
8	21	54 ok
9	34	88 ok 
10	55	143 ok
11	89	232 ok
12	144	376 ok
13	233	609 ok
14	377	986 ok
15	610	1596 ok
16	987	2583
17	1597	4180
18	2584	6764
19	4181	10945
20	6765	17710
21	10946	28656 not here
22	17711	46367
23	28657	75024 not here
24	46368	121392
25	75025	196417
26	121393	317810
27	196418	514228
28	317811	832039
29	514229	1346268
30	832040	2178308
31	1346269	3524577
32	2178309	5702886
33	3524578	9227464
34	5702887	14930351
35	9227465	24157816
*/