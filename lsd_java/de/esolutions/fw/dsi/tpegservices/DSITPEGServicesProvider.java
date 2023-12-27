/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tpegservices;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tpegservices.DSITPEGServicesReply;
import de.esolutions.fw.comm.dsi.tpegservices.impl.DSITPEGServicesProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.tpegservices.DSITPEGServices;
import org.osgi.framework.BundleContext;

public class DSITPEGServicesProvider
extends AbstractProvider
implements DSITPEGServices {
    private static final int[] attributeIDs = new int[]{1, 2};
    private DSITPEGServicesProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$tpegservices$DSITPEGServices;

    public DSITPEGServicesProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$tpegservices$DSITPEGServices == null ? (class$org$dsi$ifc$tpegservices$DSITPEGServices = DSITPEGServicesProvider.class$("org.dsi.ifc.tpegservices.DSITPEGServices")) : class$org$dsi$ifc$tpegservices$DSITPEGServices).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSITPEGServicesProxy(this.instance, (DSITPEGServicesReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestSimpleMapList(int n, int n2) {
        try {
            this.proxy.requestSimpleMapList(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void addSimpleMapBookmark(int n) {
        try {
            this.proxy.addSimpleMapBookmark(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteSimpleMapBookmark(int n) {
        try {
            this.proxy.deleteSimpleMapBookmark(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteAllSimpleMapBookmarks() {
        try {
            this.proxy.deleteAllSimpleMapBookmarks();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestLocationDetails(int n) {
        try {
            this.proxy.requestLocationDetails(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestFuelPriceInformation(int n, int n2) {
        try {
            this.proxy.requestFuelPriceInformation(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSortedFuelPriceInformation(int n, int n2, int n3) {
        try {
            this.proxy.requestSortedFuelPriceInformation(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestNewsInformation(int n) {
        try {
            this.proxy.requestNewsInformation(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestResourceInformation(int n) {
        try {
            this.proxy.requestResourceInformation(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLanguage(String string) {
        try {
            this.proxy.setLanguage(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestWeatherInfo(NavLocation navLocation, int n, int n2) {
        try {
            this.proxy.requestWeatherInfo(navLocation, n, n2);
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

