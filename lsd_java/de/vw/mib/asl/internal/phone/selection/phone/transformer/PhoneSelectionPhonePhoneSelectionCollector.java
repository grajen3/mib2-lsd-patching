/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.selection.phone.transformer;

import de.vw.mib.asl.internal.phone.bluetooth.ConnectedDevice;

public class PhoneSelectionPhonePhoneSelectionCollector {
    public static final int DEVICE_TYPE_UNKNOWN;
    public static final int DEVICE_TYPE_HFP;
    public static final int DEVICE_TYPE_RSAP;
    public static final int DEVICE_TYPE_SIM;
    public ConnectedDevice connectedDevice = null;
    public int simMode = 0;
    public int deviceType = 0;

    public PhoneSelectionPhonePhoneSelectionCollector(ConnectedDevice connectedDevice, int n, int n2) {
        this.connectedDevice = connectedDevice;
        this.simMode = n;
        this.deviceType = n2;
    }
}

