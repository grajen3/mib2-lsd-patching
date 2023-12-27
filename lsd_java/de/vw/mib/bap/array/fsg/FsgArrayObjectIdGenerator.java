/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.array.fsg;

import de.vw.mib.bap.array.fsg.FsgArrayObjectId;

public interface FsgArrayObjectIdGenerator {
    default public FsgArrayObjectId createObjectID(Object object, int n) {
    }

    default public boolean compareObjectID(FsgArrayObjectId fsgArrayObjectId, Object object) {
    }
}

