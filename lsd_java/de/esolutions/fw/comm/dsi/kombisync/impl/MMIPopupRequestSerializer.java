/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.MMIPopupRequest;

public class MMIPopupRequestSerializer {
    public static void putOptionalMMIPopupRequest(ISerializer iSerializer, MMIPopupRequest mMIPopupRequest) {
        boolean bl = mMIPopupRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = mMIPopupRequest.getTid();
            iSerializer.putInt32(n);
            int n2 = mMIPopupRequest.getMmiPopupID();
            iSerializer.putInt32(n2);
            int n3 = mMIPopupRequest.getMmiPriority();
            iSerializer.putInt32(n3);
            int n4 = mMIPopupRequest.getZpmPrioritySlotID();
            iSerializer.putInt32(n4);
            boolean bl2 = mMIPopupRequest.isShow();
            iSerializer.putBool(bl2);
            int n5 = mMIPopupRequest.getScreenFormat();
            iSerializer.putInt32(n5);
            int n6 = mMIPopupRequest.getFocus();
            iSerializer.putInt32(n6);
        }
    }

    public static void putOptionalMMIPopupRequestVarArray(ISerializer iSerializer, MMIPopupRequest[] mMIPopupRequestArray) {
        boolean bl = mMIPopupRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(mMIPopupRequestArray.length);
            for (int i2 = 0; i2 < mMIPopupRequestArray.length; ++i2) {
                MMIPopupRequestSerializer.putOptionalMMIPopupRequest(iSerializer, mMIPopupRequestArray[i2]);
            }
        }
    }

    public static MMIPopupRequest getOptionalMMIPopupRequest(IDeserializer iDeserializer) {
        MMIPopupRequest mMIPopupRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            boolean bl2;
            int n3;
            int n4;
            int n5;
            int n6;
            mMIPopupRequest = new MMIPopupRequest();
            mMIPopupRequest.tid = n6 = iDeserializer.getInt32();
            mMIPopupRequest.mmiPopupID = n5 = iDeserializer.getInt32();
            mMIPopupRequest.mmiPriority = n4 = iDeserializer.getInt32();
            mMIPopupRequest.zpmPrioritySlotID = n3 = iDeserializer.getInt32();
            mMIPopupRequest.show = bl2 = iDeserializer.getBool();
            mMIPopupRequest.screenFormat = n2 = iDeserializer.getInt32();
            mMIPopupRequest.focus = n = iDeserializer.getInt32();
        }
        return mMIPopupRequest;
    }

    public static MMIPopupRequest[] getOptionalMMIPopupRequestVarArray(IDeserializer iDeserializer) {
        MMIPopupRequest[] mMIPopupRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            mMIPopupRequestArray = new MMIPopupRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                mMIPopupRequestArray[i2] = MMIPopupRequestSerializer.getOptionalMMIPopupRequest(iDeserializer);
            }
        }
        return mMIPopupRequestArray;
    }
}

