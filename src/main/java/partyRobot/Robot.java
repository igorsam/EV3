package partyRobot;

import ev3dev.actuators.lego.motors.EV3LargeRegulatedMotor;
import ev3dev.actuators.lego.motors.EV3MediumRegulatedMotor;
import ev3dev.sensors.Battery;
import lejos.hardware.port.MotorPort;
import lejos.utility.Delay;

public class Robot {

    public static void main(final String[] args){

        System.out.println("Creating Motor A & B");
        final EV3LargeRegulatedMotor motorLeft = new EV3LargeRegulatedMotor(MotorPort.A);
        final EV3LargeRegulatedMotor motorRight = new EV3LargeRegulatedMotor(MotorPort.B);

        System.out.println("Creating Basic Motor");
        final EV3MediumRegulatedMotor servoMotor = new EV3MediumRegulatedMotor(MotorPort.D);

        //To Stop the motor in case of pkill java for example
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            public void run() {
                System.out.println("Emergency Stop");
                servoMotor.stop();
                motorLeft.stop();
                motorRight.stop();
            }
        }));

        System.out.println("Defining Running-Duration of Motors");
        final int durationAB = 8000;
        final int durationServo = 2000;

        System.out.println("Defining the Stop mode");
        motorLeft.brake();
        motorRight.brake();
        servoMotor.brake();

        System.out.println("Defining basic motor speed");
        final int servoMotorSpeed = 200;
        servoMotor.setSpeed(servoMotorSpeed);

        System.out.println("Defining motor speed");
        final int motorSpeedForward = 500;
        motorLeft.setSpeed(motorSpeedForward);
        motorRight.setSpeed(motorSpeedForward);

        System.out.println("Close basic motor");
        servoMotor.forward();

        Delay.msDelay(durationServo);

        System.out.println("Go Forward with the motors A & B");
        motorLeft.forward();
        motorRight.forward();

        Delay.msDelay(durationAB);

        System.out.println("Stop motors A & B");
        motorLeft.stop();
        motorRight.stop();

        Delay.msDelay(1000);

        System.out.println("Open servo motor");
        servoMotor.backward();

        Delay.msDelay(durationServo);

        System.out.println("Stop basic motor");
        servoMotor.stop();

        Delay.msDelay(5000);

        System.out.println("Defining motor backward speed");
        final int motorSpeedBackward = 250;
        motorLeft.setSpeed(motorSpeedBackward);
        motorRight.setSpeed(motorSpeedBackward);

        System.out.println("Go Backward with the motors");
        motorLeft.backward();
        motorRight.backward();

        Delay.msDelay((durationAB * 2));

        System.out.println("Stop motors A & B");
        motorLeft.stop();
        motorRight.stop();

        System.out.println("Checking Battery");
        System.out.println("Votage: " + Battery.getInstance().getVoltage());

        System.exit(0);
    }
}
