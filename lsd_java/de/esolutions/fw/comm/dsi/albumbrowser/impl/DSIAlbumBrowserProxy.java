/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.albumbrowser.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.albumbrowser.DSIAlbumBrowser;
import de.esolutions.fw.comm.dsi.albumbrowser.DSIAlbumBrowserC;
import de.esolutions.fw.comm.dsi.albumbrowser.DSIAlbumBrowserReply;
import de.esolutions.fw.comm.dsi.albumbrowser.impl.DSIAlbumBrowserReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIAlbumBrowserProxy
implements DSIAlbumBrowser,
DSIAlbumBrowserC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.albumbrowser.DSIAlbumBrowser");
    private Proxy proxy;

    public DSIAlbumBrowserProxy(int n, DSIAlbumBrowserReply dSIAlbumBrowserReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("2af5bc21-5cbd-5430-a909-9cc19692a1d2", n, "185c4ed3-4d8a-5abf-933a-db6607faeebe", "dsi.albumbrowser.DSIAlbumBrowser");
        DSIAlbumBrowserReplyService dSIAlbumBrowserReplyService = new DSIAlbumBrowserReplyService(dSIAlbumBrowserReply);
        this.proxy = new Proxy(serviceInstanceID, dSIAlbumBrowserReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void initializeBrowser(long l, long l2, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt64(l2);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void deinitializeBrowser() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void startSingle() {
        this.proxy.remoteCallMethod((short)19, null);
    }

    @Override
    public void startPreview() {
        this.proxy.remoteCallMethod((short)18, null);
    }

    @Override
    public void startActive() {
        this.proxy.remoteCallMethod((short)17, null);
    }

    @Override
    public void stop() {
        this.proxy.remoteCallMethod((short)20, null);
    }

    @Override
    public void setScrollMode(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void scrollTicks(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void selectAlbum(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void moveFocus(long l, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void albumIdxForFID(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)0, genericSerializable);
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
        this.proxy.remoteCallMethod((short)10, genericSerializable);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)9, null);
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
        this.proxy.remoteCallMethod((short)2, genericSerializable);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
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
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }
}

