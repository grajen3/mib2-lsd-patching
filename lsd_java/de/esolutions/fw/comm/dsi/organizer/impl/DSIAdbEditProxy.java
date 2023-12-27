/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbEdit;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbEditC;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbEditReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbEditProxy$1;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbEditProxy$2;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbEditProxy$3;
import de.esolutions.fw.comm.dsi.organizer.impl.DSIAdbEditReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.AdbEntry;

public class DSIAdbEditProxy
implements DSIAdbEdit,
DSIAdbEditC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.organizer.DSIAdbEdit");
    private Proxy proxy;

    public DSIAdbEditProxy(int n, DSIAdbEditReply dSIAdbEditReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("b8a478f0-a008-5e29-b678-453c90a12a42", n, "87e7bf42-ab91-53b0-acdc-c57190b576d5", "dsi.organizer.DSIAdbEdit");
        DSIAdbEditReplyService dSIAdbEditReplyService = new DSIAdbEditReplyService(dSIAdbEditReply);
        this.proxy = new Proxy(serviceInstanceID, dSIAdbEditReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void insertEntry(AdbEntry adbEntry, int n) {
        DSIAdbEditProxy$1 dSIAdbEditProxy$1 = new DSIAdbEditProxy$1(this, adbEntry, n);
        this.proxy.remoteCallMethod((short)17, dSIAdbEditProxy$1);
    }

    @Override
    public void getEntries(long[] lArray, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void getEntryDataSets(long[] lArray, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void changeEntry(AdbEntry adbEntry, int n) {
        DSIAdbEditProxy$2 dSIAdbEditProxy$2 = new DSIAdbEditProxy$2(this, adbEntry, n);
        this.proxy.remoteCallMethod((short)15, dSIAdbEditProxy$2);
    }

    @Override
    public void copyEntry(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)4, genericSerializable);
    }

    @Override
    public void deleteEntries(long[] lArray, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalInt64VarArray(lArray);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)5, genericSerializable);
    }

    @Override
    public void setSpeedDial(AdbEntry adbEntry) {
        DSIAdbEditProxy$3 dSIAdbEditProxy$3 = new DSIAdbEditProxy$3(this, adbEntry);
        this.proxy.remoteCallMethod((short)18, dSIAdbEditProxy$3);
    }

    @Override
    public void deleteSpeedDial(int n) {
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
    public void getEntryByReferenceId(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
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

