/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;

//THIS IS A TEST

import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Accelerometer;
import edu.wpi.first.wpilibj.SensorBase;
import edu.wpi.first.wpilibj.ADXL345_I2C;
import edu.wpi.first.wpilibj.AnalogChannel;
import edu.wpi.first.wpilibj.DriverStationLCD;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.camera.AxisCamera;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
        RobotDrive drive = new RobotDrive(1, 2);
        Joystick leftStick = new Joystick(1);
        Joystick rightStick = new Joystick(2);
        Joystick thirdstick = new Joystick(3);
//        private Compressor compressor = new Compressor(1,2);
        Victor motor = new Victor(4);
        AnalogChannel channel = new AnalogChannel(2);
        Accelerometer sensor = new Accelerometer(channel);
        
        Gyro g = new Gyro(1); 
        int x;
        

        double left;
        double sensorread;
        
        AxisCamera camera = AxisCamera.getInstance();
 
       
        
    

        
    public void autonomous() {
        //for (int j = 0; j < 10; j++){
        //for (int i = 0; i < 50; i++) {
           // if (i < 10){
        boolean get = false;
        int Defualt;
        int Next = 0;
        int Current = 0;
        
        drive.tankDrive(1, 1);
        Timer.delay(500);
        drive.tankDrive(0, 0);
        for(int r = 1; r<5; r = r++){
                if(get == false){
                  Defualt = (int) g.getAngle();
                  Next = Defualt+90;
                  
                }
                while(Current <= Next){
                Current = (int) g.getAngle();
                drive.tankDrive(-1, 1);
        
        }
                
        }     
          // }else{
        //drive.tankDrive(-1, 1); //turn right
        //Timer.delay(2.5); // wait 2 seconds
        
         // drive 0% forward with 75% turn
        //Timer.delay(0.01); // wait for the 90 degree turn to complete
        }
       // }
        //drive.drive(-1.0, 0.0); // drive 0% forward with 0% turn (stop)
   // }
   // }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        
        while (isOperatorControl() && isEnabled())
        {
             
             
             drive.tankDrive(leftStick, rightStick);
             
            // left = leftStick.getAxis(Joystick.AxisType.kY);
             //sensorread = sensor.getAcceleration();
             AxisCamera camera = AxisCamera.getInstance();
             DriverStationLCD.getInstance().updateLCD();
 
              
             
             //drive.arcadeDrive(thirdstick);
             
             //sensorread = sensor.getAcceleration();
             System.out.println(sensorread);
             //System.out.println(right);
             Timer.delay(0.005);
        }
    }
}
