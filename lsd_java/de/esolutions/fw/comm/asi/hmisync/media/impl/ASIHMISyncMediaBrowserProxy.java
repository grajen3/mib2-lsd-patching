/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowser;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserC;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaBrowserReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaEntry;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserProxy$1;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserProxy$2;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserProxy$3;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaBrowserReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMediaBrowserProxy
implements ASIHMISyncMediaBrowser,
ASIHMISyncMediaBrowserC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.media.ASIHMISyncMediaBrowser");
    private Proxy proxy;

    public ASIHMISyncMediaBrowserProxy(int n, ASIHMISyncMediaBrowserReply aSIHMISyncMediaBrowserReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("04780aa8-9662-4220-9900-4a1e11586d28", n, "8f2aa3cc-0c22-5ffa-83d3-4e78162cf3e6", "asi.hmisync.media.ASIHMISyncMediaBrowser");
        ASIHMISyncMediaBrowserReplyService aSIHMISyncMediaBrowserReplyService = new ASIHMISyncMediaBrowserReplyService(aSIHMISyncMediaBrowserReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncMediaBrowserReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void activate(MediaSourceSlot mediaSourceSlot) {
        ASIHMISyncMediaBrowserProxy$1 aSIHMISyncMediaBrowserProxy$1 = new ASIHMISyncMediaBrowserProxy$1(this, mediaSourceSlot);
        this.proxy.remoteCallMethod((short)0, aSIHMISyncMediaBrowserProxy$1);
    }

    @Override
    public void deactivate() {
        this.proxy.remoteCallMethod((short)6, null);
    }

    @Override
    public void setBrowseMode(int n) {
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
    public void changeFolder(MediaEntry[] mediaEntryArray) {
        ASIHMISyncMediaBrowserProxy$2 aSIHMISyncMediaBrowserProxy$2 = new ASIHMISyncMediaBrowserProxy$2(this, mediaEntryArray);
        this.proxy.remoteCallMethod((short)2, aSIHMISyncMediaBrowserProxy$2);
    }

    @Override
    public void addSelection(int n, MediaEntry mediaEntry) {
        ASIHMISyncMediaBrowserProxy$3 aSIHMISyncMediaBrowserProxy$3 = new ASIHMISyncMediaBrowserProxy$3(this, n, mediaEntry);
        this.proxy.remoteCallMethod((short)1, aSIHMISyncMediaBrowserProxy$3);
    }

    @Override
    public void requestList(int n, long l, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)12, null);
    }

    @Override
    public void setNotification(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void setNotification(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)3, null);
    }

    @Override
    public void clearNotification(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void clearNotification(long[] lArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalUInt32VarArray(lArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }
}

