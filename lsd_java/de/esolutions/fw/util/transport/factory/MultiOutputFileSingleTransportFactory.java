/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.BaseTransportFactory;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.packet.PacketTransport;
import de.esolutions.fw.util.transport.socket.MultiFileOutputStream;
import de.esolutions.fw.util.transport.socket.OutputStreamTransport;
import java.io.FileNotFoundException;

public class MultiOutputFileSingleTransportFactory
extends BaseTransportFactory
implements ISingleTransportFactory {
    String baseName;
    String suffix;
    int numDigits;
    int firstIndex;
    int splitSize;

    public MultiOutputFileSingleTransportFactory(String string, String string2, int n, int n2, int n3) {
        this.baseName = string;
        this.suffix = string2;
        this.numDigits = n;
        this.firstIndex = n2;
        this.splitSize = n3;
    }

    @Override
    public ITransport createTransport() {
        try {
            MultiFileOutputStream multiFileOutputStream = new MultiFileOutputStream(this.baseName, this.suffix, this.numDigits, this.firstIndex, this.splitSize);
            OutputStreamTransport outputStreamTransport = new OutputStreamTransport(multiFileOutputStream);
            ITransport iTransport = new PacketTransport(outputStreamTransport);
            iTransport = this.enrichTransport(iTransport);
            return iTransport;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[MultiOutputFile:").append(this.baseName).append(",").append(this.suffix).append(",").append(this.numDigits).append(",").append(this.firstIndex).append(",").append(this.splitSize).append("]").toString();
    }
}

