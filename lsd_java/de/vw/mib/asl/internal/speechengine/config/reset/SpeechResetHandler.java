/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.config.reset;

import de.vw.mib.asl.api.system.factoryreset.AbstractFactoryResetParticipant;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetCallback;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetComponents;
import de.vw.mib.asl.api.system.factoryreset.FactoryResetService;
import de.vw.mib.asl.internal.speechengine.config.lsc.VoiceServiceInternal;
import de.vw.mib.asl.internal.speechengine.config.settings.SpeechSettingsManager;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigListener;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.DialogSystemConfigRegistry;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.RecognizerConfig;
import de.vw.mib.asl.internal.speechengine.dialogsystem.config.TTSConfig;
import de.vw.mib.asl.internal.util.AbstractClassifiedLogger;
import de.vw.mib.collections.ObjectOptHashSet;
import de.vw.mib.collections.ObjectSet;
import java.util.Iterator;
import java.util.List;

public class SpeechResetHandler
extends AbstractFactoryResetParticipant
implements DialogSystemConfigListener {
    private final ObjectSet recognizers;
    private final VoiceServiceInternal voiceServiceInternal;
    private final AbstractClassifiedLogger logger;
    private final SpeechSettingsManager speechSettingsManager;

    public SpeechResetHandler(AbstractClassifiedLogger abstractClassifiedLogger, SpeechSettingsManager speechSettingsManager, VoiceServiceInternal voiceServiceInternal, FactoryResetService factoryResetService, DialogSystemConfigRegistry dialogSystemConfigRegistry) {
        this.logger = abstractClassifiedLogger;
        this.speechSettingsManager = speechSettingsManager;
        this.voiceServiceInternal = voiceServiceInternal;
        this.recognizers = new ObjectOptHashSet();
        List list = dialogSystemConfigRegistry.getRecognizerConfigs();
        this.recognizers.addAll(list);
        dialogSystemConfigRegistry.register(this);
        factoryResetService.addParticipant(this, FactoryResetComponents.SPEECH);
    }

    @Override
    public void reset(FactoryResetCallback factoryResetCallback, int n) {
        Iterator iterator = this.recognizers.iterator();
        this.speechSettingsManager.resetToDefaults();
        while (iterator.hasNext()) {
            RecognizerConfig recognizerConfig = (RecognizerConfig)iterator.next();
            recognizerConfig.doReset();
        }
        try {
            this.voiceServiceInternal.changeToDefaultVoice();
        }
        catch (Exception exception) {
            this.logger.error().attachThrowable(exception).log();
        }
        factoryResetCallback.notifyResetDone();
    }

    @Override
    public void onNewTTSAvailabe(TTSConfig tTSConfig) {
    }

    @Override
    public void onTTSRemoved(TTSConfig tTSConfig) {
    }

    @Override
    public void onNewRecognizerAvailabe(RecognizerConfig recognizerConfig) {
        this.recognizers.add(recognizerConfig);
    }

    @Override
    public void onRecognizerRemoved(RecognizerConfig recognizerConfig) {
        this.recognizers.remove(recognizerConfig);
    }
}

