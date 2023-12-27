/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.media.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.media.DSIMediaBaseReply;
import de.esolutions.fw.comm.dsi.media.impl.DeviceInfoSerializer;
import de.esolutions.fw.comm.dsi.media.impl.MediaInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.media.DeviceInfo;
import org.dsi.ifc.media.MediaInfo;

public class DSIMediaBaseReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.media.DSIMediaBase");
    private static int dynamicHandle = 0;
    private DSIMediaBaseReply p_DSIMediaBaseReply;

    public DSIMediaBaseReplyService(DSIMediaBaseReply dSIMediaBaseReply) {
        super(new ServiceInstanceID("b113ffff-bd42-5cac-8697-cfd388045c9c", DSIMediaBaseReplyService.nextDynamicHandle(), "cb67bc81-5b36-5b17-867c-324a01f573a3", "dsi.media.DSIMediaBase"));
        this.p_DSIMediaBaseReply = dSIMediaBaseReply;
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
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.updateParentalML(n, n2);
                    break;
                }
                case 16: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.updatePreferredLanguage(string, n);
                    break;
                }
                case 27: {
                    MediaInfo[] mediaInfoArray = MediaInfoSerializer.getOptionalMediaInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.updateMediaList(mediaInfoArray, n);
                    break;
                }
                case 13: {
                    DeviceInfo[] deviceInfoArray = DeviceInfoSerializer.getOptionalDeviceInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.updateDeviceList(deviceInfoArray, n);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.updateCustomerUpdate(n, n3);
                    break;
                }
                case 22: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.updateApplicationVersion(string, n);
                    break;
                }
                case 24: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.updateMetadataDBVersion(string, n);
                    break;
                }
                case 6: {
                    int n = iDeserializer.getInt32();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMediaBaseReply.responseResetFactorySettings(n, bl);
                    break;
                }
                case 26: {
                    long l = iDeserializer.getInt64();
                    long l2 = iDeserializer.getInt64();
                    String string = iDeserializer.getOptionalString();
                    boolean bl = iDeserializer.getBool();
                    this.p_DSIMediaBaseReply.launchAppResult(l, l2, string, bl);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.updateProfileState(n, n4, n5);
                    break;
                }
                case 29: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.profileChanged(n, n6);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.profileCopied(n, n7, n8);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.profileReset(n, n9);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIMediaBaseReply.asyncException(n, string, n10);
                    break;
                }
                case 17: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMediaBaseReply.yyIndication(string, string2);
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

