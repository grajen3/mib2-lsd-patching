/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.ISerializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.tracing.entity.IExternalTraceEntity;
import de.esolutions.fw.util.tracing.entity.TraceEntityURI;
import de.esolutions.fw.util.tracing.message.ITraceMessage;
import de.esolutions.fw.util.tracing.protocol.message.AbstractMessage;
import de.esolutions.fw.util.tracing.protocol.message.ChangeLevelBulkMessage;
import de.esolutions.fw.util.tracing.protocol.message.ChangeLevelMessage;
import de.esolutions.fw.util.tracing.protocol.message.CreateEntityBulkMessage;
import de.esolutions.fw.util.tracing.protocol.message.CreateEntityMessage;
import de.esolutions.fw.util.tracing.protocol.message.DroppedDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.ExecuteCallbackMessage;
import de.esolutions.fw.util.tracing.protocol.message.ExitMessage;
import de.esolutions.fw.util.tracing.protocol.message.FileRequestMessage;
import de.esolutions.fw.util.tracing.protocol.message.FileStatusMessage;
import de.esolutions.fw.util.tracing.protocol.message.FileTransferMessage;
import de.esolutions.fw.util.tracing.protocol.message.InitMessage;
import de.esolutions.fw.util.tracing.protocol.message.LogDataBulkMessage;
import de.esolutions.fw.util.tracing.protocol.message.LogDataMessage;
import de.esolutions.fw.util.tracing.protocol.message.MessageEncoder;
import de.esolutions.fw.util.tracing.protocol.message.RawMessage;
import de.esolutions.fw.util.tracing.protocol.message.RegisterTimezoneMessage;
import de.esolutions.fw.util.tracing.protocol.message.SyncMarkerMessage;
import de.esolutions.fw.util.tracing.protocol.message.TimeSyncMessage;
import de.esolutions.fw.util.tracing.protocol.message.ToggleEntityMessage;
import de.esolutions.fw.util.tracing.protocol.message.UpdateTimezoneMessage;
import de.esolutions.fw.util.transport.ITransport;

public class MessageSender {
    protected ITransport transport;
    protected MessageEncoder encoder;

    public MessageSender(Connection connection) {
        this.transport = connection.getTransport();
        this.encoder = new MessageEncoder(connection.getSerializer());
    }

    public void setSerializer(ISerializer iSerializer) {
        this.encoder = new MessageEncoder(iSerializer);
    }

    private AbstractMessage send(AbstractMessage abstractMessage) {
        this.transport.send(this.encoder.encodeWriter(abstractMessage));
        return abstractMessage;
    }

    public AbstractMessage sendInit(byte by, String string, int n) {
        return this.send(new InitMessage(by, string, n));
    }

    public AbstractMessage sendExit() {
        return this.send(new ExitMessage());
    }

    public AbstractMessage sendTimeSync(long l, byte by, byte by2) {
        return this.send(new TimeSyncMessage(l, by, by2));
    }

    public AbstractMessage sendCreateEntity(IExternalTraceEntity iExternalTraceEntity) {
        return this.send(new CreateEntityMessage(iExternalTraceEntity));
    }

    public AbstractMessage sendLogData(ITraceMessage iTraceMessage) {
        return this.send(new LogDataMessage(iTraceMessage));
    }

    public AbstractMessage sendExecuteCallback(int n, byte[] byArray) {
        return this.send(new ExecuteCallbackMessage(n, byArray));
    }

    public AbstractMessage sendChangeLevel(TraceEntityURI traceEntityURI, short s) {
        return this.send(new ChangeLevelMessage(traceEntityURI, s));
    }

    public AbstractMessage sendDroppedMessages(int n) {
        return this.send(new DroppedDataMessage(n));
    }

    public AbstractMessage sendToggleEntity(TraceEntityURI traceEntityURI, boolean bl) {
        return this.send(new ToggleEntityMessage(traceEntityURI, bl));
    }

    public AbstractMessage sendRegisterTimeZone(int n, int n2, String string) {
        return this.send(new RegisterTimezoneMessage(n, n2, string));
    }

    public AbstractMessage sendUpdateTimeZone(int n, long l, long l2) {
        return this.send(new UpdateTimezoneMessage(n, l, l2));
    }

    public AbstractMessage sendRawMessage(byte by, byte[] byArray) {
        return this.send(new RawMessage(by, byArray));
    }

    public AbstractMessage sendFileRequest(int n, String string, byte by) {
        return this.send(new FileRequestMessage(n, string, by));
    }

    public AbstractMessage sendFileStatus(int n, String string, byte by, long l, long l2, byte by2, byte[] byArray) {
        return this.send(new FileStatusMessage(n, string, by, l, l2, by2, byArray));
    }

    public AbstractMessage sendFileTransfer(int n, int n2, byte by, int n3, byte[] byArray) {
        return this.send(new FileTransferMessage(n, n2, by, n3, byArray));
    }

    public AbstractMessage sendSyncMarker(int n, long l) {
        return this.send(new SyncMarkerMessage(n, l));
    }

    public AbstractMessage sendCreateEntityBulk(IExternalTraceEntity[] iExternalTraceEntityArray) {
        return this.send(new CreateEntityBulkMessage(iExternalTraceEntityArray));
    }

    public AbstractMessage sendChangeLevelBulk(IExternalTraceEntity[] iExternalTraceEntityArray) {
        return this.send(new ChangeLevelBulkMessage(iExternalTraceEntityArray));
    }

    public AbstractMessage sendLogDataBulkd(ITraceMessage[] iTraceMessageArray) {
        return this.send(new LogDataBulkMessage(iTraceMessageArray));
    }
}

