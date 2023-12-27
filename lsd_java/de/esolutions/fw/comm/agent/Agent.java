/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.AgentWorker;
import de.esolutions.fw.comm.agent.IAgentDiagnosis;
import de.esolutions.fw.comm.agent.IAgentStateListener;
import de.esolutions.fw.comm.agent.client.ClientPool;
import de.esolutions.fw.comm.agent.client.ConnectionClientHandler;
import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.diag.DiagnosisReportGenerator;
import de.esolutions.fw.comm.agent.directory.IServiceQueryReply;
import de.esolutions.fw.comm.agent.naming.ConfigNameService;
import de.esolutions.fw.comm.agent.naming.INameService;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.core.ILifecycleListener;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceInstanceListener;
import de.esolutions.fw.comm.core.IServiceListener;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.util.commons.error.DefaultFatalErrorHandler;
import de.esolutions.fw.util.commons.error.ErrorHandlingRunnableWrapper;
import de.esolutions.fw.util.commons.error.IFatalErrorHandler;
import de.esolutions.fw.util.commons.error.IRunnableWrapper;
import de.esolutions.fw.util.config.fw.SystemConfig;
import de.esolutions.fw.util.serializer.connection.ConfigConnectionFactoryProvider;
import de.esolutions.fw.util.serializer.connection.ConnectionFactoryException;
import de.esolutions.fw.util.serializer.connection.IConnectionFactoryProvider;
import de.esolutions.fw.util.transport.config.TransportConfig;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;

public class Agent {
    public static final int NORMAL_OPERATION;
    public static final int NO_SPAWN_FACTORY;
    public static final int BROKER_ERROR;
    private static final short DYNAMIC_AGENT_ID;
    private static Agent theAgent;
    private static boolean started;
    private static String errorString;
    private static INameService defaultNameService;
    private static IConnectionFactoryProvider defaultConnectionFactoryProvider;
    private static Boolean defaultUseBroker;
    private static CommConfig defaultCommConfig;
    private static Boolean defaultDynamicAgentId;
    private static IFatalErrorHandler defaultFatalErrorHandler;
    private static ArrayList stateListeners;
    private final Thread thread;
    private final AgentWorker worker;
    private final boolean withBroker;

    public static void setNameService(INameService iNameService) {
        defaultNameService = iNameService;
    }

    public static void setConnectionFactoryProvider(IConnectionFactoryProvider iConnectionFactoryProvider) {
        defaultConnectionFactoryProvider = iConnectionFactoryProvider;
    }

    public static void setUseBroker(Boolean bl) {
        defaultUseBroker = bl;
    }

    public static void setCommConfig(CommConfig commConfig) {
        defaultCommConfig = commConfig;
    }

    public static void setUseDynamicAgentId(Boolean bl) {
        defaultDynamicAgentId = bl;
    }

    public static void setConfig(INameService iNameService, IConnectionFactoryProvider iConnectionFactoryProvider, boolean bl) {
        defaultNameService = iNameService;
        defaultConnectionFactoryProvider = iConnectionFactoryProvider;
        defaultUseBroker = new Boolean(bl);
    }

    public static void setFatalErrorHandler(IFatalErrorHandler iFatalErrorHandler) {
        defaultFatalErrorHandler = iFatalErrorHandler;
    }

    private static INameService getConfigNameService() {
        SystemConfig systemConfig = SystemConfig.getInstance();
        if (!systemConfig.isValid()) {
            CommAgentTracing.CONFIG.log((short)5, "agent system configuration failed: %1", (Object)systemConfig.getFailString());
            return null;
        }
        CommAgentTracing.CONFIG.log((short)0, "agent found valid system configuration");
        return new ConfigNameService(systemConfig);
    }

