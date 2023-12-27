/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.navigation.DSINavigation;

public class DsiNavigationAdapter
extends AbstractPersonalizedAppDsiAdapter {
    private DSINavigation dsiNavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigation;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$DSINavigationListener;

    DsiNavigationAdapter(GenericEvents genericEvents, DSIProxy dSIProxy) {
        super(genericEvents, dSIProxy);
    }

    @Override
    public void profileChange(int n) {
        this.dsiNavigation.profileChange(n);
    }

    @Override
    public void profileCopy(int n, int n2) {
        this.dsiNavigation.profileCopy(n, n2);
    }

    @Override
    public void profileReset(int n) {
        this.dsiNavigation.profileReset(n);
    }

    @Override
    public void profileResetAll() {
        this.dsiNavigation.profileResetAll();
    }

    public void dsiNavigationUpdateProfileState(int n, int n2, int n3) {
        this.getListener().updateProfileState(n, n2, n3);
    }

    public void dsiNavigationProfileChanged(int n, int n2) {
        this.getListener().profileChanged(n, n2);
    }

    public void dsiNavigationProfileCopied(int n, int n2, int n3) {
        this.getListener().profileCopied(n, n2, n3);
    }

    public void dsiNavigationProfileReset(int n, int n2) {
        this.getListener().profileReset(n, n2);
    }

    public void dsiNavigationProfileResetAll(int n) {
        this.getListener().profileResetAll(n);
    }

    @Override
    protected void connectToDsi(DSIBase dSIBase) {
        this.dsiNavigation = (DSINavigation)dSIBase;
    }

    @Override
    public Class getDsiClass() {
        return class$org$dsi$ifc$navigation$DSINavigation == null ? (class$org$dsi$ifc$navigation$DSINavigation = DsiNavigationAdapter.class$("org.dsi.ifc.navigation.DSINavigation")) : class$org$dsi$ifc$navigation$DSINavigation;
    }

    @Override
    protected Class getDsiListenerClass() {
        return class$org$dsi$ifc$navigation$DSINavigationListener == null ? (class$org$dsi$ifc$navigation$DSINavigationListener = DsiNavigationAdapter.class$("org.dsi.ifc.navigation.DSINavigationListener")) : class$org$dsi$ifc$navigation$DSINavigationListener;
    }

    @Override
    protected int getProfileStateAttributeValue() {
        return 107;
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

