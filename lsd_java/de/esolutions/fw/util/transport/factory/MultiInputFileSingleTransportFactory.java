/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.ITransport;
import de.esolutions.fw.util.transport.factory.BaseTransportFactory;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.packet.PacketTransport;
import de.esolutions.fw.util.transport.socket.InputStreamTransport;
import de.esolutions.fw.util.transport.socket.MultiFileInputStream;
import java.io.FileNotFoundException;

public class MultiInputFileSingleTransportFactory
extends BaseTransportFactory
implements ISingleTransportFactory {
    String baseName;
    String suffix;
    int numDigits;
    int firstIndex;

    public MultiInputFileSingleTransportFactory(String string, String string2, int n, int n2) {
        this.baseName = string;
        this.suffix = string2;
        this.numDigits = n;
        this.firstIndex = n2;
    }

    @Override
    public ITransport createTransport() {
        try {
            MultiFileInputStream multiFileInputStream = new MultiFileInputStream(this.baseName, this.suffix, this.numDigits, this.firstIndex);
            InputStreamTransport inputStreamTransport = new InputStreamTransport(multiFileInputStream);
            ITransport iTransport = new PacketTransport(inputStreamTransport);
            iTransport = this.enrichTransport(iTransport);
            return iTransport;
        }
        catch (FileNotFoundException fileNotFoundException) {
            return null;
        }
    }

    @Override
    public String getDescription() {
        return new StringBuffer().append("[MultiInputFile:").append(this.baseName).append(",").append(this.suffix).append(",").append(this.numDigits).append(",").append(this.firstIndex).append("]").toString();
    }
}

