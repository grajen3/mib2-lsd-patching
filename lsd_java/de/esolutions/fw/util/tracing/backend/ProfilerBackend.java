/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.backend.AbstractTraceBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityType;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.profile.TraceProfiler;

public class ProfilerBackend
extends AbstractTraceBackend {
    private long beginTime;
    private long endTime;
    private int connects;
    private int disconnects;
    private int numEntities;
    private int[] numEntitiesPerType;
    private TraceProfiler profiler;

    public ProfilerBackend() {
        super("Profiling");
    }

    @Override
    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        super.init(s, iTraceBackendListener, traceConfigBackend);
        System.out.println("Enabled trace profiling...");
        this.profiler = new TraceProfiler();
        this.numEntitiesPerType = new int[6];
        this.resetStats();
    }

    private void resetStats() {
        this.connects = 0;
        this.disconnects = 0;
        this.numEntities = 0;
        for (int i2 = 0; i2 < 6; ++i2) {
            this.numEntitiesPerType[i2] = 0;
        }
        this.beginTime = System.currentTimeMillis();
        this.profiler.reset();
    }

    @Override
    public void exit() {
        super.exit();
        this.endTime = System.currentTimeMillis();
        this.dumpStats();
    }

    @Override
    public void handleBreak() {
        super.handleBreak();
        this.dumpStats();
    }

    @Override
    public boolean connect() {
        boolean bl = super.connect();
        ++this.connects;
        return bl;
    }

    @Override
    public void disconnect() {
        super.disconnect();
        ++this.disconnects;
    }

    @Override
    public boolean createEntity(ITraceEntity iTraceEntity) {
        boolean bl = super.createEntity(iTraceEntity);
        ++this.numEntities;
        short s = iTraceEntity.getURI().getType();
        this.numEntitiesPerType[s] = this.numEntitiesPerType[s] + 1;
        return bl;
    }

    private void dumpStats() {
        System.out.println("--- Profiling Results ---");
        long l = this.endTime - this.beginTime;
        System.out.println(new StringBuffer().append("Duration:  ").append(l).append(" ms").toString());
        System.out.println(new StringBuffer().append("Connect:   got=").append(this.connects).append(", lost=").append(this.disconnects).toString());
        System.out.print(new StringBuffer().append("Entities:  created=").append(this.numEntities).toString());
        for (int i2 = 0; i2 < 6; ++i2) {
            System.out.print(new StringBuffer().append(", ").append(TraceEntityType.names[i2]).append(": ").append(this.numEntitiesPerType[i2]).toString());
        }
        System.out.println();
        this.profiler.report(System.out);
    }

    @Override
    public boolean log(ITraceMessage iTraceMessage) {
        this.profiler.accountMessage(iTraceMessage);
        return true;
    }

    @Override
    public boolean droppedMessages(int n) {
        this.profiler.accountDrop(n);
        return true;
    }
}

