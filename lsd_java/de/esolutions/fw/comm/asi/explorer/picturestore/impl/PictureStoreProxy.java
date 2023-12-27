/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.explorer.picturestore.impl;

import de.esolutions.fw.comm.asi.explorer.picturestore.PictureStore;
import de.esolutions.fw.comm.asi.explorer.picturestore.PictureStoreC;
import de.esolutions.fw.comm.asi.explorer.picturestore.PictureStoreReply;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy$1;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy$2;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy$3;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy$4;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy$5;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreProxy$6;
import de.esolutions.fw.comm.asi.explorer.picturestore.impl.PictureStoreReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class PictureStoreProxy
implements PictureStore,
PictureStoreC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.explorer.picturestore.PictureStore");
    private Proxy proxy;

    public PictureStoreProxy(int n, PictureStoreReply pictureStoreReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("5aae4603-1d67-4882-89d6-72230f24ce90", n, "643c356d-a0a7-5ae2-9543-30deb149f1b8", "asi.explorer.picturestore.PictureStore");
        PictureStoreReplyService pictureStoreReplyService = new PictureStoreReplyService(pictureStoreReply);
        this.proxy = new Proxy(serviceInstanceID, pictureStoreReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setConfig(int n, int n2, int n3, int n4) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void setConfigWithFileType(int n, int n2, int n3, int n4, int n5) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
            genericSerializable.putEnum(n5);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)53, genericSerializable);
    }

    @Override
    public void beginImport() {
        this.proxy.remoteCallMethod((short)14, null);
    }

    @Override
    public void endImport() {
        this.proxy.remoteCallMethod((short)16, null);
    }

    @Override
    public void importPictureFromSource(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string) {
        PictureStoreProxy$1 pictureStoreProxy$1 = new PictureStoreProxy$1(this, n, resourceLocator, bl, n2, string);
        this.proxy.remoteCallMethod((short)59, pictureStoreProxy$1);
    }

    @Override
    public void importPictureWithSynchronizationID(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string, long l) {
        PictureStoreProxy$2 pictureStoreProxy$2 = new PictureStoreProxy$2(this, n, resourceLocator, bl, n2, string, l);
        this.proxy.remoteCallMethod((short)65, pictureStoreProxy$2);
    }

    @Override
    public void getMaxSynchronizationID(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)63, genericSerializable);
    }

    @Override
    public void setSynchronizationID(int n, long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)71, genericSerializable);
    }

    @Override
    public void renameFolder(int n, String string, String string2, long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)69, genericSerializable);
    }

    @Override
    public void countPicturesInContext(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)35, genericSerializable);
    }

    @Override
    public void increaseRefCounter(ResourceLocator resourceLocator, int n) {
        PictureStoreProxy$3 pictureStoreProxy$3 = new PictureStoreProxy$3(this, resourceLocator, n);
        this.proxy.remoteCallMethod((short)5, pictureStoreProxy$3);
    }

    @Override
    public void decreaseRefCounter(ResourceLocator resourceLocator, int n) {
        PictureStoreProxy$4 pictureStoreProxy$4 = new PictureStoreProxy$4(this, resourceLocator, n);
        this.proxy.remoteCallMethod((short)0, pictureStoreProxy$4);
    }

    @Override
    public void decreaseAllRefCounters(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void deleteAllPictures(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void deletePicturesFromContext(int n, ResourceLocator[] resourceLocatorArray, boolean bl) {
        PictureStoreProxy$5 pictureStoreProxy$5 = new PictureStoreProxy$5(this, n, resourceLocatorArray, bl);
        this.proxy.remoteCallMethod((short)42, pictureStoreProxy$5);
    }

    @Override
    public void deletePicturesWithFilterSet(int n, int n2, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)39, genericSerializable);
    }

    @Override
    public void deleteSynchronizedPicture(int n, long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)67, genericSerializable);
    }

    @Override
    public void getPictureAttributes(ResourceLocator resourceLocator) {
        PictureStoreProxy$6 pictureStoreProxy$6 = new PictureStoreProxy$6(this, resourceLocator);
        this.proxy.remoteCallMethod((short)46, pictureStoreProxy$6);
    }

    @Override
    public void listInAllContextsWithFilter(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void listInContext(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)52, genericSerializable);
    }

    @Override
    public void listInContextWithFilter(int n, int n2, int n3, int n4) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    @Override
    public void listInContextWithFilterSortDist(int n, int n2, int n3, int n4, float f2, float f3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
            genericSerializable.putFloat(f2);
            genericSerializable.putFloat(f3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)74, genericSerializable);
    }

    @Override
    public void getRectanglePicturesGrid(int n, int n2, float f2, float f3, float f4, float f5, int n3, int n4, int n5) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putFloat(f2);
            genericSerializable.putFloat(f3);
            genericSerializable.putFloat(f4);
            genericSerializable.putFloat(f5);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
            genericSerializable.putInt32(n5);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)55, genericSerializable);
    }

    @Override
    public void getAvailableYears(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putEnum(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)45, genericSerializable);
    }

    @Override
    public void getAvailableMonths(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putEnum(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)44, genericSerializable);
    }

    @Override
    public void createFilterSet() {
        this.proxy.remoteCallMethod((short)18, null);
    }

    @Override
    public void cloneFilterSet(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)37, genericSerializable);
    }

    @Override
    public void deleteFilterSet(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void setFilterImportSource(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    @Override
    public void setFilterTimeInterval(int n, int n2, long l, long l2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putEnum(n2);
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)54, genericSerializable);
    }

    @Override
    public void setFilterGeoArea(int n, float f2, float f3, float f4, float f5) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putFloat(f2);
            genericSerializable.putFloat(f3);
            genericSerializable.putFloat(f4);
            genericSerializable.putFloat(f5);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }

    @Override
    public void getAvailableFolders(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)57, genericSerializable);
    }

    @Override
    public void setFilterFolderName(int n, String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)60, genericSerializable);
    }
}

