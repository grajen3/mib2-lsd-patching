/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.sdars;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.sdars.DSISDARSTunerReply;
import de.esolutions.fw.comm.dsi.sdars.impl.DSISDARSTunerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.sdars.DSISDARSTuner;
import org.osgi.framework.BundleContext;

public class DSISDARSTunerProvider
extends AbstractProvider
implements DSISDARSTuner {
    private static final int[] attributeIDs = new int[]{2, 6, 7, 8, 9, 10, 12, 13, 26, 27, 28, 30};
    private DSISDARSTunerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$sdars$DSISDARSTuner;

    public DSISDARSTunerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$sdars$DSISDARSTuner == null ? (class$org$dsi$ifc$sdars$DSISDARSTuner = DSISDARSTunerProvider.class$("org.dsi.ifc.sdars.DSISDARSTuner")) : class$org$dsi$ifc$sdars$DSISDARSTuner).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSISDARSTunerProxy(this.instance, (DSISDARSTunerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void selectStation(int n, int n2) {
        try {
            this.proxy.selectStation(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getTime() {
        try {
            this.proxy.getTime();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getEPG24Hour(int n) {
        try {
            this.proxy.getEPG24Hour(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getEPGDescription(int n, int n2) {
        try {
            this.proxy.getEPGDescription(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void notifyHMIReady(int n) {
        try {
            this.proxy.notifyHMIReady(n);
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
    public void setRadioText2Config(int n, int n2) {
        try {
            this.proxy.setRadioText2Config(n, n2);
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

