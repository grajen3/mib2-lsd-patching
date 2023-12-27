/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.map;

import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerGoogleCtrlReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

    default public void updateAvailableLayers(LayerProperty[] layerPropertyArray, int n) {
    }

    default public void updateVisibleLayers(int[] nArray, int n) {
    }

    default public void updateAvailableLanguages(String[] stringArray, int n) {
    }

    default public void updateCurrentLanguage(String string, int n) {
    }

    default public void updateGoogleDataStatus(int n, int n2) {
    }

    default public void updateCopyrightPosition(Rect rect, int n, int n2, int n3) {
    }

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

