/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tvtuner.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.tvtuner.DSITVTunerReply;
import de.esolutions.fw.comm.dsi.tvtuner.impl.EWSInfoSerializer;
import de.esolutions.fw.comm.dsi.tvtuner.impl.LogoInfoSerializer;
import de.esolutions.fw.comm.dsi.tvtuner.impl.ProgramInfoSerializer;
import de.esolutions.fw.comm.dsi.tvtuner.impl.ServiceInfoSerializer;
import de.esolutions.fw.comm.dsi.tvtuner.impl.StartUpConfigSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.tvtuner.EWSInfo;
import org.dsi.ifc.tvtuner.LogoInfo;
import org.dsi.ifc.tvtuner.ProgramInfo;
import org.dsi.ifc.tvtuner.ServiceInfo;
import org.dsi.ifc.tvtuner.StartUpConfig;

public class DSITVTunerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.tvtuner.DSITVTuner");
    private static int dynamicHandle = 0;
    private DSITVTunerReply p_DSITVTunerReply;

    public DSITVTunerReplyService(DSITVTunerReply dSITVTunerReply) {
        super(new ServiceInstanceID("55ca38d6-fce7-5ad2-96b8-4c9782919cbd", DSITVTunerReplyService.nextDynamicHandle(), "39bf8fe7-5332-5d83-8e46-56d7b46ebd67", "dsi.tvtuner.DSITVTuner"));
        this.p_DSITVTunerReply = dSITVTunerReply;
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
                case 45: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateTunerState(n, n2);
                    break;
                }
                case 36: {
                    ServiceInfo[] serviceInfoArray = ServiceInfoSerializer.getOptionalServiceInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateServiceList(serviceInfoArray, n);
                    break;
                }
                case 53: {
                    ProgramInfo programInfo = ProgramInfoSerializer.getOptionalProgramInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateSelectedService(programInfo, n);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateSelectedSource(n, n3);
                    break;
                }
                case 40: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateTVNormArea(n, n4);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateAudioChannel(n, n5);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateMuteState(n, n6);
                    break;
                }
                case 29: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateInfoTextState(string, n);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateTerminalMode(n, n7, n8);
                    break;
                }
                case 35: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateServiceLinking(bl, n);
                    break;
                }
                case 42: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateTVNormList(nArray, n);
                    break;
                }
                case 41: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateTVNormAreaSubList(nArray, n);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateAVNorm(n, n9);
                    break;
                }
                case 55: {
                    EWSInfo[] eWSInfoArray = EWSInfoSerializer.getOptionalEWSInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateEWSInfoList(eWSInfoArray, n);
                    break;
                }
                case 11: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.selectService(n);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.selectNextService(n);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.abortSeek(n);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.switchSource(n);
                    break;
                }
                case 38: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateSubtitle(bl, n);
                    break;
                }
                case 30: {
                    LogoInfo[] logoInfoArray = LogoInfoSerializer.getOptionalLogoInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateLogoList(logoInfoArray, n);
                    break;
                }
                case 27: {
                    boolean bl = iDeserializer.getBool();
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateCASInfo(bl, string, n);
                    break;
                }
                case 44: {
                    boolean bl = iDeserializer.getBool();
                    boolean bl2 = iDeserializer.getBool();
                    boolean bl3 = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateTuneStatus(bl, bl2, bl3, n);
                    break;
                }
                case 50: {
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateMessageService(n, n10);
                    break;
                }
                case 51: {
                    StartUpConfig startUpConfig = StartUpConfigSerializer.getOptionalStartUpConfig(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateStartUpMUConfig(startUpConfig, n);
                    break;
                }
                case 39: {
                    short s2 = iDeserializer.getInt16();
                    short s3 = iDeserializer.getInt16();
                    int n = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateTMTVKeyPanel(s2, s3, n);
                    break;
                }
                case 49: {
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.updateBrowserListSort(n, n11);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n12 = iDeserializer.getInt32();
                    this.p_DSITVTunerReply.asyncException(n, string, n12);
                    break;
                }
                case 46: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITVTunerReply.yyIndication(string, string2);
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

