/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.komonavinfo;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.komonavinfo.DSIKOMONavInfoReply;
import de.esolutions.fw.comm.dsi.komonavinfo.impl.DSIKOMONavInfoProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.komonavinfo.DSIKOMONavInfo;
import org.osgi.framework.BundleContext;

public class DSIKOMONavInfoProvider
extends AbstractProvider
implements DSIKOMONavInfo {
    private static final int[] attributeIDs = new int[0];
    private DSIKOMONavInfoProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo;

    public DSIKOMONavInfoProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo == null ? (class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo = DSIKOMONavInfoProvider.class$("org.dsi.ifc.komonavinfo.DSIKOMONavInfo")) : class$org$dsi$ifc$komonavinfo$DSIKOMONavInfo).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIKOMONavInfoProxy(this.instance, (DSIKOMONavInfoReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setDistanceToNextManeuver(long l, int n, boolean bl) {
        try {
            this.proxy.setDistanceToNextManeuver(l, n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setETA(int n, short s, short s2, short s3, boolean bl, boolean bl2) {
        try {
            this.proxy.setETA(n, s, s2, s3, bl, bl2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCurrentStreet(String string) {
        try {
            this.proxy.setCurrentStreet(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTurnToStreet(String string, String string2) {
        try {
            this.proxy.setTurnToStreet(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCityName(String string) {
        try {
            this.proxy.setCityName(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setDistanceToDestination(long l, int n, boolean bl) {
        try {
            this.proxy.setDistanceToDestination(l, n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSemiDynRoute(boolean bl) {
        try {
            this.proxy.setSemiDynRoute(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTrafficOffset(int n, short s, short s2, short s3, boolean bl) {
        try {
            this.proxy.setTrafficOffset(n, s, s2, s3, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRTT(short s, short s2, boolean bl) {
        try {
            this.proxy.setRTT(s, s2, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRgSelect(int n) {
        try {
            this.proxy.setRgSelect(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCapabilities(boolean[] blArray) {
        try {
            this.proxy.setCapabilities(blArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapScale(int n, int n2, boolean[] blArray, int n3, int n4, int n5) {
        try {
            this.proxy.setMapScale(n, n2, blArray, n3, n4, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setMapScaleResult(int n, int n2, boolean[] blArray, int n3, int n4, boolean[] blArray2, boolean bl) {
        try {
            this.proxy.setMapScaleResult(n, n2, blArray, n3, n4, blArray2, bl);
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

