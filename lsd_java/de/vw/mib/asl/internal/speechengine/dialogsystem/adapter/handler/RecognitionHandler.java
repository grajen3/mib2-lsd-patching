/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.dialogsystem.adapter.handler;

import org.dsi.ifc.speechrec.NBestList;

public interface RecognitionHandler {
    default public void responseStartRecognition(int n) {
    }

    default public void responseWaitForResults(int n, NBestList nBestList) {
    }

    default public void updateRecognizerState(int n) {
    }
}

