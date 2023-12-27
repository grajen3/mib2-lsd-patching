/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carauxheatercooler;

import org.dsi.ifc.carauxheatercooler.AuxHeaterCoolerExtendedConditioning;

public class AuxHeaterCoolerConfiguration {
    public boolean heating;
    public boolean ventilation;
    public AuxHeaterCoolerExtendedConditioning extendedConditioning;

    public AuxHeaterCoolerConfiguration() {
        this.heating = false;
        this.ventilation = false;
        this.extendedConditioning = null;
    }

    public AuxHeaterCoolerConfiguration(boolean bl, boolean bl2) {
        this.heating = bl;
        this.ventilation = bl2;
        this.extendedConditioning = null;
    }

    public AuxHeaterCoolerConfiguration(boolean bl, boolean bl2, AuxHeaterCoolerExtendedConditioning auxHeaterCoolerExtendedConditioning) {
        this.heating = bl;
        this.ventilation = bl2;
        this.extendedConditioning = auxHeaterCoolerExtendedConditioning;
    }

    public boolean isHeating() {
        return this.heating;
    }

    public boolean isVentilation() {
        return this.ventilation;
    }

    public AuxHeaterCoolerExtendedConditioning getExtendedConditioning() {
        return this.extendedConditioning;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1150);
        stringBuffer.append("AuxHeaterCoolerConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("heating");
        stringBuffer.append('=');
        stringBuffer.append(this.heating);
        stringBuffer.append(',');
        stringBuffer.append("ventilation");
        stringBuffer.append('=');
        stringBuffer.append(this.ventilation);
        stringBuffer.append(',');
        stringBuffer.append("extendedConditioning");
        stringBuffer.append('=');
        stringBuffer.append(this.extendedConditioning);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

