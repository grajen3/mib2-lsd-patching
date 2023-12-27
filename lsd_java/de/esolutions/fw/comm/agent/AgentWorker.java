/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.agent;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.agent.AgentLifecycleDispatcher;
import de.esolutions.fw.comm.agent.AgentWorker$1;
import de.esolutions.fw.comm.agent.AgentWorker$2;
import de.esolutions.fw.comm.agent.AgentWorker$3;
import de.esolutions.fw.comm.agent.AgentWorker$AgentTimer;
import de.esolutions.fw.comm.agent.IAgentDiagnosis;
import de.esolutions.fw.comm.agent.agentdir.AgentDirectory;
import de.esolutions.fw.comm.agent.broker.AgentBrokerManager;
import de.esolutions.fw.comm.agent.broker.BrokerAgentUpdate;
import de.esolutions.fw.comm.agent.broker.BrokerServiceUpdate;
import de.esolutions.fw.comm.agent.broker.IBrokerServiceListener;
import de.esolutions.fw.comm.agent.client.ClientException;
import de.esolutions.fw.comm.agent.client.ClientPool;
import de.esolutions.fw.comm.agent.client.IClientHandler;
import de.esolutions.fw.comm.agent.client.IClientHandlerListener;
import de.esolutions.fw.comm.agent.client.SpawnList;
import de.esolutions.fw.comm.agent.command.BrokerAgentUpdateCommand;
import de.esolutions.fw.comm.agent.command.BrokerProxyAliveCommand;
import de.esolutions.fw.comm.agent.command.BrokerServiceUdpateCommand;
import de.esolutions.fw.comm.agent.command.ClientHandlerUpdateCommand;
import de.esolutions.fw.comm.agent.command.Command;
import de.esolutions.fw.comm.agent.command.ConnectBrokerLinkCommand;
import de.esolutions.fw.comm.agent.command.ConnectProxyCommand;
import de.esolutions.fw.comm.agent.command.DisconnectProxyCommand;
import de.esolutions.fw.comm.agent.command.ForceDisconnectCommand;
import de.esolutions.fw.comm.agent.command.ICommandExecutor;
import de.esolutions.fw.comm.agent.command.LookupServiceCommand;
import de.esolutions.fw.comm.agent.command.PostponedCommandMap;
import de.esolutions.fw.comm.agent.command.QueryServiceCommand;
import de.esolutions.fw.comm.agent.command.QuitCommand;
import de.esolutions.fw.comm.agent.command.RegisterProxyListenerCommand;
import de.esolutions.fw.comm.agent.command.RegisterRemoteServiceCommand;
import de.esolutions.fw.comm.agent.command.RegisterServiceCommand;
import de.esolutions.fw.comm.agent.command.RegisterServiceInstanceListenerCommand;
import de.esolutions.fw.comm.agent.command.RegisterServiceListenerCommand;
import de.esolutions.fw.comm.agent.command.SetupBrokerLinkCommand;
import de.esolutions.fw.comm.agent.command.SetupProxyCommand;
import de.esolutions.fw.comm.agent.command.TerminateCommand;
import de.esolutions.fw.comm.agent.command.TimerCommand;
import de.esolutions.fw.comm.agent.config.CommConfig;
import de.esolutions.fw.comm.agent.config.CommConfigTracing;
import de.esolutions.fw.comm.agent.diag.AgentDiagnosis;
import de.esolutions.fw.comm.agent.diag.AgentErrorLog;
import de.esolutions.fw.comm.agent.directory.DirectoryEntry;
import de.esolutions.fw.comm.agent.directory.IServiceDirectory;
import de.esolutions.fw.comm.agent.directory.IServiceQueryReply;
import de.esolutions.fw.comm.agent.directory.VolatileServiceDirectory;
import de.esolutions.fw.comm.agent.naming.INameService;
import de.esolutions.fw.comm.agent.notification.NotificationCenter;
import de.esolutions.fw.comm.agent.service.IServiceHandlerCallback;
import de.esolutions.fw.comm.agent.service.IServiceHandlerListener;
import de.esolutions.fw.comm.agent.service.ServiceHandler;
import de.esolutions.fw.comm.agent.service.ServiceIKChecker;
import de.esolutions.fw.comm.agent.service.ServiceRegistry;
import de.esolutions.fw.comm.agent.tracing.CommAgentTracing;
import de.esolutions.fw.comm.agent.watch.MemWatch;
import de.esolutions.fw.comm.core.ILifecycleListener;
import de.esolutions.fw.comm.core.IProxyConnector;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.IReplyService;
import de.esolutions.fw.comm.core.IService;
import de.esolutions.fw.comm.core.IServiceInstanceListener;
import de.esolutions.fw.comm.core.IServiceListener;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.IStub;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.protocol.IProtocolCallbacks;
import de.esolutions.fw.comm.core.tracing.CommMessageTracing;
import de.esolutions.fw.comm.core.tracing.ProxyTracing;
import de.esolutions.fw.comm.core.tracing.StubTracing;
import de.esolutions.fw.util.commons.error.IFatalErrorHandler;
import de.esolutions.fw.util.commons.error.IRunnableWrapper;
import de.esolutions.fw.util.commons.queue.Queue;
import de.esolutions.fw.util.commons.queue.QueueShutdownException;
import de.esolutions.fw.util.commons.timeout.ITimeSource;
import de.esolutions.fw.util.commons.timeout.TimeSourceProvider;
import de.esolutions.fw.util.commons.version.RuntimeVersion;
import de.esolutions.fw.util.serializer.connection.ConnectionFactoryException;
import de.esolutions.fw.util.serializer.connection.IConnectionFactoryProvider;
import de.esolutions.fw.util.tracing.ITraceCallback;
import de.esolutions.fw.util.tracing.TraceClient;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;

