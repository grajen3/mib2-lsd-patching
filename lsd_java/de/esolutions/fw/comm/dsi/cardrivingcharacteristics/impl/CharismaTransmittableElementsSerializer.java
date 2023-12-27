/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.cardrivingcharacteristics.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.cardrivingcharacteristics.CharismaTransmittableElements;

public class CharismaTransmittableElementsSerializer {
    public static void putOptionalCharismaTransmittableElements(ISerializer iSerializer, CharismaTransmittableElements charismaTransmittableElements) {
        boolean bl = charismaTransmittableElements == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = charismaTransmittableElements.getRa0();
            iSerializer.putInt32(n);
            int n2 = charismaTransmittableElements.getRa1();
            iSerializer.putInt32(n2);
            int n3 = charismaTransmittableElements.getRaF();
            iSerializer.putInt32(n3);
        }
    }

    public static void putOptionalCharismaTransmittableElementsVarArray(ISerializer iSerializer, CharismaTransmittableElements[] charismaTransmittableElementsArray) {
        boolean bl = charismaTransmittableElementsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(charismaTransmittableElementsArray.length);
            for (int i2 = 0; i2 < charismaTransmittableElementsArray.length; ++i2) {
                CharismaTransmittableElementsSerializer.putOptionalCharismaTransmittableElements(iSerializer, charismaTransmittableElementsArray[i2]);
            }
        }
    }

    public static CharismaTransmittableElements getOptionalCharismaTransmittableElements(IDeserializer iDeserializer) {
        CharismaTransmittableElements charismaTransmittableElements = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            charismaTransmittableElements = new CharismaTransmittableElements();
            charismaTransmittableElements.ra0 = n3 = iDeserializer.getInt32();
            charismaTransmittableElements.ra1 = n2 = iDeserializer.getInt32();
            charismaTransmittableElements.raF = n = iDeserializer.getInt32();
        }
        return charismaTransmittableElements;
    }

    public static CharismaTransmittableElements[] getOptionalCharismaTransmittableElementsVarArray(IDeserializer iDeserializer) {
        CharismaTransmittableElements[] charismaTransmittableElementsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            charismaTransmittableElementsArray = new CharismaTransmittableElements[n];
            for (int i2 = 0; i2 < n; ++i2) {
                charismaTransmittableElementsArray[i2] = CharismaTransmittableElementsSerializer.getOptionalCharismaTransmittableElements(iDeserializer);
            }
        }
        return charismaTransmittableElementsArray;
    }
}

