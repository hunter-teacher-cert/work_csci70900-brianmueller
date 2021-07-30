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
  drawPaddle();    // re-draws paddle
  checkCollide();  // checks for collision with walls or paddle
}

function drawBall() {
  noStroke(); // no outline needed
  ellipse(ballX, ballY, 20, 20); // draw ball at current location, constant diameter
}

function moveBall() {
  ballX = ballX + ballSpeedX; // updates ball location horizontally
  ballY = ballY + ballSpeedY; // updates ball location vertically

  // monitor speed/direction of ball
  console.log("ballSpeedX: " + ballSpeedX + ", ballSpeedY: " + ballSpeedY);
}

function drawPaddle() {
  stroke(0);       // color of paddle border
  strokeWeight(4); // border thickness of 4px

  // y-value is always at the bottom, minus height of paddle, minus border of paddle
  rect(mouseX, height-paddleHeight-4, 200, paddleHeight);
}

function checkCollide() {
  // left/right edge
  if (ballX < 0 || ballX > width) {
    ballSpeedX = ballSpeedX * -1; // switch X direction
  }

  // top edge
  if (ballY < 0) {
    ballSpeedY = ballSpeedY * -1; // switch Y direction
  }

  // paddle
  if (ballY > height-paddleHeight) { // past 'goal line'
    if (ballX > mouseX && ballX < mouseX + 200) { // within paddle
      ballSpeedY = ballSpeedY * -1; // switch Y direction
    } else { // end game
      text("GAME OVER!", width/2, height/2);
      noLoop();
    }
  }
}
