/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.exlap;

import de.vw.mib.asl.api.exlap.callback.ExlapExternalAppsUpdate;

public interface ExlapService {
    default public void registerExlapExternalAppsUpdates(ExlapExternalAppsUpdate exlapExternalAppsUpdate) {
    }
}

