/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIRadioTagging;
import de.esolutions.fw.comm.dsi.media.DSIRadioTaggingC;
import de.esolutions.fw.comm.dsi.media.DSIRadioTaggingReply;
import de.esolutions.fw.comm.dsi.media.impl.DSIRadioTaggingProxy$1;
import de.esolutions.fw.comm.dsi.media.impl.DSIRadioTaggingProxy$2;
import de.esolutions.fw.comm.dsi.media.impl.DSIRadioTaggingReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.media.TagInformation;

public class DSIRadioTaggingProxy
implements DSIRadioTagging,
DSIRadioTaggingC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.media.DSIRadioTagging");
    private Proxy proxy;

    public DSIRadioTaggingProxy(int n, DSIRadioTaggingReply dSIRadioTaggingReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("ad066dac-3241-5d34-b029-32d72a092966", n, "70f39a0c-498b-54a6-9ada-1e10bc686e8e", "dsi.media.DSIRadioTagging");
        DSIRadioTaggingReplyService dSIRadioTaggingReplyService = new DSIRadioTaggingReplyService(dSIRadioTaggingReply);
        this.proxy = new Proxy(serviceInstanceID, dSIRadioTaggingReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void tagSong(TagInformation tagInformation) {
        DSIRadioTaggingProxy$1 dSIRadioTaggingProxy$1 = new DSIRadioTaggingProxy$1(this, tagInformation);
        this.proxy.remoteCallMethod((short)9, dSIRadioTaggingProxy$1);
    }

    @Override
    public void tagAmbiguousSong(TagInformation tagInformation, TagInformation tagInformation2) {
        DSIRadioTaggingProxy$2 dSIRadioTaggingProxy$2 = new DSIRadioTaggingProxy$2(this, tagInformation, tagInformation2);
        this.proxy.remoteCallMethod((short)7, dSIRadioTaggingProxy$2);
    }

    @Override
    public void groupTags(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
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
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)4, null);
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
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }
}

