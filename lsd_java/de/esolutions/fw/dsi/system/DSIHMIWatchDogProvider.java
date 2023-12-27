/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.system;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.system.DSIHMIWatchDogReply;
import de.esolutions.fw.comm.dsi.system.impl.DSIHMIWatchDogProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.system.DSIHMIWatchDog;
import org.osgi.framework.BundleContext;

public class DSIHMIWatchDogProvider
extends AbstractProvider
implements DSIHMIWatchDog {
    private static final int[] attributeIDs = new int[]{1};
    private DSIHMIWatchDogProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$system$DSIHMIWatchDog;

    public DSIHMIWatchDogProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$system$DSIHMIWatchDog == null ? (class$org$dsi$ifc$system$DSIHMIWatchDog = DSIHMIWatchDogProvider.class$("org.dsi.ifc.system.DSIHMIWatchDog")) : class$org$dsi$ifc$system$DSIHMIWatchDog).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIHMIWatchDogProxy(this.instance, (DSIHMIWatchDogReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void heartbeat(int n) {
        try {
            this.proxy.heartbeat(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void errorlogDumpResult(int n) {
        try {
            this.proxy.errorlogDumpResult(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void hmiReady() {
        try {
            this.proxy.hmiReady();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int[] nArray) {
        try {
            this.proxy.setNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification(int n) {
        try {
            this.proxy.setNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNotification() {
        try {
            this.proxy.setNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int[] nArray) {
        try {
            this.proxy.clearNotification(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification(int n) {
        try {
            this.proxy.clearNotification(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearNotification() {
        try {
            this.proxy.clearNotification();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void yySet(String string, String string2) {
        try {
            this.proxy.yySet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

