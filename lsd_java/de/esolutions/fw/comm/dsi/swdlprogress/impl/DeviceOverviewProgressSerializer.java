/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdlprogress.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.swdlprogress.DeviceOverviewProgress;

public class DeviceOverviewProgressSerializer {
    public static void putOptionalDeviceOverviewProgress(ISerializer iSerializer, DeviceOverviewProgress deviceOverviewProgress) {
        boolean bl = deviceOverviewProgress == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = deviceOverviewProgress.getFileName();
            iSerializer.putOptionalString(string);
            int n = deviceOverviewProgress.getValue();
            iSerializer.putInt32(n);
            int n2 = deviceOverviewProgress.getType();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDeviceOverviewProgressVarArray(ISerializer iSerializer, DeviceOverviewProgress[] deviceOverviewProgressArray) {
        boolean bl = deviceOverviewProgressArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(deviceOverviewProgressArray.length);
            for (int i2 = 0; i2 < deviceOverviewProgressArray.length; ++i2) {
                DeviceOverviewProgressSerializer.putOptionalDeviceOverviewProgress(iSerializer, deviceOverviewProgressArray[i2]);
            }
        }
    }

    public static DeviceOverviewProgress getOptionalDeviceOverviewProgress(IDeserializer iDeserializer) {
        DeviceOverviewProgress deviceOverviewProgress = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            String string;
            deviceOverviewProgress = new DeviceOverviewProgress();
            deviceOverviewProgress.fileName = string = iDeserializer.getOptionalString();
            deviceOverviewProgress.value = n2 = iDeserializer.getInt32();
            deviceOverviewProgress.type = n = iDeserializer.getInt32();
        }
        return deviceOverviewProgress;
    }

    public static DeviceOverviewProgress[] getOptionalDeviceOverviewProgressVarArray(IDeserializer iDeserializer) {
        DeviceOverviewProgress[] deviceOverviewProgressArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            deviceOverviewProgressArray = new DeviceOverviewProgress[n];
            for (int i2 = 0; i2 < n; ++i2) {
                deviceOverviewProgressArray[i2] = DeviceOverviewProgressSerializer.getOptionalDeviceOverviewProgress(iDeserializer);
            }
        }
        return deviceOverviewProgressArray;
    }
}

