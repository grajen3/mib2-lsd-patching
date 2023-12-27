/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

import org.dsi.ifc.base.DSIListener;

public interface DSIMobileSpeechRecognitionListener
extends DSIListener {
    default public void updateSpeechRecognitionAvailable(int n, int n2) {
    }

    default public void updateSpeechRecognitionActive(int n, int n2) {
    }

    default public void updateSpeechRecognitionType(int n, int n2) {
    }

    default public void responseStartSpeechRecognition(int n) {
    }

    default public void responseStopSpeechRecognition(int n) {
    }
}

