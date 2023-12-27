/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbVCardExchangeReply;
import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.DownloadInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DownloadInfo;

public class DSIAdbVCardExchangeReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.organizer.DSIAdbVCardExchange");
    private static int dynamicHandle = 0;
    private DSIAdbVCardExchangeReply p_DSIAdbVCardExchangeReply;

    public DSIAdbVCardExchangeReplyService(DSIAdbVCardExchangeReply dSIAdbVCardExchangeReply) {
        super(new ServiceInstanceID("652febaf-81ba-5aba-890b-6fa0da6c390d", DSIAdbVCardExchangeReplyService.nextDynamicHandle(), "8eb87df5-6b8c-54e8-9d1e-dbfd4bda2e56", "dsi.organizer.DSIAdbVCardExchange"));
        this.p_DSIAdbVCardExchangeReply = dSIAdbVCardExchangeReply;
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
                case 21: {
                    DownloadInfo downloadInfo = DownloadInfoSerializer.getOptionalDownloadInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbVCardExchangeReply.updateExportCount(downloadInfo, n);
                    break;
                }
                case 22: {
                    DownloadInfo downloadInfo = DownloadInfoSerializer.getOptionalDownloadInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbVCardExchangeReply.updateImportCount(downloadInfo, n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAdbVCardExchangeReply.importVCardResult(n, n2, n3, n4);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIAdbVCardExchangeReply.exportVCardResult(n, n5, n6, n7);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIAdbVCardExchangeReply.exportSpellerVCardResult(n, n8, n9, n10, n11);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    int n12 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIAdbVCardExchangeReply.createVCardResult(n, lArray, n12, string);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    AdbEntry[] adbEntryArray = AdbEntrySerializer.getOptionalAdbEntryVarArray(iDeserializer);
                    this.p_DSIAdbVCardExchangeReply.parseVCardResult(n, adbEntryArray);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbVCardExchangeReply.responseAbort(n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIAdbVCardExchangeReply.asyncException(n, string, n13);
                    break;
                }
                case 26: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAdbVCardExchangeReply.yyIndication(string, string2);
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

