/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.navigation.impl;

import de.esolutions.fw.comm.dsi.navigation.impl.LIValueListElementSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.navigation.LIValueList;
import org.dsi.ifc.navigation.LIValueListElement;

public class LIValueListSerializer {
    public static void putOptionalLIValueList(ISerializer iSerializer, LIValueList lIValueList) {
        boolean bl = lIValueList == null;
        iSerializer.putBool(bl);
        if (!bl) {
            LIValueListElement[] lIValueListElementArray = lIValueList.getList();
            LIValueListElementSerializer.putOptionalLIValueListElementVarArray(iSerializer, lIValueListElementArray);
            boolean bl2 = lIValueList.isHasNextPage();
            iSerializer.putBool(bl2);
            boolean bl3 = lIValueList.isHasPrevPage();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalLIValueListVarArray(ISerializer iSerializer, LIValueList[] lIValueListArray) {
        boolean bl = lIValueListArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(lIValueListArray.length);
            for (int i2 = 0; i2 < lIValueListArray.length; ++i2) {
                LIValueListSerializer.putOptionalLIValueList(iSerializer, lIValueListArray[i2]);
            }
        }
    }

    public static LIValueList getOptionalLIValueList(IDeserializer iDeserializer) {
        LIValueList lIValueList = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            lIValueList = new LIValueList();
            LIValueListElement[] lIValueListElementArray = LIValueListElementSerializer.getOptionalLIValueListElementVarArray(iDeserializer);
            lIValueList.list = lIValueListElementArray;
            lIValueList.hasNextPage = bl3 = iDeserializer.getBool();
            lIValueList.hasPrevPage = bl2 = iDeserializer.getBool();
        }
        return lIValueList;
    }

    public static LIValueList[] getOptionalLIValueListVarArray(IDeserializer iDeserializer) {
        LIValueList[] lIValueListArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            lIValueListArray = new LIValueList[n];
            for (int i2 = 0; i2 < n; ++i2) {
                lIValueListArray[i2] = LIValueListSerializer.getOptionalLIValueList(iDeserializer);
            }
        }
        return lIValueListArray;
    }
}

