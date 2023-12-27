/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.state;

import org.dsi.ifc.exboxm.MobileDeviceLinkStatus;

public class MobileDeviceLinkStatusHelper {
    public static boolean areEqual(MobileDeviceLinkStatus mobileDeviceLinkStatus, MobileDeviceLinkStatus mobileDeviceLinkStatus2) {
        if (mobileDeviceLinkStatus == mobileDeviceLinkStatus2) {
            return true;
        }
        if (mobileDeviceLinkStatus == null || mobileDeviceLinkStatus2 == null) {
            return false;
        }
        boolean bl = mobileDeviceLinkStatus.getLinkType() == mobileDeviceLinkStatus2.getLinkType();
        boolean bl2 = mobileDeviceLinkStatus.isNavigationActive() == mobileDeviceLinkStatus2.isNavigationActive();
        boolean bl3 = mobileDeviceLinkStatus.isTelephoneActive() == mobileDeviceLinkStatus2.isTelephoneActive();
        return bl && bl2 && bl3;
    }
}

