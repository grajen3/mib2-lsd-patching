/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.KombiPopupStatus;

public class KombiPopupStatusSerializer {
    public static void putOptionalKombiPopupStatus(ISerializer iSerializer, KombiPopupStatus kombiPopupStatus) {
        boolean bl = kombiPopupStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = kombiPopupStatus.getTid();
            iSerializer.putInt32(n);
            int n2 = kombiPopupStatus.getMmiPopupID();
            iSerializer.putInt32(n2);
            int n3 = kombiPopupStatus.getMmiPopupState();
            iSerializer.putInt32(n3);
            int n4 = kombiPopupStatus.getZpmPrioritySlotID();
            iSerializer.putInt32(n4);
            int n5 = kombiPopupStatus.getMmiPopupPriority();
            iSerializer.putInt32(n5);
            int n6 = kombiPopupStatus.getScreenFormat();
            iSerializer.putInt32(n6);
            int n7 = kombiPopupStatus.getFocus();
            iSerializer.putInt32(n7);
        }
    }

    public static void putOptionalKombiPopupStatusVarArray(ISerializer iSerializer, KombiPopupStatus[] kombiPopupStatusArray) {
        boolean bl = kombiPopupStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(kombiPopupStatusArray.length);
            for (int i2 = 0; i2 < kombiPopupStatusArray.length; ++i2) {
                KombiPopupStatusSerializer.putOptionalKombiPopupStatus(iSerializer, kombiPopupStatusArray[i2]);
            }
        }
    }

    public static KombiPopupStatus getOptionalKombiPopupStatus(IDeserializer iDeserializer) {
        KombiPopupStatus kombiPopupStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            int n7;
            kombiPopupStatus = new KombiPopupStatus();
            kombiPopupStatus.tid = n7 = iDeserializer.getInt32();
            kombiPopupStatus.mmiPopupID = n6 = iDeserializer.getInt32();
            kombiPopupStatus.mmiPopupState = n5 = iDeserializer.getInt32();
            kombiPopupStatus.zpmPrioritySlotID = n4 = iDeserializer.getInt32();
            kombiPopupStatus.mmiPopupPriority = n3 = iDeserializer.getInt32();
            kombiPopupStatus.screenFormat = n2 = iDeserializer.getInt32();
            kombiPopupStatus.focus = n = iDeserializer.getInt32();
        }
        return kombiPopupStatus;
    }

    public static KombiPopupStatus[] getOptionalKombiPopupStatusVarArray(IDeserializer iDeserializer) {
        KombiPopupStatus[] kombiPopupStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            kombiPopupStatusArray = new KombiPopupStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                kombiPopupStatusArray[i2] = KombiPopupStatusSerializer.getOptionalKombiPopupStatus(iDeserializer);
            }
        }
        return kombiPopupStatusArray;
    }
}

