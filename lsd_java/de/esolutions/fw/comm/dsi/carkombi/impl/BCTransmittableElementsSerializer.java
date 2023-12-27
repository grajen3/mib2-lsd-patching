/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.BCTransmittableElements;

public class BCTransmittableElementsSerializer {
    public static void putOptionalBCTransmittableElements(ISerializer iSerializer, BCTransmittableElements bCTransmittableElements) {
        boolean bl = bCTransmittableElements == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = bCTransmittableElements.getRa0();
            iSerializer.putInt32(n);
            int n2 = bCTransmittableElements.getRa1();
            iSerializer.putInt32(n2);
            int n3 = bCTransmittableElements.getRa2();
            iSerializer.putInt32(n3);
            int n4 = bCTransmittableElements.getRa3();
            iSerializer.putInt32(n4);
            int n5 = bCTransmittableElements.getRaF();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalBCTransmittableElementsVarArray(ISerializer iSerializer, BCTransmittableElements[] bCTransmittableElementsArray) {
        boolean bl = bCTransmittableElementsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(bCTransmittableElementsArray.length);
            for (int i2 = 0; i2 < bCTransmittableElementsArray.length; ++i2) {
                BCTransmittableElementsSerializer.putOptionalBCTransmittableElements(iSerializer, bCTransmittableElementsArray[i2]);
            }
        }
    }

    public static BCTransmittableElements getOptionalBCTransmittableElements(IDeserializer iDeserializer) {
        BCTransmittableElements bCTransmittableElements = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            bCTransmittableElements = new BCTransmittableElements();
            bCTransmittableElements.ra0 = n5 = iDeserializer.getInt32();
            bCTransmittableElements.ra1 = n4 = iDeserializer.getInt32();
            bCTransmittableElements.ra2 = n3 = iDeserializer.getInt32();
            bCTransmittableElements.ra3 = n2 = iDeserializer.getInt32();
            bCTransmittableElements.raF = n = iDeserializer.getInt32();
        }
        return bCTransmittableElements;
    }

    public static BCTransmittableElements[] getOptionalBCTransmittableElementsVarArray(IDeserializer iDeserializer) {
        BCTransmittableElements[] bCTransmittableElementsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            bCTransmittableElementsArray = new BCTransmittableElements[n];
            for (int i2 = 0; i2 < n; ++i2) {
                bCTransmittableElementsArray[i2] = BCTransmittableElementsSerializer.getOptionalBCTransmittableElements(iDeserializer);
            }
        }
        return bCTransmittableElementsArray;
    }
}

