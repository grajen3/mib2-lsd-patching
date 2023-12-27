/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.iconhandling;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.iconhandling.TextRenderingInfo;

public interface DSIIconExtractorReply {
    public static final String IPL_COMM_UUID;
    public static final String IPL_COMM_INTERFACE_KEY;
    public static final String IPL_COMM_INTERFACE_VERSION;
    public static final String IPL_COMM_MODULE_VERSION;

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

    default public void asyncException(int n, String string, int n2) {
    }

    default public void yyIndication(String string, String string2) {
    }
}

