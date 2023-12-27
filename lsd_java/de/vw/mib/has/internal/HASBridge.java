/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.has.internal;

import de.vw.mib.collections.OptHashMapHelper;
import de.vw.mib.collections.ints.IntOptHashSet;
import de.vw.mib.collections.ints.IntSet;
import de.vw.mib.has.HASClient;
import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASContext;
import de.vw.mib.has.HASException;
import de.vw.mib.has.HASInvocation;
import de.vw.mib.has.HASInvocationHandler;
import de.vw.mib.has.HASPropertyObserver;
import de.vw.mib.has.internal.HASCallsBridge;
import de.vw.mib.has.internal.HASContainerBuilder;
import de.vw.mib.has.internal.HASDataPoolImpl;
import de.vw.mib.has.internal.HASInvocationImpl;
import de.vw.mib.has.internal.HASLog;
import de.vw.mib.has.internal.HASRegistryImpl;
import de.vw.mib.log4mib.LogMessage;
import org.dsi.ifc.has.DSIHAS;
import org.dsi.ifc.has.DSIHASListener;
import org.dsi.ifc.has.HASDataContainer;

public final class HASBridge
implements DSIHASListener,
HASInvocationHandler,
HASPropertyObserver {
    private final IntSet requestedProperties = OptHashMapHelper.synchronizedIntSet(new IntOptHashSet());
    private final IntSet subscribedProperties = OptHashMapHelper.synchronizedIntSet(new IntOptHashSet());
    private final HASClient client;
    private final HASRegistryImpl registry;
    private final HASDataPoolImpl datapool;
    private final HASContainerBuilder builder;
    private final HASCallsBridge callsBridge;
    private final DSIHAS dsiService;
    private final String logPrefix;

    HASBridge(HASClient hASClient, HASRegistryImpl hASRegistryImpl, HASDataPoolImpl hASDataPoolImpl, HASContainerBuilder hASContainerBuilder, HASCallsBridge hASCallsBridge, DSIHAS dSIHAS) {
        this.client = hASClient;
        this.registry = hASRegistryImpl;
        this.datapool = hASDataPoolImpl;
        this.builder = hASContainerBuilder;
        this.callsBridge = hASCallsBridge;
        this.dsiService = dSIHAS;
        this.logPrefix = new StringBuffer().append("HASBridge[").append(hASClient.getClientName()).append(']').toString();
    }

    @Override
    public void asyncException(int n, String string, int n2) {
        LogMessage logMessage = HASLog.error();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "asyncException", true);
            HASLog.appendIntProperty(logMessage, "errorCode", n, false);
            HASLog.appendIntProperty(logMessage, "requestType", n2, true);
            logMessage.append(", errorMsg=\"").append(String.valueOf(string)).append("\"").log();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void actionRequest(int n, int n2, HASDataContainer[] hASDataContainerArray) {
        HASInvocationImpl hASInvocationImpl = HASInvocationImpl.create(n, n2);
        try {
            HASContainer hASContainer = this.builder.build(hASDataContainerArray);
            hASInvocationImpl.setArgument(hASContainer);
            HASContext hASContext = this.registry.getContextByAction(n2);
            hASInvocationImpl.setContext(hASContext);
            this.handleInvocation(hASInvocationImpl);
        }
        catch (HASException hASException) {
            LogMessage logMessage = HASLog.error();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "actionRequest", true).append(hASException.getMessage());
                HASLog.appendHASInvocation(logMessage, hASInvocationImpl, true).attachThrowable(hASException).log();
            }
            this.dsiService.actionResult(n, n2, null, HASBridge.resultCodeToDSI(hASException.getResultCode()));
        }
        finally {
            hASInvocationImpl.release();
        }
    }

    @Override
    public void handleInvocation(HASInvocation hASInvocation) {
        try {
            HASInvocationHandler hASInvocationHandler;
            LogMessage logMessage = HASLog.trace();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "handleInvocation", true);
                HASLog.appendHASInvocation(logMessage, hASInvocation, false).log();
            }
            if (null != (hASInvocationHandler = this.client.getInvocationAdapter())) {
                logMessage = HASLog.trace();
                if (null != logMessage) {
                    HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "handleInvocation", true).append("Calling invocation adapter");
                    HASLog.appendHASInvocation(logMessage, hASInvocation, true).log();
                }
                hASInvocationHandler.handleInvocation(hASInvocation);
                logMessage = HASLog.trace();
                if (null != logMessage) {
                    HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "handleInvocation", true).append("Invocation adapter result");
                    HASLog.appendHASInvocation(logMessage, hASInvocation, true).log();
                }
            } else if (this.client.isAdapterRequired()) {
                logMessage = HASLog.warn();
                if (null != logMessage) {
                    HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "handleInvocation", true).append("Required invocation adapter not set");
                    HASLog.appendHASInvocation(logMessage, hASInvocation, true).log();
                }
                hASInvocation.setState(1);
                hASInvocation.setResultCode(-1);
                hASInvocation.setResult(null);
            }
            switch (hASInvocation.getState()) {
                case 0: {
                    this.handleActionRequest(hASInvocation);
                    break;
                }
                case 1: {
                    this.handleCallResult(hASInvocation);
                    break;
                }
                case 2: {
                    logMessage = HASLog.info();
                    if (null != logMessage) {
                        HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "handleInvocation", true).append("Dropped by invocation adapter");
                        HASLog.appendHASInvocation(logMessage, hASInvocation, true).log();
                    }
                    break;
                }
                default: {
                    throw new IllegalStateException("unknown invocation state");
                }
            }
        }
        catch (HASException hASException) {
            LogMessage logMessage = HASLog.error();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "handleInvocation", true).append(hASException.getMessage());
                HASLog.appendHASInvocation(logMessage, hASInvocation, true).attachThrowable(hASException).log();
            }
            this.dsiService.actionResult(hASInvocation.getRequestId(), hASInvocation.getOrigActionId(), null, HASBridge.resultCodeToDSI(hASException.getResultCode()));
        }
        catch (UnsupportedOperationException unsupportedOperationException) {
            LogMessage logMessage = HASLog.warn();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "handleInvocation", true).append("Not implemented by context");
                HASLog.appendHASInvocation(logMessage, hASInvocation, true).log();
            }
            this.dsiService.actionResult(hASInvocation.getRequestId(), hASInvocation.getOrigActionId(), null, 18);
        }
        catch (RuntimeException runtimeException) {
            LogMessage logMessage = HASLog.error();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "handleInvocation", true).append(runtimeException.toString());
                HASLog.appendHASInvocation(logMessage, hASInvocation, true).attachThrowable(runtimeException).log();
            }
            this.dsiService.actionResult(hASInvocation.getRequestId(), hASInvocation.getOrigActionId(), null, 16);
        }
    }

    private void handleActionRequest(HASInvocation hASInvocation) {
        HASContext hASContext = this.registry.getContextByAction(hASInvocation.getActionId());
        hASInvocation.setContext(hASContext);
        if (null == hASContext) {
            throw HASException.invalidActionRequest(hASInvocation.getActionId());
        }
        if (!hASContext.isContextReady()) {
            throw HASException.contextNotReady(hASContext.getContextName());
        }
        this.callsBridge.handleActionRequest(hASInvocation, this);
    }

    private void handleCallResult(HASInvocation hASInvocation) {
        HASDataContainer[] hASDataContainerArray = this.builder.build(hASInvocation.getResult());
        this.dsiService.actionResult(hASInvocation.getRequestId(), hASInvocation.getOrigActionId(), hASDataContainerArray, HASBridge.resultCodeToDSI(hASInvocation.getResultCode()));
    }

    @Override
    public void getPropertyRequest(int n) {
        block16: {
            HASContext hASContext;
            LogMessage logMessage = HASLog.trace();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "getPropertyRequest", true);
                HASLog.appendPropertyId(logMessage, n, false).log();
            }
            if (null == (hASContext = this.registry.getContextByProperty(n))) {
                logMessage = HASLog.error();
                if (null != logMessage) {
                    HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "getPropertyRequest", true).append("Unknown property");
                    HASLog.appendPropertyId(logMessage, n, true).log();
                }
                this.dsiService.propertyUpdate(n, null, 1);
            } else if (!hASContext.isContextReady()) {
                logMessage = HASLog.warn();
                if (null != logMessage) {
                    HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "getPropertyRequest", true).append("Context not ready");
                    HASLog.appendPropertyId(logMessage, n, true);
                    HASLog.appendHASContext(logMessage, hASContext, true).log();
                }
                this.dsiService.propertyUpdate(n, null, 17);
            } else {
                HASDataContainer[] hASDataContainerArray;
                try {
                    hASDataContainerArray = this.datapool.getDSIProperty(n);
                }
                catch (HASException hASException) {
                    logMessage = HASLog.error();
                    if (null != logMessage) {
                        HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "getPropertyRequest", true).append(hASException.getMessage());
                        HASLog.appendPropertyId(logMessage, n, true);
                        HASLog.appendHASContext(logMessage, hASContext, true);
                        logMessage.attachThrowable(hASException).log();
                    }
                    hASDataContainerArray = null;
                }
                if (null != hASDataContainerArray) {
                    this.dsiService.propertyUpdate(n, hASDataContainerArray, 0);
                } else {
                    this.requestedProperties.add(n);
                    try {
                        hASContext.getServicesImpl().propertyRequest(n);
                    }
                    catch (HASException hASException) {
                        logMessage = HASLog.error();
                        if (null != logMessage) {
                            HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "getPropertyRequest", true).append(hASException.getMessage());
                            HASLog.appendPropertyId(logMessage, n, true);
                            HASLog.appendHASContext(logMessage, hASContext, true);
                            logMessage.attachThrowable(hASException).log();
                        }
                        this.requestedProperties.remove(n);
                        this.dsiService.propertyUpdate(n, null, HASBridge.resultCodeToDSI(hASException.getResultCode()));
                    }
                    catch (UnsupportedOperationException unsupportedOperationException) {
                        logMessage = HASLog.trace();
                        if (null == logMessage) break block16;
                        HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "getPropertyRequest", true).append("Get request unsupported by context");
                        HASLog.appendPropertyId(logMessage, n, true);
                        HASLog.appendHASContext(logMessage, hASContext, true).log();
                    }
                }
            }
        }
    }

    @Override
    public void subscribeRequest(int n, int n2) {
        HASDataContainer[] hASDataContainerArray;
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "subscribeRequest", true);
            HASLog.appendPropertyId(logMessage, n, false);
            HASLog.appendIntProperty(logMessage, "interval", n2, true).log();
        }
        this.subscribedProperties.add(n);
        try {
            hASDataContainerArray = this.datapool.getDSIProperty(n);
        }
        catch (HASException hASException) {
            logMessage = HASLog.error();
            if (null != logMessage) {
                HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "subscribeRequest", true).append(hASException.getMessage());
                HASLog.appendPropertyId(logMessage, n, true);
                logMessage.attachThrowable(hASException).log();
            }
            hASDataContainerArray = null;
        }
        if (null != hASDataContainerArray) {
            this.dsiService.propertyUpdate(n, hASDataContainerArray, 0);
        }
    }

    @Override
    public void unsubscribeAllRequest() {
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "unsubscribeAllRequest", false).log();
        }
        this.subscribedProperties.clear();
    }

    @Override
    public void unsubscribeRequest(int n) {
        LogMessage logMessage = HASLog.trace();
        if (null != logMessage) {
            HASLog.appendPrefixAndMethod(logMessage, this.logPrefix, "unsubscribeRequest", true);
            HASLog.appendPropertyId(logMessage, n, false).log();
        }
        this.subscribedProperties.remove(n);
    }

    @Override
    public void propertyUpdated(int n, HASDataContainer[] hASDataContainerArray) {
        boolean bl = this.requestedProperties.remove(n);
        if (bl || this.subscribedProperties.contains(n)) {
            this.dsiService.propertyUpdate(n, hASDataContainerArray, 0);
        }
    }

    @Override
    public boolean isPropertyRequested(int n) {
        return this.requestedProperties.contains(n);
    }

    static int resultCodeToDSI(int n) {
        switch (n) {
            case -8: {
                n = 5;
                break;
            }
            case -7: {
                n = 4;
                break;
            }
            case -6: {
                n = 3;
                break;
            }
            case -5: {
                n = 2;
                break;
            }
            case -4: {
                n = 1;
                break;
            }
            case -3: {
                n = 16;
                break;
            }
            case -2: {
                n = 18;
                break;
            }
            case -1: {
                n = 17;
                break;
            }
            case 0: {
                n = 0;
                break;
            }
            case 1: {
                n = 16;
                break;
            }
            case 2: {
                n = 16;
                break;
            }
        }
        return n;
    }
}

