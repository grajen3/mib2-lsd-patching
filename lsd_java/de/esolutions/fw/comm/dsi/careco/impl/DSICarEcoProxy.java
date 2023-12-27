/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.careco.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.careco.DSICarEco;
import de.esolutions.fw.comm.dsi.careco.DSICarEcoC;
import de.esolutions.fw.comm.dsi.careco.DSICarEcoReply;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoProxy$1;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoProxy$2;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoProxy$3;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoProxy$4;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoProxy$5;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoProxy$6;
import de.esolutions.fw.comm.dsi.careco.impl.DSICarEcoReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.careco.BCmEListUpdateInfo;
import org.dsi.ifc.careco.StartStopListUpdateInfo;

public class DSICarEcoProxy
implements DSICarEco,
DSICarEcoC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.careco.DSICarEco");
    private Proxy proxy;

    public DSICarEcoProxy(int n, DSICarEcoReply dSICarEcoReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("46a82947-5a7f-5551-83ad-a1637982beaa", n, "e465c6b3-358d-566f-a11e-bef47fad7aee", "dsi.careco.DSICarEco");
        DSICarEcoReplyService dSICarEcoReplyService = new DSICarEcoReplyService(dSICarEcoReply);
        this.proxy = new Proxy(serviceInstanceID, dSICarEcoReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void requestBCmEConsumerList(BCmEListUpdateInfo bCmEListUpdateInfo) {
        DSICarEcoProxy$1 dSICarEcoProxy$1 = new DSICarEcoProxy$1(this, bCmEListUpdateInfo);
        this.proxy.remoteCallMethod((short)91, dSICarEcoProxy$1);
    }

    @Override
    public void setBCmELiveTip(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void setBcmeSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)15, null);
    }

    @Override
    public void requestStartStopProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
        DSICarEcoProxy$2 dSICarEcoProxy$2 = new DSICarEcoProxy$2(this, startStopListUpdateInfo);
        this.proxy.remoteCallMethod((short)7, dSICarEcoProxy$2);
    }

    @Override
    public void requestStartStopRestartList(StartStopListUpdateInfo startStopListUpdateInfo) {
        DSICarEcoProxy$3 dSICarEcoProxy$3 = new DSICarEcoProxy$3(this, startStopListUpdateInfo);
        this.proxy.remoteCallMethod((short)8, dSICarEcoProxy$3);
    }

    @Override
    public void requestStartStopRestartProhibitList(StartStopListUpdateInfo startStopListUpdateInfo) {
        DSICarEcoProxy$4 dSICarEcoProxy$4 = new DSICarEcoProxy$4(this, startStopListUpdateInfo);
        this.proxy.remoteCallMethod((short)9, dSICarEcoProxy$4);
    }

    @Override
    public void requestBCmEConsumerListConsumption(BCmEListUpdateInfo bCmEListUpdateInfo) {
        DSICarEcoProxy$5 dSICarEcoProxy$5 = new DSICarEcoProxy$5(this, bCmEListUpdateInfo);
        this.proxy.remoteCallMethod((short)92, dSICarEcoProxy$5);
    }

    @Override
    public void requestBCmEConsumerListRange(BCmEListUpdateInfo bCmEListUpdateInfo) {
        DSICarEcoProxy$6 dSICarEcoProxy$6 = new DSICarEcoProxy$6(this, bCmEListUpdateInfo);
        this.proxy.remoteCallMethod((short)93, dSICarEcoProxy$6);
    }

    @Override
    public void setRDSetFactoryDefault() {
        this.proxy.remoteCallMethod((short)19, null);
    }

    @Override
    public void setEASystem(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)79, genericSerializable);
    }

    @Override
    public void setEAPedalJerk(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)77, genericSerializable);
    }

    @Override
    public void setEASetFactoryDefault() {
        this.proxy.remoteCallMethod((short)78, null);
    }

    @Override
    public void setEAFreeWheeling(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)86, genericSerializable);
    }

    @Override
    public void setEAStartStop(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)87, genericSerializable);
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
        this.proxy.remoteCallMethod((short)54, genericSerializable);
    }
}

