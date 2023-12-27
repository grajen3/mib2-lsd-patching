/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.online.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.online.PicNavSyncInfo;

public class PicNavSyncInfoSerializer {
    public static void putOptionalPicNavSyncInfo(ISerializer iSerializer, PicNavSyncInfo picNavSyncInfo) {
        boolean bl = picNavSyncInfo == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = picNavSyncInfo.getAddItemCount();
            iSerializer.putInt32(n);
            int n2 = picNavSyncInfo.getDeleteItemCount();
            iSerializer.putInt32(n2);
            int n3 = picNavSyncInfo.getRenameItemCount();
            iSerializer.putInt32(n3);
            int n4 = picNavSyncInfo.getMoveItemCount();
            iSerializer.putInt32(n4);
        }
    }

    public static void putOptionalPicNavSyncInfoVarArray(ISerializer iSerializer, PicNavSyncInfo[] picNavSyncInfoArray) {
        boolean bl = picNavSyncInfoArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(picNavSyncInfoArray.length);
            for (int i2 = 0; i2 < picNavSyncInfoArray.length; ++i2) {
                PicNavSyncInfoSerializer.putOptionalPicNavSyncInfo(iSerializer, picNavSyncInfoArray[i2]);
            }
        }
    }

    public static PicNavSyncInfo getOptionalPicNavSyncInfo(IDeserializer iDeserializer) {
        PicNavSyncInfo picNavSyncInfo = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            picNavSyncInfo = new PicNavSyncInfo();
            picNavSyncInfo.addItemCount = n4 = iDeserializer.getInt32();
            picNavSyncInfo.deleteItemCount = n3 = iDeserializer.getInt32();
            picNavSyncInfo.renameItemCount = n2 = iDeserializer.getInt32();
            picNavSyncInfo.moveItemCount = n = iDeserializer.getInt32();
        }
        return picNavSyncInfo;
    }

    public static PicNavSyncInfo[] getOptionalPicNavSyncInfoVarArray(IDeserializer iDeserializer) {
        PicNavSyncInfo[] picNavSyncInfoArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            picNavSyncInfoArray = new PicNavSyncInfo[n];
            for (int i2 = 0; i2 < n; ++i2) {
                picNavSyncInfoArray[i2] = PicNavSyncInfoSerializer.getOptionalPicNavSyncInfo(iDeserializer);
            }
        }
        return picNavSyncInfoArray;
    }
}

