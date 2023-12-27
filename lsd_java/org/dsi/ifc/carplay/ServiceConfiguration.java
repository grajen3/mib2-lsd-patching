/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.carplay;

import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.ResourceRequest;

public class ServiceConfiguration {
    public AppStateRequest[] initialAppState;
    public ResourceRequest[] initialResources;
    public int screenResolution;
    public int xResolution;
    public int yResolution;
    public int xOffset;
    public int yOffset;
    public String displayName;
    public boolean useRightHandDrive;
    public int touchpadXResolution;
    public int touchpadYResolution;
    public String[] bluetoothIdentities;
    public boolean startInNightMode;
    public int physicalDisplayHeight;
    public int physicalDisplayWidth;
    public int inputFeatures;

    public ServiceConfiguration() {
        this.initialAppState = null;
        this.initialResources = null;
        this.screenResolution = 0;
        this.xResolution = 0;
        this.yResolution = 0;
        this.xOffset = 0;
        this.yOffset = 0;
        this.displayName = "";
        this.useRightHandDrive = false;
        this.touchpadXResolution = 0;
        this.touchpadYResolution = 0;
        this.bluetoothIdentities = null;
        this.startInNightMode = false;
        this.physicalDisplayHeight = 0;
        this.physicalDisplayWidth = 0;
        this.inputFeatures = 0;
    }

    public ServiceConfiguration(AppStateRequest[] appStateRequestArray, ResourceRequest[] resourceRequestArray, int n, int n2, int n3, String string, boolean bl, int n4, int n5, String[] stringArray, boolean bl2, int n6, int n7, int n8) {
        this.initialAppState = appStateRequestArray;
        this.initialResources = resourceRequestArray;
        this.screenResolution = n;
        this.xResolution = 0;
        this.yResolution = 0;
        this.xOffset = n2;
        this.yOffset = n3;
        this.displayName = string;
        this.useRightHandDrive = bl;
        this.touchpadXResolution = n4;
        this.touchpadYResolution = n5;
        this.bluetoothIdentities = stringArray;
        this.startInNightMode = bl2;
        this.physicalDisplayHeight = n6;
        this.physicalDisplayWidth = n7;
        this.inputFeatures = n8;
    }

    public ServiceConfiguration(AppStateRequest[] appStateRequestArray, ResourceRequest[] resourceRequestArray, int n, int n2, int n3, int n4, int n5, String string, boolean bl, int n6, int n7, String[] stringArray, boolean bl2, int n8, int n9, int n10) {
        this.initialAppState = appStateRequestArray;
        this.initialResources = resourceRequestArray;
        this.screenResolution = n;
        this.xResolution = n2;
        this.yResolution = n3;
        this.xOffset = n4;
        this.yOffset = n5;
        this.displayName = string;
        this.useRightHandDrive = bl;
        this.touchpadXResolution = n6;
        this.touchpadYResolution = n7;
        this.bluetoothIdentities = stringArray;
        this.startInNightMode = bl2;
        this.physicalDisplayHeight = n8;
        this.physicalDisplayWidth = n9;
        this.inputFeatures = n10;
    }

    public AppStateRequest[] getInitialAppState() {
        return this.initialAppState;
    }

    public ResourceRequest[] getInitialResources() {
        return this.initialResources;
    }

    public int getScreenResolution() {
        return this.screenResolution;
    }

    public int getXResolution() {
        return this.xResolution;
    }

    public int getYResolution() {
        return this.yResolution;
    }

    public int getXOffset() {
        return this.xOffset;
    }

    public int getYOffset() {
        return this.yOffset;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean isUseRightHandDrive() {
        return this.useRightHandDrive;
    }

    public int getTouchpadXResolution() {
        return this.touchpadXResolution;
    }

    public int getTouchpadYResolution() {
        return this.touchpadYResolution;
    }

    public String[] getBluetoothIdentities() {
        return this.bluetoothIdentities;
    }

    public boolean isStartInNightMode() {
        return this.startInNightMode;
    }

    public int getPhysicalDisplayWidth() {
        return this.physicalDisplayWidth;
    }

    public int getPhysicalDisplayHeight() {
        return this.physicalDisplayHeight;
    }

    public int getInputFeatures() {
        return this.inputFeatures;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1000);
        stringBuffer.append("ServiceConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("initialAppState");
        stringBuffer.append('[');
        if (this.initialAppState != null) {
            stringBuffer.append(this.initialAppState.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.initialAppState != null) {
            n3 = this.initialAppState.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.initialAppState[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.initialAppState);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("initialResources");
        stringBuffer.append('[');
        if (this.initialResources != null) {
            stringBuffer.append(this.initialResources.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.initialResources != null) {
            n3 = this.initialResources.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.initialResources[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.initialResources);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("screenResolution");
        stringBuffer.append('=');
        stringBuffer.append(this.screenResolution);
        stringBuffer.append(',');
        stringBuffer.append("xResolution");
        stringBuffer.append('=');
        stringBuffer.append(this.xResolution);
        stringBuffer.append(',');
        stringBuffer.append("yResolution");
        stringBuffer.append('=');
        stringBuffer.append(this.yResolution);
        stringBuffer.append(',');
        stringBuffer.append("xOffset");
        stringBuffer.append('=');
        stringBuffer.append(this.xOffset);
        stringBuffer.append(',');
        stringBuffer.append("yOffset");
        stringBuffer.append('=');
        stringBuffer.append(this.yOffset);
        stringBuffer.append(',');
        stringBuffer.append("displayName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.displayName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("useRightHandDrive");
        stringBuffer.append('=');
        stringBuffer.append(this.useRightHandDrive);
        stringBuffer.append(',');
        stringBuffer.append("touchpadXResolution");
        stringBuffer.append('=');
        stringBuffer.append(this.touchpadXResolution);
        stringBuffer.append(',');
        stringBuffer.append("touchpadYResolution");
        stringBuffer.append('=');
        stringBuffer.append(this.touchpadYResolution);
        stringBuffer.append(',');
        stringBuffer.append("bluetoothIdentities");
        stringBuffer.append('[');
        if (this.bluetoothIdentities != null) {
            stringBuffer.append(this.bluetoothIdentities.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.bluetoothIdentities != null) {
            n3 = this.bluetoothIdentities.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.bluetoothIdentities[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.bluetoothIdentities);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("startInNightMode");
        stringBuffer.append('=');
        stringBuffer.append(this.startInNightMode);
        stringBuffer.append(',');
        stringBuffer.append("physicalDisplayHeight");
        stringBuffer.append('=');
        stringBuffer.append(this.physicalDisplayHeight);
        stringBuffer.append(',');
        stringBuffer.append("physicalDisplayWidth");
        stringBuffer.append('=');
        stringBuffer.append(this.physicalDisplayWidth);
        stringBuffer.append(',');
        stringBuffer.append("inputFeatures");
        stringBuffer.append('=');
        stringBuffer.append(this.inputFeatures);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

