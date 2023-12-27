/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.controller;

import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.RecognizerConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.TTSConfig;
import java.util.ArrayList;
import java.util.List;

public class ConfigController
implements DialogSystemConfigRegistry {
    private final List configListener = new ArrayList();
    private final List ttsConfigs = new ArrayList(1);
    private final List recConfigs = new ArrayList(1);

    @Override
    public void register(DialogSystemConfigListener dialogSystemConfigListener) {
        if (dialogSystemConfigListener != null) {
            this.configListener.add(dialogSystemConfigListener);
        }
    }

    @Override
    public List getTTSConfigs() {
        return new ArrayList(this.ttsConfigs);
    }

    @Override
    public List getRecognizerConfigs() {
        return new ArrayList(this.recConfigs);
    }

    public void addRecognizerConfig(RecognizerConfig recognizerConfig) {
        if (recognizerConfig != null) {
            this.recConfigs.add(recognizerConfig);
            this.notifyRecognizerUpdated(recognizerConfig, true);
        }
    }

    public void removeRecognizerConfig(RecognizerConfig recognizerConfig) {
        if (recognizerConfig != null) {
            this.recConfigs.remove(recognizerConfig);
            this.notifyRecognizerUpdated(recognizerConfig, false);
        }
    }

    private void notifyRecognizerUpdated(RecognizerConfig recognizerConfig, boolean bl) {
        for (int i2 = 0; i2 < this.configListener.size(); ++i2) {
            DialogSystemConfigListener dialogSystemConfigListener = (DialogSystemConfigListener)this.configListener.get(i2);
            if (bl) {
                dialogSystemConfigListener.onNewRecognizerAvailabe(recognizerConfig);
                continue;
            }
            dialogSystemConfigListener.onRecognizerRemoved(recognizerConfig);
        }
    }

    public void addTtsConfig(TTSConfig tTSConfig) {
        if (tTSConfig != null) {
            this.ttsConfigs.add(tTSConfig);
            this.notifyTtsUpdated(tTSConfig, true);
        }
    }

    public void removeTtsConfig(TTSConfig tTSConfig) {
        if (tTSConfig != null) {
            this.ttsConfigs.remove(tTSConfig);
            this.notifyTtsUpdated(tTSConfig, false);
        }
    }

    private void notifyTtsUpdated(TTSConfig tTSConfig, boolean bl) {
        for (int i2 = 0; i2 < this.configListener.size(); ++i2) {
            DialogSystemConfigListener dialogSystemConfigListener = (DialogSystemConfigListener)this.configListener.get(i2);
            if (bl) {
                dialogSystemConfigListener.onNewTTSAvailabe(tTSConfig);
                continue;
            }
            dialogSystemConfigListener.onTTSRemoved(tTSConfig);
        }
    }
}

