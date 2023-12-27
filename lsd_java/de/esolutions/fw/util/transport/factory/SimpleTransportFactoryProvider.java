/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.transport.exception.TransportFactoryException;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ITransportFactoryProvider;
import de.esolutions.fw.util.transport.factory.SimpleTransportFactoryProvider$AddressPort;
import de.esolutions.fw.util.transport.factory.TCPSingleTransportFactory;
import de.esolutions.fw.util.transport.factory.TCPSpawnTransportFactory;
import java.io.IOException;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Map;

public class SimpleTransportFactoryProvider
implements ITransportFactoryProvider {
    protected String myProcName;
    protected Map procMap;
    protected Map nodeMap;

    public SimpleTransportFactoryProvider(String string) {
        this.myProcName = string;
        this.procMap = new HashMap();
        this.nodeMap = new HashMap();
    }

    public void addTCPConnection(String string, String string2, String string3, String string4, int n) {
        SimpleTransportFactoryProvider$AddressPort simpleTransportFactoryProvider$AddressPort = new SimpleTransportFactoryProvider$AddressPort(string4, n);
        this.procMap.put(new StringBuffer().append(string).append(":").append(string2).toString(), simpleTransportFactoryProvider$AddressPort);
        this.nodeMap.put(new StringBuffer().append(string).append(":").append(string2).append(":").append(string3).toString(), simpleTransportFactoryProvider$AddressPort);
    }

    @Override
    public ISingleTransportFactory createSingleTransportFactory(String string, String string2) {
        SimpleTransportFactoryProvider$AddressPort simpleTransportFactoryProvider$AddressPort = (SimpleTransportFactoryProvider$AddressPort)this.procMap.get(new StringBuffer().append(string).append(":").append(string2).toString());
        if (simpleTransportFactoryProvider$AddressPort == null) {
            throw new TransportFactoryException(new StringBuffer().append("transport for proc ").append(string).append(":").append(string2).append(" not found!").toString());
        }
        try {
            InetAddress inetAddress = InetAddress.getByName(simpleTransportFactoryProvider$AddressPort.address);
            return new TCPSingleTransportFactory(inetAddress, simpleTransportFactoryProvider$AddressPort.port);
        }
        catch (IOException iOException) {
            throw new TransportFactoryException(new StringBuffer().append("Failed IO: ").append(iOException).toString());
        }
    }

    @Override
    public ISpawnTransportFactory createSpawnTransportFactory(String string, String string2) {
        SimpleTransportFactoryProvider$AddressPort simpleTransportFactoryProvider$AddressPort = (SimpleTransportFactoryProvider$AddressPort)this.nodeMap.get(new StringBuffer().append(string).append(":").append(this.myProcName).append(":").append(string2).toString());
        if (simpleTransportFactoryProvider$AddressPort == null) {
            throw new TransportFactoryException(new StringBuffer().append("transport for node ").append(string).append(":").append(string2).append(" not found!").toString());
        }
        try {
            InetAddress inetAddress = InetAddress.getByName(simpleTransportFactoryProvider$AddressPort.address);
            return new TCPSpawnTransportFactory(inetAddress, simpleTransportFactoryProvider$AddressPort.port);
        }
        catch (IOException iOException) {
            throw new TransportFactoryException(new StringBuffer().append("Failed IO: ").append(iOException).toString());
        }
    }
}

