/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.dm;

import de.vw.mib.asl.internal.car.dm.DeviceManager;

class DeviceManager$AdaptationData {
    int deviceID;
    int clamp15OffID;
    int speedTooHighID;
    int standstillID;
    int disclaimerID;
    private final /* synthetic */ DeviceManager this$0;

    public DeviceManager$AdaptationData(DeviceManager deviceManager, int n, int n2, int n3, int n4, int n5) {
        this.this$0 = deviceManager;
        this.deviceID = n;
        this.clamp15OffID = n2;
        this.speedTooHighID = n3;
        this.standstillID = n4;
        this.disclaimerID = n5;
    }
}

