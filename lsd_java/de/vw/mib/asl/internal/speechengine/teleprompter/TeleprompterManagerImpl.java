/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.teleprompter;

import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettings;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsListener;
import de.vw.mib.asl.api.speechengine.config.settings.SpeechSettingsService;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterStateConsumer;
import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;
import de.vw.mib.collections.ObjectOptHashSet;
import de.vw.mib.collections.ObjectSet;
import java.util.Iterator;

public class TeleprompterManagerImpl
implements TeleprompterManager,
SpeechSettingsListener {
    private ObjectSet consumers = new ObjectOptHashSet();
    private final SpeechSettingsService speechSettingsManager;
    private int lastBroadCastedState = 0;

    public TeleprompterManagerImpl(SpeechConfiguratorFactory speechConfiguratorFactory) {
        this.speechSettingsManager = speechConfiguratorFactory.createSpeechConfiguration(1).getSpeechSettingsManager();
        boolean bl = this.isTeleprompterActivated();
        this.lastBroadCastedState = this.convertConfigStateToTeleprompterState(bl);
        this.speechSettingsManager.register(this);
    }

    private int convertConfigStateToTeleprompterState(boolean bl) {
        if (bl) {
            return 0;
        }
        return 1;
    }

    private boolean isTeleprompterActivated() {
        return this.speechSettingsManager.getSpeechSettings().isDisplayAvailableCommandsOnHeadunitActivated();
    }

    @Override
    public void toggle() {
        this.speechSettingsManager.toggleDisplayAvailableCommandsOnHeadunitActivated();
    }

    private void notifyAllConsumers(int n) {
        Iterator iterator = this.consumers.iterator();
        while (iterator.hasNext()) {
            TeleprompterStateConsumer teleprompterStateConsumer = (TeleprompterStateConsumer)iterator.next();
            teleprompterStateConsumer.onTeleprompterStateChanged(n);
        }
    }

    @Override
    public void register(TeleprompterStateConsumer teleprompterStateConsumer) {
        this.consumers.add(teleprompterStateConsumer);
        teleprompterStateConsumer.onTeleprompterStateChanged(this.lastBroadCastedState);
    }

    @Override
    public void unregister(TeleprompterStateConsumer teleprompterStateConsumer) {
        this.consumers.remove(teleprompterStateConsumer);
    }

    @Override
    public void show() {
        if (this.isTeleprompterActivated()) {
            return;
        }
        this.toggle();
    }

    @Override
    public void hide() {
        if (!this.isTeleprompterActivated()) {
            return;
        }
        this.toggle();
    }

    @Override
    public void onSpeechSettingsUpdated(SpeechSettings speechSettings) {
        boolean bl = speechSettings.isDisplayAvailableCommandsOnHeadunitActivated();
        int n = this.convertConfigStateToTeleprompterState(bl);
        if (n != this.lastBroadCastedState) {
            this.lastBroadCastedState = n;
            this.notifyAllConsumers(n);
        }
    }
}

