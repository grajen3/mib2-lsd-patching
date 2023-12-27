/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.map;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.map.LayerProperty;
import org.dsi.ifc.map.Rect;

public interface DSIMapViewerGoogleCtrlListener
extends DSIListener {
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
}

