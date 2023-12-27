/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.os.OSFinder;
import de.esolutions.fw.util.commons.queue.Queue;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.command.ActivateBackendCommand;
import de.esolutions.fw.util.tracing.command.ChangeFilterLevelCommand;
import de.esolutions.fw.util.tracing.command.ConnectBackendCommand;
import de.esolutions.fw.util.tracing.command.CreateEntityCommand;
import de.esolutions.fw.util.tracing.command.DisconnectBackendCommand;
import de.esolutions.fw.util.tracing.command.ExecuteCallbackCommand;
import de.esolutions.fw.util.tracing.command.FlushEntitiesCommand;
import de.esolutions.fw.util.tracing.command.FlushMessagesCommand;
import de.esolutions.fw.util.tracing.command.ITraceCommand;
import de.esolutions.fw.util.tracing.command.InitCommand;
import de.esolutions.fw.util.tracing.command.QuitCommand;
import de.esolutions.fw.util.tracing.command.RegisterBackendCommand;
import de.esolutions.fw.util.tracing.command.RegisterTimeZoneCommand;
import de.esolutions.fw.util.tracing.command.RequestFilterLevelCommand;
import de.esolutions.fw.util.tracing.command.RequestQuitCommand;
import de.esolutions.fw.util.tracing.command.ResizeBufferCommand;
import de.esolutions.fw.util.tracing.command.TerminateCommand;
import de.esolutions.fw.util.tracing.command.UnregisterBackendCommand;
import de.esolutions.fw.util.tracing.command.UpdateTimeZoneCommand;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.core.TraceCore;
import de.esolutions.fw.util.tracing.core.TraceCoreController;
import de.esolutions.fw.util.tracing.core.TraceCoreReplySignal;
import de.esolutions.fw.util.tracing.core.TraceCoreSignal;
import de.esolutions.fw.util.tracing.core.TraceCoreStats;
import de.esolutions.fw.util.tracing.core.TraceCoreStatsLogger;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZone;
import java.lang.reflect.Method;

