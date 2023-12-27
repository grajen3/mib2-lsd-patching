/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.features.FeatureFactory;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.internal.speechengine.config.SpeechConfiguratorFactory;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerActivatorCallback;
import de.vw.mib.asl.internal.speechengine.dialogsystem.PromptSystem;
import de.vw.mib.asl.internal.speechengine.messenger.BackstackStatePublisher;
import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;
import de.vw.mib.asl.internal.speechengine.result.RecognizedResultPublisher;
import de.vw.mib.configuration.internal.generated.SpeechConfiguration;
import de.vw.mib.genericevents.ThreadSwitchingTarget;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.timer.TimerManager;

public interface DialogManagerParameters {
    default public DialogManagerActivatorCallback getSpeechEngineStarter() {
    }

    default public PromptSystem getPromptSystem() {
    }

    default public HmiEventPublisher getHmiEventPublisher() {
    }

    default public BackstackStatePublisher getBackstackStatePublisher() {
    }

    default public RecognizedResultPublisher getRecognizedResultPublisher() {
    }

    default public FeatureFactory getFeatureFactory() {
    }

    default public TeleprompterManager getTeleprompterManager() {
    }

    default public SpeechConfiguration getSpeechConfiguration() {
    }

    default public Logger getSpeechLogger() {
    }

    default public TimerManager getTimerManager() {
    }

    default public ThreadSwitchingTarget getThreadSwitchingTarget() {
    }

    default public SpeechConfiguratorFactory getSpeechConfiguratorFactory() {
    }
}

