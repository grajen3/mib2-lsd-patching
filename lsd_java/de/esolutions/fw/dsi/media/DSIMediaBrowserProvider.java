/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.media;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMediaBrowserReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIMediaBrowserProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.media.DSIMediaBrowser;
import org.dsi.ifc.media.ListEntry;
import org.osgi.framework.BundleContext;

public class DSIMediaBrowserProvider
extends AbstractProvider
implements DSIMediaBrowser {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
    private DSIMediaBrowserProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$media$DSIMediaBrowser;

    public DSIMediaBrowserProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$media$DSIMediaBrowser == null ? (class$org$dsi$ifc$media$DSIMediaBrowser = DSIMediaBrowserProvider.class$("org.dsi.ifc.media.DSIMediaBrowser")) : class$org$dsi$ifc$media$DSIMediaBrowser).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIMediaBrowserProxy(this.instance, (DSIMediaBrowserReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setContentFilter(int n) {
        try {
            this.proxy.setContentFilter(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrowseMode(int n) {
        try {
            this.proxy.setBrowseMode(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setBrowseMedia(long l, long l2) {
        try {
            this.proxy.setBrowseMedia(l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void changeFolder(ListEntry[] listEntryArray) {
        try {
            this.proxy.changeFolder(listEntryArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestList(long l, int n, int n2, int n3) {
        try {
            this.proxy.requestList(l, n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestPickList(long[] lArray) {
        try {
            this.proxy.requestPickList(lArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enableRecurseSubdirectories(boolean bl) {
        try {
            this.proxy.enableRecurseSubdirectories(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void addSelection(boolean bl, int n, long l, int n2, boolean bl2) {
        try {
            this.proxy.addSelection(bl, n, l, n2, bl2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void undoLastSelection() {
        try {
            this.proxy.undoLastSelection();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetSelection() {
        try {
            this.proxy.resetSelection();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSearchString(String string) {
        try {
            this.proxy.setSearchString(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSearchCriteria(int n) {
        try {
            this.proxy.setSearchCriteria(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void activateSearchSpeller() {
        try {
            this.proxy.activateSearchSpeller();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deactivateSearchSpeller() {
        try {
            this.proxy.deactivateSearchSpeller();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void selectSearchResult(long l) {
        try {
            this.proxy.selectSearchResult(l);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSearchList(long l, int n, int n2) {
        try {
            this.proxy.requestSearchList(l, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetSearchString() {
        try {
            this.proxy.resetSearchString();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestSearchListExt(long l, int n, int n2) {
        try {
            this.proxy.requestSearchListExt(l, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void requestFullyQualifiedName(long l) {
        try {
            this.proxy.requestFullyQualifiedName(l);
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

