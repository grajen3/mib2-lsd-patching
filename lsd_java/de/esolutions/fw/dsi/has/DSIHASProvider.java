/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.has;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.has.DSIHASReply;
import de.esolutions.fw.comm.dsi.has.impl.DSIHASProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.has.DSIHAS;
import org.dsi.ifc.has.HASDataContainer;
import org.osgi.framework.BundleContext;

public class DSIHASProvider
extends AbstractProvider
implements DSIHAS {
    private static final int[] attributeIDs = new int[0];
    private DSIHASProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$has$DSIHAS;

    public DSIHASProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$has$DSIHAS == null ? (class$org$dsi$ifc$has$DSIHAS = DSIHASProvider.class$("org.dsi.ifc.has.DSIHAS")) : class$org$dsi$ifc$has$DSIHAS).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIHASProxy(this.instance, (DSIHASReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
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
    public void actionResult(int n, int n2, HASDataContainer[] hASDataContainerArray, int n3) {
        try {
            this.proxy.actionResult(n, n2, hASDataContainerArray, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void propertyUpdate(int n, HASDataContainer[] hASDataContainerArray, int n2) {
        try {
            this.proxy.propertyUpdate(n, hASDataContainerArray, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void subscribeResult(int n, int n2) {
        try {
            this.proxy.subscribeResult(n, n2);
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

