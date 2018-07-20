package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name = "Arcade1")
public class Arcade1 extends LinearOpMode
{
    private DcMotor LeftDrive;
    private DcMotor RightDrive;

    private Servo blockServo;
    private Servo clawServo;

    private static final double bGrab = 0.95;
    private static final double bRelease = 0.4;

    private static final double cGrab = 0.1;
    private static final double cRelease = 0.5;
    private static final double cAway = 1.0;





    @Override
    public void runOpMode() throws InterruptedException
    {
        LeftDrive = hardwareMap.dcMotor.get("Left Drive Motor");
        RightDrive = hardwareMap.dcMotor.get("Right Drive Motor");

        LeftDrive.setDirection(DcMotor.Direction.REVERSE);

        blockServo = hardwareMap.servo.get("Block Servo");
        clawServo = hardwareMap.servo.get("Claw Servo");

        blockServo.setPosition(bRelease);
        clawServo.setPosition(cRelease);

        waitForStart();

        while (opModeIsActive())
        {
            LeftDrive.setPower(-gamepad1.left_stick_y);
            RightDrive.setPower(-gamepad1.right_stick_y);

            if (gamepad1.a)
            {
                blockServo.setPosition(bGrab);
                clawServo.setPosition(cAway);
            }

            if (gamepad1.y)
            {
                clawServo.setPosition(cRelease);
                blockServo.setPosition(bRelease);
            }

            if (gamepad1.b)
            {
                blockServo.setPosition(bGrab);
                clawServo.setPosition(cGrab);
            }

            if (gamepad1.x)
            {
                clawServo.setPosition(cRelease);
                blockServo.setPosition(bRelease);
            }


            idle();
        }
    }
}
