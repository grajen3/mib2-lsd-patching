/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

public class TSDSystemMessages {
    public boolean disclaimer;
    public boolean roadSignRecognition;
    public boolean cameraBlind;
    public boolean navigationData;
    public boolean system;
    public boolean operationArea;
    public boolean roadSignRecognitionInit;
    public boolean speedWarning;
    public boolean wrongWayWarningLevel1;
    public boolean wrongWayWarningLevel2;
    public boolean wrongWayWarningOperationArea;
    public boolean wrongWayWarning;

    public TSDSystemMessages() {
        this.disclaimer = false;
        this.roadSignRecognition = false;
        this.cameraBlind = false;
        this.navigationData = false;
        this.system = false;
        this.operationArea = false;
        this.roadSignRecognitionInit = false;
        this.speedWarning = false;
        this.wrongWayWarningLevel1 = false;
        this.wrongWayWarningLevel2 = false;
        this.wrongWayWarningOperationArea = false;
        this.wrongWayWarning = false;
    }

    public TSDSystemMessages(boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, boolean bl6, boolean bl7, boolean bl8, boolean bl9, boolean bl10, boolean bl11, boolean bl12) {
        this.disclaimer = bl;
        this.roadSignRecognition = bl2;
        this.cameraBlind = bl3;
        this.navigationData = bl4;
        this.system = bl5;
        this.operationArea = bl6;
        this.roadSignRecognitionInit = bl7;
        this.speedWarning = bl8;
        this.wrongWayWarningLevel1 = bl9;
        this.wrongWayWarningLevel2 = bl10;
        this.wrongWayWarningOperationArea = bl11;
        this.wrongWayWarning = bl12;
    }

    public boolean isDisclaimer() {
        return this.disclaimer;
    }

    public boolean isRoadSignRecognition() {
        return this.roadSignRecognition;
    }

    public boolean isCameraBlind() {
        return this.cameraBlind;
    }

    public boolean isNavigationData() {
        return this.navigationData;
    }

    public boolean isSystem() {
        return this.system;
    }

    public boolean isOperationArea() {
        return this.operationArea;
    }

    public boolean isRoadSignRecognitionInit() {
        return this.roadSignRecognitionInit;
    }

    public boolean isSpeedWarning() {
        return this.speedWarning;
    }

    public boolean isWrongWayWarningLevel1() {
        return this.wrongWayWarningLevel1;
    }

    public boolean isWrongWayWarningLevel2() {
        return this.wrongWayWarningLevel2;
    }

    public boolean isWrongWayWarningOperationArea() {
        return this.wrongWayWarningOperationArea;
    }

    public boolean isWrongWayWarning() {
        return this.wrongWayWarning;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(650);
        stringBuffer.append("TSDSystemMessages");
        stringBuffer.append('(');
        stringBuffer.append("disclaimer");
        stringBuffer.append('=');
        stringBuffer.append(this.disclaimer);
        stringBuffer.append(',');
        stringBuffer.append("roadSignRecognition");
        stringBuffer.append('=');
        stringBuffer.append(this.roadSignRecognition);
        stringBuffer.append(',');
        stringBuffer.append("cameraBlind");
        stringBuffer.append('=');
        stringBuffer.append(this.cameraBlind);
        stringBuffer.append(',');
        stringBuffer.append("navigationData");
        stringBuffer.append('=');
        stringBuffer.append(this.navigationData);
        stringBuffer.append(',');
        stringBuffer.append("system");
        stringBuffer.append('=');
        stringBuffer.append(this.system);
        stringBuffer.append(',');
        stringBuffer.append("operationArea");
        stringBuffer.append('=');
        stringBuffer.append(this.operationArea);
        stringBuffer.append(',');
        stringBuffer.append("roadSignRecognitionInit");
        stringBuffer.append('=');
        stringBuffer.append(this.roadSignRecognitionInit);
        stringBuffer.append(',');
        stringBuffer.append("speedWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.speedWarning);
        stringBuffer.append(',');
        stringBuffer.append("wrongWayWarningLevel1");
        stringBuffer.append('=');
        stringBuffer.append(this.wrongWayWarningLevel1);
        stringBuffer.append(',');
        stringBuffer.append("wrongWayWarningLevel2");
        stringBuffer.append('=');
        stringBuffer.append(this.wrongWayWarningLevel2);
        stringBuffer.append(',');
        stringBuffer.append("wrongWayWarningOperationArea");
        stringBuffer.append('=');
        stringBuffer.append(this.wrongWayWarningOperationArea);
        stringBuffer.append(',');
        stringBuffer.append("wrongWayWarning");
        stringBuffer.append('=');
        stringBuffer.append(this.wrongWayWarning);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

