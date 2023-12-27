/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.bluetooth;

import org.dsi.ifc.bluetooth.TrustedDevice;

public final class ConnectedDevice {
    private static final int NO_SERVICE;
    public TrustedDevice device;
    public int[] connectedServices = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public int connectedServiceCount = 0;
    public int instanceId;
    public int availableServiceCount = 0;
}

