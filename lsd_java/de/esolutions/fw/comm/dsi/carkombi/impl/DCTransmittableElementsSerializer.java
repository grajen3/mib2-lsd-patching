/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCTransmittableElements;

public class DCTransmittableElementsSerializer {
    public static void putOptionalDCTransmittableElements(ISerializer iSerializer, DCTransmittableElements dCTransmittableElements) {
        boolean bl = dCTransmittableElements == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dCTransmittableElements.getRa0();
            iSerializer.putInt32(n);
            int n2 = dCTransmittableElements.getRa1();
            iSerializer.putInt32(n2);
            int n3 = dCTransmittableElements.getRa2();
            iSerializer.putInt32(n3);
            int n4 = dCTransmittableElements.getRaF();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalDCTransmittableElementsVarArray(ISerializer iSerializer, DCTransmittableElements[] dCTransmittableElementsArray) {
        boolean bl = dCTransmittableElementsArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCTransmittableElementsArray.length);
            for (int i2 = 0; i2 < dCTransmittableElementsArray.length; ++i2) {
                DCTransmittableElementsSerializer.putOptionalDCTransmittableElements(iSerializer, dCTransmittableElementsArray[i2]);
            }
        }
    }

    public static DCTransmittableElements getOptionalDCTransmittableElements(IDeserializer iDeserializer) {
        DCTransmittableElements dCTransmittableElements = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            dCTransmittableElements = new DCTransmittableElements();
            dCTransmittableElements.ra0 = n4 = iDeserializer.getInt32();
            dCTransmittableElements.ra1 = n3 = iDeserializer.getInt32();
            dCTransmittableElements.ra2 = n2 = iDeserializer.getInt32();
            dCTransmittableElements.raF = n = iDeserializer.getInt32();
        }
        return dCTransmittableElements;
    }

    public static DCTransmittableElements[] getOptionalDCTransmittableElementsVarArray(IDeserializer iDeserializer) {
        DCTransmittableElements[] dCTransmittableElementsArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCTransmittableElementsArray = new DCTransmittableElements[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCTransmittableElementsArray[i2] = DCTransmittableElementsSerializer.getOptionalDCTransmittableElements(iDeserializer);
            }
        }
        return dCTransmittableElementsArray;
    }
}

