/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCAdditionalInstrument;

public class DCAdditionalInstrumentSerializer {
    public static void putOptionalDCAdditionalInstrument(ISerializer iSerializer, DCAdditionalInstrument dCAdditionalInstrument) {
        boolean bl = dCAdditionalInstrument == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = dCAdditionalInstrument.isInstrumentOnOff();
            iSerializer.putBool(bl2);
            boolean bl3 = dCAdditionalInstrument.isLight();
            iSerializer.putBool(bl3);
            boolean bl4 = dCAdditionalInstrument.isTime();
            iSerializer.putBool(bl4);
            int n = dCAdditionalInstrument.getBrightness();
            iSerializer.putInt32(n);
        }
    }

    public static void putOptionalDCAdditionalInstrumentVarArray(ISerializer iSerializer, DCAdditionalInstrument[] dCAdditionalInstrumentArray) {
        boolean bl = dCAdditionalInstrumentArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCAdditionalInstrumentArray.length);
            for (int i2 = 0; i2 < dCAdditionalInstrumentArray.length; ++i2) {
                DCAdditionalInstrumentSerializer.putOptionalDCAdditionalInstrument(iSerializer, dCAdditionalInstrumentArray[i2]);
            }
        }
    }

    public static DCAdditionalInstrument getOptionalDCAdditionalInstrument(IDeserializer iDeserializer) {
        DCAdditionalInstrument dCAdditionalInstrument = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            boolean bl3;
            boolean bl4;
            dCAdditionalInstrument = new DCAdditionalInstrument();
            dCAdditionalInstrument.instrumentOnOff = bl4 = iDeserializer.getBool();
            dCAdditionalInstrument.light = bl3 = iDeserializer.getBool();
            dCAdditionalInstrument.time = bl2 = iDeserializer.getBool();
            dCAdditionalInstrument.brightness = n = iDeserializer.getInt32();
        }
        return dCAdditionalInstrument;
    }

    public static DCAdditionalInstrument[] getOptionalDCAdditionalInstrumentVarArray(IDeserializer iDeserializer) {
        DCAdditionalInstrument[] dCAdditionalInstrumentArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCAdditionalInstrumentArray = new DCAdditionalInstrument[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCAdditionalInstrumentArray[i2] = DCAdditionalInstrumentSerializer.getOptionalDCAdditionalInstrument(iDeserializer);
            }
        }
        return dCAdditionalInstrumentArray;
    }
}

