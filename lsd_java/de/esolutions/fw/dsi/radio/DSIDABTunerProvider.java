/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.radio;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.radio.DSIDABTunerReply;
import de.esolutions.fw.comm.dsi.radio.impl.DSIDABTunerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.radio.DSIDABTuner;
import org.osgi.framework.BundleContext;

public class DSIDABTunerProvider
extends AbstractProvider
implements DSIDABTuner {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 19, 20, 21, 22, 24, 25, 27, 28, 29, 30, 31, 32, 33, 34, 35};
    private DSIDABTunerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$radio$DSIDABTuner;

    public DSIDABTunerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$radio$DSIDABTuner == null ? (class$org$dsi$ifc$radio$DSIDABTuner = DSIDABTunerProvider.class$("org.dsi.ifc.radio.DSIDABTuner")) : class$org$dsi$ifc$radio$DSIDABTuner).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIDABTunerProxy(this.instance, (DSIDABTunerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void selectService(int n, long l, int n2, int n3, int n4, int n5, long l2) {
        try {
            this.proxy.selectService(n, l, n2, n3, n4, n5, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void seekService(int n) {
        try {
            this.proxy.seekService(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void tuneEnsemble(int n, int n2, int n3, long l) {
        try {
            this.proxy.tuneEnsemble(n, n2, n3, l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void selectDataService(int n, int n2, long l, int n3) {
        try {
            this.proxy.selectDataService(n, n2, l, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void switchDRC(boolean bl) {
        try {
            this.proxy.switchDRC(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void switchLinking(int n) {
        try {
            this.proxy.switchLinking(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void switchLinkingDeviceUsage(int n) {
        try {
            this.proxy.switchLinkingDeviceUsage(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void switchFrequencyTable(int n) {
        try {
            this.proxy.switchFrequencyTable(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void reset(int n) {
        try {
            this.proxy.reset(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void forceLMUpdate(int n) {
        try {
            this.proxy.forceLMUpdate(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void prepareTuning(int n, long l, int n2, int n3, int n4, int n5) {
        try {
            this.proxy.prepareTuning(n, l, n2, n3, n4, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableRadioTextPlus(int[] nArray) {
        try {
            this.proxy.enableRadioTextPlus(nArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setEpgMode(int n) {
        try {
            this.proxy.setEpgMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSlideShowMode(int n) {
        try {
            this.proxy.setSlideShowMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setIntellitextMode(int n) {
        try {
            this.proxy.setIntellitextMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getEPGDetailData(int n, int n2, long l, int n3) {
        try {
            this.proxy.getEPGDetailData(n, n2, l, n3);
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

