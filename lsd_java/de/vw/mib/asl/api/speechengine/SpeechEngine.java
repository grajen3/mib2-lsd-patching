/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine;

import de.vw.mib.asl.api.speechengine.PromptEngine;
import de.vw.mib.asl.api.speechengine.audio.AudioAccessor;
import de.vw.mib.asl.api.speechengine.config.SpeechConfigurator;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstack;
import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.backstack.BackstackStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.dialog.DialogStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.indicator.IndicatorStateRouter;
import de.vw.mib.asl.api.speechengine.messenger.slot.SlotStateRouter;
import de.vw.mib.asl.api.speechengine.result.ResultHandler;
import de.vw.mib.asl.api.speechengine.slots.SlotUpdater;
import de.vw.mib.asl.api.speechengine.teleprompter.TeleprompterManager;
import de.vw.mib.asl.api.speechengine.teleprompter.data.TeleprompterDataManager;
import de.vw.mib.asl.api.speechengine.vde.VoiceDestinationEntry;

public interface SpeechEngine
extends PromptEngine {
    default public DialogBackstack getDialogBackstack(int n) {
    }

    default public DialogStateRouter getDialogStateRouter() {
    }

    default public ApplicationStateRouter getApplicationStateRouter() {
    }

    default public IndicatorStateRouter getIndicatorStateRouter() {
    }

    default public BackstackStateRouter getBackstackStateRouter() {
    }

    default public ResultHandler getResultHandler(int n) {
    }

    default public SlotStateRouter getSlotStateRouter() {
    }

    default public TeleprompterManager getTeleprompterManager() {
    }

    default public SlotUpdater getSlotUpdater(int n) {
    }

    default public VoiceDestinationEntry getVdeService(int n) {
    }

    default public AudioAccessor getAudioAccessor(int n) {
    }

    default public TeleprompterDataManager getTeleprompterDataManager(int n) {
    }

    default public SpeechConfigurator getSpeechConfigurator(int n) {
    }
}

