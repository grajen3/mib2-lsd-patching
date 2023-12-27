/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync.impl;

import de.esolutions.fw.comm.dsi.kombisync.impl.MenuContextSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync.KombiDisplayRequest;
import org.dsi.ifc.kombisync.MenuContext;

public class KombiDisplayRequestSerializer {
    public static void putOptionalKombiDisplayRequest(ISerializer iSerializer, KombiDisplayRequest kombiDisplayRequest) {
        boolean bl = kombiDisplayRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = kombiDisplayRequest.getTid();
            iSerializer.putInt32(n);
            int n2 = kombiDisplayRequest.getFocus();
            iSerializer.putInt32(n2);
            int n3 = kombiDisplayRequest.getScreenFormat();
            iSerializer.putInt32(n3);
            int n4 = kombiDisplayRequest.getMainContext();
            iSerializer.putInt32(n4);
            MenuContext menuContext = kombiDisplayRequest.getMenuContext();
            MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContext);
            int n5 = kombiDisplayRequest.getPopupContext();
            iSerializer.putInt32(n5);
            int n6 = kombiDisplayRequest.getAnimationScreenType();
            iSerializer.putInt32(n6);
            int n7 = kombiDisplayRequest.getAnimationScreenSubType();
            iSerializer.putInt32(n7);
            int n8 = kombiDisplayRequest.getAnimationLeadTime();
            iSerializer.putInt32(n8);
            int n9 = kombiDisplayRequest.getAnimationAddInfo();
            iSerializer.putInt32(n9);
            boolean bl2 = kombiDisplayRequest.isLastmoderequest();
            iSerializer.putBool(bl2);
            boolean bl3 = kombiDisplayRequest.isLvdslock();
            iSerializer.putBool(bl3);
        }
    }

    public static void putOptionalKombiDisplayRequestVarArray(ISerializer iSerializer, KombiDisplayRequest[] kombiDisplayRequestArray) {
        boolean bl = kombiDisplayRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(kombiDisplayRequestArray.length);
            for (int i2 = 0; i2 < kombiDisplayRequestArray.length; ++i2) {
                KombiDisplayRequestSerializer.putOptionalKombiDisplayRequest(iSerializer, kombiDisplayRequestArray[i2]);
            }
        }
    }

    public static KombiDisplayRequest getOptionalKombiDisplayRequest(IDeserializer iDeserializer) {
        KombiDisplayRequest kombiDisplayRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            boolean bl2;
            boolean bl3;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            MenuContext menuContext;
            int n6;
            int n7;
            int n8;
            int n9;
            kombiDisplayRequest = new KombiDisplayRequest();
            kombiDisplayRequest.tid = n9 = iDeserializer.getInt32();
            kombiDisplayRequest.focus = n8 = iDeserializer.getInt32();
            kombiDisplayRequest.screenFormat = n7 = iDeserializer.getInt32();
            kombiDisplayRequest.mainContext = n6 = iDeserializer.getInt32();
            kombiDisplayRequest.menuContext = menuContext = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
            kombiDisplayRequest.popupContext = n5 = iDeserializer.getInt32();
            kombiDisplayRequest.animationScreenType = n4 = iDeserializer.getInt32();
            kombiDisplayRequest.animationScreenSubType = n3 = iDeserializer.getInt32();
            kombiDisplayRequest.animationLeadTime = n2 = iDeserializer.getInt32();
            kombiDisplayRequest.animationAddInfo = n = iDeserializer.getInt32();
            kombiDisplayRequest.lastmoderequest = bl3 = iDeserializer.getBool();
            kombiDisplayRequest.lvdslock = bl2 = iDeserializer.getBool();
        }
        return kombiDisplayRequest;
    }

    public static KombiDisplayRequest[] getOptionalKombiDisplayRequestVarArray(IDeserializer iDeserializer) {
        KombiDisplayRequest[] kombiDisplayRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            kombiDisplayRequestArray = new KombiDisplayRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                kombiDisplayRequestArray[i2] = KombiDisplayRequestSerializer.getOptionalKombiDisplayRequest(iDeserializer);
            }
        }
        return kombiDisplayRequestArray;
    }
}

