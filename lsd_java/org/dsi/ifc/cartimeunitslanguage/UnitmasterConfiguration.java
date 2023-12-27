/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.cartimeunitslanguage;

import org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedConsumptionUnits;
import org.dsi.ifc.cartimeunitslanguage.UnitmasterSupportedSkins;

public class UnitmasterConfiguration {
    public UnitmasterSupportedConsumptionUnits supportedConsumptionUnits;
    public UnitmasterSupportedSkins supportedSkins;

    public UnitmasterConfiguration() {
        this.supportedConsumptionUnits = null;
        this.supportedSkins = null;
    }

    public UnitmasterConfiguration(UnitmasterSupportedConsumptionUnits unitmasterSupportedConsumptionUnits, UnitmasterSupportedSkins unitmasterSupportedSkins) {
        this.supportedConsumptionUnits = unitmasterSupportedConsumptionUnits;
        this.supportedSkins = unitmasterSupportedSkins;
    }

    public UnitmasterSupportedConsumptionUnits getSupportedConsumptionUnits() {
        return this.supportedConsumptionUnits;
    }

    public UnitmasterSupportedSkins getSupportedSkins() {
        return this.supportedSkins;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2100);
        stringBuffer.append("UnitmasterConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("supportedConsumptionUnits");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedConsumptionUnits);
        stringBuffer.append(',');
        stringBuffer.append("supportedSkins");
        stringBuffer.append('=');
        stringBuffer.append(this.supportedSkins);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

