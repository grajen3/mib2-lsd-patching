/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.backend.AbstractTraceBackend;
import de.esolutions.fw.util.tracing.backend.BackendRegistry;
import de.esolutions.fw.util.tracing.backend.CommandShellBackend;
import de.esolutions.fw.util.tracing.backend.ConsoleBackend;
import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.RegisterBackendCommand;
import de.esolutions.fw.util.tracing.command.UnregisterBackendCommand;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.config.TraceConfigDecoder;
import de.esolutions.fw.util.tracing.config.TraceConfigLevels;
import de.esolutions.fw.util.tracing.config.TraceConfigPlugin;
import de.esolutions.fw.util.tracing.core.ITraceCoreErrorHandler;
import de.esolutions.fw.util.tracing.core.TraceCoreStats;
import de.esolutions.fw.util.tracing.core.TraceCoreWorker;
import de.esolutions.fw.util.tracing.core.TraceSpeedLimiter;
import de.esolutions.fw.util.tracing.decode.ITraceMessageDecoder;
import de.esolutions.fw.util.tracing.decode.MessageDecoderRegistry;
import de.esolutions.fw.util.tracing.decode.StringMessageDecoder;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.entity.TraceEntityURIWithLevel;
import de.esolutions.fw.util.tracing.format.MessageFormatterRegistry;
import de.esolutions.fw.util.tracing.frontend.ITraceFrontendListener;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.message.TraceMessageBuffer;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import de.esolutions.fw.util.tracing.model.TraceModel;
import de.esolutions.fw.util.tracing.plugin.ITracePlugin;
import de.esolutions.fw.util.tracing.plugin.PluginRegistry;
import de.esolutions.fw.util.tracing.timezone.TraceTimeTuple;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZone;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZonePool;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;

public class TraceCore {
    private final TraceFrontend frontend;
    private final TraceConfig config;
    private TraceMessageBuffer buffer;
    private TraceModel model;
    private TraceTimeZonePool timeZonePool;
    private TraceConfigLevels levels;
    private List listeners;
    private TraceCoreWorker worker;
    private TraceCoreStats stats;
    private List postponedCommands;
    private int numOverwrites;
    private int coreEpoch;
    private boolean allowOverwrite;
    private Object coreEpochLock = new Object();
    private TraceEntityURIWithLevel[] rootEntities;
    private TraceSpeedLimiter speedLimiter;
    private int deferredSkipCount;
    private int msgFlushInterval;
    private int msgThreshold;
    private HashMap components = new HashMap();
    private ITracePlugin[] plugins;
    private ITraceCoreErrorHandler errorHandler;
    private static final String chn;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$remote$pull$RemoteListenBackendManagerPlugin;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$backend$ConsoleBackend;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$backend$CommandShellBackend;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$backend$FileBackend;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$backend$EmergencyRecorderBackend;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$remote$push$RemoteConnectBackend;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$remote$pull$RemoteListenBackend;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$remote$push$BinaryFileBackend;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$backend$NullBackend;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$backend$ProfilerBackend;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$decode$StringMessageDecoder;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$decode$HexDumpMessageDecoder;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$format$DefaultMessageFormatter;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$format$NoNameMessageFormatter;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$format$FancyMessageFormatter;

    public TraceCore(TraceFrontend traceFrontend, TraceConfig traceConfig) {
        int n = this.getInitialBufferSize(traceConfig);
        this.stats = new TraceCoreStats();
        this.buffer = new TraceMessageBuffer(n);
        this.model = new TraceModel((short)traceConfig.getEntityPoolSize(), traceConfig.getMaxBackends());
        this.timeZonePool = new TraceTimeZonePool(traceConfig.getMaxTimeZones());
        if (traceConfig.getFileTransfer() != null) {
            traceConfig.getFileTransfer().realize(this);
        }
        this.config = traceConfig;
        this.frontend = traceFrontend;
        this.listeners = new ArrayList();
        this.worker = null;
        this.coreEpoch = 0;
        this.allowOverwrite = traceConfig.getAllowOverwrite();
        this.postponedCommands = new ArrayList();
        this.levels = traceConfig.getLevels();
        this.msgFlushInterval = traceConfig.getMessageBufferFlushInterval();
        this.msgThreshold = traceConfig.getMessageBufferThreshold();
        this.rootEntities = new TraceEntityURIWithLevel[6];
        this.setupStats();
        this.setupSpeedLimiter();
        this.stats.updateKey("bs", n);
        this.stats.updateKey("es", traceConfig.getEntityPoolSize());
    }

