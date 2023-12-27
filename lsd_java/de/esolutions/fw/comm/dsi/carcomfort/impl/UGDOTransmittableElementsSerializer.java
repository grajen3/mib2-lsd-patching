/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carcomfort.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carcomfort.UGDOTransmittableElements;

public class UGDOTransmittableElementsSerializer {
    public static void putOptionalUGDOTransmittableElements(ISerializer iSerializer, UGDOTransmittableElements uGDOTransmittableElements) {
        boolean bl = uGDOTransmittableElements == null;
        iSerializer.putBool(bl);
        if (!bl) {
            short s = uGDOTransmittableElements.getRa0();
            iSerializer.putInt16(s);
            short s2 = uGDOTransmittableElements.getRa1();
            iSerializer.putInt16(s2);
            short s3 = uGDOTransmittableElements.getRa2();
            iSerializer.putInt16(s3);
            short s4 = uGDOTransmittableElements.getRa3();
            iSerializer.putInt16(s4);
            short s5 = uGDOTransmittableElements.getRa4();
            iSerializer.putInt16(s5);
            short s6 = uGDOTransmittableElements.getRa5();
            iSerializer.putInt16(s6);
            short s7 = uGDOTransmittableElements.getRaF();
            iSerializer.putInt16(s7);
        }
    }

    public static void putOptionalUGDOTransmittableElementsVarArray(ISerializer iSerializer, UGDOTransmittableElements[] uGDOTransmittableElementsArray) {
        boolean bl = uGDOTransmittableElementsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(uGDOTransmittableElementsArray.length);
            for (int i2 = 0; i2 < uGDOTransmittableElementsArray.length; ++i2) {
                UGDOTransmittableElementsSerializer.putOptionalUGDOTransmittableElements(iSerializer, uGDOTransmittableElementsArray[i2]);
            }
        }
    }

    public static UGDOTransmittableElements getOptionalUGDOTransmittableElements(IDeserializer iDeserializer) {
        UGDOTransmittableElements uGDOTransmittableElements = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            short s;
            short s2;
            short s3;
            short s4;
            short s5;
            short s6;
            short s7;
            uGDOTransmittableElements = new UGDOTransmittableElements();
            uGDOTransmittableElements.ra0 = s7 = iDeserializer.getInt16();
            uGDOTransmittableElements.ra1 = s6 = iDeserializer.getInt16();
            uGDOTransmittableElements.ra2 = s5 = iDeserializer.getInt16();
            uGDOTransmittableElements.ra3 = s4 = iDeserializer.getInt16();
            uGDOTransmittableElements.ra4 = s3 = iDeserializer.getInt16();
            uGDOTransmittableElements.ra5 = s2 = iDeserializer.getInt16();
            uGDOTransmittableElements.raF = s = iDeserializer.getInt16();
        }
        return uGDOTransmittableElements;
    }

    public static UGDOTransmittableElements[] getOptionalUGDOTransmittableElementsVarArray(IDeserializer iDeserializer) {
        UGDOTransmittableElements[] uGDOTransmittableElementsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            uGDOTransmittableElementsArray = new UGDOTransmittableElements[n];
            for (int i2 = 0; i2 < n; ++i2) {
                uGDOTransmittableElementsArray[i2] = UGDOTransmittableElementsSerializer.getOptionalUGDOTransmittableElements(iDeserializer);
            }
        }
        return uGDOTransmittableElementsArray;
    }
}

