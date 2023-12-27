/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturestore.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.picturestore.DSIPictureStore;
import de.esolutions.fw.comm.dsi.picturestore.DSIPictureStoreC;
import de.esolutions.fw.comm.dsi.picturestore.DSIPictureStoreReply;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy$1;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy$2;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy$3;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy$4;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy$5;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy$6;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy$7;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy$8;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreProxy$9;
import de.esolutions.fw.comm.dsi.picturestore.impl.DSIPictureStoreReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSIPictureStoreProxy
implements DSIPictureStore,
DSIPictureStoreC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.picturestore.DSIPictureStore");
    private Proxy proxy;

    public DSIPictureStoreProxy(int n, DSIPictureStoreReply dSIPictureStoreReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("6547a393-25c0-5a7f-ab18-fa7875d3e6aa", n, "2ef96885-7e80-5628-938a-ba87647a92d5", "dsi.picturestore.DSIPictureStore");
        DSIPictureStoreReplyService dSIPictureStoreReplyService = new DSIPictureStoreReplyService(dSIPictureStoreReply);
        this.proxy = new Proxy(serviceInstanceID, dSIPictureStoreReplyService, context);
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
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void importPicture(int n, ResourceLocator resourceLocator, boolean bl) {
        DSIPictureStoreProxy$1 dSIPictureStoreProxy$1 = new DSIPictureStoreProxy$1(this, n, resourceLocator, bl);
        this.proxy.remoteCallMethod((short)11, dSIPictureStoreProxy$1);
    }

    @Override
    public void pictureExists(ResourceLocator resourceLocator) {
        DSIPictureStoreProxy$2 dSIPictureStoreProxy$2 = new DSIPictureStoreProxy$2(this, resourceLocator);
        this.proxy.remoteCallMethod((short)15, dSIPictureStoreProxy$2);
    }

    @Override
    public void increaseRefCounter(ResourceLocator resourceLocator, int n) {
        DSIPictureStoreProxy$3 dSIPictureStoreProxy$3 = new DSIPictureStoreProxy$3(this, resourceLocator, n);
        this.proxy.remoteCallMethod((short)12, dSIPictureStoreProxy$3);
    }

    @Override
    public void decreaseRefCounter(ResourceLocator resourceLocator, int n) {
        DSIPictureStoreProxy$4 dSIPictureStoreProxy$4 = new DSIPictureStoreProxy$4(this, resourceLocator, n);
        this.proxy.remoteCallMethod((short)3, dSIPictureStoreProxy$4);
    }

    @Override
    public void getFreeSlots(int n) {
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
    public void getReferences(ResourceLocator resourceLocator) {
        DSIPictureStoreProxy$5 dSIPictureStoreProxy$5 = new DSIPictureStoreProxy$5(this, resourceLocator);
        this.proxy.remoteCallMethod((short)10, dSIPictureStoreProxy$5);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void deletePicturesFromContext(int n, ResourceLocator[] resourceLocatorArray, boolean bl) {
        DSIPictureStoreProxy$6 dSIPictureStoreProxy$6 = new DSIPictureStoreProxy$6(this, n, resourceLocatorArray, bl);
        this.proxy.remoteCallMethod((short)6, dSIPictureStoreProxy$6);
    }

    @Override
    public void deletePictures(ResourceLocator[] resourceLocatorArray, boolean bl) {
        DSIPictureStoreProxy$7 dSIPictureStoreProxy$7 = new DSIPictureStoreProxy$7(this, resourceLocatorArray, bl);
        this.proxy.remoteCallMethod((short)5, dSIPictureStoreProxy$7);
    }

    @Override
    public void getLRUPictures(int n, boolean bl, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void listInAllContexts(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void getPictureAttributes(ResourceLocator resourceLocator) {
        DSIPictureStoreProxy$8 dSIPictureStoreProxy$8 = new DSIPictureStoreProxy$8(this, resourceLocator);
        this.proxy.remoteCallMethod((short)9, dSIPictureStoreProxy$8);
    }

    @Override
    public void setConfigWithFileType(int n, int n2, int n3, int n4, int n5) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
            genericSerializable.putInt32(n5);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)30, genericSerializable);
    }

    @Override
    public void importPictureFromSource(int n, ResourceLocator resourceLocator, boolean bl, int n2, String string) {
        DSIPictureStoreProxy$9 dSIPictureStoreProxy$9 = new DSIPictureStoreProxy$9(this, n, resourceLocator, bl, n2, string);
        this.proxy.remoteCallMethod((short)35, dSIPictureStoreProxy$9);
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
        this.proxy.remoteCallMethod((short)24, genericSerializable);
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
        this.proxy.remoteCallMethod((short)62, genericSerializable);
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
        this.proxy.remoteCallMethod((short)27, genericSerializable);
    }

    @Override
    public void getAvailableYears(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }

    @Override
    public void getAvailableMonths(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void createFilterSet() {
        this.proxy.remoteCallMethod((short)22, null);
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
        this.proxy.remoteCallMethod((short)21, genericSerializable);
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
        this.proxy.remoteCallMethod((short)23, genericSerializable);
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
            genericSerializable.putInt32(n2);
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
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
    public void resetToFactorySettings() {
        this.proxy.remoteCallMethod((short)36, null);
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
        this.proxy.remoteCallMethod((short)34, genericSerializable);
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
        this.proxy.remoteCallMethod((short)37, genericSerializable);
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
        this.proxy.remoteCallMethod((short)38, genericSerializable);
    }

    @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)17, null);
    }

    @Override
    public void clearNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void clearNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)0, null);
    }

    @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }
}

