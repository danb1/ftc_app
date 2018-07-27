package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

@TeleOp(name = "DanT")
public class DanTele extends LinearOpMode
{
    //declare drive motors
    private DcMotor lMotor;
    private DcMotor rMotor;

    @Override
    public void runOpMode() throws InterruptedException
    {
        //Init Drive
        lMotor = hardwareMap.dcMotor.get("LeftMotor");
        rMotor = hardwareMap.dcMotor.get("RightMotor");


        //waits for the start button to be pressed
        waitForStart();

        //run this code while in the main OpMode
        while (opModeIsActive())
        {
            //Tank drive
            lMotor.setPower(-gamepad1.left_stick_y);
            rMotor.setPower(-gamepad1.right_stick_y);

            // give hardware a chance to catch up
            idle();
        }

    }
}
