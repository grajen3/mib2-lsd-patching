/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.radiodata.DSIRadioData;

public class DsiRadioDataAdapter
extends AbstractPersonalizedAppDsiAdapter {
    private DSIRadioData dsiRadioData;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$DSIRadioData;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$DSIRadioDataListener;

    DsiRadioDataAdapter(GenericEvents genericEvents, DSIProxy dSIProxy) {
        super(genericEvents, dSIProxy);
    }

    @Override
    public void profileChange(int n) {
        this.dsiRadioData.profileChange(n);
    }

    @Override
    public void profileCopy(int n, int n2) {
        this.dsiRadioData.profileCopy(n, n2);
    }

    @Override
    public void profileReset(int n) {
        this.dsiRadioData.profileReset(n);
    }

    @Override
    public void profileResetAll() {
        this.dsiRadioData.profileResetAll();
    }

    public void dsiRadioDataUpdateProfileState(int n, int n2, int n3) {
        this.getListener().updateProfileState(n, n2, n3);
    }

    public void dsiRadioDataProfileChanged(int n, int n2) {
        this.getListener().profileChanged(n, n2);
    }

    public void dsiRadioDataProfileCopied(int n, int n2, int n3) {
        this.getListener().profileCopied(n, n2, n3);
    }

    public void dsiRadioDataProfileReset(int n, int n2) {
        this.getListener().profileReset(n, n2);
    }

    public void dsiRadioDataProfileResetAll(int n) {
        this.getListener().profileResetAll(n);
    }

    @Override
    protected void connectToDsi(DSIBase dSIBase) {
        this.dsiRadioData = (DSIRadioData)dSIBase;
    }

    @Override
    public Class getDsiClass() {
        return class$org$dsi$ifc$radiodata$DSIRadioData == null ? (class$org$dsi$ifc$radiodata$DSIRadioData = DsiRadioDataAdapter.class$("org.dsi.ifc.radiodata.DSIRadioData")) : class$org$dsi$ifc$radiodata$DSIRadioData;
    }

    @Override
    protected Class getDsiListenerClass() {
        return class$org$dsi$ifc$radiodata$DSIRadioDataListener == null ? (class$org$dsi$ifc$radiodata$DSIRadioDataListener = DsiRadioDataAdapter.class$("org.dsi.ifc.radiodata.DSIRadioDataListener")) : class$org$dsi$ifc$radiodata$DSIRadioDataListener;
    }

    @Override
    protected int getProfileStateAttributeValue() {
        return 3;
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

