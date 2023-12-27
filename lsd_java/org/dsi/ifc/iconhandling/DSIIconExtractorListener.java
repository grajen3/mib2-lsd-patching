/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.iconhandling;

import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public interface DSIIconExtractorListener
extends DSIListener {
    default public void iconResult(int n) {
    }

    default public void resourceIdForTMCEventIcon(ResourceLocator resourceLocator) {
    }

    default public void resourceIdForPOIIcon(ResourceLocator resourceLocator) {
    }

    default public void renderingInformationForRoadIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
    }

    default public void resourceIdForTargetIcon(ResourceLocator resourceLocator) {
    }

    default public void resourceIdForRoadClassIcon(ResourceLocator resourceLocator) {
    }

    default public void resourceIdForTrafficRegulationIcon(ResourceLocator resourceLocator) {
    }

    default public void resourceIdForAdditionalIcon(ResourceLocator resourceLocator) {
    }

    default public void renderingInformationForExitIcon(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
    }

    default public void resourceIdForCountryIcon(ResourceLocator resourceLocator) {
    }

    default public void resourceIdForTrafficRegulationIconWithSubIndex(ResourceLocator resourceLocator) {
    }

    default public void renderingInformationForExitIconWithVariant(ResourceLocator resourceLocator, TextRenderingInfo textRenderingInfo) {
    }

    default public void setBrandIconStyleResult(int n) {
    }

    default public void resourceIdForTrafficSourceIconResult(ResourceLocator resourceLocator) {
    }

    default public void resourceIdForAreaWarningIconResult(ResourceLocator resourceLocator) {
    }

    default public void resourceIdForAdditionalTurnListIconResult(ResourceLocator resourceLocator) {
    }

    default public void resourceIdForComposedPOIIconResult(ResourceLocator resourceLocator) {
    }

    default public void resourceIdForPOIIconFromRawDataResult(ResourceLocator resourceLocator) {
    }
}

