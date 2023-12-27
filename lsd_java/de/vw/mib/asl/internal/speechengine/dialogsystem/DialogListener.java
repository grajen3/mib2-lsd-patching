/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem;

import de.vw.mib.asl.internal.speechengine.dialogsystem.Dialog;
import org.dsi.ifc.speechrec.NBestList;

public interface DialogListener {
    default public void onIdle(Dialog dialog) {
    }

    default public void onStarted(Dialog dialog, int n) {
    }

    default public void onTerminated(Dialog dialog, int n) {
    }

    default public void onUtteranceFinished() {
    }

    default public void onRecognitionFinished(int n, NBestList nBestList) {
    }

    default public void onPromptStarted(int n) {
    }

    default public void onPromptSpoken(int n) {
    }

    default public void onPauseStarted() {
    }

    default public void onPauseFinished() {
    }

    default public void onEndStarted(Dialog dialog) {
    }
}

