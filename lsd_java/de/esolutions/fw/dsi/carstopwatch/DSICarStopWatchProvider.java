/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carstopwatch;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carstopwatch.DSICarStopWatchReply;
import de.esolutions.fw.comm.dsi.carstopwatch.impl.DSICarStopWatchProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.carstopwatch.DSICarStopWatch;
import org.dsi.ifc.carstopwatch.StopWatchTime;
import org.osgi.framework.BundleContext;

public class DSICarStopWatchProvider
extends AbstractProvider
implements DSICarStopWatch {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7};
    private DSICarStopWatchProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$carstopwatch$DSICarStopWatch;

    public DSICarStopWatchProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$carstopwatch$DSICarStopWatch == null ? (class$org$dsi$ifc$carstopwatch$DSICarStopWatch = DSICarStopWatchProvider.class$("org.dsi.ifc.carstopwatch.DSICarStopWatch")) : class$org$dsi$ifc$carstopwatch$DSICarStopWatch).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarStopWatchProxy(this.instance, (DSICarStopWatchReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setStopWatchFastestLapTime(StopWatchTime stopWatchTime) {
        try {
            this.proxy.setStopWatchFastestLapTime(stopWatchTime);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setStopWatchLapRating(int n) {
        try {
            this.proxy.setStopWatchLapRating(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setStopWatchLapProgress(float f2) {
        try {
            this.proxy.setStopWatchLapProgress(f2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setStopWatchLapGPSTrigger() {
        try {
            this.proxy.setStopWatchLapGPSTrigger();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setStopWatchControl(int n) {
        try {
            this.proxy.setStopWatchControl(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setStopWatchSlowestLapTime(StopWatchTime stopWatchTime) {
        try {
            this.proxy.setStopWatchSlowestLapTime(stopWatchTime);
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

