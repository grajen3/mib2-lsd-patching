/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.mobilityhorizon.impl;

import de.esolutions.fw.comm.dsi.global.impl.NavLocationWgs84Serializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavLocationWgs84;
import org.dsi.ifc.mobilityhorizon.MobilityHorizonLocation;

public class MobilityHorizonLocationSerializer {
    public static void putOptionalMobilityHorizonLocation(ISerializer iSerializer, MobilityHorizonLocation mobilityHorizonLocation) {
        boolean bl = mobilityHorizonLocation == null;
        iSerializer.putBool(bl);
        if (!bl) {
            NavLocationWgs84 navLocationWgs84 = mobilityHorizonLocation.getLocation();
            NavLocationWgs84Serializer.putOptionalNavLocationWgs84(iSerializer, navLocationWgs84);
            int n = mobilityHorizonLocation.getLocationType();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalMobilityHorizonLocationVarArray(ISerializer iSerializer, MobilityHorizonLocation[] mobilityHorizonLocationArray) {
        boolean bl = mobilityHorizonLocationArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mobilityHorizonLocationArray.length);
            for (int i2 = 0; i2 < mobilityHorizonLocationArray.length; ++i2) {
                MobilityHorizonLocationSerializer.putOptionalMobilityHorizonLocation(iSerializer, mobilityHorizonLocationArray[i2]);
            }
        }
    }

    public static MobilityHorizonLocation getOptionalMobilityHorizonLocation(IDeserializer iDeserializer) {
        MobilityHorizonLocation mobilityHorizonLocation = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            NavLocationWgs84 navLocationWgs84;
            mobilityHorizonLocation = new MobilityHorizonLocation();
            mobilityHorizonLocation.location = navLocationWgs84 = NavLocationWgs84Serializer.getOptionalNavLocationWgs84(iDeserializer);
            mobilityHorizonLocation.locationType = n = iDeserializer.getInt32();
        }
        return mobilityHorizonLocation;
    }

    public static MobilityHorizonLocation[] getOptionalMobilityHorizonLocationVarArray(IDeserializer iDeserializer) {
        MobilityHorizonLocation[] mobilityHorizonLocationArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mobilityHorizonLocationArray = new MobilityHorizonLocation[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mobilityHorizonLocationArray[i2] = MobilityHorizonLocationSerializer.getOptionalMobilityHorizonLocation(iDeserializer);
            }
        }
        return mobilityHorizonLocationArray;
    }
}

