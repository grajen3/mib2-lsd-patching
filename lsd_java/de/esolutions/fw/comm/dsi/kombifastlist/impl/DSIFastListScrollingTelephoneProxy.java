/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.kombifastlist.impl;

import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingTelephone;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingTelephoneC;
import de.esolutions.fw.comm.dsi.kombifastlist.DSIFastListScrollingTelephoneReply;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneProxy$1;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneProxy$2;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneProxy$3;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneProxy$4;
import de.esolutions.fw.comm.dsi.kombifastlist.impl.DSIFastListScrollingTelephoneReplyService;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.kombifastlist.DataCombinedNumbers;
import org.dsi.ifc.kombifastlist.DataFavoriteList;
import org.dsi.ifc.kombifastlist.DataInitials;
import org.dsi.ifc.kombifastlist.DataPhonebook;

public class DSIFastListScrollingTelephoneProxy
implements DSIFastListScrollingTelephone,
DSIFastListScrollingTelephoneC {
    private static final CallContext context = CallContext.getContext("PROXY.dsi.kombifastlist.DSIFastListScrollingTelephone");
    private Proxy proxy;

    public DSIFastListScrollingTelephoneProxy(int n, DSIFastListScrollingTelephoneReply dSIFastListScrollingTelephoneReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("75e6756d-c921-58e9-92cf-8f198f2a1ce7", n, "5e4b90d1-e0ae-5563-bc16-6c69162249eb", "dsi.kombifastlist.DSIFastListScrollingTelephone");
        DSIFastListScrollingTelephoneReplyService dSIFastListScrollingTelephoneReplyService = new DSIFastListScrollingTelephoneReplyService(dSIFastListScrollingTelephoneReply);
        this.proxy = new Proxy(serviceInstanceID, dSIFastListScrollingTelephoneReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void pushFunctionAvailabilityTelephone(int n) {
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
    public void pushMOSTOperationStateTelephone(short s) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt16(s);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void responsePhonebook(int n, int n2, int n3, int n4, int n5, long l, int n6, int n7, int n8, int n9, int n10, int n11, int n12) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
            genericSerializable.putInt32(n4);
            genericSerializable.putInt32(n5);
            genericSerializable.putInt64(l);
            genericSerializable.putInt32(n6);
            genericSerializable.putInt32(n7);
            genericSerializable.putInt32(n8);
            genericSerializable.putInt32(n9);
            genericSerializable.putInt32(n10);
            genericSerializable.putInt32(n11);
            genericSerializable.putInt32(n12);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void responsePhonebookArray(int n, int n2, DataPhonebook[] dataPhonebookArray) {
        DSIFastListScrollingTelephoneProxy$1 dSIFastListScrollingTelephoneProxy$1 = new DSIFastListScrollingTelephoneProxy$1(this, n, n2, dataPhonebookArray);
        this.proxy.remoteCallMethod((short)20, dSIFastListScrollingTelephoneProxy$1);
    }

    @Override
    public void responseGetInitialsTelephone(int n, int n2, int n3, int n4, DataInitials[] dataInitialsArray) {
        DSIFastListScrollingTelephoneProxy$2 dSIFastListScrollingTelephoneProxy$2 = new DSIFastListScrollingTelephoneProxy$2(this, n, n2, n3, n4, dataInitialsArray);
        this.proxy.remoteCallMethod((short)15, dSIFastListScrollingTelephoneProxy$2);
    }

    @Override
    public void pushupdateFavoriteList(int n, int n2, DataFavoriteList[] dataFavoriteListArray) {
        DSIFastListScrollingTelephoneProxy$3 dSIFastListScrollingTelephoneProxy$3 = new DSIFastListScrollingTelephoneProxy$3(this, n, n2, dataFavoriteListArray);
        this.proxy.remoteCallMethod((short)14, dSIFastListScrollingTelephoneProxy$3);
    }

    @Override
    public void pushCombinedNumbers(int n, int n2, DataCombinedNumbers[] dataCombinedNumbersArray) {
        DSIFastListScrollingTelephoneProxy$4 dSIFastListScrollingTelephoneProxy$4 = new DSIFastListScrollingTelephoneProxy$4(this, n, n2, dataCombinedNumbersArray);
        this.proxy.remoteCallMethod((short)10, dSIFastListScrollingTelephoneProxy$4);
    }

    @Override
    public void pushCurrentListSizeTelephone(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)11, genericSerializable);
    }

    @Override
    public void responsePhonebookJobs(int n, int n2, int n3) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
            genericSerializable.putInt32(n3);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)21, genericSerializable);
    }

    @Override
    public void responseNotifyCombinedNumbersPush(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)16, genericSerializable);
    }

    @Override
    public void responseNotifyCurrentListSizes(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)17, genericSerializable);
    }

    @Override
    public void responseNotifyFavoriteListPush(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
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
        this.proxy.remoteCallMethod((short)23, genericSerializable);
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
        this.proxy.remoteCallMethod((short)24, genericSerializable);
    }

    @Override
    public void setNotification() {
        this.proxy.remoteCallMethod((short)22, null);
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
        this.proxy.remoteCallMethod((short)26, genericSerializable);
    }
}

