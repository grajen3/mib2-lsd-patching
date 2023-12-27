/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.diagnosis;

import de.vw.mib.asl.framework.api.diagnosis.config.Access;

public interface AdaptionResponse {
    default public void onSuccess(Access access) {
    }

    default public void onError() {
    }
}

