/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.kombifastlist;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingTelephoneReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;
import org.osgi.framework.BundleContext;

public class DSIFastListScrollingTelephoneProvider
extends AbstractProvider
implements DSIFastListScrollingTelephone {
    private static final int[] attributeIDs = new int[0];
    private DSIFastListScrollingTelephoneProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephone;

    public DSIFastListScrollingTelephoneProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephone == null ? (class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephone = DSIFastListScrollingTelephoneProvider.class$("org.dsi.ifc.kombifastlist.DSIFastListScrollingTelephone")) : class$org$dsi$ifc$kombifastlist$DSIFastListScrollingTelephone).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIFastListScrollingTelephoneProxy(this.instance, (DSIFastListScrollingTelephoneReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void pushFunctionAvailabilityTelephone(int n) {
        try {
            this.proxy.pushFunctionAvailabilityTelephone(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushMOSTOperationStateTelephone(short s) {
        try {
            this.proxy.pushMOSTOperationStateTelephone(s);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responsePhonebook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        try {
            this.proxy.responsePhonebook(n, n2, n3, n4, n5, l, n6, n7, n8, n9, n10, n11, n12);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responsePhonebookArray(int n, int n2, DataPhonebook[] dataPhonebookArray) {
        try {
            this.proxy.responsePhonebookArray(n, n2, dataPhonebookArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseGetInitialsTelephone(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
        try {
            this.proxy.responseGetInitialsTelephone(n, n2, n3, n4, dataInitialsArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushupdateFavoriteList(int n, int n2, DataFavoriteList[] dataFavoriteListArray) {
        try {
            this.proxy.pushupdateFavoriteList(n, n2, dataFavoriteListArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushCombinedNumbers(int n, int n2, DataCombinedNumbers[] dataCombinedNumbersArray) {
        try {
            this.proxy.pushCombinedNumbers(n, n2, dataCombinedNumbersArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pushCurrentListSizeTelephone(int n, int n2, int n3) {
        try {
            this.proxy.pushCurrentListSizeTelephone(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responsePhonebookJobs(int n, int n2, int n3) {
        try {
            this.proxy.responsePhonebookJobs(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNotifyCombinedNumbersPush(boolean bl) {
        try {
            this.proxy.responseNotifyCombinedNumbersPush(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNotifyCurrentListSizes(boolean bl) {
        try {
            this.proxy.responseNotifyCurrentListSizes(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void responseNotifyFavoriteListPush(boolean bl) {
        try {
            this.proxy.responseNotifyFavoriteListPush(bl);
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

