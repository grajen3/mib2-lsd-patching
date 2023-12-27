/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.search.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.search.DSISearchDataProvider;
import de.esolutions.fw.comm.dsi.search.DSISearchDataProviderC;
import de.esolutions.fw.comm.dsi.search.DSISearchDataProviderReply;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchDataProviderProxy$1;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchDataProviderProxy$2;
import de.esolutions.fw.comm.dsi.search.impl.DSISearchDataProviderReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.search.DataSet;
import org.dsi.ifc.search.RawDataSet;

public class DSISearchDataProviderProxy
implements DSISearchDataProvider,
DSISearchDataProviderC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.search.DSISearchDataProvider");
    private Proxy proxy;

    public DSISearchDataProviderProxy(int n, DSISearchDataProviderReply dSISearchDataProviderReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("609c2f54-403b-514e-a26b-497fb68562b8", n, "0bdb432e-00eb-5a56-a464-12a0e0e947b1", "dsi.search.DSISearchDataProvider");
        DSISearchDataProviderReplyService dSISearchDataProviderReplyService = new DSISearchDataProviderReplyService(dSISearchDataProviderReply);
        this.proxy = new Proxy(serviceInstanceID, dSISearchDataProviderReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void registerProviderSource(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)10, genericSerializable);
    }

    @Override
    public void sourceDataAvailabilityChanged(int n, boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void invalidateAllData(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void storeDataSets(int n, DataSet[] dataSetArray, int n2) {
        DSISearchDataProviderProxy$1 dSISearchDataProviderProxy$1 = new DSISearchDataProviderProxy$1(this, n, dataSetArray, n2);
        this.proxy.remoteCallMethod((short)21, dSISearchDataProviderProxy$1);
    }

    @Override
    public void storeRawDataSets(int n, RawDataSet[] rawDataSetArray, int n2) {
        DSISearchDataProviderProxy$2 dSISearchDataProviderProxy$2 = new DSISearchDataProviderProxy$2(this, n, rawDataSetArray, n2);
        this.proxy.remoteCallMethod((short)20, dSISearchDataProviderProxy$2);
    }

    @Override
    public void deleteDataSet(int n, long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
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
        this.proxy.remoteCallMethod((short)13, genericSerializable);
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
        this.proxy.remoteCallMethod((short)14, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)12, null);
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
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }
}

