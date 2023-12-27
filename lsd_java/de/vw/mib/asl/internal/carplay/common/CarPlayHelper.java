/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.carplay.common;

import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.Resource;

public final class CarPlayHelper {
    public static boolean containsElement(Object[] objectArray, Object object) {
        if (objectArray == null || objectArray.length == 0 || object == null) {
            return false;
        }
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            if (!(objectArray[i2] != null && object instanceof Resource && objectArray[i2] instanceof Resource ? CarPlayHelper.compareResource((Resource)object, (Resource)objectArray[i2]) : objectArray[i2] != null && object instanceof AppState && objectArray[i2] instanceof AppState && CarPlayHelper.compareAppState((AppState)object, (AppState)objectArray[i2]))) continue;
            return true;
        }
        return false;
    }

    private static boolean compareResource(Resource resource, Resource resource2) {
        return resource.getResourceID() == resource2.getResourceID() && resource.getOwner() == resource2.getOwner();
    }

    private static boolean compareAppState(AppState appState, AppState appState2) {
        if (appState.getAppStateID() == appState2.getAppStateID() && appState.getOwner() == appState2.getOwner()) {
            if (appState.getSpeechMode() == appState2.getSpeechMode()) {
                return true;
            }
            return appState.getSpeechMode() == 0 && appState2.getSpeechMode() == 1 || appState.getSpeechMode() == 1 && appState2.getSpeechMode() == 0;
        }
        return false;
    }
}

