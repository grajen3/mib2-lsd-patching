/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.iconhandling;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.iconhandling.DSIIconExtractorReply;
import de.esolutions.fw.comm.dsi.iconhandling.impl.DSIIconExtractorProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.iconhandling.DSIIconExtractor;
import org.osgi.framework.BundleContext;

public class DSIIconExtractorProvider
extends AbstractProvider
implements DSIIconExtractor {
    private static final int[] attributeIDs = new int[0];
    private DSIIconExtractorProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$iconhandling$DSIIconExtractor;

    public DSIIconExtractorProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$iconhandling$DSIIconExtractor == null ? (class$org$dsi$ifc$iconhandling$DSIIconExtractor = DSIIconExtractorProvider.class$("org.dsi.ifc.iconhandling.DSIIconExtractor")) : class$org$dsi$ifc$iconhandling$DSIIconExtractor).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIIconExtractorProxy(this.instance, (DSIIconExtractorReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void resourceIdForTMCEventIcon(int n, int n2, int n3) {
        try {
            this.proxy.resourceIdForTMCEventIcon(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForPOIIcon(int n, int n2, int n3) {
        try {
            this.proxy.resourceIdForPOIIcon(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void renderingInformationForRoadIcon(int n, int n2, int n3) {
        try {
            this.proxy.renderingInformationForRoadIcon(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForTargetIcon(int n, int n2) {
        try {
            this.proxy.resourceIdForTargetIcon(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForRoadClassIcon(int n, int n2, int n3) {
        try {
            this.proxy.resourceIdForRoadClassIcon(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForTrafficRegulationIcon(int n, int n2, int n3) {
        try {
            this.proxy.resourceIdForTrafficRegulationIcon(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void renderingInformationForExitIcon(int n, int n2, int n3) {
        try {
            this.proxy.renderingInformationForExitIcon(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForAdditionalIcon(int n, int n2, int n3) {
        try {
            this.proxy.resourceIdForAdditionalIcon(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForCountryIcon(int n, int n2) {
        try {
            this.proxy.resourceIdForCountryIcon(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForTrafficRegulationIconWithSubindex(int n, int n2, int n3, int n4) {
        try {
            this.proxy.resourceIdForTrafficRegulationIconWithSubindex(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void renderingInformationForExitIconWithVariant(int n, int n2, int n3, int n4) {
        try {
            this.proxy.renderingInformationForExitIconWithVariant(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrandIconStyle(int[] nArray, int n) {
        try {
            this.proxy.setBrandIconStyle(nArray, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForAdditionalTurnListIcon(int n, int n2, int n3, int n4) {
        try {
            this.proxy.resourceIdForAdditionalTurnListIcon(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForTrafficSourceIcon(int n, int n2) {
        try {
            this.proxy.resourceIdForTrafficSourceIcon(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForAreaWarningIcon(int n, int n2) {
        try {
            this.proxy.resourceIdForAreaWarningIcon(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForComposedPOIIcon(int n, int n2, int n3, int[] nArray) {
        try {
            this.proxy.resourceIdForComposedPOIIcon(n, n2, n3, nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resourceIdForPOIIconFromRawData(int n, int n2, int n3) {
        try {
            this.proxy.resourceIdForPOIIconFromRawData(n, n2, n3);
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

