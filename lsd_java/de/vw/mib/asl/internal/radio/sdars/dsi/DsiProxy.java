/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.dsi;

import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.framework.internal.framework.util.BitField;
import de.vw.mib.asl.internal.radio.sdars.dsi.SatTunerListener;
import de.vw.mib.asl.internal.radio.sdars.helper.SatConfig;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sdars.DSISDARSTuner;
import org.dsi.ifc.sdars.DSISDARSTunerListener;

final class DsiProxy
implements DSISDARSTuner {
    public static final int UPDATE_FLAG_STATION_LIST;
    public static final int UPDATE_FLAG_CATEGORY_LIST;
    private final SatDb mDb;
    private final DSISDARSTuner mProxy;
    private final DSISDARSTunerListener mListener;
    private final boolean mUseLateRtNotification;
    private boolean mOtherNotificationsSet = false;
    private BitField mFlags = new BitField();
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSTuner;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSTunerListener;

    DsiProxy(SatDb satDb, AbstractTarget abstractTarget, int[] nArray) {
        this.mDb = satDb;
        String string = System.getProperty("de.vw.mib.asl.internal.radio.sdars.late_rt_notification");
        this.mUseLateRtNotification = string == null ? SatConfig.mDefaultUseLateRtNotification : Boolean.valueOf(string);
        this.mListener = new SatTunerListener(this, this.mDb);
        DSIServiceLocator dSIServiceLocator = SatDb.getDsiServiceLocator();
        this.mProxy = (DSISDARSTuner)dSIServiceLocator.getService(abstractTarget, class$org$dsi$ifc$sdars$DSISDARSTuner == null ? (class$org$dsi$ifc$sdars$DSISDARSTuner = DsiProxy.class$("org.dsi.ifc.sdars.DSISDARSTuner")) : class$org$dsi$ifc$sdars$DSISDARSTuner);
        dSIServiceLocator.addResponseListener(abstractTarget, class$org$dsi$ifc$sdars$DSISDARSTunerListener == null ? (class$org$dsi$ifc$sdars$DSISDARSTunerListener = DsiProxy.class$("org.dsi.ifc.sdars.DSISDARSTunerListener")) : class$org$dsi$ifc$sdars$DSISDARSTunerListener, this.mListener);
        this.setNotification(new int[]{26, 10, 12, 2, 8, 6, 13, 9, 28}, (DSIListener)this.mListener);
        if (!this.mUseLateRtNotification) {
            this.setNotification(2, (DSIListener)this.mListener);
            this.setNotification(27, (DSIListener)this.mListener);
        }
    }

    public void addOtherNotifications(int n) {
        this.mFlags.set(n, true);
        if (this.mUseLateRtNotification && !this.mOtherNotificationsSet && this.mFlags.get(2) && this.mFlags.get(1)) {
            this.mOtherNotificationsSet = true;
            this.setNotification(2, (DSIListener)this.mListener);
            this.setNotification(27, (DSIListener)this.mListener);
            this.notifyHMIReady(6);
        }
    }

    @Override
    public void reset(int n) {
        this.mProxy.reset(n);
    }

    @Override
    public void clearNotification(int[] nArray, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void clearNotification(DSIListener dSIListener) {
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.mProxy.setNotification(nArray, dSIListener);
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
        this.mProxy.setNotification(n, dSIListener);
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
    }

    @Override
    public void selectStation(int n, int n2) {
        this.mProxy.selectStation(n, n2);
    }

    @Override
    public void getTime() {
        this.mProxy.getTime();
    }

    @Override
    public void setRadioText2Config(int n, int n2) {
    }

    @Override
    public void getEPG24Hour(int n) {
    }

    @Override
    public void getEPGDescription(int n, int n2) {
    }

    public void hmiReady() {
    }

    @Override
    public void notifyHMIReady(int n) {
        this.mProxy.notifyHMIReady(n);
    }

    @Override
    public void profileChange(int n) {
    }

    @Override
    public void profileCopy(int n, int n2) {
    }

    @Override
    public void profileReset(int n) {
    }

    @Override
    public void profileResetAll() {
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

