/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.helper;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.sdars.StationInfo;

public final class SatUtil {
    private SatUtil() {
    }

    public static boolean equals(String string, String string2) {
        if (string == null) {
            if (string2 != null) {
                return false;
            }
        } else {
            if (string2 == null) {
                return false;
            }
            if (string.compareTo(string2) != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(StationInfo stationInfo, StationInfo stationInfo2) {
        if (stationInfo == null) {
            if (stationInfo2 != null) {
                return false;
            }
        } else {
            if (stationInfo2 == null) {
                return false;
            }
            if (stationInfo.stationNumber != stationInfo2.stationNumber || stationInfo.categoryNumber != stationInfo2.categoryNumber || stationInfo.sID != stationInfo2.sID || stationInfo.subscription != stationInfo2.subscription || !SatUtil.equals(stationInfo.fullLabel, stationInfo2.fullLabel) || !SatUtil.equals(stationInfo.shortLabel, stationInfo2.shortLabel)) {
                return false;
            }
        }
        return true;
    }

    public static boolean equals(ResourceLocator resourceLocator, ResourceLocator resourceLocator2) {
        if (resourceLocator == null) {
            if (resourceLocator2 != null) {
                return false;
            }
        } else {
            String string;
            String string2;
            if (resourceLocator2 == null) {
                return false;
            }
            boolean bl = resourceLocator.isIntResource();
            if (bl != resourceLocator2.isIntResource()) {
                return false;
            }
            if (bl ? resourceLocator.getId() != resourceLocator2.getId() : !SatUtil.equals(string2 = resourceLocator.getUrl(), string = resourceLocator2.getUrl())) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValid(ResourceLocator resourceLocator) {
        if (resourceLocator != null) {
            if (resourceLocator.isIntResource()) {
                return resourceLocator.id != -1 && resourceLocator.id != 0;
            }
            return resourceLocator.url != null && resourceLocator.url.length() > 0;
        }
        return false;
    }

    public static String getTrimmed(String string) {
        String string2;
        if (string != null && (string2 = string.trim()).length() > 0) {
            return string2;
        }
        return null;
    }
}

