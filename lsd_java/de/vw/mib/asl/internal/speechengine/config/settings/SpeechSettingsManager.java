/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.settings;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettings;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsListener;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.framework.api.persistence2.AbstractProfileChangeHandler;
import de.vw.mib.asl.internal.speechengine.config.settings.SpeechSettingsDefaultProvider;
import de.vw.mib.asl.internal.speechengine.config.settings.SpeechSettingsImmutable;
import de.vw.mib.asl.internal.speechengine.config.start.SpeechConfiguratorParameters;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.asl.speech.persistence.SpeechPersistenceService;
import de.vw.mib.asl.speech.persistence.SpeechSettingsPersistable;
import de.vw.mib.collections.ObjectObjectMap;
import de.vw.mib.collections.ObjectObjectOptHashMap;
import de.vw.mib.threads.AsyncServiceFactory;
import java.util.Iterator;

public class SpeechSettingsManager
extends AbstractProfileChangeHandler
implements SpeechSettingsService {
    private AbstractClassifiedLogger logger;
    private final SpeechPersistenceService speechPersistenceService;
    private SpeechSettings currentImmutableSettings = SpeechSettingsDefaultProvider.getDefaultSettings();
    private boolean isDisplayAvailableCommandsOnHeadunitActivated = SpeechSettingsDefaultProvider.isDisplayAvailableCommandsOnHeadunitActivated();
    private boolean isDisplayAvailableCommandsOnICActivated = SpeechSettingsDefaultProvider.isDisplayAvailableCommandsOnICActivated();
    private boolean isUseSpeechSessionStartToneActivate = SpeechSettingsDefaultProvider.isUseSpeechSessionStartToneActivated();
    private boolean isUseSpeechSessionEndToneActivated = SpeechSettingsDefaultProvider.isUseSpeechSessionEndToneActivated();
    private boolean isRecognizerReadyToneActivated = SpeechSettingsDefaultProvider.isRecognizerReadyToneActivated();
    private boolean isRecognizerEndToneActivated = SpeechSettingsDefaultProvider.isRecognizerEndToneActivated();
    private final ObjectObjectMap speechSettingsListenerAsync;
    private final AsyncServiceFactory asyncServiceFactory;

    public SpeechSettingsManager(SpeechConfiguratorParameters speechConfiguratorParameters, SpeechPersistenceService speechPersistenceService) {
        this.logger = speechConfiguratorParameters.getClassifiedLogger();
        this.asyncServiceFactory = speechConfiguratorParameters.getAsyncServiceFactory();
        this.speechPersistenceService = speechPersistenceService;
        this.speechSettingsListenerAsync = new ObjectObjectOptHashMap();
        speechPersistenceService.addProfileChangeListener(this);
        this.loadAndApplyPersistedValue();
    }

    @Override
    public void toggleDisplayAvailableCommandsOnHeadunitActivated() {
        boolean bl = this.isDisplayAvailableCommandsOnHeadunitActivated;
        boolean bl2 = !bl;
        this.setAndPersistDisplayAvailableCommandsOnHeadunitActivated(bl2);
        this.exchangeImmutableSettingsAndNotifyObservers();
    }

    private void setAndPersistDisplayAvailableCommandsOnHeadunitActivated(boolean bl) {
        this.isDisplayAvailableCommandsOnHeadunitActivated = bl;
        this.speechPersistenceService.loadSpeechSettingsPersistable().setIsDisplayAvailableCommandsOnHeadunitActivated(this.isDisplayAvailableCommandsOnHeadunitActivated);
    }

    @Override
    public void toggleDisplayAvailableCommandsOnICActivated() {
        boolean bl = this.isDisplayAvailableCommandsOnICActivated;
        boolean bl2 = !bl;
        this.setAndPersistDisplayAvailableCommandsOnICActivated(bl2);
        this.exchangeImmutableSettingsAndNotifyObservers();
    }

    private void setAndPersistDisplayAvailableCommandsOnICActivated(boolean bl) {
        this.isDisplayAvailableCommandsOnICActivated = bl;
        this.speechPersistenceService.loadSpeechSettingsPersistable().setIsDisplayAvailableCommandsOnICActivated(this.isDisplayAvailableCommandsOnICActivated);
    }

    @Override
    public void toggleUseSpeechSessionStartToneActivated() {
        boolean bl = this.isUseSpeechSessionStartToneActivate;
        boolean bl2 = !bl;
        this.setAndPersistUseSpeechSessionStartToneActivated(bl2);
        this.exchangeImmutableSettingsAndNotifyObservers();
    }

    private void setAndPersistUseSpeechSessionStartToneActivated(boolean bl) {
        this.isUseSpeechSessionStartToneActivate = bl;
        this.speechPersistenceService.loadSpeechSettingsPersistable().setIsUseSpeechSessionStartToneActivated(this.isUseSpeechSessionStartToneActivate);
    }

    @Override
    public void toggleUseSpeechSessionEndToneActivated() {
        boolean bl = this.isUseSpeechSessionEndToneActivated;
        boolean bl2 = !bl;
        this.setAndPersistUseSpeechSessionEndToneActivated(bl2);
        this.exchangeImmutableSettingsAndNotifyObservers();
    }

    private void setAndPersistUseSpeechSessionEndToneActivated(boolean bl) {
        this.isUseSpeechSessionEndToneActivated = bl;
        this.speechPersistenceService.loadSpeechSettingsPersistable().setIsUseSpeechSessionEndToneActivated(this.isUseSpeechSessionEndToneActivated);
    }

    @Override
    public void toggleRecognizerReadyToneActivated() {
        boolean bl = this.isRecognizerReadyToneActivated;
        boolean bl2 = !bl;
        this.setAndPersistRecognizerReadyToneActivated(bl2);
        this.exchangeImmutableSettingsAndNotifyObservers();
    }

    private void setAndPersistRecognizerReadyToneActivated(boolean bl) {
        this.isRecognizerReadyToneActivated = bl;
        this.speechPersistenceService.loadSpeechSettingsPersistable().setIsRecognizerReadyToneActivated(this.isRecognizerReadyToneActivated);
    }

    @Override
    public void toggleRecognizerEndToneActivated() {
        boolean bl = this.isRecognizerEndToneActivated;
        boolean bl2 = !bl;
        this.setAndPersistRecognizerEndToneActivated(bl2);
        this.exchangeImmutableSettingsAndNotifyObservers();
    }

    private void setAndPersistRecognizerEndToneActivated(boolean bl) {
        this.isRecognizerEndToneActivated = bl;
        this.speechPersistenceService.loadSpeechSettingsPersistable().setIsRecognizerEndToneActivated(this.isRecognizerEndToneActivated);
    }

    private void exchangeImmutableSettingsAndNotifyObservers() {
        this.currentImmutableSettings = new SpeechSettingsImmutable(this.isDisplayAvailableCommandsOnHeadunitActivated, this.isDisplayAvailableCommandsOnICActivated, this.isUseSpeechSessionStartToneActivate, this.isUseSpeechSessionEndToneActivated, this.isRecognizerReadyToneActivated, this.isRecognizerEndToneActivated);
        this.notifyObservers();
    }

    private void notifyObservers() {
        Iterator iterator = this.speechSettingsListenerAsync.valueIterator();
        while (iterator.hasNext()) {
            SpeechSettingsListener speechSettingsListener = (SpeechSettingsListener)iterator.next();
            speechSettingsListener.onSpeechSettingsUpdated(this.currentImmutableSettings);
        }
    }

    @Override
    public SpeechSettings getSpeechSettings() {
        return this.currentImmutableSettings;
    }

    @Override
    public void register(SpeechSettingsListener speechSettingsListener) {
        if (!this.speechSettingsListenerAsync.containsKey(speechSettingsListener)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("register(SpeechSettingsListener) : ").append(super.getClass().getName()).log();
            }
            Object object = this.asyncServiceFactory.create(speechSettingsListener);
            this.speechSettingsListenerAsync.put(speechSettingsListener, object);
        }
    }

    @Override
    public void unregister(SpeechSettingsListener speechSettingsListener) {
        if (this.speechSettingsListenerAsync.containsKey(speechSettingsListener)) {
            if (this.logger.isTraceEnabled()) {
                this.logger.trace().append("unregister(SpeechSettingsListener) : ").append(super.getClass().getName()).log();
            }
            this.speechSettingsListenerAsync.remove(speechSettingsListener);
        }
    }

    @Override
    protected void prepareForProfileChange() {
        this.notifyReadyForProfileSwitch();
    }

    @Override
    protected void changeProfile() {
        this.loadAndApplyPersistedValue();
        this.notifyProfileChanged(true);
    }

    private void loadAndApplyPersistedValue() {
        SpeechSettingsPersistable speechSettingsPersistable = this.speechPersistenceService.loadSpeechSettingsPersistable();
        this.isDisplayAvailableCommandsOnHeadunitActivated = speechSettingsPersistable.isIsDisplayAvailableCommandsOnHeadunitActivated();
        this.isDisplayAvailableCommandsOnICActivated = speechSettingsPersistable.isIsDisplayAvailableCommandsOnICActivated();
        this.isUseSpeechSessionStartToneActivate = speechSettingsPersistable.isIsUseSpeechSessionStartToneActivated();
        this.isUseSpeechSessionEndToneActivated = speechSettingsPersistable.isIsUseSpeechSessionEndToneActivated();
        this.isRecognizerReadyToneActivated = speechSettingsPersistable.isIsRecognizerReadyToneActivated();
        this.isRecognizerEndToneActivated = speechSettingsPersistable.isIsRecognizerEndToneActivated();
        this.exchangeImmutableSettingsAndNotifyObservers();
    }

    public void resetToDefaults() {
        this.currentImmutableSettings = SpeechSettingsDefaultProvider.getDefaultSettings();
        this.setAndPersistDisplayAvailableCommandsOnHeadunitActivated(this.currentImmutableSettings.isDisplayAvailableCommandsOnHeadunitActivated());
        this.setAndPersistDisplayAvailableCommandsOnICActivated(this.currentImmutableSettings.isDisplayAvailableCommandsOnICActivated());
        this.setAndPersistRecognizerEndToneActivated(this.currentImmutableSettings.isRecognizerEndToneActivated());
        this.setAndPersistRecognizerReadyToneActivated(this.currentImmutableSettings.isRecognizerEndToneActivated());
        this.setAndPersistUseSpeechSessionEndToneActivated(this.currentImmutableSettings.isUseSpeechSessionEndToneActivated());
        this.setAndPersistUseSpeechSessionStartToneActivated(this.currentImmutableSettings.isUseSpeechSessionStartToneActivated());
        this.notifyObservers();
    }
}

