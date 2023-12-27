/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.dsi.picturestore;

import de.esolutions.fw.comm.agent.Agent;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.picturestore.DSIPictureStoreReply;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy;
import de.esolutions.fw.dsi.base.AbstractProvider;
import de.esolutions.fw.dsi.base.IDispatcher;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.DSIPictureStore;
import org.osgi.framework.BundleContext;

public class DSIPictureStoreProvider
extends AbstractProvider
implements DSIPictureStore {
    private static final int[] attributeIDs = new int[0];
    private DSIPictureStoreProxy proxy;
    static /* synthetic */ Class class$org$dsi$ifc$picturestore$DSIPictureStore;

    public DSIPictureStoreProvider(int n, BundleContext bundleContext, Agent agent, IDispatcher iDispatcher) {
        super(bundleContext, agent, iDispatcher, n);
        this.createNewProxy();
    }

    @Override
    protected int[] getAttributeIDs() {
        return attributeIDs;
    }

    @Override
    public String getName() {
        return (class$org$dsi$ifc$picturestore$DSIPictureStore == null ? (class$org$dsi$ifc$picturestore$DSIPictureStore = DSIPictureStoreProvider.class$("org.dsi.ifc.picturestore.DSIPictureStore")) : class$org$dsi$ifc$picturestore$DSIPictureStore).getName();
    }

    @Override
    protected Proxy getProxy() {
        return this.proxy.getProxy();
    }

    @Override
    protected Proxy createNewProxy() {
        this.proxy = new DSIPictureStoreProxy(this.instance, (DSIPictureStoreReply)((Object)this.dispatcher));
        return this.proxy.getProxy();
    }

    @Override
    public void setConfig(int n, int n2, int n3, int n4) {
        try {
            this.proxy.setConfig(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importPicture(int n, ResourceLocator resourceLocator, boolean bl) {
        try {
            this.proxy.importPicture(n, resourceLocator, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void pictureExists(ResourceLocator resourceLocator) {
        try {
            this.proxy.pictureExists(resourceLocator);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void increaseRefCounter(ResourceLocator resourceLocator, int n) {
        try {
            this.proxy.increaseRefCounter(resourceLocator, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void decreaseRefCounter(ResourceLocator resourceLocator, int n) {
        try {
            this.proxy.decreaseRefCounter(resourceLocator, n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getFreeSlots(int n) {
        try {
            this.proxy.getFreeSlots(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getReferences(ResourceLocator resourceLocator) {
        try {
            this.proxy.getReferences(resourceLocator);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteAllPictures(int n, boolean bl) {
        try {
            this.proxy.deleteAllPictures(n, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deletePicturesFromContext(int n, ResourceLocator[] resourceLocatorArray, boolean bl) {
        try {
            this.proxy.deletePicturesFromContext(n, resourceLocatorArray, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deletePictures(ResourceLocator[] resourceLocatorArray, boolean bl) {
        try {
            this.proxy.deletePictures(resourceLocatorArray, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getLRUPictures(int n, boolean bl, int n2) {
        try {
            this.proxy.getLRUPictures(n, bl, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void listInAllContexts(int n, int n2) {
        try {
            this.proxy.listInAllContexts(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void listInContext(int n, int n2, int n3) {
        try {
            this.proxy.listInContext(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getPictureAttributes(ResourceLocator resourceLocator) {
        try {
            this.proxy.getPictureAttributes(resourceLocator);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setConfigWithFileType(int n, int n2, int n3, int n4, int n5) {
        try {
            this.proxy.setConfigWithFileType(n, n2, n3, n4, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void importPictureFromSource(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string) {
        try {
            this.proxy.importPictureFromSource(n, resourceLocator, bl, n2, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deletePicturesWithFilterSet(int n, int n2, boolean bl) {
        try {
            this.proxy.deletePicturesWithFilterSet(n, n2, bl);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void listInContextWithFilter(int n, int n2, int n3, int n4) {
        try {
            this.proxy.listInContextWithFilter(n, n2, n3, n4);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void listInContextWithFilterSortDist(int n, int n2, int n3, int n4, float f2, float f3) {
        try {
            this.proxy.listInContextWithFilterSortDist(n, n2, n3, n4, f2, f3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getRectanglePicturesGrid(int n, int n2, float f2, float f3, float f4, float f5, int n3, int n4, int n5) {
        try {
            this.proxy.getRectanglePicturesGrid(n, n2, f2, f3, f4, f5, n3, n4, n5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getAvailableYears(int n, int n2) {
        try {
            this.proxy.getAvailableYears(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getAvailableMonths(int n, int n2, int n3) {
        try {
            this.proxy.getAvailableMonths(n, n2, n3);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void createFilterSet() {
        try {
            this.proxy.createFilterSet();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void cloneFilterSet(int n) {
        try {
            this.proxy.cloneFilterSet(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void deleteFilterSet(int n) {
        try {
            this.proxy.deleteFilterSet(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFilterImportSource(int n, int n2) {
        try {
            this.proxy.setFilterImportSource(n, n2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFilterTimeInterval(int n, int n2, long l, long l2) {
        try {
            this.proxy.setFilterTimeInterval(n, n2, l, l2);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFilterGeoArea(int n, float f2, float f3, float f4, float f5) {
        try {
            this.proxy.setFilterGeoArea(n, f2, f3, f4, f5);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void resetToFactorySettings() {
        try {
            this.proxy.resetToFactorySettings();
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void getAvailableFolders(int n) {
        try {
            this.proxy.getAvailableFolders(n);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void setFilterFolderName(int n, String string) {
        try {
            this.proxy.setFilterFolderName(n, string);
        }
        catch (MethodException methodException) {
            this.traceException(methodException);
        }
    }

    @Override
    public void countPicturesInContext(int n, int n2) {
        try {
            this.proxy.countPicturesInContext(n, n2);
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

