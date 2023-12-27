/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tvtuner;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tvtuner.DSITVTunerReply;
import de.esolutions.fw.comm.dsi.tvtuner.impl.DSITVTunerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.tvtuner.DSITVTuner;
import org.osgi.framework.BundleContext;

public class DSITVTunerProvider
extends AbstractProvider
implements DSITVTuner {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22};
    private DSITVTunerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$tvtuner$DSITVTuner;

    public DSITVTunerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$tvtuner$DSITVTuner == null ? (class$org$dsi$ifc$tvtuner$DSITVTuner = DSITVTunerProvider.class$("org.dsi.ifc.tvtuner.DSITVTuner")) : class$org$dsi$ifc$tvtuner$DSITVTuner).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSITVTunerProxy(this.instance, (DSITVTunerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void selectService(long l, int n, int n2) {
        try {
            this.proxy.selectService(l, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void selectNextService(int n, int n2) {
        try {
            this.proxy.selectNextService(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void abortSeek() {
        try {
            this.proxy.abortSeek();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void switchSource(int n) {
        try {
            this.proxy.switchSource(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAudioChannel(int n) {
        try {
            this.proxy.setAudioChannel(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNormArea(int n) {
        try {
            this.proxy.setNormArea(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableServiceLinking(boolean bl) {
        try {
            this.proxy.enableServiceLinking(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTerminalMode(int n, int n2) {
        try {
            this.proxy.setTerminalMode(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setNormAreaSubList(int[] nArray) {
        try {
            this.proxy.setNormAreaSubList(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setAVNorm(int n) {
        try {
            this.proxy.setAVNorm(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void incMoved(byte by) {
        try {
            this.proxy.incMoved(by);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setCoordinateRel(short s, short s2, short s3) {
        try {
            this.proxy.setCoordinateRel(s, s2, s3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTMTVKeyPanel(short s, short s2) {
        try {
            this.proxy.setTMTVKeyPanel(s, s2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableSubtitle(boolean bl) {
        try {
            this.proxy.enableSubtitle(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrowserListSort(int n) {
        try {
            this.proxy.setBrowserListSort(n);
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

