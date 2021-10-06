const counter = document.getElementById('counter');

const increment = document.querySelector('.inc');

const decrement = document.querySelector('.dec');

let count = 0;

increment.addEventListener("click", function() {

    count++;
    counter.innerHTML = count;
});

decrement.addEventListener("click", function() {

    count--;
    counter.innerHTML = count;
});