/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.protocol.message;

import de.esolutions.fw.util.serializer.adapter.DefaultExtendedDeserializer;
import de.esolutions.fw.util.serializer.connection.Connection;
import de.esolutions.fw.util.serializer.stream.BEDefaultDeserializer;
import de.esolutions.fw.util.tracing.protocol.message.MessageReceiver;
import de.esolutions.fw.util.transport.packet.PacketTransport;
import de.esolutions.fw.util.transport.socket.InputStreamTransport;
import java.io.InputStream;

public class MessageReader {
    private final InputStream in;
    private final Connection c;
    private final MessageReceiver receiver;

    public MessageReader(InputStream inputStream) {
        this.in = inputStream;
        InputStreamTransport inputStreamTransport = new InputStreamTransport(inputStream);
        PacketTransport packetTransport = new PacketTransport(inputStreamTransport);
        DefaultExtendedDeserializer defaultExtendedDeserializer = new DefaultExtendedDeserializer(new BEDefaultDeserializer());
        this.c = new Connection(packetTransport, null, defaultExtendedDeserializer);
        this.receiver = new MessageReceiver(this.c);
    }

    public void open() {
        this.c.open();
    }

    public void close() {
        this.c.close(false);
        this.in.close();
    }

    public MessageReceiver receiver() {
        return this.receiver;
    }
}

