/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.filebrowser;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.filebrowser.DSIFileBrowserReply;
import de.esolutions.fw.comm.dsi.filebrowser.impl.DSIFileBrowserProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.filebrowser.BrowsedFile;
import org.dsi.ifc.filebrowser.BrowsedFileSet;
import org.dsi.ifc.filebrowser.DSIFileBrowser;
import org.dsi.ifc.filebrowser.Path;
import org.dsi.ifc.global.ResourceLocator;
import org.osgi.framework.BundleContext;

public class DSIFileBrowserProvider
extends AbstractProvider
implements DSIFileBrowser {
    private static final int[] attributeIDs = new int[0];
    private DSIFileBrowserProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$filebrowser$DSIFileBrowser;

    public DSIFileBrowserProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$filebrowser$DSIFileBrowser == null ? (class$org$dsi$ifc$filebrowser$DSIFileBrowser = DSIFileBrowserProvider.class$("org.dsi.ifc.filebrowser.DSIFileBrowser")) : class$org$dsi$ifc$filebrowser$DSIFileBrowser).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIFileBrowserProxy(this.instance, (DSIFileBrowserReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void start(Path path) {
        try {
            this.proxy.start(path);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFileExtensionFilter(int n, String[] stringArray) {
        try {
            this.proxy.setFileExtensionFilter(n, stringArray);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFileTypeFilter(int n, int n2) {
        try {
            this.proxy.setFileTypeFilter(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stop(int n) {
        try {
            this.proxy.stop(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getViewWindow(int n, int n2, int n3) {
        try {
            this.proxy.getViewWindow(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getViewWindowWithPreviews(int n, int n2, int n3) {
        try {
            this.proxy.getViewWindowWithPreviews(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getViewWindowFromFile(int n, int n2, BrowsedFile browsedFile, int n3) {
        try {
            this.proxy.getViewWindowFromFile(n, n2, browsedFile, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getResourceLocatorWindow(int n, int n2, int n3) {
        try {
            this.proxy.getResourceLocatorWindow(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getSelectedFiles(int n) {
        try {
            this.proxy.getSelectedFiles(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getResourceLocators(int n, BrowsedFileSet browsedFileSet) {
        try {
            this.proxy.getResourceLocators(n, browsedFileSet);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getFileCount(int n) {
        try {
            this.proxy.getFileCount(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getFileCountWithFileTypeFilter(int n, int n2) {
        try {
            this.proxy.getFileCountWithFileTypeFilter(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSelectionSingle(int n, BrowsedFile browsedFile, boolean bl) {
        try {
            this.proxy.setSelectionSingle(n, browsedFile, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setSelection(int n, int n2) {
        try {
            this.proxy.setSelection(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void changeFolder(int n, Path path) {
        try {
            this.proxy.changeFolder(n, path);
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
    public void startSpeller(int n, int n2) {
        try {
            this.proxy.startSpeller(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void addSpellerChars(int n, String string) {
        try {
            this.proxy.addSpellerChars(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void removeSpellerChar(int n) {
        try {
            this.proxy.removeSpellerChar(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void stopSpeller(int n) {
        try {
            this.proxy.stopSpeller(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFileTypeActive(boolean bl) {
        try {
            this.proxy.setFileTypeActive(bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void validateSpellerChars(int n, String string) {
        try {
            this.proxy.validateSpellerChars(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteAllPreviewFiles() {
        try {
            this.proxy.deleteAllPreviewFiles();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createPreviewImage(ResourceLocator resourceLocator, int n, int n2) {
        try {
            this.proxy.createPreviewImage(resourceLocator, n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cancelPreviewCreation() {
        try {
            this.proxy.cancelPreviewCreation();
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

