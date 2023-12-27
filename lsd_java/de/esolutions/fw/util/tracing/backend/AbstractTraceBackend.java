/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.backend;

import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.config.TraceConfigLevels;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.model.TraceEntity;

public abstract class AbstractTraceBackend
implements ITraceBackend {
    protected ITraceBackendListener listener;
    protected TraceConfigBackend config;
    protected TraceConfigLevels levels;
    protected String backendName;
    protected short bid;

    public AbstractTraceBackend(String string) {
        this.backendName = string;
        this.bid = (short)-1;
    }

    @Override
    public void init(short s, ITraceBackendListener iTraceBackendListener, TraceConfigBackend traceConfigBackend) {
        this.listener = iTraceBackendListener;
        this.bid = s;
        this.config = traceConfigBackend;
        if (this.config != null) {
            this.levels = this.config.getLevels();
        }
    }

    @Override
    public void exit() {
    }

    @Override
    public String getName() {
        return this.backendName;
    }

    @Override
    public int getFlags() {
        return 1;
    }

    @Override
    public boolean adjustToChangeLevel(ITraceEntity iTraceEntity) {
        return false;
    }

    @Override
    public short backendFilterLevel(ITraceEntity iTraceEntity) {
        if (this.levels != null) {
            TraceEntity traceEntity = (TraceEntity)iTraceEntity;
            String string = traceEntity.getPath(true);
            return this.levels.getTraceLevel(iTraceEntity.getURI().getType(), string);
        }
        return 7;
    }

    @Override
    public short backendDefaultFilterLevel(short s) {
        if (this.levels != null) {
            return this.levels.getDefaultTraceLevel(s);
        }
        return 7;
    }

    @Override
    public boolean createEntity(ITraceEntity iTraceEntity) {
        this.listener.logMessage(this.bid, new StringBuffer().append("createEntity uri=").append(iTraceEntity.getURI()).append(" name=").append(iTraceEntity.getName()).append(" level=").append(TraceLevels.levelNames[iTraceEntity.getCoreFilterLevel()]).toString());
        return true;
    }

    @Override
    public boolean changeFilterLevel(TraceEntityURI traceEntityURI, short s) {
        this.listener.logMessage(this.bid, new StringBuffer().append("changeFilterLevel: uri=").append(traceEntityURI).append(" level=").append(s).toString());
        return true;
    }

    @Override
    public boolean connect() {
        this.listener.logMessage(this.bid, "--- connect ---");
        this.listener.connected(this.bid, true);
        return true;
    }

    @Override
    public void disconnect() {
        this.listener.logMessage(this.bid, "--- disconnect ---");
        this.listener.disconnected(this.bid);
    }

    @Override
    public boolean droppedMessages(int n) {
        this.listener.logMessage(this.bid, new StringBuffer().append("DROPPED ").append(n).append(" MESSAGES").toString());
        return true;
    }

    @Override
    public void handleBreak() {
        this.listener.logMessage(this.bid, "*** BREAK ***");
    }

    @Override
    public boolean registerTimeZone(int n, int n2, String string) {
        this.listener.logMessage(this.bid, new StringBuffer().append("registerTimeZone: id=").append(n).append(" res=").append(n2).append(" name=").append(string).toString());
        return true;
    }

    @Override
    public boolean updateTimeZone(int n, long l, long l2) {
        this.listener.logMessage(this.bid, new StringBuffer().append("updateTimeZone: id=").append(n).append(" tz=").append(l).append(" core=").append(l2).toString());
        return true;
    }

    @Override
    public ITraceMessage logBulk(ITraceMessage[] iTraceMessageArray) {
        this.listener.logMessage(this.bid, new StringBuffer().append("logBulk: num=").append(iTraceMessageArray.length).toString());
        return null;
    }

    @Override
    public boolean createEntityBulk(ITraceEntity[] iTraceEntityArray) {
        this.listener.logMessage(this.bid, new StringBuffer().append("createEntityBulk: num=").append(iTraceEntityArray.length).toString());
        return true;
    }

    @Override
    public boolean changeFilterLevelBulk(ITraceEntity[] iTraceEntityArray) {
        this.listener.logMessage(this.bid, new StringBuffer().append("changeFilterLevelBulk: num=").append(iTraceEntityArray.length).toString());
        return true;
    }
}

