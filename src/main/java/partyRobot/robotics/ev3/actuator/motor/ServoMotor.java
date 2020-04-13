package partyRobot.robotics.ev3.actuator.motor;

import ev3dev.actuators.lego.motors.BasicMotor;
import lejos.hardware.port.Port;

public class ServoMotor extends BasicMotor {

    /**
     * Constructor
     *
     * @param motorPort port
     */
    public ServoMotor(Port motorPort) {
        super(motorPort);
    }
}
