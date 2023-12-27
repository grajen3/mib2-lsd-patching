/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.radiodata.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.ResourceLocatorSerializer;
import de.esolutions.fw.comm.dsi.radiodata.DSIRadioDataReply;
import de.esolutions.fw.comm.dsi.radiodata.impl.CountryRegionDataSerializer;
import de.esolutions.fw.comm.dsi.radiodata.impl.CountryRegionTranslationDataSerializer;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationDataResponseSerializer;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationDataSerializer;
import de.esolutions.fw.comm.dsi.radiodata.impl.RadioStationLogoResponseSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class DSIRadioDataReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.radiodata.DSIRadioData");
    private static int dynamicHandle = 0;
    private DSIRadioDataReply p_DSIRadioDataReply;

    public DSIRadioDataReplyService(DSIRadioDataReply dSIRadioDataReply) {
        super(new ServiceInstanceID("33a6fa68-c4fd-555f-9b16-c2504d731c26", DSIRadioDataReplyService.nextDynamicHandle(), "d5d3a20b-9acf-575b-8821-250c27f4e1be", "dsi.radiodata.DSIRadioData"));
        this.p_DSIRadioDataReply = dSIRadioDataReply;
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
                case 18: {
                    RadioStationDataResponse[] radioStationDataResponseArray = RadioStationDataResponseSerializer.getOptionalRadioStationDataResponseVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.responseRadioStationData(radioStationDataResponseArray, n);
                    break;
                }
                case 19: {
                    RadioStationLogoResponse[] radioStationLogoResponseArray = RadioStationLogoResponseSerializer.getOptionalRadioStationLogoResponseVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.responseRadioStationLogos(radioStationLogoResponseArray, n);
                    break;
                }
                case 16: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.responseDynamicDatabaseAlteration(n, n2);
                    break;
                }
                case 12: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.responseCountryList(nArray, n);
                    break;
                }
                case 15: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    int n6 = iDeserializer.getInt32();
                    int n7 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.responseDatabaseVersionInfo(n, n3, n4, string, n5, n6, n7);
                    break;
                }
                case 23: {
                    int n = iDeserializer.getInt32();
                    int n8 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.updateDatabaseState(n, n8);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    int n9 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.responsePersistStationLogos(n, n9);
                    break;
                }
                case 24: {
                    RadioStationLogoResponse[] radioStationLogoResponseArray = RadioStationLogoResponseSerializer.getOptionalRadioStationLogoResponseVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.updateRadioStationLogos(radioStationLogoResponseArray, n);
                    break;
                }
                case 27: {
                    CountryRegionData[] countryRegionDataArray = CountryRegionDataSerializer.getOptionalCountryRegionDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.responseCountryRegionData(countryRegionDataArray, n);
                    break;
                }
                case 14: {
                    CountryRegionTranslationData[] countryRegionTranslationDataArray = CountryRegionTranslationDataSerializer.getOptionalCountryRegionTranslationDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.responseCountryRegionTranslationData(countryRegionTranslationDataArray, n);
                    break;
                }
                case 28: {
                    RadioStationData[] radioStationDataArray = RadioStationDataSerializer.getOptionalRadioStationDataVarArray(iDeserializer);
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n10 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.responsePersistStationLogosWithChangedUrls(radioStationDataArray, resourceLocatorArray, n, n10);
                    break;
                }
                case 37: {
                    RadioStationData[] radioStationDataArray = RadioStationDataSerializer.getOptionalRadioStationDataVarArray(iDeserializer);
                    ResourceLocator[] resourceLocatorArray = ResourceLocatorSerializer.getOptionalResourceLocatorVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    int n11 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.updatePersistStationLogosWithChangedUrls(radioStationDataArray, resourceLocatorArray, n, n11);
                    break;
                }
                case 38: {
                    int n = iDeserializer.getInt32();
                    int n12 = iDeserializer.getInt32();
                    int n13 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.updateProfileState(n, n12, n13);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n14 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.profileChanged(n, n14);
                    break;
                }
                case 31: {
                    int n = iDeserializer.getInt32();
                    int n15 = iDeserializer.getInt32();
                    int n16 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.profileCopied(n, n15, n16);
                    break;
                }
                case 34: {
                    int n = iDeserializer.getInt32();
                    int n17 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.profileReset(n, n17);
                    break;
                }
                case 36: {
                    int n = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.profileResetAll(n);
                    break;
                }
                case 0: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n18 = iDeserializer.getInt32();
                    this.p_DSIRadioDataReply.asyncException(n, string, n18);
                    break;
                }
                case 25: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSIRadioDataReply.yyIndication(string, string2);
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

