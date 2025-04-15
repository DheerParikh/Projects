// Written by Dheer Parkih, Jude Cheng, and Michelle Tang, 2024
// Arduino Enabled Gyroscopic Computer Interface Peripheral
// Uses MPU9250 6-axis gyroscope and accelerometer

#include <MPU9250_asukiaaa.h>
#include <SoftwareSerial.h> 
#include <Mouse.h>
#ifdef _ESP32_HAL_I2C_H_
#define SDA_PIN 21
#define SCL_PIN 22
#endif

MPU9250_asukiaaa mySensor;
float aX, aY, aZ, aSqrt, gX, gY, gZ, mDirection, mX, mY, mZ;

void setup() {
  Serial.begin(9600);
  Wire.begin();
  Mouse.begin();
  while (!Serial)
    ;
  Serial.println("started");

#ifdef _ESP32_HAL_I2C_H_  // For ESP32
  Wire.begin(SDA_PIN, SCL_PIN);
  mySensor.setWire(&Wire);
#endif
  mySensor.beginAccel();
  mySensor.beginGyro();
}


void loop() {
  uint8_t sensorId;
  int result;

  result = mySensor.readId(&sensorId);
  if (result == 0) {
    //Serial.println("sensorId: " + String(sensorId));
  } else {
    Serial.println("Cannot read sensorId " + String(result));
  }

  result = mySensor.accelUpdate();
  if (result == 0) {
    aX = mySensor.accelX();
    aY = mySensor.accelY();
    aZ = mySensor.accelZ();
    aSqrt = mySensor.accelSqrt();
    //Serial.println("accelX:" + String(aX));
    //Serial.println("accelY: " + String(aY));
    //Serial.println("accelZ:" + String(aZ));
    //Serial.println("accelSqrt: " + String(aSqrt));
  } else {
    Serial.println("Cannot read accel values " + String(result));
  }

  result = mySensor.gyroUpdate();
  if (result == 0) {
    gX = mySensor.gyroX();
    gY = mySensor.gyroY();
    gZ = mySensor.gyroZ();
   //Serial.println("gyroX:" + String(gX));
    //Serial.println("gyroY: " + String(gY));
    //Serial.println("gyroZ: " + String(gZ));
// Taking gyroscopic values and assigning them to a new variable for easier coding and reading
    //mX=gX;
    //mY=gY;
    //mZ=gZ;

// Checking to see if the x movement is great enough to move the mouse
   if (aX>0.4 || aX<-0.4){
    if (gX>-5 && gX<5 ){
      Mouse.move(0, (aX * 10));  // Move mouse on X-axis
      aX = mySensor.accelX();
      aY = mySensor.accelY();
      aZ = mySensor.accelZ();
      //if (aX > 0.1 || aX < -0.1) {
        //Serial.print("sit");
        //break;
      //}
    }
    // Print the mouse movement
    //Serial.print("X Mouse movement: ");
    //Serial.println(aX * 10);  // Print how much the X-axis moved
  }  

// Checking to see if the Y movement is great enough to move the mouse
   if (aY>0.4 || aY<-0.4){
    if (gY>-5 && gY<5 ){
      Mouse.move((aY * 10), 0);  // Move mouse on Y-axis
      aX = mySensor.accelX();
      aY = mySensor.accelY();
      aZ = mySensor.accelZ();
      //if (aY > 0.1 || aY < -0.1) {ååå
        //Serial.print("sit");
        //break;
      //}
    }
    // Print the mouse movement
    //Serial.print("Mouse movement: Y-axis moved by ");
    //Serial.println(aY * 10);  // Print how much the Y-axis moved
  }

// Make the mouse click
    if (aZ < -1.5) {
      //Serial.println("Left click");
      Mouse.press(MOUSE_LEFT);
      delay(100);
      Mouse.release(MOUSE_LEFT);
      delay(200);
    }
    else if (gZ > 220) {
      //Serial.println("Right click");
      Mouse.press(MOUSE_RIGHT);
      delay(100);
      Mouse.release(MOUSE_RIGHT);
      delay(200);
    }
    
  } else {
    Serial.println("Cannot read gyro values " + String(result));
  }

  /*result = mySensor.magUpdate();
  if (result != 0) {
    Serial.println("cannot read mag so call begin again");
    mySensor.beginMag();
    result = mySensor.magUpdate();
  }
  if (result == 0) {
    mX = mySensor.magX();
    mY = mySensor.magY();
    mZ = mySensor.magZ();
    mDirection = mySensor.magHorizDirection();
    Serial.println("magX: " + String(mX));
    Serial.println("maxY: " + String(mY));
    Serial.println("magZ: " + String(mZ));
    Serial.println("horizontal direction: " + String(mDirection));
  } else {
    //Serial.println("Cannot read mag values " + String(result));
  }*/

  //Serial.println("at " + String(millis()) + "ms");
  //Serial.println("");  // Add an empty line
  delay(5);
}
