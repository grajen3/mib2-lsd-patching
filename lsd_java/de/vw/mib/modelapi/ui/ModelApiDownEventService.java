/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.modelapi.ui;

import de.vw.mib.modelapi.ModelApiDownEvent;

public interface ModelApiDownEventService {
    default public ModelApiDownEvent createEvent(int n) {
    }

    default public void sendEvent(ModelApiDownEvent modelApiDownEvent) {
    }
}

