/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbListReply;
import de.esolutions.fw.comm.dsi.organizer.impl.AdbViewSizeSerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.DataSetSerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.IndexInformationSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.AdbViewSize;
import org.dsi.ifc.organizer.DataSet;
import org.dsi.ifc.organizer.IndexInformation;

public class DSIAdbListReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.organizer.DSIAdbList");
    private static int dynamicHandle = 0;
    private DSIAdbListReply p_DSIAdbListReply;

    public DSIAdbListReplyService(DSIAdbListReply dSIAdbListReply) {
        super(new ServiceInstanceID("42dbbcd2-3ea6-5bd5-bf1c-1688f4fb8458", DSIAdbListReplyService.nextDynamicHandle(), "1f064d36-4f05-57d2-af73-a3c0a190b478", "dsi.organizer.DSIAdbList"));
        this.p_DSIAdbListReply = dSIAdbListReply;
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
                case 32: {
                    AdbViewSize adbViewSize = AdbViewSizeSerializer.getOptionalAdbViewSize(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbListReply.updateViewSize(adbViewSize, n);
                    break;
                }
                case 18: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbListReply.invalidData(n);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAdbListReply.stopSpellerResult(n, n2);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    DataSet[] dataSetArray = DataSetSerializer.getOptionalDataSetVarArray(iDeserializer);
                    int n4 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAdbListReply.spellerResult(n, n3, dataSetArray, n4, string, string2);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSIAdbListReply.validateSpellerCharsResult(n, n5, string, string3);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    DataSet[] dataSetArray = DataSetSerializer.getOptionalDataSetVarArray(iDeserializer);
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIAdbListReply.getViewWindowResult(n, dataSetArray, n6);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    DataSet[] dataSetArray = DataSetSerializer.getOptionalDataSetVarArray(iDeserializer);
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIAdbListReply.getSpellerViewWindowResult(n, n7, dataSetArray, n8);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIAdbListReply.getValidHanziCharsWindowResult(n, n9, n10, string, n11);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbListReply.setListStyleResult(n);
                    break;
                }
                case 33: {
                    IndexInformation[] indexInformationArray = IndexInformationSerializer.getOptionalIndexInformationVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbListReply.updateAlphabeticalIndex(indexInformationArray, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSIAdbListReply.asyncException(n, string, n12);
                    break;
                }
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    String string4 = iDeserializer.getOptionalString();
                    this.p_DSIAdbListReply.yyIndication(string, string4);
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

