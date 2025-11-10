function countYandexoid (N, staff, K) {
  sortedStaf = staff.sort((a, b) => b-a);
  let res = 0;
  for (let i = 0; i < K; i++){
    res+=sortedStaf[i]
  } 
  return res;
}

console.log(countYandexoid(5, [10,1,23,0,1], 2));