/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.trafficregulation;

import org.dsi.ifc.trafficregulation.SpeedLimitInfo;

public class TrafficSignInformation {
    public int highestPrioritySign;
    public int secondHighestPrioritySign;
    public int informationText;
    public int trafficSignOne;
    public int trafficSignTwo;
    public int trafficSignThree;
    public int warningSignOne;
    public int warningSignTwo;
    public int warningSignThree;
    public int additionalSignOne;
    public int additionalSignTwo;
    public int additionalSignThree;
    public int variant;
    public SpeedLimitInfo highestPrioritySpeedLimit;
    public int trafficSignOneSource;
    public int trafficSignTwoSource;
    public int trafficSignThreeSource;

    public TrafficSignInformation() {
        this.highestPrioritySign = 0;
        this.secondHighestPrioritySign = 0;
        this.informationText = 0;
        this.trafficSignOne = 0;
        this.trafficSignTwo = 0;
        this.trafficSignThree = 0;
        this.warningSignOne = 0;
        this.warningSignTwo = 0;
        this.warningSignThree = 0;
        this.additionalSignOne = 0;
        this.additionalSignTwo = 0;
        this.additionalSignThree = 0;
        this.variant = 0;
        this.highestPrioritySpeedLimit = null;
        this.trafficSignOneSource = 0;
        this.trafficSignTwoSource = 0;
        this.trafficSignThreeSource = 0;
    }

    public TrafficSignInformation(int n, int n2, int n3, int n4, int n5, int n6, int n7, int n8, int n9, int n10, int n11, int n12, int n13, SpeedLimitInfo speedLimitInfo, int n14, int n15, int n16) {
        this.highestPrioritySign = n;
        this.secondHighestPrioritySign = n2;
        this.informationText = n3;
        this.trafficSignOne = n4;
        this.trafficSignTwo = n5;
        this.trafficSignThree = n6;
        this.warningSignOne = n7;
        this.warningSignTwo = n8;
        this.warningSignThree = n9;
        this.additionalSignOne = n10;
        this.additionalSignTwo = n11;
        this.additionalSignThree = n12;
        this.variant = n13;
        this.highestPrioritySpeedLimit = speedLimitInfo;
        this.trafficSignOneSource = n14;
        this.trafficSignTwoSource = n15;
        this.trafficSignThreeSource = n16;
    }

    public int getHighestPrioritySign() {
        return this.highestPrioritySign;
    }

    public int getSecondHighestPrioritySign() {
        return this.secondHighestPrioritySign;
    }

    public int getInformationText() {
        return this.informationText;
    }

    public int getTrafficSignOne() {
        return this.trafficSignOne;
    }

    public int getTrafficSignTwo() {
        return this.trafficSignTwo;
    }

    public int getTrafficSignThree() {
        return this.trafficSignThree;
    }

    public int getWarningSignOne() {
        return this.warningSignOne;
    }

    public int getWarningSignTwo() {
        return this.warningSignTwo;
    }

    public int getWarningSignThree() {
        return this.warningSignThree;
    }

    public int getAdditionalSignOne() {
        return this.additionalSignOne;
    }

    public int getAdditionalSignTwo() {
        return this.additionalSignTwo;
    }

    public int getAdditionalSignThree() {
        return this.additionalSignThree;
    }

    public int getVariant() {
        return this.variant;
    }

    public SpeedLimitInfo getHighestPrioritySpeedLimit() {
        return this.highestPrioritySpeedLimit;
    }

    public int getTrafficSignOneSource() {
        return this.trafficSignOneSource;
    }

    public int getTrafficSignTwoSource() {
        return this.trafficSignTwoSource;
    }

    public int getTrafficSignThreeSource() {
        return this.trafficSignThreeSource;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2150);
        stringBuffer.append("TrafficSignInformation");
        stringBuffer.append('(');
        stringBuffer.append("highestPrioritySign");
        stringBuffer.append('=');
        stringBuffer.append(this.highestPrioritySign);
        stringBuffer.append(',');
        stringBuffer.append("secondHighestPrioritySign");
        stringBuffer.append('=');
        stringBuffer.append(this.secondHighestPrioritySign);
        stringBuffer.append(',');
        stringBuffer.append("informationText");
        stringBuffer.append('=');
        stringBuffer.append(this.informationText);
        stringBuffer.append(',');
        stringBuffer.append("trafficSignOne");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficSignOne);
        stringBuffer.append(',');
        stringBuffer.append("trafficSignTwo");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficSignTwo);
        stringBuffer.append(',');
        stringBuffer.append("trafficSignThree");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficSignThree);
        stringBuffer.append(',');
        stringBuffer.append("warningSignOne");
        stringBuffer.append('=');
        stringBuffer.append(this.warningSignOne);
        stringBuffer.append(',');
        stringBuffer.append("warningSignTwo");
        stringBuffer.append('=');
        stringBuffer.append(this.warningSignTwo);
        stringBuffer.append(',');
        stringBuffer.append("warningSignThree");
        stringBuffer.append('=');
        stringBuffer.append(this.warningSignThree);
        stringBuffer.append(',');
        stringBuffer.append("additionalSignOne");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalSignOne);
        stringBuffer.append(',');
        stringBuffer.append("additionalSignTwo");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalSignTwo);
        stringBuffer.append(',');
        stringBuffer.append("additionalSignThree");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalSignThree);
        stringBuffer.append(',');
        stringBuffer.append("variant");
        stringBuffer.append('=');
        stringBuffer.append(this.variant);
        stringBuffer.append(',');
        stringBuffer.append("highestPrioritySpeedLimit");
        stringBuffer.append('=');
        stringBuffer.append(this.highestPrioritySpeedLimit);
        stringBuffer.append(',');
        stringBuffer.append("trafficSignOneSource");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficSignOneSource);
        stringBuffer.append(',');
        stringBuffer.append("trafficSignTwoSource");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficSignTwoSource);
        stringBuffer.append(',');
        stringBuffer.append("trafficSignThreeSource");
        stringBuffer.append('=');
        stringBuffer.append(this.trafficSignThreeSource);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

