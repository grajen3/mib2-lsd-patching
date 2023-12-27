/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.dsiproxy;

import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyAdapterFactory;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyDebugInterceptor;
import de.vw.mib.asl.framework.api.dsiproxy.DSIProxyInterceptor;
import de.vw.mib.asl.framework.api.dsiproxy.DSIServiceStateListener;
import de.vw.mib.genericevents.Target;
import org.dsi.ifc.base.DSIBase;
import org.dsi.ifc.base.DSIListener;
import org.dsi.ifc.navigation.util.ILocationAccessorFactory;

public interface DSIProxy {
    default public ILocationAccessorFactory getLocationAccessorFactory() {
    }

    default public DSIProxyAdapterFactory getAdapterFactory() {
    }

    default public DSIBase getService(Target target, Class clazz) {
    }

    default public DSIBase getService(Target target, Class clazz, int n) {
    }

    default public void addResponseListener(Target target, Class clazz, DSIListener dSIListener) {
    }

    default public void addResponseListener(Target target, Class clazz, int n, DSIListener dSIListener) {
    }

    default public void removeResponseListener(Target target, Class clazz, DSIListener dSIListener) {
    }

    default public void removeResponseListener(Target target, Class clazz, int n, DSIListener dSIListener) {
    }

    default public void addServiceStateListener(DSIServiceStateListener dSIServiceStateListener) {
    }

    default public void addServiceStateListener(Class clazz, DSIServiceStateListener dSIServiceStateListener) {
    }

    default public void addServiceStateListener(Class clazz, int n, DSIServiceStateListener dSIServiceStateListener) {
    }

    default public void removeServiceStateListener(DSIServiceStateListener dSIServiceStateListener) {
    }

    default public void removeServiceStateListener(Class clazz, DSIServiceStateListener dSIServiceStateListener) {
    }

    default public void removeServiceStateListener(Class clazz, int n, DSIServiceStateListener dSIServiceStateListener) {
    }

    default public void addServiceInterceptor(Class clazz, DSIProxyInterceptor dSIProxyInterceptor) {
    }

    default public void addServiceInterceptor(Class clazz, int n, DSIProxyInterceptor dSIProxyInterceptor) {
    }

    default public void removeServiceInterceptor(Class clazz, DSIProxyInterceptor dSIProxyInterceptor) {
    }

    default public void removeServiceInterceptor(Class clazz, int n, DSIProxyInterceptor dSIProxyInterceptor) {
    }

    default public void addListenerInterceptor(Class clazz, DSIProxyInterceptor dSIProxyInterceptor) {
    }

    default public void addListenerInterceptor(Class clazz, int n, DSIProxyInterceptor dSIProxyInterceptor) {
    }

    default public void removeListenerInterceptor(Class clazz, DSIProxyInterceptor dSIProxyInterceptor) {
    }

    default public void removeListenerInterceptor(Class clazz, int n, DSIProxyInterceptor dSIProxyInterceptor) {
    }

    default public void addDebugInterceptor(DSIProxyDebugInterceptor dSIProxyDebugInterceptor) {
    }

    default public void removeDebugInterceptor(DSIProxyDebugInterceptor dSIProxyDebugInterceptor) {
    }

    default public boolean clearPendingResponses(Class clazz, String string) {
    }

    default public boolean clearPendingResponses(Class clazz, int n, String string) {
    }

    default public boolean clearWaitingRequests(Class clazz, String string) {
    }

    default public boolean clearWaitingRequests(Class clazz, int n, String string) {
    }

    default public void setUnexpectedResponsePassing(Class clazz, String string, boolean bl) {
    }

    default public void setUnexpectedResponsePassing(Class clazz, int n, String string, boolean bl) {
    }
}

