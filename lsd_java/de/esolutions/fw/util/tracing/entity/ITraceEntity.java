/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.entity;

import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;

public interface ITraceEntity {
    default public String getName() {
    }

    default public TraceEntityURI getURI() {
    }

    default public TraceEntityURI getParentURI() {
    }

    default public short getFrontendFilterLevel() {
    }

    default public ITraceEntity getParent() {
    }

    default public int getCreateEpoch() {
    }

    default public short getCoreFilterLevel() {
    }

    default public IExternalTraceEntity createExternalCoreEntity() {
    }
}

