/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.bluetooth;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.bluetooth.DSIObjectPushReply;
import de.esolutions.fw.comm.dsi.bluetooth.impl.DSIObjectPushProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.bluetooth.DSIObjectPush;
import org.osgi.framework.BundleContext;

public class DSIObjectPushProvider
extends AbstractProvider
implements DSIObjectPush {
    private static final int[] attributeIDs = new int[]{1, 2};
    private DSIObjectPushProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$bluetooth$DSIObjectPush;

    public DSIObjectPushProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$bluetooth$DSIObjectPush == null ? (class$org$dsi$ifc$bluetooth$DSIObjectPush = DSIObjectPushProvider.class$("org.dsi.ifc.bluetooth.DSIObjectPush")) : class$org$dsi$ifc$bluetooth$DSIObjectPush).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIObjectPushProxy(this.instance, (DSIObjectPushReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestOPPAbortSending() {
        try {
            this.proxy.requestOPPAbortSending();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestOPPAcceptObject(String string, boolean bl) {
        try {
            this.proxy.requestOPPAcceptObject(string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestOPPSendContacts(String string, String string2) {
        try {
            this.proxy.requestOPPSendContacts(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestOPPSendMessages(String string, int[] nArray) {
        try {
            this.proxy.requestOPPSendMessages(string, nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestOPPSendBinary(String string, String[] stringArray) {
        try {
            this.proxy.requestOPPSendBinary(string, stringArray);
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

