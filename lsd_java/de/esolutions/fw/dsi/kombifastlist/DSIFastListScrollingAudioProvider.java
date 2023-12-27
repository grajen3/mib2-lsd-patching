/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombifastlist;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingAudioReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingAudioProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingAudio;
import org.dsi.ifc.kombifastlist.DataCommonList;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;
import org.dsi.ifc.kombifastlist.DataReceptionList;
import org.osgi.framework.BundleContext;

public class DSIFastListScrollingAudioProvider
extends AbstractProvider
implements DSIFastListScrollingAudio {
    private static final int[] attributeIDs = new int[0];
    private DSIFastListScrollingAudioProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio;

    public DSIFastListScrollingAudioProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio = DSIFastListScrollingAudioProvider.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingAudio")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingAudio).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIFastListScrollingAudioProxy(this.instance, (DSIFastListScrollingAudioReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void pushFunctionAvailabilityAudio(int n) {
        try {
            this.proxy.pushFunctionAvailabilityAudio(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushMOSTOperationStateAudio(int n) {
        try {
            this.proxy.pushMOSTOperationStateAudio(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseMediaBrowser(int n, int n2, int n3, int n4, int n5, int n6, int n7, long l, int n8, long l2, long l3, int n9, int n10, int n11) {
        try {
            this.proxy.responseMediaBrowser(n, n2, n3, n4, n5, n6, n7, l, n8, l2, l3, n9, n10, n11);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseMediaBrowserArray(long l, int n, DataMediaBrowser[] dataMediaBrowserArray) {
        try {
            this.proxy.responseMediaBrowserArray(l, n, dataMediaBrowserArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushCommonList(long l, int n, DataCommonList[] dataCommonListArray) {
        try {
            this.proxy.pushCommonList(l, n, dataCommonListArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushReceptionList(long l, int n, DataReceptionList[] dataReceptionListArray) {
        try {
            this.proxy.pushReceptionList(l, n, dataReceptionListArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushCurrentListSizeAudio(int n, int n2, int n3) {
        try {
            this.proxy.pushCurrentListSizeAudio(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseMediaBrowserJobs(long l, int n, int n2) {
        try {
            this.proxy.responseMediaBrowserJobs(l, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNotifyCommonListPush(boolean bl) {
        try {
            this.proxy.responseNotifyCommonListPush(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNotifyCurrentListSizeAudio(boolean bl) {
        try {
            this.proxy.responseNotifyCurrentListSizeAudio(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNotifyReceptionList(boolean bl) {
        try {
            this.proxy.responseNotifyReceptionList(bl);
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

