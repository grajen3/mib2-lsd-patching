/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingAudio;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingAudioC;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingAudioReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingAudioProxy$1;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingAudioProxy$2;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingAudioProxy$3;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingAudioReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombifastlist.DataCommonList;
import org.dsi.ifc.kombifastlist.DataMediaBrowser;
import org.dsi.ifc.kombifastlist.DataReceptionList;

public class DSIFastListScrollingAudioProxy
implements DSIFastListScrollingAudio,
DSIFastListScrollingAudioC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombifastlist.DSIFastListScrollingAudio");
    private Proxy proxy;

    public DSIFastListScrollingAudioProxy(int n, DSIFastListScrollingAudioReply dSIFastListScrollingAudioReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("85e659ee-d2bf-5319-a867-f9afc89a7b40", n, "dd122866-29e9-54f8-be13-f1b6397c3d5f", "dsi.kombifastlist.DSIFastListScrollingAudio");
        DSIFastListScrollingAudioReplyService dSIFastListScrollingAudioReplyService = new DSIFastListScrollingAudioReplyService(dSIFastListScrollingAudioReply);
        this.proxy = new Proxy(serviceInstanceID, dSIFastListScrollingAudioReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void pushFunctionAvailabilityAudio(int n) {
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
    public void pushMOSTOperationStateAudio(int n) {
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
    public void responseMediaBrowser(int n, int n2, int n3, int n4, int n5, int n6, int n7, long l, int n8, long l2, long l3, int n9, int n10, int n11) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
            genericSerializable.putInt32(n5);
            genericSerializable.putInt32(n6);
            genericSerializable.putInt32(n7);
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n8);
            genericSerializable.putInt64(l2);
            genericSerializable.putInt64(l3);
            genericSerializable.putInt32(n9);
            genericSerializable.putInt32(n10);
            genericSerializable.putInt32(n11);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void responseMediaBrowserArray(long l, int n, DataMediaBrowser[] dataMediaBrowserArray) {
        DSIFastListScrollingAudioProxy$1 dSIFastListScrollingAudioProxy$1 = new DSIFastListScrollingAudioProxy$1(this, l, n, dataMediaBrowserArray);
        this.proxy.remoteCallMethod((short)15, dSIFastListScrollingAudioProxy$1);
    }

    @Override
    public void pushCommonList(long l, int n, DataCommonList[] dataCommonListArray) {
        DSIFastListScrollingAudioProxy$2 dSIFastListScrollingAudioProxy$2 = new DSIFastListScrollingAudioProxy$2(this, l, n, dataCommonListArray);
        this.proxy.remoteCallMethod((short)9, dSIFastListScrollingAudioProxy$2);
    }

    @Override
    public void pushReceptionList(long l, int n, DataReceptionList[] dataReceptionListArray) {
        DSIFastListScrollingAudioProxy$3 dSIFastListScrollingAudioProxy$3 = new DSIFastListScrollingAudioProxy$3(this, l, n, dataReceptionListArray);
        this.proxy.remoteCallMethod((short)13, dSIFastListScrollingAudioProxy$3);
    }

    @Override
    public void pushCurrentListSizeAudio(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void responseMediaBrowserJobs(long l, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void responseNotifyCommonListPush(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void responseNotifyCurrentListSizeAudio(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void responseNotifyReceptionList(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
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
        this.proxy.remoteCallMethod((short)21, genericSerializable);
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
        this.proxy.remoteCallMethod((short)22, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)20, null);
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
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }
}

