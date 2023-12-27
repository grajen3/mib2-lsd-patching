/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.bap;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.bap.DSIBAPReply;
import de.esolutions.fw.comm.dsi.bap.impl.DSIBAPProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.bap.DSIBAP;
import org.osgi.framework.BundleContext;

public class DSIBAPProvider
extends AbstractProvider
implements DSIBAP {
    private static final int[] attributeIDs = new int[0];
    private DSIBAPProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$bap$DSIBAP;

    public DSIBAPProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$bap$DSIBAP == null ? (class$org$dsi$ifc$bap$DSIBAP = DSIBAPProvider.class$("org.dsi.ifc.bap.DSIBAP")) : class$org$dsi$ifc$bap$DSIBAP).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIBAPProxy(this.instance, (DSIBAPReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void getBAPState(int n) {
        try {
            this.proxy.getBAPState(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHMIState(int n, int n2) {
        try {
            this.proxy.setHMIState(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void request(int n, int n2, int n3, int n4, int n5) {
        try {
            this.proxy.request(n, n2, n3, n4, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestVoid(int n, int n2, int n3) {
        try {
            this.proxy.requestVoid(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestByteSequence(int n, int n2, int n3, byte[] byArray) {
        try {
            this.proxy.requestByteSequence(n, n2, n3, byArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestError(int n, int n2, int n3) {
        try {
            this.proxy.requestError(n, n2, n3);
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

