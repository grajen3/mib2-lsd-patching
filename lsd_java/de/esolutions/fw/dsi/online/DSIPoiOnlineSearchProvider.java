/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.online;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.online.DSIPoiOnlineSearchReply;
import de.esolutions.fw.comm.dsi.online.impl.DSIPoiOnlineSearchProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.online.DSIPoiOnlineSearch;
import org.dsi.ifc.online.PoiOnlineSearchValuelistElement;
import org.osgi.framework.BundleContext;

public class DSIPoiOnlineSearchProvider
extends AbstractProvider
implements DSIPoiOnlineSearch {
    private static final int[] attributeIDs = new int[0];
    private DSIPoiOnlineSearchProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$online$DSIPoiOnlineSearch;

    public DSIPoiOnlineSearchProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$online$DSIPoiOnlineSearch == null ? (class$org$dsi$ifc$online$DSIPoiOnlineSearch = DSIPoiOnlineSearchProvider.class$("org.dsi.ifc.online.DSIPoiOnlineSearch")) : class$org$dsi$ifc$online$DSIPoiOnlineSearch).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIPoiOnlineSearchProxy(this.instance, (DSIPoiOnlineSearchReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void poiStartSelectionZoom(String string, int n, int n2, int n3, int n4, int n5) {
        try {
            this.proxy.poiStartSelectionZoom(string, n, n2, n3, n4, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dynamicPoiStartSelectionZoom(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        try {
            this.proxy.dynamicPoiStartSelectionZoom(n, n2, n3, n4, n5, n6, n7);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiStartSelection(String string, int n, int n2, int n3, int n4) {
        try {
            this.proxy.poiStartSelection(string, n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void dynamicPoiStartSelection(int n, int n2, int n3, int n4, int n5, int n6) {
        try {
            this.proxy.dynamicPoiStartSelection(n, n2, n3, n4, n5, n6);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiStopSelection() {
        try {
            this.proxy.poiStopSelection();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiRequestValueList(int n, int n2) {
        try {
            this.proxy.poiRequestValueList(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiStartVoiceSelection(int n, int n2, int n3, int n4, boolean bl, int n5) {
        try {
            this.proxy.poiStartVoiceSelection(n, n2, n3, n4, bl, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiRawVoiceDataAvailable(String string, int n) {
        try {
            this.proxy.poiRawVoiceDataAvailable(string, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiRequestSpellingSuggestion() {
        try {
            this.proxy.poiRequestSpellingSuggestion();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void usedPoi(PoiOnlineSearchValuelistElement poiOnlineSearchValuelistElement, int n) {
        try {
            this.proxy.usedPoi(poiOnlineSearchValuelistElement, n);
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
    public void setFallbackLanguage(String string) {
        try {
            this.proxy.setFallbackLanguage(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void poiVoiceSearchActive() {
        try {
            this.proxy.poiVoiceSearchActive();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void precheckDynamicPOICategory(int n) {
        try {
            this.proxy.precheckDynamicPOICategory(n);
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

