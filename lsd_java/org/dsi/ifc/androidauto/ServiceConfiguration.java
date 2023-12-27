/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto;

import org.dsi.ifc.androidauto.AppState;
import org.dsi.ifc.androidauto.Resource;

public class ServiceConfiguration {
    public AppState[] initialAppState;
    public Resource[] initialResources;
    public int displayResolutionX;
    public int displayResolutionY;
    public int displayOffsetX;
    public int displayOffsetY;
    public String displayName;
    public boolean useRightHandDrive;
    public boolean touchpadAvailable;
    public int touchpadResolutionX;
    public int touchpadResolutionY;
    public boolean touchscreenAvailable;
    public int touchscreenResolutionX;
    public int touchscreenResolutionY;
    public boolean startInNightMode;
    public int physicalDisplayHeight;
    public int physicalDisplayWidth;

    public ServiceConfiguration() {
        this.initialAppState = null;
        this.initialResources = null;
        this.displayResolutionX = 0;
        this.displayResolutionY = 0;
        this.displayOffsetX = 0;
        this.displayOffsetY = 0;
        this.displayName = "";
        this.useRightHandDrive = false;
        this.touchpadAvailable = false;
        this.touchpadResolutionX = 0;
        this.touchpadResolutionY = 0;
        this.touchscreenAvailable = false;
        this.touchscreenResolutionX = 0;
        this.touchscreenResolutionY = 0;
        this.startInNightMode = false;
        this.physicalDisplayHeight = 0;
        this.physicalDisplayWidth = 0;
    }

    public ServiceConfiguration(AppState[] appStateArray, Resource[] resourceArray, int n, int n2, int n3, int n4, String string, boolean bl, boolean bl2, int n5, int n6, boolean bl3, int n7, int n8, boolean bl4, int n9, int n10) {
        this.initialAppState = appStateArray;
        this.initialResources = resourceArray;
        this.displayResolutionX = n;
        this.displayResolutionY = n2;
        this.displayOffsetX = n3;
        this.displayOffsetY = n4;
        this.displayName = string;
        this.useRightHandDrive = bl;
        this.touchpadAvailable = bl2;
        this.touchpadResolutionX = n5;
        this.touchpadResolutionY = n6;
        this.touchscreenAvailable = bl3;
        this.touchscreenResolutionX = n7;
        this.touchscreenResolutionY = n8;
        this.startInNightMode = bl4;
        this.physicalDisplayHeight = n9;
        this.physicalDisplayWidth = n10;
    }

    public AppState[] getInitialAppState() {
        return this.initialAppState;
    }

    public Resource[] getInitialResources() {
        return this.initialResources;
    }

    public int getDisplayResolutionX() {
        return this.displayResolutionX;
    }

    public int getDisplayResolutionY() {
        return this.displayResolutionY;
    }

    public int getDisplayOffsetX() {
        return this.displayOffsetX;
    }

    public int getDisplayOffsetY() {
        return this.displayOffsetY;
    }

    public String getDisplayName() {
        return this.displayName;
    }

    public boolean isUseRightHandDrive() {
        return this.useRightHandDrive;
    }

    public boolean isTouchpadAvailable() {
        return this.touchpadAvailable;
    }

    public int getTouchpadResolutionX() {
        return this.touchpadResolutionX;
    }

    public int getTouchpadResolutionY() {
        return this.touchpadResolutionY;
    }

    public boolean isTouchscreenAvailable() {
        return this.touchscreenAvailable;
    }

    public int getTouchscreenResolutionX() {
        return this.touchscreenResolutionX;
    }

    public int getTouchscreenResolutionY() {
        return this.touchscreenResolutionY;
    }

    public boolean isStartInNightMode() {
        return this.startInNightMode;
    }

    public int getPhysicalDisplayHeight() {
        return this.physicalDisplayHeight;
    }

    public int getPhysicalDisplayWidth() {
        return this.physicalDisplayWidth;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(1150);
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
        stringBuffer.append("displayResolutionX");
        stringBuffer.append('=');
        stringBuffer.append(this.displayResolutionX);
        stringBuffer.append(',');
        stringBuffer.append("displayResolutionY");
        stringBuffer.append('=');
        stringBuffer.append(this.displayResolutionY);
        stringBuffer.append(',');
        stringBuffer.append("displayOffsetX");
        stringBuffer.append('=');
        stringBuffer.append(this.displayOffsetX);
        stringBuffer.append(',');
        stringBuffer.append("displayOffsetY");
        stringBuffer.append('=');
        stringBuffer.append(this.displayOffsetY);
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
        stringBuffer.append("touchpadAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.touchpadAvailable);
        stringBuffer.append(',');
        stringBuffer.append("touchpadResolutionX");
        stringBuffer.append('=');
        stringBuffer.append(this.touchpadResolutionX);
        stringBuffer.append(',');
        stringBuffer.append("touchpadResolutionY");
        stringBuffer.append('=');
        stringBuffer.append(this.touchpadResolutionY);
        stringBuffer.append(',');
        stringBuffer.append("touchscreenAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.touchscreenAvailable);
        stringBuffer.append(',');
        stringBuffer.append("touchscreenResolutionX");
        stringBuffer.append('=');
        stringBuffer.append(this.touchscreenResolutionX);
        stringBuffer.append(',');
        stringBuffer.append("touchscreenResolutionY");
        stringBuffer.append('=');
        stringBuffer.append(this.touchscreenResolutionY);
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
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

