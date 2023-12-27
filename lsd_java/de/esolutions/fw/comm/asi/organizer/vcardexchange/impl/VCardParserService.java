/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.organizer.vcardexchange.impl;

import de.esolutions.fw.comm.asi.organizer.vcardexchange.VCardParserS;
import de.esolutions.fw.comm.asi.organizer.vcardexchange.impl.VCardParserReplyProxy;
import de.esolutions.fw.comm.core.AbstractService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.AdbEntry;

public class VCardParserService
extends AbstractService {
    private static final CallContext context = CallContext.getContext("STUB.asi.organizer.vcardexchange.VCardParser");
    private VCardParserS p_VCardParser;

    public VCardParserService(int n, VCardParserS vCardParserS) {
        super(new ServiceInstanceID("ac51e9cb-58ff-4a94-82b2-348bedfdc513", n, "4d2de5a1-2ec1-5014-915d-ced43ea78aaf", "asi.organizer.vcardexchange.VCardParser"));
        this.p_VCardParser = vCardParserS;
    }

    @Override
    public IProxyFrontend createReplyProxy() {
        return new VCardParserReplyProxy();
    }

    @Override
    public CallContext getCallContext() {
        return context;
    }

    @Override
    public void handleCallMethod(short s, IDeserializer iDeserializer, IProxyFrontend iProxyFrontend) {
        try {
            switch (s) {
                case 18: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_VCardParser.parseVCard(string, n, n2, (VCardParserReplyProxy)iProxyFrontend);
                    break;
                }
                case 19: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_VCardParser.parseVCardDirectory(string, n, n3, (VCardParserReplyProxy)iProxyFrontend);
                    break;
                }
                case 25: {
                    AdbEntry adbEntry = AdbEntrySerializer.getOptionalAdbEntry(iDeserializer);
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_VCardParser.exportVCard(adbEntry, string, n, (VCardParserReplyProxy)iProxyFrontend);
                    break;
                }
                case 24: {
                    AdbEntry adbEntry = AdbEntrySerializer.getOptionalAdbEntry(iDeserializer);
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_VCardParser.exportSmallVCard(adbEntry, string, n, (VCardParserReplyProxy)iProxyFrontend);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    this.p_VCardParser.finishParsing(n, (VCardParserReplyProxy)iProxyFrontend);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_VCardParser.finishExport(n, n4, (VCardParserReplyProxy)iProxyFrontend);
                    break;
                }
                case 7: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_VCardParser.finishSmallExport(string, n, (VCardParserReplyProxy)iProxyFrontend);
                    break;
                }
                case 15: {
                    String string = iDeserializer.getOptionalString();
                    this.p_VCardParser.setBinaryContentTempPath(string, (VCardParserReplyProxy)iProxyFrontend);
                    break;
                }
                case 13: {
                    long l = iDeserializer.getInt64();
                    this.p_VCardParser.setBinaryContentQuotaPerFile(l, (VCardParserReplyProxy)iProxyFrontend);
                    break;
                }
                case 28: {
                    boolean bl = iDeserializer.getBool();
                    this.p_VCardParser.setExtendedAddressHandling(bl, (VCardParserReplyProxy)iProxyFrontend);
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

