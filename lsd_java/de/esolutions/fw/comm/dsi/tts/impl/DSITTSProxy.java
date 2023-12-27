/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tts.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tts.DSITTS;
import de.esolutions.fw.comm.dsi.tts.DSITTSC;
import de.esolutions.fw.comm.dsi.tts.DSITTSReply;
import de.esolutions.fw.comm.dsi.tts.impl.DSITTSProxy$1;
import de.esolutions.fw.comm.dsi.tts.impl.DSITTSReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.tts.TTSPrompt;

public class DSITTSProxy
implements DSITTS,
DSITTSC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.tts.DSITTS");
    private Proxy proxy;

    public DSITTSProxy(int n, DSITTSReply dSITTSReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("3ec2050a-cbb3-5d61-8a43-34960573d838", n, "e8685afc-fb0e-5385-a1ba-2fae13b0c7d7", "dsi.tts.DSITTS");
        DSITTSReplyService dSITTSReplyService = new DSITTSReplyService(dSITTSReply);
        this.proxy = new Proxy(serviceInstanceID, dSITTSReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void speakPrompt(short s, TTSPrompt tTSPrompt) {
        DSITTSProxy$1 dSITTSProxy$1 = new DSITTSProxy$1(this, s, tTSPrompt);
        this.proxy.remoteCallMethod((short)10, dSITTSProxy$1);
    }

    @Override
    public void setLanguage(short s, String string, int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void init(short s) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)3, genericSerializable);
    }

    @Override
    public void requestAudioTrigger(short s, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void requestPlayTone(short s, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void requestSkipSpeaking(short s, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)22, genericSerializable);
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
        this.proxy.remoteCallMethod((short)8, genericSerializable);
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
        this.proxy.remoteCallMethod((short)9, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)7, null);
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
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }
}

