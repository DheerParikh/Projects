//Written by Dheer Parkih, Jude Cheng, and Michelle Tang, 2024
//Arduino Enabled Gyroscopic Computer Interface Peripheral
//Uses MPU9250 6-axis gyroscope and accelerometer

#include <MPU9250_asukiaaa.h>
#include <Mouse.h>
#ifdef _ESP32_HAL_I2C_H_
#define SDA_PIN 21
#define SCL_PIN 22
#endif

MPU9250_asukiaaa mySensor;
float aX, aY, aZ, aSqrt, gX, gY, gZ, mDirection, mX, mY, mZ;
// Anything with a represents acceleration, g and m represent gyroscopic values
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
    Serial.println("accelX: " + String(aX));
    Serial.println("accelY: " + String(aY));
    Serial.println("accelZ: " + String(aZ));
    Serial.println("accelSqrt: " + String(aSqrt));
  } else {
    Serial.println("Cannod read accel values " + String(result));
  }

  result = mySensor.gyroUpdate();
  if (result == 0) {
    gX = mySensor.gyroX();
    gY = mySensor.gyroY();
    gZ = mySensor.gyroZ();
    Serial.println("gyroX: " + String(gX));
    Serial.println("gyroY: " + String(gY));
    Serial.println("gyroZ: " + String(gZ));
// Taking gyroscopic values and assigning them to a new variable for easier coding and reading
    mX=gX;
    mY=gY;
    mZ=gZ;

//Checking to see if the x movement is great enough to move the mouse
   if (aX>0.4 || aX<-0.4){
    while (mX>-5 && mX<5 ){
      Mouse.move(0,(aX*10));
      aX = mySensor.accelX();
      aY = mySensor.accelY();
      aZ = mySensor.accelZ();
      if(aX>0.1 || aX<-0.1){
        Serial.print("end movement X");
        break;
      }
    }
  }  

//Checking to see if the Y movement is great enough to move the mouse
   if (aY>0.4 || aY<-0.4){
    while (mY>-5 && mY<5 ){
      Mouse.move((aY*10),0);
      aX = mySensor.accelX();
      aY = mySensor.accelY();
      aZ = mySensor.accelZ();
      if(aY>0.1 || aY<-0.1){
        Serial.print("end movement Y");
        break;
      }
    }
  }
// make the mouse left click
    if(aZ<-1.5){
      Mouse.press(MOUSE_LEFT);
      delay(100);
      Mouse.release(MOUSE_LEFT);
      delay(200);
    }
// make the mouse right click
    else if (mZ>220){
      Mouse.press(MOUSE_RIGHT);
      delay(100);
      Mouse.release(MOUSE_RIGHT);
      delay(200);
    }
    
  } else {
    Serial.println("Cannot read gyro values " + String(result));
  }

  /*result = mySensor.magUpdate();
  /*if (result != 0) {
    Serial.println("cannot read mag so call begin again");
    mySensor.beginMag();
    result = mySensor.magUpdate();
  }/*
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

  Serial.println("at " + String(millis()) + "ms");
  Serial.println("");  // Add an empty line
  delay(5);
}
