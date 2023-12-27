/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserReply;
import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.AdbEntry;

public class VCardParserReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.asi.organizer.vcardexchange.VCardParser");
    private static int dynamicHandle = 0;
    private VCardParserReply p_VCardParserReply;

    public VCardParserReplyService(VCardParserReply vCardParserReply) {
        super(new ServiceInstanceID("c4084aff-df82-4408-b56c-2aef1da8ec7e", VCardParserReplyService.nextDynamicHandle(), "167912de-3ac1-5a6e-8756-89022777b8bc", "asi.organizer.vcardexchange.VCardParser"));
        this.p_VCardParserReply = vCardParserReply;
    }

    private static synchronized int nextDynamicHandle() {
        int n = ++dynamicHandle;
        return n;
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 27: {
                    int n = iDeserializer.getEnum();
                    AdbEntry adbEntry = AdbEntrySerializer.getOptionalAdbEntry(iDeserializer);
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_VCardParserReply.parseVCardResult(n, adbEntry, n2, n3);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getEnum();
                    AdbEntry[] adbEntryArray = AdbEntrySerializer.getOptionalAdbEntryVarArray(iDeserializer);
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_VCardParserReply.parseVCardDirectoryResult(n, adbEntryArray, n4, n5);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getEnum();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_VCardParserReply.exportVCardResult(n, string, n6);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getEnum();
                    String string = iDeserializer.getOptionalString();
                    int n7 = iDeserializer.getInt32();
                    this.p_VCardParserReply.exportSmallVCardResult(n, string, n7);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    this.p_VCardParserReply.parsingFinished(n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_VCardParserReply.exportFinished(n, n8);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getEnum();
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    int n9 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n10 = iDeserializer.getInt32();
                    this.p_VCardParserReply.smallExportFinished(n, lArray, n9, string, n10);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getEnum();
                    String string = iDeserializer.getOptionalString();
                    this.p_VCardParserReply.setBinaryContentTempPathResult(n, string);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getEnum();
                    long l = iDeserializer.getInt64();
                    this.p_VCardParserReply.setBinaryContentQuotaPerFileResult(n, l);
                    break;
                }
                default: {
                    throw new MethodException(new StringBuffer().append("Invalid Method Id ").append(s).toString());
                }
            }
        }
        catch (SerializerException serializerException) {
            throw new MethodException(new StringBuffer().append("Deserialization failed: method=").append(s).append(", error=").append(serializerException.getMessage()).toString());
        }
    }
}

