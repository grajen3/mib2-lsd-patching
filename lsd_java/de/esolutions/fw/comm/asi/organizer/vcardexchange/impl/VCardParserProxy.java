/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParser;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserC;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserProxy$1;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserProxy$2;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.Proxy;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.util.serializer.adapter.GenericSerializable;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.AdbEntry;

public class VCardParserProxy
implements VCardParser,
VCardParserC {
    private static final CallContext context = CallContext.getContext("PROXY.asi.organizer.vcardexchange.VCardParser");
    private Proxy proxy;

    public VCardParserProxy(int n, VCardParserReply vCardParserReply) {
        ServiceInstanceID serviceInstanceID = new ServiceInstanceID("ac51e9cb-58ff-4a94-82b2-348bedfdc513", n, "4d2de5a1-2ec1-5014-915d-ced43ea78aaf", "asi.organizer.vcardexchange.VCardParser");
        VCardParserReplyService vCardParserReplyService = new VCardParserReplyService(vCardParserReply);
        this.proxy = new Proxy(serviceInstanceID, vCardParserReplyService, context);
    }

    public Proxy getProxy() {
        return this.proxy;
    }

    @Override
    public void parseVCard(String string, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)18, genericSerializable);
    }

    @Override
    public void parseVCardDirectory(String string, int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)19, genericSerializable);
    }

    @Override
    public void exportVCard(AdbEntry adbEntry, String string, int n) {
        VCardParserProxy$1 vCardParserProxy$1 = new VCardParserProxy$1(this, adbEntry, string, n);
        this.proxy.remoteCallMethod((short)25, vCardParserProxy$1);
    }

    @Override
    public void exportSmallVCard(AdbEntry adbEntry, String string, int n) {
        VCardParserProxy$2 vCardParserProxy$2 = new VCardParserProxy$2(this, adbEntry, string, n);
        this.proxy.remoteCallMethod((short)24, vCardParserProxy$2);
    }

    @Override
    public void finishParsing(int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)6, genericSerializable);
    }

    @Override
    public void finishExport(int n, int n2) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt32(n);
            genericSerializable.putInt32(n2);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)23, genericSerializable);
    }

    @Override
    public void finishSmallExport(String string, int n) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
            genericSerializable.putInt32(n);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)7, genericSerializable);
    }

    @Override
    public void setBinaryContentTempPath(String string) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putOptionalString(string);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)15, genericSerializable);
    }

    @Override
    public void setBinaryContentQuotaPerFile(long l) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putInt64(l);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)13, genericSerializable);
    }

    @Override
    public void setExtendedAddressHandling(boolean bl) {
        GenericSerializable genericSerializable = new GenericSerializable();
        try {
            genericSerializable.putBool(bl);
        }
        catch (SerializerException serializerException) {
            throw new MethodException(serializerException.getMessage());
        }
        this.proxy.remoteCallMethod((short)28, genericSerializable);
    }
}

