/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.displaycontroller;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.displaycontroller.DSIDisplayControllerReply;
import de.esolutions.fw.comm.dsi.displaycontroller.impl.DSIDisplayControllerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.displaycontroller.DSIDisplayController;
import org.osgi.framework.BundleContext;

public class DSIDisplayControllerProvider
extends AbstractProvider
implements DSIDisplayController {
    private static final int[] attributeIDs = new int[0];
    private DSIDisplayControllerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$displaycontroller$DSIDisplayController;

    public DSIDisplayControllerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$displaycontroller$DSIDisplayController == null ? (class$org$dsi$ifc$displaycontroller$DSIDisplayController = DSIDisplayControllerProvider.class$("org.dsi.ifc.displaycontroller.DSIDisplayController")) : class$org$dsi$ifc$displaycontroller$DSIDisplayController).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIDisplayControllerProxy(this.instance, (DSIDisplayControllerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void switchDisplayPower(int n, int n2, int n3) {
        try {
            this.proxy.switchDisplayPower(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDisplayBrightness(int n, int n2) {
        try {
            this.proxy.setDisplayBrightness(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getDisplayBrightness(int n) {
        try {
            this.proxy.getDisplayBrightness(n);
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

