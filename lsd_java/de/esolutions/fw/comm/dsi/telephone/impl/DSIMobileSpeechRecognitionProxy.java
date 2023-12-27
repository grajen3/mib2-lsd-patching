/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.telephone.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.telephone.DSIMobileSpeechRecognition;
import de.esolutions.fw.comm.dsi.telephone.DSIMobileSpeechRecognitionC;
import de.esolutions.fw.comm.dsi.telephone.DSIMobileSpeechRecognitionReply;
import de.esolutions.fw.comm.dsi.telephone.impl.DSIMobileSpeechRecognitionReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIMobileSpeechRecognitionProxy
implements DSIMobileSpeechRecognition,
DSIMobileSpeechRecognitionC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.telephone.DSIMobileSpeechRecognition");
    private Proxy proxy;

    public DSIMobileSpeechRecognitionProxy(int n, DSIMobileSpeechRecognitionReply dSIMobileSpeechRecognitionReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("db970b0f-3c89-5e05-bfb4-2413a989dec1", n, "2b54b56d-1a82-5bc4-adc7-cee4cb037b15", "dsi.telephone.DSIMobileSpeechRecognition");
        DSIMobileSpeechRecognitionReplyService dSIMobileSpeechRecognitionReplyService = new DSIMobileSpeechRecognitionReplyService(dSIMobileSpeechRecognitionReply);
        this.proxy = new Proxy(serviceInstanceID, dSIMobileSpeechRecognitionReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestStartSpeechRecognition() {
        this.proxy.remoteCallMethod((short)4, null);
    }

    @Override
    public void requestStopSpeechRecognition() {
        this.proxy.remoteCallMethod((short)13, null);
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
        this.proxy.remoteCallMethod((short)7, genericSerializable);
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
        this.proxy.remoteCallMethod((short)8, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)6, null);
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

