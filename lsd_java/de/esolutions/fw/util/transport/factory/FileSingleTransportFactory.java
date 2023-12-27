/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.BaseTransportFactory;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.packet.PacketTransport;
import de.esolutions.fw.util.transport.socket.FileByteTransport;

public class FileSingleTransportFactory
extends BaseTransportFactory
implements ISingleTransportFactory {
    private String fileName;

    public FileSingleTransportFactory(String string) {
        this.fileName = string;
    }

    @Override
    public ITransport createTransport() {
        FileByteTransport fileByteTransport = new FileByteTransport(this.fileName);
        ITransport iTransport = new PacketTransport(fileByteTransport);
        iTransport = this.enrichTransport(iTransport);
        return iTransport;
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[File:").append(this.fileName).append("]").toString();
    }
}

