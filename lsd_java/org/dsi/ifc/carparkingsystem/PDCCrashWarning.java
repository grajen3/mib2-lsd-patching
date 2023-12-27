/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.carparkingsystem.PDCCrashWarningFrontRear;
import org.dsi.ifc.carparkingsystem.PDCCrashWarningRightLeft;

public class PDCCrashWarning {
    public PDCCrashWarningFrontRear sectorsFront;
    public PDCCrashWarningFrontRear sectorsRear;
    public PDCCrashWarningRightLeft sectorsRight;
    public PDCCrashWarningRightLeft sectorsLeft;

    public PDCCrashWarning() {
        this.sectorsFront = null;
        this.sectorsRear = null;
        this.sectorsRight = null;
        this.sectorsLeft = null;
    }

    public PDCCrashWarning(PDCCrashWarningFrontRear pDCCrashWarningFrontRear, PDCCrashWarningFrontRear pDCCrashWarningFrontRear2, PDCCrashWarningRightLeft pDCCrashWarningRightLeft, PDCCrashWarningRightLeft pDCCrashWarningRightLeft2) {
        this.sectorsFront = pDCCrashWarningFrontRear;
        this.sectorsRear = pDCCrashWarningFrontRear2;
        this.sectorsRight = pDCCrashWarningRightLeft;
        this.sectorsLeft = pDCCrashWarningRightLeft2;
    }

    public PDCCrashWarningFrontRear getSectorsFront() {
        return this.sectorsFront;
    }

    public PDCCrashWarningFrontRear getSectorsRear() {
        return this.sectorsRear;
    }

    public PDCCrashWarningRightLeft getSectorsRight() {
        return this.sectorsRight;
    }

    public PDCCrashWarningRightLeft getSectorsLeft() {
        return this.sectorsLeft;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(4150);
        stringBuffer.append("PDCCrashWarning");
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

