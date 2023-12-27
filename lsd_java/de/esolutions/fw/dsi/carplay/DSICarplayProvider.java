/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.carplay;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carplay.DSICarplayReply;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.DSICarplay;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;
import org.osgi.framework.BundleContext;

public class DSICarplayProvider
extends AbstractProvider
implements DSICarplay {
    private static final int[] attributeIDs = new int[]{2, 3, 4, 5, 6, 7, 8, 9, 10, 12};
    private DSICarplayProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$carplay$DSICarplay;

    public DSICarplayProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$carplay$DSICarplay == null ? (class$org$dsi$ifc$carplay$DSICarplay = DSICarplayProvider.class$("org.dsi.ifc.carplay.DSICarplay")) : class$org$dsi$ifc$carplay$DSICarplay).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSICarplayProxy(this.instance, (DSICarplayReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        try {
            this.proxy.startService(serviceConfiguration);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void postButtonEvent(int n, int n2) {
        try {
            this.proxy.postButtonEvent(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
        try {
            this.proxy.postTouchEvent(n, n2, touchEventArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void postRotaryEvent(int n) {
        try {
            this.proxy.postRotaryEvent(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void postCharacterEvent(int n, String[] stringArray) {
        try {
            this.proxy.postCharacterEvent(n, stringArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
        try {
            this.proxy.requestModeChange(resourceRequestArray, appStateRequestArray, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
        try {
            this.proxy.responseUpdateMode(resourceArray, appStateArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseBTDeactivation() {
        try {
            this.proxy.responseBTDeactivation();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestUI(int n) {
        try {
            this.proxy.requestUI(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestNightMode(boolean bl) {
        try {
            this.proxy.requestNightMode(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSIRIAction(int n) {
        try {
            this.proxy.requestSIRIAction(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseUpdateMainAudioType(int n) {
        try {
            this.proxy.responseUpdateMainAudioType(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestUI2(String string) {
        try {
            this.proxy.requestUI2(string);
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

