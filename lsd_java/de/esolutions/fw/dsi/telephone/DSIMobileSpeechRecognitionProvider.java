/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.telephone;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephone.DSIMobileSpeechRecognitionReply;
import de.esolutions.fw.comm.dsi.telephone.impl.DSIMobileSpeechRecognitionProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.telephone.DSIMobileSpeechRecognition;
import org.osgi.framework.BundleContext;

public class DSIMobileSpeechRecognitionProvider
extends AbstractProvider
implements DSIMobileSpeechRecognition {
    private static final int[] attributeIDs = new int[]{1, 2, 3};
    private DSIMobileSpeechRecognitionProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition;

    public DSIMobileSpeechRecognitionProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition == null ? (class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition = DSIMobileSpeechRecognitionProvider.class$("org.dsi.ifc.telephone.DSIMobileSpeechRecognition")) : class$org$dsi$ifc$telephone$DSIMobileSpeechRecognition).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMobileSpeechRecognitionProxy(this.instance, (DSIMobileSpeechRecognitionReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestStartSpeechRecognition() {
        try {
            this.proxy.requestStartSpeechRecognition();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestStopSpeechRecognition() {
        try {
            this.proxy.requestStopSpeechRecognition();
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

