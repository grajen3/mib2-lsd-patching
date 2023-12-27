/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carparkingsystem.impl;

import de.esolutions.fw.comm.dsi.carparkingsystem.impl.WCPanelStatesSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carparkingsystem.WCPanelListRecord;
import org.dsi.ifc.carparkingsystem.WCPanelStates;

public class WCPanelListRecordSerializer {
    public static void putOptionalWCPanelListRecord(ISerializer iSerializer, WCPanelListRecord wCPanelListRecord) {
        boolean bl = wCPanelListRecord == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = wCPanelListRecord.getPos();
            iSerializer.putInt32(n);
            String string = wCPanelListRecord.getSerialNumber();
            iSerializer.putOptionalString(string);
            String string2 = wCPanelListRecord.getName();
            iSerializer.putOptionalString(string2);
            String string3 = wCPanelListRecord.getPin();
            iSerializer.putOptionalString(string3);
            String string4 = wCPanelListRecord.getSoftware();
            iSerializer.putOptionalString(string4);
            String string5 = wCPanelListRecord.getHardware();
            iSerializer.putOptionalString(string5);
            WCPanelStates wCPanelStates = wCPanelListRecord.getState();
            WCPanelStatesSerializer.putOptionalWCPanelStates(iSerializer, wCPanelStates);
            int n2 = wCPanelListRecord.getInfo();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalWCPanelListRecordVarArray(ISerializer iSerializer, WCPanelListRecord[] wCPanelListRecordArray) {
        boolean bl = wCPanelListRecordArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(wCPanelListRecordArray.length);
            for (int i2 = 0; i2 < wCPanelListRecordArray.length; ++i2) {
                WCPanelListRecordSerializer.putOptionalWCPanelListRecord(iSerializer, wCPanelListRecordArray[i2]);
            }
        }
    }

    public static WCPanelListRecord getOptionalWCPanelListRecord(IDeserializer iDeserializer) {
        WCPanelListRecord wCPanelListRecord = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            WCPanelStates wCPanelStates;
            String string;
            String string2;
            String string3;
            String string4;
            String string5;
            int n2;
            wCPanelListRecord = new WCPanelListRecord();
            wCPanelListRecord.pos = n2 = iDeserializer.getInt32();
            wCPanelListRecord.serialNumber = string5 = iDeserializer.getOptionalString();
            wCPanelListRecord.name = string4 = iDeserializer.getOptionalString();
            wCPanelListRecord.pin = string3 = iDeserializer.getOptionalString();
            wCPanelListRecord.software = string2 = iDeserializer.getOptionalString();
            wCPanelListRecord.hardware = string = iDeserializer.getOptionalString();
            wCPanelListRecord.state = wCPanelStates = WCPanelStatesSerializer.getOptionalWCPanelStates(iDeserializer);
            wCPanelListRecord.info = n = iDeserializer.getInt32();
        }
        return wCPanelListRecord;
    }

    public static WCPanelListRecord[] getOptionalWCPanelListRecordVarArray(IDeserializer iDeserializer) {
        WCPanelListRecord[] wCPanelListRecordArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            wCPanelListRecordArray = new WCPanelListRecord[n];
            for (int i2 = 0; i2 < n; ++i2) {
                wCPanelListRecordArray[i2] = WCPanelListRecordSerializer.getOptionalWCPanelListRecord(iDeserializer);
            }
        }
        return wCPanelListRecordArray;
    }
}

