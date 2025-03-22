function leastCommon(arr) {
  //placing in order
  arr.sort();
  
  //if two consequtive nums
  if (arr[1]-arr[0] == 1){
    let result = arr[0]*arr[1]; 
    return result;
  }

  //make array of whole numbers 
  for (let i = arr[0]+1; i < arr[1]; i++){
    arr.push(i);
  }
  arr.sort((a,b)=>a-b);
  console.log(arr);

  //multiple first and last nums for saving a bit of time
  let result = arr[arr.length-3]*arr[arr.length-2]*arr[arr.length-1];
  console.log(result);
  //checking if it`s a  common multiple for each
  //if not add 1 and check again
  function check(y, aarr){
         let chek = aarr.map((x) => y % x);//checking if has reminder after dividing
         console.log(chek);
         if (chek.every(function(x){return x == 0}) == false){
           y++;
           return check(y, aarr);
         }
         else if (chek.every(function(x){return x == 0}) == true){
           return y;
         }
    }  

return check(result,arr);
}

console.log(leastCommon([2,10]));