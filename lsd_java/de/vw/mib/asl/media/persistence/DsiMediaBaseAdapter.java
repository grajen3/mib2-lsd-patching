/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.media.DSIMediaBase;

public class DsiMediaBaseAdapter
extends AbstractPersonalizedAppDsiAdapter {
    private DSIMediaBase dsiMediaBase;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBase;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBaseListener;

    DsiMediaBaseAdapter(GenericEvents genericEvents, DSIProxy dSIProxy) {
        super(genericEvents, dSIProxy);
    }

    @Override
    public void profileChange(int n) {
        this.dsiMediaBase.profileChange(n);
    }

    @Override
    public void profileCopy(int n, int n2) {
        this.dsiMediaBase.profileCopy(n, n2);
    }

    @Override
    public void profileReset(int n) {
        this.dsiMediaBase.profileReset(n);
    }

    @Override
    public void profileResetAll() {
        this.dsiMediaBase.profileResetAll();
    }

    public void dsiMediaBaseUpdateProfileState(int n, int n2, int n3) {
        this.getListener().updateProfileState(n, n2, n3);
    }

    public void dsiMediaBaseProfileChanged(int n, int n2) {
        this.getListener().profileChanged(n, n2);
    }

    public void dsiMediaBaseProfileCopied(int n, int n2, int n3) {
        this.getListener().profileCopied(n, n2, n3);
    }

    public void dsiMediaBaseProfileReset(int n, int n2) {
        this.getListener().profileReset(n, n2);
    }

    public void dsiMediaBaseProfileResetAll(int n) {
        this.getListener().profileResetAll(n);
    }

    @Override
    protected void connectToDsi(DSIBase dSIBase) {
        this.dsiMediaBase = (DSIMediaBase)dSIBase;
    }

    @Override
    public Class getDsiClass() {
        return class$org$dsi$ifc$media$DSIMediaBase == null ? (class$org$dsi$ifc$media$DSIMediaBase = DsiMediaBaseAdapter.class$("org.dsi.ifc.media.DSIMediaBase")) : class$org$dsi$ifc$media$DSIMediaBase;
    }

    @Override
    protected Class getDsiListenerClass() {
        return class$org$dsi$ifc$media$DSIMediaBaseListener == null ? (class$org$dsi$ifc$media$DSIMediaBaseListener = DsiMediaBaseAdapter.class$("org.dsi.ifc.media.DSIMediaBaseListener")) : class$org$dsi$ifc$media$DSIMediaBaseListener;
    }

    @Override
    protected int getProfileStateAttributeValue() {
        return 9;
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

