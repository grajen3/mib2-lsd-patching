/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.dsi.kombisync.impl.MenuContextSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.MMIDisplayStatus;
import org.dsi.ifc.kombisync.MenuContext;

public class MMIDisplayStatusSerializer {
    public static void putOptionalMMIDisplayStatus(ISerializer iSerializer, MMIDisplayStatus mMIDisplayStatus) {
        boolean bl = mMIDisplayStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = mMIDisplayStatus.getTid();
            iSerializer.putInt32(n);
            int n2 = mMIDisplayStatus.getFocus();
            iSerializer.putInt32(n2);
            int n3 = mMIDisplayStatus.getScreenFormat();
            iSerializer.putInt32(n3);
            int n4 = mMIDisplayStatus.getMainContext();
            iSerializer.putInt32(n4);
            MenuContext menuContext = mMIDisplayStatus.getMenuContext();
            MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContext);
            int n5 = mMIDisplayStatus.getPopupContext();
            iSerializer.putInt32(n5);
            int n6 = mMIDisplayStatus.getAnimationSpeed();
            iSerializer.putInt32(n6);
            int n7 = mMIDisplayStatus.getAnimationInfo();
            iSerializer.putInt32(n7);
            int n8 = mMIDisplayStatus.getKdkOpacity();
            iSerializer.putInt32(n8);
            boolean bl2 = mMIDisplayStatus.isKdkVisible();
            iSerializer.putBool(bl2);
            boolean bl3 = mMIDisplayStatus.isBargraphVisible();
            iSerializer.putBool(bl3);
            int n9 = mMIDisplayStatus.getKdkPositionInfo();
            iSerializer.putInt32(n9);
        }
    }

    public static void putOptionalMMIDisplayStatusVarArray(ISerializer iSerializer, MMIDisplayStatus[] mMIDisplayStatusArray) {
        boolean bl = mMIDisplayStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mMIDisplayStatusArray.length);
            for (int i2 = 0; i2 < mMIDisplayStatusArray.length; ++i2) {
                MMIDisplayStatusSerializer.putOptionalMMIDisplayStatus(iSerializer, mMIDisplayStatusArray[i2]);
            }
        }
    }

    public static MMIDisplayStatus getOptionalMMIDisplayStatus(IDeserializer iDeserializer) {
        MMIDisplayStatus mMIDisplayStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            boolean bl3;
            int n2;
            int n3;
            int n4;
            int n5;
            MenuContext menuContext;
            int n6;
            int n7;
            int n8;
            int n9;
            mMIDisplayStatus = new MMIDisplayStatus();
            mMIDisplayStatus.tid = n9 = iDeserializer.getInt32();
            mMIDisplayStatus.focus = n8 = iDeserializer.getInt32();
            mMIDisplayStatus.screenFormat = n7 = iDeserializer.getInt32();
            mMIDisplayStatus.mainContext = n6 = iDeserializer.getInt32();
            mMIDisplayStatus.menuContext = menuContext = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
            mMIDisplayStatus.popupContext = n5 = iDeserializer.getInt32();
            mMIDisplayStatus.animationSpeed = n4 = iDeserializer.getInt32();
            mMIDisplayStatus.animationInfo = n3 = iDeserializer.getInt32();
            mMIDisplayStatus.kdkOpacity = n2 = iDeserializer.getInt32();
            mMIDisplayStatus.kdkVisible = bl3 = iDeserializer.getBool();
            mMIDisplayStatus.bargraphVisible = bl2 = iDeserializer.getBool();
            mMIDisplayStatus.kdkPositionInfo = n = iDeserializer.getInt32();
        }
        return mMIDisplayStatus;
    }

    public static MMIDisplayStatus[] getOptionalMMIDisplayStatusVarArray(IDeserializer iDeserializer) {
        MMIDisplayStatus[] mMIDisplayStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mMIDisplayStatusArray = new MMIDisplayStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mMIDisplayStatusArray[i2] = MMIDisplayStatusSerializer.getOptionalMMIDisplayStatus(iDeserializer);
            }
        }
        return mMIDisplayStatusArray;
    }
}

