/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.sound.persistence;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.persistence2.dsi.AbstractPersonalizedAppDsiAdapter;
import de.vw.mib.genericevents.GenericEvents;
import org.dsi.ifc.audio.DSISound;
import org.dsi.ifc.base.DSIBase;

public class DsiSoundAdapter
extends AbstractPersonalizedAppDsiAdapter {
    private DSISound dsiSound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISound;
    static /* synthetic */ Class class$org$dsi$ifc$audio$DSISoundListener;

    DsiSoundAdapter(GenericEvents genericEvents, DSIProxy dSIProxy) {
        super(genericEvents, dSIProxy);
    }

    @Override
    public void profileChange(int n) {
        this.dsiSound.profileChange(n);
    }

    @Override
    public void profileCopy(int n, int n2) {
        this.dsiSound.profileCopy(n, n2);
    }

    @Override
    public void profileReset(int n) {
        this.dsiSound.profileReset(n);
    }

    @Override
    public void profileResetAll() {
        this.dsiSound.profileResetAll();
    }

    public void dsiSoundUpdateProfileState(int n, int n2, int n3) {
        this.getListener().updateProfileState(n, n2, n3);
    }

    public void dsiSoundProfileChanged(int n, int n2) {
        this.getListener().profileChanged(n, n2);
    }

    public void dsiSoundProfileCopied(int n, int n2, int n3) {
        this.getListener().profileCopied(n, n2, n3);
    }

    public void dsiSoundProfileReset(int n, int n2) {
        this.getListener().profileReset(n, n2);
    }

    public void dsiSoundProfileResetAll(int n) {
        this.getListener().profileResetAll(n);
    }

    @Override
    protected void connectToDsi(DSIBase dSIBase) {
        this.dsiSound = (DSISound)dSIBase;
    }

    @Override
    public Class getDsiClass() {
        return class$org$dsi$ifc$audio$DSISound == null ? (class$org$dsi$ifc$audio$DSISound = DsiSoundAdapter.class$("org.dsi.ifc.audio.DSISound")) : class$org$dsi$ifc$audio$DSISound;
    }

    @Override
    protected Class getDsiListenerClass() {
        return class$org$dsi$ifc$audio$DSISoundListener == null ? (class$org$dsi$ifc$audio$DSISoundListener = DsiSoundAdapter.class$("org.dsi.ifc.audio.DSISoundListener")) : class$org$dsi$ifc$audio$DSISoundListener;
    }

    @Override
    protected int getProfileStateAttributeValue() {
        return 56;
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

