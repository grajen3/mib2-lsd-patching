/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.sdars.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.DateTimeSerializer;
import de.esolutions.fw.comm.dsi.sdars.DSISDARSTunerReply;
import de.esolutions.fw.comm.dsi.sdars.impl.CategoryInfoSerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.EPGDescriptionSerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.EPGShortInfoSerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.ImageInformationSerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.RadioTextSerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.ServiceStatus3Serializer;
import de.esolutions.fw.comm.dsi.sdars.impl.SignalQualitySerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.StationDescriptionSerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.StationInfoSerializer;
import de.esolutions.fw.comm.dsi.sdars.impl.SubscriptionStatusSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.sdars.CategoryInfo;
import org.dsi.ifc.sdars.EPGDescription;
import org.dsi.ifc.sdars.EPGShortInfo;
import org.dsi.ifc.sdars.ImageInformation;
import org.dsi.ifc.sdars.RadioText;
import org.dsi.ifc.sdars.ServiceStatus3;
import org.dsi.ifc.sdars.SignalQuality;
import org.dsi.ifc.sdars.StationDescription;
import org.dsi.ifc.sdars.StationInfo;
import org.dsi.ifc.sdars.SubscriptionStatus;

public class DSISDARSTunerReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.sdars.DSISDARSTuner");
    private static int dynamicHandle = 0;
    private DSISDARSTunerReply p_DSISDARSTunerReply;

    public DSISDARSTunerReplyService(DSISDARSTunerReply dSISDARSTunerReply) {
        super(new ServiceInstanceID("9513adb3-74d0-5976-8f10-298e5e449901", DSISDARSTunerReplyService.nextDynamicHandle(), "54f1a5de-eaca-5072-8ab7-8bc249d76713", "dsi.sdars.DSISDARSTuner"));
        this.p_DSISDARSTunerReply = dSISDARSTunerReply;
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
                    String string = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateElectronicSerialCode(string, n);
                    break;
                }
                case 26: {
                    ServiceStatus3 serviceStatus3 = ServiceStatus3Serializer.getOptionalServiceStatus3(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateServiceStatus3(serviceStatus3, n);
                    break;
                }
                case 19: {
                    SignalQuality signalQuality = SignalQualitySerializer.getOptionalSignalQuality(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateSignalQuality(signalQuality, n);
                    break;
                }
                case 17: {
                    StationInfo stationInfo = StationInfoSerializer.getOptionalStationInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateSelectedStation(stationInfo, n);
                    break;
                }
                case 22: {
                    StationInfo[] stationInfoArray = StationInfoSerializer.getOptionalStationInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateStationList(stationInfoArray, n);
                    break;
                }
                case 13: {
                    CategoryInfo[] categoryInfoArray = CategoryInfoSerializer.getOptionalCategoryInfoVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateCategoryList(categoryInfoArray, n);
                    break;
                }
                case 45: {
                    RadioText radioText = RadioTextSerializer.getOptionalRadioText(iDeserializer);
                    this.p_DSISDARSTunerReply.informationRadioText(radioText);
                    break;
                }
                case 44: {
                    RadioText[] radioTextArray = RadioTextSerializer.getOptionalRadioTextVarArray(iDeserializer);
                    this.p_DSISDARSTunerReply.informationRadioText2(radioTextArray);
                    break;
                }
                case 20: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateStaticTaggingInfo(string, string2, n);
                    break;
                }
                case 14: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateDetectedDevice(n, n2);
                    break;
                }
                case 8: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.selectStationStatus(n);
                    break;
                }
                case 6: {
                    DateTime dateTime = DateTimeSerializer.getOptionalDateTime(iDeserializer);
                    this.p_DSISDARSTunerReply.responseTime(dateTime);
                    break;
                }
                case 41: {
                    EPGShortInfo ePGShortInfo = EPGShortInfoSerializer.getOptionalEPGShortInfo(iDeserializer);
                    this.p_DSISDARSTunerReply.responseEPG24Hour(ePGShortInfo);
                    break;
                }
                case 42: {
                    EPGDescription ePGDescription = EPGDescriptionSerializer.getOptionalEPGDescription(iDeserializer);
                    this.p_DSISDARSTunerReply.responseEPGDescription(ePGDescription);
                    break;
                }
                case 12: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateAvailability(n, n3);
                    break;
                }
                case 21: {
                    StationDescription[] stationDescriptionArray = StationDescriptionSerializer.getOptionalStationDescriptionVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateStationDescription(stationDescriptionArray, n);
                    break;
                }
                case 25: {
                    SubscriptionStatus subscriptionStatus = SubscriptionStatusSerializer.getOptionalSubscriptionStatus(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateSubscriptionStatus(subscriptionStatus, n);
                    break;
                }
                case 36: {
                    EPGShortInfo[] ePGShortInfoArray = EPGShortInfoSerializer.getOptionalEPGShortInfoVarArray(iDeserializer);
                    this.p_DSISDARSTunerReply.informationEPGChannelList(ePGShortInfoArray);
                    break;
                }
                case 35: {
                    ImageInformation[] imageInformationArray = ImageInformationSerializer.getOptionalImageInformationVarArray(iDeserializer);
                    this.p_DSISDARSTunerReply.informationChannelArt(imageInformationArray);
                    break;
                }
                case 34: {
                    ImageInformation[] imageInformationArray = ImageInformationSerializer.getOptionalImageInformationVarArray(iDeserializer);
                    this.p_DSISDARSTunerReply.informationBackgroundArt(imageInformationArray);
                    break;
                }
                case 33: {
                    ImageInformation[] imageInformationArray = ImageInformationSerializer.getOptionalImageInformationVarArray(iDeserializer);
                    this.p_DSISDARSTunerReply.informationAlbumArt(imageInformationArray);
                    break;
                }
                case 37: {
                    ImageInformation[] imageInformationArray = ImageInformationSerializer.getOptionalImageInformationVarArray(iDeserializer);
                    this.p_DSISDARSTunerReply.informationGenreArt(imageInformationArray);
                    break;
                }
                case 40: {
                    ImageInformation[] imageInformationArray = ImageInformationSerializer.getOptionalImageInformationVarArray(iDeserializer);
                    this.p_DSISDARSTunerReply.informationStudioArt(imageInformationArray);
                    break;
                }
                case 54: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.updateProfileState(n, n4, n5);
                    break;
                }
                case 47: {
                    int n = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.profileChanged(n, n6);
                    break;
                }
                case 48: {
                    int n = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.profileCopied(n, n7, n8);
                    break;
                }
                case 51: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.profileReset(n, n9);
                    break;
                }
                case 53: {
                    int n = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSISDARSTunerReply.asyncException(n, string, n10);
                    break;
                }
                case 23: {
                    String string = iDeserializer.getOptionalString();
                    String string3 = iDeserializer.getOptionalString();
                    this.p_DSISDARSTunerReply.yyIndication(string, string3);
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

