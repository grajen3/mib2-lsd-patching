/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.collections.ints.IntIntMap;
import de.vw.mib.collections.ints.IntSet;
import java.util.Map;

public interface SourcesPersistence
extends Persistable {
    default public int getMediaType() {
    }

    default public void setMediaType(int n) {
    }

    default public IntIntMap getPartitionLSM() {
    }

    default public IntSet getDatabaseFullReported() {
    }

    default public Map getDeflowered() {
    }

    default public int getObjectId() {
    }

    default public void setObjectId(int n) {
    }
}

