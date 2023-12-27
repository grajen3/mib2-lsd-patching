/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.dsi.trace.optimized.internal.generated.dsi.radiodata;

import de.vw.mib.dsi.trace.optimized.internal.AbstractOptimzedDSIObjectTracer;
import java.io.PrintWriter;
import org.dsi.ifc.radiodata.CountryRegionData;
import org.dsi.ifc.radiodata.CountryRegionTranslationData;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationDataResponse;
import org.dsi.ifc.radiodata.RadioStationLogoRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public final class DSIRadioDataTracer
extends AbstractOptimzedDSIObjectTracer {
    private static final int ID_COUNTRYREGIONDATA;
    private static final int ID_COUNTRYREGIONTRANSLATIONDATA;
    private static final int ID_RADIOSTATIONDATA;
    private static final int ID_RADIOSTATIONDATAREQUEST;
    private static final int ID_RADIOSTATIONDATARESPONSE;
    private static final int ID_RADIOSTATIONLOGOREQUEST;
    private static final int ID_RADIOSTATIONLOGORESPONSE;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$CountryRegionData;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$CountryRegionTranslationData;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$RadioStationData;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$RadioStationDataRequest;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$RadioStationDataResponse;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$RadioStationLogoRequest;
    static /* synthetic */ Class class$org$dsi$ifc$radiodata$RadioStationLogoResponse;

    public DSIRadioDataTracer() {
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radiodata$CountryRegionData == null ? (class$org$dsi$ifc$radiodata$CountryRegionData = DSIRadioDataTracer.class$("org.dsi.ifc.radiodata.CountryRegionData")) : class$org$dsi$ifc$radiodata$CountryRegionData, 1);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radiodata$CountryRegionTranslationData == null ? (class$org$dsi$ifc$radiodata$CountryRegionTranslationData = DSIRadioDataTracer.class$("org.dsi.ifc.radiodata.CountryRegionTranslationData")) : class$org$dsi$ifc$radiodata$CountryRegionTranslationData, 2);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radiodata$RadioStationData == null ? (class$org$dsi$ifc$radiodata$RadioStationData = DSIRadioDataTracer.class$("org.dsi.ifc.radiodata.RadioStationData")) : class$org$dsi$ifc$radiodata$RadioStationData, 3);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radiodata$RadioStationDataRequest == null ? (class$org$dsi$ifc$radiodata$RadioStationDataRequest = DSIRadioDataTracer.class$("org.dsi.ifc.radiodata.RadioStationDataRequest")) : class$org$dsi$ifc$radiodata$RadioStationDataRequest, 4);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radiodata$RadioStationDataResponse == null ? (class$org$dsi$ifc$radiodata$RadioStationDataResponse = DSIRadioDataTracer.class$("org.dsi.ifc.radiodata.RadioStationDataResponse")) : class$org$dsi$ifc$radiodata$RadioStationDataResponse, 5);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radiodata$RadioStationLogoRequest == null ? (class$org$dsi$ifc$radiodata$RadioStationLogoRequest = DSIRadioDataTracer.class$("org.dsi.ifc.radiodata.RadioStationLogoRequest")) : class$org$dsi$ifc$radiodata$RadioStationLogoRequest, 6);
        this.registerDSIDatacontainerID(class$org$dsi$ifc$radiodata$RadioStationLogoResponse == null ? (class$org$dsi$ifc$radiodata$RadioStationLogoResponse = DSIRadioDataTracer.class$("org.dsi.ifc.radiodata.RadioStationLogoResponse")) : class$org$dsi$ifc$radiodata$RadioStationLogoResponse, 7);
    }

    @Override
    public void traceDSIObject(PrintWriter printWriter, Object object) {
        if (printWriter == null) {
            return;
        }
        switch (this.resolveID(object)) {
            case 1: {
                this.traceCountryRegionData(printWriter, (CountryRegionData)object);
                break;
            }
            case 2: {
                this.traceCountryRegionTranslationData(printWriter, (CountryRegionTranslationData)object);
                break;
            }
            case 3: {
                this.traceRadioStationData(printWriter, (RadioStationData)object);
                break;
            }
            case 4: {
                this.traceRadioStationDataRequest(printWriter, (RadioStationDataRequest)object);
                break;
            }
            case 5: {
                this.traceRadioStationDataResponse(printWriter, (RadioStationDataResponse)object);
                break;
            }
            case 6: {
                this.traceRadioStationLogoRequest(printWriter, (RadioStationLogoRequest)object);
                break;
            }
            case 7: {
                this.traceRadioStationLogoResponse(printWriter, (RadioStationLogoResponse)object);
                break;
            }
            default: {
                throw new IllegalArgumentException(new StringBuffer().append("Not a valid DSI object for tracing: ").append(object.getClass()).toString());
            }
        }
    }

    private void traceCountryRegionData(PrintWriter printWriter, CountryRegionData countryRegionData) {
        int n;
        int n2;
        if (countryRegionData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(countryRegionData.crId);
        printWriter.print(countryRegionData.macroRegionId);
        printWriter.print(countryRegionData.ioc);
        printWriter.print(countryRegionData.countryId);
        printWriter.print(countryRegionData.countryNameInternational);
        printWriter.print(countryRegionData.countryNameOriginal);
        printWriter.print(countryRegionData.iocCountryNameInternational);
        printWriter.print(countryRegionData.countryEcc);
        printWriter.print(countryRegionData.countryPi);
        if (countryRegionData.countryNeighborPi == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = countryRegionData.countryNeighborPi.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(countryRegionData.countryNeighborPi[n]);
            }
        }
        printWriter.print(countryRegionData.gpsMode);
        if (countryRegionData.gpsp == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = countryRegionData.gpsp.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(countryRegionData.gpsp[n]);
            }
        }
        printWriter.print(countryRegionData.flagId);
        printWriter.print(countryRegionData.amSupport);
        printWriter.print(countryRegionData.fmSupport);
        printWriter.print(countryRegionData.dabSupport);
        printWriter.print(countryRegionData.speechSupport);
        printWriter.print(countryRegionData.nurGenehmigteLogos);
        printWriter.print(countryRegionData.requestStrategy);
        printWriter.print(countryRegionData.useDatabaseNameInHmi);
        printWriter.print(countryRegionData.nativeLanguage);
        if (countryRegionData.extraString == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = countryRegionData.extraString.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(countryRegionData.extraString[n]);
            }
        }
        if (countryRegionData.extraInt == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = countryRegionData.extraInt.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                printWriter.print(countryRegionData.extraInt[n]);
            }
        }
    }

    private void traceCountryRegionTranslationData(PrintWriter printWriter, CountryRegionTranslationData countryRegionTranslationData) {
        if (countryRegionTranslationData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(countryRegionTranslationData.countryId);
        printWriter.print(countryRegionTranslationData.guiLanguageId);
        printWriter.print(countryRegionTranslationData.guiLanguage);
        printWriter.print(countryRegionTranslationData.countryRegionTranslation);
        printWriter.print(countryRegionTranslationData.guiListItemPosition);
    }

    private void traceRadioStationData(PrintWriter printWriter, RadioStationData radioStationData) {
        if (radioStationData == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(radioStationData.stationId);
        printWriter.print(radioStationData.country);
        printWriter.print(radioStationData.extendedCountryCode);
        printWriter.print(radioStationData.piSid);
        printWriter.print(radioStationData.linkedPiSid);
        printWriter.print(radioStationData.ensembleId);
        printWriter.print(radioStationData.scidi);
        printWriter.print(radioStationData.longName);
        printWriter.print(radioStationData.shortName);
        printWriter.print(radioStationData.frequency);
        printWriter.print(radioStationData.subChannelId);
        printWriter.print(radioStationData.stationType);
        printWriter.print(radioStationData.radioSdsId);
        printWriter.print(radioStationData.logoId);
    }

    private void traceRadioStationDataRequest(PrintWriter printWriter, RadioStationDataRequest radioStationDataRequest) {
        if (radioStationDataRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(radioStationDataRequest.maxItemCount);
        printWriter.print(radioStationDataRequest.stationId);
        printWriter.print(radioStationDataRequest.useStationId);
        printWriter.print(radioStationDataRequest.country);
        printWriter.print(radioStationDataRequest.useCountry);
        printWriter.print(radioStationDataRequest.extendedCountryCode);
        printWriter.print(radioStationDataRequest.useExtendedCountryCode);
        printWriter.print(radioStationDataRequest.piSid);
        printWriter.print(radioStationDataRequest.usePiSid);
        printWriter.print(radioStationDataRequest.linkedPiSid);
        printWriter.print(radioStationDataRequest.useLinkedPiSid);
        printWriter.print(radioStationDataRequest.ensembleId);
        printWriter.print(radioStationDataRequest.useEnsembleId);
        printWriter.print(radioStationDataRequest.scidi);
        printWriter.print(radioStationDataRequest.useScidi);
        printWriter.print(radioStationDataRequest.longName);
        printWriter.print(radioStationDataRequest.useLongName);
        printWriter.print(radioStationDataRequest.shortName);
        printWriter.print(radioStationDataRequest.useShortName);
        printWriter.print(radioStationDataRequest.frequency);
        printWriter.print(radioStationDataRequest.useFrequency);
        printWriter.print(radioStationDataRequest.subChannelId);
        printWriter.print(radioStationDataRequest.useSubChannelId);
        printWriter.print(radioStationDataRequest.stationType);
        printWriter.print(radioStationDataRequest.useStationType);
        printWriter.print(radioStationDataRequest.logoId);
        printWriter.print(radioStationDataRequest.useLogoId);
    }

    private void traceRadioStationDataResponse(PrintWriter printWriter, RadioStationDataResponse radioStationDataResponse) {
        if (radioStationDataResponse == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(radioStationDataResponse.totalItemCount);
        if (radioStationDataResponse.radioStationData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = radioStationDataResponse.radioStationData.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                this.trace(printWriter, radioStationDataResponse.radioStationData[i2]);
            }
        }
    }

    private void traceRadioStationLogoRequest(PrintWriter printWriter, RadioStationLogoRequest radioStationLogoRequest) {
        if (radioStationLogoRequest == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        this.trace(printWriter, radioStationLogoRequest.radioStationDataRequest);
        if (radioStationLogoRequest.priorities == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            int n = radioStationLogoRequest.priorities.length;
            printWriter.print(n);
            for (int i2 = 0; i2 < n; ++i2) {
                printWriter.print(radioStationLogoRequest.priorities[i2]);
            }
        }
    }

    private void traceRadioStationLogoResponse(PrintWriter printWriter, RadioStationLogoResponse radioStationLogoResponse) {
        int n;
        int n2;
        if (radioStationLogoResponse == null) {
            printWriter.print(-1);
            return;
        }
        printWriter.print(0);
        printWriter.print(radioStationLogoResponse.totalItemCount);
        if (radioStationLogoResponse.resourceLocators == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = radioStationLogoResponse.resourceLocators.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, radioStationLogoResponse.resourceLocators[n]);
            }
        }
        if (radioStationLogoResponse.radioStationData == null) {
            printWriter.print(-1);
        } else {
            printWriter.print(0);
            n2 = radioStationLogoResponse.radioStationData.length;
            printWriter.print(n2);
            for (n = 0; n < n2; ++n) {
                this.trace(printWriter, radioStationLogoResponse.radioStationData[n]);
            }
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

