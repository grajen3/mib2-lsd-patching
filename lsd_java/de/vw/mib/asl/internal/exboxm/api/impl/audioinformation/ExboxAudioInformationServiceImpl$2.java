/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.exboxm.api.impl.audioinformation;

import de.vw.mib.asl.api.exboxm.audioinformation.ExboxAudioInformationListener;
import de.vw.mib.asl.internal.exboxm.api.impl.audioinformation.ExboxAudioInformationServiceImpl;

class ExboxAudioInformationServiceImpl$2
implements Runnable {
    private final /* synthetic */ ExboxAudioInformationListener val$listener;
    private final /* synthetic */ int val$sourceType;
    private final /* synthetic */ ExboxAudioInformationServiceImpl this$0;

    ExboxAudioInformationServiceImpl$2(ExboxAudioInformationServiceImpl exboxAudioInformationServiceImpl, ExboxAudioInformationListener exboxAudioInformationListener, int n) {
        this.this$0 = exboxAudioInformationServiceImpl;
        this.val$listener = exboxAudioInformationListener;
        this.val$sourceType = n;
    }

    @Override
    public void run() {
        this.val$listener.onAudioSourceChanges(this.val$sourceType);
    }
}

