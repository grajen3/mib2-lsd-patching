/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carkombi.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carkombi.DCElementContentSelectionListRA2;

public class DCElementContentSelectionListRA2Serializer {
    public static void putOptionalDCElementContentSelectionListRA2(ISerializer iSerializer, DCElementContentSelectionListRA2 dCElementContentSelectionListRA2) {
        boolean bl = dCElementContentSelectionListRA2 == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = dCElementContentSelectionListRA2.getPos();
            iSerializer.putInt32(n);
            int n2 = dCElementContentSelectionListRA2.getElementContent();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalDCElementContentSelectionListRA2VarArray(ISerializer iSerializer, DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array) {
        boolean bl = dCElementContentSelectionListRA2Array == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(dCElementContentSelectionListRA2Array.length);
            for (int i2 = 0; i2 < dCElementContentSelectionListRA2Array.length; ++i2) {
                DCElementContentSelectionListRA2Serializer.putOptionalDCElementContentSelectionListRA2(iSerializer, dCElementContentSelectionListRA2Array[i2]);
            }
        }
    }

    public static DCElementContentSelectionListRA2 getOptionalDCElementContentSelectionListRA2(IDeserializer iDeserializer) {
        DCElementContentSelectionListRA2 dCElementContentSelectionListRA2 = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            dCElementContentSelectionListRA2 = new DCElementContentSelectionListRA2();
            dCElementContentSelectionListRA2.pos = n2 = iDeserializer.getInt32();
            dCElementContentSelectionListRA2.elementContent = n = iDeserializer.getInt32();
        }
        return dCElementContentSelectionListRA2;
    }

    public static DCElementContentSelectionListRA2[] getOptionalDCElementContentSelectionListRA2VarArray(IDeserializer iDeserializer) {
        DCElementContentSelectionListRA2[] dCElementContentSelectionListRA2Array = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            dCElementContentSelectionListRA2Array = new DCElementContentSelectionListRA2[n];
            for (int i2 = 0; i2 < n; ++i2) {
                dCElementContentSelectionListRA2Array[i2] = DCElementContentSelectionListRA2Serializer.getOptionalDCElementContentSelectionListRA2(iDeserializer);
            }
        }
        return dCElementContentSelectionListRA2Array;
    }
}

