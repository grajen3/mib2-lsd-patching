/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.commons.Buffer;
import de.esolutions.fw.util.commons.StringUtils;
import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import de.esolutions.fw.util.tracing.TraceLevels;
import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.entity.TraceEntityURIWithLevel;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferReceiver;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.protocol.IProtocolActions;
import de.esolutions.fw.util.tracing.protocol.ProtocolException;
import de.esolutions.fw.util.tracing.protocol.ProtocolHandler;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.ExitMessage;
import de.esolutions.fw.util.tracing.remote.EntityBackRef;
import de.esolutions.fw.util.tracing.remote.IDMapper;
import de.esolutions.fw.util.transport.exception.TransportException;
import java.io.IOException;

public class ConnectionFrontendHandler
implements IProtocolActions {
    private final String myName;
    private final Connection connection;
    private final TraceFrontend frontend;
    private ProtocolHandler protocol;
    private boolean isConnected;
    private boolean isValid;
    private IDMapper mapper;
    private TraceEntityURIWithLevel proc;
    private String procName;
    private String peerName;
    private IDMapper timeZoneMapper;
    private boolean ignoreLevels;
    private boolean doOpenClose = true;
    private boolean isMaster;
    private boolean createTopLevelEntities;
    private boolean passiveMode = true;
    private IFileTransferReceiver fileTransferManager;
    public static final String chn;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager;

    public ConnectionFrontendHandler(String string, Connection connection, TraceFrontend traceFrontend) {
        this.myName = string;
        this.connection = connection;
        this.frontend = traceFrontend;
    }

    public Connection getConnection() {
        return this.connection;
    }

    public String toString() {
        Buffer buffer = new Buffer();
        buffer.append("<name=");
        buffer.append(this.myName);
        buffer.append(",con=");
        buffer.append(this.connection.getDescription());
        buffer.append(",ignoreLevels=");
        buffer.append(this.ignoreLevels);
        buffer.append(",doOpenClose=");
        buffer.append(this.doOpenClose);
        buffer.append(",isMaster=");
        buffer.append(this.isMaster);
        buffer.append(",createTopLevelEntities=");
        buffer.append(this.createTopLevelEntities);
        buffer.append(",passiveMode=");
        buffer.append(this.passiveMode);
        buffer.append(">");
        return buffer.toString();
    }

    public void setIsMaster(boolean bl) {
        this.isMaster = bl;
    }

    public void setCreateTopLevelEntities(boolean bl) {
        this.createTopLevelEntities = bl;
    }

    public void setIgnoreLevels(boolean bl) {
        this.ignoreLevels = bl;
    }

    public void setDoOpenClose(boolean bl) {
        this.doOpenClose = bl;
    }

    public void setPassiveMode(boolean bl) {
        this.passiveMode = bl;
    }

    public boolean connect() {
        if (this.isConnected) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "connect: already connected!");
            return false;
        }
        try {
            if (this.doOpenClose) {
                this.connection.open();
            }
            this.protocol = new ProtocolHandler(this.myName, this.connection, this.isMaster);
            this.protocol.setActionHandler(this);
            this.protocol.setEndOnTimeOut(true);
            this.fileTransferManager = (IFileTransferReceiver)this.frontend.getComponent((class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager == null ? (class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager = ConnectionFrontendHandler.class$("de.esolutions.fw.util.tracing.filetransfer.AbstractFileTransferManager")) : class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager).getName());
            if (this.fileTransferManager != null) {
                this.fileTransferManager.setFileTransferSender(this.protocol);
            }
            if (!this.protocol.connect(this.passiveMode, false)) {
                TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "Protocol connect to client %1 failed!", this.peerName);
                return false;
            }
            this.peerName = this.protocol.getPeerName();
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "connected to %1", this.peerName);
            this.isConnected = true;
            this.isValid = true;
            return true;
        }
        catch (IOException iOException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "start connection failed with: %1", iOException.getMessage());
            return false;
        }
        catch (TransportException transportException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "start connection failed with: %1", transportException.getMessage());
            return false;
        }
        catch (SerializerException serializerException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "start connection failed with: %1", serializerException.getMessage());
            return false;
        }
        catch (ProtocolException protocolException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "start connection failed with: %1", protocolException.getMessage());
            return false;
        }
        catch (InterruptedException interruptedException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "start connection failed with: %1", interruptedException.getMessage());
            return false;
        }
    }

    public boolean isConnected() {
        return this.isConnected;
    }

    public void disconnect() {
        if (!this.isConnected) {
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "disconnect: not connected!");
            return;
        }
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "disconnect: protocol");
        this.isConnected = false;
        this.isValid = false;
        try {
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", new StringBuffer().append("protocol is in state: ").append(this.protocol.getState()).toString());
            if (this.protocol.getState() == 1) {
                this.protocol.disconnect();
            }
        }
        catch (IOException iOException) {
            TraceMe.msg(TraceMe.WARN, "ConnectionFrontendHandler", "stop: failed IO disconnect", iOException.getMessage());
        }
        catch (TransportException transportException) {
            TraceMe.msg(TraceMe.WARN, "ConnectionFrontendHandler", "stop: failed transport disconnect: %1", transportException.getMessage());
        }
        catch (ProtocolException protocolException) {
            TraceMe.msg(TraceMe.WARN, "ConnectionFrontendHandler", "stop: failed protocol disconnect: %1", protocolException.getMessage());
        }
        catch (InterruptedException interruptedException) {
            // empty catch block
        }
        try {
            if (this.doOpenClose) {
                TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "disconnect: connection close");
                this.connection.close(false);
            }
        }
        catch (TransportException transportException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "stop connection failed with: %1", transportException.getMessage());
        }
        catch (IOException iOException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "stop connection failed with: %1", iOException.getMessage());
        }
        catch (InterruptedException interruptedException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "stop connection failed with: %1", interruptedException.getMessage());
        }
        if (this.mapper != null) {
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "disconnect: disable all channels");
            this.disableAllChannels();
            this.mapper = null;
        }
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "disconnect: done");
    }

    private void disableAllChannels() {
        int n = this.mapper.getMaxExtern();
        if (n == -1) {
            return;
        }
        for (int i2 = 0; i2 <= n; ++i2) {
            TraceEntityURI traceEntityURI = this.mapper.getInternalURI(i2);
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "disable entity: %1", traceEntityURI);
            if (traceEntityURI == null) continue;
            this.frontend.disableEntity(traceEntityURI);
        }
        if (this.proc != null) {
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "disable entity: %1", this.proc);
            this.frontend.disableEntity(this.proc);
        }
    }

    public AbstractMessage handleIncomingMessage() {
        if (!this.isValid) {
            TraceMe.msg(TraceMe.WARN, "ConnectionFrontendHandler", "handleMessage(): not valid anymore!");
            return null;
        }
        try {
            AbstractMessage abstractMessage = this.protocol.handleIncomingMessage();
            if (abstractMessage == null) {
                TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "connection: end from transport");
                this.isValid = false;
            } else if (abstractMessage instanceof ExitMessage) {
                TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "connection: end from procotol");
                this.isValid = false;
            }
            return abstractMessage;
        }
        catch (InterruptedException interruptedException) {
            TraceMe.msg(TraceMe.WARN, "ConnectionFrontendHandler", "dropping connection... interrupted");
            return null;
        }
        catch (ProtocolException protocolException) {
            TraceMe.msg(TraceMe.WARN, "ConnectionFrontendHandler", "dropping connection... protocol failed: %1", protocolException.getMessage());
            this.isValid = false;
            return null;
        }
        catch (IOException iOException) {
            TraceMe.msg(TraceMe.WARN, "ConnectionFrontendHandler", "dropping connection... io problem: %1", iOException.getMessage());
            this.isValid = false;
            return null;
        }
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String getPeerName() {
        return this.peerName;
    }

    @Override
    public boolean handlePassiveInit() {
        TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "Client: PassiveInit: INVALID");
        return false;
    }

    @Override
    public boolean handleInit(String string, int n) {
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "Client: Init: name=%1 maxEntities=%2", string, new Integer(n));
        this.mapper = new IDMapper(n);
        int n2 = this.frontend.getConfig().getMaxTimeZones();
        this.timeZoneMapper = new IDMapper(n2);
        if (this.createTopLevelEntities) {
            TraceEntityURIWithLevel traceEntityURIWithLevel;
            String string2;
            String string3;
            String[] stringArray = StringUtils.splitString(string, '.');
            if (stringArray.length == 0) {
                string3 = "unknown";
                string2 = null;
            } else if (stringArray.length == 1) {
                string3 = string;
                string2 = null;
            } else {
                string3 = stringArray[0];
                string2 = stringArray[1];
            }
            TraceEntityURIWithLevel traceEntityURIWithLevel2 = null;
            if (string2 != null) {
                traceEntityURIWithLevel2 = this.frontend.createRootEntity((short)0, string2, (short)7);
                if (traceEntityURIWithLevel2 == null) {
                    return false;
                }
            } else {
                traceEntityURIWithLevel2 = this.frontend.getRootEntity((short)1);
            }
            if ((traceEntityURIWithLevel = this.frontend.createEntity((short)1, string3, (short)7, traceEntityURIWithLevel2)) == null) {
                return false;
            }
            this.proc = traceEntityURIWithLevel;
            this.procName = string3;
        }
        if (this.fileTransferManager != null) {
            this.fileTransferManager.handleInitExitMessage();
        }
        return true;
    }

    @Override
    public void handleExit() {
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "Client: Exit");
        if (this.fileTransferManager != null) {
            this.fileTransferManager.handleInitExitMessage();
        }
    }

    @Override
    public boolean handleCreateEntity(IExternalTraceEntity iExternalTraceEntity) {
        TraceEntityURI traceEntityURI = iExternalTraceEntity.getURI();
        TraceEntityURI traceEntityURI2 = iExternalTraceEntity.getParentURI();
        TraceEntityURI traceEntityURI3 = null;
        traceEntityURI3 = traceEntityURI2 != null ? this.mapper.getInternalURI(traceEntityURI2) : this.proc;
        EntityBackRef entityBackRef = new EntityBackRef(this, traceEntityURI.getId());
        String string = iExternalTraceEntity.getName();
        short s = this.ignoreLevels ? (short)0 : iExternalTraceEntity.getFilterLevel();
        TraceEntityURIWithLevel traceEntityURIWithLevel = traceEntityURI.getType() == 1 && string.equals(this.procName) ? this.proc : this.frontend.createEntity(traceEntityURI.getType(), string, s, traceEntityURI3, entityBackRef);
        if (traceEntityURIWithLevel == null) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "*** FAILED *** Create Entity: ext=%1:%2@%3 parent=%4 -> int=%5 parent=%6", traceEntityURI, string, TraceLevels.levelNames[s], traceEntityURI2, traceEntityURIWithLevel, traceEntityURI3);
            return false;
        }
        this.mapper.setMapping(traceEntityURI.getType(), traceEntityURI.getId(), traceEntityURIWithLevel.getId());
        TraceEntityURI traceEntityURI4 = this.mapper.getInternalURI(traceEntityURI.getId());
        if (traceEntityURI4 != null && traceEntityURI4.getId() != traceEntityURIWithLevel.getId()) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "******************* PROBLEM *****************: check=%1 ext=%2", new Integer(traceEntityURI4.getId()), new Integer(traceEntityURIWithLevel.getId()));
        }
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "--- OK --- Create Entity: ext=%1:%2@%3 parent=%4 -> int=%5 parent=%6@%7", traceEntityURI, string, TraceLevels.levelNames[s], traceEntityURI2, traceEntityURIWithLevel, traceEntityURI3, TraceLevels.levelNames[traceEntityURIWithLevel.getLevel()]);
        return true;
    }

    @Override
    public boolean handleLogData(ITraceMessage iTraceMessage) {
        int n = this.mapper.getInternalID(iTraceMessage.getChannelID());
        int n2 = this.mapper.getInternalID(iTraceMessage.getThreadID());
        iTraceMessage.setChannelID(n);
        iTraceMessage.setThreadID(n2);
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "Message int(Cid=%1,Tid=%2) level=%3: %4", new Integer(n), new Integer(n2), TraceLevels.levelNames[iTraceMessage.getLevel()], iTraceMessage.getMessageString());
        this.frontend.log(iTraceMessage);
        return true;
    }

    @Override
    public boolean handleToggleEntity(TraceEntityURI traceEntityURI, boolean bl) {
        int n = this.mapper.getInternalID(traceEntityURI.getId());
        TraceEntityURI traceEntityURI2 = new TraceEntityURI(traceEntityURI.getType(), n);
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "Toggle Entity: %1 -> %2 on=%3", traceEntityURI, traceEntityURI2, new Boolean(bl));
        boolean bl2 = bl ? this.frontend.enableEntity(traceEntityURI2) : this.frontend.disableEntity(traceEntityURI2);
        if (!bl2) {
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", " -> ERROR");
        }
        return true;
    }

    @Override
    public boolean handleDroppedData(int n) {
        this.frontend.reportLostMessages(n);
        return true;
    }

    @Override
    public boolean handleChangeLevel(TraceEntityURI traceEntityURI, short s) {
        TraceEntityURI traceEntityURI2 = this.mapper.getInternalURI(traceEntityURI);
        if (traceEntityURI2 != null) {
            if (!this.ignoreLevels) {
                this.frontend.changeFilterLevel(traceEntityURI2, s);
            }
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "Change Level: extUri=%1 intUri=%2 @%3", traceEntityURI, traceEntityURI2, TraceLevels.levelNames[s]);
        } else {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "Change Level: extUri=%1 no intUri!!", traceEntityURI);
        }
        return true;
    }

    @Override
    public boolean handleExecuteCallback(int n, byte[] byArray) {
        TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "UNEXPECTED Execute Callback: %1", new Integer(n));
        return true;
    }

    @Override
    public boolean handleRegisterTimezone(int n, int n2, String string) {
        int n3 = this.frontend.registerTimeZone(n2, string);
        if (n3 == -1) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "*** Can't register timezone ***: res=%1 name=%2", new Integer(n2), string);
            return false;
        }
        this.timeZoneMapper.setMapping((short)0, n, n3);
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "Register TimeZone: intId=%1 extId=%2 res=%3 name=%4", new Integer(n3), new Integer(n), new Integer(n2), string);
        return true;
    }

    @Override
    public boolean handleUpdateTimezone(int n, long l, long l2) {
        int n2 = this.timeZoneMapper.getInternalID(n);
        if (n2 == -1) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "*** Can't update timezone ***: extId=%1", new Integer(n));
            return false;
        }
        this.frontend.updateTimeZone(n2, l, l2);
        TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "Update TimeZone: intId=%1 extId=%2 tzTime=%3 coreTime=%4", new Integer(n2), new Integer(n), new Long(l), new Long(l2));
        return true;
    }

    public boolean executeCallbackExtUri(int n, byte[] byArray) {
        if (!this.isConnected) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "NOT CONNECTED: Execute Callback: %1", new Integer(n));
            return false;
        }
        try {
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "Execute Callback: extId=%1", new Integer(n));
            this.protocol.sendExecuteCallback(n, byArray);
            return true;
        }
        catch (InterruptedException interruptedException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "Executing Callback: %1", interruptedException);
            this.isValid = false;
            return false;
        }
        catch (IOException iOException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "Executing Callback: %1", iOException);
            this.isValid = false;
            return false;
        }
        catch (TransportException transportException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "Executing Callback: %1", transportException);
            this.isValid = false;
            return false;
        }
    }

    public boolean requestFilterLevelExtUri(TraceEntityURI traceEntityURI, short s) {
        if (!this.isConnected) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "NOT CONNECTED: Request Filter Level: %1", traceEntityURI);
            return false;
        }
        try {
            TraceMe.msg(TraceMe.INFO, "ConnectionFrontendHandler", "con: Request Filter Level: extUri=%1 level=%2", traceEntityURI, TraceLevels.levelNames[s]);
            this.protocol.sendChangeLevel(traceEntityURI, s);
            return true;
        }
        catch (InterruptedException interruptedException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "Changing Filter: %1", interruptedException);
            this.isValid = false;
            return false;
        }
        catch (IOException iOException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "Changing Filter: %1", iOException);
            this.isValid = false;
            return false;
        }
        catch (TransportException transportException) {
            TraceMe.msg(TraceMe.ERROR, "ConnectionFrontendHandler", "Changing Filter: %1", transportException);
            this.isValid = false;
            return false;
        }
    }

    @Override
    public boolean handleFileRequestMessage(int n, String string, byte by) {
        if (this.fileTransferManager != null) {
            this.fileTransferManager.handleFileRequestMessage(n, string, by);
            return true;
        }
        return false;
    }

    @Override
    public boolean handleFileStatusMessage(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
        if (this.fileTransferManager != null) {
            this.fileTransferManager.handleFileStatusMessage(n, string, by, l, l2, by2, byArray);
            return true;
        }
        return false;
    }

    @Override
    public boolean handleFileTransferMessage(int n, int n2, byte by, int n3, byte[] byArray) {
        if (this.fileTransferManager != null) {
            this.fileTransferManager.handleFileTransferMessage(n, n2, by, n3, byArray);
            return true;
        }
        return false;
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

