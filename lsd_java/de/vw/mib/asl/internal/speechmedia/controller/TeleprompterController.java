/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechmedia.controller;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettings;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsListener;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.api.speechengine.result.router.ModelEventConsumer;
import de.vw.mib.asl.framework.internal.framework.AbstractASLHsmTarget;
import de.vw.mib.genericevents.EventGeneric;

public class TeleprompterController
implements ModelEventConsumer,
SpeechSettingsListener {
    public static final int EVENT_ID;
    public static final int NOTIFY;
    public static final int VISIBILITY;
    public static final int STATE;
    public static final int ON;
    public static final int OFF;
    private final SpeechSettingsService speechSettingsManager;
    private boolean isVisible;

    public TeleprompterController(SpeechSettingsService speechSettingsService) {
        this.speechSettingsManager = speechSettingsService;
        this.speechSettingsManager.register(this);
        boolean bl = this.speechSettingsManager.getSpeechSettings().isDisplayAvailableCommandsOnHeadunitActivated();
        this.isVisible = !bl;
        this.updateTeleprompterVisible(bl);
    }

    @Override
    public void onEvent(EventGeneric eventGeneric) {
        this.speechSettingsManager.toggleDisplayAvailableCommandsOnHeadunitActivated();
    }

    @Override
    public void onSpeechSettingsUpdated(SpeechSettings speechSettings) {
        this.updateTeleprompterVisible(speechSettings.isDisplayAvailableCommandsOnHeadunitActivated());
    }

    private void updateTeleprompterVisible(boolean bl) {
        if (this.isVisible == bl) {
            return;
        }
        this.isVisible = bl;
        AbstractASLHsmTarget.writeBooleanToDatapool(-1316933120, this.isVisible);
        if (this.isVisible) {
            AbstractASLHsmTarget.writeIntegerToDatapool(-1014943232, 0);
        } else {
            AbstractASLHsmTarget.writeIntegerToDatapool(-1014943232, 1);
        }
    }
}

