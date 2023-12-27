/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.swdldeviceinfo.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.swdldeviceinfo.DSISwdlDeviceInfoReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSISwdlDeviceInfoReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.swdldeviceinfo.DSISwdlDeviceInfo");
    private static int dynamicHandle = 0;
    private DSISwdlDeviceInfoReply p_DSISwdlDeviceInfoReply;

    public DSISwdlDeviceInfoReplyService(DSISwdlDeviceInfoReply dSISwdlDeviceInfoReply) {
        super(new ServiceInstanceID("36a2e2a5-a8cb-5aa2-88da-885af6a1f6b4", DSISwdlDeviceInfoReplyService.nextDynamicHandle(), "a9fd0f99-b1dc-5a0b-8ea0-ee8ce728ca21", "dsi.swdldeviceinfo.DSISwdlDeviceInfo"));
        this.p_DSISwdlDeviceInfoReply = dSISwdlDeviceInfoReply;
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
                case 34: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlDeviceInfoReply.updateSummaryChanged(string, n);
                    break;
                }
                case 7: {
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSISwdlDeviceInfoReply.getDevices(stringArray, nArray);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    this.p_DSISwdlDeviceInfoReply.getModules(n, stringArray, nArray, sArray);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    short s2 = iDeserializer.getInt16();
                    short s3 = iDeserializer.getInt16();
                    short s4 = iDeserializer.getInt16();
                    this.p_DSISwdlDeviceInfoReply.getLanguages(n, stringArray, s2, s3, s4);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    short[] sArray = iDeserializer.getOptionalInt16VarArray();
                    this.p_DSISwdlDeviceInfoReply.getErrors(n, nArray, sArray);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISwdlDeviceInfoReply.isDataModule(n, n2, bl);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSISwdlDeviceInfoReply.isNoExclusiveBoloUpdate(n, n3, bl);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    this.p_DSISwdlDeviceInfoReply.getVersions(n, n4, lArray);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    long[] lArray = iDeserializer.getOptionalInt64VarArray();
                    this.p_DSISwdlDeviceInfoReply.getTargetVersions(n, n5, lArray);
                    break;
                }
                case 5: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    this.p_DSISwdlDeviceInfoReply.getAdditionalInfo(n, n6, nArray);
                    break;
                }
                case 13: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    String[] stringArray = iDeserializer.getOptionalStringVarArray();
                    this.p_DSISwdlDeviceInfoReply.getFileNames(n, n7, stringArray);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    long l3 = iDeserializer.getInt64();
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSISwdlDeviceInfoReply.getFileDetails(n, n8, n9, l, l2, l3, bl, bl2, string, string2);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSISwdlDeviceInfoReply.getInfoFilePath(n, string, string3);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISwdlDeviceInfoReply.getNumberOfPopups(n);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n11 = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    String string4 = iDeserializer.getOptionalString();
                    this.p_DSISwdlDeviceInfoReply.getPopup(n, n10, string, n11, n12, n13, string4);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSISwdlDeviceInfoReply.asyncException(n, string, n14);
                    break;
                }
                case 35: {
                    String string = iDeserializer.getOptionalString();
                    String string5 = iDeserializer.getOptionalString();
                    this.p_DSISwdlDeviceInfoReply.yyIndication(string, string5);
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

