/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.popup;

import de.vw.mib.popup.PopupSpeechInfoReceiver;

public interface PopupSpeechSegueService {
    default public void addPopupSpeechInfoReceiver(PopupSpeechInfoReceiver popupSpeechInfoReceiver) {
    }

    default public void removePopupSpeechInfoReceiver(PopupSpeechInfoReceiver popupSpeechInfoReceiver) {
    }

    default public void receiveSpeechApplicantActive(boolean bl) {
    }
}

