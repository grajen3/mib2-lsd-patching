/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.browser;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.browser.DSIBrowserReply;
import de.esolutions.fw.comm.dsi.browser.impl.DSIBrowserProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.browser.DSIBrowser;
import org.dsi.ifc.browser.TimePeriod;
import org.osgi.framework.BundleContext;

public class DSIBrowserProvider
extends AbstractProvider
implements DSIBrowser {
    private static final int[] attributeIDs = new int[]{1, 2, 3, 4, 7, 10, 12, 13, 14, 15, 16, 17, 18};
    private DSIBrowserProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$browser$DSIBrowser;

    public DSIBrowserProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$browser$DSIBrowser == null ? (class$org$dsi$ifc$browser$DSIBrowser = DSIBrowserProvider.class$("org.dsi.ifc.browser.DSIBrowser")) : class$org$dsi$ifc$browser$DSIBrowser).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIBrowserProxy(this.instance, (DSIBrowserReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void cancelLoading() {
        try {
            this.proxy.cancelLoading();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void followLink(boolean bl) {
        try {
            this.proxy.followLink(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getPreference(int n) {
        try {
            this.proxy.getPreference(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void goBack() {
        try {
            this.proxy.goBack();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void goForward() {
        try {
            this.proxy.goForward();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void gotoHomeUrl() {
        try {
            this.proxy.gotoHomeUrl();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void loadUrl(String string) {
        try {
            this.proxy.loadUrl(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void nextFocus(int n) {
        try {
            this.proxy.nextFocus(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void previousFocus(int n) {
        try {
            this.proxy.previousFocus(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void scroll(int n, int n2) {
        try {
            this.proxy.scroll(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void reloadUrl() {
        try {
            this.proxy.reloadUrl();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setPreference(int n, int n2, String string) {
        try {
            this.proxy.setPreference(n, n2, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stopBrowser() {
        try {
            this.proxy.stopBrowser();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void zoom(int n, boolean bl) {
        try {
            this.proxy.zoom(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void suspendBrowser() {
        try {
            this.proxy.suspendBrowser();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resumeBrowser() {
        try {
            this.proxy.resumeBrowser();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setLanguage(String string) {
        try {
            this.proxy.setLanguage(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteCookies() {
        try {
            this.proxy.deleteCookies();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteHistory() {
        try {
            this.proxy.deleteHistory();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deletePasswords() {
        try {
            this.proxy.deletePasswords();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteCache() {
        try {
            this.proxy.deleteCache();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void downloadFile(String string, String string2) {
        try {
            this.proxy.downloadFile(string, string2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void enterImageSelectionMode() {
        try {
            this.proxy.enterImageSelectionMode();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void clickOnPosition(int n, int n2, boolean bl) {
        try {
            this.proxy.clickOnPosition(n, n2, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void javaScriptAlertAck() {
        try {
            this.proxy.javaScriptAlertAck();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void javaScriptConfirmAck(boolean bl) {
        try {
            this.proxy.javaScriptConfirmAck(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void javaScriptPromptAck(String string, boolean bl) {
        try {
            this.proxy.javaScriptPromptAck(string, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void bringToFront() {
        try {
            this.proxy.bringToFront();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void keyboardInput(String string) {
        try {
            this.proxy.keyboardInput(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSelection(int n, boolean bl) {
        try {
            this.proxy.setSelection(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetToFactoryDefaults() {
        try {
            this.proxy.resetToFactoryDefaults();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void exportBrowserData(String string) {
        try {
            this.proxy.exportBrowserData(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importBrowserData(String string) {
        try {
            this.proxy.importBrowserData(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getHistory(TimePeriod timePeriod) {
        try {
            this.proxy.getHistory(timePeriod);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void executeJavaScript(String string) {
        try {
            this.proxy.executeJavaScript(string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void touchScroll(int n, int n2) {
        try {
            this.proxy.touchScroll(n, n2);
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

