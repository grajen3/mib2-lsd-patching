/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.comm.dsi.global.impl.CarBCDistanceSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.RGSLocalHazardInformation;
import org.dsi.ifc.global.CarBCDistance;

public class RGSLocalHazardInformationSerializer {
    public static void putOptionalRGSLocalHazardInformation(ISerializer iSerializer, RGSLocalHazardInformation rGSLocalHazardInformation) {
        boolean bl = rGSLocalHazardInformation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = rGSLocalHazardInformation.getEventID();
            iSerializer.putInt16(s);
            int n = rGSLocalHazardInformation.getEventType();
            iSerializer.putInt32(n);
            int n2 = rGSLocalHazardInformation.getEventQuality();
            iSerializer.putInt32(n2);
            CarBCDistance carBCDistance = rGSLocalHazardInformation.getApproach();
            CarBCDistanceSerializer.putOptionalCarBCDistance(iSerializer, carBCDistance);
        }
    }

    public static void putOptionalRGSLocalHazardInformationVarArray(ISerializer iSerializer, RGSLocalHazardInformation[] rGSLocalHazardInformationArray) {
        boolean bl = rGSLocalHazardInformationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(rGSLocalHazardInformationArray.length);
            for (int i2 = 0; i2 < rGSLocalHazardInformationArray.length; ++i2) {
                RGSLocalHazardInformationSerializer.putOptionalRGSLocalHazardInformation(iSerializer, rGSLocalHazardInformationArray[i2]);
            }
        }
    }

    public static RGSLocalHazardInformation getOptionalRGSLocalHazardInformation(IDeserializer iDeserializer) {
        RGSLocalHazardInformation rGSLocalHazardInformation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            CarBCDistance carBCDistance;
            int n;
            int n2;
            short s;
            rGSLocalHazardInformation = new RGSLocalHazardInformation();
            rGSLocalHazardInformation.eventID = s = iDeserializer.getInt16();
            rGSLocalHazardInformation.eventType = n2 = iDeserializer.getInt32();
            rGSLocalHazardInformation.eventQuality = n = iDeserializer.getInt32();
            rGSLocalHazardInformation.approach = carBCDistance = CarBCDistanceSerializer.getOptionalCarBCDistance(iDeserializer);
        }
        return rGSLocalHazardInformation;
    }

    public static RGSLocalHazardInformation[] getOptionalRGSLocalHazardInformationVarArray(IDeserializer iDeserializer) {
        RGSLocalHazardInformation[] rGSLocalHazardInformationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            rGSLocalHazardInformationArray = new RGSLocalHazardInformation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                rGSLocalHazardInformationArray[i2] = RGSLocalHazardInformationSerializer.getOptionalRGSLocalHazardInformation(iDeserializer);
            }
        }
        return rGSLocalHazardInformationArray;
    }
}

