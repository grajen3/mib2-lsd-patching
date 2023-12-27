/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.MenuContextSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupStatusFlagsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.MenuContext;
import org.dsi.ifc.kombisync2.PopupStatus;
import org.dsi.ifc.kombisync2.PopupStatusFlags;

public class PopupStatusSerializer {
    public static void putOptionalPopupStatus(ISerializer iSerializer, PopupStatus popupStatus) {
        boolean bl = popupStatus == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = popupStatus.getPopupID();
            iSerializer.putInt32(n);
            int n2 = popupStatus.getPopupID2();
            iSerializer.putInt32(n2);
            int n3 = popupStatus.getScreenFormat();
            iSerializer.putInt32(n3);
            int n4 = popupStatus.getFocus();
            iSerializer.putInt32(n4);
            MenuContext menuContext = popupStatus.getMenuContext();
            MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContext);
            int n5 = popupStatus.getPopupFlapLeft();
            iSerializer.putInt32(n5);
            int n6 = popupStatus.getPopupFlapRight();
            iSerializer.putInt32(n6);
            PopupStatusFlags popupStatusFlags = popupStatus.getPopupStatusFlags();
            PopupStatusFlagsSerializer.putOptionalPopupStatusFlags(iSerializer, popupStatusFlags);
        }
    }

    public static void putOptionalPopupStatusVarArray(ISerializer iSerializer, PopupStatus[] popupStatusArray) {
        boolean bl = popupStatusArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(popupStatusArray.length);
            for (int i2 = 0; i2 < popupStatusArray.length; ++i2) {
                PopupStatusSerializer.putOptionalPopupStatus(iSerializer, popupStatusArray[i2]);
            }
        }
    }

    public static PopupStatus getOptionalPopupStatus(IDeserializer iDeserializer) {
        PopupStatus popupStatus = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            PopupStatusFlags popupStatusFlags;
            int n;
            int n2;
            MenuContext menuContext;
            int n3;
            int n4;
            int n5;
            int n6;
            popupStatus = new PopupStatus();
            popupStatus.popupID = n6 = iDeserializer.getInt32();
            popupStatus.popupID2 = n5 = iDeserializer.getInt32();
            popupStatus.screenFormat = n4 = iDeserializer.getInt32();
            popupStatus.focus = n3 = iDeserializer.getInt32();
            popupStatus.menuContext = menuContext = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
            popupStatus.popupFlapLeft = n2 = iDeserializer.getInt32();
            popupStatus.popupFlapRight = n = iDeserializer.getInt32();
            popupStatus.popupStatusFlags = popupStatusFlags = PopupStatusFlagsSerializer.getOptionalPopupStatusFlags(iDeserializer);
        }
        return popupStatus;
    }

    public static PopupStatus[] getOptionalPopupStatusVarArray(IDeserializer iDeserializer) {
        PopupStatus[] popupStatusArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            popupStatusArray = new PopupStatus[n];
            for (int i2 = 0; i2 < n; ++i2) {
                popupStatusArray[i2] = PopupStatusSerializer.getOptionalPopupStatus(iDeserializer);
            }
        }
        return popupStatusArray;
    }
}

