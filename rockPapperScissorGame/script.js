//variable to fetch the essential dom elements
let computerPointFeild = document.querySelector(".computer-point .point");
let userPointFeild = document.querySelector(".human-point .point");
let mainRpsButton = document.querySelectorAll(".choice button");
let banner = document.querySelector(".starter");
let bannerText = document.querySelector(".starter span");
let gameMovesReflector = document.querySelector(".game-controls .currentMoves span");
// let rockButton = document.querySelector(".rock");
// let paperButton = document.querySelector(".paper");
// let scissorButton = document.querySelector(".scissor");
//private variable to control the game nature
let started = false;
let numberMovesDone = userPoint = computerPoint = draw = 0;
//helper method for the smooth working of the game
//method to convert the user click to the corresponding number
const stringToNumber = (string) =>{
    let stringDic = {
        "rock" :0,
        "paper":1,
        "scissor":2
    }
    return stringDic[string];
}
//for converting computer selection to the string
const numberToString = (number) =>{
    let numberDic = {
        0 :"rock",
        1 : "paper",
        2 : "scissor"
    }
    return numberDic[number];
}
//for returning random value from the 0-2 (int)
const computerSelection = () =>{
    return Math.floor(Math.random()*3);
}
//for changing the points of won condestent
const makeProgresion = (winner) =>{
    if (winner == "user"){
        userPoint += 1;
        userPointFeild.innerHTML = userPoint;
    }else{
        computerPoint +=1;
        computerPointFeild.innerHTML = computerPoint;
    }
}
//for doing the user vs computer dynamic text
const showAnimation = (computerMove , userMove) =>{
    gameMovesReflector.innerHTML =`${computerMove} Vs ${userMove}`;
}
const gameOver = () =>{
    console.log("gameOver is called")
    if (userPoint > computerPoint){
        bannerText.innerHTML = "you won <br>press any key to play again ";
    }else{
        bannerText.innerHTML = "better luck next time <br>press any key to play again";
    }
    banner.style.display = "grid";
    computerPoint = userPoint = numberMovesDone = 0;
    computerPointFeild.innerHTML = userPointFeild.innerHTML = 0;
    gameMovesReflector.innerHTML = "";
    started = false;
}
//move validation and retrieve who got the point
const evaluteUserMove = (selection) =>{
    if (numberMovesDone < 3){
        let userChoice = stringToNumber(selection);
        let computerChoice = computerSelection();
        let validator = ( userChoice - computerChoice ) % 3;
        let correctedValidator = validator < 0 ?  validator+3 : validator;
        showAnimation(numberToString(computerChoice),selection);
        if (correctedValidator == 1) {
            makeProgresion("user")
        }
        else if (correctedValidator == 2){
            makeProgresion("computer")
        }else{
            draw++;
        }
        numberMovesDone++;
    };
    if(numberMovesDone == 3){
        setTimeout(()=>{gameOver()},2000)
        // gameOver();
    };
}
//eventlistner for each button
mainRpsButton.forEach((button) =>{
    button.addEventListener("click", () =>{evaluteUserMove(button.name)})
})
//for contorolling the entier game
const startGame = () => {
    banner.style.display = 'none';
}
//setting an keypress event to to start the game 
document.addEventListener("keypress" ,() =>{started?console.log("game ongoing"):startGame();})