public class TraceCoreWorker
implements Runnable {
    private Thread thread;
    private boolean active;
    private TraceCoreSignal signal = new TraceCoreSignal();
    private TraceCoreReplySignal seqNumSignal = new TraceCoreReplySignal();
    private Queue commands;
    private final TraceConfig config;
    private TraceCore core;
    private TraceCoreController controller;
    private final int msgFlushInterval;
    private final int entityFlushInterval;
    private TraceCoreStatsLogger statsLogger;
    private Throwable injectError;
    private static final String chn;

    public TraceCoreWorker(TraceCore traceCore, TraceCoreStats traceCoreStats) {
        this.commands = new Queue(traceCore.getConfig().getCommandBufferSize());
        this.core = traceCore;
        this.config = traceCore.getConfig();
        TraceConfig traceConfig = traceCore.getConfig();
        this.msgFlushInterval = traceConfig.getMessageBufferFlushInterval();
        this.entityFlushInterval = traceConfig.getEntityFlushInterval();
        if (traceConfig.getEnableCoreStatistics()) {
            this.statsLogger = new TraceCoreStatsLogger(this.config, traceCore.getFrontend(), traceCoreStats);
        }
    }

    public TraceCoreController getController() {
        return this.controller;
    }

    public synchronized void start(int n) {
        this.active = true;
        this.controller = new TraceCoreController(this.core, n);
        this.thread = new Thread(this, "TraceClient");
        this.thread.start();
    }

    public synchronized void stop() {
        this.addCommand(new QuitCommand());
        try {
            this.thread.join();
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        this.thread = null;
    }

    public synchronized boolean isRunning() {
        return this.thread != null;
    }

    public boolean addCommand(ITraceCommand iTraceCommand) {
        if (iTraceCommand == null) {
            TraceMe.msg(TraceMe.FATAL, "CoreWorker", "addCommand is null!");
            this.commands.dump();
            throw new RuntimeException("AddCommandIsNull");
        }
        try {
            if (this.commands.put(iTraceCommand)) {
                TraceMe.msg(TraceMe.INFO, "CoreWorker", "addCommand in high water range! queue size=%1", new Integer(this.commands.size()));
            }
            this.signal.triggerSignal(TraceCoreSignal.COMMAND);
            return true;
        }
        catch (QueueShutdownException queueShutdownException) {
            TraceMe.msg(TraceMe.ERROR, "CoreWorker", "addCommand failed: %1", queueShutdownException);
            return false;
        }
    }

    public boolean addInitCommand() {
        return this.addCommand(new InitCommand());
    }

    public boolean addRegisterBackendCommand(ITraceBackend iTraceBackend, TraceConfigBackend traceConfigBackend, String string) {
        return this.addCommand(new RegisterBackendCommand(iTraceBackend, traceConfigBackend, string));
    }

    public boolean addActivateBackendCommand(ITraceBackend iTraceBackend) {
        return this.addCommand(new ActivateBackendCommand(iTraceBackend));
    }

    public boolean addUnregisterBackendCommand(ITraceBackend iTraceBackend) {
        return this.addCommand(new UnregisterBackendCommand(iTraceBackend));
    }

    public boolean addCreateEntityCommand(int n, TraceEntity traceEntity, short s) {
        return this.addCommand(new CreateEntityCommand(n, traceEntity, s));
    }

    public boolean addChangeFilterLevelCommand(int n, TraceEntity traceEntity, short s) {
        return this.addCommand(new ChangeFilterLevelCommand(n, traceEntity, s));
    }

    public boolean addExecuteCallbackCommand(int n, byte[] byArray) {
        return this.addCommand(new ExecuteCallbackCommand(n, byArray));
    }

    public boolean addRequestFilterLevelCommand(TraceEntityURI traceEntityURI, short s) {
        return this.addCommand(new RequestFilterLevelCommand(traceEntityURI, s));
    }

    public boolean addFlushMessagesCommand() {
        return this.addCommand(new FlushMessagesCommand());
    }

    public boolean addFlushEntitiesCommand() {
        return this.addCommand(new FlushEntitiesCommand());
    }

    public void addConnectBackendCommand(short s, boolean bl) {
        this.addCommand(new ConnectBackendCommand(s, bl));
    }

    public void addDisconnectBackendCommand(short s) {
        this.addCommand(new DisconnectBackendCommand(s));
    }

    public void addRegisterTimeZoneCommand(int n, TraceTimeZone traceTimeZone) {
        this.addCommand(new RegisterTimeZoneCommand(n, traceTimeZone));
    }

    public void addUpdateTimeZoneCommand(TraceTimeZone traceTimeZone) {
        this.addCommand(new UpdateTimeZoneCommand(traceTimeZone));
    }

    public void addResizeBufferCommand(int n) {
        this.addCommand(new ResizeBufferCommand(n));
    }

    public void addTerminateCommand() {
        this.addCommand(new TerminateCommand());
    }

    public void addRequestQuitCommand() {
        this.addCommand(new RequestQuitCommand());
    }

    public void triggerMessageSignal() {
        this.signal.triggerSignal(TraceCoreSignal.MESSAGE);
    }

    public void triggerBreakSignal() {
        this.signal.triggerSignal(TraceCoreSignal.BREAK);
    }

    public boolean flushMessages(int n, boolean bl, long l) {
        if (!this.addFlushMessagesCommand()) {
            return false;
        }
        TraceMe.msg(TraceMe.TRACE, "CoreWorker", "flushing and waiting for seqNum=%1", new Integer(n));
        boolean bl2 = true;
        if (bl) {
            try {
                if (l > 0L) {
                    bl2 = this.seqNumSignal.waitForSignalWithTimeout(n, l);
                } else {
                    this.seqNumSignal.waitForSignal(n);
                }
            }
            catch (InterruptedException interruptedException) {
                return false;
            }
        }
        TraceMe.msg(TraceMe.TRACE, "CoreWorker", "flushed for seqNum %1 and ok=%2", new Integer(n), new Boolean(bl2));
        return bl2;
    }

    public void triggerSeqNumSignal(int n) {
        TraceMe.msg(TraceMe.TRACE, "CoreWorker", "report flushed signal seqNum=%1", new Integer(n));
        this.seqNumSignal.triggerSignal(n);
    }

    private boolean runCorePinMethod(int n) {
        try {
            OSFinder oSFinder = OSFinder.getInstance();
            Object object = oSFinder.getOSInstance();
            if (object == null) {
                return false;
            }
            Class[] classArray = new Class[]{Integer.TYPE};
            Method method = oSFinder.getOSClass().getDeclaredMethod("pinThread", classArray);
            if (method != null) {
                Object[] objectArray = new Object[]{new Integer(n)};
                method.invoke(object, objectArray);
                return true;
            }
        }
        catch (Exception exception) {
            // empty catch block
        }
        return false;
    }

    @Override
    public void run() {
        int n;
        if (this.config.getTraceCoreCPU() != null && !this.runCorePinMethod(n = this.config.getTraceCoreCPU().intValue())) {
            TraceMe.msg(TraceMe.ERROR, "CoreWorker", "traceCoreCPU was in config defined, but could not used");
        }
        try {
            n = this.msgFlushInterval;
            if (this.entityFlushInterval < n) {
                n = this.entityFlushInterval;
            }
            TraceMe.msg(TraceMe.DEBUG, "CoreWorker", "worker:*: started. wait %1 ms", new Integer(n));
            long l = 0L;
            long l2 = 0L;
            long l3 = 0L;
            ITimeSource iTimeSource = TimeSourceProvider.getMonotonicTimeSource();
            while (this.active) {
                try {
                    long l4;
                    int n2;
                    int n3 = this.signal.waitForSignalWithTimeout(n);
                    TraceMe.msg(TraceMe.DEBUG, "CoreWorker", "worker:*: signal=%1", new Integer(n3));
                    if (this.injectError != null) {
                        TraceMe.msg(TraceMe.FATAL, "CoreWorker", "injecting ERROR!");
                        throw this.injectError;
                    }
                    long l5 = iTimeSource.getCurrentTime();
                    boolean bl = (n3 & TraceCoreSignal.BREAK) != 0;
                    TraceMe.msg(TraceMe.DEBUG, "CoreWorker", "worker:*: got signal=%1", new Integer(n3));
                    boolean bl2 = false;
                    boolean bl3 = false;
                    if ((n3 & TraceCoreSignal.TIMEOUT) != 0) {
                        long l6;
                        long l7 = l5 - l2;
                        if (l7 > (long)this.entityFlushInterval) {
                            l2 = l5;
                            bl2 = true;
                        }
                        if ((l6 = l5 - l3) > (long)this.msgFlushInterval) {
                            l3 = l5;
                            bl3 = true;
                        }
                    }
                    if ((n3 & (TraceCoreSignal.MESSAGE | TraceCoreSignal.COMMAND)) != 0) {
                        bl3 = true;
                    }
                    if (bl3) {
                        TraceMe.msg(TraceMe.DEBUG, "CoreWorker", "worker:*: flush messages");
                        if (this.controller.flushMessages()) {
                            bl2 = false;
                        }
                    }
                    if (bl2) {
                        TraceMe.msg(TraceMe.DEBUG, "CoreWorker", "worker:*: flush entities");
                        this.controller.flushEntities();
                    }
                    if ((n3 & TraceCoreSignal.COMMAND) != 0 && !bl) {
                        this.active = this.processCommands();
                    }
                    if (bl) {
                        this.controller.handleBreak();
                    }
                    if ((n2 = this.config.getCoreStatisticsInterval()) <= 0 || this.statsLogger == null || (l4 = l5 - l) < (long)n2) continue;
                    this.statsLogger.log();
                    l = l5;
                }
                catch (InterruptedException interruptedException) {
                    TraceMe.msg(TraceMe.WARN, "CoreWorker", "worker:*: interrupted: %1", interruptedException);
                }
            }
            TraceMe.msg(TraceMe.DEBUG, "CoreWorker", "worker:*: stopped");
        }
        catch (Throwable throwable) {
            System.err.println(new StringBuffer().append("JavaTraceCore: CRASHED: ").append(throwable).toString());
            throwable.printStackTrace();
            this.errorShutdown(throwable);
        }
    }

    private void errorShutdown(Throwable throwable) {
        try {
            System.err.println("JavaTraceCore: trying to shutdown");
            this.core.errorShutdown(throwable);
            this.controller.errorShutdown();
            this.commands.shutdown();
            System.err.println("JavaTraceCore: shutdown done");
        }
        catch (Throwable throwable2) {
            System.err.println(new StringBuffer().append("JavaTraceCore: CRASHED AGAIN: ").append(throwable2).toString());
            throwable2.printStackTrace();
        }
    }

    private boolean processCommands() {
        while (!this.commands.isEmpty()) {
            try {
                ITraceCommand iTraceCommand = (ITraceCommand)this.commands.get();
                if (iTraceCommand != null) {
                    boolean bl = iTraceCommand.execute(this.controller);
                    if (bl) {
                        return false;
                    }
                    TraceMe.msg(TraceMe.DEBUG, "CoreWorker", "worker:*: do flush after command");
                    this.controller.flushMessages();
                    continue;
                }
                TraceMe.msg(TraceMe.FATAL, "CoreWorker", "worker:*: command queue returns NULL command");
                this.commands.dump();
                throw new RuntimeException("CommandQueueReturnedNull");
            }
            catch (QueueShutdownException queueShutdownException) {
                TraceMe.msg(TraceMe.ERROR, "CoreWorker", "process commands failed: %1", queueShutdownException);
                return true;
            }
            catch (InterruptedException interruptedException) {
                TraceMe.msg(TraceMe.ERROR, "CoreWorker", "process commands failed: %1", interruptedException);
                return true;
            }
        }
        return true;
    }

    public void injectError(Throwable throwable) {
        this.injectError = throwable;
    }
}

