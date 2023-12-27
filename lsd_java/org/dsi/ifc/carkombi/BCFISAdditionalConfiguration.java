/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class BCFISAdditionalConfiguration {
    public boolean fis1;
    public boolean fis2;
    public boolean fis3;
    public boolean stopWatch;
    public boolean oilTemp;
    public boolean digitalSpeed;
    public boolean refuelVolume;
    public boolean speedWarning;
    public boolean coolantTemp;
    public boolean secondarySpeed;
    public boolean vza;
    public boolean resetTime;
    public boolean comfortPowerConsumption;
    public boolean zeroEmissionTime;
    public boolean zeroEmissionDistance;
    public boolean vzaMfa;
    public boolean bcmeConsumerList;
    public boolean bcmeLiveTips;
    public boolean astaMfa;

    public BCFISAdditionalConfiguration() {
        this.stopWatch = false;
        this.oilTemp = false;
        this.digitalSpeed = false;
        this.refuelVolume = false;
        this.speedWarning = false;
        this.coolantTemp = false;
        this.secondarySpeed = false;
        this.vza = false;
        this.fis1 = false;
        this.fis2 = false;
        this.fis3 = false;
        this.resetTime = false;
        this.comfortPowerConsumption = false;
        this.zeroEmissionTime = false;
        this.zeroEmissionDistance = false;
        this.vzaMfa = false;
        this.bcmeConsumerList = false;
        this.bcmeLiveTips = false;
        this.astaMfa = false;
    }

    public BCFISAdditionalConfiguration(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18) {
        this.stopWatch = bl4;
        this.oilTemp = bl5;
        this.digitalSpeed = bl6;
        this.refuelVolume = bl7;
        this.speedWarning = bl8;
        this.coolantTemp = bl9;
        this.secondarySpeed = bl10;
        this.vza = bl11;
        this.fis1 = bl;
        this.fis2 = bl2;
        this.fis3 = bl3;
        this.resetTime = bl12;
        this.comfortPowerConsumption = bl13;
        this.zeroEmissionTime = bl14;
        this.zeroEmissionDistance = bl15;
        this.vzaMfa = bl16;
        this.bcmeConsumerList = bl17;
        this.bcmeLiveTips = bl18;
        this.astaMfa = false;
    }

    public BCFISAdditionalConfiguration(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12, boolean bl13, boolean bl14, boolean bl15, boolean bl16, boolean bl17, boolean bl18, boolean bl19) {
        this.stopWatch = bl4;
        this.oilTemp = bl5;
        this.digitalSpeed = bl6;
        this.refuelVolume = bl7;
        this.speedWarning = bl8;
        this.coolantTemp = bl9;
        this.secondarySpeed = bl10;
        this.vza = bl11;
        this.fis1 = bl;
        this.fis2 = bl2;
        this.fis3 = bl3;
        this.resetTime = bl12;
        this.comfortPowerConsumption = bl13;
        this.zeroEmissionTime = bl14;
        this.zeroEmissionDistance = bl15;
        this.vzaMfa = bl16;
        this.bcmeConsumerList = bl17;
        this.bcmeLiveTips = bl18;
        this.astaMfa = bl19;
    }

    public boolean isStopWatch() {
        return this.stopWatch;
    }

    public boolean isOilTemp() {
        return this.oilTemp;
    }

    public boolean isDigitalSpeed() {
        return this.digitalSpeed;
    }

    public boolean isRefuelVolume() {
        return this.refuelVolume;
    }

    public boolean isSpeedWarning() {
        return this.speedWarning;
    }

    public boolean isCoolantTemp() {
        return this.coolantTemp;
    }

    public boolean isSecondarySpeed() {
        return this.secondarySpeed;
    }

    public boolean isVza() {
        return this.vza;
    }

    public boolean isFis1() {
        return this.fis1;
    }

    public boolean isFis2() {
        return this.fis2;
    }

    public boolean isFis3() {
        return this.fis3;
    }

    public boolean isResetTime() {
        return this.resetTime;
    }

    public boolean isComfortPowerConsumption() {
        return this.comfortPowerConsumption;
    }

    public boolean isZeroEmissionTime() {
        return this.zeroEmissionTime;
    }

    public boolean isZeroEmissionDistance() {
        return this.zeroEmissionDistance;
    }

    public boolean isVzaMfa() {
        return this.vzaMfa;
    }

    public boolean isBcmeConsumerList() {
        return this.bcmeConsumerList;
    }

    public boolean isBcmeLiveTips() {
        return this.bcmeLiveTips;
    }

    public boolean isAstaMfa() {
        return this.astaMfa;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(800);
        stringBuffer.append("BCFISAdditionalConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("fis1");
        stringBuffer.append('=');
        stringBuffer.append(this.fis1);
        stringBuffer.append(',');
        stringBuffer.append("fis2");
        stringBuffer.append('=');
        stringBuffer.append(this.fis2);
        stringBuffer.append(',');
        stringBuffer.append("fis3");
        stringBuffer.append('=');
        stringBuffer.append(this.fis3);
        stringBuffer.append(',');
        stringBuffer.append("stopWatch");
        stringBuffer.append('=');
        stringBuffer.append(this.stopWatch);
        stringBuffer.append(',');
        stringBuffer.append("oilTemp");
        stringBuffer.append('=');
        stringBuffer.append(this.oilTemp);
        stringBuffer.append(',');
        stringBuffer.append("digitalSpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.digitalSpeed);
        stringBuffer.append(',');
        stringBuffer.append("refuelVolume");
        stringBuffer.append('=');
        stringBuffer.append(this.refuelVolume);
        stringBuffer.append(',');
        stringBuffer.append("speedWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.speedWarning);
        stringBuffer.append(',');
        stringBuffer.append("coolantTemp");
        stringBuffer.append('=');
        stringBuffer.append(this.coolantTemp);
        stringBuffer.append(',');
        stringBuffer.append("secondarySpeed");
        stringBuffer.append('=');
        stringBuffer.append(this.secondarySpeed);
        stringBuffer.append(',');
        stringBuffer.append("vza");
        stringBuffer.append('=');
        stringBuffer.append(this.vza);
        stringBuffer.append(',');
        stringBuffer.append("resetTime");
        stringBuffer.append('=');
        stringBuffer.append(this.resetTime);
        stringBuffer.append(',');
        stringBuffer.append("comfortPowerConsumption");
        stringBuffer.append('=');
        stringBuffer.append(this.comfortPowerConsumption);
        stringBuffer.append(',');
        stringBuffer.append("zeroEmissionTime");
        stringBuffer.append('=');
        stringBuffer.append(this.zeroEmissionTime);
        stringBuffer.append(',');
        stringBuffer.append("zeroEmissionDistance");
        stringBuffer.append('=');
        stringBuffer.append(this.zeroEmissionDistance);
        stringBuffer.append(',');
        stringBuffer.append("vzaMfa");
        stringBuffer.append('=');
        stringBuffer.append(this.vzaMfa);
        stringBuffer.append(',');
        stringBuffer.append("bcmeConsumerList");
        stringBuffer.append('=');
        stringBuffer.append(this.bcmeConsumerList);
        stringBuffer.append(',');
        stringBuffer.append("bcmeLiveTips");
        stringBuffer.append('=');
        stringBuffer.append(this.bcmeLiveTips);
        stringBuffer.append(',');
        stringBuffer.append("astaMfa");
        stringBuffer.append('=');
        stringBuffer.append(this.astaMfa);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

