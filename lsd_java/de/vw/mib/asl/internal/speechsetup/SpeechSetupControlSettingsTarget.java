/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechsetup;

import de.vw.mib.asl.ASLPropertyManager;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettings;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsListener;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.internal.speechsetup.ifc.SpeechSetupParameters;
import de.vw.mib.genericevents.AbstractTarget;
import de.vw.mib.genericevents.EventGeneric;

public class SpeechSetupControlSettingsTarget
extends AbstractTarget
implements SpeechSettingsListener {
    private ASLPropertyManager datapool;
    private SpeechSettingsService settingsService;
    private static final int[] SETTINGS_SERVICES = new int[]{1142308928, 1159086144, 1075200064, 1091977280, 1108754496, 1125531712};

    public SpeechSetupControlSettingsTarget(SpeechSetupParameters speechSetupParameters) {
        super(speechSetupParameters.getGenericEvents(), -1544546048, speechSetupParameters.getTaskId());
        this.addObservers(SETTINGS_SERVICES);
        this.datapool = speechSetupParameters.getAslPropertyManager();
        this.settingsService = speechSetupParameters.getSpeechEngine().getSpeechConfigurator(19).getSpeechSettingsManager();
        this.settingsService.register(this);
        this.refreshValues(this.settingsService.getSpeechSettings());
    }

    @Override
    public void gotEvent(EventGeneric eventGeneric) {
        switch (eventGeneric.getReceiverEventId()) {
            case 1077941824: {
                this.settingsService.toggleUseSpeechSessionStartToneActivated();
                break;
            }
            case 1077941825: {
                this.settingsService.toggleUseSpeechSessionEndToneActivated();
                break;
            }
            case 1077941826: {
                this.settingsService.toggleRecognizerReadyToneActivated();
                break;
            }
            case 1077941827: {
                this.settingsService.toggleRecognizerEndToneActivated();
                break;
            }
            case 1077941828: {
                this.settingsService.toggleDisplayAvailableCommandsOnHeadunitActivated();
                break;
            }
            case 1077941829: {
                this.settingsService.toggleDisplayAvailableCommandsOnICActivated();
                break;
            }
        }
    }

    @Override
    public void onSpeechSettingsUpdated(SpeechSettings speechSettings) {
        this.refreshValues(speechSettings);
    }

    private void refreshValues(SpeechSettings speechSettings) {
        this.datapool.valueChangedBoolean(1430077440, speechSettings.isDisplayAvailableCommandsOnHeadunitActivated());
        this.datapool.valueChangedBoolean(1446854656, speechSettings.isDisplayAvailableCommandsOnICActivated());
        this.datapool.valueChangedBoolean(1362968576, speechSettings.isUseSpeechSessionStartToneActivated());
        this.datapool.valueChangedBoolean(1379745792, speechSettings.isUseSpeechSessionEndToneActivated());
        this.datapool.valueChangedBoolean(1396523008, speechSettings.isRecognizerReadyToneActivated());
        this.datapool.valueChangedBoolean(1413300224, speechSettings.isRecognizerEndToneActivated());
    }
}