    private int getInitialBufferSize(TraceConfig traceConfig) {
        int n = traceConfig.getMessageBufferStartupSize();
        int n2 = traceConfig.getMessageBufferSize();
        if (n > 0) {
            if (n < n2) {
                TraceMe.msg(TraceMe.WARN, "Core", "%1: startup buffer size invalid: %2 (size %3) -> ignoring!", traceConfig.getId(), new Integer(n), new Integer(n2));
                n = n2;
            }
        } else {
            n = n2;
        }
        TraceMe.msg(TraceMe.INFO, "Core", "%1: startup message buffer size=%2", traceConfig.getId(), new Integer(n));
        return n;
    }

    private void setupStats() {
        this.stats.registerKey("ec", 2);
        this.stats.registerKey("ef", 2);
        this.stats.registerKey("es", 0);
        this.stats.registerKey("mc", 6);
        this.stats.registerKey("mo", 6);
        this.stats.registerKey("tc", 2);
        this.stats.registerKey("to", 2);
        this.stats.registerKey("ts", 2);
        this.stats.registerKey("ti", 2);
        this.stats.registerKey("ds", 6);
        this.stats.registerKey("di", 6);
        this.stats.registerKey("ps", 6);
        this.stats.registerKey("bc", 12);
        this.stats.registerKey("bb", 12);
        this.stats.registerKey("bs", 0);
    }

    private void setupSpeedLimiter() {
        if (this.config.enforceSpeedLimit()) {
            Object object;
            boolean bl = true;
            String string = this.config.disableSpeedLimitFile();
            if (string != null && ((File)(object = new File(string))).exists()) {
                TraceMe.msg(TraceMe.WARN, "Core", "%1: speed limit was disabled by %2", this.config.getId(), string);
                bl = false;
            }
            if (bl) {
                object = TimeSourceProvider.getMonotonicTimeSource();
                this.speedLimiter = new TraceSpeedLimiter(this.config, this.stats, (ITimeSource)object);
            }
        }
    }

    public Object getComponent(String string) {
        return this.components.get(string);
    }

    public void setComponent(String string, Object object) {
        this.components.put(string, object);
    }

    public TraceMessageBuffer getMessageBuffer() {
        return this.buffer;
    }

    public TraceConfig getConfig() {
        return this.config;
    }

