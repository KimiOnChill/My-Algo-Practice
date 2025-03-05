//initial conditions
const graph = {
  start : {A : 6, B : 2},
  A : {end: 1},
  B : {A : 3, end : 5}
  };
  
  let costs = {
  A : 6,
  B : 2,
  end : infinity
  };
  
  let parents = {
  A : start,
  B : start,
  end: undefined
  }
  
  let processed = [];
  
  //algo work