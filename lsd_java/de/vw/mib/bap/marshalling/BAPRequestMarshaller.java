/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

import de.vw.mib.bap.datatypes.BAPEntity;

public interface BAPRequestMarshaller {
    default public void startResult(int n, BAPEntity bAPEntity) {
    }

    default public void abortResult(int n, BAPEntity bAPEntity) {
    }

    default public void getEntity(int n, BAPEntity bAPEntity) {
    }

    default public void setGetEntity(int n, BAPEntity bAPEntity) {
    }

    default public void ackEntity(int n, BAPEntity bAPEntity) {
    }
}

