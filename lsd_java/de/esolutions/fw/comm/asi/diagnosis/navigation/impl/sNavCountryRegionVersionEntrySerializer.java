/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.diagnosis.navigation.impl;

import de.esolutions.fw.comm.asi.diagnosis.navigation.sNavCountryRegionVersionEntry;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;

public class sNavCountryRegionVersionEntrySerializer {
    public static void putOptionalsNavCountryRegionVersionEntry(ISerializer iSerializer, sNavCountryRegionVersionEntry sNavCountryRegionVersionEntry2) {
        boolean bl = sNavCountryRegionVersionEntry2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short[] sArray = sNavCountryRegionVersionEntry2.getCountry_region_version_code();
            iSerializer.putOptionalUInt8VarArray(sArray);
        }
    }

    public static void putOptionalsNavCountryRegionVersionEntryVarArray(ISerializer iSerializer, sNavCountryRegionVersionEntry[] sNavCountryRegionVersionEntryArray) {
        boolean bl = sNavCountryRegionVersionEntryArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(sNavCountryRegionVersionEntryArray.length);
            for (int i2 = 0; i2 < sNavCountryRegionVersionEntryArray.length; ++i2) {
                sNavCountryRegionVersionEntrySerializer.putOptionalsNavCountryRegionVersionEntry(iSerializer, sNavCountryRegionVersionEntryArray[i2]);
            }
        }
    }

    public static sNavCountryRegionVersionEntry getOptionalsNavCountryRegionVersionEntry(IDeserializer iDeserializer) {
        sNavCountryRegionVersionEntry sNavCountryRegionVersionEntry2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            sNavCountryRegionVersionEntry2 = new sNavCountryRegionVersionEntry();
            short[] sArray = iDeserializer.getOptionalUInt8VarArray();
            sNavCountryRegionVersionEntry2.country_region_version_code = sArray;
        }
        return sNavCountryRegionVersionEntry2;
    }

    public static sNavCountryRegionVersionEntry[] getOptionalsNavCountryRegionVersionEntryVarArray(IDeserializer iDeserializer) {
        sNavCountryRegionVersionEntry[] sNavCountryRegionVersionEntryArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            sNavCountryRegionVersionEntryArray = new sNavCountryRegionVersionEntry[n];
            for (int i2 = 0; i2 < n; ++i2) {
                sNavCountryRegionVersionEntryArray[i2] = sNavCountryRegionVersionEntrySerializer.getOptionalsNavCountryRegionVersionEntry(iDeserializer);
            }
        }
        return sNavCountryRegionVersionEntryArray;
    }
}

