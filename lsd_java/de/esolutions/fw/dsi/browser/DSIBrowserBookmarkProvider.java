/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.browser;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserBookmarkReply;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserBookmarkProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.browser.Bookmark;
import org.dsi.ifc.browser.DSIBrowserBookmark;
import org.dsi.ifc.browser.PathInfo;
import org.osgi.framework.BundleContext;

public class DSIBrowserBookmarkProvider
extends AbstractProvider
implements DSIBrowserBookmark {
    private static final int[] attributeIDs = new int[]{1, 2};
    private DSIBrowserBookmarkProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowserBookmark;

    public DSIBrowserBookmarkProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$browser$DSIBrowserBookmark == null ? (class$org$dsi$ifc$browser$DSIBrowserBookmark = DSIBrowserBookmarkProvider.class$("org.dsi.ifc.browser.DSIBrowserBookmark")) : class$org$dsi$ifc$browser$DSIBrowserBookmark).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIBrowserBookmarkProxy(this.instance, (DSIBrowserBookmarkReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void listBookmarks(String string) {
        try {
            this.proxy.listBookmarks(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void addBookmark(Bookmark bookmark) {
        try {
            this.proxy.addBookmark(bookmark);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void editBookmark(Bookmark bookmark, Bookmark bookmark2) {
        try {
            this.proxy.editBookmark(bookmark, bookmark2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteBookmark(Bookmark bookmark) {
        try {
            this.proxy.deleteBookmark(bookmark);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createFolder(Bookmark bookmark) {
        try {
            this.proxy.createFolder(bookmark);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteFolder(String string) {
        try {
            this.proxy.deleteFolder(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void renameFolder(String string, String string2) {
        try {
            this.proxy.renameFolder(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void exportBookmarks(PathInfo pathInfo) {
        try {
            this.proxy.exportBookmarks(pathInfo);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importBookmarks(PathInfo pathInfo, boolean bl, boolean bl2) {
        try {
            this.proxy.importBookmarks(pathInfo, bl, bl2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getQuotaInformation() {
        try {
            this.proxy.getQuotaInformation();
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

