/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol;

import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferSender;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.protocol.IProtocolActions;
import de.esolutions.fw.util.tracing.protocol.ITimeSyncSender;
import de.esolutions.fw.util.tracing.protocol.ProtocolException;
import de.esolutions.fw.util.tracing.protocol.TimeSyncer;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.ChangeLevelBulkMessage;
import de.esolutions.fw.util.tracing.protocol.message.ChangeLevelMessage;
import de.esolutions.fw.util.tracing.protocol.message.CreateEntityBulkMessage;
import de.esolutions.fw.util.tracing.protocol.message.CreateEntityMessage;
import de.esolutions.fw.util.tracing.protocol.message.DroppedDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.ExecuteCallbackMessage;
import de.esolutions.fw.util.tracing.protocol.message.FileRequestMessage;
import de.esolutions.fw.util.tracing.protocol.message.FileStatusMessage;
import de.esolutions.fw.util.tracing.protocol.message.FileTransferMessage;
import de.esolutions.fw.util.tracing.protocol.message.InitMessage;
import de.esolutions.fw.util.tracing.protocol.message.LogDataBulkMessage;
import de.esolutions.fw.util.tracing.protocol.message.LogDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageReceiver;
import de.esolutions.fw.util.tracing.protocol.message.MessageSender;
import de.esolutions.fw.util.tracing.protocol.message.RegisterTimezoneMessage;
import de.esolutions.fw.util.tracing.protocol.message.TimeSyncMessage;
import de.esolutions.fw.util.tracing.protocol.message.ToggleEntityMessage;
import de.esolutions.fw.util.tracing.protocol.message.UpdateTimezoneMessage;
import de.esolutions.fw.util.transport.exception.EndOfTransportException;
import de.esolutions.fw.util.transport.exception.TransportException;
import de.esolutions.fw.util.transport.exception.TransportTimeoutException;
import java.io.IOException;

