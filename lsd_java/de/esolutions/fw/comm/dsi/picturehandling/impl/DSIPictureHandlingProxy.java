/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.picturehandling.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.picturehandling.DSIPictureHandling;
import de.esolutions.fw.comm.dsi.picturehandling.DSIPictureHandlingC;
import de.esolutions.fw.comm.dsi.picturehandling.DSIPictureHandlingReply;
import de.esolutions.fw.comm.dsi.picturehandling.impl.DSIPictureHandlingProxy$1;
import de.esolutions.fw.comm.dsi.picturehandling.impl.DSIPictureHandlingProxy$2;
import de.esolutions.fw.comm.dsi.picturehandling.impl.DSIPictureHandlingReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSIPictureHandlingProxy
implements DSIPictureHandling,
DSIPictureHandlingC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.picturehandling.DSIPictureHandling");
    private Proxy proxy;

    public DSIPictureHandlingProxy(int n, DSIPictureHandlingReply dSIPictureHandlingReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("95e3a600-66cb-54c6-aba9-3cb50e9eaa12", n, "584bc854-0159-59ce-92d8-982381968c59", "dsi.picturehandling.DSIPictureHandling");
        DSIPictureHandlingReplyService dSIPictureHandlingReplyService = new DSIPictureHandlingReplyService(dSIPictureHandlingReply);
        this.proxy = new Proxy(serviceInstanceID, dSIPictureHandlingReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setPictureConfig(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)12, genericSerializable);
    }

    @Override
    public void requestPictures(int n, ResourceLocator[] resourceLocatorArray, int n2) {
        DSIPictureHandlingProxy$1 dSIPictureHandlingProxy$1 = new DSIPictureHandlingProxy$1(this, n, resourceLocatorArray, n2);
        this.proxy.remoteCallMethod((short)8, dSIPictureHandlingProxy$1);
    }

    @Override
    public void cancelPicture(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)1, genericSerializable);
    }

    @Override
    public void freePicture(ResourceLocator resourceLocator) {
        DSIPictureHandlingProxy$2 dSIPictureHandlingProxy$2 = new DSIPictureHandlingProxy$2(this, resourceLocator);
        this.proxy.remoteCallMethod((short)6, dSIPictureHandlingProxy$2);
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
        this.proxy.remoteCallMethod((short)3, genericSerializable);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)2, null);
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }
}

