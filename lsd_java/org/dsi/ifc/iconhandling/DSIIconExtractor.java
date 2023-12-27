/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.iconhandling;

import org.dsi.ifc.base.DSIBase;

public interface DSIIconExtractor
extends DSIBase {
    public static final String VERSION;
    public static final int ICONSIZE_SMALL;
    public static final int ICONSIZE_MEDIUM;
    public static final int ICONSIZE_LARGE;
    public static final int ICONSIZE_VERY_SMALL;
    public static final int ICONSIZE_VERY_LARGE;
    public static final int ICONRESULT_OK;
    public static final int ICONRESULT_ERROR;
    public static final int TMCICONSUBINDEX_NORMAL;
    public static final int TMCICONSUBINDEX_GRAYED_OUT;
    public static final int TMCICONSUBINDEX_BYPASSED;
    public static final int TMCICONSUBINDEX_BYPASSED_DISAPPEARS;
    public static final int TRAFFICREGULATIONICONSUBINDEX_NORMAL;
    public static final int TRAFFICREGULATIONICONSUBINDEX_GRAYED_OUT;
    public static final int TRAFFICREGULATIONICONSUBINDEX_CROSSED_OUT;
    public static final int BRANDICONSTYLE_ACTUALBRANDICON;
    public static final int BRANDICONSTYLE_GENERIC;
    public static final int RT_RESOURCEIDFORTMCEVENTICON;
    public static final int RT_RESOURCEIDFORPOIICON;
    public static final int RT_RENDERINGINFORMATIONFORROADICON;
    public static final int RT_RESOURCEIDFORTARGETICON;
    public static final int RT_RESOURCEIDFORROADCLASSICON;
    public static final int RT_RESOURCEIDFORTRAFFICREGULATIONICON;
    public static final int RT_RENDERINGINFORMATIONFOREXITICON;
    public static final int RT_RESOURCEIDFORADDITIONALICON;
    public static final int RT_RESOURCEIDFORCOUNTRYICON;
    public static final int RT_RESOURCEIDFORTRAFFICREGULATIONICONWITHSUBINDEX;
    public static final int RT_RENDERINGINFORMATIONFOREXITICONWITHVARIANT;
    public static final int RT_SETBRANDICONSTYLE;
    public static final int RT_RESOURCEIDFORADDITIONALTURNLISTICON;
    public static final int RT_RESOURCEIDFORTRAFFICSOURCEICON;
    public static final int RT_RESOURCEIDFORAREAWARNINGICON;
    public static final int RT_RESOURCEIDFORCOMPOSEDPOIICON;
    public static final int RT_RESOURCEIDFORPOIICONFROMRAWDATA;
    public static final int RP_RESOURCEIDFORTMCEVENTICON;
    public static final int RP_RESOURCEIDFORPOIICON;
    public static final int RP_RENDERINGINFORMATIONFORROADICON;
    public static final int RP_RESOURCEIDFORTARGETICON;
    public static final int RP_RESOURCEIDFORROADCLASSICON;
    public static final int RP_RESOURCEIDFORTRAFFICREGULATIONICON;
    public static final int RP_RENDERINGINFORMATIONFOREXITICON;
    public static final int RP_ICONRESULT;
    public static final int RP_RESOURCEIDFORADDITIONALICON;
    public static final int RP_RESOURCEIDFORCOUNTRYICON;
    public static final int RP_RESOURCEIDFORTRAFFICREGULATIONICONWITHSUBINDEX;
    public static final int RP_RENDERINGINFORMATIONFOREXITICONWITHVARIANT;
    public static final int RP_SETBRANDICONSTYLERESULT;
    public static final int RP_RESOURCEIDFORTRAFFICSOURCEICONRESULT;
    public static final int RP_RESOURCEIDFORAREAWARNINGICONRESULT;
    public static final int RP_RESOURCEIDFORADDITIONALTURNLISTICONRESULT;
    public static final int RP_RESOURCEIDFORCOMPOSEDPOIICONRESULT;
    public static final int RP_RESOURCEIDFORPOIICONFROMRAWDATARESULT;

    default public void resourceIdForTMCEventIcon(int n, int n2, int n3) {
    }

    default public void resourceIdForPOIIcon(int n, int n2, int n3) {
    }

    default public void renderingInformationForRoadIcon(int n, int n2, int n3) {
    }

    default public void resourceIdForTargetIcon(int n, int n2) {
    }

    default public void resourceIdForRoadClassIcon(int n, int n2, int n3) {
    }

    default public void resourceIdForTrafficRegulationIcon(int n, int n2, int n3) {
    }

    default public void renderingInformationForExitIcon(int n, int n2, int n3) {
    }

    default public void resourceIdForAdditionalIcon(int n, int n2, int n3) {
    }

    default public void resourceIdForCountryIcon(int n, int n2) {
    }

    default public void resourceIdForTrafficRegulationIconWithSubindex(int n, int n2, int n3, int n4) {
    }

    default public void renderingInformationForExitIconWithVariant(int n, int n2, int n3, int n4) {
    }

    default public void setBrandIconStyle(int[] nArray, int n) {
    }

    default public void resourceIdForAdditionalTurnListIcon(int n, int n2, int n3, int n4) {
    }

    default public void resourceIdForTrafficSourceIcon(int n, int n2) {
    }

    default public void resourceIdForAreaWarningIcon(int n, int n2) {
    }

    default public void resourceIdForComposedPOIIcon(int n, int n2, int n3, int[] nArray) {
    }

    default public void resourceIdForPOIIconFromRawData(int n, int n2, int n3) {
    }
}

