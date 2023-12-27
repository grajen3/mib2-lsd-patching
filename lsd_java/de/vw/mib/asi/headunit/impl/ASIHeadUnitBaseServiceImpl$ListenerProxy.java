/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asi.headunit.impl;

import de.esolutions.fw.comm.asi.hmisync.headunit.CarConfiguration;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockDate;
import de.esolutions.fw.comm.asi.hmisync.headunit.ClockTime;
import de.esolutions.fw.comm.core.method.MethodException;
import de.vw.mib.asi.headunit.ASIHeadUnitListener;
import de.vw.mib.asi.headunit.impl.ASIHeadUnitBaseServiceImpl;

class ASIHeadUnitBaseServiceImpl$ListenerProxy
implements ASIHeadUnitListener {
    private final /* synthetic */ ASIHeadUnitBaseServiceImpl this$0;

    ASIHeadUnitBaseServiceImpl$ListenerProxy(ASIHeadUnitBaseServiceImpl aSIHeadUnitBaseServiceImpl) {
        this.this$0 = aSIHeadUnitBaseServiceImpl;
    }

    @Override
    public void updateCarConfiguration(CarConfiguration carConfiguration, boolean bl) {
        try {
            this.this$0.updateCarConfiguration(carConfiguration, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateClockDate(ClockDate clockDate, boolean bl) {
        try {
            this.this$0.updateClockDate(clockDate, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateClockTime(ClockTime clockTime, boolean bl) {
        try {
            this.this$0.updateClockTime(clockTime, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateDistanceUnit(int n, boolean bl) {
        try {
            this.this$0.updateDistanceUnit(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateExtCarConfiguration(int[] nArray, boolean bl) {
        try {
            this.this$0.updateExtCarConfiguration(nArray, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateLanguage1(int n, boolean bl) {
        try {
            this.this$0.updateLanguage1(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateLanguage2(String string, boolean bl) {
        try {
            this.this$0.updateLanguage2(string, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updatePressureUnit(int n, boolean bl) {
        try {
            this.this$0.updatePressureUnit(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateRegion(int n, boolean bl) {
        try {
            this.this$0.updateRegion(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSpeedUnit(int n, boolean bl) {
        try {
            this.this$0.updateSpeedUnit(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateSplashScreenCoding(short s, boolean bl) {
        try {
            this.this$0.updateSplashScreenCoding(s, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }

    @Override
    public void updateTemperatureUnit(int n, boolean bl) {
        try {
            this.this$0.updateTemperatureUnit(n, bl);
        }
        catch (MethodException methodException) {
            throw new RuntimeException(methodException);
        }
    }
}

