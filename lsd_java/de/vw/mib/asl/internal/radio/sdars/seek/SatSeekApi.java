/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek;

import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.asl.internal.radio.sdars.seek.SatSeekModel;
import java.util.Vector;
import org.dsi.ifc.sdars.TrafficWxEntry;

public final class SatSeekApi {
    private final SatDb mDb;
    private SatSeekModel mModel;
    private static boolean isTrafficSelected;
    private static int storedSeekSid;
    private static int storedSeekType;
    public static int retrySeekCountResetTimer;
    public static int retryCountSeek;
    private static boolean isSeekRetryTimerRunning;
    private static int newTrafficSeekID;
    private static int retryCountTraffic;
    private static boolean isTrafficRetryTimerOn;
    private static boolean isSeekDeletePressed;
    private static boolean isTrafficRemoved;
    private static boolean isTrafficSeekFailed;
    private static TrafficWxEntry lastActivatedTrafficEntry;
    private static boolean isSeekStarted;
    private static boolean isTrafficMarketRemovedSuccessfully;
    private static boolean isRestoreTrafficInitiated;
    private static boolean isTrafficMarketClearedCompletely;

    public SatSeekApi(SatDb satDb) {
        this.mDb = satDb;
    }

    public void startModule() {
        if (this.mModel == null) {
            this.mModel = new SatSeekModel(this.mDb);
        }
    }

    public void deleteAllSeekEntries() {
        this.mModel.getSeekEntries().deleteAllSeekEntries();
    }

    public static boolean isTrafficSelected() {
        return isTrafficSelected;
    }

    public static void setTrafficSelected(boolean bl) {
        isTrafficSelected = bl;
    }

    public static int getNewTrafficSeekID() {
        return newTrafficSeekID;
    }

    public static void setNewTrafficSeekID(int n) {
        newTrafficSeekID = n;
    }

    public static int getRetryCountTraffic() {
        return retryCountTraffic;
    }

    public static void setRetryCountTraffic(int n) {
        retryCountTraffic = n;
    }

    public static boolean getIsTrafficRetryTimerRunning() {
        return isTrafficRetryTimerOn;
    }

    public static void setTrafficRetryTimerRunning(boolean bl) {
        isTrafficRetryTimerOn = bl;
    }

    public static int getStoredSeekSid() {
        return storedSeekSid;
    }

    public static void setStoredSeekSid(int n) {
        storedSeekSid = n;
    }

    public static int getStoredSeekType() {
        return storedSeekType;
    }

    public static void setStoredSeekType(int n) {
        storedSeekType = n;
    }

    public static int getRetrySeekCount() {
        return retryCountSeek;
    }

    public static void setRetrySeekCount(int n) {
        retryCountSeek = n;
    }

    public static boolean isSeekRetryTimerRunning() {
        return isSeekRetryTimerRunning;
    }

    public static void setSeekRetryTimerRunning(boolean bl) {
        isSeekRetryTimerRunning = bl;
    }

    public static boolean getIsSeekDeletePressed() {
        return isSeekDeletePressed;
    }

    public static void setSeekDeletePressed(boolean bl) {
        isSeekDeletePressed = bl;
    }

    public static boolean getIsTrafficSeekRemoved() {
        return isTrafficRemoved;
    }

    public static void setTrafficRemoved(boolean bl) {
        isTrafficRemoved = bl;
    }

    public static boolean getIsTrafficSeekFailed() {
        return isTrafficSeekFailed;
    }

    public static void setTrafficSeekFailed(boolean bl) {
        isTrafficSeekFailed = bl;
    }

    public static TrafficWxEntry getLastActivatedTrafficEntry() {
        return lastActivatedTrafficEntry;
    }

    public static void setLastActivatedTrafficEntry(TrafficWxEntry trafficWxEntry) {
        lastActivatedTrafficEntry = trafficWxEntry;
    }

    public static boolean isSeekStarted() {
        return isSeekStarted;
    }

    public static void setSeekStarted(boolean bl) {
        isSeekStarted = bl;
    }

    public static boolean isTrafficMarketRemovedSuccessfully() {
        return isTrafficMarketRemovedSuccessfully;
    }

    public static void setTrafficMarketRemovedSuccessfully(boolean bl) {
        isTrafficMarketRemovedSuccessfully = bl;
    }

    public static boolean isRestoreTrafficInitiated() {
        return isRestoreTrafficInitiated;
    }

    public static void setRestoreTrafficInitiated(boolean bl) {
        isRestoreTrafficInitiated = bl;
    }

    public static boolean isTrafficMarketClearedCompletely() {
        return isTrafficMarketClearedCompletely;
    }

    public static void setTrafficMarketClearedCompletely(boolean bl) {
        isTrafficMarketClearedCompletely = bl;
    }

    public Vector getSeekAlerts() {
        return this.mModel.getSeekAlerts();
    }

    public void refreshAlertList() {
        this.mModel.refreshAlertList();
    }

    static {
        storedSeekSid = -1;
        storedSeekType = -1;
        retrySeekCountResetTimer = 5000;
        retryCountSeek = 0;
        isSeekRetryTimerRunning = false;
        newTrafficSeekID = -1;
        retryCountTraffic = 0;
        isTrafficRetryTimerOn = false;
        isSeekDeletePressed = false;
        isTrafficRemoved = false;
        isTrafficSeekFailed = false;
        isSeekStarted = false;
        isTrafficMarketRemovedSuccessfully = false;
        isRestoreTrafficInitiated = false;
        isTrafficMarketClearedCompletely = false;
    }
}

