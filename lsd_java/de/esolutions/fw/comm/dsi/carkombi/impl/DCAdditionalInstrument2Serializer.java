/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCAdditionalInstrument2;

public class DCAdditionalInstrument2Serializer {
    public static void putOptionalDCAdditionalInstrument2(ISerializer iSerializer, DCAdditionalInstrument2 dCAdditionalInstrument2) {
        boolean bl = dCAdditionalInstrument2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            boolean bl2 = dCAdditionalInstrument2.isInstrumentOnOff();
            iSerializer.putBool(bl2);
            boolean bl3 = dCAdditionalInstrument2.isDigitalClock();
            iSerializer.putBool(bl3);
            boolean bl4 = dCAdditionalInstrument2.isAnalogClock();
            iSerializer.putBool(bl4);
            boolean bl5 = dCAdditionalInstrument2.isCompass();
            iSerializer.putBool(bl5);
            boolean bl6 = dCAdditionalInstrument2.isNavigation();
            iSerializer.putBool(bl6);
        }
    }

    public static void putOptionalDCAdditionalInstrument2VarArray(ISerializer iSerializer, DCAdditionalInstrument2[] dCAdditionalInstrument2Array) {
        boolean bl = dCAdditionalInstrument2Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCAdditionalInstrument2Array.length);
            for (int i2 = 0; i2 < dCAdditionalInstrument2Array.length; ++i2) {
                DCAdditionalInstrument2Serializer.putOptionalDCAdditionalInstrument2(iSerializer, dCAdditionalInstrument2Array[i2]);
            }
        }
    }

    public static DCAdditionalInstrument2 getOptionalDCAdditionalInstrument2(IDeserializer iDeserializer) {
        DCAdditionalInstrument2 dCAdditionalInstrument2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            boolean bl4;
            boolean bl5;
            boolean bl6;
            dCAdditionalInstrument2 = new DCAdditionalInstrument2();
            dCAdditionalInstrument2.instrumentOnOff = bl6 = iDeserializer.getBool();
            dCAdditionalInstrument2.digitalClock = bl5 = iDeserializer.getBool();
            dCAdditionalInstrument2.analogClock = bl4 = iDeserializer.getBool();
            dCAdditionalInstrument2.compass = bl3 = iDeserializer.getBool();
            dCAdditionalInstrument2.navigation = bl2 = iDeserializer.getBool();
        }
        return dCAdditionalInstrument2;
    }

    public static DCAdditionalInstrument2[] getOptionalDCAdditionalInstrument2VarArray(IDeserializer iDeserializer) {
        DCAdditionalInstrument2[] dCAdditionalInstrument2Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCAdditionalInstrument2Array = new DCAdditionalInstrument2[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCAdditionalInstrument2Array[i2] = DCAdditionalInstrument2Serializer.getOptionalDCAdditionalInstrument2(iDeserializer);
            }
        }
        return dCAdditionalInstrument2Array;
    }
}

