/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carparkingsystem;

import org.dsi.ifc.global.CarArrayListTransmittableElements;

public class WCConfiguration {
    public int vehiclePanelSizeY;
    public int vehiclePanelSizeX;
    public int vehiclePanelPositionY;
    public int vehiclePanelPositionX;
    public int vehicleWidth;
    public CarArrayListTransmittableElements panelListTransmittableElements;
    public int[] panelListRAConfig;

    public WCConfiguration() {
        this.vehiclePanelSizeY = 0;
        this.vehiclePanelSizeX = 0;
        this.vehiclePanelPositionY = 0;
        this.vehiclePanelPositionX = 0;
        this.vehicleWidth = 0;
        this.panelListTransmittableElements = null;
        this.panelListRAConfig = null;
    }

    public WCConfiguration(int n, int n2, int n3, int n4, int n5) {
        this.vehiclePanelSizeY = n;
        this.vehiclePanelSizeX = n2;
        this.vehiclePanelPositionY = n3;
        this.vehiclePanelPositionX = n4;
        this.vehicleWidth = n5;
        this.panelListTransmittableElements = null;
        this.panelListRAConfig = null;
    }

    public WCConfiguration(int n, int n2, int n3, int n4, int n5, CarArrayListTransmittableElements carArrayListTransmittableElements, int[] nArray) {
        this.vehiclePanelSizeY = n;
        this.vehiclePanelSizeX = n2;
        this.vehiclePanelPositionY = n3;
        this.vehiclePanelPositionX = n4;
        this.vehicleWidth = n5;
        this.panelListTransmittableElements = carArrayListTransmittableElements;
        this.panelListRAConfig = nArray;
    }

    public int getVehiclePanelSizeY() {
        return this.vehiclePanelSizeY;
    }

    public int getVehiclePanelSizeX() {
        return this.vehiclePanelSizeX;
    }

    public int getVehiclePanelPositionY() {
        return this.vehiclePanelPositionY;
    }

    public int getVehiclePanelPositionX() {
        return this.vehiclePanelPositionX;
    }

    public int getVehicleWidth() {
        return this.vehicleWidth;
    }

    public CarArrayListTransmittableElements getPanelListTransmittableElements() {
        return this.panelListTransmittableElements;
    }

    public int[] getPanelListRAConfig() {
        return this.panelListRAConfig;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(1500);
        stringBuffer.append("WCConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("vehiclePanelSizeY");
        stringBuffer.append('=');
        stringBuffer.append(this.vehiclePanelSizeY);
        stringBuffer.append(',');
        stringBuffer.append("vehiclePanelSizeX");
        stringBuffer.append('=');
        stringBuffer.append(this.vehiclePanelSizeX);
        stringBuffer.append(',');
        stringBuffer.append("vehiclePanelPositionY");
        stringBuffer.append('=');
        stringBuffer.append(this.vehiclePanelPositionY);
        stringBuffer.append(',');
        stringBuffer.append("vehiclePanelPositionX");
        stringBuffer.append('=');
        stringBuffer.append(this.vehiclePanelPositionX);
        stringBuffer.append(',');
        stringBuffer.append("vehicleWidth");
        stringBuffer.append('=');
        stringBuffer.append(this.vehicleWidth);
        stringBuffer.append(',');
        stringBuffer.append("panelListTransmittableElements");
        stringBuffer.append('=');
        stringBuffer.append(this.panelListTransmittableElements);
        stringBuffer.append(',');
        stringBuffer.append("panelListRAConfig");
        stringBuffer.append('[');
        if (this.panelListRAConfig != null) {
            stringBuffer.append(this.panelListRAConfig.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.panelListRAConfig != null) {
            int n = this.panelListRAConfig.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.panelListRAConfig[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.panelListRAConfig);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

