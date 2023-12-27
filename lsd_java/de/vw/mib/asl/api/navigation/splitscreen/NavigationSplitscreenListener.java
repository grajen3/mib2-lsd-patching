/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation.splitscreen;

import de.vw.mib.asl.api.navigation.IManeuverViewElement;
import de.vw.mib.asl.api.navigation.INavigationLocation;
import de.vw.mib.asl.api.navigation.INavigationPosPosition;
import de.vw.mib.asl.api.navigation.IOverlayData;

public interface NavigationSplitscreenListener {
    default public void updateLocationInfo(INavigationLocation iNavigationLocation) {
    }

    default public void updateCompassStreet(String string) {
    }

    default public void updateCompassDegree(int n) {
    }

    default public void updatePositionInfo(INavigationPosPosition iNavigationPosPosition) {
    }

    default public void updateRMLInformation(IManeuverViewElement[] iManeuverViewElementArray) {
    }

    default public void updateOverlayCurrentContent(int n) {
    }

    default public void updateOverlayCount(int n) {
    }

    default public void updateOverlayIndex(int n) {
    }

    default public void updateOverlayData(IOverlayData iOverlayData) {
    }
}

