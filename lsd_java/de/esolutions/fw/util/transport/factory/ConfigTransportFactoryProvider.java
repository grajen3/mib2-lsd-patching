/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.factory;

import de.esolutions.fw.util.config.query.ConfigOverlayPathQuery;
import de.esolutions.fw.util.transport.config.ResManTransportParam;
import de.esolutions.fw.util.transport.config.TCPTransportParam;
import de.esolutions.fw.util.transport.config.TSTransportParam;
import de.esolutions.fw.util.transport.config.TransportConfig;
import de.esolutions.fw.util.transport.exception.TransportFactoryException;
import de.esolutions.fw.util.transport.factory.FileSingleTransportFactory;
import de.esolutions.fw.util.transport.factory.ISingleTransportFactory;
import de.esolutions.fw.util.transport.factory.ISpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.ITransportFactoryProvider;
import de.esolutions.fw.util.transport.factory.TCPSingleTransportFactory;
import de.esolutions.fw.util.transport.factory.TCPSpawnTransportFactory;
import de.esolutions.fw.util.transport.factory.TSSingleTransportFactory;
import de.esolutions.fw.util.transport.factory.TSSpawnTransportFactory;

public class ConfigTransportFactoryProvider
implements ITransportFactoryProvider {
    private TransportConfig config;

    public ConfigTransportFactoryProvider(TransportConfig transportConfig) {
        this.config = transportConfig;
        if (!transportConfig.isValid()) {
            throw new TransportFactoryException(new StringBuffer().append("Can't create factory provider from invalid config:\n").append(transportConfig.getFailString()).toString());
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    @Override
    public ISingleTransportFactory createSingleTransportFactory(String string, String string2) {
        ConfigOverlayPathQuery configOverlayPathQuery = this.config.getQueryForService(string, string2);
        if (configOverlayPathQuery == null) {
            throw new TransportFactoryException(new StringBuffer().append("No transport defined for proc ").append(string).append(":").append(string2).toString());
        }
        String string3 = configOverlayPathQuery.getStringValue("mode");
        if (string3 != null) {
            if (string3.equals("tcpip")) {
                TCPTransportParam tCPTransportParam = TCPTransportParam.create(configOverlayPathQuery);
                if (tCPTransportParam == null) throw new TransportFactoryException(new StringBuffer().append("Can't create 'tcpip' transport for proc ").append(string).append(":").append(string2).toString());
                TCPSingleTransportFactory tCPSingleTransportFactory = new TCPSingleTransportFactory(tCPTransportParam.getAddress(), tCPTransportParam.getPort());
                tCPSingleTransportFactory.setOptions(tCPTransportParam.getOptions());
                return tCPSingleTransportFactory;
            }
            if (string3.equals("resman")) {
                ResManTransportParam resManTransportParam = ResManTransportParam.create(configOverlayPathQuery);
                if (resManTransportParam == null) throw new TransportFactoryException(new StringBuffer().append("Can't create 'resman' transport for proc ").append(string).append(":").append(string2).toString());
                return new FileSingleTransportFactory(resManTransportParam.getPath());
            }
            if (!string3.equals("ts")) throw new TransportFactoryException(new StringBuffer().append("Invalid transport mode ").append(string3).append(" on node ").append(string).append(":").append(string2).toString());
            TSTransportParam tSTransportParam = TSTransportParam.create(configOverlayPathQuery);
            if (tSTransportParam == null) throw new TransportFactoryException(new StringBuffer().append("No supported transport defined for ").append(string).append(":").append(string2).toString());
            return new TSSingleTransportFactory(tSTransportParam.getMountpoint(), tSTransportParam.getFile());
        }
        TCPTransportParam tCPTransportParam = TCPTransportParam.create(configOverlayPathQuery);
        if (tCPTransportParam != null) {
            TCPSingleTransportFactory tCPSingleTransportFactory = new TCPSingleTransportFactory(tCPTransportParam.getAddress(), tCPTransportParam.getPort());
            tCPSingleTransportFactory.setOptions(tCPTransportParam.getOptions());
            return tCPSingleTransportFactory;
        }
        ResManTransportParam resManTransportParam = ResManTransportParam.create(configOverlayPathQuery);
        if (resManTransportParam == null) throw new TransportFactoryException(new StringBuffer().append("No supported transport defined for ").append(string).append(":").append(string2).toString());
        return new FileSingleTransportFactory(resManTransportParam.getPath());
    }

    @Override
    public ISpawnTransportFactory createSpawnTransportFactory(String string, String string2) {
        ConfigOverlayPathQuery configOverlayPathQuery = this.config.getQueryForMyService(string, string2);
        if (configOverlayPathQuery == null) {
            throw new TransportFactoryException(new StringBuffer().append("No transport defined for node ").append(string).append(":").append(string2).toString());
        }
        String string3 = configOverlayPathQuery.getStringValue("mode");
        if (string3 != null) {
            if (string3.equals("tcpip")) {
                TCPTransportParam tCPTransportParam = TCPTransportParam.create(configOverlayPathQuery);
                if (tCPTransportParam != null) {
                    TCPSpawnTransportFactory tCPSpawnTransportFactory = new TCPSpawnTransportFactory(tCPTransportParam.getAddress(), tCPTransportParam.getPort());
                    tCPSpawnTransportFactory.setOptions(tCPTransportParam.getOptions());
                    return tCPSpawnTransportFactory;
                }
                throw new TransportFactoryException(new StringBuffer().append("No transport defined for mode 'tcpip' on node ").append(string).append(":").append(string2).toString());
            }
            if (string3.equals("ts")) {
                TSTransportParam tSTransportParam = TSTransportParam.create(configOverlayPathQuery);
                if (tSTransportParam != null) {
                    return new TSSpawnTransportFactory(tSTransportParam.getMountpoint(), tSTransportParam.getFile());
                }
                throw new TransportFactoryException(new StringBuffer().append("No transport defined for mode 'ts' on node ").append(string).append(":").append(string2).toString());
            }
            throw new TransportFactoryException(new StringBuffer().append("Invalid transport mode ").append(string3).append(" on node ").append(string).append(":").append(string2).toString());
        }
        TCPTransportParam tCPTransportParam = TCPTransportParam.create(configOverlayPathQuery);
        if (tCPTransportParam != null) {
            TCPSpawnTransportFactory tCPSpawnTransportFactory = new TCPSpawnTransportFactory(tCPTransportParam.getAddress(), tCPTransportParam.getPort());
            tCPSpawnTransportFactory.setOptions(tCPTransportParam.getOptions());
            return tCPSpawnTransportFactory;
        }
        throw new TransportFactoryException(new StringBuffer().append("No supported own transport defined for ").append(string).append(":").append(string2).toString());
    }
}

