/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.dialogmanager;

import de.vw.mib.asl.api.speechengine.dialogmanager.DialogSessionListener;

public interface DialogManager {
    default public void startSession(DialogSessionListener dialogSessionListener) {
    }

    default public void startSession() {
    }

    default public void endSession(boolean bl) {
    }

    default public void disableSession() {
    }

    default public void enableSession() {
    }

    default public void pauseSession() {
    }

    default public void back() {
    }

    default public void togglePause() {
    }
}

