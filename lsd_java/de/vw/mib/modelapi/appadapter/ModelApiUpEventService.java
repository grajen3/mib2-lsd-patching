/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.modelapi.appadapter;

import de.vw.mib.modelapi.ModelApiUpEvent;

public interface ModelApiUpEventService {
    default public ModelApiUpEvent createEvent(int n) {
    }

    default public void sendEvent(ModelApiUpEvent modelApiUpEvent) {
    }
}

