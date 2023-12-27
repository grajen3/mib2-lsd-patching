/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.sound.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.sound.persistence.SoundSettings;

class SoundSettingsImpl
extends AbstractPersistable
implements SoundSettings {
    private final PersistenceModule module;
    private int eqMode;
    private short eqUserTreble;
    private short eqUserMiddle;
    private short eqUserBass;
    private int eqPresetCanton;
    private boolean userMuteActive;

    SoundSettingsImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
    }

    @Override
    public int getEqMode() {
        return this.eqMode;
    }

    @Override
    public void setEqMode(int n) {
        this.eqMode = n;
        this.markDirty();
    }

    @Override
    public short getEqUserTreble() {
        return this.eqUserTreble;
    }

    @Override
    public void setEqUserTreble(short s) {
        this.eqUserTreble = s;
        this.markDirty();
    }

    @Override
    public short getEqUserMiddle() {
        return this.eqUserMiddle;
    }

    @Override
    public void setEqUserMiddle(short s) {
        this.eqUserMiddle = s;
        this.markDirty();
    }

    @Override
    public short getEqUserBass() {
        return this.eqUserBass;
    }

    @Override
    public void setEqUserBass(short s) {
        this.eqUserBass = s;
        this.markDirty();
    }

    @Override
    public int getEqPresetCanton() {
        return this.eqPresetCanton;
    }

    @Override
    public void setEqPresetCanton(int n) {
        this.eqPresetCanton = n;
        this.markDirty();
    }

    @Override
    public boolean isUserMuteActive() {
        return this.userMuteActive;
    }

    @Override
    public void setUserMuteActive(boolean bl) {
        this.userMuteActive = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

