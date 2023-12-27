/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.speechengine.result.router;

import de.vw.mib.genericevents.EventGeneric;

public interface ModelEventConsumer {
    default public void onEvent(EventGeneric eventGeneric) {
    }
}

