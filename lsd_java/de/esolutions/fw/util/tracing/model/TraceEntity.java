/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.model;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityType;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.entity.TraceEntityURIWithLevel;
import de.esolutions.fw.util.tracing.model.ExternalTraceEntity;

public class TraceEntity
implements ITraceEntity {
    private final String name;
    private final TraceEntityURI uri;
    private short createFilterLevel;
    private short configFilterLevel;
    private short frontendFilterLevel;
    private short frontendLastFilterLevel;
    private short coreFilterLevel;
    private TraceEntity parent;
    private int createEpoch;
    private int changeEpoch;
    private final short[] backendLevels;
    private Object attachment;
    private String localPathCache;
    private String pathCache;
    private TraceEntity firstChild;
    private TraceEntity nextChild;

    public TraceEntity(int n, TraceEntityURI traceEntityURI, String string, short s, short s2, int n2) {
        this.name = string;
        this.uri = traceEntityURI;
        this.configFilterLevel = s2;
        this.createFilterLevel = s;
        this.frontendFilterLevel = s;
        this.coreFilterLevel = (short)6;
        this.frontendLastFilterLevel = (short)7;
        this.createEpoch = n;
        this.backendLevels = new short[n2];
    }

    public void addChild(TraceEntity traceEntity) {
        TraceEntity traceEntity2 = this.firstChild;
        this.firstChild = traceEntity;
        traceEntity.setNextChild(traceEntity2);
    }

    public void setNextChild(TraceEntity traceEntity) {
        this.nextChild = traceEntity;
    }

    public TraceEntity findChild(String string, short s) {
        if (this.firstChild == null) {
            return null;
        }
        return this.firstChild.findSibling(string, s);
    }

    public TraceEntity findSibling(String string, short s) {
        TraceEntity traceEntity = this;
        while (traceEntity != null) {
            if (traceEntity.getName().equals(string) && traceEntity.getURI().getType() == s) {
                return traceEntity;
            }
            traceEntity = traceEntity.nextChild;
        }
        return null;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public TraceEntity findParent(short s) {
        for (TraceEntity traceEntity = (TraceEntity)this.getParent(); traceEntity != null; traceEntity = (TraceEntity)traceEntity.getParent()) {
            if (traceEntity.getURI().getType() != s) continue;
            return traceEntity;
        }
        return null;
    }

    public int getPathLength(boolean bl) {
        short s = this.getURI().getType();
        int n = 0;
        for (TraceEntity traceEntity = this; !(traceEntity == null || bl && traceEntity.getURI().getType() != s); traceEntity = (TraceEntity)traceEntity.getParent()) {
            ++n;
        }
        return n;
    }

    public TraceEntity[] getPathEntities(boolean bl) {
        int n = this.getPathLength(bl);
        TraceEntity[] traceEntityArray = new TraceEntity[n];
        TraceEntity traceEntity = this;
        int n2 = n - 1;
        for (int i2 = 0; i2 < n; ++i2) {
            traceEntityArray[n2] = traceEntity;
            traceEntity = (TraceEntity)traceEntity.getParent();
            --n2;
        }
        return traceEntityArray;
    }

    public String getPath(boolean bl) {
        if (bl) {
            if (this.localPathCache != null) {
                return this.localPathCache;
            }
        } else if (this.pathCache != null) {
            return this.pathCache;
        }
        TraceEntity[] traceEntityArray = this.getPathEntities(bl);
        Buffer buffer = new Buffer();
        int n = traceEntityArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            String string = traceEntityArray[i2].getName();
            buffer.append(string);
            if (string.length() <= 0 || i2 >= n - 1) continue;
            buffer.append(".");
        }
        String string = buffer.toString();
        if (bl) {
            this.localPathCache = string;
        } else {
            this.pathCache = string;
        }
        return string;
    }

    @Override
    public TraceEntityURI getURI() {
        return this.uri;
    }

    public TraceEntityURIWithLevel getURIWithFrontendLevel() {
        return new TraceEntityURIWithLevel(this.uri, this.frontendFilterLevel);
    }

    @Override
    public int getCreateEpoch() {
        return this.createEpoch;
    }

    public void setChangeEpoch(int n) {
        this.changeEpoch = n;
    }

    public int getChangeEpoch() {
        return this.changeEpoch;
    }

    public short getConfigFilterLevel() {
        return this.configFilterLevel;
    }

    public short getCreateFilterLevel() {
        return this.createFilterLevel;
    }

    @Override
    public short getFrontendFilterLevel() {
        return this.frontendFilterLevel;
    }

    public void setFrontendFilterLevel(short s) {
        this.frontendFilterLevel = s;
    }

    public short disable() {
        this.frontendLastFilterLevel = this.frontendFilterLevel;
        this.frontendFilterLevel = (short)8;
        return this.frontendFilterLevel;
    }

    public short enable() {
        if (this.frontendLastFilterLevel != 7) {
            this.frontendFilterLevel = this.frontendLastFilterLevel;
        }
        return this.frontendFilterLevel;
    }

    public boolean isEnabled() {
        return this.frontendFilterLevel != 8;
    }

    public void setCoreFilterLevel(short s) {
        this.coreFilterLevel = s;
    }

    @Override
    public short getCoreFilterLevel() {
        return this.coreFilterLevel;
    }

    public void setParent(TraceEntity traceEntity) {
        this.parent = traceEntity;
    }

    @Override
    public ITraceEntity getParent() {
        return this.parent;
    }

    @Override
    public TraceEntityURI getParentURI() {
        if (this.parent == null) {
            return null;
        }
        return this.parent.getURI();
    }

    public void setBackendLevel(int n, short s) {
        this.backendLevels[n] = s;
    }

    public short getBackendLevel(int n) {
        return this.backendLevels[n];
    }

    public String toString() {
        return new StringBuffer().append("[").append(this.uri.getId()).append(":").append(this.name).append(",").append(TraceEntityType.names[this.uri.getType()]).append(",frontend=").append(TraceLevels.levelNames[this.frontendFilterLevel]).append(",core=").append(TraceLevels.levelNames[this.coreFilterLevel]).append(",create=").append(TraceLevels.levelNames[this.createFilterLevel]).append(",config=").append(TraceLevels.levelNames[this.configFilterLevel]).append(",").append(this.parent == null ? "none" : this.parent.getName()).append(",epoch=").append(this.createEpoch).append("]").toString();
    }

    public void setAttachment(Object object) {
        this.attachment = object;
    }

    public Object getAttachment() {
        return this.attachment;
    }

    @Override
    public IExternalTraceEntity createExternalCoreEntity() {
        return new ExternalTraceEntity(this.name, this.uri, this.coreFilterLevel, this.parent == null ? null : this.parent.getURI());
    }
}

