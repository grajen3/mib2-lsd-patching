/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.waveplayer;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.waveplayer.DSIWavePlayerReply;
import de.esolutions.fw.comm.dsi.waveplayer.impl.DSIWavePlayerProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.waveplayer.DSIWavePlayer;
import org.osgi.framework.BundleContext;

public class DSIWavePlayerProvider
extends AbstractProvider
implements DSIWavePlayer {
    private static final int[] attributeIDs = new int[]{1, 2};
    private DSIWavePlayerProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$waveplayer$DSIWavePlayer;

    public DSIWavePlayerProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$waveplayer$DSIWavePlayer == null ? (class$org$dsi$ifc$waveplayer$DSIWavePlayer = DSIWavePlayerProvider.class$("org.dsi.ifc.waveplayer.DSIWavePlayer")) : class$org$dsi$ifc$waveplayer$DSIWavePlayer).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIWavePlayerProxy(this.instance, (DSIWavePlayerReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void audioTrigger(int n) {
        try {
            this.proxy.audioTrigger(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void audioTriggerDefaultTone(int n) {
        try {
            this.proxy.audioTriggerDefaultTone(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPlayTone(int n) {
        try {
            this.proxy.setPlayTone(n);
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

