/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.radio.DSIAMFMTuner;

public class DsiAMFMTunerAdapter
extends AbstractPersonalizedAppDsiAdapter {
    private DSIAMFMTuner dsiAMFMTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIAMFMTunerListener;

    DsiAMFMTunerAdapter(GenericEvents genericEvents, DSIProxy dSIProxy) {
        super(genericEvents, dSIProxy);
    }

    @Override
    public void profileChange(int n) {
        this.dsiAMFMTuner.profileChange(n);
    }

    @Override
    public void profileCopy(int n, int n2) {
        this.dsiAMFMTuner.profileCopy(n, n2);
    }

    @Override
    public void profileReset(int n) {
        this.dsiAMFMTuner.profileReset(n);
    }

    @Override
    public void profileResetAll() {
        this.dsiAMFMTuner.profileResetAll();
    }

    public void dsiAMFMTunerUpdateProfileState(int n, int n2, int n3) {
        this.getListener().updateProfileState(n, n2, n3);
    }

    public void dsiAMFMTunerProfileChanged(int n, int n2) {
        this.getListener().profileChanged(n, n2);
    }

    public void dsiAMFMTunerProfileCopied(int n, int n2, int n3) {
        this.getListener().profileCopied(n, n2, n3);
    }

    public void dsiAMFMTunerProfileReset(int n, int n2) {
        this.getListener().profileReset(n, n2);
    }

    public void dsiAMFMTunerProfileResetAll(int n) {
        this.getListener().profileResetAll(n);
    }

    @Override
    protected void connectToDsi(DSIBase dSIBase) {
        this.dsiAMFMTuner = (DSIAMFMTuner)dSIBase;
    }

    @Override
    public Class getDsiClass() {
        return class$org$dsi$ifc$radio$DSIAMFMTuner == null ? (class$org$dsi$ifc$radio$DSIAMFMTuner = DsiAMFMTunerAdapter.class$("org.dsi.ifc.radio.DSIAMFMTuner")) : class$org$dsi$ifc$radio$DSIAMFMTuner;
    }

    @Override
    protected Class getDsiListenerClass() {
        return class$org$dsi$ifc$radio$DSIAMFMTunerListener == null ? (class$org$dsi$ifc$radio$DSIAMFMTunerListener = DsiAMFMTunerAdapter.class$("org.dsi.ifc.radio.DSIAMFMTunerListener")) : class$org$dsi$ifc$radio$DSIAMFMTunerListener;
    }

    @Override
    protected int getProfileStateAttributeValue() {
        return 21;
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

