/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.radio.DSIDABTuner;

public class DsiDABTunerAdapter
extends AbstractPersonalizedAppDsiAdapter {
    private DSIDABTuner dsiDABTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTuner;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTunerListener;

    DsiDABTunerAdapter(GenericEvents genericEvents, DSIProxy dSIProxy) {
        super(genericEvents, dSIProxy);
    }

    @Override
    public void profileChange(int n) {
        this.dsiDABTuner.profileChange(n);
    }

    @Override
    public void profileCopy(int n, int n2) {
        this.dsiDABTuner.profileCopy(n, n2);
    }

    @Override
    public void profileReset(int n) {
        this.dsiDABTuner.profileReset(n);
    }

    @Override
    public void profileResetAll() {
        this.dsiDABTuner.profileResetAll();
    }

    public void dsiDABTunerUpdateProfileState(int n, int n2, int n3) {
        this.getListener().updateProfileState(n, n2, n3);
    }

    public void dsiDABTunerProfileChanged(int n, int n2) {
        this.getListener().profileChanged(n, n2);
    }

    public void dsiDABTunerProfileCopied(int n, int n2, int n3) {
        this.getListener().profileCopied(n, n2, n3);
    }

    public void dsiDABTunerProfileReset(int n, int n2) {
        this.getListener().profileReset(n, n2);
    }

    public void dsiDABTunerProfileResetAll(int n) {
        this.getListener().profileResetAll(n);
    }

    @Override
    protected void connectToDsi(DSIBase dSIBase) {
        this.dsiDABTuner = (DSIDABTuner)dSIBase;
    }

    @Override
    public Class getDsiClass() {
        return class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = DsiDABTunerAdapter.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner;
    }

    @Override
    protected Class getDsiListenerClass() {
        return class$org$dsi$ifc$radio$DSIDABTunerListener == null ? (class$org$dsi$ifc$radio$DSIDABTunerListener = DsiDABTunerAdapter.class$("org.dsi.ifc.radio.DSIDABTunerListener")) : class$org$dsi$ifc$radio$DSIDABTunerListener;
    }

    @Override
    protected int getProfileStateAttributeValue() {
        return 35;
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

