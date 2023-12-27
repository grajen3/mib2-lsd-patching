/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbEditReply;
import de.esolutions.fw.comm.dsi.organizer.impl.AdbEntrySerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.DataSetSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.AdbEntry;
import org.dsi.ifc.organizer.DataSet;

public class DSIAdbEditReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.organizer.DSIAdbEdit");
    private static int dynamicHandle = 0;
    private DSIAdbEditReply p_DSIAdbEditReply;

    public DSIAdbEditReplyService(DSIAdbEditReply dSIAdbEditReply) {
        super(new ServiceInstanceID("f0118e22-e5d7-5253-aeb9-0a19a9bcd4a4", DSIAdbEditReplyService.nextDynamicHandle(), "1fed00ad-7bf5-5ffc-850d-591deb7037aa", "dsi.organizer.DSIAdbEdit"));
        this.p_DSIAdbEditReply = dSIAdbEditReply;
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
                case 29: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbEditReply.updateNewEntryAvailable(bl, n);
                    break;
                }
                case 30: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbEditReply.updateNewPublicProfileEntryAvailable(bl, n);
                    break;
                }
                case 32: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbEditReply.updateNewTopDestinationEntryAvailable(bl, n);
                    break;
                }
                case 31: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbEditReply.updateNewPublicProfileTopDestEntryAvailable(bl, n);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    AdbEntry adbEntry = AdbEntrySerializer.getOptionalAdbEntry(iDeserializer);
                    this.p_DSIAdbEditReply.insertEntryResult(n, adbEntry);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    AdbEntry[] adbEntryArray = AdbEntrySerializer.getOptionalAdbEntryVarArray(iDeserializer);
                    this.p_DSIAdbEditReply.getEntriesResult(n, adbEntryArray);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    DataSet[] dataSetArray = DataSetSerializer.getOptionalDataSetVarArray(iDeserializer);
                    this.p_DSIAdbEditReply.getEntryDataSetsResult(n, dataSetArray);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    AdbEntry adbEntry = AdbEntrySerializer.getOptionalAdbEntry(iDeserializer);
                    this.p_DSIAdbEditReply.changeEntryResult(n, adbEntry);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    AdbEntry adbEntry = AdbEntrySerializer.getOptionalAdbEntry(iDeserializer);
                    this.p_DSIAdbEditReply.copyEntryResult(n, adbEntry);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbEditReply.deleteEntriesResult(n);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbEditReply.setSpeedDialResult(n);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbEditReply.deleteSpeedDialResult(n);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    AdbEntry adbEntry = AdbEntrySerializer.getOptionalAdbEntry(iDeserializer);
                    this.p_DSIAdbEditReply.getEntryByReferenceIdResult(n, adbEntry);
                    break;
                }
                case 35: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbEditReply.updateNewOnlineDestinationEntryAvailable(bl, n);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAdbEditReply.asyncException(n, string, n2);
                    break;
                }
                case 33: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAdbEditReply.yyIndication(string, string2);
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

