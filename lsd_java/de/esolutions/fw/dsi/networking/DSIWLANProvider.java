/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.networking;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.networking.DSIWLANReply;
import de.esolutions.fw.comm.dsi.networking.impl.DSIWLANProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.networking.DSIWLAN;
import org.dsi.ifc.networking.Profile;
import org.osgi.framework.BundleContext;

public class DSIWLANProvider
extends AbstractProvider
implements DSIWLAN {
    private static final int[] attributeIDs = new int[]{1, 12, 13, 17, 18, 19, 20, 21, 22, 23, 24};
    private DSIWLANProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$networking$DSIWLAN;

    public DSIWLANProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$networking$DSIWLAN == null ? (class$org$dsi$ifc$networking$DSIWLAN = DSIWLANProvider.class$("org.dsi.ifc.networking.DSIWLAN")) : class$org$dsi$ifc$networking$DSIWLAN).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIWLANProxy(this.instance, (DSIWLANReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void factoryReset() {
        try {
            this.proxy.factoryReset();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRole(int n) {
        try {
            this.proxy.setRole(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRFActive(boolean bl) {
        try {
            this.proxy.setRFActive(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setProfile(Profile profile) {
        try {
            this.proxy.setProfile(profile);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestNetworkSearch(int n, int n2) {
        try {
            this.proxy.requestNetworkSearch(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAbortSearch() {
        try {
            this.proxy.requestAbortSearch();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestConnectNetwork(String string, String string2, String string3, int n) {
        try {
            this.proxy.requestConnectNetwork(string, string2, string3, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDisconnectNetwork(String string, String string2) {
        try {
            this.proxy.requestDisconnectNetwork(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDeleteTrustedNetwork(String string, String string2) {
        try {
            this.proxy.requestDeleteTrustedNetwork(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestActivateWps(int n, int n2, int n3) {
        try {
            this.proxy.requestActivateWps(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCancelWPS() {
        try {
            this.proxy.requestCancelWPS();
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

