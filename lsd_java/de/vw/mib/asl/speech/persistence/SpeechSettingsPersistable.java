/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.speech.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;

public interface SpeechSettingsPersistable
extends Persistable {
    default public boolean isIsDisplayAvailableCommandsOnHeadunitActivated() {
    }

    default public void setIsDisplayAvailableCommandsOnHeadunitActivated(boolean bl) {
    }

    default public boolean isIsDisplayAvailableCommandsOnICActivated() {
    }

    default public void setIsDisplayAvailableCommandsOnICActivated(boolean bl) {
    }

    default public boolean isIsUseSpeechSessionStartToneActivated() {
    }

    default public void setIsUseSpeechSessionStartToneActivated(boolean bl) {
    }

    default public boolean isIsUseSpeechSessionEndToneActivated() {
    }

    default public void setIsUseSpeechSessionEndToneActivated(boolean bl) {
    }

    default public boolean isIsRecognizerReadyToneActivated() {
    }

    default public void setIsRecognizerReadyToneActivated(boolean bl) {
    }

    default public boolean isIsRecognizerEndToneActivated() {
    }

    default public void setIsRecognizerEndToneActivated(boolean bl) {
    }

    default public int getCurrentVoiceType() {
    }

    default public void setCurrentVoiceType(int n) {
    }
}

