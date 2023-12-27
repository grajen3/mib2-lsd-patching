/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.media.controller;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.media.controller.MediaController;

class MediaController$1
implements Runnable {
    private final /* synthetic */ MediaController this$0;

    MediaController$1(MediaController mediaController) {
        this.this$0 = mediaController;
    }

    @Override
    public void run() {
        ServiceManager.eventDispatcher.createAndSubmitHMIEvent(308022272);
    }
}

