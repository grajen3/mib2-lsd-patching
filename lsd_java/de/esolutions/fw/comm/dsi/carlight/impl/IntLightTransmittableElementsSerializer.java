/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlight.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlight.IntLightTransmittableElements;

public class IntLightTransmittableElementsSerializer {
    public static void putOptionalIntLightTransmittableElements(ISerializer iSerializer, IntLightTransmittableElements intLightTransmittableElements) {
        boolean bl = intLightTransmittableElements == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = intLightTransmittableElements.getRa0();
            iSerializer.putInt16(s);
            short s2 = intLightTransmittableElements.getRaF();
            iSerializer.putInt16(s2);
        }
    }

    public static void putOptionalIntLightTransmittableElementsVarArray(ISerializer iSerializer, IntLightTransmittableElements[] intLightTransmittableElementsArray) {
        boolean bl = intLightTransmittableElementsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(intLightTransmittableElementsArray.length);
            for (int i2 = 0; i2 < intLightTransmittableElementsArray.length; ++i2) {
                IntLightTransmittableElementsSerializer.putOptionalIntLightTransmittableElements(iSerializer, intLightTransmittableElementsArray[i2]);
            }
        }
    }

    public static IntLightTransmittableElements getOptionalIntLightTransmittableElements(IDeserializer iDeserializer) {
        IntLightTransmittableElements intLightTransmittableElements = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            intLightTransmittableElements = new IntLightTransmittableElements();
            intLightTransmittableElements.ra0 = s2 = iDeserializer.getInt16();
            intLightTransmittableElements.raF = s = iDeserializer.getInt16();
        }
        return intLightTransmittableElements;
    }

    public static IntLightTransmittableElements[] getOptionalIntLightTransmittableElementsVarArray(IDeserializer iDeserializer) {
        IntLightTransmittableElements[] intLightTransmittableElementsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            intLightTransmittableElementsArray = new IntLightTransmittableElements[n];
            for (int i2 = 0; i2 < n; ++i2) {
                intLightTransmittableElementsArray[i2] = IntLightTransmittableElementsSerializer.getOptionalIntLightTransmittableElements(iDeserializer);
            }
        }
        return intLightTransmittableElementsArray;
    }
}

