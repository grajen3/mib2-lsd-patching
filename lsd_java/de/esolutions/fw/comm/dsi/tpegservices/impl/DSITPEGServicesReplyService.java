/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.dsi.tpegservices.impl;

import de.esolutions.fw.comm.core.AbstractReplyService;
import de.esolutions.fw.comm.core.CallContext;
import de.esolutions.fw.comm.core.IProxyFrontend;
import de.esolutions.fw.comm.core.ServiceInstanceID;
import de.esolutions.fw.comm.core.method.MethodException;
import de.esolutions.fw.comm.dsi.global.impl.NavLocationSerializer;
import de.esolutions.fw.comm.dsi.tpegservices.DSITPEGServicesReply;
import de.esolutions.fw.comm.dsi.tpegservices.impl.FuelPriceInformationSerializer;
import de.esolutions.fw.comm.dsi.tpegservices.impl.NewsCategorySerializer;
import de.esolutions.fw.comm.dsi.tpegservices.impl.ResourceInformationSerializer;
import de.esolutions.fw.comm.dsi.tpegservices.impl.SimpleMapDataSerializer;
import de.esolutions.fw.comm.dsi.tpegservices.impl.WeatherInfoSerializer;
import de.esolutions.fw.util.serializer.IDeserializer;
import de.esolutions.fw.util.serializer.exception.SerializerException;
import org.dsi.ifc.global.NavLocation;
import org.dsi.ifc.tpegservices.FuelPriceInformation;
import org.dsi.ifc.tpegservices.NewsCategory;
import org.dsi.ifc.tpegservices.ResourceInformation;
import org.dsi.ifc.tpegservices.SimpleMapData;
import org.dsi.ifc.tpegservices.WeatherInfo;

public class DSITPEGServicesReplyService
extends AbstractReplyService {
    private static final CallContext context = CallContext.getContext("STUB.dsi.tpegservices.DSITPEGServices");
    private static int dynamicHandle = 0;
    private DSITPEGServicesReply p_DSITPEGServicesReply;

    public DSITPEGServicesReplyService(DSITPEGServicesReply dSITPEGServicesReply) {
        super(new ServiceInstanceID("df2bcc79-5aca-58de-9890-11936aa66c5b", DSITPEGServicesReplyService.nextDynamicHandle(), "38b87564-71b1-5f7e-8a45-5e821f7bee7c", "dsi.tpegservices.DSITPEGServices"));
        this.p_DSITPEGServicesReply = dSITPEGServicesReply;
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
                case 27: {
                    int[] nArray = iDeserializer.getOptionalInt32VarArray();
                    int n = iDeserializer.getInt32();
                    this.p_DSITPEGServicesReply.updateTPEGContentAvailability(nArray, n);
                    break;
                }
                case 31: {
                    SimpleMapData[] simpleMapDataArray = SimpleMapDataSerializer.getOptionalSimpleMapDataVarArray(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITPEGServicesReply.updateSimpleMapsBookmarks(simpleMapDataArray, n);
                    break;
                }
                case 13: {
                    NavLocation navLocation = NavLocationSerializer.getOptionalNavLocation(iDeserializer);
                    this.p_DSITPEGServicesReply.requestLocationDetailsResponse(navLocation);
                    break;
                }
                case 11: {
                    FuelPriceInformation[] fuelPriceInformationArray = FuelPriceInformationSerializer.getOptionalFuelPriceInformationVarArray(iDeserializer);
                    this.p_DSITPEGServicesReply.requestFuelPriceInformationResponse(fuelPriceInformationArray);
                    break;
                }
                case 15: {
                    NewsCategory newsCategory = NewsCategorySerializer.getOptionalNewsCategory(iDeserializer);
                    this.p_DSITPEGServicesReply.requestNewsInformationResponse(newsCategory);
                    break;
                }
                case 30: {
                    int n = iDeserializer.getInt32();
                    int n2 = iDeserializer.getInt32();
                    SimpleMapData[] simpleMapDataArray = SimpleMapDataSerializer.getOptionalSimpleMapDataVarArray(iDeserializer);
                    this.p_DSITPEGServicesReply.requestSimpleMapListResponse(n, n2, simpleMapDataArray);
                    break;
                }
                case 1: {
                    int n = iDeserializer.getInt32();
                    int n3 = iDeserializer.getInt32();
                    this.p_DSITPEGServicesReply.addSimpleMapBookmarkResult(n, n3);
                    break;
                }
                case 9: {
                    int n = iDeserializer.getInt32();
                    int n4 = iDeserializer.getInt32();
                    this.p_DSITPEGServicesReply.deleteSimpleMapBookmarkResult(n, n4);
                    break;
                }
                case 7: {
                    int n = iDeserializer.getInt32();
                    this.p_DSITPEGServicesReply.deleteAllSimpleMapBookmarksResult(n);
                    break;
                }
                case 17: {
                    int n = iDeserializer.getInt32();
                    ResourceInformation resourceInformation = ResourceInformationSerializer.getOptionalResourceInformation(iDeserializer);
                    this.p_DSITPEGServicesReply.requestResourceInformationResponse(n, resourceInformation);
                    break;
                }
                case 22: {
                    boolean bl = iDeserializer.getBool();
                    this.p_DSITPEGServicesReply.setLanguageResponse(bl);
                    break;
                }
                case 33: {
                    WeatherInfo weatherInfo = WeatherInfoSerializer.getOptionalWeatherInfo(iDeserializer);
                    int n = iDeserializer.getInt32();
                    this.p_DSITPEGServicesReply.requestWeatherInfoResult(weatherInfo, n);
                    break;
                }
                case 2: {
                    int n = iDeserializer.getInt32();
                    String string = iDeserializer.getOptionalString();
                    int n5 = iDeserializer.getInt32();
                    this.p_DSITPEGServicesReply.asyncException(n, string, n5);
                    break;
                }
                case 28: {
                    String string = iDeserializer.getOptionalString();
                    String string2 = iDeserializer.getOptionalString();
                    this.p_DSITPEGServicesReply.yyIndication(string, string2);
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

