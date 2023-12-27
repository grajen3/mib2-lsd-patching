/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.diag;

import de.esolutions.fw.comm.agent.diag.AbstractInfoBase;
import de.esolutions.fw.comm.core.Lifecycle;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.dsi.base.IProvider;
import de.esolutions.fw.dsi.base.ProviderState;
import de.esolutions.fw.dsi.comm.IDSIServiceWorker;
import java.lang.reflect.Field;

public class ProviderInfo
extends AbstractInfoBase {
    public final String proxyState;
    public final String providerState;
    public final String providerClass;
    public final boolean registered;
    public final String serviceWorkerName;
    public final int serviceWorkerUseCount;
    public final String proxyErrorString;
    public String errorTimeStamp;
    public final int proxyErrorCode;
    public final int proxyId;
    public final int proxyReconnectionCounter;
    public final String errorMessage;
    public final ServiceInstanceID serviceInstanceId;
    private static final int DEFAULT_PROXY_RECONNECTION_COUNTER;
    private static final int DEFAULT_PROXY_ERROR_CODE_0;
    private static final int DEFAULT_PROXY_ERROR_CODE_MINUS_1;
    private static final boolean DEFAULT_REGISTERED;
    private static final String DEFAULT_PROXY_STATE;
    private static final String DEFAULT_PROVIDER_STATE;
    private static final int DEFAULT_SERVICE_WORKER_USE_COUNT;
    private static final int DEFAULT_PROXY_ID;

    @Override
    protected Object fieldValueToObject(Field field) {
        if (field == null) {
            return null;
        }
        String string = field.getName();
        if (string.equals("proxyReconnectionCounter") && this.proxyReconnectionCounter == 0 || string.equals("proxyErrorCode") && this.proxyErrorCode == 0 || string.equals("proxyErrorCode") && this.proxyErrorCode == -1 || string.equals("proxyErrorString") && this.proxyErrorCode == 0 || string.equals("proxyErrorString") && this.proxyErrorCode == -1 || string.equals("registered") && this.registered || string.equals("proxyState") && this.proxyState == null || string.equals("proxyState") && this.proxyState.equals(DEFAULT_PROXY_STATE) || string.equals("providerState") && this.providerState == null || string.equals("providerState") && this.providerState.equals(DEFAULT_PROVIDER_STATE) || string.equals("serviceWorkerUseCount") && this.serviceWorkerName == null || string.equals("serviceWorkerUseCount") && this.serviceWorkerUseCount == 1 || string.equals("proxyId") && this.proxyId == -1) {
            return null;
        }
        return super.fieldValueToObject(field);
    }

    public ProviderInfo(int n, IProvider iProvider, int n2, int n3, ProviderState providerState, int n4, boolean bl, int n5, int n6, int n7, int n8, IDSIServiceWorker iDSIServiceWorker, Proxy proxy, String string) {
        super(n);
        this.errorMessage = string;
        if (string != null) {
            this.errorTimeStamp = super.getTimeStampString();
        }
        this.providerClass = iProvider != null ? super.getClass().getName() : null;
        this.proxyReconnectionCounter = n3;
        this.providerState = providerState != null ? ProviderState.stateNames[providerState.getState()] : null;
        this.proxyState = Lifecycle.lifecycleNames[n2];
        this.registered = bl;
        if (iDSIServiceWorker != null) {
            this.serviceWorkerName = iDSIServiceWorker.getName();
            this.serviceWorkerUseCount = iDSIServiceWorker.getUseCount();
        } else {
            this.serviceWorkerName = null;
            this.serviceWorkerUseCount = 0;
        }
        if (proxy != null) {
            this.proxyErrorString = proxy.getErrorString();
            this.proxyErrorCode = proxy.getErrorCode();
            this.proxyId = proxy.getProxyID();
            this.serviceInstanceId = proxy.getInstanceID();
        } else {
            this.serviceInstanceId = null;
            this.proxyErrorString = null;
            this.proxyErrorCode = -1;
            this.proxyId = -1;
        }
    }

    @Override
    public ServiceInstanceID getServiceInstanceID() {
        return this.serviceInstanceId;
    }

    static {
        DEFAULT_PROXY_STATE = Lifecycle.lifecycleNames[1];
        DEFAULT_PROVIDER_STATE = ProviderState.stateNames[2];
    }
}

