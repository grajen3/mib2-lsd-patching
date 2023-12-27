/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.media.services.sources;

import de.vw.mib.asl.api.media.services.Callback;
import de.vw.mib.asl.api.media.services.sources.SourceId;

public interface MediaEjectionService {
    default public void eject(SourceId sourceId, Callback callback) {
    }
}

