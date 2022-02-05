/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.carplay.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.carplay.DSICarplay;
import de.esolutions.fw.comm.dsi.carplay.DSICarplayC;
import de.esolutions.fw.comm.dsi.carplay.DSICarplayReply;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayProxy$1;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayProxy$2;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayProxy$3;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayProxy$4;
import de.esolutions.fw.comm.dsi.carplay.impl.DSICarplayReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.carplay.AppState;
import org.dsi.ifc.carplay.AppStateRequest;
import org.dsi.ifc.carplay.Resource;
import org.dsi.ifc.carplay.ResourceRequest;
import org.dsi.ifc.carplay.ServiceConfiguration;
import org.dsi.ifc.carplay.TouchEvent;

public class DSICarplayProxy
implements DSICarplay,
DSICarplayC {
    private static /*final*/ CallContext context = CallContext.getContext("PROXY.dsi.carplay.DSICarplay");
    private Proxy proxy;

    public DSICarplayProxy(int n, DSICarplayReply dSICarplayReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("b60ff3e0-c276-5843-8023-5aba5e2ac150", n, "44e3fa4c-73e2-5fd1-a140-725298101c75", "dsi.carplay.DSICarplay");
        DSICarplayReplyService dSICarplayReplyService = new DSICarplayReplyService(dSICarplayReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarplayReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

   // @Override
    public void startService(ServiceConfiguration serviceConfiguration) {
        DSICarplayProxy$1 dSICarplayProxy$1 = new DSICarplayProxy$1(this, serviceConfiguration);
        this.proxy.remoteCallMethod((short)46, dSICarplayProxy$1);
    }

   // @Override
    public void postButtonEvent(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

   // @Override
    public void postTouchEvent(int n, int n2, TouchEvent[] touchEventArray) {
        DSICarplayProxy$2 dSICarplayProxy$2 = new DSICarplayProxy$2(this, n, n2, touchEventArray);
        this.proxy.remoteCallMethod((short)7, dSICarplayProxy$2);
    }

   // @Override
    public void postRotaryEvent(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

   // @Override
    public void postCharacterEvent(int n, String[] stringArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putOptionalStringVarArray(stringArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

   // @Override
    public void requestModeChange(ResourceRequest[] resourceRequestArray, AppStateRequest[] appStateRequestArray, String string) {
        
        boolean ignored = false;
        if (appStateRequestArray != null) {
            for (int i=0; i < appStateRequestArray.length; i++) {
                AppStateRequest appStateRequest = appStateRequestArray[i];
                String footer = "";
                if (appStateRequest.appStateID == 2 && appStateRequest.state && appStateRequest.speechMode == 0) {
                    footer = " (ignored)";
                    ignored = true;
                }
                System.out.println("DSICarplayProxy.requestModeChange(" + string + "): " + appStateRequest.toString() + footer);
            }
        } else {
            System.out.println("DSICarplayProxy.requestModeChange(" + string + "): " + resourceRequestArray);
        }
                    
        new Exception("Stack trace").printStackTrace();

        if (ignored) {
            return;
        }

        DSICarplayProxy$3 dSICarplayProxy$3 = new DSICarplayProxy$3(this, resourceRequestArray, appStateRequestArray, string);
        this.proxy.remoteCallMethod((short)9, dSICarplayProxy$3);
    }

   // @Override
    public void responseUpdateMode(Resource[] resourceArray, AppState[] appStateArray) {
        DSICarplayProxy$4 dSICarplayProxy$4 = new DSICarplayProxy$4(this, resourceArray, appStateArray);
        this.proxy.remoteCallMethod((short)38, dSICarplayProxy$4);
    }

   // @Override
    public void responseBTDeactivation() {
        this.proxy.remoteCallMethod((short)12, null);
    }

   // @Override
    public void requestUI(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

   // @Override
    public void requestNightMode(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

   // @Override
    public void requestSIRIAction(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)34, genericSerializable);
    }

   // @Override
    public void responseUpdateMainAudioType(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)42, genericSerializable);
    }

   // @Override
    public void requestUI2(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)47, genericSerializable);
    }

   // @Override
    public void setNotification(int[] nArray) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt32VarArray(nArray);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

   // @Override
    public void setNotification(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

   // @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)14, null);
    }

   // @Override
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

   // @Override
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

   // @Override
    public void clearNotification() {
        this.proxy.remoteCallMethod((short)1, null);
    }

   // @Override
    public void yySet(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)31, genericSerializable);
    }
}

