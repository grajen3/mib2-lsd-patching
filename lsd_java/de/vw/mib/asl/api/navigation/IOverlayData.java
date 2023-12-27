/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.navigation;

import org.dsi.ifc.global.ResourceLocator;

public interface IOverlayData {
    default public String getName() {
    }

    default public String getExitNumber() {
    }

    default public boolean getExitNumberVisibility() {
    }

    default public int getDistanceToManeuver() {
    }

    default public ResourceLocator getColorIndicatorIcon() {
    }

    default public int[] getLaneDirections() {
    }

    default public int[] getLaneInfos() {
    }

    default public int[] getLaneMarkingsLeft() {
    }

    default public int[] getLaneMarkingsRight() {
    }

    default public int getLaneNumber() {
    }

    default public boolean getLaneGuidanceAvailable() {
    }

    default public ResourceLocator getHeadlineIcon() {
    }

    default public boolean getHeadlineIconVisibility() {
    }

    default public String getSignPostInfo() {
    }
}

