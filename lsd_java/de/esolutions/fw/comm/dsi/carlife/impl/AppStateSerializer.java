/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carlife.impl;

import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.ISerializer;
import org.dsi.ifc.carlife.AppState;

public class AppStateSerializer {
    public static void putOptionalAppState(ISerializer iSerializer, AppState appState) {
        boolean bl = appState == null;
        iSerializer.putBool(bl);
        if (!bl) {
            int n = appState.getAppStateID();
            iSerializer.putInt32(n);
            int n2 = appState.getOwner();
            iSerializer.putInt32(n2);
        }
    }

    public static void putOptionalAppStateVarArray(ISerializer iSerializer, AppState[] appStateArray) {
        boolean bl = appStateArray == null;
        iSerializer.putBool(bl);
        if (!bl) {
            iSerializer.putInt32(appStateArray.length);
            for (int i2 = 0; i2 < appStateArray.length; ++i2) {
                AppStateSerializer.putOptionalAppState(iSerializer, appStateArray[i2]);
            }
        }
    }

    public static AppState getOptionalAppState(IDeserializer iDeserializer) {
        AppState appState = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n;
            int n2;
            appState = new AppState();
            appState.appStateID = n2 = iDeserializer.getInt32();
            appState.owner = n = iDeserializer.getInt32();
        }
        return appState;
    }

    public static AppState[] getOptionalAppStateVarArray(IDeserializer iDeserializer) {
        AppState[] appStateArray = null;
        boolean bl = iDeserializer.getBool();
        if (!bl) {
            int n = iDeserializer.getInt32();
            appStateArray = new AppState[n];
            for (int i2 = 0; i2 < n; ++i2) {
                appStateArray[i2] = AppStateSerializer.getOptionalAppState(iDeserializer);
            }
        }
        return appStateArray;
    }
}

