/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.marshalling;

import de.vw.mib.bap.datatypes.BAPEntity;

public interface BAPIndicationMarshaller {
    default public void resultEntity(int n, BAPEntity bAPEntity) {
    }

    default public void statusEntity(int n, BAPEntity bAPEntity) {
    }

    default public void changedEntity(int n, BAPEntity bAPEntity) {
    }

    default public void statusAckEntity(int n, BAPEntity bAPEntity) {
    }

    default public void error(int n, int n2) {
    }
}

