/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.MenuContextSerializer;
import de.esolutions.fw.comm.dsi.kombisync2.impl.PopupStatusFlagsSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.MenuContext;
import org.dsi.ifc.kombisync2.PopupRegisterRequestResponse;
import org.dsi.ifc.kombisync2.PopupStatusFlags;

public class PopupRegisterRequestResponseSerializer {
    public static void putOptionalPopupRegisterRequestResponse(ISerializer iSerializer, PopupRegisterRequestResponse popupRegisterRequestResponse) {
        boolean bl = popupRegisterRequestResponse == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = popupRegisterRequestResponse.getTid();
            iSerializer.putInt32(n);
            int n2 = popupRegisterRequestResponse.getPopupState();
            iSerializer.putInt32(n2);
            int n3 = popupRegisterRequestResponse.getPopupID();
            iSerializer.putInt32(n3);
            int n4 = popupRegisterRequestResponse.getScreenFormat();
            iSerializer.putInt32(n4);
            int n5 = popupRegisterRequestResponse.getFocus();
            iSerializer.putInt32(n5);
            MenuContext menuContext = popupRegisterRequestResponse.getMenuContext();
            MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContext);
            int n6 = popupRegisterRequestResponse.getPopupContext();
            iSerializer.putInt32(n6);
            int n7 = popupRegisterRequestResponse.getPopupType();
            iSerializer.putInt32(n7);
            int n8 = popupRegisterRequestResponse.getPopupPriority();
            iSerializer.putInt32(n8);
            PopupStatusFlags popupStatusFlags = popupRegisterRequestResponse.getPopupStatusFlags();
            PopupStatusFlagsSerializer.putOptionalPopupStatusFlags(iSerializer, popupStatusFlags);
        }
    }

    public static void putOptionalPopupRegisterRequestResponseVarArray(ISerializer iSerializer, PopupRegisterRequestResponse[] popupRegisterRequestResponseArray) {
        boolean bl = popupRegisterRequestResponseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(popupRegisterRequestResponseArray.length);
            for (int i2 = 0; i2 < popupRegisterRequestResponseArray.length; ++i2) {
                PopupRegisterRequestResponseSerializer.putOptionalPopupRegisterRequestResponse(iSerializer, popupRegisterRequestResponseArray[i2]);
            }
        }
    }

    public static PopupRegisterRequestResponse getOptionalPopupRegisterRequestResponse(IDeserializer iDeserializer) {
        PopupRegisterRequestResponse popupRegisterRequestResponse = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            PopupStatusFlags popupStatusFlags;
            int n;
            int n2;
            int n3;
            MenuContext menuContext;
            int n4;
            int n5;
            int n6;
            int n7;
            int n8;
            popupRegisterRequestResponse = new PopupRegisterRequestResponse();
            popupRegisterRequestResponse.tid = n8 = iDeserializer.getInt32();
            popupRegisterRequestResponse.popupState = n7 = iDeserializer.getInt32();
            popupRegisterRequestResponse.popupID = n6 = iDeserializer.getInt32();
            popupRegisterRequestResponse.screenFormat = n5 = iDeserializer.getInt32();
            popupRegisterRequestResponse.focus = n4 = iDeserializer.getInt32();
            popupRegisterRequestResponse.menuContext = menuContext = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
            popupRegisterRequestResponse.popupContext = n3 = iDeserializer.getInt32();
            popupRegisterRequestResponse.popupType = n2 = iDeserializer.getInt32();
            popupRegisterRequestResponse.popupPriority = n = iDeserializer.getInt32();
            popupRegisterRequestResponse.popupStatusFlags = popupStatusFlags = PopupStatusFlagsSerializer.getOptionalPopupStatusFlags(iDeserializer);
        }
        return popupRegisterRequestResponse;
    }

    public static PopupRegisterRequestResponse[] getOptionalPopupRegisterRequestResponseVarArray(IDeserializer iDeserializer) {
        PopupRegisterRequestResponse[] popupRegisterRequestResponseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            popupRegisterRequestResponseArray = new PopupRegisterRequestResponse[n];
            for (int i2 = 0; i2 < n; ++i2) {
                popupRegisterRequestResponseArray[i2] = PopupRegisterRequestResponseSerializer.getOptionalPopupRegisterRequestResponse(iDeserializer);
            }
        }
        return popupRegisterRequestResponseArray;
    }
}