    public TraceFrontend getFrontend() {
        return this.frontend;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public List getFrontendListeners() {
        List list = this.listeners;
        synchronized (list) {
            ArrayList arrayList = new ArrayList(this.listeners);
            return arrayList;
        }
    }

    public TraceModel getModel() {
        return this.model;
    }

    public TraceCoreStats getStats() {
        return this.stats;
    }

    public TraceTimeZonePool getTimeZonePool() {
        return this.timeZonePool;
    }

    public TraceCoreWorker getWorker() {
        return this.worker;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void start() {
        this.numOverwrites = 0;
        this.deferredSkipCount = 0;
        this.worker = new TraceCoreWorker(this, this.stats);
        int n = this.getEpoch();
        this.worker.start(n);
        this.initMessageDecoderRegistry();
        this.initMessageFormatters();
        this.initBackendRegistry();
        this.initPluginRegistry();
        List list = this.postponedCommands;
        synchronized (list) {
            ListIterator listIterator = this.postponedCommands.listIterator();
            while (listIterator.hasNext()) {
                ITraceCommand iTraceCommand = (ITraceCommand)listIterator.next();
                this.worker.addCommand(iTraceCommand);
            }
        }
        this.setupBackends();
        this.setupMessageDecoders();
        this.setupPlugins();
        this.worker.addInitCommand();
    }

    public void stop() {
        if (this.worker == null) {
            return;
        }
        if (this.worker.isRunning()) {
            this.worker.stop();
        }
        this.worker = null;
        this.shutdownPlugins();
        int n = this.buffer.size();
        if (n > 0) {
            TraceMe.msg(TraceMe.WARN, "Core", "%1 messages left in buffer", new Integer(n));
        }
        if (this.numOverwrites > 0) {
            TraceMe.msg(TraceMe.WARN, "Core", "%1 messages were overwritten!", new Integer(this.numOverwrites));
        }
    }

    public boolean isRunning() {
        return this.worker != null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TraceEntityURIWithLevel createEntity(short s, String string, short s2, TraceEntityURI traceEntityURI, Object object) {
        this.stats.updateKey("ec", 1);
        if (traceEntityURI == null) {
            traceEntityURI = this.getRootEntity(s);
        }
        Object object2 = this.coreEpochLock;
        synchronized (object2) {
            short s3 = this.getConfigFilterLevel(s, string, traceEntityURI);
            short s4 = this.getCreateFilterLevel(s2, s3);
            TraceEntity traceEntity = this.model.createEntity(this.coreEpoch + 1, s, string, s4, s3, traceEntityURI, object);
            if (traceEntity == null) {
                return null;
            }
            ++this.coreEpoch;
            if (this.worker != null) {
                this.worker.addCreateEntityCommand(this.coreEpoch, traceEntity, s4);
            } else {
                traceEntity.setCoreFilterLevel(s4);
            }
            TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: create entity %2", new Integer(this.coreEpoch), traceEntity);
            return new TraceEntityURIWithLevel(traceEntity.getURI(), s4);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TraceEntityURIWithLevel getRootEntity(short s) {
        Object object = this.coreEpochLock;
        synchronized (object) {
            TraceEntityURIWithLevel traceEntityURIWithLevel;
            if (this.rootEntities[s] != null) {
                return this.rootEntities[s];
            }
            short s2 = this.getConfigFilterLevel(s, "", null);
            short s3 = this.getCreateFilterLevel((short)0, s2);
            TraceEntity traceEntity = this.model.createEntity(this.coreEpoch + 1, s, "", s3, s2, null, null);
            if (traceEntity == null) {
                return null;
            }
            ++this.coreEpoch;
            if (this.worker != null) {
                this.worker.addCreateEntityCommand(this.coreEpoch, traceEntity, s3);
            } else {
                traceEntity.setCoreFilterLevel(s3);
            }
            this.rootEntities[s] = traceEntityURIWithLevel = new TraceEntityURIWithLevel(traceEntity.getURI(), s3);
            TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: create root entity %2", new Integer(this.coreEpoch), traceEntity);
            return traceEntityURIWithLevel;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TraceEntityURIWithLevel getRootEntityNoCreate(short s) {
        Object object = this.coreEpochLock;
        synchronized (object) {
            if (this.rootEntities[s] != null) {
                return this.rootEntities[s];
            }
            return null;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public TraceEntityURI getParentEntity(TraceEntityURI traceEntityURI) {
        Object object = this.coreEpochLock;
        synchronized (object) {
            TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
            if (traceEntity == null) {
                return null;
            }
            return traceEntity.getParentURI();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean enableEntity(TraceEntityURI traceEntityURI) {
        Object object = this.coreEpochLock;
        synchronized (object) {
            TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
            if (traceEntity == null) {
                return false;
            }
            ++this.coreEpoch;
            short s = traceEntity.getFrontendFilterLevel();
            TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: enableEntity %2 level=%3", new Integer(this.coreEpoch), traceEntityURI, TraceLevels.levelNames[s]);
            short s2 = traceEntity.enable();
            traceEntity.setChangeEpoch(this.coreEpoch);
            if (this.worker != null) {
                this.worker.addChangeFilterLevelCommand(this.coreEpoch, traceEntity, s2);
            } else {
                traceEntity.setCoreFilterLevel(s2);
            }
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean disableEntity(TraceEntityURI traceEntityURI) {
        Object object = this.coreEpochLock;
        synchronized (object) {
            TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
            if (traceEntity == null) {
                return false;
            }
            ++this.coreEpoch;
            TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: disableEntity %2", new Integer(this.coreEpoch), traceEntityURI);
            short s = traceEntity.disable();
            traceEntity.setChangeEpoch(s);
            if (this.worker != null) {
                this.worker.addChangeFilterLevelCommand(this.coreEpoch, traceEntity, s);
            } else {
                traceEntity.setCoreFilterLevel(s);
            }
            return true;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean isEntityEnabled(TraceEntityURI traceEntityURI) {
        Object object = this.coreEpochLock;
        synchronized (object) {
            TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
            if (traceEntity == null) {
                return false;
            }
            return traceEntity.isEnabled();
        }
    }

    public boolean setAttachment(TraceEntityURI traceEntityURI, Object object) {
        TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
        if (traceEntity == null) {
            return false;
        }
        traceEntity.setAttachment(object);
        return true;
    }

    public Object getAttachment(TraceEntityURI traceEntityURI) {
        TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
        if (traceEntity == null) {
            return null;
        }
        return traceEntity.getAttachment();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private int getEpoch() {
        Object object = this.coreEpochLock;
        synchronized (object) {
            return this.coreEpoch;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean log(ITraceMessage iTraceMessage) {
        Object object;
        if (this.buffer == null) {
            return false;
        }
        if (!this.model.matchChannelAndThread(iTraceMessage.getLevel(), iTraceMessage.getChannelID(), iTraceMessage.getThreadID())) {
            return false;
        }
        int n = this.getEpoch();
        iTraceMessage.setEpoch(n);
        iTraceMessage.expandNow();
        if (this.speedLimiter != null) {
            object = this.speedLimiter;
            synchronized (object) {
                boolean bl = this.speedLimiter.check(iTraceMessage, this.deferredSkipCount > 0);
                if (!bl) {
                    TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: log message seq=%2 level=%3: dopped by speed limiter!", new Integer(n), new Integer(iTraceMessage.getSeqNum()), TraceLevels.levelNames[iTraceMessage.getLevel()]);
                    ++this.deferredSkipCount;
                    this.stats.updateKey("ds", 1);
                    this.stats.updateKey("ts", 1);
                    return false;
                }
                if (this.deferredSkipCount > 0) {
                    TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: speed limiter reports %2 skipped messsages", new Integer(n), new Integer(this.deferredSkipCount));
                    this.buffer.skipEntries(this.deferredSkipCount);
                    this.deferredSkipCount = 0;
                }
            }
        }
        this.stats.updateKey("mc", 1);
        this.stats.updateKey("tc", 1);
        this.stats.updateKey("ps", iTraceMessage.getMessageSize());
        if (!this.buffer.put(iTraceMessage, this.allowOverwrite)) {
            ++this.numOverwrites;
            this.stats.updateKey("mo", 1);
            this.stats.updateKey("to", 1);
        }
        object = this.buffer.getNumEntriesAndBytes();
        this.stats.updateKey("bc", (int)object[0]);
        this.stats.updateKey("bb", (int)object[1]);
        TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: log message %2", new Integer(n), iTraceMessage);
        if (this.worker != null && (this.msgFlushInterval == 0 || this.buffer.size() > this.msgThreshold || this.buffer.size() == this.buffer.capacity())) {
            this.worker.triggerMessageSignal();
        }
        return true;
    }

    public boolean reportLostMessages(int n) {
        if (this.buffer == null) {
            return false;
        }
        this.stats.updateKey("di", n);
        this.stats.updateKey("ti", n);
        this.buffer.skipEntries(n);
        return true;
    }

    public boolean flushMessages(boolean bl, long l) {
        int n = this.buffer.getCurrentSequenceNumber();
        return this.worker.flushMessages(n, bl, l);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean registerBackend(ITraceBackend iTraceBackend, TraceConfigBackend traceConfigBackend, String string) {
        if (this.worker != null) {
            return this.worker.addRegisterBackendCommand(iTraceBackend, traceConfigBackend, string);
        }
        List list = this.postponedCommands;
        synchronized (list) {
            this.postponedCommands.add(new RegisterBackendCommand(iTraceBackend, traceConfigBackend, string));
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean unregisterBackend(ITraceBackend iTraceBackend) {
        if (this.worker != null) {
            return this.worker.addUnregisterBackendCommand(iTraceBackend);
        }
        List list = this.postponedCommands;
        synchronized (list) {
            this.postponedCommands.add(new UnregisterBackendCommand(iTraceBackend));
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public boolean changeFilterLevel(TraceEntityURI traceEntityURI, short s) {
        this.stats.updateKey("ef", 1);
        Object object = this.coreEpochLock;
        synchronized (object) {
            TraceEntity traceEntity = this.model.getEntity(traceEntityURI);
            if (traceEntity == null) {
                return false;
            }
            short s2 = traceEntity.getFrontendFilterLevel();
            if (s2 == s) {
                TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: changeFilterLevel %2 %3 -> %4 unchanged!", new Integer(this.coreEpoch), traceEntityURI, TraceLevels.levelNames[s2], TraceLevels.levelNames[s]);
                return true;
            }
            ++this.coreEpoch;
            TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: changeFilterLevel %2 %3 -> %4", new Integer(this.coreEpoch), traceEntityURI, TraceLevels.levelNames[s2], TraceLevels.levelNames[s]);
            traceEntity.setFrontendFilterLevel(s);
            traceEntity.setChangeEpoch(this.coreEpoch);
            if (this.worker != null) {
                this.worker.addChangeFilterLevelCommand(this.coreEpoch, traceEntity, s);
            } else {
                traceEntity.setCoreFilterLevel(s);
            }
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int registerTimeZone(int n, String string) {
        Object object = this.coreEpochLock;
        synchronized (object) {
            int n2 = this.timeZonePool.getTimeZone(string);
            if (n2 != -1) {
                return n2;
            }
            TraceTimeZone traceTimeZone = this.timeZonePool.addTimeZone(n, string, this.coreEpoch + 1);
            if (traceTimeZone == null) {
                return -1;
            }
            n2 = traceTimeZone.getId();
            ++this.coreEpoch;
            if (this.worker != null) {
                this.worker.addRegisterTimeZoneCommand(this.coreEpoch, traceTimeZone);
            }
            TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: register time zone %2 name=%3 resolution=%4", new Integer(this.coreEpoch), new Integer(n2), string, new Integer(n));
            return n2;
        }
    }

    public boolean updateTimeZone(int n, long l, long l2) {
        TraceTimeZone traceTimeZone = this.timeZonePool.getTimeZone(n);
        if (traceTimeZone == null) {
            return false;
        }
        int n2 = this.getEpoch();
        TraceTimeTuple traceTimeTuple = new TraceTimeTuple(l, l2, n2);
        traceTimeZone.setLastUpdate(traceTimeTuple);
        if (this.worker != null) {
            this.worker.addUpdateTimeZoneCommand(traceTimeZone);
        }
        TraceMe.msg(TraceMe.DEBUG, "Core", "core:%1: update time zone %2 %3", new Integer(n2), new Integer(n), traceTimeTuple);
        return false;
    }

    public void emergencyBreak() {
        this.worker.triggerBreakSignal();
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void registerListener(ITraceFrontendListener iTraceFrontendListener) {
        List list = this.listeners;
        synchronized (list) {
            this.listeners.add(iTraceFrontendListener);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void unregisterListener(ITraceFrontendListener iTraceFrontendListener) {
        List list = this.listeners;
        synchronized (list) {
            this.listeners.remove(iTraceFrontendListener);
        }
    }

    private short getConfigFilterLevel(short s, String string, TraceEntityURI traceEntityURI) {
        short s2;
        String string2 = null;
        TraceEntity traceEntity = null;
        if (traceEntityURI != null && (traceEntity = this.model.getEntity(traceEntityURI)) != null) {
            string2 = traceEntity.getPath(true);
        }
        String string3 = string2 != null && string2.length() > 0 ? new StringBuffer().append(string2).append(".").append(string).toString() : string;
        TraceMe.msg(TraceMe.DEBUG, "Core", "     getConfigFilterLevel(%1) -> cfgPath=%2", string, string3);
        if (this.levels != null) {
            s2 = this.levels.getTraceLevel(s, string3);
            TraceMe.msg(TraceMe.DEBUG, "Core", "      from config: %1 (path=%2)", TraceLevels.levelNames[s2], string3);
            if (s2 == 7) {
                if (traceEntity != null) {
                    s2 = traceEntity.getConfigFilterLevel();
                    TraceMe.msg(TraceMe.DEBUG, "Core", "      from parent: %1", TraceLevels.levelNames[s2]);
                } else {
                    s2 = this.levels.getDefaultTraceLevel(s);
                    TraceMe.msg(TraceMe.DEBUG, "Core", "      from default config: %1", TraceLevels.levelNames[s2]);
                    if (s2 == 7) {
                        s2 = 0;
                        TraceMe.msg(TraceMe.DEBUG, "Core", "      from hard-coded default: %1", TraceLevels.levelNames[s2]);
                    }
                }
            }
        } else {
            s2 = 0;
            TraceMe.msg(TraceMe.DEBUG, "Core", "      from hard-coded default: %1", TraceLevels.levelNames[s2]);
        }
        return s2;
    }

    private short getCreateFilterLevel(short s, short s2) {
        if (s == 7) {
            s = 0;
        }
        if (s2 > s) {
            TraceMe.msg(TraceMe.DEBUG, "Core", "      create level (cfg): %1", TraceLevels.levelNames[s2]);
            return s2;
        }
        TraceMe.msg(TraceMe.DEBUG, "Core", "      create level (usr): %1", TraceLevels.levelNames[s]);
        return s;
    }

    private void initPluginRegistry() {
        PluginRegistry pluginRegistry = PluginRegistry.getInstance();
        pluginRegistry.register("RemoteListenBackendManager", class$de$esolutions$fw$util$tracing$remote$pull$RemoteListenBackendManagerPlugin == null ? (class$de$esolutions$fw$util$tracing$remote$pull$RemoteListenBackendManagerPlugin = TraceCore.class$("de.esolutions.fw.util.tracing.remote.pull.RemoteListenBackendManagerPlugin")) : class$de$esolutions$fw$util$tracing$remote$pull$RemoteListenBackendManagerPlugin);
    }

    private void setupPlugins() {
        TraceConfigPlugin[] traceConfigPluginArray = this.config.getPlugins();
        if (traceConfigPluginArray != null) {
            int n = traceConfigPluginArray.length;
            this.plugins = new ITracePlugin[n];
            for (int i2 = 0; i2 < n; ++i2) {
                ITracePlugin iTracePlugin;
                TraceConfigPlugin traceConfigPlugin = traceConfigPluginArray[i2];
                if (!traceConfigPlugin.isEnabled()) continue;
                this.plugins[i2] = iTracePlugin = traceConfigPlugin.createInstance();
                if (iTracePlugin == null) continue;
                iTracePlugin.start(this.frontend, traceConfigPlugin);
            }
        } else {
            this.plugins = null;
        }
    }

    private void shutdownPlugins() {
        if (this.plugins != null) {
            for (int i2 = 0; i2 < this.plugins.length; ++i2) {
                ITracePlugin iTracePlugin = this.plugins[i2];
                if (iTracePlugin == null) continue;
                iTracePlugin.stop();
            }
            this.plugins = null;
        }
    }

    private void initBackendRegistry() {
        BackendRegistry backendRegistry = BackendRegistry.getInstance();
        backendRegistry.register("ConsoleBackend", class$de$esolutions$fw$util$tracing$backend$ConsoleBackend == null ? (class$de$esolutions$fw$util$tracing$backend$ConsoleBackend = TraceCore.class$("de.esolutions.fw.util.tracing.backend.ConsoleBackend")) : class$de$esolutions$fw$util$tracing$backend$ConsoleBackend);
        backendRegistry.register("CommandShellBackend", class$de$esolutions$fw$util$tracing$backend$CommandShellBackend == null ? (class$de$esolutions$fw$util$tracing$backend$CommandShellBackend = TraceCore.class$("de.esolutions.fw.util.tracing.backend.CommandShellBackend")) : class$de$esolutions$fw$util$tracing$backend$CommandShellBackend);
        backendRegistry.register("FileBackend", class$de$esolutions$fw$util$tracing$backend$FileBackend == null ? (class$de$esolutions$fw$util$tracing$backend$FileBackend = TraceCore.class$("de.esolutions.fw.util.tracing.backend.FileBackend")) : class$de$esolutions$fw$util$tracing$backend$FileBackend);
        backendRegistry.register("EmergencyRecorderBackend", class$de$esolutions$fw$util$tracing$backend$EmergencyRecorderBackend == null ? (class$de$esolutions$fw$util$tracing$backend$EmergencyRecorderBackend = TraceCore.class$("de.esolutions.fw.util.tracing.backend.EmergencyRecorderBackend")) : class$de$esolutions$fw$util$tracing$backend$EmergencyRecorderBackend);
        backendRegistry.register("RemoteConnectBackend", class$de$esolutions$fw$util$tracing$remote$push$RemoteConnectBackend == null ? (class$de$esolutions$fw$util$tracing$remote$push$RemoteConnectBackend = TraceCore.class$("de.esolutions.fw.util.tracing.remote.push.RemoteConnectBackend")) : class$de$esolutions$fw$util$tracing$remote$push$RemoteConnectBackend);
        backendRegistry.register("RemoteListenBackend", class$de$esolutions$fw$util$tracing$remote$pull$RemoteListenBackend == null ? (class$de$esolutions$fw$util$tracing$remote$pull$RemoteListenBackend = TraceCore.class$("de.esolutions.fw.util.tracing.remote.pull.RemoteListenBackend")) : class$de$esolutions$fw$util$tracing$remote$pull$RemoteListenBackend);
        backendRegistry.register("BinaryFileBackend", class$de$esolutions$fw$util$tracing$remote$push$BinaryFileBackend == null ? (class$de$esolutions$fw$util$tracing$remote$push$BinaryFileBackend = TraceCore.class$("de.esolutions.fw.util.tracing.remote.push.BinaryFileBackend")) : class$de$esolutions$fw$util$tracing$remote$push$BinaryFileBackend);
        backendRegistry.register("NullBackend", class$de$esolutions$fw$util$tracing$backend$NullBackend == null ? (class$de$esolutions$fw$util$tracing$backend$NullBackend = TraceCore.class$("de.esolutions.fw.util.tracing.backend.NullBackend")) : class$de$esolutions$fw$util$tracing$backend$NullBackend);
        backendRegistry.register("ProfilerBackend", class$de$esolutions$fw$util$tracing$backend$ProfilerBackend == null ? (class$de$esolutions$fw$util$tracing$backend$ProfilerBackend = TraceCore.class$("de.esolutions.fw.util.tracing.backend.ProfilerBackend")) : class$de$esolutions$fw$util$tracing$backend$ProfilerBackend);
    }

    private void setupBackends() {
        TraceConfigBackend[] traceConfigBackendArray = this.config.getBackends();
        int n = 0;
        if (traceConfigBackendArray != null) {
            for (int i2 = 0; i2 < traceConfigBackendArray.length; ++i2) {
                boolean bl;
                ITraceBackend iTraceBackend;
                TraceConfigBackend traceConfigBackend = traceConfigBackendArray[i2];
                if (!traceConfigBackend.isEnabled() || (iTraceBackend = traceConfigBackend.createInstance()) == null || !(bl = this.registerBackend(iTraceBackend, traceConfigBackend, traceConfigBackend.getName()))) continue;
                ++n;
            }
        }
        if (n == 0) {
            if (this.config.getUseDefaultConsole()) {
                TraceMe.msg(TraceMe.INFO, "Core", "core: Using default console backend");
                AbstractTraceBackend abstractTraceBackend = this.config.getCoreClass().compareTo("server") == 0 ? new CommandShellBackend() : new ConsoleBackend();
                boolean bl = this.registerBackend(abstractTraceBackend, null, "default");
                TraceMe.msg(TraceMe.INFO, "Core", "core: registering backend %1 ok=%2", abstractTraceBackend.getName(), new Boolean(bl));
            } else {
                TraceMe.msg(TraceMe.INFO, "Core", "core: Note: no backends defined in config and default console disabled!");
            }
        }
    }

    private void initMessageDecoderRegistry() {
        MessageDecoderRegistry messageDecoderRegistry = MessageDecoderRegistry.getInstance();
        messageDecoderRegistry.register("StringDecoder", class$de$esolutions$fw$util$tracing$decode$StringMessageDecoder == null ? (class$de$esolutions$fw$util$tracing$decode$StringMessageDecoder = TraceCore.class$("de.esolutions.fw.util.tracing.decode.StringMessageDecoder")) : class$de$esolutions$fw$util$tracing$decode$StringMessageDecoder);
        messageDecoderRegistry.register("HexDumpDecoder", class$de$esolutions$fw$util$tracing$decode$HexDumpMessageDecoder == null ? (class$de$esolutions$fw$util$tracing$decode$HexDumpMessageDecoder = TraceCore.class$("de.esolutions.fw.util.tracing.decode.HexDumpMessageDecoder")) : class$de$esolutions$fw$util$tracing$decode$HexDumpMessageDecoder);
    }

    private void setupMessageDecoders() {
        MessageDecoderRegistry messageDecoderRegistry = MessageDecoderRegistry.getInstance();
        TraceConfigDecoder[] traceConfigDecoderArray = this.config.getMessageDecoders();
        boolean bl = false;
        if (traceConfigDecoderArray != null) {
            for (int i2 = 0; i2 < traceConfigDecoderArray.length; ++i2) {
                ITraceMessageDecoder iTraceMessageDecoder;
                TraceConfigDecoder traceConfigDecoder = traceConfigDecoderArray[i2];
                if (!traceConfigDecoder.isEnabled() || (iTraceMessageDecoder = traceConfigDecoder.createInstance()) == null) continue;
                short s = traceConfigDecoder.getId();
                messageDecoderRegistry.registerDecoder(s, iTraceMessageDecoder);
                if (s != 1) continue;
                bl = true;
            }
        }
        if (!bl) {
            TraceMe.msg(TraceMe.INFO, "Core", "core: registering default string decoder");
            messageDecoderRegistry.registerDecoder((short)1, new StringMessageDecoder());
        }
    }

    public void registerMessageDecoder(short s, ITraceMessageDecoder iTraceMessageDecoder, ConfigValue configValue) {
        iTraceMessageDecoder.init(configValue);
        MessageDecoderRegistry.getInstance().registerDecoder(s, iTraceMessageDecoder);
    }

    public void unregisterMessageDecoder(short s) {
        MessageDecoderRegistry.getInstance().unregisterDecoder(s);
    }

    public void writeSemFile(String string, String string2) {
        this.model.writeSemFile(string, string2);
    }

    private void initMessageFormatters() {
        MessageFormatterRegistry messageFormatterRegistry = MessageFormatterRegistry.getInstance();
        messageFormatterRegistry.register("DefaultFormatter", class$de$esolutions$fw$util$tracing$format$DefaultMessageFormatter == null ? (class$de$esolutions$fw$util$tracing$format$DefaultMessageFormatter = TraceCore.class$("de.esolutions.fw.util.tracing.format.DefaultMessageFormatter")) : class$de$esolutions$fw$util$tracing$format$DefaultMessageFormatter);
        messageFormatterRegistry.register("NoNameFormatter", class$de$esolutions$fw$util$tracing$format$NoNameMessageFormatter == null ? (class$de$esolutions$fw$util$tracing$format$NoNameMessageFormatter = TraceCore.class$("de.esolutions.fw.util.tracing.format.NoNameMessageFormatter")) : class$de$esolutions$fw$util$tracing$format$NoNameMessageFormatter);
        messageFormatterRegistry.register("FancyFormatter", class$de$esolutions$fw$util$tracing$format$FancyMessageFormatter == null ? (class$de$esolutions$fw$util$tracing$format$FancyMessageFormatter = TraceCore.class$("de.esolutions.fw.util.tracing.format.FancyMessageFormatter")) : class$de$esolutions$fw$util$tracing$format$FancyMessageFormatter);
    }

    public void setErrorHandler(ITraceCoreErrorHandler iTraceCoreErrorHandler) {
        this.errorHandler = iTraceCoreErrorHandler;
    }

    public void errorShutdown(Throwable throwable) {
        if (this.errorHandler != null) {
            this.errorHandler.errorShutdown(this, throwable);
        }
    }

    public void injectError(Throwable throwable) {
        if (this.worker != null) {
            this.worker.injectError(throwable);
            this.worker.triggerMessageSignal();
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

