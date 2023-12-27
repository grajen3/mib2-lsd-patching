/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote;

import de.esolutions.fw.util.tracing.backend.ITraceBackendListener;
import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.filetransfer.IFileTransferReceiver;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.protocol.IProtocolActions;

public class RemoteBackendActions
implements IProtocolActions {
    private ITraceBackendListener listener;
    private short bid;
    private IFileTransferReceiver fileTransferManager;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager;

    public RemoteBackendActions(short s, ITraceBackendListener iTraceBackendListener) {
        this.bid = s;
        this.listener = iTraceBackendListener;
        this.fileTransferManager = (IFileTransferReceiver)iTraceBackendListener.getComponent((class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager == null ? (class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager = RemoteBackendActions.class$("de.esolutions.fw.util.tracing.filetransfer.AbstractFileTransferManager")) : class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager).getName());
    }

    @Override
    public boolean handleChangeLevel(TraceEntityURI traceEntityURI, short s) {
        this.listener.logMessage(this.bid, new StringBuffer().append("handleChangeLevel: uri=").append(traceEntityURI).append(" level=").append(s).toString());
        this.listener.triggerRequestFilterLevel(traceEntityURI, s);
        return true;
    }

    @Override
    public boolean handleExecuteCallback(int n, byte[] byArray) {
        this.listener.logMessage(this.bid, new StringBuffer().append("handleExecuteCallback: cbid=").append(n).toString());
        this.listener.triggerExecuteCallback(n, byArray);
        return true;
    }

    @Override
    public boolean handleCreateEntity(IExternalTraceEntity iExternalTraceEntity) {
        this.listener.logMessage(this.bid, new StringBuffer().append("handleCreateEntity: ").append(iExternalTraceEntity).toString());
        return true;
    }

    @Override
    public void handleExit() {
        this.listener.logMessage(this.bid, "handleExit");
    }

    @Override
    public boolean handleInit(String string, int n) {
        this.listener.logMessage(this.bid, new StringBuffer().append("handleInit: name=").append(string).append(" maxEntities=").append(n).toString());
        return true;
    }

    @Override
    public boolean handlePassiveInit() {
        this.listener.logMessage(this.bid, "handlePassiveInit");
        return true;
    }

    @Override
    public boolean handleLogData(ITraceMessage iTraceMessage) {
        this.listener.logMessage(this.bid, new StringBuffer().append("handleLogData: msg=").append(iTraceMessage).toString());
        return true;
    }

    @Override
    public boolean handleDroppedData(int n) {
        this.listener.logMessage(this.bid, new StringBuffer().append("handleDroppedData: num=").append(n).toString());
        return true;
    }

    @Override
    public boolean handleToggleEntity(TraceEntityURI traceEntityURI, boolean bl) {
        this.listener.logMessage(this.bid, new StringBuffer().append("handleToggleEntity: uri=").append(traceEntityURI).append(" on=").append(bl).toString());
        return true;
    }

    @Override
    public boolean handleRegisterTimezone(int n, int n2, String string) {
        this.listener.logMessage(this.bid, new StringBuffer().append("handleRegisterTimezone: id=").append(n).append(" resolution=").append(n2).append(" name=").append(string).toString());
        return true;
    }

    @Override
    public boolean handleUpdateTimezone(int n, long l, long l2) {
        this.listener.logMessage(this.bid, new StringBuffer().append("handleUpdateTimezone: id=").append(n).append(" tzTime=").append(l).append(" coreTime=").append(l2).toString());
        return false;
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

