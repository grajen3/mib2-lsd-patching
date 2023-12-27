/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map;

import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.internal.speechnavigation.navi.api.adapter.map.listener.MapServiceListener;
import org.dsi.ifc.map.Rect;

public interface MapService {
    default public void showAddressOnMap(MapServiceListener mapServiceListener, INavigationLocation iNavigationLocation, Rect rect) {
    }

    default public void initMapSize(Rect rect) {
    }

    default public void release() {
    }
}

