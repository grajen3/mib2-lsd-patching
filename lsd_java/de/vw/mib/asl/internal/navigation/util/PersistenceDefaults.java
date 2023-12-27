/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.navigation.util;

import de.vw.mib.asl.api.navigation.util.IPersistenceDefaults;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public class PersistenceDefaults
implements IPersistenceDefaults {
    public static boolean getRouteOptionsHmiAlternativeRouteCalculationDefault() {
        return IPersistenceDefaults.ROUTEOPTIONS_HMI_ALTERNATIVE_ROUTE_CALCULATION_DEFAULT;
    }

    public static int getRouteOptionHmiRouteCalculationTypeDefault() {
        return 0;
    }

    public static int getRouteOptionsHmiDynamicRouteCalculationDefault() {
        return 0;
    }

    public static boolean getLaneGuidanceDefault() {
        return true;
    }

    public static boolean getMainMapShowIconsBrandsDefault() {
        return true;
    }

    public static boolean getMainMapShowIconsFavoritesDefault() {
        return true;
    }

    public static boolean getPoiFuelOptionsFuelWwarningDefault() {
        return true;
    }

    public static boolean getBorderChangePopupActiveDefault() {
        return true;
    }

    public static int getHmiAudioAnnouncementTypeDefault() {
        return 0;
    }

    public static int getHmiTrafficSignModeDefault() {
        return 1;
    }

    public static int getHmiVoiceAnnouncementsDuringPhoneSetDefault() {
        return 1;
    }

    public static int getHmiGuidanceTimeFormatDefault() {
        return IPersistenceDefaults.HMI_GUIDANCE_TIME_FORMAT_DEFAULT;
    }

    public static boolean getStatusLineInfoDefault() {
        return false;
    }

    public static boolean getSoundNavAnnouncementStateDefault() {
        return true;
    }

    public static boolean getHOVUsageDefault() {
        return false;
    }

    public static boolean getMainMapShowPoiIconsDefault() {
        return true;
    }

    public static boolean getNavLocationValidDefault() {
        return false;
    }

    public static int getMainMapOrientationDefault() {
        return 0;
    }

    public static int getMainMapTypeLastDefault() {
        return 0;
    }

    public static boolean getMainMapShowSpeedAndFlowDefault() {
        return true;
    }

    public static boolean getTrafficShowFreeFlowDefault() {
        return true;
    }

    public static boolean getTrafficShowCongestionDefault() {
        return true;
    }

    public static boolean getTrafficShowIncidentsDefault() {
        return true;
    }

    public static boolean getMainMapIsKdkActiveDefault() {
        return true;
    }

    public static int getMapInMapModeDefault() {
        return 1;
    }

    public static int getMainMapAutoZoomModeDefault() {
        return 1;
    }

    public static boolean getSpeedCameraWarningDefault() {
        return true;
    }

    public static boolean getMainMapVisibleInKombiDefault() {
        return false;
    }

    public static int getMapTypeKombiFpkDefault() {
        return 0;
    }

    public static int getMapOrientationKombiFpkDefault() {
        return 2;
    }

    public static int getMapContentKombiFpkDefault() {
        return 0;
    }

    public static boolean getKdkActiveInKombiFpkDefault() {
        return false;
    }

    public static int getAutoZoomModeKombiFpkDefault() {
        return 1;
    }

    public static boolean getPrivacyModeDefault() {
        return false;
    }

    public static boolean getSplitScreenGuidanceVisibilityDefault() {
        return IPersistenceDefaults.HMI_SPLIT_SCREEN_GUIDANCE_VISIBILITY_DEFAULT;
    }

    public static boolean getSplitScreenNoGuidanceVisibilityDefault() {
        return IPersistenceDefaults.HMI_SPLIT_SCREEN_NO_GUIDANCE_VISIBILITY_DEFAULT;
    }

    public static int getSplitScreenGuidanceContentDefault() {
        return IPersistenceDefaults.HMI_SPLIT_SCREEN_GUIDANCE_CONTENT_DEFAULT;
    }

    public static int getSplitScreenNoGuidanceContentDefault() {
        return IPersistenceDefaults.HMI_SPLIT_SCREEN_NO_GUIDANCE_CONTENT_DEFAULT;
    }

    public static boolean getAudibleApproachPPOIHintStatusDefault() {
        return true;
    }

    public static int getMainMapMapModeDefault() {
        return 1;
    }

    public static int getOnlineToursAvailableDefault() {
        return 0;
    }

    public static boolean getSeasonalRestrictionsDefault() {
        return true;
    }

    public static boolean getStatisticalDataDefault() {
        return false;
    }

    public static int getDayNightMainMapModeDefault() {
        return 2;
    }

    public static boolean getMergingTrafficDefault() {
        return true;
    }

    public static boolean getReduceLaneDefault() {
        return true;
    }

    public static boolean getRailwayCrossingDefault() {
        return true;
    }

    public static int getSpeedCameraWarningTypeDefault() {
        return 1;
    }

    public static boolean getPnavEnabledDefault() {
        return true;
    }

    public static boolean getShowSldeHelpDefault() {
        return true;
    }

    public static int getLastModeDestinationInputDefault() {
        boolean bl = ServiceManager.configManagerDiag.isFeatureFlagSet(125);
        return bl ? 1 : 0;
    }

    public static long getLastTimeStampBeforeHmiOff() {
        return -1L;
    }
}

