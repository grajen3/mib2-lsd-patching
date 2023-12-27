/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.speech.persistence;

import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistable;

class SpeechSettingsPersistableImpl
extends AbstractPersistable
implements SpeechSettingsPersistable {
    private final PersistenceModule module;
    private boolean isDisplayAvailableCommandsOnHeadunitActivated;
    private boolean isDisplayAvailableCommandsOnICActivated;
    private boolean isUseSpeechSessionStartToneActivated;
    private boolean isUseSpeechSessionEndToneActivated;
    private boolean isRecognizerReadyToneActivated;
    private boolean isRecognizerEndToneActivated;
    private int currentVoiceType;

    SpeechSettingsPersistableImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 2;
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
    public boolean isIsDisplayAvailableCommandsOnHeadunitActivated() {
        return this.isDisplayAvailableCommandsOnHeadunitActivated;
    }

    @Override
    public void setIsDisplayAvailableCommandsOnHeadunitActivated(boolean bl) {
        this.isDisplayAvailableCommandsOnHeadunitActivated = bl;
        this.markDirty();
    }

    @Override
    public boolean isIsDisplayAvailableCommandsOnICActivated() {
        return this.isDisplayAvailableCommandsOnICActivated;
    }

    @Override
    public void setIsDisplayAvailableCommandsOnICActivated(boolean bl) {
        this.isDisplayAvailableCommandsOnICActivated = bl;
        this.markDirty();
    }

    @Override
    public boolean isIsUseSpeechSessionStartToneActivated() {
        return this.isUseSpeechSessionStartToneActivated;
    }

    @Override
    public void setIsUseSpeechSessionStartToneActivated(boolean bl) {
        this.isUseSpeechSessionStartToneActivated = bl;
        this.markDirty();
    }

    @Override
    public boolean isIsUseSpeechSessionEndToneActivated() {
        return this.isUseSpeechSessionEndToneActivated;
    }

    @Override
    public void setIsUseSpeechSessionEndToneActivated(boolean bl) {
        this.isUseSpeechSessionEndToneActivated = bl;
        this.markDirty();
    }

    @Override
    public boolean isIsRecognizerReadyToneActivated() {
        return this.isRecognizerReadyToneActivated;
    }

    @Override
    public void setIsRecognizerReadyToneActivated(boolean bl) {
        this.isRecognizerReadyToneActivated = bl;
        this.markDirty();
    }

    @Override
    public boolean isIsRecognizerEndToneActivated() {
        return this.isRecognizerEndToneActivated;
    }

    @Override
    public void setIsRecognizerEndToneActivated(boolean bl) {
        this.isRecognizerEndToneActivated = bl;
        this.markDirty();
    }

    @Override
    public int getCurrentVoiceType() {
        return this.currentVoiceType;
    }

    @Override
    public void setCurrentVoiceType(int n) {
        this.currentVoiceType = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

