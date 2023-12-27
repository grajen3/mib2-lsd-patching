/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek.traffic;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.seek.DsiSeekProxy;
import de.vw.mib.asl.internal.radio.sdars.seek.traffic.SatTrafficWxTarget;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.GenericEventException;
import org.dsi.ifc.sdars.SeekAlert;
import org.dsi.ifc.sdars.TrafficWxEntry;

public final class TrafficApi {
    private static SatTrafficWxTarget mTarget = null;
    public static int jump;
    public static boolean jumpCancelled;
    public static boolean isJumped;
    private static boolean isTMSet;

    public static void start(SatDb satDb, DsiSeekProxy dsiSeekProxy, AbstractTarget abstractTarget) {
        mTarget = new SatTrafficWxTarget(satDb, dsiSeekProxy, abstractTarget);
    }

    public boolean notifyStartSeekAlert(SeekAlert seekAlert) {
        if (mTarget != null) {
            return mTarget.notifyStartSeekAlert(seekAlert);
        }
        return false;
    }

    public boolean notifyStopSeekAlert(SeekAlert seekAlert) {
        if (mTarget != null) {
            return mTarget.notifyStopSeekAlert(seekAlert);
        }
        return false;
    }

    public void updateTrafficWeatherList(TrafficWxEntry[] trafficWxEntryArray) {
        if (mTarget != null) {
            mTarget.updateTrafficWeatherList(trafficWxEntryArray);
        }
    }

    public void resetTrafficAlertSettings() {
        mTarget.resetTrafficSettings();
    }

    public void restoreLastActiveTrafficEntry() {
        if (null != mTarget) {
            mTarget.restoreLastActiveTrafficEntry();
        }
    }

    public void storeCurrentTrafficEntry() {
        if (null != mTarget) {
            mTarget.storeCurrentTrafficEntry();
        }
    }

    public static boolean isTMSet() {
        return isTMSet;
    }

    public static void setTMSet(boolean bl) {
        try {
            if (bl) {
                mTarget.triggerMe(-1534721792);
            }
        }
        catch (GenericEventException genericEventException) {
            ServiceManager.errorHandler.handleError(genericEventException);
        }
        isTMSet = bl;
    }

    static {
        jumpCancelled = true;
        isTMSet = false;
    }
}

