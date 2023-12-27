/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carplay.AppStateRequest;

public class AppStateRequestSerializer {
    public static void putOptionalAppStateRequest(ISerializer iSerializer, AppStateRequest appStateRequest) {
        boolean bl = appStateRequest == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = appStateRequest.getAppStateID();
            iSerializer.putInt32(n);
            boolean bl2 = appStateRequest.isState();
            iSerializer.putBool(bl2);
            int n2 = appStateRequest.getSpeechMode();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalAppStateRequestVarArray(ISerializer iSerializer, AppStateRequest[] appStateRequestArray) {
        boolean bl = appStateRequestArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(appStateRequestArray.length);
            for (int i2 = 0; i2 < appStateRequestArray.length; ++i2) {
                AppStateRequestSerializer.putOptionalAppStateRequest(iSerializer, appStateRequestArray[i2]);
            }
        }
    }

    public static AppStateRequest getOptionalAppStateRequest(IDeserializer iDeserializer) {
        AppStateRequest appStateRequest = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            boolean bl2;
            int n2;
            appStateRequest = new AppStateRequest();
            appStateRequest.appStateID = n2 = iDeserializer.getInt32();
            appStateRequest.state = bl2 = iDeserializer.getBool();
            appStateRequest.speechMode = n = iDeserializer.getInt32();
        }
        return appStateRequest;
    }

    public static AppStateRequest[] getOptionalAppStateRequestVarArray(IDeserializer iDeserializer) {
        AppStateRequest[] appStateRequestArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            appStateRequestArray = new AppStateRequest[n];
            for (int i2 = 0; i2 < n; ++i2) {
                appStateRequestArray[i2] = AppStateRequestSerializer.getOptionalAppStateRequest(iDeserializer);
            }
        }
        return appStateRequestArray;
    }
}

