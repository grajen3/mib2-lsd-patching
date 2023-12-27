/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.sdars.seek;

import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator;
import de.vw.mib.asl.internal.radio.sdars.helper.SatDb;
import de.vw.mib.genericevents.AbstractTarget;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.sdars.DSISDARSSeek;
import org.dsi.ifc.sdars.DSISDARSSeekListener;

public final class DsiSeekProxy
implements DSISDARSSeek {
    private DSISDARSSeek mProxy = null;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSSeek;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSSeekListener;

    public DsiSeekProxy(DSISDARSSeekListener dSISDARSSeekListener, AbstractTarget abstractTarget) {
        DSIServiceLocator dSIServiceLocator = SatDb.getDsiServiceLocator();
        this.mProxy = (DSISDARSSeek)dSIServiceLocator.getService(abstractTarget, class$org$dsi$ifc$sdars$DSISDARSSeek == null ? (class$org$dsi$ifc$sdars$DSISDARSSeek = DsiSeekProxy.class$("org.dsi.ifc.sdars.DSISDARSSeek")) : class$org$dsi$ifc$sdars$DSISDARSSeek);
        dSIServiceLocator.addResponseListener(abstractTarget, class$org$dsi$ifc$sdars$DSISDARSSeekListener == null ? (class$org$dsi$ifc$sdars$DSISDARSSeekListener = DsiSeekProxy.class$("org.dsi.ifc.sdars.DSISDARSSeekListener")) : class$org$dsi$ifc$sdars$DSISDARSSeekListener, dSISDARSSeekListener);
        this.setNotification(new int[]{4, 3, 2, 1, 6}, (DSIListener)dSISDARSSeekListener);
    }

    @Override
    public void setNotification(int[] nArray, DSIListener dSIListener) {
        this.mProxy.setNotification(nArray, dSIListener);
    }

    @Override
    public void setNotification(int n, DSIListener dSIListener) {
    }

    @Override
    public void setNotification(DSIListener dSIListener) {
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
    public void setSeekCommand(int n, int n2, int n3) {
        this.mProxy.setSeekCommand(n, n2, n3);
    }

    @Override
    public void manageSeek(int n, int n2) {
        this.mProxy.manageSeek(n, n2);
    }

    @Override
    public void reset(int n) {
        this.mProxy.reset(n);
    }

    @Override
    public void getLeagues() {
    }

    @Override
    public void getTeamsOfLeague(int n) {
    }

    @Override
    public void manageSeek2(int n, int n2, int n3, int n4) {
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

