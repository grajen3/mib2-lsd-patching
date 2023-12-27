/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cardriverassistance;

import org.dsi.ifc.global.CarViewOption;

public class FTAViewOptions {
    public CarViewOption system;

    public FTAViewOptions() {
        this.system = null;
    }

    public FTAViewOptions(CarViewOption carViewOption) {
        this.system = carViewOption;
    }

    public CarViewOption getSystem() {
        return this.system;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1050);
        stringBuffer.append("FTAViewOptions");
        stringBuffer.append('(');
        stringBuffer.append("system");
        stringBuffer.append('=');
        stringBuffer.append(this.system);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

