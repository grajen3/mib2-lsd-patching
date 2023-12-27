/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.core;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.backend.ITraceBackend;
import de.esolutions.fw.util.tracing.command.ITraceCommandExecutor;
import de.esolutions.fw.util.tracing.config.TraceConfig;
import de.esolutions.fw.util.tracing.config.TraceConfigBackend;
import de.esolutions.fw.util.tracing.core.TraceBackendState;
import de.esolutions.fw.util.tracing.core.TraceBackendStateManager;
import de.esolutions.fw.util.tracing.core.TraceCore;
import de.esolutions.fw.util.tracing.core.TraceCoreBackendListener;
import de.esolutions.fw.util.tracing.core.TraceCoreStats;
import de.esolutions.fw.util.tracing.core.TraceCoreWorker;
import de.esolutions.fw.util.tracing.decode.ITraceMessageDecoder;
import de.esolutions.fw.util.tracing.decode.MessageDecoderRegistry;
import de.esolutions.fw.util.tracing.entity.ITraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.frontend.ITraceFrontendListener;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.message.TraceMessageBuffer;
import de.esolutions.fw.util.tracing.model.TraceEntity;
import de.esolutions.fw.util.tracing.model.TraceModel;
import de.esolutions.fw.util.tracing.timezone.TraceTimeTuple;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZone;
import de.esolutions.fw.util.tracing.timezone.TraceTimeZonePool;
import java.util.List;
import java.util.ListIterator;

