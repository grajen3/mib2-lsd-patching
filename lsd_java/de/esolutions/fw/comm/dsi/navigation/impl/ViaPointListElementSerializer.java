/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.ViaPointListElement;

public class ViaPointListElementSerializer {
    public static void putOptionalViaPointListElement(ISerializer iSerializer, ViaPointListElement viaPointListElement) {
        boolean bl = viaPointListElement == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = viaPointListElement.getId();
            iSerializer.putInt32(n);
            String string = viaPointListElement.getDescription();
            iSerializer.putOptionalString(string);
            long l = viaPointListElement.getRoadIconId();
            iSerializer.putInt64(l);
            String string2 = viaPointListElement.getRoadNumber();
            iSerializer.putOptionalString(string2);
            boolean bl2 = viaPointListElement.isHasChildren();
            iSerializer.putBool(bl2);
            long l2 = viaPointListElement.getParentID();
            iSerializer.putInt64(l2);
            int n2 = viaPointListElement.getNumberOfViaPointsInNode();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalViaPointListElementVarArray(ISerializer iSerializer, ViaPointListElement[] viaPointListElementArray) {
        boolean bl = viaPointListElementArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(viaPointListElementArray.length);
            for (int i2 = 0; i2 < viaPointListElementArray.length; ++i2) {
                ViaPointListElementSerializer.putOptionalViaPointListElement(iSerializer, viaPointListElementArray[i2]);
            }
        }
    }

    public static ViaPointListElement getOptionalViaPointListElement(IDeserializer iDeserializer) {
        ViaPointListElement viaPointListElement = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            long l;
            boolean bl2;
            String string;
            long l2;
            String string2;
            int n2;
            viaPointListElement = new ViaPointListElement();
            viaPointListElement.id = n2 = iDeserializer.getInt32();
            viaPointListElement.description = string2 = iDeserializer.getOptionalString();
            viaPointListElement.roadIconId = l2 = iDeserializer.getInt64();
            viaPointListElement.roadNumber = string = iDeserializer.getOptionalString();
            viaPointListElement.hasChildren = bl2 = iDeserializer.getBool();
            viaPointListElement.parentID = l = iDeserializer.getInt64();
            viaPointListElement.numberOfViaPointsInNode = n = iDeserializer.getInt32();
        }
        return viaPointListElement;
    }

    public static ViaPointListElement[] getOptionalViaPointListElementVarArray(IDeserializer iDeserializer) {
        ViaPointListElement[] viaPointListElementArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            viaPointListElementArray = new ViaPointListElement[n];
            for (int i2 = 0; i2 < n; ++i2) {
                viaPointListElementArray[i2] = ViaPointListElementSerializer.getOptionalViaPointListElement(iDeserializer);
            }
        }
        return viaPointListElementArray;
    }
}

