/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.framework.dsi;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxy;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyDebugInterceptor;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyInterceptor;
import de.vw.mib.asl.framework.internal.dsiproxy.adapter.AdapterFactoryImpl;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIInterceptor;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceLocator$DSIMethodsRetriever;
import de.vw.mib.asl.framework.internal.framework.dsi.DSIServiceStateListener;
import de.vw.mib.asl.framework.internal.framework.dsi.proxy.DSIProxyInvocationHandler;
import de.vw.mib.asl.framework.internal.framework.dsi.proxy.DSIProxyTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.skeleton.DSISkeletonTarget;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Constants;
import de.vw.mib.asl.framework.internal.framework.dsi.util.Utils;
import de.vw.mib.genericevents.Target;
import de.vw.mib.reflection.RuntimeUtil;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.base.IAdapterManager;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

public final class DSIServiceLocator
implements DSIProxy {
    private final DSISkeletonTarget skeletonTarget;
    private final DSIProxyTarget proxyTarget;
    private final DSIProxyAdapterFactory adapterFactory;
    private ILocationAccessorFactory locationAccessorFactory;
    static /* synthetic */ Class class$org$dsi$ifc$base$IAdapterManager;
    static /* synthetic */ Class class$org$dsi$ifc$navigation$util$ILocationAccessorFactory;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIBase;
    static /* synthetic */ Class class$org$dsi$ifc$base$DSIListener;

    public DSIServiceLocator(DSISkeletonTarget dSISkeletonTarget, DSIProxyTarget dSIProxyTarget, BundleContext bundleContext) {
        this.skeletonTarget = dSISkeletonTarget;
        this.proxyTarget = dSIProxyTarget;
        this.adapterFactory = new AdapterFactoryImpl();
        try {
            IAdapterManager iAdapterManager;
            ServiceReference serviceReference = bundleContext.getServiceReference((class$org$dsi$ifc$base$IAdapterManager == null ? (class$org$dsi$ifc$base$IAdapterManager = DSIServiceLocator.class$("org.dsi.ifc.base.IAdapterManager")) : class$org$dsi$ifc$base$IAdapterManager).getName());
            if (serviceReference != null && (iAdapterManager = (IAdapterManager)bundleContext.getService(serviceReference)) != null) {
                this.locationAccessorFactory = (ILocationAccessorFactory)iAdapterManager.getFactory(class$org$dsi$ifc$navigation$util$ILocationAccessorFactory == null ? (class$org$dsi$ifc$navigation$util$ILocationAccessorFactory = DSIServiceLocator.class$("org.dsi.ifc.navigation.util.ILocationAccessorFactory")) : class$org$dsi$ifc$navigation$util$ILocationAccessorFactory);
            }
            if (this.locationAccessorFactory == null) {
                ServiceManager.loggerDSIProxy.warn().append("Could not retrieve DSI adaptor factory.").log();
            }
        }
        catch (Exception exception) {
            ServiceManager.loggerDSIProxy.error().append("Could not retrieve DSI adaptor factory.").attachThrowable(exception).log();
        }
    }

    @Override
    public ILocationAccessorFactory getLocationAccessorFactory() {
        return this.locationAccessorFactory;
    }

    @Override
    public DSIProxyAdapterFactory getAdapterFactory() {
        return this.adapterFactory;
    }

    @Override
    public DSIBase getService(Target target, Class clazz) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return this.getService(target, n, 0);
    }

    @Override
    public DSIBase getService(Target target, Class clazz, int n) {
        Utils.checkDSIServiceType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        return this.getService(target, n2, n);
    }

    @Override
    public boolean clearPendingResponses(Class clazz, String string) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return this.proxyTarget.clearPendingResponses(n, 0, string);
    }

    @Override
    public boolean clearPendingResponses(Class clazz, int n, String string) {
        Utils.checkDSIServiceType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        return this.proxyTarget.clearPendingResponses(n2, 0, string);
    }

    @Override
    public boolean clearWaitingRequests(Class clazz, String string) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        return this.proxyTarget.clearWaitingRequests(n, 0, string);
    }

    @Override
    public boolean clearWaitingRequests(Class clazz, int n, String string) {
        Utils.checkDSIServiceType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        return this.proxyTarget.clearWaitingRequests(n2, n, string);
    }

    public void setServiceUnexpectedResponsePrevent(Class clazz, String string, boolean bl) {
        this.setUnexpectedResponsePassing(clazz, string, !bl);
    }

    @Override
    public void setUnexpectedResponsePassing(Class clazz, int n, String string, boolean bl) {
        Utils.checkDSIServiceType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        this.proxyTarget.setUnexpectedResponsePassing(n2, n, string, bl);
    }

    public void setServiceUnexpectedResponsePrevent(Class clazz, int n, String string, boolean bl) {
        this.setUnexpectedResponsePassing(clazz, n, string, !bl);
    }

    @Override
    public void setUnexpectedResponsePassing(Class clazz, String string, boolean bl) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        this.proxyTarget.setUnexpectedResponsePassing(n, 0, string, bl);
    }

    @Override
    public void addServiceStateListener(de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener dSIServiceStateListener) {
        this.proxyTarget.addServiceStateListener(dSIServiceStateListener);
    }

    public void addServiceStateListener(DSIServiceStateListener dSIServiceStateListener) {
        this.addServiceStateListener((de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener)dSIServiceStateListener);
    }

    @Override
    public void addServiceStateListener(Class clazz, de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener dSIServiceStateListener) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        this.proxyTarget.addServiceStateListener(n, 0, dSIServiceStateListener);
    }

    public void addServiceStateListener(Class clazz, DSIServiceStateListener dSIServiceStateListener) {
        this.addServiceStateListener(clazz, (de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener)dSIServiceStateListener);
    }

    @Override
    public void addServiceStateListener(Class clazz, int n, de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener dSIServiceStateListener) {
        Utils.checkDSIServiceType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        this.proxyTarget.addServiceStateListener(n2, n, dSIServiceStateListener);
    }

    public void addServiceStateListener(Class clazz, int n, DSIServiceStateListener dSIServiceStateListener) {
        this.addServiceStateListener(clazz, n, (de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener)dSIServiceStateListener);
    }

    @Override
    public void removeServiceStateListener(de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener dSIServiceStateListener) {
        this.proxyTarget.removeServiceStateListener(dSIServiceStateListener);
    }

    public void removeServiceStateListener(DSIServiceStateListener dSIServiceStateListener) {
        this.removeServiceStateListener((de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener)dSIServiceStateListener);
    }

    @Override
    public void removeServiceStateListener(Class clazz, de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener dSIServiceStateListener) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        this.proxyTarget.removeServiceStateListener(n, 0, dSIServiceStateListener);
    }

    public void removeServiceStateListener(Class clazz, DSIServiceStateListener dSIServiceStateListener) {
        this.removeServiceStateListener(clazz, (de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener)dSIServiceStateListener);
    }

    @Override
    public void removeServiceStateListener(Class clazz, int n, de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener dSIServiceStateListener) {
        Utils.checkDSIServiceType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        this.proxyTarget.removeServiceStateListener(n2, n, dSIServiceStateListener);
    }

    public void removeServiceStateListener(Class clazz, int n, DSIServiceStateListener dSIServiceStateListener) {
        this.removeServiceStateListener(clazz, n, (de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener)dSIServiceStateListener);
    }

    @Override
    public void addResponseListener(Target target, Class clazz, DSIListener dSIListener) {
        Utils.checkDSIListenerType(clazz);
        int n = Utils.getTypeIndex(clazz);
        this.addResponseListener(target, n, 0, dSIListener);
    }

    @Override
    public void addResponseListener(Target target, Class clazz, int n, DSIListener dSIListener) {
        Utils.checkDSIListenerType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        this.addResponseListener(target, n2, n, dSIListener);
    }

    @Override
    public void removeResponseListener(Target target, Class clazz, DSIListener dSIListener) {
        Utils.checkDSIListenerType(clazz);
        int n = Utils.getTypeIndex(clazz);
        this.removeResponseListener(target, n, 0, dSIListener);
    }

    @Override
    public void removeResponseListener(Target target, Class clazz, int n, DSIListener dSIListener) {
        Utils.checkDSIListenerType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        this.removeResponseListener(target, n2, n, dSIListener);
    }

    @Override
    public void addServiceInterceptor(Class clazz, DSIProxyInterceptor dSIProxyInterceptor) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        this.proxyTarget.addServiceInterceptor(n, 0, dSIProxyInterceptor);
    }

    public void addServiceInterceptor(Class clazz, DSIInterceptor dSIInterceptor) {
        this.addServiceInterceptor(clazz, (DSIProxyInterceptor)dSIInterceptor);
    }

    @Override
    public void addServiceInterceptor(Class clazz, int n, DSIProxyInterceptor dSIProxyInterceptor) {
        Utils.checkDSIServiceType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        this.proxyTarget.addServiceInterceptor(n2, n, dSIProxyInterceptor);
    }

    public void addServiceInterceptor(Class clazz, int n, DSIInterceptor dSIInterceptor) {
        this.addServiceInterceptor(clazz, n, (DSIProxyInterceptor)dSIInterceptor);
    }

    @Override
    public void removeServiceInterceptor(Class clazz, DSIProxyInterceptor dSIProxyInterceptor) {
        Utils.checkDSIServiceType(clazz);
        int n = Utils.getTypeIndex(clazz);
        this.proxyTarget.removeServiceInterceptor(n, 0, dSIProxyInterceptor);
    }

    public void removeServiceInterceptor(Class clazz, DSIInterceptor dSIInterceptor) {
        this.removeServiceInterceptor(clazz, (DSIProxyInterceptor)dSIInterceptor);
    }

    @Override
    public void removeServiceInterceptor(Class clazz, int n, DSIProxyInterceptor dSIProxyInterceptor) {
        Utils.checkDSIServiceType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        this.proxyTarget.removeServiceInterceptor(n2, n, dSIProxyInterceptor);
    }

    public void removeServiceInterceptor(Class clazz, int n, DSIInterceptor dSIInterceptor) {
        this.removeServiceInterceptor(clazz, n, (DSIProxyInterceptor)dSIInterceptor);
    }

    @Override
    public void addListenerInterceptor(Class clazz, DSIProxyInterceptor dSIProxyInterceptor) {
        Utils.checkDSIListenerType(clazz);
        int n = Utils.getTypeIndex(clazz);
        this.skeletonTarget.addListenerInterceptor(n, 0, dSIProxyInterceptor);
    }

    public void addListenerInterceptor(Class clazz, DSIInterceptor dSIInterceptor) {
        this.addListenerInterceptor(clazz, (DSIProxyInterceptor)dSIInterceptor);
    }

    @Override
    public void addListenerInterceptor(Class clazz, int n, DSIProxyInterceptor dSIProxyInterceptor) {
        Utils.checkDSIListenerType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        this.skeletonTarget.addListenerInterceptor(n2, n, dSIProxyInterceptor);
    }

    public void addListenerInterceptor(Class clazz, int n, DSIInterceptor dSIInterceptor) {
        this.addListenerInterceptor(clazz, n, (DSIProxyInterceptor)dSIInterceptor);
    }

    @Override
    public void removeListenerInterceptor(Class clazz, DSIProxyInterceptor dSIProxyInterceptor) {
        Utils.checkDSIListenerType(clazz);
        int n = Utils.getTypeIndex(clazz);
        this.skeletonTarget.removeListenerInterceptor(n, 0, dSIProxyInterceptor);
    }

    public void removeListenerInterceptor(Class clazz, DSIInterceptor dSIInterceptor) {
        this.removeListenerInterceptor(clazz, (DSIProxyInterceptor)dSIInterceptor);
    }

    @Override
    public void removeListenerInterceptor(Class clazz, int n, DSIProxyInterceptor dSIProxyInterceptor) {
        Utils.checkDSIListenerType(clazz);
        int n2 = Utils.getTypeIndex(clazz);
        this.skeletonTarget.removeListenerInterceptor(n2, n, dSIProxyInterceptor);
    }

    public void removeListenerInterceptor(Class clazz, int n, DSIInterceptor dSIInterceptor) {
        this.removeListenerInterceptor(clazz, n, (DSIProxyInterceptor)dSIInterceptor);
    }

    @Override
    public void addDebugInterceptor(DSIProxyDebugInterceptor dSIProxyDebugInterceptor) {
        Utils.addDebugInterceptor(dSIProxyDebugInterceptor);
    }

    @Override
    public void removeDebugInterceptor(DSIProxyDebugInterceptor dSIProxyDebugInterceptor) {
        Utils.removeDebugInterceptor(dSIProxyDebugInterceptor);
    }

    private DSIBase getService(Target target, int n, int n2) {
        int n3 = target != null ? target.getTargetId() : -1;
        DSIProxyInvocationHandler dSIProxyInvocationHandler = new DSIProxyInvocationHandler(this.proxyTarget, n, n2, n3);
        return ServiceManager.reflectionFactory.newServicesProxy(n, Constants.PROXY_OAP, dSIProxyInvocationHandler);
    }

    private void addResponseListener(Target target, int n, int n2, DSIListener dSIListener) {
        int n3 = target != null ? target.getTargetId() : -1;
        this.proxyTarget.addResponseListener(n, n2, n3, dSIListener);
    }

    private void removeResponseListener(Target target, int n, int n2, DSIListener dSIListener) {
        int n3 = target != null ? target.getTargetId() : -1;
        this.proxyTarget.removeResponseListener(n, n2, n3, dSIListener);
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        RuntimeUtil.addMethodsRetriever(new DSIServiceLocator$DSIMethodsRetriever());
    }
}

