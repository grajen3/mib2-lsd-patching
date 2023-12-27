/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.carparkingsystem.PDCWallDetectionFrontRear;
import org.dsi.ifc.carparkingsystem.PDCWallDetectionRightLeft;

public class PDCWallDetection {
    public PDCWallDetectionFrontRear sectorsFront;
    public PDCWallDetectionFrontRear sectorsRear;
    public PDCWallDetectionRightLeft sectorsRight;
    public PDCWallDetectionRightLeft sectorsLeft;

    public PDCWallDetection() {
        this.sectorsFront = null;
        this.sectorsRear = null;
        this.sectorsRight = null;
        this.sectorsLeft = null;
    }

    public PDCWallDetection(PDCWallDetectionFrontRear pDCWallDetectionFrontRear, PDCWallDetectionFrontRear pDCWallDetectionFrontRear2, PDCWallDetectionRightLeft pDCWallDetectionRightLeft, PDCWallDetectionRightLeft pDCWallDetectionRightLeft2) {
        this.sectorsFront = pDCWallDetectionFrontRear;
        this.sectorsRear = pDCWallDetectionFrontRear2;
        this.sectorsRight = pDCWallDetectionRightLeft;
        this.sectorsLeft = pDCWallDetectionRightLeft2;
    }

    public PDCWallDetectionFrontRear getSectorsFront() {
        return this.sectorsFront;
    }

    public PDCWallDetectionFrontRear getSectorsRear() {
        return this.sectorsRear;
    }

    public PDCWallDetectionRightLeft getSectorsRight() {
        return this.sectorsRight;
    }

    public PDCWallDetectionRightLeft getSectorsLeft() {
        return this.sectorsLeft;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(4150);
        stringBuffer.append("PDCWallDetection");
        stringBuffer.append('(');
        stringBuffer.append("sectorsFront");
        stringBuffer.append('=');
        stringBuffer.append(this.sectorsFront);
        stringBuffer.append(',');
        stringBuffer.append("sectorsRear");
        stringBuffer.append('=');
        stringBuffer.append(this.sectorsRear);
        stringBuffer.append(',');
        stringBuffer.append("sectorsRight");
        stringBuffer.append('=');
        stringBuffer.append(this.sectorsRight);
        stringBuffer.append(',');
        stringBuffer.append("sectorsLeft");
        stringBuffer.append('=');
        stringBuffer.append(this.sectorsLeft);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

