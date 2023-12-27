/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombisync2.impl;

import de.esolutions.fw.comm.dsi.kombisync2.impl.MenuContextSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.kombisync2.DisplayRequestResponse;
import org.dsi.ifc.kombisync2.MenuContext;

public class DisplayRequestResponseSerializer {
    public static void putOptionalDisplayRequestResponse(ISerializer iSerializer, DisplayRequestResponse displayRequestResponse) {
        boolean bl = displayRequestResponse == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = displayRequestResponse.getReqRespInformation();
            iSerializer.putInt32(n);
            int n2 = displayRequestResponse.getMainContext();
            iSerializer.putInt32(n2);
            int n3 = displayRequestResponse.getScreenFormat();
            iSerializer.putInt32(n3);
            int n4 = displayRequestResponse.getFocus();
            iSerializer.putInt32(n4);
            MenuContext menuContext = displayRequestResponse.getMenuContext();
            MenuContextSerializer.putOptionalMenuContext(iSerializer, menuContext);
            int n5 = displayRequestResponse.getStyle();
            iSerializer.putInt32(n5);
            int n6 = displayRequestResponse.getRequestTID();
            iSerializer.putInt32(n6);
            int n7 = displayRequestResponse.getResponseTID();
            iSerializer.putInt32(n7);
        }
    }

    public static void putOptionalDisplayRequestResponseVarArray(ISerializer iSerializer, DisplayRequestResponse[] displayRequestResponseArray) {
        boolean bl = displayRequestResponseArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(displayRequestResponseArray.length);
            for (int i2 = 0; i2 < displayRequestResponseArray.length; ++i2) {
                DisplayRequestResponseSerializer.putOptionalDisplayRequestResponse(iSerializer, displayRequestResponseArray[i2]);
            }
        }
    }

    public static DisplayRequestResponse getOptionalDisplayRequestResponse(IDeserializer iDeserializer) {
        DisplayRequestResponse displayRequestResponse = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            int n3;
            MenuContext menuContext;
            int n4;
            int n5;
            int n6;
            int n7;
            displayRequestResponse = new DisplayRequestResponse();
            displayRequestResponse.reqRespInformation = n7 = iDeserializer.getInt32();
            displayRequestResponse.mainContext = n6 = iDeserializer.getInt32();
            displayRequestResponse.screenFormat = n5 = iDeserializer.getInt32();
            displayRequestResponse.focus = n4 = iDeserializer.getInt32();
            displayRequestResponse.menuContext = menuContext = MenuContextSerializer.getOptionalMenuContext(iDeserializer);
            displayRequestResponse.style = n3 = iDeserializer.getInt32();
            displayRequestResponse.requestTID = n2 = iDeserializer.getInt32();
            displayRequestResponse.responseTID = n = iDeserializer.getInt32();
        }
        return displayRequestResponse;
    }

    public static DisplayRequestResponse[] getOptionalDisplayRequestResponseVarArray(IDeserializer iDeserializer) {
        DisplayRequestResponse[] displayRequestResponseArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            displayRequestResponseArray = new DisplayRequestResponse[n];
            for (int i2 = 0; i2 < n; ++i2) {
                displayRequestResponseArray[i2] = DisplayRequestResponseSerializer.getOptionalDisplayRequestResponse(iDeserializer);
            }
        }
        return displayRequestResponseArray;
    }
}

