/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carcomfort;

import org.dsi.ifc.carcomfort.RDKWheelPressures;
import org.dsi.ifc.carcomfort.RDKWheelStates;
import org.dsi.ifc.carcomfort.RDKWheelTemperatures;

public class RDKTireDisplayData {
    public RDKWheelStates wheelStates;
    public RDKWheelPressures wheelPressures;
    public RDKWheelPressures requiredWheelPressures;
    public RDKWheelTemperatures wheelTemperatures;

    public RDKTireDisplayData() {
        this.wheelStates = null;
        this.wheelPressures = null;
        this.requiredWheelPressures = null;
        this.wheelTemperatures = null;
    }

    public RDKTireDisplayData(RDKWheelStates rDKWheelStates, RDKWheelPressures rDKWheelPressures, RDKWheelPressures rDKWheelPressures2, RDKWheelTemperatures rDKWheelTemperatures) {
        this.wheelStates = rDKWheelStates;
        this.wheelPressures = rDKWheelPressures;
        this.requiredWheelPressures = rDKWheelPressures2;
        this.wheelTemperatures = rDKWheelTemperatures;
    }

    public RDKWheelStates getWheelStates() {
        return this.wheelStates;
    }

    public RDKWheelPressures getWheelPressures() {
        return this.wheelPressures;
    }

    public RDKWheelPressures getRequiredWheelPressures() {
        return this.requiredWheelPressures;
    }

    public RDKWheelTemperatures getWheelTemperatures() {
        return this.wheelTemperatures;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(4200);
        stringBuffer.append("RDKTireDisplayData");
        stringBuffer.append('(');
        stringBuffer.append("wheelStates");
        stringBuffer.append('=');
        stringBuffer.append(this.wheelStates);
        stringBuffer.append(',');
        stringBuffer.append("wheelPressures");
        stringBuffer.append('=');
        stringBuffer.append(this.wheelPressures);
        stringBuffer.append(',');
        stringBuffer.append("requiredWheelPressures");
        stringBuffer.append('=');
        stringBuffer.append(this.requiredWheelPressures);
        stringBuffer.append(',');
        stringBuffer.append("wheelTemperatures");
        stringBuffer.append('=');
        stringBuffer.append(this.wheelTemperatures);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

