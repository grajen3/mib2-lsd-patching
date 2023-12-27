/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.androidauto2;

import org.dsi.ifc.androidauto2.BluetoothServiceAnnouncement;

public class ServiceConfiguration {
    public int displayResolutionX;
    public int displayResolutionY;
    public int driverPosition;
    public boolean touchpadAvailable;
    public int touchpadResolutionX;
    public int touchpadResolutionY;
    public boolean touchscreenAvailable;
    public int touchscreenResolutionX;
    public int touchscreenResolutionY;
    public int physicalDisplayHeight;
    public int physicalDisplayWidth;
    public boolean rotaryControllerAvailable;
    public boolean externalBluetoothPairing;
    public BluetoothServiceAnnouncement pairingAnnoncement;
    public int windowResolutionX;
    public int windowResolutionY;
    public int windowOffsetX;
    public int windowOffsetY;

    public ServiceConfiguration() {
        this.displayResolutionX = 0;
        this.displayResolutionY = 0;
        this.driverPosition = 0;
        this.touchpadAvailable = false;
        this.touchpadResolutionX = 0;
        this.touchpadResolutionY = 0;
        this.touchscreenAvailable = false;
        this.touchscreenResolutionX = 0;
        this.touchscreenResolutionY = 0;
        this.physicalDisplayHeight = 0;
        this.physicalDisplayWidth = 0;
        this.rotaryControllerAvailable = false;
        this.externalBluetoothPairing = false;
        this.pairingAnnoncement = null;
        this.windowResolutionX = 0;
        this.windowResolutionY = 0;
        this.windowOffsetX = 0;
        this.windowOffsetY = 0;
    }

    public ServiceConfiguration(int n, int n2, int n3, boolean bl, int n4, int n5, boolean bl2, int n6, int n7, int n8, int n9, boolean bl3, boolean bl4, BluetoothServiceAnnouncement bluetoothServiceAnnouncement) {
        this.displayResolutionX = n;
        this.displayResolutionY = n2;
        this.driverPosition = n3;
        this.touchpadAvailable = bl;
        this.touchpadResolutionX = n4;
        this.touchpadResolutionY = n5;
        this.touchscreenAvailable = bl2;
        this.touchscreenResolutionX = n6;
        this.touchscreenResolutionY = n7;
        this.physicalDisplayHeight = n8;
        this.physicalDisplayWidth = n9;
        this.rotaryControllerAvailable = bl3;
        this.externalBluetoothPairing = bl4;
        this.pairingAnnoncement = bluetoothServiceAnnouncement;
    }

    public ServiceConfiguration(int n, int n2, int n3, boolean bl, int n4, int n5, boolean bl2, int n6, int n7, int n8, int n9, boolean bl3, boolean bl4, BluetoothServiceAnnouncement bluetoothServiceAnnouncement, int n10, int n11, int n12, int n13) {
        this.displayResolutionX = n;
        this.displayResolutionY = n2;
        this.driverPosition = n3;
        this.touchpadAvailable = bl;
        this.touchpadResolutionX = n4;
        this.touchpadResolutionY = n5;
        this.touchscreenAvailable = bl2;
        this.touchscreenResolutionX = n6;
        this.touchscreenResolutionY = n7;
        this.physicalDisplayHeight = n8;
        this.physicalDisplayWidth = n9;
        this.rotaryControllerAvailable = bl3;
        this.externalBluetoothPairing = bl4;
        this.pairingAnnoncement = bluetoothServiceAnnouncement;
        this.windowResolutionX = n10;
        this.windowResolutionY = n11;
        this.windowOffsetX = n12;
        this.windowOffsetY = n13;
    }

    public int getDisplayResolutionX() {
        return this.displayResolutionX;
    }

    public int getDisplayResolutionY() {
        return this.displayResolutionY;
    }

    public int getDriverPosition() {
        return this.driverPosition;
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

    public int getPhysicalDisplayHeight() {
        return this.physicalDisplayHeight;
    }

    public int getPhysicalDisplayWidth() {
        return this.physicalDisplayWidth;
    }

    public boolean isRotaryControllerAvailable() {
        return this.rotaryControllerAvailable;
    }

    public boolean isExternalBluetoothPairing() {
        return this.externalBluetoothPairing;
    }

    public BluetoothServiceAnnouncement getPairingAnnoncement() {
        return this.pairingAnnoncement;
    }

    public int getWindowResolutionX() {
        return this.windowResolutionX;
    }

    public int getWindowResolutionY() {
        return this.windowResolutionY;
    }

    public int getWindowOffsetX() {
        return this.windowOffsetX;
    }

    public int getWindowOffsetY() {
        return this.windowOffsetY;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2200);
        stringBuffer.append("ServiceConfiguration");
        stringBuffer.append('(');
        stringBuffer.append("displayResolutionX");
        stringBuffer.append('=');
        stringBuffer.append(this.displayResolutionX);
        stringBuffer.append(',');
        stringBuffer.append("displayResolutionY");
        stringBuffer.append('=');
        stringBuffer.append(this.displayResolutionY);
        stringBuffer.append(',');
        stringBuffer.append("driverPosition");
        stringBuffer.append('=');
        stringBuffer.append(this.driverPosition);
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
        stringBuffer.append("physicalDisplayHeight");
        stringBuffer.append('=');
        stringBuffer.append(this.physicalDisplayHeight);
        stringBuffer.append(',');
        stringBuffer.append("physicalDisplayWidth");
        stringBuffer.append('=');
        stringBuffer.append(this.physicalDisplayWidth);
        stringBuffer.append(',');
        stringBuffer.append("rotaryControllerAvailable");
        stringBuffer.append('=');
        stringBuffer.append(this.rotaryControllerAvailable);
        stringBuffer.append(',');
        stringBuffer.append("externalBluetoothPairing");
        stringBuffer.append('=');
        stringBuffer.append(this.externalBluetoothPairing);
        stringBuffer.append(',');
        stringBuffer.append("pairingAnnoncement");
        stringBuffer.append('=');
        stringBuffer.append(this.pairingAnnoncement);
        stringBuffer.append(',');
        stringBuffer.append("windowResolutionX");
        stringBuffer.append('=');
        stringBuffer.append(this.windowResolutionX);
        stringBuffer.append(',');
        stringBuffer.append("windowResolutionY");
        stringBuffer.append('=');
        stringBuffer.append(this.windowResolutionY);
        stringBuffer.append(',');
        stringBuffer.append("windowOffsetX");
        stringBuffer.append('=');
        stringBuffer.append(this.windowOffsetX);
        stringBuffer.append(',');
        stringBuffer.append("windowOffsetY");
        stringBuffer.append('=');
        stringBuffer.append(this.windowOffsetY);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

