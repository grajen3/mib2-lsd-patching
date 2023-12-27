/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.sdars.StationDescription;

public class StationDescriptionSerializer {
    public static void putOptionalStationDescription(ISerializer iSerializer, StationDescription stationDescription) {
        boolean bl = stationDescription == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = stationDescription.getSID();
            iSerializer.putInt32(n);
            String string = stationDescription.getShortStationDescription();
            iSerializer.putOptionalString(string);
            String string2 = stationDescription.getLongStationDescription();
            iSerializer.putOptionalString(string2);
            int[] nArray = stationDescription.getRelatedStationArray();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalStationDescriptionVarArray(ISerializer iSerializer, StationDescription[] stationDescriptionArray) {
        boolean bl = stationDescriptionArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(stationDescriptionArray.length);
            for (int i2 = 0; i2 < stationDescriptionArray.length; ++i2) {
                StationDescriptionSerializer.putOptionalStationDescription(iSerializer, stationDescriptionArray[i2]);
            }
        }
    }

    public static StationDescription getOptionalStationDescription(IDeserializer iDeserializer) {
        StationDescription stationDescription = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            String string;
            String string2;
            int n;
            stationDescription = new StationDescription();
            stationDescription.sID = n = iDeserializer.getInt32();
            stationDescription.shortStationDescription = string2 = iDeserializer.getOptionalString();
            stationDescription.longStationDescription = string = iDeserializer.getOptionalString();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            stationDescription.relatedStationArray = nArray;
        }
        return stationDescription;
    }

    public static StationDescription[] getOptionalStationDescriptionVarArray(IDeserializer iDeserializer) {
        StationDescription[] stationDescriptionArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            stationDescriptionArray = new StationDescription[n];
            for (int i2 = 0; i2 < n; ++i2) {
                stationDescriptionArray[i2] = StationDescriptionSerializer.getOptionalStationDescription(iDeserializer);
            }
        }
        return stationDescriptionArray;
    }
}

