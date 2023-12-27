/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.calendar;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.calendar.DSICalendarExchangeReply;
import de.esolutions.fw.comm.dsi.calendar.impl.DSICalendarExchangeProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.calendar.DSICalendarExchange;
import org.dsi.ifc.global.ResourceLocator;
import org.osgi.framework.BundleContext;

public class DSICalendarExchangeProvider
extends AbstractProvider
implements DSICalendarExchange {
    private static final int[] attributeIDs = new int[0];
    private DSICalendarExchangeProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$calendar$DSICalendarExchange;

    public DSICalendarExchangeProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$calendar$DSICalendarExchange == null ? (class$org$dsi$ifc$calendar$DSICalendarExchange = DSICalendarExchangeProvider.class$("org.dsi.ifc.calendar.DSICalendarExchange")) : class$org$dsi$ifc$calendar$DSICalendarExchange).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICalendarExchangeProxy(this.instance, (DSICalendarExchangeReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void parseICal(String string) {
        try {
            this.proxy.parseICal(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void parseICalDirectory(String string) {
        try {
            this.proxy.parseICalDirectory(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void exportICal(int n, int n2, long[] lArray, int n3) {
        try {
            this.proxy.exportICal(n, n2, lArray, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importICal(ResourceLocator[] resourceLocatorArray) {
        try {
            this.proxy.importICal(resourceLocatorArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortExport() {
        try {
            this.proxy.abortExport();
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

