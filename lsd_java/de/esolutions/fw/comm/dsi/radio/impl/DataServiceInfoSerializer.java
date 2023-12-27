/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radio.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.radio.DataServiceInfo;

public class DataServiceInfoSerializer {
    public static void putOptionalDataServiceInfo(ISerializer iSerializer, DataServiceInfo dataServiceInfo) {
        boolean bl = dataServiceInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dataServiceInfo.getEnsID();
            iSerializer.putInt32(n);
            int n2 = dataServiceInfo.getEnsECC();
            iSerializer.putInt32(n2);
            long l = dataServiceInfo.getSID();
            iSerializer.putInt64(l);
            int n3 = dataServiceInfo.getSCIDI();
            iSerializer.putInt32(n3);
            int n4 = dataServiceInfo.getType();
            iSerializer.putInt32(n4);
            int n5 = dataServiceInfo.getServiceAbbreviationMatrix();
            iSerializer.putInt32(n5);
            String string = dataServiceInfo.getServiceShortName();
            iSerializer.putOptionalString(string);
            String string2 = dataServiceInfo.getServiceFullName();
            iSerializer.putOptionalString(string2);
            int n6 = dataServiceInfo.getComponentAbbreviationMatrix();
            iSerializer.putInt32(n6);
            String string3 = dataServiceInfo.getComponentShortName();
            iSerializer.putOptionalString(string3);
            String string4 = dataServiceInfo.getComponentFullName();
            iSerializer.putOptionalString(string4);
            String string5 = dataServiceInfo.getURL();
            iSerializer.putOptionalString(string5);
        }
    }

    public static void putOptionalDataServiceInfoVarArray(ISerializer iSerializer, DataServiceInfo[] dataServiceInfoArray) {
        boolean bl = dataServiceInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dataServiceInfoArray.length);
            for (int i2 = 0; i2 < dataServiceInfoArray.length; ++i2) {
                DataServiceInfoSerializer.putOptionalDataServiceInfo(iSerializer, dataServiceInfoArray[i2]);
            }
        }
    }

    public static DataServiceInfo getOptionalDataServiceInfo(IDeserializer iDeserializer) {
        DataServiceInfo dataServiceInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            String string3;
            int n;
            String string4;
            String string5;
            int n2;
            int n3;
            int n4;
            long l;
            int n5;
            int n6;
            dataServiceInfo = new DataServiceInfo();
            dataServiceInfo.ensID = n6 = iDeserializer.getInt32();
            dataServiceInfo.ensECC = n5 = iDeserializer.getInt32();
            dataServiceInfo.sID = l = iDeserializer.getInt64();
            dataServiceInfo.sCIDI = n4 = iDeserializer.getInt32();
            dataServiceInfo.type = n3 = iDeserializer.getInt32();
            dataServiceInfo.serviceAbbreviationMatrix = n2 = iDeserializer.getInt32();
            dataServiceInfo.serviceShortName = string5 = iDeserializer.getOptionalString();
            dataServiceInfo.serviceFullName = string4 = iDeserializer.getOptionalString();
            dataServiceInfo.componentAbbreviationMatrix = n = iDeserializer.getInt32();
            dataServiceInfo.componentShortName = string3 = iDeserializer.getOptionalString();
            dataServiceInfo.componentFullName = string2 = iDeserializer.getOptionalString();
            dataServiceInfo.uRL = string = iDeserializer.getOptionalString();
        }
        return dataServiceInfo;
    }

    public static DataServiceInfo[] getOptionalDataServiceInfoVarArray(IDeserializer iDeserializer) {
        DataServiceInfo[] dataServiceInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dataServiceInfoArray = new DataServiceInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dataServiceInfoArray[i2] = DataServiceInfoSerializer.getOptionalDataServiceInfo(iDeserializer);
            }
        }
        return dataServiceInfoArray;
    }
}

