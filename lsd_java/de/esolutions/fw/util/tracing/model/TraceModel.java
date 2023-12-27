/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.model;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import de.esolutions.fw.util.tracing.model.TraceEntityPool;

public class TraceModel {
    private TraceEntityPool pool;

    public TraceModel(short s, int n) {
        this.pool = new TraceEntityPool(s, n);
    }

    public synchronized String toString() {
        Buffer buffer = new Buffer();
        buffer.append(this.pool);
        return buffer.toString();
    }

    public synchronized boolean matchChannelAndThread(short s, int n, int n2) {
        TraceEntity traceEntity = this.pool.getById(n);
        TraceEntity traceEntity2 = this.pool.getById(n2);
        if (traceEntity == null || traceEntity2 == null) {
            return false;
        }
        return traceEntity.getFrontendFilterLevel() <= s && traceEntity2.getFrontendFilterLevel() <= s;
    }

    public synchronized TraceEntity getEntity(TraceEntityURI traceEntityURI) {
        TraceEntity traceEntity = this.pool.getByURI(traceEntityURI);
        if (traceEntity != null) {
            if (traceEntity.getURI().getType() == traceEntityURI.getType()) {
                return traceEntity;
            }
            return null;
        }
        return traceEntity;
    }

    public synchronized TraceEntity[] getAllEntities(short s) {
        return this.pool.getAllEntities();
    }

    public synchronized TraceEntity[] getAllCreatedEntitiesInRange(int n, int n2) {
        return this.pool.getAllCreatedEntitiesInRange(n, n2);
    }

    public synchronized TraceEntity[] getAllChangedOnlyEntitiesInRange(int n, int n2) {
        return this.pool.getAllChangedOnlyEntitiesInRange(n, n2);
    }

    public synchronized TraceEntity createEntity(int n, short s, String string, short s2, short s3, TraceEntityURI traceEntityURI, Object object) {
        TraceEntity traceEntity = null;
        if (traceEntityURI != null) {
            traceEntity = this.pool.getByURI(traceEntityURI);
        }
        TraceEntity traceEntity2 = null;
        traceEntity2 = traceEntity == null ? this.pool.findRootEntity(string, s) : traceEntity.findChild(string, s);
        if (traceEntity2 != null) {
            traceEntity2.setFrontendFilterLevel(s2);
            traceEntity2.setChangeEpoch(n);
            return traceEntity2;
        }
        traceEntity2 = this.pool.createEntity(n, s, string, s2, s3, traceEntity, object);
        return traceEntity2;
    }

    public synchronized void writeSemFile(String string, String string2) {
        this.pool.writeSemFile(string, string2);
    }
}

