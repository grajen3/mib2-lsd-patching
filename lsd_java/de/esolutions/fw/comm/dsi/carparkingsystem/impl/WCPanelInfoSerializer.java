/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.WCPanelInfo;

public class WCPanelInfoSerializer {
    public static void putOptionalWCPanelInfo(ISerializer iSerializer, WCPanelInfo wCPanelInfo) {
        boolean bl = wCPanelInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = wCPanelInfo.getState();
            iSerializer.putInt32(n);
            double d2 = wCPanelInfo.getAngle();
            iSerializer.putDouble(d2);
            int n2 = wCPanelInfo.getPositionY();
            iSerializer.putInt32(n2);
            int n3 = wCPanelInfo.getPositionX();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalWCPanelInfoVarArray(ISerializer iSerializer, WCPanelInfo[] wCPanelInfoArray) {
        boolean bl = wCPanelInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wCPanelInfoArray.length);
            for (int i2 = 0; i2 < wCPanelInfoArray.length; ++i2) {
                WCPanelInfoSerializer.putOptionalWCPanelInfo(iSerializer, wCPanelInfoArray[i2]);
            }
        }
    }

    public static WCPanelInfo getOptionalWCPanelInfo(IDeserializer iDeserializer) {
        WCPanelInfo wCPanelInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            double d2;
            int n3;
            wCPanelInfo = new WCPanelInfo();
            wCPanelInfo.state = n3 = iDeserializer.getInt32();
            wCPanelInfo.angle = d2 = iDeserializer.getDouble();
            wCPanelInfo.positionY = n2 = iDeserializer.getInt32();
            wCPanelInfo.positionX = n = iDeserializer.getInt32();
        }
        return wCPanelInfo;
    }

    public static WCPanelInfo[] getOptionalWCPanelInfoVarArray(IDeserializer iDeserializer) {
        WCPanelInfo[] wCPanelInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wCPanelInfoArray = new WCPanelInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wCPanelInfoArray[i2] = WCPanelInfoSerializer.getOptionalWCPanelInfo(iDeserializer);
            }
        }
        return wCPanelInfoArray;
    }
}

