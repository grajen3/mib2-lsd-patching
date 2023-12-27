/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.organizer.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.organizer.DSIAdbUserProfileReply;
import de.esolutions.fw.comm.dsi.organizer.impl.DownloadInfoSerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.EntryMeterSerializer;
import de.esolutions.fw.comm.dsi.organizer.impl.ProfileInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.organizer.DownloadInfo;
import org.dsi.ifc.organizer.EntryMeter;
import org.dsi.ifc.organizer.ProfileInfo;

public class DSIAdbUserProfileReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.organizer.DSIAdbUserProfile");
    private static int dynamicHandle = 0;
    private DSIAdbUserProfileReply p_DSIAdbUserProfileReply;

    public DSIAdbUserProfileReplyService(DSIAdbUserProfileReply dSIAdbUserProfileReply) {
        super(new ServiceInstanceID("5600e882-32bc-5962-bf4b-6c7c42e96b5b", DSIAdbUserProfileReplyService.nextDynamicHandle(), "087275ce-30fb-5962-9609-c69d8e3875d9", "dsi.organizer.DSIAdbUserProfile"));
        this.p_DSIAdbUserProfileReply = dSIAdbUserProfileReply;
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
                    ProfileInfo[] profileInfoArray = ProfileInfoSerializer.getOptionalProfileInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.updateProfileInfo(profileInfoArray, n, n2);
                    break;
                }
                case 27: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.updateDeviceConnected(bl, n);
                    break;
                }
                case 31: {
                    DownloadInfo downloadInfo = DownloadInfoSerializer.getOptionalDownloadInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.updateDownloadCountSim(downloadInfo, n);
                    break;
                }
                case 29: {
                    DownloadInfo downloadInfo = DownloadInfoSerializer.getOptionalDownloadInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.updateDownloadCountMe(downloadInfo, n);
                    break;
                }
                case 30: {
                    DownloadInfo downloadInfo = DownloadInfoSerializer.getOptionalDownloadInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.updateDownloadCountOpp(downloadInfo, n);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.updateDownloadState(n, n3, n4);
                    break;
                }
                case 21: {
                    String string = iDeserializer.getOptionalString();
                    this.p_DSIAdbUserProfileReply.newDeviceConnected(string);
                    break;
                }
                case 19: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.downloadToProfileResult(n);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.restartDownloadResult(n);
                    break;
                }
                case 22: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.profileDeleted(n);
                    break;
                }
                case 26: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.setProfileNameResult(n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.deleteProfilesResult(n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.commonEntryCountResult(n, n5);
                    break;
                }
                case 20: {
                    int n = iDeserializer.getInt32();
                    EntryMeter[] entryMeterArray = EntryMeterSerializer.getOptionalEntryMeterVarArray(iDeserializer);
                    this.p_DSIAdbUserProfileReply.entryMeterResult(n, entryMeterArray);
                    break;
                }
                case 25: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.setPairingCodeResult(n);
                    break;
                }
                case 24: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.setHomeIdResult(n);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.updateDownloadState2ndPhone(n, n6, n7);
                    break;
                }
                case 37: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.setSOSButtonResult(n);
                    break;
                }
                case 38: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.updateSOSButton(bl, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIAdbUserProfileReply.asyncException(n, string, n8);
                    break;
                }
                case 33: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIAdbUserProfileReply.yyIndication(string, string2);
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

