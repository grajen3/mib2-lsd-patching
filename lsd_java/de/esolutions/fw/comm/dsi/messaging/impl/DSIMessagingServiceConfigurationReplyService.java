/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.messaging.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.messaging.DSIMessagingServiceConfigurationReply;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;

public class DSIMessagingServiceConfigurationReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.messaging.DSIMessagingServiceConfiguration");
    private static int dynamicHandle = 0;
    private DSIMessagingServiceConfigurationReply p_DSIMessagingServiceConfigurationReply;

    public DSIMessagingServiceConfigurationReplyService(DSIMessagingServiceConfigurationReply dSIMessagingServiceConfigurationReply) {
        super(new ServiceInstanceID("00bb8613-1c87-5188-8f8d-740a594364ca", DSIMessagingServiceConfigurationReplyService.nextDynamicHandle(), "1274017b-42f4-5d28-8978-47f8efc8962f", "dsi.messaging.DSIMessagingServiceConfiguration"));
        this.p_DSIMessagingServiceConfigurationReply = dSIMessagingServiceConfigurationReply;
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
                case 25: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.setSMSCNumberResponse(n);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.activateStoreSmsOnSentResponse(n);
                    break;
                }
                case 27: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.setShortMessageValidityPeriodResponse(n);
                    break;
                }
                case 4: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.activateSMSDeliveryReportResponse(n);
                    break;
                }
                case 34: {
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateSMSCNumber(string, n);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.setPhoneSystemRingingVolumeResponse(n);
                    break;
                }
                case 21: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.setPhoneSystemRingingTypeResponse(n);
                    break;
                }
                case 3: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.activateEmailIncludeOldMailInReplyResponse(n);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.activateEmailEmptySubjectNotificationResponse(n);
                    break;
                }
                case 10: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.changeFolderViewModeResponse(n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.restoreFactorySettingsResponse(n);
                    break;
                }
                case 45: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.responseSetSmsIndications(n);
                    break;
                }
                case 43: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.responseSetEmailIndications(n);
                    break;
                }
                case 44: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.responseSetPushSms(n);
                    break;
                }
                case 36: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateSmsDeliveryReport(bl, n);
                    break;
                }
                case 37: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateStoreSmsOnSent(bl, n);
                    break;
                }
                case 35: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateShortMessageValidityPeriod(n, n2);
                    break;
                }
                case 33: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updatePhoneSystemRingingVolume(n, n3);
                    break;
                }
                case 32: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updatePhoneSystemRingingType(n, n4);
                    break;
                }
                case 30: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateEmailIncludeOldMailInReply(bl, n);
                    break;
                }
                case 29: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateEmailEmptySubjectNotification(bl, n);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateFolderViewMode(n, n5);
                    break;
                }
                case 28: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateAccountPreferences(n, string, n6);
                    break;
                }
                case 48: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateSmsIndications(bl, n);
                    break;
                }
                case 46: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updateEmailIndications(bl, n);
                    break;
                }
                case 47: {
                    boolean bl = iDeserializer.getBool();
                    int n = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.updatePushSms(bl, n);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIMessagingServiceConfigurationReply.asyncException(n, string, n7);
                    break;
                }
                case 38: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIMessagingServiceConfigurationReply.yyIndication(string, string2);
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

