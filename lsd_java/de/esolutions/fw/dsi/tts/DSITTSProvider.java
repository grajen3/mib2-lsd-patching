/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.tts;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tts.DSITTSReply;
import de.esolutions.fw.comm.dsi.tts.impl.DSITTSProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.tts.DSITTS;
import org.dsi.ifc.tts.TTSPrompt;
import org.osgi.framework.BundleContext;

public class DSITTSProvider
extends AbstractProvider
implements DSITTS {
    private static final int[] attributeIDs = new int[]{2, 7, 9, 10};
    private DSITTSProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$tts$DSITTS;

    public DSITTSProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$tts$DSITTS == null ? (class$org$dsi$ifc$tts$DSITTS = DSITTSProvider.class$("org.dsi.ifc.tts.DSITTS")) : class$org$dsi$ifc$tts$DSITTS).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSITTSProxy(this.instance, (DSITTSReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void speakPrompt(short s, TTSPrompt tTSPrompt) {
        try {
            this.proxy.speakPrompt(s, tTSPrompt);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLanguage(short s, String string, int n, int n2, int n3) {
        try {
            this.proxy.setLanguage(s, string, n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void init(short s) {
        try {
            this.proxy.init(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAudioTrigger(short s, int n) {
        try {
            this.proxy.requestAudioTrigger(s, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestPlayTone(short s, int n) {
        try {
            this.proxy.requestPlayTone(s, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSkipSpeaking(short s, int n, int n2) {
        try {
            this.proxy.requestSkipSpeaking(s, n, n2);
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

