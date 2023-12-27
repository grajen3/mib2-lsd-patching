/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system.input;

import de.vw.mib.event.dispatcher.SystemEventDispatcher;
import de.vw.mib.input.InputManagerListener;

public class UserInteractionNotifier
implements InputManagerListener {
    private final SystemEventDispatcher systemEventDispatcher;
    private boolean userInteractionStarted;

    public UserInteractionNotifier(SystemEventDispatcher systemEventDispatcher) {
        this.systemEventDispatcher = systemEventDispatcher;
    }

    @Override
    public void userInteractionStarted(int n, int n2) {
        if (!this.userInteractionStarted && n == 1) {
            this.systemEventDispatcher.createAndSubmitHMIEvent(386);
            this.userInteractionStarted = true;
        }
    }

    @Override
    public void userInteractionStopped(int n, int n2) {
        if (this.userInteractionStarted && n == 1) {
            this.systemEventDispatcher.createAndSubmitHMIEvent(387);
            this.userInteractionStarted = false;
        }
    }
}