    private static IConnectionFactoryProvider getConfigConnectionFactoryProvider() {
        try {
            ConfigConnectionFactoryProvider configConnectionFactoryProvider = new ConfigConnectionFactoryProvider(TransportConfig.getInstance());
            CommAgentTracing.CONFIG.log((short)0, "agent created config connection factory provider");
            return configConnectionFactoryProvider;
        }
        catch (ConnectionFactoryException connectionFactoryException) {
            CommAgentTracing.CONFIG.log((short)5, "agent connection setup failed: %1", (Object)connectionFactoryException.getMessage());
            return null;
        }
    }

    public static synchronized Agent init() {
        IFatalErrorHandler iFatalErrorHandler;
        if (theAgent != null) {
            return theAgent;
        }
        INameService iNameService = defaultNameService;
        if (iNameService == null) {
            iNameService = Agent.getConfigNameService();
        }
        if (iNameService == null) {
            errorString = "error setting up config name service";
            return null;
        }
        IConnectionFactoryProvider iConnectionFactoryProvider = defaultConnectionFactoryProvider;
        if (iConnectionFactoryProvider == null) {
            iConnectionFactoryProvider = Agent.getConfigConnectionFactoryProvider();
        }
        if (iConnectionFactoryProvider == null) {
            errorString = "error setting up config connection factory prodiver";
            return null;
        }
        CommConfig commConfig = defaultCommConfig;
        if (commConfig == null) {
            commConfig = CommConfig.getInstance();
        }
        if (!commConfig.isValid()) {
            CommAgentTracing.CONFIG.log((short)5, "agent config invalid: %1", (Object)commConfig.getFailString());
            errorString = "error reading comm config";
            return null;
        }
        boolean bl = commConfig.getUseBroker();
        if (defaultUseBroker != null) {
            bl = defaultUseBroker;
        }
        if ((iFatalErrorHandler = defaultFatalErrorHandler) == null) {
            iFatalErrorHandler = new DefaultFatalErrorHandler(commConfig.getKillOnFatalError());
        }
        theAgent = new Agent(iNameService, iConnectionFactoryProvider, commConfig, bl, iFatalErrorHandler);
        Agent.notifyAgentStateListenersAgentStarted();
        return theAgent;
    }

    public static synchronized String getErrorString() {
        return errorString;
    }

    public static synchronized Agent start() {
        return Agent.start(null);
    }

    public static synchronized Agent start(ILifecycleListener iLifecycleListener) {
        if (theAgent == null) {
            Agent.init();
        }
        if (theAgent == null) {
            return null;
        }
        if (started) {
            return theAgent;
        }
        if (iLifecycleListener != null) {
            theAgent.registerAgentLifecycleListener(iLifecycleListener);
        }
        theAgent.startWorker();
        started = true;
        return theAgent;
    }

