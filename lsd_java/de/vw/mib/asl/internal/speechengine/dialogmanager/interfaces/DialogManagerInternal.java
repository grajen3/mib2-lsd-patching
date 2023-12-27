/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackHandler;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogBackstackListener;
import de.vw.mib.asl.api.speechengine.dialogmanager.DialogSessionListener;
import de.vw.mib.asl.api.speechengine.features.model.Command;
import de.vw.mib.asl.api.speechengine.features.model.Prompt;
import de.vw.mib.asl.internal.speechengine.dialogmanager.DialogManagerProxy;
import de.vw.mib.asl.internal.speechengine.dialogmanager.featurehandler.internal.PromptList;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.CommandConsumer;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.DialogManagerStateListener;
import de.vw.mib.asl.internal.speechengine.dialogmanager.interfaces.FeatureHandler;
import de.vw.mib.asl.internal.speechengine.dialogsystem.SpeechDialogSystem;
import org.dsi.ifc.speechrec.NBestList;

public interface DialogManagerInternal
extends DialogManagerProxy {
    default public void resetHelpMode() {
    }

    default public void initializeSpeech(SpeechDialogSystem speechDialogSystem) {
    }

    default public void registerFeatureHandler(int n, FeatureHandler featureHandler) {
    }

    default public void unregisterFeatureHandler(int n, FeatureHandler featureHandler) {
    }

    default public void registerFeatureHandlerDone(FeatureHandler featureHandler) {
    }

    default public void unregisterFeatureHandlerDone(FeatureHandler featureHandler) {
    }

    default public void registerDialogManagerStateListener(DialogManagerStateListener dialogManagerStateListener) {
    }

    default public void unregisterDialogManagerStateListener(DialogManagerStateListener dialogManagerStateListener) {
    }

    default public void registerCommandConsumer(int n, CommandConsumer commandConsumer) {
    }

    default public void unregisterCommandConsumer(int n, CommandConsumer commandConsumer) {
    }

    default public void setState(int n) {
    }

    default public void onInitializationReady() {
    }

    default public void onRecognitionFinished(int n, NBestList nBestList) {
    }

    default public void startPleaseWaitTimer() {
    }

    default public void resetPleaseWaitTimer() {
    }

    default public void startPauseTimer() {
    }

    default public void resetPauseTimer() {
    }

    default public void loadCommands(Command[] commandArray) {
    }

    default public void unloadCommands(Command[] commandArray) {
    }

    default public void playPrompt(int n, boolean bl, boolean bl2) {
    }

    default public void playBackgroundPrompt(int n) {
    }

    default public void playPrompts(Prompt[] promptArray, boolean bl, boolean bl2, int n) {
    }

    default public PromptList getInitialPrompts() {
    }

    default public PromptList getRepeatPrompts() {
    }

    default public Prompt getHelpPrompt() {
    }

    default public void startRecognition() {
    }

    default public void pauseSDS() {
    }

    default public void openMainMenu(boolean bl, boolean bl2) {
    }

    default public void endSDS() {
    }

    default public void fireIdleEvent(int n) {
    }

    default public void firePromptStartedEvent(int n) {
    }

    default public void firePromptSpokenEvent(int n) {
    }

    default public void clearBackstack(int n) {
    }

    default public void notifyDialogStep() {
    }

    default public void keepPromptsRunning() {
    }

    default public void clearTaskList() {
    }

    default public void ignoreInitialPrompts() {
    }

    default public void registerDialogBackstackListener(DialogBackstackListener dialogBackstackListener) {
    }

    default public void unregisterDialogBackstackListener(DialogBackstackListener dialogBackstackListener) {
    }

    default public void resetCounters() {
    }

    default public void startSession(DialogSessionListener dialogSessionListener) {
    }

    default public void endSession(boolean bl) {
    }

    default public void disableSession(int n) {
    }

    default public void enableSession(int n) {
    }

    default public void pauseSession() {
    }

    default public void back() {
    }

    default public void togglePause() {
    }

    default public void pushDialogBackHandler(DialogBackHandler dialogBackHandler) {
    }

    default public void cancelCurrentRunningPrompt(int n) {
    }
}

