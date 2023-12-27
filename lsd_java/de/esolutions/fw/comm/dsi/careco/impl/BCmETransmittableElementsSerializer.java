/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.careco.BCmETransmittableElements;

public class BCmETransmittableElementsSerializer {
    public static void putOptionalBCmETransmittableElements(ISerializer iSerializer, BCmETransmittableElements bCmETransmittableElements) {
        boolean bl = bCmETransmittableElements == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = bCmETransmittableElements.getRa0();
            iSerializer.putInt16(s);
            short s2 = bCmETransmittableElements.getRa1();
            iSerializer.putInt16(s2);
            short s3 = bCmETransmittableElements.getRa2();
            iSerializer.putInt16(s3);
            short s4 = bCmETransmittableElements.getRaF();
            iSerializer.putInt16(s4);
        }
    }

    public static void putOptionalBCmETransmittableElementsVarArray(ISerializer iSerializer, BCmETransmittableElements[] bCmETransmittableElementsArray) {
        boolean bl = bCmETransmittableElementsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCmETransmittableElementsArray.length);
            for (int i2 = 0; i2 < bCmETransmittableElementsArray.length; ++i2) {
                BCmETransmittableElementsSerializer.putOptionalBCmETransmittableElements(iSerializer, bCmETransmittableElementsArray[i2]);
            }
        }
    }

    public static BCmETransmittableElements getOptionalBCmETransmittableElements(IDeserializer iDeserializer) {
        BCmETransmittableElements bCmETransmittableElements = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            short s4;
            bCmETransmittableElements = new BCmETransmittableElements();
            bCmETransmittableElements.ra0 = s4 = iDeserializer.getInt16();
            bCmETransmittableElements.ra1 = s3 = iDeserializer.getInt16();
            bCmETransmittableElements.ra2 = s2 = iDeserializer.getInt16();
            bCmETransmittableElements.raF = s = iDeserializer.getInt16();
        }
        return bCmETransmittableElements;
    }

    public static BCmETransmittableElements[] getOptionalBCmETransmittableElementsVarArray(IDeserializer iDeserializer) {
        BCmETransmittableElements[] bCmETransmittableElementsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCmETransmittableElementsArray = new BCmETransmittableElements[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCmETransmittableElementsArray[i2] = BCmETransmittableElementsSerializer.getOptionalBCmETransmittableElements(iDeserializer);
            }
        }
        return bCmETransmittableElementsArray;
    }
}

