/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.careco;

import org.dsi.ifc.careco.BCmETransmittableElements;

public class BCmEConfiguration {
    public int primaryEngineType;
    public int secondaryEngineType;
    public BCmETransmittableElements consumerListTransmittableElements;
    public BCmETransmittableElements consumerListConsumptionTransmittableElements;
    public BCmETransmittableElements consumerListRangeTransmittableElements;

    public BCmEConfiguration() {
        this.primaryEngineType = 0;
        this.secondaryEngineType = 0;
        this.consumerListTransmittableElements = null;
        this.consumerListConsumptionTransmittableElements = null;
        this.consumerListRangeTransmittableElements = null;
    }

    public BCmEConfiguration(int n, int n2, BCmETransmittableElements bCmETransmittableElements, BCmETransmittableElements bCmETransmittableElements2, BCmETransmittableElements bCmETransmittableElements3) {
        this.primaryEngineType = n;
        this.secondaryEngineType = n2;
        this.consumerListTransmittableElements = bCmETransmittableElements;
        this.consumerListConsumptionTransmittableElements = bCmETransmittableElements2;
        this.consumerListRangeTransmittableElements = bCmETransmittableElements3;
    }

    public int getPrimaryEngineType() {
        return this.primaryEngineType;
    }

    public int getSecondaryEngineType() {
        return this.secondaryEngineType;
    }

    public BCmETransmittableElements getConsumerListTransmittableElements() {
        return this.consumerListTransmittableElements;
    }

    public BCmETransmittableElements getConsumerListConsumptionTransmittableElements() {
        return this.consumerListConsumptionTransmittableElements;
    }

    public BCmETransmittableElements getConsumerListRangeTransmittableElements() {
        return this.consumerListRangeTransmittableElements;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3400);
        stringBuffer.append("BCmEConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("primaryEngineType");
        stringBuffer.append('=');
        stringBuffer.append(this.primaryEngineType);
        stringBuffer.append(',');
        stringBuffer.append("secondaryEngineType");
        stringBuffer.append('=');
        stringBuffer.append(this.secondaryEngineType);
        stringBuffer.append(',');
        stringBuffer.append("consumerListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.consumerListTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("consumerListConsumptionTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.consumerListConsumptionTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("consumerListRangeTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.consumerListRangeTransmittableElements);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

