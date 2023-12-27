/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.PictureStoreS;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class PictureStoreService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.explorer.picturestore.PictureStore");
    private PictureStoreS p_PictureStore;

    public PictureStoreService(int n, PictureStoreS pictureStoreS) {
        super(new ServiceInstanceID("5aae4603-1d67-4882-89d6-72230f24ce90", n, "643c356d-a0a7-5ae2-9543-30deb149f1b8", "asi.explorer.picturestore.PictureStore"));
        this.p_PictureStore = pictureStoreS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new PictureStoreReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 6: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_PictureStore.setConfig(n, n2, n3, n4, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getEnum();
                    this.p_PictureStore.setConfigWithFileType(n, n5, n6, n7, n8, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 14: {
                    this.p_PictureStore.beginImport((PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 16: {
                    this.p_PictureStore.endImport((PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 59: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    int n9 = iDeserializer.getEnum();
                    String string = iDeserializer.getOptionalString();
                    this.p_PictureStore.importPictureFromSource(n, resourceLocator, bl, n9, string, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 65: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    int n10 = iDeserializer.getEnum();
                    String string = iDeserializer.getOptionalString();
                    long l = iDeserializer.getInt64();
                    this.p_PictureStore.importPictureWithSynchronizationID(n, resourceLocator, bl, n10, string, l, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 63: {
                    int n = iDeserializer.getInt32();
                    this.p_PictureStore.getMaxSynchronizationID(n, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 71: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    this.p_PictureStore.setSynchronizationID(n, l, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 69: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    long l = iDeserializer.getInt64();
                    this.p_PictureStore.renameFolder(n, string, string2, l, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_PictureStore.countPicturesInContext(n, n11, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 5: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_PictureStore.increaseRefCounter(resourceLocator, n, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 0: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_PictureStore.decreaseRefCounter(resourceLocator, n, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    this.p_PictureStore.decreaseAllRefCounters(n, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_PictureStore.deleteAllPictures(n, bl, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 42: {
                    int n = iDeserializer.getInt32();
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    boolean bl = iDeserializer.getBool();
                    this.p_PictureStore.deletePicturesFromContext(n, resourceLocatorArray, bl, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 39: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_PictureStore.deletePicturesWithFilterSet(n, n12, bl, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 67: {
                    int n = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    this.p_PictureStore.deleteSynchronizedPicture(n, l, l2, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 46: {
                    ResourceLocator resourceLocator = ResourceLocatorSerializer.getOptionalResourceLocator(iDeserializer);
                    this.p_PictureStore.getPictureAttributes(resourceLocator, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_PictureStore.listInAllContextsWithFilter(n, n13, n14, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 52: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_PictureStore.listInContext(n, n15, n16, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    int n18 = iDeserializer.getInt32();
                    int n19 = iDeserializer.getInt32();
                    this.p_PictureStore.listInContextWithFilter(n, n17, n18, n19, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 74: {
                    int n = iDeserializer.getInt32();
                    int n20 = iDeserializer.getInt32();
                    int n21 = iDeserializer.getInt32();
                    int n22 = iDeserializer.getInt32();
                    float f2 = iDeserializer.getFloat();
                    float f3 = iDeserializer.getFloat();
                    this.p_PictureStore.listInContextWithFilterSortDist(n, n20, n21, n22, f2, f3, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 55: {
                    int n = iDeserializer.getInt32();
                    int n23 = iDeserializer.getInt32();
                    float f4 = iDeserializer.getFloat();
                    float f5 = iDeserializer.getFloat();
                    float f6 = iDeserializer.getFloat();
                    float f7 = iDeserializer.getFloat();
                    int n24 = iDeserializer.getInt32();
                    int n25 = iDeserializer.getInt32();
                    int n26 = iDeserializer.getInt32();
                    this.p_PictureStore.getRectanglePicturesGrid(n, n23, f4, f5, f6, f7, n24, n25, n26, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n27 = iDeserializer.getEnum();
                    this.p_PictureStore.getAvailableYears(n, n27, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    int n28 = iDeserializer.getInt32();
                    int n29 = iDeserializer.getEnum();
                    this.p_PictureStore.getAvailableMonths(n, n28, n29, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 18: {
                    this.p_PictureStore.createFilterSet((PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    this.p_PictureStore.cloneFilterSet(n, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    this.p_PictureStore.deleteFilterSet(n, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n30 = iDeserializer.getInt32();
                    this.p_PictureStore.setFilterImportSource(n, n30, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    int n31 = iDeserializer.getEnum();
                    long l = iDeserializer.getInt64();
                    long l3 = iDeserializer.getInt64();
                    this.p_PictureStore.setFilterTimeInterval(n, n31, l, l3, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    float f8 = iDeserializer.getFloat();
                    float f9 = iDeserializer.getFloat();
                    float f10 = iDeserializer.getFloat();
                    float f11 = iDeserializer.getFloat();
                    this.p_PictureStore.setFilterGeoArea(n, f8, f9, f10, f11, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 57: {
                    int n = iDeserializer.getInt32();
                    this.p_PictureStore.getAvailableFolders(n, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                case 60: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_PictureStore.setFilterFolderName(n, string, (PictureStoreReplyProxy)iProxyFrontend);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