public class ProtocolHandler
implements ITimeSyncSender,
IFileTransferSender {
    protected static final byte protocolRevision;
    public static final int STATE_INIT;
    public static final int STATE_CONNECTED;
    public static final int STATE_PASSIVE_CONNECT;
    public static final int STATE_EXIT;
    public static final int STATE_DISCONNECTED;
    public static final int STATE_ERROR;
    protected Connection connection;
    protected IProtocolActions actions;
    protected MessageSender sender;
    protected MessageReceiver receiver;
    protected int state;
    protected boolean isMaster;
    protected String myName;
    protected int maxEntities;
    protected String peerName;
    protected TimeSyncer timeSyncer;
    protected boolean endOnTimeOut;

    public ProtocolHandler(String string, Connection connection, boolean bl) {
        this.myName = string;
        this.connection = connection;
        this.sender = new MessageSender(this.connection);
        this.receiver = new MessageReceiver(this.connection);
        this.state = 0;
        this.isMaster = bl;
        this.timeSyncer = new TimeSyncer(this);
    }

    public void setEndOnTimeOut(boolean bl) {
        this.endOnTimeOut = bl;
    }

    public void setMaxEntities(int n) {
        this.maxEntities = n;
    }

    public int getMaxEntities() {
        return this.maxEntities;
    }

    public void setActionHandler(IProtocolActions iProtocolActions) {
        this.actions = iProtocolActions;
    }

    public int getState() {
        return this.state;
    }

    public String getPeerName() {
        return this.peerName;
    }

    public synchronized boolean connect(boolean bl, boolean bl2) {
        if (this.state != 0) {
            throw new ProtocolException("connect only allowed in INIT state");
        }
        if (this.isMaster) {
            return this.doHandshakeMaster(bl, bl2);
        }
        return this.doHandshakeSlave(bl);
    }

    public synchronized boolean disconnect() {
        if (this.state != 1 && this.state != 2) {
            throw new ProtocolException("disconnect only allowed in CONNECTED state");
        }
        this.sender.sendExit();
        return true;
    }

    /*
     * Unable to fully structure code
     */
    public AbstractMessage handleIncomingMessage() {
        if (this.state != 1) {
            throw new ProtocolException("handle incoming message only allowed in CONNECTED state");
        }
        var1_1 = null;
        while (true) lbl-1000:
        // 3 sources

        {
            try {
                var1_1 = this.receiver.recvMessage();
            }
            catch (TransportTimeoutException var2_3) {
                if (!this.endOnTimeOut) ** GOTO lbl-1000
                return null;
            }
            catch (IOException var2_4) {
                var3_9 = super.getClass().getName();
                if (var3_9.equals("java.net.SocketTimeoutException")) {
                    if (!this.endOnTimeOut) continue;
                    return null;
                }
                throw var2_4;
            }
            catch (EndOfTransportException var2_5) {
                return null;
            }
            catch (TransportException var2_6) {
                throw new ProtocolException(new StringBuffer().append("transport has problems: ").append(var2_6.getMessage()).toString());
            }
            catch (SerializerException var2_7) {
                throw new ProtocolException(new StringBuffer().append("serializer has problems: ").append(var2_7.getMessage()).toString());
            }
            break;
        }
        if (var1_1 == null) {
            throw new ProtocolException("no message received");
        }
        var2_8 = var1_1.getMessageType().toByte();
        switch (var2_8) {
            case 4: {
                var3_9 = (LogDataMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleLogData(var3_9.getMessage());
                break;
            }
            case 1: {
                this.state = 3;
                if (this.actions == null) break;
                this.actions.handleExit();
                break;
            }
            case 2: {
                var3_9 = (TimeSyncMessage)var1_1;
                try {
                    this.timeSyncer.handleIncomingMessage((TimeSyncMessage)var3_9);
                    break;
                }
                catch (TransportException var4_10) {
                    throw new ProtocolException(new StringBuffer().append("transport has problems: ").append(var4_10.getMessage()).toString());
                }
            }
            case 3: {
                var3_9 = (CreateEntityMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleCreateEntity(var3_9.getEntity());
                break;
            }
            case 18: {
                var3_9 = (ExecuteCallbackMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleExecuteCallback(var3_9.getCallbackId(), var3_9.getCallbackPayload());
                break;
            }
            case 17: {
                var3_9 = (ChangeLevelMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleChangeLevel(var3_9.getUri(), var3_9.getLevel());
                break;
            }
            case 5: {
                var3_9 = (DroppedDataMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleDroppedData(var3_9.getNumDropped());
                break;
            }
            case 16: {
                var3_9 = (ToggleEntityMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleToggleEntity(var3_9.getUri(), var3_9.getOn());
                break;
            }
            case 19: {
                var3_9 = (RegisterTimezoneMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleRegisterTimezone(var3_9.getId(), var3_9.getResolution(), var3_9.getName());
                break;
            }
            case 20: {
                var3_9 = (UpdateTimezoneMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleUpdateTimezone(var3_9.getId(), var3_9.getTimezoneTimeStamp(), var3_9.getCoreTimeStamp());
                break;
            }
            case 22: {
                var3_9 = (FileRequestMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleFileRequestMessage(var3_9.getTransferId(), var3_9.getFilePath(), var3_9.getOperation());
                break;
            }
            case 23: {
                var3_9 = (FileStatusMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleFileStatusMessage(var3_9.getTransferId(), var3_9.getFilePath(), var3_9.getFileFlag(), var3_9.getFileSize(), var3_9.getFileTimeStamp(), var3_9.getFileHashType(), var3_9.getFileHash());
                break;
            }
            case 24: {
                var3_9 = (FileTransferMessage)var1_1;
                if (this.actions == null) break;
                this.actions.handleFileTransferMessage(var3_9.getTransferId(), var3_9.getBlockNumber(), var3_9.getFlag(), var3_9.getBlockSize(), var3_9.getBlockData());
                break;
            }
            case 48: {
                var3_9 = (CreateEntityBulkMessage)var1_1;
                if (this.actions == null || (var4_11 = var3_9.getEntities()) == null) break;
                for (var5_14 = 0; var5_14 < var4_11.length; ++var5_14) {
                    this.actions.handleCreateEntity(var4_11[var5_14]);
                }
                break;
            }
            case 50: {
                var3_9 = (ChangeLevelBulkMessage)var1_1;
                if (this.actions == null || (var4_12 = var3_9.getEntities()) == null) break;
                for (var5_15 = 0; var5_15 < var4_12.length; ++var5_15) {
                    var6_17 = var4_12[var5_15];
                    this.actions.handleChangeLevel(var6_17.getURI(), var6_17.getFilterLevel());
                }
                break;
            }
            case 49: {
                var3_9 = (LogDataBulkMessage)var1_1;
                if (this.actions == null || (var4_13 = var3_9.getMessages()) == null) break;
                for (var5_16 = 0; var5_16 < var4_13.length; ++var5_16) {
                    this.actions.handleLogData(var4_13[var5_16]);
                }
                break;
            }
        }
        return var1_1;
    }

    public synchronized void sendSyncMarker(int n, long l) {
        this.sender.sendSyncMarker(n, l);
    }

    @Override
    public synchronized void sendTimeSync(long l, byte by, byte by2) {
        this.sender.sendTimeSync(l, by, by2);
    }

    public synchronized void sendCreateEntity(IExternalTraceEntity iExternalTraceEntity) {
        this.sender.sendCreateEntity(iExternalTraceEntity);
    }

    public synchronized void sendLogData(ITraceMessage iTraceMessage) {
        this.sender.sendLogData(iTraceMessage);
    }

    public synchronized void sendExecuteCallback(int n, byte[] byArray) {
        this.sender.sendExecuteCallback(n, byArray);
    }

    public synchronized void sendChangeLevel(TraceEntityURI traceEntityURI, short s) {
        this.sender.sendChangeLevel(traceEntityURI, s);
    }

    public synchronized void sendDroppedMessages(int n) {
        this.sender.sendDroppedMessages(n);
    }

    public synchronized void sendToggleEntity(TraceEntityURI traceEntityURI, boolean bl) {
        this.sender.sendToggleEntity(traceEntityURI, bl);
    }

    public synchronized void sendRegisterTimeZone(int n, int n2, String string) {
        this.sender.sendRegisterTimeZone(n, n2, string);
    }

    public synchronized void sendUpdateTimeZone(int n, long l, long l2) {
        this.sender.sendUpdateTimeZone(n, l, l2);
    }

    @Override
    public synchronized boolean sendFileRequest(int n, String string, byte by) {
        try {
            this.sender.sendFileRequest(n, string, by);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public synchronized boolean sendFileStatus(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
        try {
            this.sender.sendFileStatus(n, string, by, l, l2, by2, byArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public synchronized boolean sendFileTransfer(int n, int n2, byte by, int n3, byte[] byArray) {
        try {
            this.sender.sendFileTransfer(n, n2, by, n3, byArray);
        }
        catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
        return true;
    }

    public synchronized void sendCreateEntityBulk(IExternalTraceEntity[] iExternalTraceEntityArray) {
        this.sender.sendCreateEntityBulk(iExternalTraceEntityArray);
    }

    public synchronized void sendChangeLevelBulk(IExternalTraceEntity[] iExternalTraceEntityArray) {
        this.sender.sendChangeLevelBulk(iExternalTraceEntityArray);
    }

    public synchronized void sendLogDataBulk(ITraceMessage[] iTraceMessageArray) {
        this.sender.sendLogDataBulkd(iTraceMessageArray);
    }

    private boolean doHandshakeMaster(boolean bl, boolean bl2) {
        this.sender.sendInit((byte)1, this.myName, this.maxEntities);
        if (bl) {
            if (!this.actions.handlePassiveInit()) {
                this.state = 5;
                return false;
            }
            this.state = 2;
            return true;
        }
        int n = 8192;
        if (!bl2) {
            InitMessage initMessage;
            try {
                initMessage = this.receiver.recvInitMessage();
            }
            catch (IOException iOException) {
                if (this.actions != null && !this.actions.handlePassiveInit()) {
                    this.state = 5;
                    return false;
                }
                this.state = 2;
                return true;
            }
            this.peerName = initMessage.getMyName();
            if (1 < initMessage.getProtocolRevision()) {
                this.state = 5;
                return false;
            }
            n = initMessage.getMaxEntities();
        }
        if (this.actions != null && !this.actions.handleInit(this.peerName, n)) {
            this.state = 5;
            return false;
        }
        this.timeSyncer.start((byte)20);
        this.state = 1;
        return true;
    }

    private boolean doHandshakeSlave(boolean bl) {
        InitMessage initMessage = this.receiver.recvInitMessage();
        byte by = initMessage.getProtocolRevision();
        this.peerName = initMessage.getMyName();
        if (!bl) {
            this.sender.sendInit((byte)1, this.myName, this.maxEntities);
        }
        if (by > 1) {
            this.state = 5;
            return false;
        }
        if (this.actions != null && !this.actions.handleInit(this.peerName, initMessage.getMaxEntities())) {
            this.state = 5;
            return false;
        }
        this.state = 1;
        return true;
    }
}

