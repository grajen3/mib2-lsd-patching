/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechnavigation.usecase.common;

import de.vw.mib.asl.api.speechengine.result.router.RecognizedEventConsumer;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;

public abstract class HelpControllerBase
implements RecognizedEventConsumer {
    protected final int eventId;

    public HelpControllerBase(int n) {
        this.eventId = n;
    }

    @Override
    public void onRecognizedEvent(int n) {
        if (this.eventId == n) {
            this.onHelp();
        }
    }

    protected abstract void onHelp() {
    }

    protected void fireEvent(int n) {
        ASLFrameworkFactory.getASLFrameworkAPI().getServices().getSystemEventDispatcher().createAndSubmitHMIEvent(n);
    }
}

