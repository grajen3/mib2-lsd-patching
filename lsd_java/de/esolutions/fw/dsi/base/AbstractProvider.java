/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.base;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.IProxyListener;
import de.esolutions.fw.comm.core.IServiceWorker;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.dsi.admin.IProviderService;
import de.esolutions.fw.dsi.base.AbstractProvider$SlowReconnect;
import de.esolutions.fw.dsi.base.AbstractProviderBase;
import de.esolutions.fw.dsi.base.IDispatcher;
import de.esolutions.fw.dsi.base.IProvider;
import de.esolutions.fw.dsi.base.IProviderStateListener;
import de.esolutions.fw.dsi.base.ProviderState;
import de.esolutions.fw.dsi.comm.IDSIServiceWorker;
import de.esolutions.fw.dsi.config.AdapterConfig;
import de.esolutions.fw.dsi.diag.IAdapterErrorLog;
import de.esolutions.fw.dsi.diag.ProviderInfo;
import de.esolutions.fw.dsi.tracing.Channels;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public abstract class AbstractProvider
extends AbstractProviderBase
implements IProvider,
IProxyListener,
IProviderStateListener {
    private BundleContext bundleContext;
    private Agent agent;
    private List stateListeners;
    private int proxyState;
    private int proxyReconnectionCounter;
    private static final Timer reconnectTimer = new Timer();
    private ProviderState providerState = new ProviderState();
    private int slowReconnectTimeout;
    private AbstractProvider$SlowReconnect reconnectTask;
    private boolean registered;
    protected int maxFastsReconnects = 10;
    protected int slowReconnectTimeoutStartVal = 1000;
    protected int slowReconnectTimeoutEndVal = 10000;
    private ServiceRegistration providerRegistration;
    private IDSIServiceWorker worker;
    private IAdapterErrorLog errorLog;
    protected IProviderService providerService;
    private String className;
    protected int instance;

    public void setClassName(String string) {
        this.className = string;
    }

    public String getClassName() {
        return this.className;
    }

    public void setProviderService(IProviderService iProviderService) {
        this.providerService = iProviderService;
    }

    public IProviderService getProviderService() {
        return this.providerService;
    }

    public void setErrorLog(IAdapterErrorLog iAdapterErrorLog) {
        this.errorLog = iAdapterErrorLog;
    }

    public AbstractProvider(BundleContext bundleContext, Agent agent, IDispatcher iDispatcher, int n) {
        this(bundleContext, agent, iDispatcher);
        this.instance = n;
    }

    public AbstractProvider(BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(iDispatcher);
        this.bundleContext = bundleContext;
        this.agent = agent;
        this.slowReconnectTimeoutStartVal = AdapterConfig.getInstance().slowReconnectTimeoutStartVal();
        this.slowReconnectTimeoutEndVal = AdapterConfig.getInstance().slowReconnectTimeoutEndVal();
        this.maxFastsReconnects = AdapterConfig.getInstance().maxFastsReconnects();
        this.slowReconnectTimeout = this.slowReconnectTimeoutStartVal;
        this.proxyState = 0;
        this.stateListeners = new ArrayList();
        this.providerState.setListener(this);
    }

    protected abstract Proxy createNewProxy() {
    }

    protected abstract Proxy getProxy() {
    }

    @Override
    public int getInstance() {
        int n = -1;
        if (this.getProxy() != null) {
            n = this.getProxy().getInstanceID().getHandle();
        }
        return n;
    }

    @Override
    public final void addProviderStateListener(IProviderStateListener iProviderStateListener) {
        this.stateListeners.add(iProviderStateListener);
    }

    @Override
    public final void removeProviderStateListener(IProviderStateListener iProviderStateListener) {
        this.stateListeners.remove(iProviderStateListener);
    }

    private final void resetProxyReconnection() {
        this.proxyReconnectionCounter = 0;
        this.slowReconnectTimeout = this.slowReconnectTimeoutStartVal;
    }

    @Override
    public void onConnecting(IProvider iProvider) {
        this.tracer.log((short)2, "ProviderState connecting");
        for (int i2 = 0; i2 < this.stateListeners.size(); ++i2) {
            IProviderStateListener iProviderStateListener = (IProviderStateListener)this.stateListeners.get(i2);
            iProviderStateListener.onConnecting(this);
        }
    }

    @Override
    public void onConnected(IProvider iProvider) {
        this.resetProxyReconnection();
        this.tracer.log((short)2, "ProviderState connected");
        if (this.providerService.checkAndClearStopFlag(super.getClass().getName(), this.instance)) {
            this.tracer.log((short)2, "Provider connected but stop flag set disconnect");
            IDSIServiceWorker iDSIServiceWorker = this.stopProvider();
            this.providerService.stopServiceWorker(iDSIServiceWorker);
        } else {
            for (int i2 = 0; i2 < this.stateListeners.size(); ++i2) {
                IProviderStateListener iProviderStateListener = (IProviderStateListener)this.stateListeners.get(i2);
                iProviderStateListener.onConnected(this);
            }
            this.tracer.log((short)2, "Provider connected, register OSGi service: proxy instanceId=%1", this.getProxy().getInstanceID());
            this.registerProvider();
            this.tracer.log((short)2, "DSI connected: service=%1, instance=%2", (Object)this.getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
        }
    }

    @Override
    public void onConnectionFailed(IProvider iProvider) {
        this.tracer.log((short)2, "ProviderState connection failed");
        for (int i2 = 0; i2 < this.stateListeners.size(); ++i2) {
            IProviderStateListener iProviderStateListener = (IProviderStateListener)this.stateListeners.get(i2);
            iProviderStateListener.onConnectionFailed(this);
        }
        this.reconnectProxy();
    }

    @Override
    public void onConnectionLost(IProvider iProvider) {
        this.tracer.log((short)2, "ProviderState connection lost");
        for (int i2 = 0; i2 < this.stateListeners.size(); ++i2) {
            IProviderStateListener iProviderStateListener = (IProviderStateListener)this.stateListeners.get(i2);
            iProviderStateListener.onConnectionLost(this);
        }
        this.unregisterProvider();
        this.unregisterDispatcher();
        this.setupNewProxy();
        this.tracer.log((short)1, "onConnectionLost: setup new proxy");
        this.connectProxy();
        this.tracer.log((short)1, "onConnectionLost: connectProxy !");
    }

    @Override
    public void onDisconnected(IProvider iProvider) {
        this.tracer.log((short)2, "ProviderState disconnected");
        try {
            this.agent.unregisterProxyListener(this.getProxy(), this);
            this.tracer.log((short)0, "COMM Proxy Listener unregistered: name=%1, instance=%2", (Object)this.getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
        }
        catch (Exception exception) {
            this.tracer.log((short)4, "Error during COMM Proxy Listener unregistration: className=%1, instance=%2, error=%3", (Object)super.getClass().getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()), (Object)exception.getMessage());
            this.addProviderError("Error during COMM Proxy Listener unregistration");
        }
        for (int i2 = 0; i2 < this.stateListeners.size(); ++i2) {
            IProviderStateListener iProviderStateListener = (IProviderStateListener)this.stateListeners.get(i2);
            iProviderStateListener.onDisconnected(this);
        }
    }

    @Override
    public void onDisconnecting(IProvider iProvider) {
        this.tracer.log((short)2, "ProviderState disconnecting");
        for (int i2 = 0; i2 < this.stateListeners.size(); ++i2) {
            IProviderStateListener iProviderStateListener = (IProviderStateListener)this.stateListeners.get(i2);
            iProviderStateListener.onDisconnecting(this);
        }
        this.unregisterProvider();
        this.unregisterDispatcher();
        this.disconnectProxy();
    }

    @Override
    public final ProviderState getProviderState() {
        return this.providerState;
    }

    @Override
    public final void startProvider(boolean bl, IDSIServiceWorker iDSIServiceWorker) {
        if (!this.providerState.startService()) {
            this.tracer.log((short)4, "Wrong provider state, cannot start provider: name=%1, instance=%2", (Object)this.getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
            return;
        }
        this.worker = iDSIServiceWorker;
        iDSIServiceWorker.start();
        this.registerDispatcher(iDSIServiceWorker);
        this.getProxy().setReplyServiceWorker(iDSIServiceWorker);
        this.connectProxy();
        if (bl) {
            this.tracer.log((short)2, "Early DSI registration of: name=%1, instance=%2", (Object)this.getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
            this.registerProvider();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public final IDSIServiceWorker stopProvider() {
        if (!this.providerState.stopService()) {
            this.tracer.log((short)4, "Wrong provider state, cannot stop provider: name=%1, instance=%2", (Object)this.getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
            this.addProviderError("Wrong provider state, cannot stop provider!");
            return null;
        }
        Object object = reconnectTimer;
        synchronized (object) {
            if (this.reconnectTask != null) {
                this.reconnectTask.cancel();
            }
        }
        object = this.worker;
        if (this.worker != null) {
            this.worker.stop();
            this.worker = null;
        }
        return object;
    }

    private final void registerDispatcher(IServiceWorker iServiceWorker) {
        try {
            if (iServiceWorker != null) {
                this.agent.registerService(this.dispatcher.getService(), iServiceWorker);
                this.tracer.log((short)2, "DSI Dispatcher registered with service worker: instance=%1, worker=%2", (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()), (Object)iServiceWorker.toString());
            } else {
                this.agent.registerService(this.dispatcher.getService());
                this.tracer.log((short)2, "DSI Dispatcher registered without special service worker: className=%1, instance=%2", (Object)super.getClass().getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
            }
            this.tracer.log((short)2, "DSI Dispatcher registered as COMM service: className=%1, instance=%2", (Object)super.getClass().getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
        }
        catch (Exception exception) {
            this.tracer.log((short)4, "Error during DSI Dispatcher COMM service registration: className=%1, instance=%2, error=%3", (Object)super.getClass().getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()), (Object)exception.getMessage());
            this.addProviderError("Error during DSI Dispatcher COMM service registration");
        }
    }

    private final void connectProxy() {
        try {
            this.agent.registerProxyListener(this.getProxy(), this);
            this.tracer.log((short)0, "COMM Proxy Listener registered: name=%1, instance=%2", (Object)this.getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
        }
        catch (Exception exception) {
            this.tracer.log((short)4, "Error during COMM Proxy Listener registration: className=%1, instance=%2, error=%3", (Object)super.getClass().getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()), (Object)exception.getMessage());
            this.addProviderError("Error during COMM Proxy Listener registration");
        }
        boolean bl = this.getProxy().connectAsync();
        this.tracer.log((short)1, "connectProxy: connectAsync, result=%1!", new Boolean(bl));
    }

    private final void disconnectProxy() {
        this.getProxy().disconnectAsync();
    }

    private final synchronized void registerProvider() {
        if (!this.registered) {
            try {
                String string = this.getName();
                int n = this.getProxy().getInstanceID().getHandle();
                Channels.BENCH_STARTUP.log((short)2, "DSIAdapter.registerServiceProvider(%1,%2)", (Object)string, (Object)new Integer(n));
                Properties properties = new Properties();
                properties.put("DEVICE_NAME", string);
                properties.put("DEVICE_INSTANCE", new Integer(n));
                this.providerRegistration = this.bundleContext.registerService(string, (Object)this, (Dictionary)properties);
                this.tracer.log((short)2, "DSI Provider registered as OSGi service: service=%1, instance=%2", (Object)string, (Object)new Integer(n));
            }
            catch (Exception exception) {
                this.tracer.log((short)4, "Problem during DSI Provider OSGi service registration: serviceName=%1, className=%2, instance=%3, error=%4", (Object)this.getName(), (Object)super.getClass().getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()), (Object)exception.getMessage());
                this.addProviderError("Problem during DSI Provider OSGi service registration");
            }
            this.registered = true;
        }
    }

    private final synchronized void unregisterProvider() {
        if (this.registered && this.providerRegistration != null) {
            this.tracer.log((short)2, "DSI Provider unregistering as OSGi service: name=%1, instance=%2", (Object)this.getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
            this.providerRegistration.unregister();
            this.registered = false;
            String string = this.getName();
            int n = this.getProxy().getInstanceID().getHandle();
            this.dispatcher.clearNotificationListeners();
            Channels.BENCH_STARTUP.log((short)2, "DSIAdapter.unregisterServiceProvider(%1,%2)", (Object)string, (Object)new Integer(n));
        } else {
            this.tracer.log((short)2, "DSI Provider OSGi service not unregistered, since not registered yet: name=%1, instance=%2", (Object)this.getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
        }
    }

    private final void unregisterDispatcher() {
        try {
            this.agent.unregisterService(this.dispatcher.getService());
            this.tracer.log((short)2, "DSI Dispatcher unregistered as COMM service: className=%1, instance=%2", (Object)super.getClass().getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()));
        }
        catch (Exception exception) {
            this.tracer.log((short)4, "Error during DSI Dispatcher COMM service unregistration: className=%1, instance=%2, error=%3", (Object)super.getClass().getName(), (Object)Integer.toString(this.getProxy().getInstanceID().getHandle()), (Object)exception.getMessage());
            this.addProviderError("Error during DSI Dispatcher COMM service unregistration");
        }
    }

    @Override
    public final void proxyStateChanged(Proxy proxy, int n) {
        if (this.getProxy() == proxy && this.proxyState != n) {
            if (n == 3) {
                this.tracer.log((short)2, "Proxy state changed: proxyId=%2, state=%3, reason=%4, proxyInstanceID=%1", proxy.getInstanceID(), (Object)new Short(proxy.getProxyID()), (Object)Lifecycle.lifecycleNames[n], (Object)proxy.getErrorString());
            } else {
                this.tracer.log((short)2, "Proxy state changed: proxyId=%2, state=%3, proxyInstanceID=%1", proxy.getInstanceID(), (Object)new Short(proxy.getProxyID()), (Object)Lifecycle.lifecycleNames[n]);
            }
            this.proxyState = n;
            this.updateProviderState();
        }
    }

    private void updateProviderState() {
        this.tracer.log((short)2, "Update provider state: state=%1, proxyState=%2", (Object)ProviderState.stateNames[this.providerState.getState()], (Object)Lifecycle.lifecycleNames[this.proxyState]);
        if (this.proxyState == 1) {
            this.providerState.setState(2);
        } else if (this.proxyState == 3) {
            if (this.providerState.getState() == 1) {
                this.providerState.setState(5);
            } else if (this.providerState.getState() == 2) {
                this.providerState.setState(4);
            } else if (this.providerState.getState() == 3) {
                this.providerState.setState(0);
            }
        } else if (this.proxyState == 2) {
            if (this.providerState.getState() == 2) {
                this.providerState.setState(4);
            } else {
                this.providerState.setState(0);
            }
        } else if (this.proxyState == 0 && (this.providerState.getState() == 5 || this.providerState.getState() == 4)) {
            this.providerState.setState(1);
        }
    }

    private void setupNewProxy() {
        try {
            this.agent.unregisterProxyListener(this.getProxy(), this);
            this.tracer.log((short)0, "setupNewProxy: unregisterProxyListener done");
        }
        catch (Exception exception) {
            this.tracer.log((short)3, "setupNewProxy: unregisterProxyListener failed!");
        }
        this.createNewProxy();
        this.tracer.log((short)0, "setupNewProxy done");
    }

    private final boolean reconnectProxy() {
        String string = null;
        switch (this.getProxy().getLifecycle().getErrorCode()) {
            case 7: {
                string = "the service does not have a factory for ";
                break;
            }
            case 4: {
                string = "the service reports an interface key mismatch for ";
                break;
            }
            case 2: {
                string = "the instanceId is invalid for ";
            }
        }
        if (string != null) {
            this.tracer.log((short)4, new StringBuffer().append("Proxy error, ").append(string).append("proxy instanceId=%1").toString(), this.getProxy().getInstanceID());
            return false;
        }
        this.setupNewProxy();
        if (++this.proxyReconnectionCounter <= this.maxFastsReconnects) {
            short s = 2;
            if (this.proxyReconnectionCounter == 1) {
                s = 3;
            }
            this.tracer.log(s, "Proxy error, try (fast) reconnection number %1: proxy instanceId=%2", new Integer(this.proxyReconnectionCounter), (Object)this.getProxy().getInstanceID());
            this.connectProxy();
        } else {
            short s = 2;
            if (this.slowReconnectTimeout == this.slowReconnectTimeoutStartVal) {
                s = 3;
            }
            this.tracer.log(s, "Proxy error, trying (slow) reconnection with timeout %2: proxy instanceId=%1", this.getProxy().getInstanceID(), (Object)new Integer(this.slowReconnectTimeout));
            this.scheduleReconnect(this.slowReconnectTimeout);
            this.slowReconnectTimeout <<= 1;
            if (this.slowReconnectTimeout > this.slowReconnectTimeoutEndVal) {
                this.slowReconnectTimeout = this.slowReconnectTimeoutEndVal;
            }
        }
        return true;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private final void scheduleReconnect(int n) {
        Timer timer = reconnectTimer;
        synchronized (timer) {
            if (this.reconnectTask != null) {
                this.reconnectTask.cancel();
            }
            this.reconnectTask = new AbstractProvider$SlowReconnect(this);
            reconnectTimer.schedule((TimerTask)this.reconnectTask, n);
        }
    }

    @Override
    public ProviderInfo getProviderInfo(int n) {
        return this.createProviderInfo(n, null);
    }

    private void addProviderError(String string) {
        if (this.errorLog != null) {
            int n = this.errorLog.getAbsoluteProviderErrors();
            ProviderInfo providerInfo = this.createProviderInfo(n, string);
            this.errorLog.addProviderError(providerInfo);
        }
    }

    private synchronized ProviderInfo createProviderInfo(int n, String string) {
        ProviderInfo providerInfo = new ProviderInfo(n, this, this.proxyState, this.proxyReconnectionCounter, this.providerState, this.slowReconnectTimeout, this.registered, this.maxFastsReconnects, this.slowReconnectTimeout, this.slowReconnectTimeoutEndVal, this.slowReconnectTimeoutStartVal, this.worker, this.getProxy(), string);
        return providerInfo;
    }

    @Override
    public IDispatcher getDispatcher() {
        return this.dispatcher;
    }

    static /* synthetic */ void access$000(AbstractProvider abstractProvider) {
        abstractProvider.connectProxy();
    }
}

