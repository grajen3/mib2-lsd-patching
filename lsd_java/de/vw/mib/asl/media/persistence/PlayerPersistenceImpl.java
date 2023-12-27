/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.collections.maps.PersistenceIntObjectOptHashMap;
import de.vw.mib.asl.media.persistence.PlayerPersistence;
import de.vw.mib.collections.ints.IntObjectMap;
import java.util.Iterator;

class PlayerPersistenceImpl
extends AbstractPersistable
implements PlayerPersistence {
    private final PersistenceModule module;
    private final PersistenceIntObjectOptHashMap selections = new PersistenceIntObjectOptHashMap();
    private boolean includeSubfolder;
    private int videoFormat;
    private boolean videoMaximized;
    private String parentalManagementPin;
    private int parentalManagementLevel;

    PlayerPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 7;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        this.selections.setRootPersistable(persistable);
        Iterator iterator = this.getSelections().values().iterator();
        while (iterator.hasNext()) {
            AbstractPersistable abstractPersistable = (AbstractPersistable)iterator.next();
            if (abstractPersistable == null) continue;
            abstractPersistable.updateRootPersistable(persistable);
        }
    }

    @Override
    public boolean isIncludeSubfolder() {
        return this.includeSubfolder;
    }

    @Override
    public void setIncludeSubfolder(boolean bl) {
        this.includeSubfolder = bl;
        this.markDirty();
    }

    @Override
    public int getVideoFormat() {
        return this.videoFormat;
    }

    @Override
    public void setVideoFormat(int n) {
        this.videoFormat = n;
        this.markDirty();
    }

    @Override
    public IntObjectMap getSelections() {
        return this.selections;
    }

    @Override
    public boolean isVideoMaximized() {
        return this.videoMaximized;
    }

    @Override
    public void setVideoMaximized(boolean bl) {
        this.videoMaximized = bl;
        this.markDirty();
    }

    @Override
    public String getParentalManagementPin() {
        return this.parentalManagementPin;
    }

    @Override
    public void setParentalManagementPin(String string) {
        this.parentalManagementPin = string;
        this.markDirty();
    }

    @Override
    public int getParentalManagementLevel() {
        return this.parentalManagementLevel;
    }

    @Override
    public void setParentalManagementLevel(int n) {
        this.parentalManagementLevel = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

