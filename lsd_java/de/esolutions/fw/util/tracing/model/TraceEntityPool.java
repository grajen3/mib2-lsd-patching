/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.model;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class TraceEntityPool {
    private TraceEntity[] data;
    private int size;
    private int capacity;
    private int numBackends;
    private TraceEntity firstRoot;

    public TraceEntityPool(int n, int n2) {
        this.data = new TraceEntity[n];
        this.size = 0;
        this.capacity = n;
        this.numBackends = n2;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        for (int i2 = 0; i2 < this.size; ++i2) {
            TraceEntity traceEntity = this.data[i2];
            buffer.append(new StringBuffer().append(traceEntity.toString()).append("\n").toString());
        }
        return buffer.toString();
    }

    public int size() {
        return this.size;
    }

    public TraceEntity getById(int n) {
        if (n < 0 || n >= this.capacity) {
            return null;
        }
        return this.data[n];
    }

    public TraceEntity getByURI(TraceEntityURI traceEntityURI) {
        int n = traceEntityURI.getId();
        if (n < 0 || n >= this.capacity) {
            return null;
        }
        TraceEntity traceEntity = this.data[n];
        if (traceEntity == null) {
            return null;
        }
        if (traceEntity.getURI().getType() == traceEntityURI.getType()) {
            return traceEntity;
        }
        return null;
    }

    private void grow(int n) {
        TraceEntity[] traceEntityArray = this.data;
        int n2 = this.capacity;
        this.capacity += n;
        this.data = new TraceEntity[this.capacity];
        System.arraycopy((Object)traceEntityArray, 0, (Object)this.data, 0, n2);
    }

    public TraceEntity createEntity(int n, short s, String string, short s2, short s3, TraceEntity traceEntity, Object object) {
        if (this.size + 1 >= this.capacity) {
            this.grow(256);
        }
        int n2 = this.size++;
        TraceEntityURI traceEntityURI = new TraceEntityURI(s, n2);
        TraceEntity traceEntity2 = new TraceEntity(n, traceEntityURI, string, s2, s3, this.numBackends);
        traceEntity2.setParent(traceEntity);
        traceEntity2.setAttachment(object);
        this.data[n2] = traceEntity2;
        if (traceEntity == null) {
            this.addRootEntity(traceEntity2);
        } else {
            traceEntity.addChild(traceEntity2);
        }
        return traceEntity2;
    }

    public boolean enableEntity(int n, int n2) {
        if (n2 < 0 || n2 >= this.capacity) {
            return false;
        }
        TraceEntity traceEntity = this.data[n2];
        if (traceEntity == null) {
            return false;
        }
        traceEntity.enable();
        return true;
    }

    public boolean disableEntity(int n, int n2) {
        if (n2 < 0 || n2 >= this.capacity) {
            return false;
        }
        TraceEntity traceEntity = this.data[n2];
        if (traceEntity == null) {
            return false;
        }
        traceEntity.disable();
        return true;
    }

    public String getNameForId(int n) {
        if (n < 0 || n >= this.capacity) {
            return null;
        }
        TraceEntity traceEntity = this.data[n];
        if (traceEntity == null) {
            return null;
        }
        return traceEntity.getName();
    }

    public TraceEntity[] getAllEntities() {
        if (this.size == 0) {
            return null;
        }
        TraceEntity[] traceEntityArray = new TraceEntity[this.size];
        System.arraycopy((Object)this.data, 0, (Object)traceEntityArray, 0, this.size);
        return traceEntityArray;
    }

    public TraceEntity[] getAllCreatedEntitiesInRange(int n, int n2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.size; ++i2) {
            TraceEntity traceEntity = this.data[i2];
            int n3 = traceEntity.getCreateEpoch();
            if (n3 < n || n3 > n2) continue;
            arrayList.add(traceEntity);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Object[] objectArray = new TraceEntity[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    public TraceEntity[] getAllChangedOnlyEntitiesInRange(int n, int n2) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.size; ++i2) {
            int n3;
            TraceEntity traceEntity = this.data[i2];
            int n4 = traceEntity.getChangeEpoch();
            if (n4 < n || n4 > n2 || (n3 = traceEntity.getCreateEpoch()) >= n) continue;
            arrayList.add(traceEntity);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        Object[] objectArray = new TraceEntity[arrayList.size()];
        arrayList.toArray(objectArray);
        return objectArray;
    }

    private void addRootEntity(TraceEntity traceEntity) {
        TraceEntity traceEntity2 = this.firstRoot;
        this.firstRoot = traceEntity;
        traceEntity.setNextChild(traceEntity2);
    }

    public TraceEntity findRootEntity(String string, short s) {
        if (this.firstRoot == null) {
            return null;
        }
        return this.firstRoot.findSibling(string, s);
    }

    public void writeSemFile(String string, String string2) {
        FileOutputStream fileOutputStream = new FileOutputStream(string);
        PrintStream printStream = new PrintStream(fileOutputStream, true, "UTF-8");
        printStream.println(new StringBuffer().append("0 1 -1 ").append(string2).toString());
        for (int i2 = 0; i2 < this.data.length; ++i2) {
            TraceEntity traceEntity = this.data[i2];
            if (traceEntity == null) continue;
            int n = traceEntity.getURI().getId();
            short s = traceEntity.getURI().getType();
            int n2 = -1;
            ITraceEntity iTraceEntity = traceEntity.getParent();
            if (iTraceEntity != null) {
                n2 = iTraceEntity.getURI().getId();
            }
            printStream.println(new StringBuffer().append(++n).append(" ").append(s).append(" ").append(++n2).append(" ").append(traceEntity.getName()).toString());
        }
        printStream.close();
    }
}

