/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.dsi.kombisync.impl.MenuContextSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.KombiDisplayStatus;
import org.dsi.ifc.kombisync.MenuContext;

public class KombiDisplayStatusSerializer {
    public static void putOptionalKombiDisplayStatus(ISerializer iSerializer, KombiDisplayStatus kombiDisplayStatus) {
        boolean bl = kombiDisplayStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = kombiDisplayStatus.getTid();
            iSerializer.putInt32(n);
            int n2 = kombiDisplayStatus.getFocus();
            iSerializer.putInt32(n2);
            int n3 = kombiDisplayStatus.getScreenFormat();
            iSerializer.putInt32(n3);
            int n4 = kombiDisplayStatus.getMainContext();
            iSerializer.putInt32(n4);
            MenuContext menuContext = kombiDisplayStatus.getMenuContext();
            MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContext);
            int n5 = kombiDisplayStatus.getPopupContext();
            iSerializer.putInt32(n5);
            int n6 = kombiDisplayStatus.getAnimationScreenType();
            iSerializer.putInt32(n6);
            int n7 = kombiDisplayStatus.getAnimationScreenSubType();
            iSerializer.putInt32(n7);
            int n8 = kombiDisplayStatus.getAnimationLeadTime();
            iSerializer.putInt32(n8);
            int n9 = kombiDisplayStatus.getAnimationAddInfo();
            iSerializer.putInt32(n9);
            int n10 = kombiDisplayStatus.getAnimationSpeed();
            iSerializer.putInt32(n10);
        }
    }

    public static void putOptionalKombiDisplayStatusVarArray(ISerializer iSerializer, KombiDisplayStatus[] kombiDisplayStatusArray) {
        boolean bl = kombiDisplayStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(kombiDisplayStatusArray.length);
            for (int i2 = 0; i2 < kombiDisplayStatusArray.length; ++i2) {
                KombiDisplayStatusSerializer.putOptionalKombiDisplayStatus(iSerializer, kombiDisplayStatusArray[i2]);
            }
        }
    }

    public static KombiDisplayStatus getOptionalKombiDisplayStatus(IDeserializer iDeserializer) {
        KombiDisplayStatus kombiDisplayStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            int n6;
            MenuContext menuContext;
            int n7;
            int n8;
            int n9;
            int n10;
            kombiDisplayStatus = new KombiDisplayStatus();
            kombiDisplayStatus.tid = n10 = iDeserializer.getInt32();
            kombiDisplayStatus.focus = n9 = iDeserializer.getInt32();
            kombiDisplayStatus.screenFormat = n8 = iDeserializer.getInt32();
            kombiDisplayStatus.mainContext = n7 = iDeserializer.getInt32();
            kombiDisplayStatus.menuContext = menuContext = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
            kombiDisplayStatus.popupContext = n6 = iDeserializer.getInt32();
            kombiDisplayStatus.animationScreenType = n5 = iDeserializer.getInt32();
            kombiDisplayStatus.animationScreenSubType = n4 = iDeserializer.getInt32();
            kombiDisplayStatus.animationLeadTime = n3 = iDeserializer.getInt32();
            kombiDisplayStatus.animationAddInfo = n2 = iDeserializer.getInt32();
            kombiDisplayStatus.animationSpeed = n = iDeserializer.getInt32();
        }
        return kombiDisplayStatus;
    }

    public static KombiDisplayStatus[] getOptionalKombiDisplayStatusVarArray(IDeserializer iDeserializer) {
        KombiDisplayStatus[] kombiDisplayStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            kombiDisplayStatusArray = new KombiDisplayStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                kombiDisplayStatusArray[i2] = KombiDisplayStatusSerializer.getOptionalKombiDisplayStatus(iDeserializer);
            }
        }
        return kombiDisplayStatusArray;
    }
}

