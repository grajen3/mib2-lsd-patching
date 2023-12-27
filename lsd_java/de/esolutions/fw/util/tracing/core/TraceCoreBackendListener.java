/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.config.TraceConfigFormatter;
import de.esolutions.fw.util.tracing.core.TraceCore;
import de.esolutions.fw.util.tracing.core.TraceCoreEntityResolver;
import de.esolutions.fw.util.tracing.core.TraceCoreWorker;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.format.ITraceEntityResolver;
import de.esolutions.fw.util.tracing.format.ITraceMessageFormatter;
import de.esolutions.fw.util.tracing.format.MessageFormatterRegistry;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import de.esolutions.fw.util.tracing.model.TraceModel;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZone;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZonePool;
import java.util.HashMap;
import java.util.Map;

public class TraceCoreBackendListener
implements ITraceBackendListener {
    private TraceCoreWorker worker;
    private TraceConfig config;
    private TraceModel model;
    private TraceTimeZonePool timeZonePool;
    private TraceCoreEntityResolver resolver;
    private Map formatterConfigs;
    private TraceCore core;

    public TraceCoreBackendListener(TraceCore traceCore) {
        this.core = traceCore;
        this.worker = traceCore.getWorker();
        this.config = traceCore.getConfig();
        this.model = traceCore.getModel();
        this.timeZonePool = traceCore.getTimeZonePool();
        this.resolver = new TraceCoreEntityResolver(this.model);
        TraceConfigFormatter[] traceConfigFormatterArray = this.config.getMessageFormatters();
        this.formatterConfigs = new HashMap();
        if (traceConfigFormatterArray != null) {
            for (int i2 = 0; i2 < traceConfigFormatterArray.length; ++i2) {
                TraceConfigFormatter traceConfigFormatter = traceConfigFormatterArray[i2];
                this.formatterConfigs.put(traceConfigFormatter.getName(), traceConfigFormatter);
            }
        }
    }

    @Override
    public void connected(short s, boolean bl) {
        this.worker.addConnectBackendCommand(s, bl);
    }

    @Override
    public void disconnected(short s) {
        this.worker.addDisconnectBackendCommand(s);
    }

    @Override
    public boolean triggerRequestFilterLevel(TraceEntityURI traceEntityURI, short s) {
        return this.worker.addRequestFilterLevelCommand(traceEntityURI, s);
    }

    @Override
    public boolean triggerExecuteCallback(int n, byte[] byArray) {
        return this.worker.addExecuteCallbackCommand(n, byArray);
    }

    @Override
    public short queryFilterLevel(TraceEntityURI traceEntityURI) {
        TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
        if (traceEntity == null) {
            return 7;
        }
        return traceEntity.getCoreFilterLevel();
    }

    @Override
    public void logMessage(short s, String string) {
        String string2 = this.worker.getController().getBackendKey(s);
        TraceMe.msg(TraceMe.TRACE, "CoreListener", "%1: %2", string2, string);
    }

    @Override
    public int getCoreMaxEntities() {
        return this.config.getEntityPoolSize();
    }

    @Override
    public String getCoreId() {
        return this.config.getId();
    }

    @Override
    public void requestQuit() {
        this.worker.addRequestQuitCommand();
    }

    @Override
    public ITraceMessageFormatter createFormatter(String string, boolean bl) {
        TraceConfigFormatter traceConfigFormatter = (TraceConfigFormatter)this.formatterConfigs.get(string);
        ITraceMessageFormatter iTraceMessageFormatter = null;
        if (traceConfigFormatter != null) {
            iTraceMessageFormatter = traceConfigFormatter.createInstance();
        }
        if (bl && iTraceMessageFormatter == null) {
            iTraceMessageFormatter = MessageFormatterRegistry.getInstance().createFormatter("DefaultFormatter");
        }
        return iTraceMessageFormatter;
    }

    @Override
    public ITraceEntityResolver getEntityResolver() {
        return this.resolver;
    }

    @Override
    public String getTimeZoneName(int n) {
        TraceTimeZone traceTimeZone = this.timeZonePool.getTimeZone(n);
        if (traceTimeZone != null) {
            return traceTimeZone.getName();
        }
        return null;
    }

    @Override
    public Object getComponent(String string) {
        return this.core.getComponent(string);
    }
}

