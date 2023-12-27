/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.MenuContextSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.MenuContext;
import org.dsi.ifc.kombisync2.PopupActionRequestResponse;

public class PopupActionRequestResponseSerializer {
    public static void putOptionalPopupActionRequestResponse(ISerializer iSerializer, PopupActionRequestResponse popupActionRequestResponse) {
        boolean bl = popupActionRequestResponse == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = popupActionRequestResponse.getTid();
            iSerializer.putInt32(n);
            int n2 = popupActionRequestResponse.getPopupState();
            iSerializer.putInt32(n2);
            int n3 = popupActionRequestResponse.getPopupID();
            iSerializer.putInt32(n3);
            int n4 = popupActionRequestResponse.getScreenFormat();
            iSerializer.putInt32(n4);
            int n5 = popupActionRequestResponse.getFocus();
            iSerializer.putInt32(n5);
            MenuContext menuContext = popupActionRequestResponse.getMenuContext();
            MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContext);
        }
    }

    public static void putOptionalPopupActionRequestResponseVarArray(ISerializer iSerializer, PopupActionRequestResponse[] popupActionRequestResponseArray) {
        boolean bl = popupActionRequestResponseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(popupActionRequestResponseArray.length);
            for (int i2 = 0; i2 < popupActionRequestResponseArray.length; ++i2) {
                PopupActionRequestResponseSerializer.putOptionalPopupActionRequestResponse(iSerializer, popupActionRequestResponseArray[i2]);
            }
        }
    }

    public static PopupActionRequestResponse getOptionalPopupActionRequestResponse(IDeserializer iDeserializer) {
        PopupActionRequestResponse popupActionRequestResponse = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            MenuContext menuContext;
            int n;
            int n2;
            int n3;
            int n4;
            int n5;
            popupActionRequestResponse = new PopupActionRequestResponse();
            popupActionRequestResponse.tid = n5 = iDeserializer.getInt32();
            popupActionRequestResponse.popupState = n4 = iDeserializer.getInt32();
            popupActionRequestResponse.popupID = n3 = iDeserializer.getInt32();
            popupActionRequestResponse.screenFormat = n2 = iDeserializer.getInt32();
            popupActionRequestResponse.focus = n = iDeserializer.getInt32();
            popupActionRequestResponse.menuContext = menuContext = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
        }
        return popupActionRequestResponse;
    }

    public static PopupActionRequestResponse[] getOptionalPopupActionRequestResponseVarArray(IDeserializer iDeserializer) {
        PopupActionRequestResponse[] popupActionRequestResponseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            popupActionRequestResponseArray = new PopupActionRequestResponse[n];
            for (int i2 = 0; i2 < n; ++i2) {
                popupActionRequestResponseArray[i2] = PopupActionRequestResponseSerializer.getOptionalPopupActionRequestResponse(iDeserializer);
            }
        }
        return popupActionRequestResponseArray;
    }
}

