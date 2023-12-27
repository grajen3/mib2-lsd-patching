/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.keypanel;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.keypanel.DSIKeyPanelReply;
import de.esolutions.fw.comm.dsi.keypanel.impl.DSIKeyPanelProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.keypanel.DSIKeyPanel;
import org.osgi.framework.BundleContext;

public class DSIKeyPanelProvider
extends AbstractProvider
implements DSIKeyPanel {
    private static final int[] attributeIDs = new int[]{7, 9, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27};
    private DSIKeyPanelProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$keypanel$DSIKeyPanel;

    public DSIKeyPanelProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$keypanel$DSIKeyPanel == null ? (class$org$dsi$ifc$keypanel$DSIKeyPanel = DSIKeyPanelProvider.class$("org.dsi.ifc.keypanel.DSIKeyPanel")) : class$org$dsi$ifc$keypanel$DSIKeyPanel).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIKeyPanelProxy(this.instance, (DSIKeyPanelReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setIllumination(int n, int n2, int n3) {
        try {
            this.proxy.setIllumination(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setHapticFeedback(int n, int n2, int n3) {
        try {
            this.proxy.setHapticFeedback(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTMDisplayState(boolean bl) {
        try {
            this.proxy.setTMDisplayState(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRecognizerLanguage(int n, String string) {
        try {
            this.proxy.setRecognizerLanguage(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRecognizerLanguage2(int n, String string, int n2) {
        try {
            this.proxy.setRecognizerLanguage2(n, string, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setRecognizerMode(int n, int n2) {
        try {
            this.proxy.setRecognizerMode(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clearRecognizer(int n) {
        try {
            this.proxy.clearRecognizer(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setGenericSetting(int n, int n2, int n3) {
        try {
            this.proxy.setGenericSetting(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetDevice(int n) {
        try {
            this.proxy.resetDevice(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestGenericSetting(int n, int n2) {
        try {
            this.proxy.requestGenericSetting(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestLastKey(int n) {
        try {
            this.proxy.requestLastKey(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getVersionInfo(int n, int n2) {
        try {
            this.proxy.getVersionInfo(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setTouchSensitiveArea(int n, int n2, int n3, int n4, int n5) {
        try {
            this.proxy.setTouchSensitiveArea(n, n2, n3, n4, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getProperty(int n, int n2, int n3) {
        try {
            this.proxy.getProperty(n, n2, n3);
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

