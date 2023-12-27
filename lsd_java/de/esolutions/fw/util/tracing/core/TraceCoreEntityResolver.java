/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import de.esolutions.fw.util.tracing.model.TraceModel;

public class TraceCoreEntityResolver
implements ITraceEntityResolver {
    private TraceModel model;

    public TraceCoreEntityResolver(TraceModel traceModel) {
        this.model = traceModel;
    }

    @Override
    public String resolveName(TraceEntityURI traceEntityURI) {
        TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
        if (traceEntity != null) {
            return traceEntity.getName();
        }
        return null;
    }

    @Override
    public String resolveParentName(TraceEntityURI traceEntityURI, short s) {
        TraceEntity traceEntity;
        TraceEntity traceEntity2 = this.model.getEntity(traceEntityURI);
        if (traceEntity2 != null && (traceEntity = traceEntity2.findParent(s)) != null) {
            return traceEntity.getName();
        }
        return null;
    }

    @Override
    public String resolvePath(TraceEntityURI traceEntityURI, boolean bl) {
        TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
        if (traceEntity != null) {
            return traceEntity.getPath(bl);
        }
        return null;
    }
}

