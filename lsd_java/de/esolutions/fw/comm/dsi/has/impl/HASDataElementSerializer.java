/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.has.impl;

import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.has.HASDataElement;

public class HASDataElementSerializer {
    public static void putOptionalHASDataElement(ISerializer iSerializer, HASDataElement hASDataElement) {
        boolean bl = hASDataElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = hASDataElement.getElementId();
            iSerializer.putInt32(n);
            int n2 = hASDataElement.getElementType();
            iSerializer.putInt32(n2);
            long l = hASDataElement.getNumericData();
            iSerializer.putInt64(l);
            String string = hASDataElement.getStringData();
            iSerializer.putOptionalString(string);
            double d2 = hASDataElement.getDoubleData();
            iSerializer.putDouble(d2);
            byte[] byArray = hASDataElement.getBinaryData();
            iSerializer.putOptionalInt8VarArray(byArray);
            ResourceLocator resourceLocator = hASDataElement.getResourceLocator();
            ResourceLocatorSerializer.putOptionalResourceLocator(iSerializer, resourceLocator);
        }
    }

    public static void putOptionalHASDataElementVarArray(ISerializer iSerializer, HASDataElement[] hASDataElementArray) {
        boolean bl = hASDataElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(hASDataElementArray.length);
            for (int i2 = 0; i2 < hASDataElementArray.length; ++i2) {
                HASDataElementSerializer.putOptionalHASDataElement(iSerializer, hASDataElementArray[i2]);
            }
        }
    }

    public static HASDataElement getOptionalHASDataElement(IDeserializer iDeserializer) {
        HASDataElement hASDataElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            ResourceLocator resourceLocator;
            double d2;
            String string;
            long l;
            int n;
            int n2;
            hASDataElement = new HASDataElement();
            hASDataElement.elementId = n2 = iDeserializer.getInt32();
            hASDataElement.elementType = n = iDeserializer.getInt32();
            hASDataElement.numericData = l = iDeserializer.getInt64();
            hASDataElement.stringData = string = iDeserializer.getOptionalString();
            hASDataElement.doubleData = d2 = iDeserializer.getDouble();
            byte[] byArray = iDeserializer.getOptionalInt8VarArray();
            hASDataElement.binaryData = byArray;
            hASDataElement.resourceLocator = resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
        }
        return hASDataElement;
    }

    public static HASDataElement[] getOptionalHASDataElementVarArray(IDeserializer iDeserializer) {
        HASDataElement[] hASDataElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            hASDataElementArray = new HASDataElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                hASDataElementArray[i2] = HASDataElementSerializer.getOptionalHASDataElement(iDeserializer);
            }
        }
        return hASDataElementArray;
    }
}

