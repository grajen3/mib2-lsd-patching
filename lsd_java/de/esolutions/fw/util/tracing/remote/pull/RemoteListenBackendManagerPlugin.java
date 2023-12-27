/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.remote.pull;

import de.esolutions.fw.util.commons.traceme.TraceMe;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.serializer.connection.ConfigConnectionFactoryProvider;
import de.esolutions.fw.util.serializer.connection.ConnectionFactoryException;
import de.esolutions.fw.util.serializer.connection.GenericSpawnConnectionFactory;
import de.esolutions.fw.util.serializer.connection.ISpawnConnectionFactory;
import de.esolutions.fw.util.serializer.factory.BEDefaultSerializerFactory;
import de.esolutions.fw.util.tracing.config.TraceConfigPlugin;
import de.esolutions.fw.util.tracing.frontend.TraceFrontend;
import de.esolutions.fw.util.tracing.plugin.ITracePlugin;
import de.esolutions.fw.util.tracing.remote.pull.RemoteListenBackendManager;
import de.esolutions.fw.util.transport.config.TransportConfig;
import de.esolutions.fw.util.transport.factory.TCPSpawnTransportFactory;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class RemoteListenBackendManagerPlugin
implements ITracePlugin {
    private RemoteListenBackendManager mgr;
    private static final String chn;

    @Override
    public void start(TraceFrontend traceFrontend, TraceConfigPlugin traceConfigPlugin) {
        TraceMe.msg(TraceMe.TRACE, "RemotenListManagerBackend", "start");
        IConfigQuery iConfigQuery = traceConfigPlugin.getQuery();
        ISpawnConnectionFactory iSpawnConnectionFactory = null;
        String string = iConfigQuery.getStringValue("transportService");
        if (string != null) {
            iSpawnConnectionFactory = this.createFactoryForTransportService(string);
        }
        if (iSpawnConnectionFactory == null) {
            String string2 = iConfigQuery.getStringValue("host");
            short s = (short)iConfigQuery.getIntegerValue("port", 0);
            if (string2 != null && s != 0) {
                iSpawnConnectionFactory = this.createFactoryWithHostAndPort(string2, s);
            }
        }
        if (iSpawnConnectionFactory == null) {
            iSpawnConnectionFactory = this.createFactoryWithHostAndPort("localhost", (short)21002);
        }
        boolean bl = iConfigQuery.getBooleanValue("forceActive", true);
        if (iSpawnConnectionFactory != null) {
            this.mgr = new RemoteListenBackendManager(iSpawnConnectionFactory, traceFrontend, null);
            this.mgr.setForceActive(bl);
            this.mgr.start();
        } else {
            TraceMe.msg(TraceMe.ERROR, "RemotenListManagerBackend", "can't start!");
        }
    }

    @Override
    public void stop() {
        TraceMe.msg(TraceMe.TRACE, "RemotenListManagerBackend", "stop");
        if (this.mgr != null) {
            this.mgr.stop();
        }
    }

    private ISpawnConnectionFactory createFactoryForTransportService(String string) {
        TransportConfig transportConfig = TransportConfig.getInstance();
        if (!transportConfig.isValid()) {
            TraceMe.msg(TraceMe.ERROR, "RemotenListManagerBackend", "transport config invalid!");
            return null;
        }
        String string2 = transportConfig.getSystemConfig().getMyNodeName();
        try {
            ConfigConnectionFactoryProvider configConnectionFactoryProvider = new ConfigConnectionFactoryProvider(transportConfig);
            ISpawnConnectionFactory iSpawnConnectionFactory = configConnectionFactoryProvider.createSpawnConnectionFactory(string, string2);
            TraceMe.msg(TraceMe.INFO, "RemotenListManagerBackend", "using transport service: %1", string);
            return iSpawnConnectionFactory;
        }
        catch (ConnectionFactoryException connectionFactoryException) {
            TraceMe.msg(TraceMe.ERROR, "RemotenListManagerBackend", "Unknown remote listen backend service: %1", string);
            return null;
        }
    }

    private ISpawnConnectionFactory createFactoryWithHostAndPort(String string, short s) {
        TCPSpawnTransportFactory tCPSpawnTransportFactory = null;
        try {
            tCPSpawnTransportFactory = new TCPSpawnTransportFactory(InetAddress.getByName(string), (int)s);
            TraceMe.msg(TraceMe.INFO, "RemotenListManagerBackend", "using host: %1:%2", string, new Short(s));
        }
        catch (UnknownHostException unknownHostException) {
            TraceMe.msg(TraceMe.ERROR, "RemotenListManagerBackend", "Unknown remote listen backend host: %1", string);
            return null;
        }
        BEDefaultSerializerFactory bEDefaultSerializerFactory = new BEDefaultSerializerFactory();
        GenericSpawnConnectionFactory genericSpawnConnectionFactory = new GenericSpawnConnectionFactory(tCPSpawnTransportFactory, bEDefaultSerializerFactory);
        return genericSpawnConnectionFactory;
    }
}

