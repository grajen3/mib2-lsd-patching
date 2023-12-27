/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.hmisync.media.impl;

import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMedia;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaC;
import de.esolutions.fw.comm.asi.hmisync.media.ASIHMISyncMediaReply;
import de.esolutions.fw.comm.asi.hmisync.media.MediaBrowserSelectionData;
import de.esolutions.fw.comm.asi.hmisync.media.MediaSourceSlot;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaProxy$1;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaProxy$2;
import de.esolutions.fw.comm.asi.hmisync.media.impl.ASIHMISyncMediaReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class ASIHMISyncMediaProxy
implements ASIHMISyncMedia,
ASIHMISyncMediaC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.hmisync.media.ASIHMISyncMedia");
    private Proxy proxy;

    public ASIHMISyncMediaProxy(int n, ASIHMISyncMediaReply aSIHMISyncMediaReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("848d4459-b390-4cdf-b374-6d4783690a1b", n, "ec49cac0-e751-57fe-b753-0d3e4dc75d6e", "asi.hmisync.media.ASIHMISyncMedia");
        ASIHMISyncMediaReplyService aSIHMISyncMediaReplyService = new ASIHMISyncMediaReplyService(aSIHMISyncMediaReply);
        this.proxy = new Proxy(serviceInstanceID, aSIHMISyncMediaReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void activate(MediaSourceSlot mediaSourceSlot, MediaBrowserSelectionData mediaBrowserSelectionData) {
        ASIHMISyncMediaProxy$1 aSIHMISyncMediaProxy$1 = new ASIHMISyncMediaProxy$1(this, mediaSourceSlot, mediaBrowserSelectionData);
        this.proxy.remoteCallMethod((short)0, aSIHMISyncMediaProxy$1);
    }

    @Override
    public void resume() {
        this.proxy.remoteCallMethod((short)11, null);
    }

    @Override
    public void pause() {
        this.proxy.remoteCallMethod((short)6, null);
    }

    @Override
    public void skip(byte by) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt8(by);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void seek(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void stopSeek() {
        this.proxy.remoteCallMethod((short)36, null);
    }

    @Override
    public void mix(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void repeatTitle(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void toggleRepeatState() {
        this.proxy.remoteCallMethod((short)39, null);
    }

    @Override
    public void toggleShuffleState() {
        this.proxy.remoteCallMethod((short)40, null);
    }

    @Override
    public void setEntry(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void setTimePosition(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void touchEvent(int n, int n2, int n3, int n4, int n5) {
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
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void executeDvdVideoCommand(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void requestPlayList(int n, long l, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setPlaySelection(MediaBrowserSelectionData mediaBrowserSelectionData) {
        ASIHMISyncMediaProxy$2 aSIHMISyncMediaProxy$2 = new ASIHMISyncMediaProxy$2(this, mediaBrowserSelectionData);
        this.proxy.remoteCallMethod((short)17, aSIHMISyncMediaProxy$2);
    }

    @Override
    public void playMoreFrom(long l, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)14, null);
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
        this.proxy.remoteCallMethod((short)16, genericSerializable);
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
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
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
        this.proxy.remoteCallMethod((short)2, genericSerializable);
    }
}

