/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tpegservices.DSITPEGServices;
import de.esolutions.fw.comm.dsi.tpegservices.DSITPEGServicesC;
import de.esolutions.fw.comm.dsi.tpegservices.DSITPEGServicesReply;
import de.esolutions.fw.comm.dsi.tpegservices.impl.DSITPEGServicesProxy$1;
import de.esolutions.fw.comm.dsi.tpegservices.impl.DSITPEGServicesReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocation;

public class DSITPEGServicesProxy
implements DSITPEGServices,
DSITPEGServicesC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.tpegservices.DSITPEGServices");
    private Proxy proxy;

    public DSITPEGServicesProxy(int n, DSITPEGServicesReply dSITPEGServicesReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("fd9bc210-a829-5360-b874-09b6978b5b51", n, "7df675ac-5a57-5e93-bcae-c171725c0d43", "dsi.tpegservices.DSITPEGServices");
        DSITPEGServicesReplyService dSITPEGServicesReplyService = new DSITPEGServicesReplyService(dSITPEGServicesReply);
        this.proxy = new Proxy(serviceInstanceID, dSITPEGServicesReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestSimpleMapList(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void addSimpleMapBookmark(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)0, genericSerializable);
    }

    @Override
    public void deleteSimpleMapBookmark(int n) {
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
    public void deleteAllSimpleMapBookmarks() {
        this.proxy.remoteCallMethod((short)6, null);
    }

    @Override
    public void requestLocationDetails(int n) {
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
    public void requestFuelPriceInformation(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void requestSortedFuelPriceInformation(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)20, genericSerializable);
    }

    @Override
    public void requestNewsInformation(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void requestResourceInformation(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void setLanguage(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void requestWeatherInfo(NavLocation navLocation, int n, int n2) {
        DSITPEGServicesProxy$1 dSITPEGServicesProxy$1 = new DSITPEGServicesProxy$1(this, navLocation, n, n2);
        this.proxy.remoteCallMethod((short)32, dSITPEGServicesProxy$1);
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
        this.proxy.remoteCallMethod((short)24, genericSerializable);
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
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)23, null);
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
        this.proxy.remoteCallMethod((short)4, genericSerializable);
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
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)3, null);
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
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }
}

