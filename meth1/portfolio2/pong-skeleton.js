var ballX;              // x-location of the ball
var ballY;              // y-location of the ball
var ballSpeedX = 5;     // speed of the ball horizontally
var ballSpeedY = 5;     // speed of the ball vertically
var paddleHeight = 30;  // height of the paddle

function setup() {
  createCanvas(800, 600);   // canvas size
  noCursor();       // hides the mouse
  ballX = width/2;  // start the ball in the
  ballY = height/2; // middle of the canvas
}

function draw() {
  background(128); // resets the background
  drawBall();      // draws ball
  moveBall();      // ball moves in X and Y directions
  drawPaddle();    // draws paddle
  checkCollide();  // checks for collision with walls or paddle
}

function drawBall() {

}

function moveBall() {

}

function drawPaddle() {

}

function checkCollide() {

}
