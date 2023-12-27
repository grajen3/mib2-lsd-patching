/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.dsi.kombisync.impl.MenuContextSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.MMIDisplayRequest;
import org.dsi.ifc.kombisync.MenuContext;

public class MMIDisplayRequestSerializer {
    public static void putOptionalMMIDisplayRequest(ISerializer iSerializer, MMIDisplayRequest mMIDisplayRequest) {
        boolean bl = mMIDisplayRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = mMIDisplayRequest.getTid();
            iSerializer.putInt32(n);
            int n2 = mMIDisplayRequest.getFocus();
            iSerializer.putInt32(n2);
            int n3 = mMIDisplayRequest.getScreenFormat();
            iSerializer.putInt32(n3);
            int n4 = mMIDisplayRequest.getMainContext();
            iSerializer.putInt32(n4);
            MenuContext menuContext = mMIDisplayRequest.getMenuContext();
            MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContext);
            int n5 = mMIDisplayRequest.getPopupContext();
            iSerializer.putInt32(n5);
            boolean bl2 = mMIDisplayRequest.isQuitInfo();
            iSerializer.putBool(bl2);
        }
    }

    public static void putOptionalMMIDisplayRequestVarArray(ISerializer iSerializer, MMIDisplayRequest[] mMIDisplayRequestArray) {
        boolean bl = mMIDisplayRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mMIDisplayRequestArray.length);
            for (int i2 = 0; i2 < mMIDisplayRequestArray.length; ++i2) {
                MMIDisplayRequestSerializer.putOptionalMMIDisplayRequest(iSerializer, mMIDisplayRequestArray[i2]);
            }
        }
    }

    public static MMIDisplayRequest getOptionalMMIDisplayRequest(IDeserializer iDeserializer) {
        MMIDisplayRequest mMIDisplayRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            int n;
            MenuContext menuContext;
            int n2;
            int n3;
            int n4;
            int n5;
            mMIDisplayRequest = new MMIDisplayRequest();
            mMIDisplayRequest.tid = n5 = iDeserializer.getInt32();
            mMIDisplayRequest.focus = n4 = iDeserializer.getInt32();
            mMIDisplayRequest.screenFormat = n3 = iDeserializer.getInt32();
            mMIDisplayRequest.mainContext = n2 = iDeserializer.getInt32();
            mMIDisplayRequest.menuContext = menuContext = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
            mMIDisplayRequest.popupContext = n = iDeserializer.getInt32();
            mMIDisplayRequest.quitInfo = bl2 = iDeserializer.getBool();
        }
        return mMIDisplayRequest;
    }

    public static MMIDisplayRequest[] getOptionalMMIDisplayRequestVarArray(IDeserializer iDeserializer) {
        MMIDisplayRequest[] mMIDisplayRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mMIDisplayRequestArray = new MMIDisplayRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mMIDisplayRequestArray[i2] = MMIDisplayRequestSerializer.getOptionalMMIDisplayRequest(iDeserializer);
            }
        }
        return mMIDisplayRequestArray;
    }
}

