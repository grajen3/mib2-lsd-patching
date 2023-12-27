/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.global.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.global.NavSegmentID;

public class NavSegmentIDSerializer {
    public static void putOptionalNavSegmentID(ISerializer iSerializer, NavSegmentID navSegmentID) {
        boolean bl = navSegmentID == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int[] nArray = navSegmentID.getElements();
            iSerializer.putOptionalInt32VarArray(nArray);
        }
    }

    public static void putOptionalNavSegmentIDVarArray(ISerializer iSerializer, NavSegmentID[] navSegmentIDArray) {
        boolean bl = navSegmentIDArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(navSegmentIDArray.length);
            for (int i2 = 0; i2 < navSegmentIDArray.length; ++i2) {
                NavSegmentIDSerializer.putOptionalNavSegmentID(iSerializer, navSegmentIDArray[i2]);
            }
        }
    }

    public static NavSegmentID getOptionalNavSegmentID(IDeserializer iDeserializer) {
        NavSegmentID navSegmentID = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            navSegmentID = new NavSegmentID();
            int[] nArray = iDeserializer.getOptionalInt32VarArray();
            navSegmentID.elements = nArray;
        }
        return navSegmentID;
    }

    public static NavSegmentID[] getOptionalNavSegmentIDVarArray(IDeserializer iDeserializer) {
        NavSegmentID[] navSegmentIDArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            navSegmentIDArray = new NavSegmentID[n];
            for (int i2 = 0; i2 < n; ++i2) {
                navSegmentIDArray[i2] = NavSegmentIDSerializer.getOptionalNavSegmentID(iDeserializer);
            }
        }
        return navSegmentIDArray;
    }
}

