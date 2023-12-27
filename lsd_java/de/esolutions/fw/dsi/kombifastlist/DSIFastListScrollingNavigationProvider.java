/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombifastlist;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingNavigationReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingNavigationProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation;
import org.dsi.ifc.kombifastlist.DataAddress;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.osgi.framework.BundleContext;

public class DSIFastListScrollingNavigationProvider
extends AbstractProvider
implements DSIFastListScrollingNavigation {
    private static final int[] attributeIDs = new int[0];
    private DSIFastListScrollingNavigationProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigation;

    public DSIFastListScrollingNavigationProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigation == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigation = DSIFastListScrollingNavigationProvider.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingNavigation")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingNavigation).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIFastListScrollingNavigationProxy(this.instance, (DSIFastListScrollingNavigationReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void pushFunctionAvailabilityNavigation(int n) {
        try {
            this.proxy.pushFunctionAvailabilityNavigation(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushMOSTOperationStateNavigation(int n) {
        try {
            this.proxy.pushMOSTOperationStateNavigation(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNavBook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        try {
            this.proxy.responseNavBook(n, n2, n3, n4, n5, l, n6, n7, n8, n9, n10, n11, n12);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNavBookArray(int n, int n2, DataAddress[] dataAddressArray) {
        try {
            this.proxy.responseNavBookArray(n, n2, dataAddressArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseGetInitialsNavigation(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
        try {
            this.proxy.responseGetInitialsNavigation(n, n2, n3, n4, dataInitialsArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushLastDestList(int n, int n2, DataAddress[] dataAddressArray) {
        try {
            this.proxy.pushLastDestList(n, n2, dataAddressArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushUpdateFavoriteDestList(int n, int n2, DataAddress[] dataAddressArray) {
        try {
            this.proxy.pushUpdateFavoriteDestList(n, n2, dataAddressArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushCurrentListSizeNavigation(int n, int n2, int n3) {
        try {
            this.proxy.pushCurrentListSizeNavigation(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNavBookJobs(int n, int n2, int n3) {
        try {
            this.proxy.responseNavBookJobs(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNotifyCurrentListSizesNavigation(boolean bl) {
        try {
            this.proxy.responseNotifyCurrentListSizesNavigation(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNotifyFavoriteDestList(boolean bl) {
        try {
            this.proxy.responseNotifyFavoriteDestList(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNotifyLastDestList(boolean bl) {
        try {
            this.proxy.responseNotifyLastDestList(bl);
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

