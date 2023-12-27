/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombipictureserver.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombipictureserver.DSIKombiPictureServer;
import de.esolutions.fw.comm.dsi.kombipictureserver.DSIKombiPictureServerC;
import de.esolutions.fw.comm.dsi.kombipictureserver.DSIKombiPictureServerReply;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy$1;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy$2;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy$3;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy$4;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy$5;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerProxy$6;
import de.esolutions.fw.comm.dsi.kombipictureserver.impl.DSIKombiPictureServerReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;

public class DSIKombiPictureServerProxy
implements DSIKombiPictureServer,
DSIKombiPictureServerC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombipictureserver.DSIKombiPictureServer");
    private Proxy proxy;

    public DSIKombiPictureServerProxy(int n, DSIKombiPictureServerReply dSIKombiPictureServerReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("e2ec2c1a-6feb-5795-ad64-808237e9eb04", n, "b5b5ee5e-67a7-517b-8bd4-22d8ed778502", "dsi.kombipictureserver.DSIKombiPictureServer");
        DSIKombiPictureServerReplyService dSIKombiPictureServerReplyService = new DSIKombiPictureServerReplyService(dSIKombiPictureServerReply);
        this.proxy = new Proxy(serviceInstanceID, dSIKombiPictureServerReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void setKombiHmiReady() {
        this.proxy.remoteCallMethod((short)15, null);
    }

    @Override
    public void responseCoverArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        DSIKombiPictureServerProxy$1 dSIKombiPictureServerProxy$1 = new DSIKombiPictureServerProxy$1(this, l, n, n2, n3, resourceLocator);
        this.proxy.remoteCallMethod((short)27, dSIKombiPictureServerProxy$1);
    }

    @Override
    public void responseStationArt(long l, int n, int n2, int n3, ResourceLocator resourceLocator) {
        DSIKombiPictureServerProxy$2 dSIKombiPictureServerProxy$2 = new DSIKombiPictureServerProxy$2(this, l, n, n2, n3, resourceLocator);
        this.proxy.remoteCallMethod((short)29, dSIKombiPictureServerProxy$2);
    }

    @Override
    public void responseActiveCallPicture(int n, int n2, ResourceLocator resourceLocator) {
        DSIKombiPictureServerProxy$3 dSIKombiPictureServerProxy$3 = new DSIKombiPictureServerProxy$3(this, n, n2, resourceLocator);
        this.proxy.remoteCallMethod((short)10, dSIKombiPictureServerProxy$3);
    }

    @Override
    public void responseActiveCallPictureInstance(int n, int n2, int n3, ResourceLocator resourceLocator) {
        DSIKombiPictureServerProxy$4 dSIKombiPictureServerProxy$4 = new DSIKombiPictureServerProxy$4(this, n, n2, n3, resourceLocator);
        this.proxy.remoteCallMethod((short)36, dSIKombiPictureServerProxy$4);
    }

    @Override
    public void responseDynamicIcon(int n, int n2, boolean bl, ResourceLocator resourceLocator) {
        DSIKombiPictureServerProxy$5 dSIKombiPictureServerProxy$5 = new DSIKombiPictureServerProxy$5(this, n, n2, bl, resourceLocator);
        this.proxy.remoteCallMethod((short)37, dSIKombiPictureServerProxy$5);
    }

    @Override
    public void responseAdbContactPicture(long l, int n, int n2, ResourceLocator resourceLocator) {
        DSIKombiPictureServerProxy$6 dSIKombiPictureServerProxy$6 = new DSIKombiPictureServerProxy$6(this, l, n, n2, resourceLocator);
        this.proxy.remoteCallMethod((short)26, dSIKombiPictureServerProxy$6);
    }

    @Override
    public void responseInternalAddressID(long l, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void responsePictureServerAbilities(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)32, genericSerializable);
    }

    @Override
    public void responsePictureStream(int n, short s, short s2, int n2, int n3, byte[] byArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt16(s);
            genericSerializable.putInt16(s2);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putOptionalInt8VarArray(byArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)33, genericSerializable);
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
        this.proxy.remoteCallMethod((short)17, genericSerializable);
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
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)16, null);
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
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }
}

