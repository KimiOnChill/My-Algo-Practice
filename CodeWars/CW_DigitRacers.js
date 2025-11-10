const input = "322232233311110";

function digitRacers(str) {
  const digits = {};
  for (let i = 0; i < str.length; i++) {
    if (digits.hasOwnProperty(`${str[i]}`)) {
      digits[`${str[i]}`][0] ++;
      digits[`${str[i]}`][1] = i;
    } else {
      digits[`${str[i]}`] = [1, str.indexOf(`${str[i]}`)];
    }
  };
  console.log(digits);
  let arrOrder = (Object.entries(digits).sort(function (a,b) {
    if (a[1][0] == b[1][0]){
      return  b[1][1] - a[1][1];
    } else{
      return b[1][0] - a[1][0];
    }
  }));
  console.log(arrOrder);
  let realDigits = "0123456789";
  let placeCount = 1;
  let result = `1st place: ${arrOrder[0][0]}`;
  realDigits = realDigits.replace(`${arrOrder[0][0]}`, "");
  for (let i = 1; i < arrOrder.length; i++) {
    if (arrOrder[i][1][0] === arrOrder[i-1][1][0]) {
      result += `, ${arrOrder[i][0]}`;
      realDigits = realDigits.replace(`${arrOrder[i][0]}`, "");
    } else {
      placeCount++;
      switch(placeCount) {
        case 2:
          result += `\n2nd place: ${arrOrder[i][0]}`;
          realDigits = realDigits.replace(`${arrOrder[i][0]}`, "");
          break;
        case 3:
          result += `\n3rd place: ${arrOrder[i][0]}`;
          realDigits = realDigits.replace(`${arrOrder[i][0]}`, "");
          break;
        default: 
          result += `\n${placeCount}th place: ${arrOrder[i][0]}`;
          realDigits = realDigits.replace(`${arrOrder[i][0]}`, "");
          break;
      }
    }
  }
  if (realDigits == ""){
    result += "\nAll digits present";
  } else {
    result += `\nAbsent digits: `;
    for  (let i = 0; i < realDigits.length; i++) {
      result += `${realDigits[i]}, `;
    }
    result = result.slice(0, -2);
  }
  return result;
}
console.log(digitRacers('01234567899876543210'));