#include <Adafruit_NeoPixel.h>
#define LEDPIN 13 // connect the Data from the strip to this pin on the Arduino
#define NUMBER_PIXELS 60 // the number of pixels in your LED strip
Adafruit_NeoPixel strip = Adafruit_NeoPixel(NUMBER_PIXELS, LEDPIN, NEO_RGBW + NEO_KHZ800);
 
const int climb1 = 2;
const int hatch1 = 3;
//const int echoPin2 = 8;
//const int trigPin2 = 7; //echo and trig pins for the hatch
const int climb2 = 4;
float duration1, duration2, duration3, distance1, distance2, distance3;

int delayTime = 5; // 1/10 of a second
int IRLeft = 5; 
int IRCenter = 6;
int IRRight= 7;
int IRLED = 9; //cargo IR

void setup() {
  Serial.begin(9600);
  strip.begin(); // initialize the strip0  strip.show();
  pinMode(IRLED, INPUT);
  pinMode(IRLeft, INPUT);
  pinMode(IRCenter, INPUT);
  pinMode(IRRight, INPUT);
}

//grb

void loop() {
  //strip.setPixelColor(25, 50, 50, 50);
  //strip.setPixelColor(5, 50, 50, 50);
  /*for (int i = 0; i < strip.numPixels() / 2; i++) {
     // chasing(i, delayTime);
     //chasing(i+30, delayTime);
     solid(i, 10, 200, 250);
     solid(i+30, 10, 100, 120);
  }*/
  cargo();
  hatch();
  IRLine();
  ultrasonic();
  
  if(cargo() == false && hatch() == false){
    for (int i = 0; i < strip.numPixels() / 2; i++) {
        chasing(i, delayTime);
        chasing(i+30, delayTime);
      }
    }else if(cargo()==true && hatch()==true){
      for (int i = 0; i < strip.numPixels() / 2; i++) {
        solid(i, 10, 200, 255); //purple
    }
  }else if(cargo()==true && hatch() == false){
    for (int i = 0; i < strip.numPixels() / 2; i++) {
      solid(i, 10, 200, 255); //purple
    }
  }else if(hatch()==true && cargo() == false){
    for (int i = 0; i < strip.numPixels() / 2; i++){
        solid(i, 255, 0, 0); //green
    }
   
  }
 } 

void solid(uint16_t i, int g, int r, int b){
  int np = strip.numPixels();
  for(int i = 0; i < np / 2; i++){
    strip.setPixelColor(i % np, g, r, b);
    strip.show(); 
  }
}

boolean cargo(){
  Serial.println(digitalRead(IRLED));
  if(digitalRead(IRLED) == 0){
    return true;
  }else{
    return false;
  }
  
}

boolean hatch(){
  // Clears the trigPin 
  pinMode(hatch1, OUTPUT);
  digitalWrite(hatch1, LOW); 
  delayMicroseconds(5); 
  //Sets the trigPin on HIGH state for 10 micro seconds 
  digitalWrite(hatch1, HIGH); 
  delayMicroseconds(5); 
  digitalWrite(hatch1, LOW); 
  delayMicroseconds(5);

  // Reads the echoPin, returns the sound wave travel time in microseconds 
  pinMode(hatch1, INPUT);
  duration2 = pulseIn(hatch1, HIGH);  
  // Calculating the distance 
  distance1 = (duration2/29)/2/2.94; 
  Serial.println("distance 1 = " + (String)distance1);
  if(0 < distance1 && distance1 < 10){
    return true;
  }else{
    return false;
  }
}

void chasing(uint16_t i, uint16_t wait) { 
    int np = strip.numPixels();  // we use the modulo function with this
    strip.setPixelColor((i) % np, 10, 200, 255);       
    strip.setPixelColor((i+1) % np, 10, 200, 255);       
    strip.setPixelColor((i+2) % np, 10, 200, 255);       
    strip.setPixelColor((i+3) % np, 10, 200, 255);    
    strip.setPixelColor((i+4) % np, 255, 0, 0);    
    strip.setPixelColor((i+5) % np, 255, 0, 0);    
    strip.setPixelColor((i+6) % np, 255, 0, 0);
    strip.setPixelColor((i+7) % np, 255, 0, 0);
    strip.show();
    delay(wait);
    strip.setPixelColor((i+8) % np, 10, 200, 255);       
    strip.setPixelColor((i+9) % np, 10, 200, 255);       
    strip.setPixelColor((i+10) % np, 10, 200, 255);       
    strip.setPixelColor((i+11) % np, 10, 200, 255);    
    strip.setPixelColor((i+12) % np, 255, 0, 0);    
    strip.setPixelColor((i+13) % np, 255, 0, 0);    
    strip.setPixelColor((i+14) % np, 255, 0, 0);
    strip.setPixelColor((i+15) % np, 10, 200, 255);
    strip.show();
    delay(wait);
    strip.setPixelColor((i+16) % np, 10, 200, 255);       
    strip.setPixelColor((i+17) % np, 10, 200, 255);       
    strip.setPixelColor((i+18) % np, 10, 200, 255);       
    strip.setPixelColor((i+19) % np, 10, 200, 255);    
    strip.setPixelColor((i+20) % np, 255, 0, 0);    
    strip.setPixelColor((i+21) % np, 255, 0, 0);    
    strip.setPixelColor((i+22) % np, 255, 0, 0);
    strip.setPixelColor((i+23) % np, 255, 0, 0);
    strip.show();
    delay(wait);
}

void IRLine(){
  int left = digitalRead(IRLeft);
  int right = digitalRead(IRRight);
  int center = digitalRead(IRCenter);
  Serial.println((String)left + "" + (String)center+ "" + (String)right);
}

void ultrasonic(){
  // Clears the trigPin
  pinMode(climb1, OUTPUT); 
  digitalWrite(climb1, LOW); 
  delayMicroseconds(5); 
  //Sets the trigPin on HIGH state for 10 micro seconds 
  digitalWrite(climb1, HIGH); 
  delayMicroseconds(5); 
  digitalWrite(climb1, LOW); 
  delayMicroseconds(5);

  // Reads the echoPin, returns the sound wave travel time in microseconds 
  pinMode(climb1, INPUT);
  duration1 = pulseIn(climb1, HIGH);  
  // Calculating the distance 
  distance2 = (duration1/29)/2/2.94; 
  Serial.println("distance 2= " + (String)distance2);
  Serial.println();
  
  pinMode(climb2, OUTPUT);
  digitalWrite(climb2, LOW); 
  delayMicroseconds(5); 
  //Sets the trigPin on HIGH state for 10 micro seconds 
  digitalWrite(climb2, HIGH); 
  delayMicroseconds(5); 
  digitalWrite(climb2, LOW); 
  delayMicroseconds(5);

  // Reads the echoPin, returns the sound wave travel time in microseconds 
  pinMode(climb2, INPUT);
  duration3 = pulseIn(climb2, HIGH);  
  // Calculating the distance 
  distance3 = (duration3/29)/2/2.94; 
  Serial.println("distance 3 = " + (String)distance3);
  Serial.println();
}