public final class AgentWorker
implements Runnable,
ICommandExecutor,
IServiceHandlerListener,
IProxyConnector,
IBrokerServiceListener,
IClientHandlerListener,
IProtocolCallbacks,
ITraceCallback {
    private CommConfig config;
    private INameService nameService;
    private IConnectionFactoryProvider connectionFactoryProvider;
    private ServiceRegistry serviceRegistry;
    private IServiceDirectory serviceDirectory;
    private AgentDirectory agentDirectory;
    private NotificationCenter notificationCenter;
    private ClientPool clientPool;
    private Queue commandQueue;
    private PostponedCommandMap postponedInstanceCommands;
    private PostponedCommandMap postponedClientCommands;
    private boolean brokerIsAlive;
    private Object brokerLock = new Object();
    private Lifecycle lifecycle;
    private AgentLifecycleDispatcher lifecycleDispatcher;
    private boolean withBroker;
    private boolean dynamicAgentId;
    private int maxBrokerConnectRetries;
    private int curBrokerConnectRetries;
    private short myAgentID;
    private int returnCode;
    private String errorString;
    private SpawnList spawnList;
    private AgentWorker$AgentTimer timer;
    private int aliveCounter;
    private int aliveRate;
    private AgentBrokerManager brokerManager;
    private static final int REPLY_HANDLE_MASK;
    private static final short LOCAL_AGENT;
    private MemWatch memWatch;
    private final ServiceIKChecker ikChecker;
    private final AgentErrorLog errorLog;
    private final AgentDiagnosis diagnosis;
    private int totalCommandCount;
    private int dumpModelCB;
    private final ITimeSource monoTime;
    private final IFatalErrorHandler fatalErrorHandler;
    private final IRunnableWrapper runnableWrapper;
    private boolean agentReconnect = true;

    public AgentWorker(Agent agent, CommConfig commConfig, INameService iNameService, IConnectionFactoryProvider iConnectionFactoryProvider, boolean bl, boolean bl2, IFatalErrorHandler iFatalErrorHandler, IRunnableWrapper iRunnableWrapper) {
        this.config = commConfig;
        this.monoTime = TimeSourceProvider.getMonotonicTimeSource();
        this.fatalErrorHandler = iFatalErrorHandler;
        this.runnableWrapper = iRunnableWrapper;
        this.nameService = iNameService;
        this.connectionFactoryProvider = iConnectionFactoryProvider;
        this.serviceRegistry = new ServiceRegistry(this, commConfig, iNameService.getMyID(), this.monoTime, iRunnableWrapper);
        this.serviceDirectory = new VolatileServiceDirectory();
        this.agentDirectory = new AgentDirectory();
        this.notificationCenter = new NotificationCenter(commConfig, this.monoTime);
        this.lifecycleDispatcher = new AgentLifecycleDispatcher();
        this.lifecycle = new Lifecycle(this);
        this.lifecycle.setListener(this.lifecycleDispatcher);
        this.withBroker = bl;
        this.myAgentID = iNameService.getMyID();
        this.dynamicAgentId = bl2;
        this.ikChecker = new ServiceIKChecker(commConfig.getIgnoreIK());
        this.errorLog = new AgentErrorLog(commConfig.getErrorLogSize());
        this.clientPool = new ClientPool(this.myAgentID, iConnectionFactoryProvider, this.serviceRegistry, iNameService, commConfig, this, this, this.agentDirectory, bl, this.ikChecker, this.errorLog, this.dynamicAgentId, this, this.monoTime, iRunnableWrapper);
        this.commandQueue = new Queue(commConfig.getCommandQueueSize());
        this.postponedInstanceCommands = new PostponedCommandMap();
        this.postponedClientCommands = new PostponedCommandMap();
        if (commConfig.getEnableMemWatch()) {
            this.memWatch = new MemWatch(this.monoTime);
            this.memWatch.setMarker(commConfig.getCheckLowMemKiB(), commConfig.getCheckCriticalMemKiB());
            this.memWatch.setMinDuration(commConfig.getCheckMemMinDuration());
            this.memWatch.setFatalErrorDuration(commConfig.getFatalErrorOnLowMem(), commConfig.getFatalErrorOnCriticalMem(), iFatalErrorHandler);
        }
        Proxy.setProxyConnector(this);
        int n = commConfig.getCommandTimePulse();
        if (n < 100) {
            n = 100;
        }
        this.timer = new AgentWorker$AgentTimer(this, this.commandQueue, n);
        this.timer.start();
        this.aliveRate = commConfig.getCommandTimeAlive() / n;
        this.aliveCounter = 0;
        if (bl) {
            this.brokerManager = new AgentBrokerManager(this.myAgentID, 0, this, commConfig, this.lifecycleDispatcher, this.monoTime, iRunnableWrapper);
            this.maxBrokerConnectRetries = commConfig.getBrokerConnectRetries();
            this.curBrokerConnectRetries = 0;
        }
        this.diagnosis = new AgentDiagnosis(this.clientPool, this, this.errorLog, this.serviceRegistry, this.serviceDirectory, commConfig.getDoctorConfig());
        this.setupCommTracing();
        this.returnCode = 0;
        CommAgentTracing.AGENT.log((short)2, "FRAMEWORK_VERSION=%1", (Object)RuntimeVersion.getFWVersion());
        this.dumpModelCB = TraceClient.registerTraceCallback("FW_COMM_DumpModel", this);
    }

    private void setupCommTracing() {
        CommConfigTracing commConfigTracing = this.config.getTracing();
        if (commConfigTracing.isEnabled()) {
            CommMessageTracing commMessageTracing = new CommMessageTracing();
            commMessageTracing.setVersion(commConfigTracing.getVersion());
            commMessageTracing.setFlagMask(commConfigTracing.getFlags());
            commMessageTracing.setTruncatedPayloadSize(commConfigTracing.getTruncatePayloadSize());
            commMessageTracing.setMyAgentID(this.myAgentID);
            ProxyTracing.setTracing(commMessageTracing);
            StubTracing.setTracing(commMessageTracing);
        }
    }

    public void setAgentReconnects(boolean bl) {
        if (bl) {
            this.curBrokerConnectRetries = 0;
        }
        this.agentReconnect = bl;
    }

    public boolean waitUntilAlive() {
        return this.lifecycle.waitUntilAlive();
    }

    public boolean waitUntilDead() {
        return this.lifecycle.waitUntilDead();
    }

    public boolean isDead() {
        return this.lifecycle.isDead();
    }

    public boolean isAlive() {
        return this.lifecycle.isAlive();
    }

    public void registerLifecycleListener(ILifecycleListener iLifecycleListener) {
        this.lifecycleDispatcher.register(iLifecycleListener);
    }

    public void unregisterLifecycleListener(ILifecycleListener iLifecycleListener) {
        this.lifecycleDispatcher.unregister(iLifecycleListener);
    }

    public int getReturnCode() {
        return this.returnCode;
    }

    public String getReturnCodeErrorString() {
        return this.errorString;
    }

    public IAgentDiagnosis getAgentDiagnosis() {
        return this.diagnosis;
    }

    public short getMyAgentId() {
        return this.myAgentID;
    }

    public IFatalErrorHandler getFatalErrorHandler() {
        return this.fatalErrorHandler;
    }

    public IRunnableWrapper getRunnableWrapper() {
        return this.runnableWrapper;
    }

    protected void enqueueCommand(Command command) {
        CommAgentTracing.AGENT.log((short)0, "enqueueCommand: %1 ", (Object)super.getClass().getName());
        try {
            command.setCreateTime(this.monoTime.getCurrentTime());
            if (this.commandQueue.put(command)) {
                CommAgentTracing.AGENT.log((short)3, "Command queue is in high water range! queue size=%1", new Integer(this.commandQueue.size()));
            }
            ++this.totalCommandCount;
        }
        catch (QueueShutdownException queueShutdownException) {
            CommAgentTracing.AGENT.log((short)4, "Failed enqueueing command %1: %2", command, (Object)queueShutdownException);
        }
    }

    public void stop(int n, String string) {
        CommAgentTracing.AGENT.log((short)3, "stopping agent with return code=%1, error string=%2", new Integer(n), (Object)string);
        this.returnCode = n;
        this.errorString = string;
        this.enqueueCommand(new QuitCommand());
    }

    private void setReplyServiceHandle(IReplyService iReplyService) {
        ServiceInstanceID serviceInstanceID = iReplyService.getInstanceID();
        int n = serviceInstanceID.getHandle();
        serviceInstanceID = new ServiceInstanceID(serviceInstanceID.getServiceUUID(), n |= 0x80 | this.clientPool.getMyAgentID() << 16, serviceInstanceID.getInterfaceKey());
        iReplyService.setInstanceID(serviceInstanceID);
    }

    public void registerService(IService iService, IServiceWorker iServiceWorker, boolean bl) {
        CommAgentTracing.AGENT.log((short)2, "%1 service %2", (Object)(bl ? "register" : "unregister"), (Object)iService.getInstanceID());
        if (iServiceWorker == null && bl) {
            CommAgentTracing.AGENT.log((short)3, "Service without ServiceWorker registered for service %1 ", iService.getInstanceID());
        }
        this.enqueueCommand(new RegisterServiceCommand(iService, iServiceWorker, bl));
    }

    public void registerAllStaticServices() {
        Map map;
        if (!this.withBroker && (map = this.config.getAllStaticServices()) != null) {
            Set set = map.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map$Entry map$Entry = (Map$Entry)iterator.next();
                short s = (Short)map$Entry.getKey();
                ServiceInstanceID[] serviceInstanceIDArray = (ServiceInstanceID[])map$Entry.getValue();
                for (int i2 = 0; i2 < serviceInstanceIDArray.length; ++i2) {
                    this.registerRemoteService(serviceInstanceIDArray[i2], s, true);
                    CommAgentTracing.CONFIG.log((short)2, "registering static service %1 for agent %2", serviceInstanceIDArray[i2], (Object)new Short(s));
                }
            }
        }
    }

    @Override
    public void registerRemoteReplyService(ServiceInstanceID serviceInstanceID, short s) {
        this.registerRemoteService(serviceInstanceID, s, true);
    }

    @Override
    public void unregisterRemoteReplyService(ServiceInstanceID serviceInstanceID, short s) {
        this.registerRemoteService(serviceInstanceID, s, false);
    }

    public void registerRemoteService(ServiceInstanceID serviceInstanceID, short s, boolean bl) {
        this.enqueueCommand(new RegisterRemoteServiceCommand(serviceInstanceID, s, bl));
    }

    public void registerServiceInstanceListener(ServiceInstanceID serviceInstanceID, IServiceInstanceListener iServiceInstanceListener, boolean bl) {
        this.enqueueCommand(new RegisterServiceInstanceListenerCommand(serviceInstanceID, iServiceInstanceListener, bl));
    }

    public void registerServiceListener(IService iService, IServiceListener iServiceListener, boolean bl) {
        this.enqueueCommand(new RegisterServiceListenerCommand(iService, iServiceListener, bl));
    }

    @Override
    public void registerProxyListener(Proxy proxy, IProxyListener iProxyListener, boolean bl) {
        this.enqueueCommand(new RegisterProxyListenerCommand(proxy, iProxyListener, bl));
    }

    @Override
    public void serviceUpdate(BrokerServiceUpdate[] brokerServiceUpdateArray) {
        this.enqueueCommand(new BrokerServiceUdpateCommand(brokerServiceUpdateArray));
    }

    @Override
    public void agentUpdate(BrokerAgentUpdate[] brokerAgentUpdateArray) {
        this.enqueueCommand(new BrokerAgentUpdateCommand(brokerAgentUpdateArray));
    }

    @Override
    public void connectProxy(Proxy proxy) {
        this.enqueueCommand(new ConnectProxyCommand(proxy));
    }

    @Override
    public void disconnectProxy(Proxy proxy) {
        this.enqueueCommand(new DisconnectProxyCommand(proxy));
    }

    protected void lookupService(ServiceInstanceID serviceInstanceID) {
        this.enqueueCommand(new LookupServiceCommand(serviceInstanceID));
    }

    protected void connectBrokerLink() {
        this.enqueueCommand(new ConnectBrokerLinkCommand());
    }

    public void queryService(ServiceInstanceID serviceInstanceID, IServiceQueryReply iServiceQueryReply) {
        if (serviceInstanceID == null) {
            serviceInstanceID = new ServiceInstanceID();
        }
        this.enqueueCommand(new QueryServiceCommand(serviceInstanceID, iServiceQueryReply));
    }

    public void forceDisconnect(short s) {
        this.enqueueCommand(new ForceDisconnectCommand(s));
    }

    public void pingControl(String string) {
        this.clientPool.pingControl(string);
    }

    public void setTracePeer(short s) {
        this.clientPool.setTracePeer(s);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean doRegisterService(IService iService, IServiceWorker iServiceWorker, boolean bl) {
        Object object;
        ServiceInstanceID serviceInstanceID = iService.getInstanceID();
        DirectoryEntry directoryEntry = new DirectoryEntry(serviceInstanceID, 0);
        if (bl) {
            object = this.serviceRegistry.findService(serviceInstanceID);
            if (object != null) {
                CommAgentTracing.AGENT.log((short)4, "duplicate registration of service instance %1. ignoring! %2?", serviceInstanceID, (Object)iService);
                return true;
            }
            this.serviceRegistry.registerService(iService, iServiceWorker);
            this.serviceDirectory.registerService(directoryEntry);
            CommAgentTracing.COMM.log((short)2, "on='%1' event='interface' interface='%2:%3' info='registered' reason='normal' home='%4'", new Short(this.myAgentID), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()), (Object)new Short(this.myAgentID));
        } else {
            object = this.serviceRegistry.findService(serviceInstanceID);
            if (object == null) {
                CommAgentTracing.AGENT.log((short)4, "unregistration of unknown service instance %1. ignoring! %2?", serviceInstanceID, (Object)iService);
                return true;
            }
            if (object.getService() != iService) {
                CommAgentTracing.AGENT.log((short)4, "unregistration of different service instance %1. ignoring! %2 != %3?", serviceInstanceID, (Object)object.getService(), (Object)iService);
                return true;
            }
            this.serviceRegistry.unregisterService(iService);
            this.serviceDirectory.unregisterService(directoryEntry);
            CommAgentTracing.COMM.log((short)2, "on='%1' event='interface' interface='%2:%3' info='unregistered' reason='normal' home='%4'", new Short(this.myAgentID), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()), (Object)new Short(this.myAgentID));
            this.clientPool.cleanUpGoneLocalService(iService);
        }
        object = this.brokerLock;
        synchronized (object) {
            if (this.withBroker && this.brokerIsAlive) {
                this.brokerManager.registerServiceAtBroker(serviceInstanceID, bl);
            }
        }
        if (bl) {
            object = this.postponedInstanceCommands.retrieveCommands(serviceInstanceID);
            this.handlePostponedCommands((Command[])object, "instance", serviceInstanceID, true, false);
        }
        this.notificationCenter.reportRegisterServiceInstance(this.ikChecker, serviceInstanceID, bl, this.myAgentID);
        return true;
    }

    @Override
    public boolean doRegisterRemoteService(ServiceInstanceID serviceInstanceID, short s, boolean bl) {
        DirectoryEntry directoryEntry = new DirectoryEntry(serviceInstanceID, s);
        if (bl) {
            this.serviceDirectory.registerService(directoryEntry);
            CommAgentTracing.COMM.log((short)2, "on='%1' event='interface' interface='%2:%3' info='registered' reason='normal' home='%4'", new Short(this.myAgentID), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()), (Object)new Short(s));
        } else {
            this.serviceDirectory.unregisterService(directoryEntry);
            CommAgentTracing.COMM.log((short)2, "on='%1' event='interface' interface='%2:%3' info='unregistered' reason='normal' home='%4'", new Short(this.myAgentID), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()), (Object)new Short(s));
            this.clientPool.disconnectProxiesLostOfService(s, serviceInstanceID);
        }
        this.notificationCenter.reportRegisterServiceInstance(this.ikChecker, serviceInstanceID, bl, s);
        return true;
    }

    private short mapLocalAgentID(short s) {
        if (s == 0) {
            return this.myAgentID;
        }
        return s;
    }

    @Override
    public boolean doRegisterServiceInstanceListener(ServiceInstanceID serviceInstanceID, IServiceInstanceListener iServiceInstanceListener, boolean bl) {
        if (bl) {
            this.notificationCenter.registerServiceInstanceListener(serviceInstanceID, iServiceInstanceListener);
            DirectoryEntry[] directoryEntryArray = this.serviceDirectory.locateService(serviceInstanceID);
            if (directoryEntryArray != null) {
                for (int i2 = 0; i2 < directoryEntryArray.length; ++i2) {
                    DirectoryEntry directoryEntry = directoryEntryArray[i2];
                    if (!this.ikChecker.isCompatible("Register", directoryEntry.getServiceInstanceID(), serviceInstanceID, null)) continue;
                    CommAgentTracing.AGENT.log((short)1, "tell service instance listener initially about %1", directoryEntry);
                    this.notificationCenter.reportRegisterServiceInstance(iServiceInstanceListener, serviceInstanceID, this.mapLocalAgentID(directoryEntry.getAgentID()));
                }
            }
            if (this.withBroker) {
                this.lookupService(serviceInstanceID);
            }
        } else {
            this.notificationCenter.unregisterServiceInstanceListener(serviceInstanceID, iServiceInstanceListener);
        }
        return true;
    }

    @Override
    public boolean doRegisterServiceListener(IService iService, IServiceListener iServiceListener, boolean bl) {
        if (bl) {
            int n;
            this.notificationCenter.registerServiceListener(iService, iServiceListener);
            ServiceHandler serviceHandler = this.serviceRegistry.findService(iService.getInstanceID());
            if (serviceHandler != null && (n = serviceHandler.getStubCount()) > 0) {
                CommAgentTracing.AGENT.log((short)1, "tell service listener initially about stub count %1", new Integer(n));
                this.notificationCenter.reportServiceStubCountChanged(iServiceListener, iService, n);
            }
        } else {
            this.notificationCenter.unregisterServiceListener(iService, iServiceListener);
        }
        return true;
    }

    @Override
    public boolean doRegisterProxyListener(Proxy proxy, IProxyListener iProxyListener, boolean bl) {
        if (bl) {
            this.notificationCenter.registerProxyListener(proxy, iProxyListener);
            int n = proxy.getState();
            this.notificationCenter.reportProxyStateChanged(proxy, n, null, iProxyListener);
        } else {
            this.notificationCenter.unregisterProxyListener(proxy, iProxyListener);
        }
        return true;
    }

    @Override
    public boolean doBrokerAgentUpdate(BrokerAgentUpdate[] brokerAgentUpdateArray) {
        int n = 0;
        if (brokerAgentUpdateArray != null) {
            n = brokerAgentUpdateArray.length;
        }
        CommAgentTracing.AGENT.log((short)1, "broker: agent update #events=%1", new Integer(n));
        for (int i2 = 0; i2 < n; ++i2) {
            BrokerAgentUpdate brokerAgentUpdate = brokerAgentUpdateArray[i2];
            short s = brokerAgentUpdate.getAgentID();
            short s2 = brokerAgentUpdate.getAgentEpoch();
            boolean bl = this.agentDirectory.updateAgent(s, s2);
            CommAgentTracing.AGENT.log((short)1, " Event: agentID=%1 agentEpoch=%2 [is newer=%3]", new Short(s), (Object)new Short(s2), (Object)new Boolean(bl));
            if (s == this.myAgentID) continue;
            this.clientPool.cleanUpOldConnection(s, s2);
        }
        return true;
    }

    @Override
    public boolean doBrokerServiceUpdate(BrokerServiceUpdate[] brokerServiceUpdateArray) {
        int n = 0;
        if (brokerServiceUpdateArray != null) {
            n = brokerServiceUpdateArray.length;
        }
        CommAgentTracing.AGENT.log((short)1, "broker: service update #events=%1", new Integer(n));
        for (int i2 = 0; i2 < n; ++i2) {
            Command[] commandArray;
            BrokerServiceUpdate brokerServiceUpdate = brokerServiceUpdateArray[i2];
            ServiceInstanceID serviceInstanceID = brokerServiceUpdate.getInstanceID();
            short s = brokerServiceUpdate.getAgent();
            int n2 = brokerServiceUpdate.getAction();
            int n3 = brokerServiceUpdate.getReason();
            CommAgentTracing.AGENT.log((short)1, "  Event: action=%1 reason=%2 srv_id=%3 agent=#%4", (Object)BrokerServiceUpdate.actionNames[n2], (Object)BrokerServiceUpdate.reasonNames[n3], (Object)serviceInstanceID, (Object)new Integer(s));
            boolean bl = false;
            boolean bl2 = false;
            if (n2 == 0) {
                commandArray = new DirectoryEntry(serviceInstanceID, s);
                this.serviceDirectory.registerService((DirectoryEntry)commandArray);
                if (s != this.myAgentID) {
                    this.notificationCenter.reportRegisterServiceInstance(this.ikChecker, serviceInstanceID, true, s);
                }
                bl = true;
                CommAgentTracing.COMM.log((short)2, "on='%1' event='interface' interface='%2:%3' info='registered' reason='%4' home='%5'", new Short(this.myAgentID), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()), (Object)BrokerServiceUpdate.reasonNames[n3], (Object)new Short(s));
            } else if (n2 == 1) {
                commandArray = new DirectoryEntry(serviceInstanceID, s);
                this.serviceDirectory.unregisterService((DirectoryEntry)commandArray);
                if (s != this.myAgentID) {
                    this.notificationCenter.reportRegisterServiceInstance(this.ikChecker, serviceInstanceID, false, s);
                }
                CommAgentTracing.COMM.log((short)2, "on='%1' event='interface' interface='%2:%3' info='unregistered' reason='%4' home='%5'", new Short(this.myAgentID), (Object)serviceInstanceID.getServiceUUID(), (Object)new Integer(serviceInstanceID.getHandle()), (Object)BrokerServiceUpdate.reasonNames[n3], (Object)new Short(s));
                this.clientPool.disconnectProxiesLostOfService(s, serviceInstanceID);
            } else if (n2 == 2) {
                bl2 = true;
            } else {
                CommAgentTracing.AGENT.log((short)4, "unknown Action %1 !", new Integer(n2));
            }
            if (!bl && !bl2) continue;
            commandArray = this.postponedInstanceCommands.retrieveCommands(serviceInstanceID);
            this.handlePostponedCommands(commandArray, "instance", serviceInstanceID, bl, false);
        }
        return true;
    }

    private void handlePostponedCommands(Command[] commandArray, String string, Object object, boolean bl, boolean bl2) {
        if (commandArray != null && commandArray.length > 0) {
            CommAgentTracing.AGENT.log((short)1, "found %1 postponed %2 commands for %3", new Integer(commandArray.length), (Object)string, object);
            for (int i2 = 0; i2 < commandArray.length; ++i2) {
                Command command = commandArray[i2];
                if (bl) {
                    CommAgentTracing.AGENT.log((short)1, "re-add postponed %1 command: %2", (Object)string, (Object)command);
                    this.enqueueCommand(command);
                    continue;
                }
                short s = command.getRetryCount();
                if (s == this.config.getCommandRetryCount() || bl2 || command.getDropNow()) {
                    CommAgentTracing.AGENT.log((short)1, "drop postponed %1 command: %2 timeout=false", (Object)string, (Object)command);
                    command.drop(this, false);
                    continue;
                }
                command.incRetryCount();
                CommAgentTracing.AGENT.log((short)1, "delay drop and requeue postponed %1 command: %2 retries=%3", (Object)string, (Object)command, (Object)new Integer(command.getRetryCount()));
                this.enqueueCommand(command);
            }
        } else {
            CommAgentTracing.AGENT.log((short)1, "no postponed %1 commands for %2", (Object)string, object);
        }
    }

    @Override
    public void clientHandlerStateUpdate(IClientHandler iClientHandler, boolean bl) {
        this.enqueueCommand(new ClientHandlerUpdateCommand(iClientHandler, bl));
    }

    public IService findService(ServiceInstanceID serviceInstanceID) {
        IService iService = null;
        ServiceHandler serviceHandler = this.serviceRegistry.findService(serviceInstanceID);
        if (serviceHandler != null) {
            iService = serviceHandler.getService();
        }
        return iService;
    }

    @Override
    public boolean doClientHandlerUpdate(IClientHandler iClientHandler, boolean bl) {
        CommAgentTracing.AGENT.log((short)1, "client handler update (my agent id=%1, epoch=%2) (peer agent id=%3, epoch=%4) connected=%5", new Short(iClientHandler.getMyAssignedAgentID()), (Object)new Short(iClientHandler.getMyAssignedAgentEpoch()), (Object)new Short(iClientHandler.getPeerAgentID()), (Object)new Short(iClientHandler.getPeerAgentEpoch()), (Object)new Boolean(bl));
        Command[] commandArray = this.postponedClientCommands.retrieveCommands(iClientHandler);
        this.handlePostponedCommands(commandArray, "handler", iClientHandler, bl, true);
        if (bl) {
            this.agentDirectory.updateAgent(iClientHandler.getPeerAgentID(), iClientHandler.getPeerAgentEpoch());
        } else if (this.withBroker) {
            short s = iClientHandler.getPeerAgentID();
            DirectoryEntry[] directoryEntryArray = this.serviceDirectory.removeAllEntriesOfPeer(s);
            CommAgentTracing.AGENT.log((short)1, "removed entries from service directory (located on lost peer id=%1): #%2 services", new Short(s), (Object)new Integer(directoryEntryArray == null ? 0 : directoryEntryArray.length));
            if (directoryEntryArray != null && directoryEntryArray.length > 0) {
                for (int i2 = 0; i2 < directoryEntryArray.length; ++i2) {
                    DirectoryEntry directoryEntry = directoryEntryArray[i2];
                    ServiceInstanceID serviceInstanceID = directoryEntry.getServiceInstanceID();
                    CommAgentTracing.AGENT.log((short)1, "re-lookup vanished service: #%1", serviceInstanceID);
                    this.doLookupService(serviceInstanceID);
                }
            }
        }
        return true;
    }

    @Override
    public boolean doQueryService(ServiceInstanceID serviceInstanceID, IServiceQueryReply iServiceQueryReply) {
        DirectoryEntry[] directoryEntryArray = this.serviceDirectory.locateService(serviceInstanceID);
        if (directoryEntryArray == null || directoryEntryArray.length == 0) {
            CommAgentTracing.AGENT.log((short)2, "query: %1 -> service not found!", serviceInstanceID);
            iServiceQueryReply.serviceQueryFailed(serviceInstanceID, 1);
        } else {
            CommAgentTracing.AGENT.log((short)2, "query: %1 -> service found: %d entries", serviceInstanceID, (Object)new Integer(directoryEntryArray.length));
            iServiceQueryReply.serviceQueryResult(serviceInstanceID, directoryEntryArray);
        }
        return true;
    }

    @Override
    public void dropQueryService(ServiceInstanceID serviceInstanceID, IServiceQueryReply iServiceQueryReply, boolean bl) {
        if (!bl && serviceInstanceID.getServiceUUID().isZero()) {
            DirectoryEntry[] directoryEntryArray = this.serviceDirectory.getAllEntries();
            if (directoryEntryArray != null && directoryEntryArray.length > 0) {
                CommAgentTracing.AGENT.log((short)2, "query: %1 -> query all -> %2 entries", serviceInstanceID, (Object)new Integer(directoryEntryArray.length));
                iServiceQueryReply.serviceQueryResult(null, directoryEntryArray);
            } else {
                CommAgentTracing.AGENT.log((short)2, "query: %1 -> query all -> no entry found", serviceInstanceID);
                iServiceQueryReply.serviceQueryFailed(null, 1);
            }
        } else {
            CommAgentTracing.AGENT.log((short)2, "query: %1 -> %2", serviceInstanceID, (Object)(bl ? "timeout" : "not found"));
            iServiceQueryReply.serviceQueryFailed(serviceInstanceID, bl ? 2 : 1);
        }
    }

    @Override
    public boolean doConnectProxy(Proxy proxy) {
        Object object;
        short s;
        CommAgentTracing.AGENT.log((short)2, "do: connecting proxy %1", proxy.getInstanceID());
        if (proxy.isDisconnectPending()) {
            CommAgentTracing.AGENT.log((short)2, "early abort proxy %1 connect -> pending disconnect!", proxy.getInstanceID());
            proxy.getLifecycle().setDead();
            return true;
        }
        ServiceInstanceID serviceInstanceID = proxy.getInstanceID();
        DirectoryEntry[] directoryEntryArray = this.serviceDirectory.locateService(serviceInstanceID);
        if (directoryEntryArray == null || directoryEntryArray.length == 0) {
            CommAgentTracing.AGENT.log((short)4, "-> service not available!");
            proxy.getLifecycle().setError(6);
            return true;
        }
        DirectoryEntry directoryEntry = null;
        for (s = 0; s < directoryEntryArray.length; ++s) {
            boolean bl;
            object = directoryEntryArray[s];
            CommAgentTracing.AGENT.log((short)1, "suitable service is %1", object);
            boolean bl2 = this.ikChecker.isCompatible("Proxy", ((DirectoryEntry)object).getServiceInstanceID(), serviceInstanceID, proxy.getCheckIK());
            if (bl2) {
                directoryEntry = directoryEntryArray[s];
            }
            if (!proxy.detectInterfaceKeyMismatch()) continue;
            boolean bl3 = bl = !this.ikChecker.isEquals(((DirectoryEntry)object).getServiceInstanceID(), serviceInstanceID);
            if (!bl) continue;
            CommAgentTracing.AGENT.log((short)4, "InterfaceKeyMismatch detected %1 != %2 ", ((DirectoryEntry)object).getServiceInstanceID(), (Object)serviceInstanceID);
            proxy.setInterfaceKeyMismatch(true);
        }
        if (directoryEntry == null) {
            CommAgentTracing.AGENT.log((short)4, "Error setting up proxy=%1: Interface Key mismatch", proxy.getInstanceID());
            proxy.getLifecycle().setError(4);
            return true;
        }
        s = this.mapLocalAgentID(directoryEntry.getAgentID());
        CommAgentTracing.AGENT.log((short)1, "done setting up proxy=%1: using agent=#%2 service=%3", proxy.getInstanceID(), (Object)new Short(s), (Object)directoryEntry.getServiceInstanceID());
        if (proxy.isDisconnectPending()) {
            CommAgentTracing.AGENT.log((short)2, "late abort proxy connect %1 -> pending disconnect!", proxy.getInstanceID());
            proxy.getLifecycle().setDead();
            return true;
        }
        try {
            object = this.clientPool.requestConnection(s, false);
            this.enqueueCommand(new SetupProxyCommand(proxy, (IClientHandler)object));
        }
        catch (ClientException clientException) {
            CommAgentTracing.AGENT.log((short)4, "Error setting up proxy=%1 using agent=#%2: %3", proxy.getInstanceID(), (Object)new Short(s), (Object)clientException);
            proxy.getLifecycle().setError(3);
        }
        catch (ConnectionFactoryException connectionFactoryException) {
            CommAgentTracing.AGENT.log((short)4, "Error setting up proxy=%1 using agent=#%2: %3", proxy.getInstanceID(), (Object)new Short(s), (Object)connectionFactoryException);
            proxy.getLifecycle().setError(3);
        }
        return true;
    }

    @Override
    public void dropConnectProxy(Proxy proxy, boolean bl) {
        CommAgentTracing.AGENT.log((short)3, "service N/A: dropped proxy=%1", proxy.getInstanceID());
        proxy.getLifecycle().setError(3);
    }

    @Override
    public boolean doSetupProxy(Proxy proxy, IClientHandler iClientHandler) {
        if (iClientHandler.isConnected()) {
            CommAgentTracing.AGENT.log((short)1, "setting up proxy %1 via agent %2", proxy.getInstanceID(), (Object)new Short(iClientHandler.getPeerAgentID()));
            if (proxy.isDisconnectPending()) {
                CommAgentTracing.AGENT.log((short)2, "abort proxy setup %1 -> pending disconnect!", proxy.getInstanceID());
                proxy.getLifecycle().setDead();
                return true;
            }
            IReplyService iReplyService = proxy.getReplyService();
            IServiceWorker iServiceWorker = null;
            if (iReplyService != null) {
                this.setReplyServiceHandle(iReplyService);
                CommAgentTracing.AGENT.log((short)1, "registering reply service %1", iReplyService.getInstanceID());
                iServiceWorker = proxy.getReplyServiceWorker();
                boolean bl = this.doRegisterService(iReplyService, iServiceWorker, true);
                if (!bl) {
                    CommAgentTracing.AGENT.log((short)4, "error registering reply service %1", iReplyService.getInstanceID());
                    proxy.getLifecycle().setError(6);
                    return true;
                }
                proxy.setReplyServiceRegistered(true);
            }
            if (iClientHandler.connectProxy(proxy)) {
                CommAgentTracing.AGENT.log((short)2, "ok: proxy connected to #%2: %1", proxy.getInstanceID(), (Object)new Short(iClientHandler.getPeerAgentID()));
                CommAgentTracing.COMM.log((short)2, "on='%1' event='proxy' interface='%2:%3' info='connect' ", new Integer(this.myAgentID), (Object)proxy.getInstanceID().getServiceUUID(), (Object)new Integer(proxy.getInstanceID().getHandle()));
            } else {
                CommAgentTracing.AGENT.log((short)4, "setting up proxy %1 via agent %2 FAILED", proxy.getInstanceID(), (Object)new Short(iClientHandler.getPeerAgentID()));
                proxy.getLifecycle().setError(3);
            }
        } else {
            CommAgentTracing.AGENT.log((short)4, "missing connection -> FAILED setting up proxy at #%2 %1", proxy.getInstanceID(), (Object)new Short(iClientHandler.getPeerAgentID()));
            proxy.getLifecycle().setError(3);
        }
        return true;
    }

    @Override
    public void dropSetupProxy(Proxy proxy, boolean bl) {
        CommAgentTracing.AGENT.log((short)4, "connection not available -> dropped proxy=%1", proxy.getInstanceID());
        proxy.getLifecycle().setError(6);
    }

    @Override
    public boolean doDisconnectProxy(Proxy proxy) {
        IClientHandler iClientHandler = (IClientHandler)proxy.getBackend();
        if (iClientHandler != null) {
            iClientHandler.disconnectProxy(proxy);
            CommAgentTracing.COMM.log((short)2, "on='%1' event='proxy' interface='%2:%3' info='disconnect' ", new Integer(this.myAgentID), (Object)proxy.getInstanceID().getServiceUUID(), (Object)new Integer(proxy.getInstanceID().getHandle()));
        } else {
            CommAgentTracing.AGENT.log((short)2, "too early disconnect for proxy %1 -> ignored", proxy.getInstanceID());
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean doLookupService(ServiceInstanceID serviceInstanceID) {
        if (!serviceInstanceID.getServiceUUID().isZero()) {
            this.serviceDirectory.addEmptyService(serviceInstanceID);
        }
        if (this.brokerManager != null) {
            Object object = this.brokerLock;
            synchronized (object) {
                if (this.brokerIsAlive) {
                    this.brokerManager.lookupService(serviceInstanceID);
                }
            }
        }
        return true;
    }

    @Override
    public void proxyStateChanged(Proxy proxy, int n) {
        boolean bl;
        IReplyService iReplyService = proxy.getReplyService();
        if (iReplyService != null && (n == 2 || n == 3)) {
            if (proxy.getReplyServiceRegistered()) {
                CommAgentTracing.AGENT.log((short)1, "proxy dead/error -> unregister reply service %1", iReplyService.getInstanceID());
                this.registerService(iReplyService, null, false);
                proxy.setReplyServiceRegistered(false);
            } else {
                CommAgentTracing.AGENT.log((short)1, "proxy dead/error -> reply service was not registered %1", iReplyService.getInstanceID());
            }
        }
        AgentWorker$1 agentWorker$1 = null;
        if (n == 1) {
            agentWorker$1 = new AgentWorker$1(this, proxy);
        }
        if (!(bl = this.notificationCenter.reportProxyStateChanged(proxy, n, agentWorker$1)) && agentWorker$1 != null) {
            proxy.getBackend().proxyAliveDone(proxy);
        }
        if (n == 2 || n == 3) {
            this.notificationCenter.unregisterAllProxyListeners(proxy);
        }
        String string = null;
        if (n == 1) {
            string = "alive";
        }
        if (n == 2 || n == 3) {
            string = "dead";
        }
        if (string != null) {
            CommAgentTracing.COMM.log((short)2, "on='%1' event='proxy' interface='%2:%3' info='%4' ", new Integer(this.myAgentID), (Object)proxy.getInstanceID().getServiceUUID(), (Object)new Integer(proxy.getInstanceID().getHandle()), (Object)string);
        }
    }

    @Override
    public void serviceStubAttached(IService iService, int n, IStub iStub, IServiceHandlerCallback iServiceHandlerCallback) {
        AgentWorker$2 agentWorker$2 = new AgentWorker$2(this, iServiceHandlerCallback);
        this.notificationCenter.reportServiceStubCountChanged(iService, n);
        if (!this.notificationCenter.reportServiceStubAttached(iStub, agentWorker$2)) {
            iServiceHandlerCallback.completedCall();
        }
    }

    @Override
    public void serviceStubDetached(IService iService, int n, IStub iStub, IServiceHandlerCallback iServiceHandlerCallback) {
        AgentWorker$3 agentWorker$3 = new AgentWorker$3(this, iServiceHandlerCallback);
        this.notificationCenter.reportServiceStubCountChanged(iService, n);
        if (!this.notificationCenter.reportServiceStubDetached(iStub, agentWorker$3)) {
            iServiceHandlerCallback.completedCall();
        }
    }

    private void dropTimedOutCommands(Command[] commandArray, String string, int n) {
        int n2;
        if (commandArray != null && (n2 = commandArray.length) > 0) {
            CommAgentTracing.AGENT.log((short)2, "drop: %1 old %2 commands (timout %3 ms)", new Integer(n2), (Object)string, (Object)new Integer(n));
            for (int i2 = 0; i2 < n2; ++i2) {
                Command command = commandArray[i2];
                CommAgentTracing.AGENT.log((short)1, "dropping %1", command);
                command.drop(this, true);
            }
        }
    }

    private void retryBrokerConnect() {
        if (this.agentReconnect) {
            if (this.curBrokerConnectRetries < this.maxBrokerConnectRetries || this.maxBrokerConnectRetries == 0) {
                CommAgentTracing.AGENT.log((short)2, "re-connect: retrying to connect broker %1/%2", new Integer(this.curBrokerConnectRetries), (Object)new Integer(this.maxBrokerConnectRetries));
                this.connectBrokerLink();
                ++this.curBrokerConnectRetries;
                this.lifecycleDispatcher.brokerConnectRetry(false);
            } else if (this.curBrokerConnectRetries == this.maxBrokerConnectRetries) {
                CommAgentTracing.AGENT.log((short)4, "re-connect: failed to reach broker after %1 retries", new Integer(this.maxBrokerConnectRetries));
                ++this.curBrokerConnectRetries;
                this.lifecycleDispatcher.brokerConnectRetry(true);
            }
        }
    }

    @Override
    public boolean doTimer() {
        int n = this.config.getCommandDropTimeout();
        long l = this.monoTime.getCurrentTime();
        Command[] commandArray = this.postponedInstanceCommands.retrieveOldCommands(n, l);
        this.dropTimedOutCommands(commandArray, "instance", n);
        commandArray = this.postponedClientCommands.retrieveOldCommands(n, l);
        this.dropTimedOutCommands(commandArray, "client", n);
        if (this.withBroker) {
            if (this.brokerManager.hasPermanentError()) {
                this.stop(2, this.brokerManager.getErrorString());
            } else if (this.brokerManager.needNewConnect()) {
                this.retryBrokerConnect();
            }
        }
        this.clientPool.doTimer();
        ++this.aliveCounter;
        if (this.aliveCounter >= this.aliveRate) {
            this.aliveCounter = 0;
            CommAgentTracing.AGENT.log((short)1, "--- ALIVE ---");
        }
        return true;
    }

    @Override
    public boolean doConnectBrokerLink() {
        CommAgentTracing.AGENT.log((short)2, "do: trying to connect broker");
        IClientHandler iClientHandler = this.brokerManager.connect(this.nameService, this.clientPool);
        if (iClientHandler == null && this.brokerManager.hasPermanentError()) {
            this.stop(2, this.brokerManager.getErrorString());
        }
        return true;
    }

    public void enqueueSetupBrokerLinkCommand(IClientHandler iClientHandler) {
        this.enqueueCommand(new SetupBrokerLinkCommand(iClientHandler));
    }

    @Override
    public boolean doSetupBrokerLink(IClientHandler iClientHandler) {
        CommAgentTracing.AGENT.log((short)2, "do: trying to setup broker");
        if (this.brokerManager.setup(iClientHandler)) {
            short s = this.brokerManager.getMyAssignedAgentID();
            short s2 = this.brokerManager.getMyAssignedAgentEpoch();
            this.agentDirectory.updateAgent(s, s2);
            if (s != this.myAgentID) {
                CommAgentTracing.AGENT.log((short)1, "broker assigned me a new agent id: %1, (old agent id: %2)", new Short(s), (Object)new Short(this.myAgentID));
                this.myAgentID = s;
                this.clientPool.assignMyAgentID(s);
                this.lifecycleDispatcher.agentIdUpdate(this.myAgentID);
                if (this.dynamicAgentId) {
                    CommAgentTracing.AGENT.log((short)2, "broker assigned a new id, drop all connections");
                    this.clientPool.forceDisconnectAllWithoutBroker();
                }
                if (s2 == 0) {
                    CommAgentTracing.AGENT.log((short)1, "detected epoch overflow at broker! dropping all connections...");
                    this.clientPool.forceDisconnectAll();
                }
            }
            if (this.spawnList != null) {
                this.spawnList.enableSpawning();
                CommAgentTracing.AGENT.log((short)2, "ok: broker link is up -> started spawning connection factory");
            } else {
                CommAgentTracing.AGENT.log((short)2, "ok: broker link is up");
            }
        } else if (this.brokerManager.hasPermanentError()) {
            this.stop(2, this.brokerManager.getErrorString());
        }
        return true;
    }

    @Override
    public void dropSetupBrokerLink(IClientHandler iClientHandler) {
        this.brokerManager.brokerLinkDropped();
    }

    @Override
    public boolean doForceDisconnect(short s) {
        if (this.brokerManager != null && s == this.brokerManager.getBrokerAgentID()) {
            short s2 = this.brokerManager.getBrokerAgentID();
            this.clientPool.forceDisconnect(s2);
            short s3 = this.agentDirectory.getAgentEpoch(this.myAgentID);
            CommAgentTracing.AGENT.log((short)1, "resetting my epoch after forced broker disconnect (was %1)", new Short(s3));
            this.agentDirectory.resetAgent(this.myAgentID);
        } else {
            this.clientPool.forceDisconnect(s);
        }
        return true;
    }

    @Override
    public void run() {
        CommAgentTracing.AGENT.log((short)2, "start: commAgent for agent=#%1 withBroker=%2", new Short(this.myAgentID), (Object)new Boolean(this.withBroker));
        if (!this.setupSpawnFactories()) {
            this.lifecycle.setError(1);
            this.errorString = "no spawn factory was set up!";
            this.returnCode = 1;
            this.shutdown();
            CommAgentTracing.AGENT.log((short)2, "life: agent is dead");
            return;
        }
        if (this.withBroker) {
            this.connectBrokerLink();
        }
        this.lifecycle.setAlive();
        CommAgentTracing.COMM.log((short)2, "on='%1' event='agent' name='%2'", new Short(this.nameService.getMyID()), (Object)this.nameService.getMyProcName());
        CommAgentTracing.AGENT.log((short)2, "life: agent is alive");
        boolean bl = true;
        int n = 0;
        long l = 0L;
        int n2 = 0;
        while (bl) {
            try {
                Object object = this.commandQueue.get();
                if (object instanceof Command) {
                    Command command = (Command)object;
                    bl = this.processCommand(command);
                    n2 = 0;
                } else {
                    n = 10;
                    ++n2;
                }
                if (n > 0) {
                    CommAgentTracing.AGENT.log((short)4, "agent cmd queue: #%1 class=%2 size=%3", new Long(l), object, (Object)new Integer(this.commandQueue.size()));
                    --n;
                }
                if (n2 >= 10) {
                    CommAgentTracing.AGENT.log((short)5, "agent cmd queue: aborting... too many failures in a row");
                    break;
                }
                ++l;
            }
            catch (InterruptedException interruptedException) {
                CommAgentTracing.AGENT.log((short)4, "Error getting command: %1", interruptedException);
                break;
            }
            catch (QueueShutdownException queueShutdownException) {
                CommAgentTracing.AGENT.log((short)4, "Error getting command: %1", queueShutdownException);
                break;
            }
            catch (Throwable throwable) {
                CommAgentTracing.AGENT.log((short)5, "Agent crashed: %1", throwable);
                break;
            }
        }
        this.shutdown();
        CommAgentTracing.AGENT.log((short)2, "life: agent is dead: returnCode=%1 errorString=%2", new Integer(this.returnCode), (Object)this.errorString);
        if (this.returnCode == 0) {
            this.lifecycle.setDead();
        } else {
            this.lifecycle.setError(this.returnCode);
        }
    }

    private boolean processCommand(Command command) {
        DirectoryEntry[] directoryEntryArray;
        boolean bl = true;
        ServiceInstanceID serviceInstanceID = command.getDependentInstanceID();
        boolean bl2 = true;
        boolean bl3 = false;
        boolean bl4 = false;
        if (serviceInstanceID != null) {
            if (serviceInstanceID.getServiceUUID().isZero()) {
                if (this.withBroker) {
                    CommAgentTracing.AGENT.log((short)1, "cmd depends on svc id with zero UUID -> always push a broker lookup", serviceInstanceID);
                    this.lookupService(serviceInstanceID);
                    bl2 = false;
                }
            } else {
                directoryEntryArray = this.serviceDirectory.locateService(serviceInstanceID);
                if (directoryEntryArray == null) {
                    if (this.withBroker) {
                        CommAgentTracing.AGENT.log((short)1, "cmd depends on svc id: service not in directory. pushed a broker lookup for instanceID %1", serviceInstanceID);
                        this.lookupService(serviceInstanceID);
                        bl2 = false;
                    } else {
                        CommAgentTracing.AGENT.log((short)3, "cmd depends on svc id: no broker and requested service not registered statically %1", serviceInstanceID);
                        bl3 = true;
                    }
                } else if (directoryEntryArray.length == 0) {
                    CommAgentTracing.AGENT.log((short)1, "cmd depends on svc id: already waiting for lookup of %1", serviceInstanceID);
                    bl2 = false;
                } else {
                    CommAgentTracing.AGENT.log((short)1, "cmd depends on svc id: instance id available at %1", serviceInstanceID);
                }
            }
        }
        if ((directoryEntryArray = command.getDependentClientHandler()) != null) {
            if (directoryEntryArray.isDeadOrError()) {
                CommAgentTracing.AGENT.log((short)1, "drop command because required handler is dead or error: %1", (Object)directoryEntryArray);
                bl3 = true;
            } else if (!directoryEntryArray.isConnected()) {
                CommAgentTracing.AGENT.log((short)1, "required client handler not connected yet: %1", (Object)directoryEntryArray);
                bl2 = false;
                bl4 = true;
            }
        }
        if (bl3) {
            CommAgentTracing.AGENT.log((short)2, "drop: >> command %1", command);
            command.drop(this, false);
        } else if (bl2) {
            if (!(command instanceof TimerCommand)) {
                CommAgentTracing.AGENT.log((short)0, "[ command %1", command);
            }
            long l = this.monoTime.getCurrentTime();
            bl = command.handle(this);
            long l2 = this.monoTime.getCurrentTime();
            if (!(command instanceof TimerCommand)) {
                CommAgentTracing.AGENT.log((short)0, "] command %1: duration %2 ms", command, (Object)new Long(l2 - l));
            }
        } else if (bl4) {
            CommAgentTracing.AGENT.log((short)1, "@ postpone client command %1 for agent #%2", command, (Object)command.getDependentClientHandler());
            this.postponedClientCommands.addCommand(command.getDependentClientHandler(), command);
        } else {
            CommAgentTracing.AGENT.log((short)1, "@ postpone instance command %1 for %2", command, (Object)command.getDependentInstanceID());
            this.postponedInstanceCommands.addCommand(command.getDependentInstanceID(), command);
        }
        return bl;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void brokerProxyIsDead() {
        Object object = this.brokerLock;
        synchronized (object) {
            this.brokerIsAlive = false;
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void brokerProxyIsAlive() {
        Object object = this.brokerLock;
        synchronized (object) {
            this.brokerIsAlive = true;
        }
        this.enqueueCommand(new BrokerProxyAliveCommand());
    }

    public void brokerFinishedShutdown(boolean bl) {
        if (bl) {
            CommAgentTracing.AGENT.log((short)1, "broker was operational -> retry connect immediately.");
            this.curBrokerConnectRetries = 0;
            this.retryBrokerConnect();
        } else {
            CommAgentTracing.AGENT.log((short)1, "broker was not operational -> retry connect later.");
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public boolean doBrokerProxyAlive() {
        Object object = this.brokerLock;
        synchronized (object) {
            if (!this.brokerIsAlive) {
                CommAgentTracing.AGENT.log((short)1, "broker alive already lost broker proxy. ignoring...");
            } else {
                ServiceInstanceID[] serviceInstanceIDArray;
                boolean bl = true;
                IService[] iServiceArray = this.serviceRegistry.getAllServices();
                for (int i2 = 0; i2 < iServiceArray.length; ++i2) {
                    ServiceInstanceID serviceInstanceID = iServiceArray[i2].getInstanceID();
                    CommAgentTracing.AGENT.log((short)1, "re-registering service at broker %1", serviceInstanceID);
                    bl = this.brokerManager.registerServiceAtBroker(serviceInstanceID, true);
                    if (!bl) break;
                }
                if (bl && (serviceInstanceIDArray = this.serviceDirectory.getAllEmptyEntries()) != null) {
                    for (int i3 = 0; i3 < serviceInstanceIDArray.length; ++i3) {
                        ServiceInstanceID serviceInstanceID = serviceInstanceIDArray[i3];
                        CommAgentTracing.AGENT.log((short)1, "re-lookup service at broker %1", serviceInstanceID);
                        bl = this.brokerManager.lookupService(serviceInstanceID);
                        if (!bl) break;
                    }
                }
                CommAgentTracing.AGENT.log((short)1, "broker alive done. ok=%1", new Boolean(bl));
            }
        }
        return true;
    }

    @Override
    public boolean doQuit() {
        CommAgentTracing.AGENT.log((short)0, "+ quit");
        this.unregisterLocalServices();
        this.enqueueCommand(new TerminateCommand());
        CommAgentTracing.AGENT.log((short)0, "- quit");
        return true;
    }

    protected void unregisterLocalServices() {
        CommAgentTracing.AGENT.log((short)0, "+ unregister local services");
        IService[] iServiceArray = this.serviceRegistry.getAllServices();
        if (iServiceArray != null) {
            for (IService iService : iServiceArray) {
                CommAgentTracing.AGENT.log((short)1, "unregister local service %1", iService.getInstanceID());
                this.registerService(iService, null, false);
            }
        }
        CommAgentTracing.AGENT.log((short)0, "- unregister local services");
    }

    protected void shutdown() {
        CommAgentTracing.AGENT.log((short)0, "+ shutdown agent");
        if (this.brokerManager != null) {
            this.brokerManager.shutdown();
        }
        if (this.spawnList != null) {
            CommAgentTracing.AGENT.log((short)1, "shutdown connection factory");
            this.spawnList.disableSpawning();
        }
        this.clientPool.shutdown();
        this.serviceRegistry.shutdown();
        this.notificationCenter.shutdown();
        this.timer.stop();
        if (this.dumpModelCB != -1) {
            TraceClient.unregisterTraceCallback(this.dumpModelCB);
        }
        CommAgentTracing.AGENT.log((short)0, "- shutdown agent");
    }

    protected boolean setupSpawnFactories() {
        this.spawnList = new SpawnList(this.nameService, this.connectionFactoryProvider, this.clientPool);
        if (!this.withBroker) {
            this.spawnList.enableSpawning();
            CommAgentTracing.AGENT.log((short)1, "started spawning connection factory");
        }
        return true;
    }

    @Override
    public Short getAgentIdProposal() {
        return this.lifecycleDispatcher.getAgentIdProposal();
    }

    public ClientPool getClientPool() {
        return this.clientPool;
    }

    public int getCommandQueueSize() {
        return this.commandQueue.size();
    }

    public int getTotalCommandCount() {
        return this.totalCommandCount;
    }

    @Override
    public void executeTraceCallback(int n, byte[] byArray) {
        if (n == this.dumpModelCB) {
            this.clientPool.dumpProxiesAndConnections();
            this.serviceDirectory.dumpDirectory(this.myAgentID);
        }
    }

    static /* synthetic */ IRunnableWrapper access$000(AgentWorker agentWorker) {
        return agentWorker.runnableWrapper;
    }

    static /* synthetic */ MemWatch access$100(AgentWorker agentWorker) {
        return agentWorker.memWatch;
    }
}

