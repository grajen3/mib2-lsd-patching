/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

import org.dsi.ifc.carkombi.BCFISAdditionalConfiguration;
import org.dsi.ifc.carkombi.BCFunctionSupport;
import org.dsi.ifc.carkombi.BCTransmittableElements;

public class BCConfiguration {
    public int primaryEngineType;
    public int secondaryEngineType;
    public BCFISAdditionalConfiguration fisAdditionalConfiguration;
    public BCTransmittableElements transmittableElementsVehicleState;
    public BCFunctionSupport functionSupport;

    public BCConfiguration() {
        this.primaryEngineType = 0;
        this.secondaryEngineType = 0;
        this.fisAdditionalConfiguration = null;
        this.transmittableElementsVehicleState = null;
        this.functionSupport = null;
    }

    public BCConfiguration(int n, int n2, BCFISAdditionalConfiguration bCFISAdditionalConfiguration, BCTransmittableElements bCTransmittableElements) {
        this.primaryEngineType = n;
        this.secondaryEngineType = n2;
        this.fisAdditionalConfiguration = bCFISAdditionalConfiguration;
        this.transmittableElementsVehicleState = bCTransmittableElements;
        this.functionSupport = null;
    }

    public BCConfiguration(int n, int n2, BCFISAdditionalConfiguration bCFISAdditionalConfiguration, BCTransmittableElements bCTransmittableElements, BCFunctionSupport bCFunctionSupport) {
        this.primaryEngineType = n;
        this.secondaryEngineType = n2;
        this.fisAdditionalConfiguration = bCFISAdditionalConfiguration;
        this.transmittableElementsVehicleState = bCTransmittableElements;
        this.functionSupport = bCFunctionSupport;
    }

    public int getPrimaryEngineType() {
        return this.primaryEngineType;
    }

    public int getSecondaryEngineType() {
        return this.secondaryEngineType;
    }

    public BCFISAdditionalConfiguration getFisAdditionalConfiguration() {
        return this.fisAdditionalConfiguration;
    }

    public BCTransmittableElements getTransmittableElementsVehicleState() {
        return this.transmittableElementsVehicleState;
    }

    public BCFunctionSupport getFunctionSupport() {
        return this.functionSupport;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(3350);
        stringBuffer.append("BCConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("primaryEngineType");
        stringBuffer.append('=');
        stringBuffer.append(this.primaryEngineType);
        stringBuffer.append(',');
        stringBuffer.append("secondaryEngineType");
        stringBuffer.append('=');
        stringBuffer.append(this.secondaryEngineType);
        stringBuffer.append(',');
        stringBuffer.append("fisAdditionalConfiguration");
        stringBuffer.append('=');
        stringBuffer.append(this.fisAdditionalConfiguration);
        stringBuffer.append(',');
        stringBuffer.append("transmittableElementsVehicleState");
        stringBuffer.append('=');
        stringBuffer.append(this.transmittableElementsVehicleState);
        stringBuffer.append(',');
        stringBuffer.append("functionSupport");
        stringBuffer.append('=');
        stringBuffer.append(this.functionSupport);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

