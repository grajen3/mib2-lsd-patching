/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.amfm.persistence.DabPersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.framework.api.persistence2.collections.lists.PersistenceArrayList;
import java.util.Iterator;
import java.util.List;

class DabPersistenceImpl
extends AbstractPersistable
implements DabPersistence {
    private final PersistenceModule module;
    private final PersistenceArrayList dabPresets = new PersistenceArrayList();
    private FrequencyPersistence currentFrequency;
    private EnsemblePersistence currentEnsemble;
    private ServicePersistence currentService;
    private ComponentPersistence currentComponent;
    private EnsemblePersistence linkingEnsemble;
    private ServicePersistence linkingService;
    private boolean lBandOptionState;
    private boolean otherAnnouncementOption;
    private boolean trafficAnnouncementOption;
    private boolean dabFollowing;
    private boolean fmLinking;
    private int viewMode;
    private boolean lsmSupportsSlideshow;
    private int currentBand1;
    private int currentBand2;
    private int currentPresetIndexSelectedByHmi;
    private int visibleBankIndex;
    private boolean softLinkingOption;

    DabPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 8;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        if (this.getCurrentFrequency() != null) {
            this.getCurrentFrequency().updateRootPersistable(persistable);
        }
        if (this.getCurrentEnsemble() != null) {
            this.getCurrentEnsemble().updateRootPersistable(persistable);
        }
        if (this.getCurrentService() != null) {
            this.getCurrentService().updateRootPersistable(persistable);
        }
        if (this.getCurrentComponent() != null) {
            this.getCurrentComponent().updateRootPersistable(persistable);
        }
        if (this.getLinkingEnsemble() != null) {
            this.getLinkingEnsemble().updateRootPersistable(persistable);
        }
        if (this.getLinkingService() != null) {
            this.getLinkingService().updateRootPersistable(persistable);
        }
        this.dabPresets.setRootPersistable(persistable);
        Iterator iterator = this.getDabPresets().iterator();
        while (iterator.hasNext()) {
            AbstractPersistable abstractPersistable = (AbstractPersistable)iterator.next();
            if (abstractPersistable == null) continue;
            abstractPersistable.updateRootPersistable(persistable);
        }
    }

    @Override
    public FrequencyPersistence getCurrentFrequency() {
        return this.currentFrequency;
    }

    @Override
    public void setCurrentFrequency(FrequencyPersistence frequencyPersistence) {
        this.currentFrequency = frequencyPersistence;
        this.markDirty();
    }

    @Override
    public EnsemblePersistence getCurrentEnsemble() {
        return this.currentEnsemble;
    }

    @Override
    public void setCurrentEnsemble(EnsemblePersistence ensemblePersistence) {
        this.currentEnsemble = ensemblePersistence;
        this.markDirty();
    }

    @Override
    public ServicePersistence getCurrentService() {
        return this.currentService;
    }

    @Override
    public void setCurrentService(ServicePersistence servicePersistence) {
        this.currentService = servicePersistence;
        this.markDirty();
    }

    @Override
    public ComponentPersistence getCurrentComponent() {
        return this.currentComponent;
    }

    @Override
    public void setCurrentComponent(ComponentPersistence componentPersistence) {
        this.currentComponent = componentPersistence;
        this.markDirty();
    }

    @Override
    public EnsemblePersistence getLinkingEnsemble() {
        return this.linkingEnsemble;
    }

    @Override
    public void setLinkingEnsemble(EnsemblePersistence ensemblePersistence) {
        this.linkingEnsemble = ensemblePersistence;
        this.markDirty();
    }

    @Override
    public ServicePersistence getLinkingService() {
        return this.linkingService;
    }

    @Override
    public void setLinkingService(ServicePersistence servicePersistence) {
        this.linkingService = servicePersistence;
        this.markDirty();
    }

    @Override
    public boolean isLBandOptionState() {
        return this.lBandOptionState;
    }

    @Override
    public void setLBandOptionState(boolean bl) {
        this.lBandOptionState = bl;
        this.markDirty();
    }

    @Override
    public boolean isOtherAnnouncementOption() {
        return this.otherAnnouncementOption;
    }

    @Override
    public void setOtherAnnouncementOption(boolean bl) {
        this.otherAnnouncementOption = bl;
        this.markDirty();
    }

    @Override
    public boolean isTrafficAnnouncementOption() {
        return this.trafficAnnouncementOption;
    }

    @Override
    public void setTrafficAnnouncementOption(boolean bl) {
        this.trafficAnnouncementOption = bl;
        this.markDirty();
    }

    @Override
    public boolean isDabFollowing() {
        return this.dabFollowing;
    }

    @Override
    public void setDabFollowing(boolean bl) {
        this.dabFollowing = bl;
        this.markDirty();
    }

    @Override
    public boolean isFmLinking() {
        return this.fmLinking;
    }

    @Override
    public void setFmLinking(boolean bl) {
        this.fmLinking = bl;
        this.markDirty();
    }

    @Override
    public int getViewMode() {
        return this.viewMode;
    }

    @Override
    public void setViewMode(int n) {
        this.viewMode = n;
        this.markDirty();
    }

    @Override
    public boolean isLsmSupportsSlideshow() {
        return this.lsmSupportsSlideshow;
    }

    @Override
    public void setLsmSupportsSlideshow(boolean bl) {
        this.lsmSupportsSlideshow = bl;
        this.markDirty();
    }

    @Override
    public int getCurrentBand1() {
        return this.currentBand1;
    }

    @Override
    public void setCurrentBand1(int n) {
        this.currentBand1 = n;
        this.markDirty();
    }

    @Override
    public int getCurrentBand2() {
        return this.currentBand2;
    }

    @Override
    public void setCurrentBand2(int n) {
        this.currentBand2 = n;
        this.markDirty();
    }

    @Override
    public int getCurrentPresetIndexSelectedByHmi() {
        return this.currentPresetIndexSelectedByHmi;
    }

    @Override
    public void setCurrentPresetIndexSelectedByHmi(int n) {
        this.currentPresetIndexSelectedByHmi = n;
        this.markDirty();
    }

    @Override
    public int getVisibleBankIndex() {
        return this.visibleBankIndex;
    }

    @Override
    public void setVisibleBankIndex(int n) {
        this.visibleBankIndex = n;
        this.markDirty();
    }

    @Override
    public boolean isSoftLinkingOption() {
        return this.softLinkingOption;
    }

    @Override
    public void setSoftLinkingOption(boolean bl) {
        this.softLinkingOption = bl;
        this.markDirty();
    }

    @Override
    public List getDabPresets() {
        return this.dabPresets;
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

