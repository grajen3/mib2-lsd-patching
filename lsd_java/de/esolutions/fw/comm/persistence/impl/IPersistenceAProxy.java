/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.persistence.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.persistence.IPersistenceA;
import de.esolutions.fw.comm.persistence.IPersistenceAC;
import de.esolutions.fw.comm.persistence.IPersistenceAReply;
import de.esolutions.fw.comm.persistence.PartitionHandle;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$1;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$10;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$11;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$12;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$13;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$14;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$15;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$16;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$17;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$18;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$19;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$2;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$20;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$21;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$22;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$23;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$24;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$25;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$26;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$3;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$4;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$5;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$6;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$7;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$8;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAProxy$9;
import de.esolutions.fw.comm.persistence.impl.IPersistenceAReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class IPersistenceAProxy
implements IPersistenceA,
IPersistenceAC {
    private static final CallContext context = CallContext.getContext("PROXY.persistence.IPersistenceA");
    private Proxy proxy;

    public IPersistenceAProxy(int n, IPersistenceAReply iPersistenceAReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("03171582-f255-4991-b8ae-83f90521c08b", n, "6e1d32e0-f75b-5b13-8215-fd985747e793", "persistence.IPersistenceA");
        IPersistenceAReplyService iPersistenceAReplyService = new IPersistenceAReplyService(iPersistenceAReply);
        this.proxy = new Proxy(serviceInstanceID, iPersistenceAReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void open(long l, String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)25, genericSerializable);
    }

    @Override
    public void open(String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void close(PartitionHandle partitionHandle) {
        IPersistenceAProxy$1 iPersistenceAProxy$1 = new IPersistenceAProxy$1(this, partitionHandle);
        this.proxy.remoteCallMethod((short)3, iPersistenceAProxy$1);
    }

    @Override
    public void version(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)44, genericSerializable);
    }

    @Override
    public void version(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)43, genericSerializable);
    }

    @Override
    public void purge(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)29, genericSerializable);
    }

    @Override
    public void purge(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }

    @Override
    public void beginTransaction(PartitionHandle partitionHandle) {
        IPersistenceAProxy$2 iPersistenceAProxy$2 = new IPersistenceAProxy$2(this, partitionHandle);
        this.proxy.remoteCallMethod((short)0, iPersistenceAProxy$2);
    }

    @Override
    public void endTransaction(PartitionHandle partitionHandle, boolean bl) {
        IPersistenceAProxy$3 iPersistenceAProxy$3 = new IPersistenceAProxy$3(this, partitionHandle, bl);
        this.proxy.remoteCallMethod((short)51, iPersistenceAProxy$3);
    }

    @Override
    public void endTransaction(PartitionHandle partitionHandle) {
        IPersistenceAProxy$4 iPersistenceAProxy$4 = new IPersistenceAProxy$4(this, partitionHandle);
        this.proxy.remoteCallMethod((short)5, iPersistenceAProxy$4);
    }

    @Override
    public void flush(PartitionHandle partitionHandle) {
        IPersistenceAProxy$5 iPersistenceAProxy$5 = new IPersistenceAProxy$5(this, partitionHandle);
        this.proxy.remoteCallMethod((short)9, iPersistenceAProxy$5);
    }

    @Override
    public void exists(PartitionHandle partitionHandle, long l) {
        IPersistenceAProxy$6 iPersistenceAProxy$6 = new IPersistenceAProxy$6(this, partitionHandle, l);
        this.proxy.remoteCallMethod((short)7, iPersistenceAProxy$6);
    }

    @Override
    public void remove(PartitionHandle partitionHandle, long l) {
        IPersistenceAProxy$7 iPersistenceAProxy$7 = new IPersistenceAProxy$7(this, partitionHandle, l);
        this.proxy.remoteCallMethod((short)32, iPersistenceAProxy$7);
    }

    @Override
    public void setInt(PartitionHandle partitionHandle, long l, long l2) {
        IPersistenceAProxy$8 iPersistenceAProxy$8 = new IPersistenceAProxy$8(this, partitionHandle, l, l2);
        this.proxy.remoteCallMethod((short)35, iPersistenceAProxy$8);
    }

    @Override
    public void getInt(PartitionHandle partitionHandle, long l, int n) {
        IPersistenceAProxy$9 iPersistenceAProxy$9 = new IPersistenceAProxy$9(this, partitionHandle, l, n);
        this.proxy.remoteCallMethod((short)64, iPersistenceAProxy$9);
    }

    @Override
    public void getInt(PartitionHandle partitionHandle, long l) {
        IPersistenceAProxy$10 iPersistenceAProxy$10 = new IPersistenceAProxy$10(this, partitionHandle, l);
        this.proxy.remoteCallMethod((short)15, iPersistenceAProxy$10);
    }

    @Override
    public void getInts(PartitionHandle partitionHandle, long[] lArray, int n) {
        IPersistenceAProxy$11 iPersistenceAProxy$11 = new IPersistenceAProxy$11(this, partitionHandle, lArray, n);
        this.proxy.remoteCallMethod((short)66, iPersistenceAProxy$11);
    }

    @Override
    public void getInts(PartitionHandle partitionHandle, long[] lArray) {
        IPersistenceAProxy$12 iPersistenceAProxy$12 = new IPersistenceAProxy$12(this, partitionHandle, lArray);
        this.proxy.remoteCallMethod((short)17, iPersistenceAProxy$12);
    }

    @Override
    public void setString(PartitionHandle partitionHandle, long l, String string) {
        IPersistenceAProxy$13 iPersistenceAProxy$13 = new IPersistenceAProxy$13(this, partitionHandle, l, string);
        this.proxy.remoteCallMethod((short)37, iPersistenceAProxy$13);
    }

    @Override
    public void getString(PartitionHandle partitionHandle, long l, int n) {
        IPersistenceAProxy$14 iPersistenceAProxy$14 = new IPersistenceAProxy$14(this, partitionHandle, l, n);
        this.proxy.remoteCallMethod((short)68, iPersistenceAProxy$14);
    }

    @Override
    public void getString(PartitionHandle partitionHandle, long l) {
        IPersistenceAProxy$15 iPersistenceAProxy$15 = new IPersistenceAProxy$15(this, partitionHandle, l);
        this.proxy.remoteCallMethod((short)19, iPersistenceAProxy$15);
    }

    @Override
    public void getStrings(PartitionHandle partitionHandle, long[] lArray, int n) {
        IPersistenceAProxy$16 iPersistenceAProxy$16 = new IPersistenceAProxy$16(this, partitionHandle, lArray, n);
        this.proxy.remoteCallMethod((short)70, iPersistenceAProxy$16);
    }

    @Override
    public void getStrings(PartitionHandle partitionHandle, long[] lArray) {
        IPersistenceAProxy$17 iPersistenceAProxy$17 = new IPersistenceAProxy$17(this, partitionHandle, lArray);
        this.proxy.remoteCallMethod((short)21, iPersistenceAProxy$17);
    }

    @Override
    public void setBlob(PartitionHandle partitionHandle, long l, short[] sArray) {
        IPersistenceAProxy$18 iPersistenceAProxy$18 = new IPersistenceAProxy$18(this, partitionHandle, l, sArray);
        this.proxy.remoteCallMethod((short)34, iPersistenceAProxy$18);
    }

    @Override
    public void getBlob(PartitionHandle partitionHandle, long l, int n) {
        IPersistenceAProxy$19 iPersistenceAProxy$19 = new IPersistenceAProxy$19(this, partitionHandle, l, n);
        this.proxy.remoteCallMethod((short)60, iPersistenceAProxy$19);
    }

    @Override
    public void getBlob(PartitionHandle partitionHandle, long l) {
        IPersistenceAProxy$20 iPersistenceAProxy$20 = new IPersistenceAProxy$20(this, partitionHandle, l);
        this.proxy.remoteCallMethod((short)11, iPersistenceAProxy$20);
    }

    @Override
    public void getBlobs(PartitionHandle partitionHandle, long[] lArray, int n) {
        IPersistenceAProxy$21 iPersistenceAProxy$21 = new IPersistenceAProxy$21(this, partitionHandle, lArray, n);
        this.proxy.remoteCallMethod((short)62, iPersistenceAProxy$21);
    }

    @Override
    public void getBlobs(PartitionHandle partitionHandle, long[] lArray) {
        IPersistenceAProxy$22 iPersistenceAProxy$22 = new IPersistenceAProxy$22(this, partitionHandle, lArray);
        this.proxy.remoteCallMethod((short)13, iPersistenceAProxy$22);
    }

    @Override
    public void subscribe(PartitionHandle partitionHandle, long[] lArray, int n) {
        IPersistenceAProxy$23 iPersistenceAProxy$23 = new IPersistenceAProxy$23(this, partitionHandle, lArray, n);
        this.proxy.remoteCallMethod((short)80, iPersistenceAProxy$23);
    }

    @Override
    public void subscribe(PartitionHandle partitionHandle, long[] lArray) {
        IPersistenceAProxy$24 iPersistenceAProxy$24 = new IPersistenceAProxy$24(this, partitionHandle, lArray);
        this.proxy.remoteCallMethod((short)39, iPersistenceAProxy$24);
    }

    @Override
    public void unsubscribe(PartitionHandle partitionHandle, long[] lArray) {
        IPersistenceAProxy$25 iPersistenceAProxy$25 = new IPersistenceAProxy$25(this, partitionHandle, lArray);
        this.proxy.remoteCallMethod((short)40, iPersistenceAProxy$25);
    }

    @Override
    public void unsubscribeAll(PartitionHandle partitionHandle) {
        IPersistenceAProxy$26 iPersistenceAProxy$26 = new IPersistenceAProxy$26(this, partitionHandle);
        this.proxy.remoteCallMethod((short)41, iPersistenceAProxy$26);
    }

    @Override
    public void convert(long l, String string, String string2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putUInt32(l);
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)48, genericSerializable);
    }

    @Override
    public void convert(String string, String string2, String string3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putOptionalString(string2);
            genericSerializable.putOptionalString(string3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)47, genericSerializable);
    }
}

