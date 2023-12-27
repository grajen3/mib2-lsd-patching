/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.mirrorlink;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.mirrorlink.DSIMirrorLinkReply;
import de.esolutions.fw.comm.dsi.mirrorlink.impl.DSIMirrorLinkProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.mirrorlink.ClientCapabilities;
import org.dsi.ifc.mirrorlink.DSIMirrorLink;
import org.dsi.ifc.mirrorlink.Event;
import org.osgi.framework.BundleContext;

public class DSIMirrorLinkProvider
extends AbstractProvider
implements DSIMirrorLink {
    private static final int[] attributeIDs = new int[]{1, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
    private DSIMirrorLinkProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$mirrorlink$DSIMirrorLink;

    public DSIMirrorLinkProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$mirrorlink$DSIMirrorLink == null ? (class$org$dsi$ifc$mirrorlink$DSIMirrorLink = DSIMirrorLinkProvider.class$("org.dsi.ifc.mirrorlink.DSIMirrorLink")) : class$org$dsi$ifc$mirrorlink$DSIMirrorLink).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMirrorLinkProxy(this.instance, (DSIMirrorLinkReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void requestClientCapabilities(ClientCapabilities clientCapabilities) {
        try {
            this.proxy.requestClientCapabilities(clientCapabilities);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAccessMode(int n) {
        try {
            this.proxy.requestAccessMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDayNightMode(int n) {
        try {
            this.proxy.requestDayNightMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestUsableViewport(int n, int n2, int n3, int n4) {
        try {
            this.proxy.requestUsableViewport(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestContextVisible(boolean bl) {
        try {
            this.proxy.requestContextVisible(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestConnectDevice(int n) {
        try {
            this.proxy.requestConnectDevice(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDisconnectDevice(int n) {
        try {
            this.proxy.requestDisconnectDevice(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestRotateScreen(int n) {
        try {
            this.proxy.requestRotateScreen(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestChangeOrientation(int n) {
        try {
            this.proxy.requestChangeOrientation(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSoftKeyEvent(int n, int n2) {
        try {
            this.proxy.requestSoftKeyEvent(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestLaunchApp(int n) {
        try {
            this.proxy.requestLaunchApp(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestTerminateApp(int n) {
        try {
            this.proxy.requestTerminateApp(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestStartSpeller(String string) {
        try {
            this.proxy.requestStartSpeller(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAddSpellerChars(String string) {
        try {
            this.proxy.requestAddSpellerChars(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestRemoveSpellerChar() {
        try {
            this.proxy.requestRemoveSpellerChar();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestClearSpeller() {
        try {
            this.proxy.requestClearSpeller();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSendString(String string) {
        try {
            this.proxy.requestSendString(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAudioOption(int n) {
        try {
            this.proxy.requestAudioOption(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAudioConnectionAudible(int n, boolean bl) {
        try {
            this.proxy.requestAudioConnectionAudible(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSendTouchEvents(Event[] eventArray, int n) {
        try {
            this.proxy.requestSendTouchEvents(eventArray, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestKeyboardMode(int n) {
        try {
            this.proxy.requestKeyboardMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestAvailableApplicationsWindow(int n, int n2) {
        try {
            this.proxy.requestAvailableApplicationsWindow(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDisplayKeyboard() {
        try {
            this.proxy.requestDisplayKeyboard();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestDismissHMIKeyboard() {
        try {
            this.proxy.requestDismissHMIKeyboard();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestFactorySettings() {
        try {
            this.proxy.requestFactorySettings();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestPhoneView() {
        try {
            this.proxy.requestPhoneView();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestContextSwitched(boolean bl) {
        try {
            this.proxy.requestContextSwitched(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void invokeNotiAction(int n, int n2) {
        try {
            this.proxy.invokeNotiAction(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestNotificationServiceEnabled(boolean bl, int n, int n2, int n3, int n4) {
        try {
            this.proxy.requestNotificationServiceEnabled(bl, n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestLocationDataServicesEnabled(boolean bl) {
        try {
            this.proxy.requestLocationDataServicesEnabled(bl);
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

