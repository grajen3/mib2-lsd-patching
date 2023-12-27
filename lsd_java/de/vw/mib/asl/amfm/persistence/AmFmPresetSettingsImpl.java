/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmPresetSettings;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceArrayList;
import java.util.Iterator;
import java.util.List;

class AmFmPresetSettingsImpl
extends AbstractPersistable
implements AmFmPresetSettings {
    private final PersistenceModule module;
    private final PersistenceArrayList amPresets = new PersistenceArrayList();
    private final PersistenceArrayList fmPresets = new PersistenceArrayList();
    private int currentBankIndexAm;
    private int currentBankIndexFm;
    private int currentIndexAm;
    private int currentIndexFm;

    AmFmPresetSettingsImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 5;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        AbstractPersistable abstractPersistable;
        this.setRootPersistable(persistable);
        this.amPresets.setRootPersistable(persistable);
        Iterator iterator = this.getAmPresets().iterator();
        while (iterator.hasNext()) {
            abstractPersistable = (AbstractPersistable)iterator.next();
            if (abstractPersistable == null) continue;
            abstractPersistable.updateRootPersistable(persistable);
        }
        this.fmPresets.setRootPersistable(persistable);
        iterator = this.getFmPresets().iterator();
        while (iterator.hasNext()) {
            abstractPersistable = (AbstractPersistable)iterator.next();
            if (abstractPersistable == null) continue;
            abstractPersistable.updateRootPersistable(persistable);
        }
    }

    @Override
    public List getAmPresets() {
        return this.amPresets;
    }

    @Override
    public List getFmPresets() {
        return this.fmPresets;
    }

    @Override
    public int getCurrentBankIndexAm() {
        return this.currentBankIndexAm;
    }

    @Override
    public void setCurrentBankIndexAm(int n) {
        this.currentBankIndexAm = n;
        this.markDirty();
    }

    @Override
    public int getCurrentBankIndexFm() {
        return this.currentBankIndexFm;
    }

    @Override
    public void setCurrentBankIndexFm(int n) {
        this.currentBankIndexFm = n;
        this.markDirty();
    }

    @Override
    public int getCurrentIndexAm() {
        return this.currentIndexAm;
    }

    @Override
    public void setCurrentIndexAm(int n) {
        this.currentIndexAm = n;
        this.markDirty();
    }

    @Override
    public int getCurrentIndexFm() {
        return this.currentIndexFm;
    }

    @Override
    public void setCurrentIndexFm(int n) {
        this.currentIndexFm = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

