/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carkombi;

public class SIAServiceTypes {
    public boolean maintenanceService;
    public boolean oilService;

    public SIAServiceTypes() {
        this.maintenanceService = false;
        this.oilService = false;
    }

    public SIAServiceTypes(boolean bl, boolean bl2) {
        this.maintenanceService = bl;
        this.oilService = bl2;
    }

    public boolean isMaintenanceService() {
        return this.maintenanceService;
    }

    public boolean isOilService() {
        return this.oilService;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(100);
        stringBuffer.append("SIAServiceTypes");
        stringBuffer.append('(');
        stringBuffer.append("maintenanceService");
        stringBuffer.append('=');
        stringBuffer.append(this.maintenanceService);
        stringBuffer.append(',');
        stringBuffer.append("oilService");
        stringBuffer.append('=');
        stringBuffer.append(this.oilService);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

