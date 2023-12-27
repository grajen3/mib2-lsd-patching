/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.messenger.application;

import de.vw.mib.asl.api.speechengine.messenger.application.ApplicationStateConsumer;

public interface ApplicationStateRouter {
    default public void register(ApplicationStateConsumer applicationStateConsumer) {
    }

    default public void unregister(ApplicationStateConsumer applicationStateConsumer) {
    }

    default public int getApplicationState() {
    }
}

