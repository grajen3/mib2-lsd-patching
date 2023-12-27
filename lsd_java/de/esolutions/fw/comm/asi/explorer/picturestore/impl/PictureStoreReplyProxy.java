/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.PictureStoreReply;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$1;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$10;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$11;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$12;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$13;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$14;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$15;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$16;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$17;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$18;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$19;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$2;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$20;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$21;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$22;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$23;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$3;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$4;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$5;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$6;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$7;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$8;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy$9;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.picturestore.GeoPicture;
import org.dsi.ifc.picturestore.PictureAttribute;

public class PictureStoreReplyProxy
implements PictureStoreReply,
IProxyFrontend {
    private static final CallContext context = CallContext.getContext("PROXY.asi.explorer.picturestore.PictureStore");
    private static final int INVALID_HANDLE;
    private Proxy proxy;

    public PictureStoreReplyProxy() {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("a4508c38-8b16-4130-967f-f23cb2238fda", -1, "ca2869dd-3831-51b0-8093-231b81bca2c1", "asi.explorer.picturestore.PictureStore");
        this.proxy = new Proxy(serviceInstanceID, context);
    }

    @Override
    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void beginImportResult(int n) {
        PictureStoreReplyProxy$1 pictureStoreReplyProxy$1 = new PictureStoreReplyProxy$1(this, n);
        this.proxy.remoteCallMethod((short)41, pictureStoreReplyProxy$1);
    }

    @Override
    public void endImportResult(int n) {
        PictureStoreReplyProxy$2 pictureStoreReplyProxy$2 = new PictureStoreReplyProxy$2(this, n);
        this.proxy.remoteCallMethod((short)43, pictureStoreReplyProxy$2);
    }

    @Override
    public void importPictureFromSourceResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2) {
        PictureStoreReplyProxy$3 pictureStoreReplyProxy$3 = new PictureStoreReplyProxy$3(this, n, resourceLocator, resourceLocator2, n2);
        this.proxy.remoteCallMethod((short)49, pictureStoreReplyProxy$3);
    }

    @Override
    public void importPictureWithSynchronizationIDResult(int n, ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n2, long l) {
        PictureStoreReplyProxy$4 pictureStoreReplyProxy$4 = new PictureStoreReplyProxy$4(this, n, resourceLocator, resourceLocator2, n2, l);
        this.proxy.remoteCallMethod((short)66, pictureStoreReplyProxy$4);
    }

    @Override
    public void getMaxSynchronizationIDResult(int n, long l) {
        PictureStoreReplyProxy$5 pictureStoreReplyProxy$5 = new PictureStoreReplyProxy$5(this, n, l);
        this.proxy.remoteCallMethod((short)64, pictureStoreReplyProxy$5);
    }

    @Override
    public void setSynchronizationIDResult(int n, long l) {
        PictureStoreReplyProxy$6 pictureStoreReplyProxy$6 = new PictureStoreReplyProxy$6(this, n, l);
        this.proxy.remoteCallMethod((short)72, pictureStoreReplyProxy$6);
    }

    @Override
    public void renameFolderResult(int n, String string, String string2, long l, int n2) {
        PictureStoreReplyProxy$7 pictureStoreReplyProxy$7 = new PictureStoreReplyProxy$7(this, n, string, string2, l, n2);
        this.proxy.remoteCallMethod((short)70, pictureStoreReplyProxy$7);
    }

    @Override
    public void countPicturesInContextResult(int n, int n2, int n3) {
        PictureStoreReplyProxy$8 pictureStoreReplyProxy$8 = new PictureStoreReplyProxy$8(this, n, n2, n3);
        this.proxy.remoteCallMethod((short)36, pictureStoreReplyProxy$8);
    }

    @Override
    public void increaseRefCounterResult(ResourceLocator resourceLocator, ResourceLocator resourceLocator2, int n) {
        PictureStoreReplyProxy$9 pictureStoreReplyProxy$9 = new PictureStoreReplyProxy$9(this, resourceLocator, resourceLocator2, n);
        this.proxy.remoteCallMethod((short)50, pictureStoreReplyProxy$9);
    }

    @Override
    public void deletedPictures(ResourceLocator[] resourceLocatorArray) {
        PictureStoreReplyProxy$10 pictureStoreReplyProxy$10 = new PictureStoreReplyProxy$10(this, resourceLocatorArray);
        this.proxy.remoteCallMethod((short)2, pictureStoreReplyProxy$10);
    }

    @Override
    public void deleteSynchronizedPictureResult(int n, long l, long l2, int n2) {
        PictureStoreReplyProxy$11 pictureStoreReplyProxy$11 = new PictureStoreReplyProxy$11(this, n, l, l2, n2);
        this.proxy.remoteCallMethod((short)68, pictureStoreReplyProxy$11);
    }

    @Override
    public void getPictureAttributesResult(ResourceLocator resourceLocator, PictureAttribute[] pictureAttributeArray, int n) {
        PictureStoreReplyProxy$12 pictureStoreReplyProxy$12 = new PictureStoreReplyProxy$12(this, resourceLocator, pictureAttributeArray, n);
        this.proxy.remoteCallMethod((short)47, pictureStoreReplyProxy$12);
    }

    @Override
    public void listWithFilterResult(ResourceLocator[] resourceLocatorArray, int n) {
        PictureStoreReplyProxy$13 pictureStoreReplyProxy$13 = new PictureStoreReplyProxy$13(this, resourceLocatorArray, n);
        this.proxy.remoteCallMethod((short)30, pictureStoreReplyProxy$13);
    }

    @Override
    public void listForContextResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        PictureStoreReplyProxy$14 pictureStoreReplyProxy$14 = new PictureStoreReplyProxy$14(this, n, resourceLocatorArray, n2);
        this.proxy.remoteCallMethod((short)51, pictureStoreReplyProxy$14);
    }

    @Override
    public void listForContextWithFilterResult(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        PictureStoreReplyProxy$15 pictureStoreReplyProxy$15 = new PictureStoreReplyProxy$15(this, n, resourceLocatorArray, n2);
        this.proxy.remoteCallMethod((short)27, pictureStoreReplyProxy$15);
    }

    @Override
    public void listForContextWithFilterSortDistResult(int n, ResourceLocator[] resourceLocatorArray, int n2, float f2, float f3) {
        PictureStoreReplyProxy$16 pictureStoreReplyProxy$16 = new PictureStoreReplyProxy$16(this, n, resourceLocatorArray, n2, f2, f3);
        this.proxy.remoteCallMethod((short)73, pictureStoreReplyProxy$16);
    }

    @Override
    public void getRectanglePicturesGridResult(GeoPicture[] geoPictureArray) {
        PictureStoreReplyProxy$17 pictureStoreReplyProxy$17 = new PictureStoreReplyProxy$17(this, geoPictureArray);
        this.proxy.remoteCallMethod((short)10, pictureStoreReplyProxy$17);
    }

    @Override
    public void getAvailableYearsResult(int[] nArray) {
        PictureStoreReplyProxy$18 pictureStoreReplyProxy$18 = new PictureStoreReplyProxy$18(this, nArray);
        this.proxy.remoteCallMethod((short)24, pictureStoreReplyProxy$18);
    }

    @Override
    public void getAvailableMonthsResult(int[] nArray) {
        PictureStoreReplyProxy$19 pictureStoreReplyProxy$19 = new PictureStoreReplyProxy$19(this, nArray);
        this.proxy.remoteCallMethod((short)22, pictureStoreReplyProxy$19);
    }

    @Override
    public void createFilterSetResult(int n) {
        PictureStoreReplyProxy$20 pictureStoreReplyProxy$20 = new PictureStoreReplyProxy$20(this, n);
        this.proxy.remoteCallMethod((short)19, pictureStoreReplyProxy$20);
    }

    @Override
    public void cloneFilterSetResult(int n, int n2) {
        PictureStoreReplyProxy$21 pictureStoreReplyProxy$21 = new PictureStoreReplyProxy$21(this, n, n2);
        this.proxy.remoteCallMethod((short)38, pictureStoreReplyProxy$21);
    }

    @Override
    public void invalidData(int[] nArray, int n) {
        PictureStoreReplyProxy$22 pictureStoreReplyProxy$22 = new PictureStoreReplyProxy$22(this, nArray, n);
        this.proxy.remoteCallMethod((short)75, pictureStoreReplyProxy$22);
    }

    @Override
    public void getAvailableFoldersResult(int n, String[] stringArray) {
        PictureStoreReplyProxy$23 pictureStoreReplyProxy$23 = new PictureStoreReplyProxy$23(this, n, stringArray);
        this.proxy.remoteCallMethod((short)58, pictureStoreReplyProxy$23);
    }
}

