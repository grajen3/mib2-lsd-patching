/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.ExtLightLampErrorDetectionStateTrailer;

public class ExtLightLampErrorDetectionStateTrailerSerializer {
    public static void putOptionalExtLightLampErrorDetectionStateTrailer(ISerializer iSerializer, ExtLightLampErrorDetectionStateTrailer extLightLampErrorDetectionStateTrailer) {
        boolean bl = extLightLampErrorDetectionStateTrailer == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = extLightLampErrorDetectionStateTrailer.getLamp();
            iSerializer.putInt32(n);
            int n2 = extLightLampErrorDetectionStateTrailer.getState();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalExtLightLampErrorDetectionStateTrailerVarArray(ISerializer iSerializer, ExtLightLampErrorDetectionStateTrailer[] extLightLampErrorDetectionStateTrailerArray) {
        boolean bl = extLightLampErrorDetectionStateTrailerArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(extLightLampErrorDetectionStateTrailerArray.length);
            for (int i2 = 0; i2 < extLightLampErrorDetectionStateTrailerArray.length; ++i2) {
                ExtLightLampErrorDetectionStateTrailerSerializer.putOptionalExtLightLampErrorDetectionStateTrailer(iSerializer, extLightLampErrorDetectionStateTrailerArray[i2]);
            }
        }
    }

    public static ExtLightLampErrorDetectionStateTrailer getOptionalExtLightLampErrorDetectionStateTrailer(IDeserializer iDeserializer) {
        ExtLightLampErrorDetectionStateTrailer extLightLampErrorDetectionStateTrailer = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            extLightLampErrorDetectionStateTrailer = new ExtLightLampErrorDetectionStateTrailer();
            extLightLampErrorDetectionStateTrailer.lamp = n2 = iDeserializer.getInt32();
            extLightLampErrorDetectionStateTrailer.state = n = iDeserializer.getInt32();
        }
        return extLightLampErrorDetectionStateTrailer;
    }

    public static ExtLightLampErrorDetectionStateTrailer[] getOptionalExtLightLampErrorDetectionStateTrailerVarArray(IDeserializer iDeserializer) {
        ExtLightLampErrorDetectionStateTrailer[] extLightLampErrorDetectionStateTrailerArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            extLightLampErrorDetectionStateTrailerArray = new ExtLightLampErrorDetectionStateTrailer[n];
            for (int i2 = 0; i2 < n; ++i2) {
                extLightLampErrorDetectionStateTrailerArray[i2] = ExtLightLampErrorDetectionStateTrailerSerializer.getOptionalExtLightLampErrorDetectionStateTrailer(iDeserializer);
            }
        }
        return extLightLampErrorDetectionStateTrailerArray;
    }
}