public class TraceCoreController
implements ITraceCommandExecutor {
    private final TraceBackendStateManager stateMgr;
    private final TraceCore core;
    private int cmdEpoch;
    private final TraceModel model;
    private final TraceTimeZonePool timeZonePool;
    private final TraceMessageBuffer buffer;
    private final TraceCoreWorker worker;
    private final TraceCoreStats stats;
    private final MessageDecoderRegistry decoderRegistry;
    private TraceCoreBackendListener backendListener;
    private boolean aboutToQuit;
    private int lastSeqNum;
    private boolean doResizeBufferOnConnected;
    private int newBufferSize;
    private static final String chn;

    public TraceCoreController(TraceCore traceCore, int n) {
        this.core = traceCore;
        this.model = traceCore.getModel();
        this.timeZonePool = traceCore.getTimeZonePool();
        this.buffer = traceCore.getMessageBuffer();
        this.worker = traceCore.getWorker();
        this.stats = traceCore.getStats();
        this.decoderRegistry = MessageDecoderRegistry.getInstance();
        TraceConfig traceConfig = traceCore.getConfig();
        this.stateMgr = new TraceBackendStateManager((short)traceConfig.getMaxBackends());
        this.backendListener = new TraceCoreBackendListener(traceCore);
        this.cmdEpoch = n;
        this.newBufferSize = traceConfig.getMessageBufferSize();
        if (this.newBufferSize != this.buffer.capacity()) {
            this.doResizeBufferOnConnected = true;
        }
        this.stats.registerKey("ls", 12);
        this.stats.registerKey("lb", 12);
        this.stats.registerKey("ecs", 12);
        this.stats.registerKey("efs", 12);
        this.stats.registerKey("ecb", 12);
        this.stats.registerKey("efb", 12);
        this.stats.registerKey("cm", 6);
        this.stats.registerKey("cb", 6);
        this.stats.registerKey("dc", 6);
        this.stats.registerKey("ml", 6);
        this.stats.registerKey("td", 2);
        this.stats.registerKey("tl", 2);
    }

    @Override
    public void registerBackend(ITraceBackend iTraceBackend, TraceConfigBackend traceConfigBackend, String string) {
        short s = this.stateMgr.createBackend(iTraceBackend, string);
        if (s == -1) {
            TraceMe.msg(TraceMe.ERROR, "Controller", "worker:%1: registerBackend: %2 -> FAILED!", new Integer(this.cmdEpoch), iTraceBackend.getName());
            return;
        }
        TraceMe.msg(TraceMe.DEBUG, "Controller", "worker:%1: registerBackend: %2 -> bid=%3", new Integer(this.cmdEpoch), iTraceBackend.getName(), new Integer(s));
        iTraceBackend.init(s, this.backendListener, traceConfigBackend);
        this.setupAllBackendLevels(s);
        this.limitAllFilterLevelsForBackends();
        this.worker.addActivateBackendCommand(iTraceBackend);
    }

    @Override
    public void activateBackend(ITraceBackend iTraceBackend) {
        TraceMe.msg(TraceMe.DEBUG, "Controller", "worker:%1: activateBackend: %2", new Integer(this.cmdEpoch), iTraceBackend.getName());
        if (!iTraceBackend.connect()) {
            TraceMe.msg(TraceMe.DEBUG, "Controller", "  - failed connect. unregistering backend!");
            this.unregisterBackend(iTraceBackend);
        }
    }

    @Override
    public void unregisterBackend(ITraceBackend iTraceBackend) {
        short s = this.stateMgr.findBackend(iTraceBackend);
        TraceMe.msg(TraceMe.DEBUG, "Controller", "worker:%1: unregisterBackend: %2 bid=%3", new Integer(this.cmdEpoch), iTraceBackend.getName(), new Integer(s));
        if (s == -1) {
            return;
        }
        if (this.stateMgr.isConnected(s)) {
            iTraceBackend.disconnect();
            this.stateMgr.setDisconnected(s);
        }
        iTraceBackend.exit();
        this.stateMgr.removeBackend(s);
        if (!this.aboutToQuit) {
            this.limitAllFilterLevelsForBackends();
        }
    }

    @Override
    public void connectBackend(short s, boolean bl) {
        TraceMe.msg(TraceMe.DEBUG, "Controller", "worker:%1:connectBackend: bid=%2", new Integer(this.cmdEpoch), new Integer(s));
        if (!bl) {
            TraceMe.msg(TraceMe.DEBUG, "Controller", "  - failed! removing backend!");
            this.stateMgr.removeBackend(s);
            return;
        }
        TraceBackendState traceBackendState = this.stateMgr.getBackendState(s);
        if (traceBackendState == null) {
            return;
        }
        if (traceBackendState.isConnected()) {
            TraceMe.msg(TraceMe.DEBUG, "Controller", "  - already connected. ignoring");
            return;
        }
        this.stateMgr.setConnected(s);
        this.worker.triggerMessageSignal();
        if (this.doResizeBufferOnConnected && this.stateMgr.areAllConnected()) {
            this.doResizeBufferOnConnected = false;
            this.worker.addFlushMessagesCommand();
            this.worker.addResizeBufferCommand(this.newBufferSize);
        }
    }

    @Override
    public void disconnectBackend(short s) {
        TraceMe.msg(TraceMe.DEBUG, "Controller", "worker:%1: disconnectBackend: bid=%2", new Integer(this.cmdEpoch), new Integer(s));
        if (!this.stateMgr.setDisconnected(s)) {
            TraceMe.msg(TraceMe.DEBUG, "Controller", "  - ignored. already disconnected!");
        }
    }

    @Override
    public void createEntity(int n, TraceEntity traceEntity, short s) {
        this.incCmdEpoch(n);
        TraceMe.msg(TraceMe.DEBUG, "Controller", "worker:%1: createEntity: %2 level=%3", new Integer(n), traceEntity, TraceLevels.levelNames[s]);
        traceEntity.setCoreFilterLevel(s);
        this.setupAllBackendLevelsForEntity(traceEntity);
        this.limitFilterLevelForBackends(traceEntity);
        TraceMe.msg(TraceMe.DEBUG, "Controller", "  -> created entity=%1", traceEntity);
    }

    @Override
    public void changeFilterLevel(int n, TraceEntity traceEntity, short s) {
        this.incCmdEpoch(n);
        TraceMe.msg(TraceMe.DEBUG, "Controller", "worker:%1: changeFilterLevel: level=%2 entity=%3", new Integer(this.cmdEpoch), TraceLevels.levelNames[s], traceEntity);
        traceEntity.setCoreFilterLevel(s);
        short[] sArray = this.stateMgr.getAllBackendIds();
        if (sArray != null) {
            for (short s2 = 0; s2 < sArray.length; s2 = (short)(s2 + 1)) {
                ITraceBackend iTraceBackend = this.stateMgr.getBackend(s2);
                if (iTraceBackend != null) {
                    if (!iTraceBackend.adjustToChangeLevel(traceEntity)) continue;
                    TraceMe.msg(TraceMe.DEBUG, "Controller", "  adjust backend bid=%1 to level=%2", new Integer(s2), TraceLevels.levelNames[s]);
                    traceEntity.setBackendLevel(s2, s);
                    continue;
                }
                TraceMe.msg(TraceMe.ERROR, "Controller", " backend was null");
            }
        }
    }

    @Override
    public void executeCallback(int n, byte[] byArray) {
        TraceMe.msg(TraceMe.INFO, "Controller", "+FRONTEND executeCallback: %1", new Integer(n));
        List list = this.core.getFrontendListeners();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ITraceFrontendListener iTraceFrontendListener = (ITraceFrontendListener)listIterator.next();
            iTraceFrontendListener.executeCallback(n, byArray);
        }
        TraceMe.msg(TraceMe.INFO, "Controller", "-FRONTEND executeCallback: %1", new Integer(n));
    }

    @Override
    public void requestFilterLevel(TraceEntityURI traceEntityURI, short s) {
        TraceMe.msg(TraceMe.INFO, "Controller", "+FRONTEND requestFilterLevel: uri=%1 level=%2", traceEntityURI, TraceLevels.levelNames[s]);
        List list = this.core.getFrontendListeners();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ITraceFrontendListener iTraceFrontendListener = (ITraceFrontendListener)listIterator.next();
            iTraceFrontendListener.requestFilterLevel(traceEntityURI, s);
        }
        TraceMe.msg(TraceMe.INFO, "Controller", "-FRONTEND requestFilterLevel: uri=%1 level=%2", traceEntityURI, TraceLevels.levelNames[s]);
    }

    @Override
    public void registerTimeZone(int n, TraceTimeZone traceTimeZone) {
        this.incCmdEpoch(n);
        int n2 = traceTimeZone.getId();
        TraceMe.msg(TraceMe.DEBUG, "Controller", "worker:%1: registerTimeZone: id=%2 %3", new Integer(n), new Integer(n2), traceTimeZone);
    }

    @Override
    public void updateTimeZone(TraceTimeZone traceTimeZone) {
        TraceTimeTuple traceTimeTuple = traceTimeZone.getLastUpdate();
        if (traceTimeTuple == null) {
            return;
        }
        int n = traceTimeZone.getId();
        TraceMe.msg(TraceMe.DEBUG, "Controller", "worker:%1: updateTimeZone: id=%2 -> %3", new Integer(this.cmdEpoch), new Integer(n), traceTimeTuple);
        short[] sArray = this.stateMgr.getAllConnectedBackendIds();
        if (!this.updateConnectedBackendState(sArray)) {
            sArray = this.stateMgr.getAllConnectedBackendIds();
        }
        if (sArray != null) {
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                TraceMe.msg(TraceMe.DEBUG, "Controller", "  report to bid %1", new Integer(sArray[i2]));
                ITraceBackend iTraceBackend = this.stateMgr.getBackend(sArray[i2]);
                if (iTraceBackend == null) continue;
                iTraceBackend.updateTimeZone(n, traceTimeTuple.getTraceZoneTime(), traceTimeTuple.getCoreTime());
            }
        }
    }

    public void errorShutdown() {
        this.buffer.dropAll();
        short[] sArray = this.stateMgr.getAllBackendIds();
        if (sArray != null) {
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                short s = sArray[i2];
                if (s == -1) continue;
                ITraceBackend iTraceBackend = this.stateMgr.getBackend(s);
                if (iTraceBackend != null) {
                    this.unregisterBackend(iTraceBackend);
                    continue;
                }
                TraceMe.msg(TraceMe.ERROR, "Controller", " backend was null");
            }
        }
    }

    @Override
    public void flushEntities() {
        short[] sArray = this.stateMgr.getAllConnectedBackendIds();
        this.updateConnectedBackendState(sArray);
    }

    @Override
    public boolean flushMessages() {
        int n;
        int n2;
        int n3;
        boolean bl;
        TraceMe.msg(TraceMe.TRACE, "Controller", "process messages");
        if (!this.stateMgr.hasConnectedBackends()) {
            return false;
        }
        short[] sArray = this.stateMgr.getAllConnectedBackendIds();
        TraceBackendState[] traceBackendStateArray = new TraceBackendState[sArray.length];
        int n4 = -129;
        int[] nArray = new int[sArray.length];
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            TraceBackendState traceBackendState;
            traceBackendStateArray[i2] = traceBackendState = this.stateMgr.getBackendState(sArray[i2]);
            nArray[i2] = traceBackendState.getMsgSeqNum();
            if (nArray[i2] >= n4) continue;
            n4 = nArray[i2];
        }
        TraceMe.msg(TraceMe.TRACE, "Controller", "  - lowest backend msg seq num is %1", new Integer(n4));
        if (this.buffer.isEmpty()) {
            return false;
        }
        ITraceMessage[] iTraceMessageArray = this.buffer.getMessageRange(n4, this.cmdEpoch);
        if (iTraceMessageArray == null) {
            return false;
        }
        this.stats.updateKey("cm", 1);
        this.updateConnectedBackendState(sArray);
        boolean bl2 = bl = this.stateMgr.getDecodeFlagCounter() > 0;
        if (bl) {
            for (n3 = 0; n3 < iTraceMessageArray.length; ++n3) {
                this.decodeMessage(iTraceMessageArray[n3]);
            }
        }
        n3 = iTraceMessageArray[0].getSeqNum();
        int n5 = iTraceMessageArray[iTraceMessageArray.length - 1].getSeqNum();
        TraceMe.msg(TraceMe.TRACE, "Controller", "  - got %1 messages in seq num range [%2;%3]", new Integer(iTraceMessageArray.length), new Integer(n3), new Integer(n5));
        if (this.lastSeqNum + 1 < n3) {
            int n6 = n3 - this.lastSeqNum - 1;
            this.stats.updateKey("dc", n6);
            this.stats.updateKey("td", n6);
        }
        this.lastSeqNum = n5;
        ITraceBackend[] iTraceBackendArray = new ITraceBackend[sArray.length];
        boolean[] blArray = new boolean[sArray.length];
        boolean bl3 = false;
        boolean bl4 = false;
        for (n2 = 0; n2 < sArray.length; ++n2) {
            TraceBackendState traceBackendState = traceBackendStateArray[n2];
            iTraceBackendArray[n2] = traceBackendState.isConnected() ? traceBackendState.getBackend() : null;
            boolean bl5 = false;
            if (iTraceBackendArray[n2] != null) {
                boolean bl6 = bl5 = (iTraceBackendArray[n2].getFlags() & 8) != 0;
            }
            if (bl5) {
                bl3 = true;
            } else {
                bl4 = true;
            }
            blArray[n2] = bl5;
        }
        this.reportBackendDrops(sArray, iTraceBackendArray, n3, nArray);
        n2 = n5 + 1;
        if (bl4) {
            n2 = this.logMessages(iTraceMessageArray, sArray, iTraceBackendArray, nArray, blArray, n2);
        }
        if (bl3) {
            n2 = this.logBulkMessages(iTraceMessageArray, sArray, iTraceBackendArray, nArray, blArray, n2);
        }
        for (n = 0; n < sArray.length; ++n) {
            if (iTraceBackendArray[n] == null) continue;
            this.stateMgr.getBackendState(sArray[n]).setMsgSeqNum(n5 + 1);
        }
        if (this.stateMgr.areAllConnected()) {
            n = this.buffer.dropUpToSeqNum(n2);
            TraceMe.msg(TraceMe.TRACE, "Controller", "  - dropped %1 messages up to but excluding seqnum %2", new Integer(n), new Integer(n2));
            int[] nArray2 = this.buffer.getNumEntriesAndBytes();
            this.stats.updateKey("bc", nArray2[0]);
            this.stats.updateKey("bb", nArray2[1]);
            this.worker.triggerSeqNumSignal(n2 - 1);
        }
        return true;
    }

    private void reportBackendDrops(short[] sArray, ITraceBackend[] iTraceBackendArray, int n, int[] nArray) {
        for (int i2 = 0; i2 < iTraceBackendArray.length; ++i2) {
            if (nArray[i2] >= n) continue;
            int n2 = n - nArray[i2];
            boolean bl = iTraceBackendArray[i2].droppedMessages(n2);
            TraceMe.msg(TraceMe.TRACE, "Controller", "  - bid=%1: DROPPED %2 MESSAGES", new Integer(sArray[i2]), new Integer(n2));
            if (!bl) {
                TraceMe.msg(TraceMe.TRACE, "Controller", "  - failed! automatically disconnecting backend.");
                this.stateMgr.setDisconnected(sArray[i2]);
                iTraceBackendArray[i2] = null;
            }
            nArray[i2] = n;
        }
    }

    private void decodeMessage(ITraceMessage iTraceMessage) {
        TraceMe.msg(TraceMe.TRACE, "Controller", "  - decode msg %1", new Integer(iTraceMessage.getSeqNum()));
        ITraceMessageDecoder iTraceMessageDecoder = this.decoderRegistry.getDecoder(iTraceMessage.getMessageType());
        if (iTraceMessageDecoder != null) {
            iTraceMessageDecoder.decodeMessage(iTraceMessage, this.backendListener.getEntityResolver());
        } else {
            iTraceMessage.setDecodedMessage(new String[]{new StringBuffer().append("UNDECODED MESSAGE OF TYPE ").append(iTraceMessage.getMessageType()).toString()});
        }
    }

    private int logBulkMessages(ITraceMessage[] iTraceMessageArray, short[] sArray, ITraceBackend[] iTraceBackendArray, int[] nArray, boolean[] blArray, int n) {
        int n2 = iTraceMessageArray.length;
        int[] nArray2 = new int[iTraceMessageArray.length];
        for (int i2 = 0; i2 < iTraceBackendArray.length; ++i2) {
            ITraceMessage[] iTraceMessageArray2;
            int n3;
            ITraceMessage iTraceMessage;
            if (!blArray[i2] || iTraceBackendArray[i2] == null) continue;
            int n4 = 0;
            int n5 = nArray[i2];
            for (int i3 = 0; i3 < n2; ++i3) {
                iTraceMessage = iTraceMessageArray[i3];
                if (iTraceMessage.getSeqNum() < n5 || (n3 = this.checkBackendForMessage(iTraceMessage, sArray[i2])) == 0) continue;
                nArray2[n4] = i3;
                ++n4;
            }
            TraceMe.msg(TraceMe.TRACE, "Controller", "  - bid=%1 %2 bulkLog: numValid=%3", new Integer(sArray[i2]), iTraceBackendArray[i2].getName(), new Integer(n4));
            if (n4 <= 0) continue;
            if (n4 == n2) {
                iTraceMessageArray2 = iTraceMessageArray;
            } else {
                iTraceMessageArray2 = new ITraceMessage[n4];
                for (int i4 = 0; i4 < n4; ++i4) {
                    iTraceMessageArray2[i4] = iTraceMessageArray[nArray2[i4]];
                }
            }
            iTraceMessage = iTraceBackendArray[i2].logBulk(iTraceMessageArray2);
            if (iTraceMessage != null) {
                TraceMe.msg(TraceMe.TRACE, "Controller", "  - failed! automatically disconnecting backend.");
                n3 = iTraceMessage.getSeqNum();
                if (n3 < n) {
                    n = n3;
                }
                this.stateMgr.getBackendState(sArray[i2]).setMsgSeqNum(n3);
                this.stateMgr.setDisconnected(sArray[i2]);
                iTraceBackendArray[i2] = null;
            }
            this.stats.updateKey("lb", n4);
            this.stats.updateKey("ml", n4);
            this.stats.updateKey("tl", n4);
        }
        return n;
    }

    private int logMessages(ITraceMessage[] iTraceMessageArray, short[] sArray, ITraceBackend[] iTraceBackendArray, int[] nArray, boolean[] blArray, int n) {
        int n2;
        int n3 = iTraceBackendArray.length;
        int[] nArray2 = new int[n3];
        for (n2 = 0; n2 < iTraceMessageArray.length; ++n2) {
            ITraceMessage iTraceMessage = iTraceMessageArray[n2];
            int n4 = iTraceMessage.getSeqNum();
            for (int n5 = 0; n5 < sArray.length; n5 = (int)((short)(n5 + 1))) {
                if (iTraceBackendArray[n5] == null || blArray[n5] || n4 < nArray[n5]) continue;
                if (this.checkBackendForMessage(iTraceMessage, sArray[n5])) {
                    boolean bl = iTraceBackendArray[n5].log(iTraceMessage);
                    TraceMe.msg(TraceMe.TRACE, "Controller", "  - bid=%1 %2 seq=%4 level=%5 delta=%6", new Integer(sArray[n5]), iTraceBackendArray[n5].getName(), new Integer(n4), TraceLevels.levelNames[iTraceMessage.getLevel()], new Long(System.currentTimeMillis() - iTraceMessage.getTimeStamp()));
                    if (!bl) {
                        TraceMe.msg(TraceMe.TRACE, "Controller", "  - failed! automatically disconnecting backend.");
                        if (n4 < n) {
                            n = n4;
                        }
                        this.stateMgr.getBackendState(sArray[n5]).setMsgSeqNum(n4);
                        this.stateMgr.setDisconnected(sArray[n5]);
                        iTraceBackendArray[n5] = null;
                    }
                    int n6 = n5;
                    nArray2[n6] = nArray2[n6] + 1;
                    continue;
                }
                TraceMe.msg(TraceMe.TRACE, "Controller", "  - bid=%1 %2: ignored: seq=%3 level=%4 delta=%5", new Integer(sArray[n5]), iTraceBackendArray[n5].getName(), new Integer(n4), TraceLevels.levelNames[iTraceMessage.getLevel()], new Long(System.currentTimeMillis() - iTraceMessage.getTimeStamp()));
            }
        }
        n2 = 0;
        for (int i2 = 0; i2 < n3; ++i2) {
            if (nArray2[i2] > n2) {
                n2 = nArray2[i2];
            }
            this.stats.updateKey("ml", nArray2[i2]);
            this.stats.updateKey("tl", nArray2[i2]);
        }
        this.stats.updateKey("ls", n2);
        return n;
    }

    @Override
    public void init() {
        TraceMe.msg(TraceMe.TRACE, "Controller", "init worker");
    }

    @Override
    public void quit() {
        TraceMe.msg(TraceMe.TRACE, "Controller", "quit worker");
        this.aboutToQuit = true;
        this.worker.addFlushMessagesCommand();
        this.worker.addFlushEntitiesCommand();
        short[] sArray = this.stateMgr.getAllBackendIds();
        if (sArray != null) {
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                TraceMe.msg(TraceMe.TRACE, "Controller", "  about to unregister bid=%1", new Integer(sArray[i2]));
                this.worker.addUnregisterBackendCommand(this.stateMgr.getBackend(sArray[i2]));
            }
        }
        this.worker.addTerminateCommand();
    }

    @Override
    public void requestQuit() {
        TraceMe.msg(TraceMe.TRACE, "Controller", "request Quit!");
        List list = this.core.getFrontendListeners();
        ListIterator listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            ITraceFrontendListener iTraceFrontendListener = (ITraceFrontendListener)listIterator.next();
            iTraceFrontendListener.requestQuit();
        }
    }

    public void handleBreak() {
        short[] sArray = this.stateMgr.getAllBackendIds();
        if (sArray != null) {
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                ITraceBackend iTraceBackend = this.stateMgr.getBackend(sArray[i2]);
                if (iTraceBackend == null) continue;
                iTraceBackend.handleBreak();
            }
        }
    }

    @Override
    public void resizeBuffer(int n) {
        TraceMe.msg(TraceMe.TRACE, "Controller", "message buffer resized: newCapacity=%1", new Integer(n));
        if (!this.buffer.resize(n)) {
            TraceMe.msg(TraceMe.ERROR, "Controller", "Failed resizing buffer: newCapacity=%1", new Integer(n));
        } else {
            this.stats.updateKey("bs", n);
        }
    }

    public String getBackendKey(short s) {
        TraceBackendState traceBackendState = this.stateMgr.getBackendState(s);
        if (traceBackendState == null) {
            return null;
        }
        return traceBackendState.getKey();
    }

    private void incCmdEpoch(int n) {
        ++this.cmdEpoch;
        if (this.cmdEpoch != n) {
            TraceMe.msg(TraceMe.WARN, "Controller", "EPOCH MISMATCH: cmdEpoch=%1 newEpoch=%2", new Integer(this.cmdEpoch), new Integer(n));
        }
    }

    protected boolean updateConnectedBackendState(short[] sArray) {
        if (sArray == null || sArray.length == 0) {
            return true;
        }
        boolean bl = true;
        for (int i2 = 0; i2 < sArray.length; ++i2) {
            short s = sArray[i2];
            TraceBackendState traceBackendState = this.stateMgr.getBackendState(s);
            int n = traceBackendState.getEpoch();
            if (n >= this.cmdEpoch) continue;
            TraceMe.msg(TraceMe.TRACE, "Controller", "  update bid %1: from epoch %2 to epoch %3", new Integer(sArray[i2]), new Integer(n + 1), new Integer(this.cmdEpoch));
            boolean bl2 = this.realizeBackendState(s, n + 1, this.cmdEpoch);
            if (bl2) {
                traceBackendState.setEpoch(this.cmdEpoch);
            } else {
                TraceMe.msg(TraceMe.TRACE, "Controller", "  - failed! automatically disconnecting backend.");
                this.stateMgr.setDisconnected(s);
                bl = false;
            }
            this.stats.updateKey("cb", 1);
        }
        return bl;
    }

    protected boolean realizeBackendState(short s, int n, int n2) {
        if (!this.reportModel(s, n, n2)) {
            return false;
        }
        return this.reportTimeZones(s, n, n2);
    }

    protected boolean reportModel(short s, int n, int n2) {
        boolean bl;
        ITraceEntity iTraceEntity;
        int n3;
        int n4;
        ITraceBackend iTraceBackend = this.stateMgr.getBackend(s);
        if (iTraceBackend == null) {
            return false;
        }
        int n5 = iTraceBackend.getFlags();
        ITraceEntity[] iTraceEntityArray = this.model.getAllCreatedEntitiesInRange(n, n2);
        if (iTraceEntityArray != null) {
            n4 = iTraceEntityArray.length;
            if ((n5 & 0x10) != 0) {
                TraceMe.msg(TraceMe.TRACE, "Controller", "%1:  - reporting %2 entities bulk creations", new Integer(s), new Integer(iTraceEntityArray.length));
                n3 = iTraceBackend.createEntityBulk(iTraceEntityArray);
                if (n3 == 0) {
                    TraceMe.msg(TraceMe.TRACE, "Controller", "  - failed! automatically disconnecting backend.");
                    return false;
                }
                this.stats.updateKey("ecb", n4);
            } else {
                TraceMe.msg(TraceMe.TRACE, "Controller", "%1:  - reporting %2 entities creations", new Integer(s), new Integer(iTraceEntityArray.length));
                for (n3 = 0; n3 < n4; ++n3) {
                    iTraceEntity = iTraceEntityArray[n3];
                    bl = iTraceBackend.createEntity(iTraceEntity);
                    if (bl) continue;
                    TraceMe.msg(TraceMe.TRACE, "Controller", "  - failed! automatically disconnecting backend.");
                    return false;
                }
                this.stats.updateKey("ecs", n4);
            }
        }
        if ((iTraceEntityArray = this.model.getAllChangedOnlyEntitiesInRange(n, n2)) != null) {
            n4 = iTraceEntityArray.length;
            if ((n5 & 0x20) != 0) {
                TraceMe.msg(TraceMe.TRACE, "Controller", "%1:  - reporting %2 entity bulk filter changes", new Integer(s), new Integer(iTraceEntityArray.length));
                n3 = iTraceBackend.changeFilterLevelBulk(iTraceEntityArray) ? 1 : 0;
                if (n3 == 0) {
                    TraceMe.msg(TraceMe.TRACE, "Controller", "  - failed! automatically disconnecting backend.");
                    return false;
                }
                this.stats.updateKey("efb", n4);
            } else {
                TraceMe.msg(TraceMe.TRACE, "Controller", "%1:  - reporting %2 entity filter changes", new Integer(s), new Integer(iTraceEntityArray.length));
                for (n3 = 0; n3 < n4; ++n3) {
                    iTraceEntity = iTraceEntityArray[n3];
                    bl = iTraceBackend.changeFilterLevel(iTraceEntity.getURI(), iTraceEntity.getCoreFilterLevel());
                    if (bl) continue;
                    TraceMe.msg(TraceMe.TRACE, "Controller", "  - failed! automatically disconnecting backend.");
                    return false;
                }
                this.stats.updateKey("efs", n4);
            }
        }
        return true;
    }

    protected boolean reportTimeZones(short s, int n, int n2) {
        ITraceBackend iTraceBackend = this.stateMgr.getBackend(s);
        if (iTraceBackend == null) {
            return false;
        }
        TraceTimeZone[] traceTimeZoneArray = this.timeZonePool.getAllTimeZonesCreatedInRange(n, n2);
        if (traceTimeZoneArray != null) {
            TraceMe.msg(TraceMe.TRACE, "Controller", "  - reporting %1 time zones", new Integer(traceTimeZoneArray.length));
            for (int i2 = 0; i2 < traceTimeZoneArray.length; ++i2) {
                TraceTimeZone traceTimeZone = traceTimeZoneArray[i2];
                boolean bl = iTraceBackend.registerTimeZone(traceTimeZone.getId(), traceTimeZone.getResolution(), traceTimeZone.getName());
                if (bl) continue;
                TraceMe.msg(TraceMe.TRACE, "Controller", "  - failed! automatically disconnecting backend.");
                return false;
            }
        }
        return true;
    }

    private void setupAllBackendLevels(short s) {
        TraceMe.msg(TraceMe.TRACE, "Controller", "setup all backend flags for bid=%1", new Integer(s));
        TraceEntity[] traceEntityArray = this.model.getAllCreatedEntitiesInRange(0, this.cmdEpoch);
        if (traceEntityArray != null) {
            for (int i2 = 0; i2 < traceEntityArray.length; ++i2) {
                TraceEntity traceEntity = traceEntityArray[i2];
                if (traceEntity == null) continue;
                this.setupBackendLevelForEntity(s, traceEntity);
            }
        }
    }

    private void setupAllBackendLevelsForEntity(TraceEntity traceEntity) {
        short[] sArray = this.stateMgr.getBackendIds();
        if (sArray != null) {
            for (int i2 = 0; i2 < sArray.length; ++i2) {
                this.setupBackendLevelForEntity(sArray[i2], traceEntity);
            }
        }
    }

    private void setupBackendLevelForEntity(short s, TraceEntity traceEntity) {
        TraceMe.msg(TraceMe.TRACE, "Controller", "- setup backend flags for bid=%1 of entity=%2", new Integer(s), traceEntity);
        if (traceEntity == null) {
            return;
        }
        ITraceBackend iTraceBackend = this.stateMgr.getBackend(s);
        if (iTraceBackend == null) {
            TraceMe.msg(TraceMe.ERROR, "Controller", "FATAL no backend?");
            return;
        }
        short s2 = 7;
        for (TraceEntity traceEntity2 = traceEntity; traceEntity2 != null; traceEntity2 = (TraceEntity)traceEntity2.getParent()) {
            s2 = iTraceBackend.backendFilterLevel(traceEntity2);
            TraceMe.msg(TraceMe.TRACE, "  - ask backend: entity=%1 level=%2", traceEntity2.getName(), TraceLevels.levelNames[s2]);
            if (s2 != 7) break;
        }
        if (s2 == 7) {
            s2 = iTraceBackend.backendDefaultFilterLevel(traceEntity.getURI().getType());
            TraceMe.msg(TraceMe.TRACE, "Controller", "  - ask backend default: %1", TraceLevels.levelNames[s2]);
        }
        short s3 = traceEntity.getCoreFilterLevel();
        if (s2 == 7) {
            s2 = s3;
            TraceMe.msg(TraceMe.TRACE, "Controller", "  - use entity config: %1", TraceLevels.levelNames[s2]);
        }
        if (s2 < s3) {
            s2 = s3;
            TraceMe.msg(TraceMe.TRACE, "Controller", "  - limit backend to entity config: %1", TraceLevels.levelNames[s2]);
        }
        traceEntity.setBackendLevel(s, s2);
    }

    private boolean checkBackendForMessage(ITraceMessage iTraceMessage, short s) {
        TraceEntity traceEntity = this.model.getEntity(new TraceEntityURI(3, iTraceMessage.getChannelID()));
        TraceEntity traceEntity2 = this.model.getEntity(new TraceEntityURI(2, iTraceMessage.getThreadID()));
        if (traceEntity == null || traceEntity2 == null) {
            TraceMe.msg(TraceMe.TRACE, "Controller", "    - keep message: no entity?!");
            return true;
        }
        short s2 = traceEntity.getBackendLevel(s);
        short s3 = traceEntity2.getBackendLevel(s);
        if (s2 == 6 || s3 == 6) {
            TraceMe.msg(TraceMe.TRACE, "Controller", "    - drop message: backend off");
            return false;
        }
        if (s2 == 7 && s3 == 7) {
            TraceMe.msg(TraceMe.TRACE, "Controller", "    - keep message: backend ignore");
            return true;
        }
        short s4 = iTraceMessage.getLevel();
        if (s2 != 7 && s4 < s2) {
            TraceMe.msg(TraceMe.TRACE, "Controller", "    - drop message: below channel level %1", new Integer(s2));
            return false;
        }
        if (s3 != 7 && s4 < s3) {
            TraceMe.msg(TraceMe.TRACE, "Controller", "    - drop message: below thread level %1", new Integer(s2));
            return false;
        }
        return true;
    }

    private short getMinimalBackendFiltering(TraceEntity traceEntity) {
        short[] sArray = this.stateMgr.getAllBackendIds();
        if (sArray == null) {
            return 6;
        }
        int n = sArray.length;
        short s = 6;
        for (int i2 = 0; i2 < n; ++i2) {
            short s2 = traceEntity.getBackendLevel(sArray[i2]);
            if (s2 >= s) continue;
            s = s2;
        }
        return s;
    }

    private void limitFilterLevelForBackends(TraceEntity traceEntity) {
        short s = traceEntity.getCoreFilterLevel();
        short s2 = this.getMinimalBackendFiltering(traceEntity);
        if (s2 != s) {
            TraceMe.msg(TraceMe.TRACE, "Controller", "  - limitFilterLevelForBackends: cur level=%1 -> backends=%2 entity=%3", TraceLevels.levelNames[s], TraceLevels.levelNames[s2], traceEntity);
        }
    }

    private void limitAllFilterLevelsForBackends() {
        TraceEntity[] traceEntityArray = this.model.getAllCreatedEntitiesInRange(0, this.cmdEpoch);
        if (traceEntityArray != null) {
            for (int i2 = 0; i2 < traceEntityArray.length; ++i2) {
                this.limitFilterLevelForBackends(traceEntityArray[i2]);
            }
        }
    }
}

