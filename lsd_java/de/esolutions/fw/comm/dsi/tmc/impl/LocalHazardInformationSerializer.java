/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tmc.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.tmc.LocalHazardInformation;

public class LocalHazardInformationSerializer {
    public static void putOptionalLocalHazardInformation(ISerializer iSerializer, LocalHazardInformation localHazardInformation) {
        boolean bl = localHazardInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = localHazardInformation.getEventID();
            iSerializer.putInt32(n);
            int n2 = localHazardInformation.getEventType();
            iSerializer.putInt32(n2);
            int n3 = localHazardInformation.getEventQuality();
            iSerializer.putInt32(n3);
            long l = localHazardInformation.getDistance();
            iSerializer.putInt64(l);
        }
    }

    public static void putOptionalLocalHazardInformationVarArray(ISerializer iSerializer, LocalHazardInformation[] localHazardInformationArray) {
        boolean bl = localHazardInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(localHazardInformationArray.length);
            for (int i2 = 0; i2 < localHazardInformationArray.length; ++i2) {
                LocalHazardInformationSerializer.putOptionalLocalHazardInformation(iSerializer, localHazardInformationArray[i2]);
            }
        }
    }

    public static LocalHazardInformation getOptionalLocalHazardInformation(IDeserializer iDeserializer) {
        LocalHazardInformation localHazardInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            long l;
            int n;
            int n2;
            int n3;
            localHazardInformation = new LocalHazardInformation();
            localHazardInformation.eventID = n3 = iDeserializer.getInt32();
            localHazardInformation.eventType = n2 = iDeserializer.getInt32();
            localHazardInformation.eventQuality = n = iDeserializer.getInt32();
            localHazardInformation.distance = l = iDeserializer.getInt64();
        }
        return localHazardInformation;
    }

    public static LocalHazardInformation[] getOptionalLocalHazardInformationVarArray(IDeserializer iDeserializer) {
        LocalHazardInformation[] localHazardInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            localHazardInformationArray = new LocalHazardInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                localHazardInformationArray[i2] = LocalHazardInformationSerializer.getOptionalLocalHazardInformation(iDeserializer);
            }
        }
        return localHazardInformationArray;
    }
}

