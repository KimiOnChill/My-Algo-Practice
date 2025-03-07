//initial conditions
const graph = {
  start : {A : 6, B : 2},
  A : {end: 1},
  B : {A : 3, end : 5},
  end: {}
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
  };
  
  let processed = [];
  
  //algo work
  function Deixtra () {
  let node = lowestCost(costs);
  
  for (key of node) {
  if (key.value < cost.key.value) {
    cost.key.value = key.value;
    parent.key = key;
  }
  processed.push(node);
  }
  
  function lowestCost(map) {
  map.filter((x) => xNotIncludes.processed  && isMin(x));
  }
  }