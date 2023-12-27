/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.radiodata;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.radiodata.DSIRadioDataReply;
import de.esolutions.fw.comm.dsi.radiodata.impl.DSIRadioDataProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.DSIRadioData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;
import org.osgi.framework.BundleContext;

public class DSIRadioDataProvider
extends AbstractProvider
implements DSIRadioData {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4};
    private DSIRadioDataProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$DSIRadioData;

    public DSIRadioDataProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$radiodata$DSIRadioData == null ? (class$org$dsi$ifc$radiodata$DSIRadioData = DSIRadioDataProvider.class$("org.dsi.ifc.radiodata.DSIRadioData")) : class$org$dsi$ifc$radiodata$DSIRadioData).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIRadioDataProxy(this.instance, (DSIRadioDataReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestRadioStationData(RadioStationDataRequest[] radioStationDataRequestArray, int n) {
        try {
            this.proxy.requestRadioStationData(radioStationDataRequestArray, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestRadioStationLogos(RadioStationLogoRequest[] radioStationLogoRequestArray, int n) {
        try {
            this.proxy.requestRadioStationLogos(radioStationLogoRequestArray, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDynamicDatabaseAlteration(RadioStationData radioStationData, ResourceLocator resourceLocator, int n, int n2) {
        try {
            this.proxy.requestDynamicDatabaseAlteration(radioStationData, resourceLocator, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCountryListUpdate(int n) {
        try {
            this.proxy.requestCountryListUpdate(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDatabaseVersionInfo(int n) {
        try {
            this.proxy.requestDatabaseVersionInfo(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestPersistStationLogos(RadioStationData[] radioStationDataArray, ResourceLocator[] resourceLocatorArray, int n, int n2) {
        try {
            this.proxy.requestPersistStationLogos(radioStationDataArray, resourceLocatorArray, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCountryRegionData(int n) {
        try {
            this.proxy.requestCountryRegionData(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestCountryRegionTranslationData(int n, String string, int n2) {
        try {
            this.proxy.requestCountryRegionTranslationData(n, string, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileChange(int n) {
        try {
            this.proxy.profileChange(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileCopy(int n, int n2) {
        try {
            this.proxy.profileCopy(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileReset(int n) {
        try {
            this.proxy.profileReset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void profileResetAll() {
        try {
            this.proxy.profileResetAll();
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

