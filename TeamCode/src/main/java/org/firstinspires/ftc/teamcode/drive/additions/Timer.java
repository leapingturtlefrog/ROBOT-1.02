package org.firstinspires.ftc.teamcode.drive.additions;

import com.qualcomm.robotcore.util.ElapsedTime;

import java.util.concurrent.TimeUnit;

public class Timer {
    private double startTime, endTime, elapsedTime, timeOfTimer;
    private boolean used;

    ElapsedTime internalTimer;


    public Timer() {
        ElapsedTime internalTimer = new ElapsedTime(ElapsedTime.Resolution.SECONDS);
        elapsedTime = 0;
        used = false;

    }

    public double getElapsedTime() { return internalTimer.time(TimeUnit.SECONDS); }

    public double getTimeLeft() { return endTime - internalTimer.now(TimeUnit.SECONDS); }

    public boolean isUsed() { return used; }

    public void reset() { used = false; }

    public void stop() { elapsedTime += internalTimer.now(TimeUnit.SECONDS) - startTime; }

    //start after it has already been stopped
    public void startAfterStop() {
        startTime = internalTimer.now(TimeUnit.SECONDS);
        endTime = internalTimer.now(TimeUnit.SECONDS) + timeOfTimer - elapsedTime;

    }

    public void start(double elap) {
        timeOfTimer = elap;
        startTime = internalTimer.now(TimeUnit.SECONDS);
        endTime = startTime + elap;
        used = false;

    }

    public boolean isOver() {
        if (internalTimer.now(TimeUnit.SECONDS) >= endTime) {
            used = true;
            return true;
        }
        return false;

    }
}
