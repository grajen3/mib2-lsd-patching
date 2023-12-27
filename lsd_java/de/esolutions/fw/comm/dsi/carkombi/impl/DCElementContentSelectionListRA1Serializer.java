/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA1;

public class DCElementContentSelectionListRA1Serializer {
    public static void putOptionalDCElementContentSelectionListRA1(ISerializer iSerializer, DCElementContentSelectionListRA1 dCElementContentSelectionListRA1) {
        boolean bl = dCElementContentSelectionListRA1 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dCElementContentSelectionListRA1.getPos();
            iSerializer.putInt32(n);
            int n2 = dCElementContentSelectionListRA1.getDisplay();
            iSerializer.putInt32(n2);
            int n3 = dCElementContentSelectionListRA1.getAdditionalInfo();
            iSerializer.putInt32(n3);
            int n4 = dCElementContentSelectionListRA1.getElement();
            iSerializer.putInt32(n4);
            int n5 = dCElementContentSelectionListRA1.getElementContent();
            iSerializer.putInt32(n5);
        }
    }

    public static void putOptionalDCElementContentSelectionListRA1VarArray(ISerializer iSerializer, DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array) {
        boolean bl = dCElementContentSelectionListRA1Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCElementContentSelectionListRA1Array.length);
            for (int i2 = 0; i2 < dCElementContentSelectionListRA1Array.length; ++i2) {
                DCElementContentSelectionListRA1Serializer.putOptionalDCElementContentSelectionListRA1(iSerializer, dCElementContentSelectionListRA1Array[i2]);
            }
        }
    }

    public static DCElementContentSelectionListRA1 getOptionalDCElementContentSelectionListRA1(IDeserializer iDeserializer) {
        DCElementContentSelectionListRA1 dCElementContentSelectionListRA1 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            dCElementContentSelectionListRA1 = new DCElementContentSelectionListRA1();
            dCElementContentSelectionListRA1.pos = n5 = iDeserializer.getInt32();
            dCElementContentSelectionListRA1.display = n4 = iDeserializer.getInt32();
            dCElementContentSelectionListRA1.additionalInfo = n3 = iDeserializer.getInt32();
            dCElementContentSelectionListRA1.element = n2 = iDeserializer.getInt32();
            dCElementContentSelectionListRA1.elementContent = n = iDeserializer.getInt32();
        }
        return dCElementContentSelectionListRA1;
    }

    public static DCElementContentSelectionListRA1[] getOptionalDCElementContentSelectionListRA1VarArray(IDeserializer iDeserializer) {
        DCElementContentSelectionListRA1[] dCElementContentSelectionListRA1Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCElementContentSelectionListRA1Array = new DCElementContentSelectionListRA1[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCElementContentSelectionListRA1Array[i2] = DCElementContentSelectionListRA1Serializer.getOptionalDCElementContentSelectionListRA1(iDeserializer);
            }
        }
        return dCElementContentSelectionListRA1Array;
    }
}

