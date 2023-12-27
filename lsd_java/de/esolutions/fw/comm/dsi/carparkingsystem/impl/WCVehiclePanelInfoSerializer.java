/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.WCVehiclePanelInfo;

public class WCVehiclePanelInfoSerializer {
    public static void putOptionalWCVehiclePanelInfo(ISerializer iSerializer, WCVehiclePanelInfo wCVehiclePanelInfo) {
        boolean bl = wCVehiclePanelInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            String string = wCVehiclePanelInfo.getSoftware();
            iSerializer.putOptionalString(string);
            String string2 = wCVehiclePanelInfo.getHardware();
            iSerializer.putOptionalString(string2);
        }
    }

    public static void putOptionalWCVehiclePanelInfoVarArray(ISerializer iSerializer, WCVehiclePanelInfo[] wCVehiclePanelInfoArray) {
        boolean bl = wCVehiclePanelInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wCVehiclePanelInfoArray.length);
            for (int i2 = 0; i2 < wCVehiclePanelInfoArray.length; ++i2) {
                WCVehiclePanelInfoSerializer.putOptionalWCVehiclePanelInfo(iSerializer, wCVehiclePanelInfoArray[i2]);
            }
        }
    }

    public static WCVehiclePanelInfo getOptionalWCVehiclePanelInfo(IDeserializer iDeserializer) {
        WCVehiclePanelInfo wCVehiclePanelInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            wCVehiclePanelInfo = new WCVehiclePanelInfo();
            wCVehiclePanelInfo.software = string2 = iDeserializer.getOptionalString();
            wCVehiclePanelInfo.hardware = string = iDeserializer.getOptionalString();
        }
        return wCVehiclePanelInfo;
    }

    public static WCVehiclePanelInfo[] getOptionalWCVehiclePanelInfoVarArray(IDeserializer iDeserializer) {
        WCVehiclePanelInfo[] wCVehiclePanelInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wCVehiclePanelInfoArray = new WCVehiclePanelInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wCVehiclePanelInfoArray[i2] = WCVehiclePanelInfoSerializer.getOptionalWCVehiclePanelInfo(iDeserializer);
            }
        }
        return wCVehiclePanelInfoArray;
    }
}