    public static synchronized Agent start(INameService iNameService, IConnectionFactoryProvider iConnectionFactoryProvider, boolean bl) {
        Agent.setConfig(iNameService, iConnectionFactoryProvider, bl);
        try {
            return Agent.start();
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static synchronized Agent start(INameService iNameService, IConnectionFactoryProvider iConnectionFactoryProvider, boolean bl, ILifecycleListener iLifecycleListener) {
        Agent.setConfig(iNameService, iConnectionFactoryProvider, bl);
        try {
            return Agent.start(iLifecycleListener);
        }
        catch (Exception exception) {
            return null;
        }
    }

    public static synchronized Agent getAgent() {
        return theAgent;
    }

    public static synchronized void stop() {
        if (theAgent != null) {
            theAgent.shutdown();
            theAgent = null;
            started = false;
            Agent.notifyAgentStateListenersAgentAboutToStop();
        }
    }

    public Agent(INameService iNameService, IConnectionFactoryProvider iConnectionFactoryProvider, CommConfig commConfig, boolean bl, IFatalErrorHandler iFatalErrorHandler) {
        int n = commConfig.getPriorities().getAgentThreadPrio();
        CommAgentTracing.CONFIG.log((short)2, "agent running on proc=%1 id=%2 node=%3 prio=%4", (Object)iNameService.getMyProcName(), (Object)new Short(iNameService.getMyID()), (Object)iNameService.getMyNodeName(), (Object)new Integer(n));
        boolean bl2 = false;
        if (defaultDynamicAgentId != null) {
            bl2 = defaultDynamicAgentId;
        }
        if (iNameService.getMyID() == 0) {
            bl2 = true;
        }
        ErrorHandlingRunnableWrapper errorHandlingRunnableWrapper = new ErrorHandlingRunnableWrapper(iFatalErrorHandler);
        this.worker = new AgentWorker(this, commConfig, iNameService, iConnectionFactoryProvider, bl, bl2, iFatalErrorHandler, errorHandlingRunnableWrapper);
        this.thread = new Thread(errorHandlingRunnableWrapper.wrap(this.worker), "commAgent");
        this.thread.setPriority(n);
        this.worker.registerAllStaticServices();
        this.withBroker = bl;
    }

    private void startWorker() {
        this.thread.start();
    }

    protected void shutdown() {
        if (this.worker.isDead()) {
            return;
        }
        this.worker.stop(0, null);
        this.worker.waitUntilDead();
    }

    public boolean waitUntilAlive() {
        return this.worker.waitUntilAlive();
    }

    public boolean waitUntilDead() {
        return this.worker.waitUntilDead();
    }

    public void registerService(IService iService) {
        if (iService == null) {
            return;
        }
        this.worker.registerService(iService, null, true);
    }

    public void registerService(IService iService, IServiceWorker iServiceWorker) {
        if (iService == null) {
            return;
        }
        this.worker.registerService(iService, iServiceWorker, true);
    }

    public void unregisterService(IService iService) {
        if (iService == null) {
            return;
        }
        this.worker.registerService(iService, null, false);
    }

    public void registerRemoteService(ServiceInstanceID serviceInstanceID, short s) {
        if (serviceInstanceID == null || s <= 0) {
            return;
        }
        this.worker.registerRemoteService(serviceInstanceID, s, true);
    }

    public void unregisterRemoteService(ServiceInstanceID serviceInstanceID, short s) {
        if (serviceInstanceID == null || s <= 0) {
            return;
        }
        this.worker.registerRemoteService(serviceInstanceID, s, false);
    }

    public void registerServiceInstanceListener(ServiceInstanceID serviceInstanceID, IServiceInstanceListener iServiceInstanceListener) {
        if (serviceInstanceID == null || iServiceInstanceListener == null) {
            return;
        }
        this.worker.registerServiceInstanceListener(serviceInstanceID, iServiceInstanceListener, true);
    }

    public void unregisterServiceInstanceListener(ServiceInstanceID serviceInstanceID, IServiceInstanceListener iServiceInstanceListener) {
        if (serviceInstanceID == null || iServiceInstanceListener == null) {
            return;
        }
        this.worker.registerServiceInstanceListener(serviceInstanceID, iServiceInstanceListener, false);
    }

    public void registerServiceListener(IService iService, IServiceListener iServiceListener) {
        if (iService == null || iServiceListener == null) {
            return;
        }
        this.worker.registerServiceListener(iService, iServiceListener, true);
    }

    public void unregisterServiceListener(IService iService, IServiceListener iServiceListener) {
        if (iService == null || iServiceListener == null) {
            return;
        }
        this.worker.registerServiceListener(iService, iServiceListener, false);
    }

    public void registerProxyListener(Proxy proxy, IProxyListener iProxyListener) {
        if (proxy == null || iProxyListener == null) {
            return;
        }
        this.worker.registerProxyListener(proxy, iProxyListener, true);
    }

    public void unregisterProxyListener(Proxy proxy, IProxyListener iProxyListener) {
        if (proxy == null || iProxyListener == null) {
            return;
        }
        this.worker.registerProxyListener(proxy, iProxyListener, false);
    }

    public boolean runsWithBroker() {
        return this.withBroker;
    }

    public void registerAgentLifecycleListener(ILifecycleListener iLifecycleListener) {
        if (iLifecycleListener == null) {
            return;
        }
        this.worker.registerLifecycleListener(iLifecycleListener);
    }

    public void unregisterAgentLifecycleListener(ILifecycleListener iLifecycleListener) {
        if (iLifecycleListener == null) {
            return;
        }
        this.worker.unregisterLifecycleListener(iLifecycleListener);
    }

    public void pingControl(String string) {
        this.worker.pingControl(string);
    }

    public void forceDisconnect(short s) {
        this.worker.forceDisconnect(s);
    }

    public void setTracePeer(short s) {
        this.worker.setTracePeer(s);
    }

    public boolean sendCustomMessage(short s, byte by, byte[] byArray) {
        ClientPool clientPool = this.worker.getClientPool();
        IClientHandler iClientHandler = clientPool.requestConnection(s, false);
        if (iClientHandler instanceof ConnectionClientHandler) {
            ((ConnectionClientHandler)iClientHandler).sendCustomMessage(by, byArray);
            return true;
        }
        return false;
    }

    public int getReturnCode() {
        return this.worker.getReturnCode();
    }

    public String getReturnCodeErrorString() {
        return this.worker.getReturnCodeErrorString();
    }

    public IFatalErrorHandler getFatalErrorHandler() {
        return this.worker.getFatalErrorHandler();
    }

    public IRunnableWrapper getRunnableWrapper() {
        return this.worker.getRunnableWrapper();
    }

    public void queryService(ServiceInstanceID serviceInstanceID, IServiceQueryReply iServiceQueryReply) {
        this.worker.queryService(serviceInstanceID, iServiceQueryReply);
    }

    public void queryAllServices(IServiceQueryReply iServiceQueryReply) {
        this.worker.queryService(null, iServiceQueryReply);
    }

    public IAgentDiagnosis getAgentDiagnosis() {
        return this.worker.getAgentDiagnosis();
    }

    public void writeDiagnosisReport(PrintStream printStream) {
        IAgentDiagnosis iAgentDiagnosis = this.worker.getAgentDiagnosis();
        DiagnosisReportGenerator diagnosisReportGenerator = new DiagnosisReportGenerator(printStream, true);
        diagnosisReportGenerator.generate(iAgentDiagnosis);
    }

    public short getAgentId() {
        return this.worker.getMyAgentId();
    }

    public void setAgentReconnect(boolean bl) {
        this.worker.setAgentReconnects(bl);
    }

    public static synchronized void registerAgentStateListener(IAgentStateListener iAgentStateListener) {
        if (!stateListeners.contains(iAgentStateListener)) {
            stateListeners.add(iAgentStateListener);
        }
        if (theAgent != null) {
            iAgentStateListener.agentStarted(theAgent);
        }
    }

    public static synchronized void unregisterAgentStateListener(IAgentStateListener iAgentStateListener) {
        if (stateListeners.contains(iAgentStateListener)) {
            stateListeners.remove(iAgentStateListener);
        }
    }

    private static void notifyAgentStateListenersAgentStarted() {
        Iterator iterator = stateListeners.iterator();
        while (iterator.hasNext()) {
            IAgentStateListener iAgentStateListener = (IAgentStateListener)iterator.next();
            iAgentStateListener.agentStarted(theAgent);
        }
    }

    private static void notifyAgentStateListenersAgentAboutToStop() {
        Iterator iterator = stateListeners.iterator();
        while (iterator.hasNext()) {
            IAgentStateListener iAgentStateListener = (IAgentStateListener)iterator.next();
            iAgentStateListener.agentAboutToStop(theAgent);
        }
    }

    static {
        theAgent = null;
        started = false;
        errorString = null;
        defaultNameService = null;
        defaultConnectionFactoryProvider = null;
        defaultUseBroker = null;
        defaultCommConfig = null;
        defaultDynamicAgentId = null;
        defaultFatalErrorHandler = null;
        stateListeners = new ArrayList();
    }
}

