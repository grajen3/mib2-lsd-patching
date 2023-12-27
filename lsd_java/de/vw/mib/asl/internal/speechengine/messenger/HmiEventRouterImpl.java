/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.speechengine.messenger;

import de.vw.mib.asl.internal.speechengine.messenger.HmiEventPublisher;
import de.vw.mib.event.dispatcher.SystemEventDispatcher;

public class HmiEventRouterImpl
implements HmiEventPublisher {
    private final SystemEventDispatcher systemEventDispatcher;

    public HmiEventRouterImpl(SystemEventDispatcher systemEventDispatcher) {
        this.systemEventDispatcher = systemEventDispatcher;
    }

    @Override
    public void publishHmiEvent(int n, int n2) {
        this.systemEventDispatcher.createAndSubmitHMIEvent(n2);
    }
}

