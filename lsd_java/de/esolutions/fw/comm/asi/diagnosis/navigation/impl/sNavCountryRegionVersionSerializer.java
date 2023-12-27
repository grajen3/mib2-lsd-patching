/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.impl.sNavCountryRegionVersionEntrySerializer;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersion;
import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersionEntry;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sNavCountryRegionVersionSerializer {
    public static void putOptionalsNavCountryRegionVersion(ISerializer iSerializer, sNavCountryRegionVersion sNavCountryRegionVersion2) {
        boolean bl = sNavCountryRegionVersion2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            long l = sNavCountryRegionVersion2.getMsg_id();
            iSerializer.putUInt32(l);
            short s = sNavCountryRegionVersion2.getStatus();
            iSerializer.putUInt8(s);
            sNavCountryRegionVersionEntry[] sNavCountryRegionVersionEntryArray = sNavCountryRegionVersion2.getVersionList();
            sNavCountryRegionVersionEntrySerializer.putOptionalsNavCountryRegionVersionEntryVarArray(iSerializer, sNavCountryRegionVersionEntryArray);
        }
    }

    public static void putOptionalsNavCountryRegionVersionVarArray(ISerializer iSerializer, sNavCountryRegionVersion[] sNavCountryRegionVersionArray) {
        boolean bl = sNavCountryRegionVersionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sNavCountryRegionVersionArray.length);
            for (int i2 = 0; i2 < sNavCountryRegionVersionArray.length; ++i2) {
                sNavCountryRegionVersionSerializer.putOptionalsNavCountryRegionVersion(iSerializer, sNavCountryRegionVersionArray[i2]);
            }
        }
    }

    public static sNavCountryRegionVersion getOptionalsNavCountryRegionVersion(IDeserializer iDeserializer) {
        sNavCountryRegionVersion sNavCountryRegionVersion2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            long l;
            sNavCountryRegionVersion2 = new sNavCountryRegionVersion();
            sNavCountryRegionVersion2.msg_id = l = iDeserializer.getUInt32();
            sNavCountryRegionVersion2.status = s = iDeserializer.getUInt8();
            sNavCountryRegionVersionEntry[] sNavCountryRegionVersionEntryArray = sNavCountryRegionVersionEntrySerializer.getOptionalsNavCountryRegionVersionEntryVarArray(iDeserializer);
            sNavCountryRegionVersion2.versionList = sNavCountryRegionVersionEntryArray;
        }
        return sNavCountryRegionVersion2;
    }

    public static sNavCountryRegionVersion[] getOptionalsNavCountryRegionVersionVarArray(IDeserializer iDeserializer) {
        sNavCountryRegionVersion[] sNavCountryRegionVersionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sNavCountryRegionVersionArray = new sNavCountryRegionVersion[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sNavCountryRegionVersionArray[i2] = sNavCountryRegionVersionSerializer.getOptionalsNavCountryRegionVersion(iDeserializer);
            }
        }
        return sNavCountryRegionVersionArray;
    }
}

