/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class EnsemblePersistenceImpl
extends AbstractPersistable
implements EnsemblePersistence {
    private final PersistenceModule module;
    private int ensEcc;
    private int ensId;
    private String frequencyLabel;
    private int frequencyValue;
    private String fullName;
    private boolean potentiallyReceivable;
    private String shortName;
    private boolean tp;

    EnsemblePersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 10;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
    }

    @Override
    public int getEnsEcc() {
        return this.ensEcc;
    }

    @Override
    public void setEnsEcc(int n) {
        this.ensEcc = n;
        this.markDirty();
    }

    @Override
    public int getEnsId() {
        return this.ensId;
    }

    @Override
    public void setEnsId(int n) {
        this.ensId = n;
        this.markDirty();
    }

    @Override
    public String getFrequencyLabel() {
        return this.frequencyLabel;
    }

    @Override
    public void setFrequencyLabel(String string) {
        this.frequencyLabel = string;
        this.markDirty();
    }

    @Override
    public int getFrequencyValue() {
        return this.frequencyValue;
    }

    @Override
    public void setFrequencyValue(int n) {
        this.frequencyValue = n;
        this.markDirty();
    }

    @Override
    public String getFullName() {
        return this.fullName;
    }

    @Override
    public void setFullName(String string) {
        this.fullName = string;
        this.markDirty();
    }

    @Override
    public boolean isPotentiallyReceivable() {
        return this.potentiallyReceivable;
    }

    @Override
    public void setPotentiallyReceivable(boolean bl) {
        this.potentiallyReceivable = bl;
        this.markDirty();
    }

    @Override
    public String getShortName() {
        return this.shortName;
    }

    @Override
    public void setShortName(String string) {
        this.shortName = string;
        this.markDirty();
    }

    @Override
    public boolean isTp() {
        return this.tp;
    }

    @Override
    public void setTp(boolean bl) {
        this.tp = bl;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

