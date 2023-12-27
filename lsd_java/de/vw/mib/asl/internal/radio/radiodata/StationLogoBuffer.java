/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.radiodata;

import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.amfm.common.AmFmStation;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataSessionManager;
import de.vw.mib.asl.internal.radio.radiodata.StationLogoData;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.ServiceInfo;
import org.dsi.ifc.radiodata.RadioStationData;
import org.dsi.ifc.radiodata.RadioStationDataRequest;
import org.dsi.ifc.radiodata.RadioStationLogoResponse;

public class StationLogoBuffer {
    private StationLogoData[] logoBuffer = null;
    public static boolean requestedRadioAmGenericStationLogo = false;
    public static boolean requestedRadioFmGenericStationLogo = false;
    public static boolean requestedRadioDabGenericStationLogo = false;
    private ResourceLocator genericAmLogoResourceLocator = null;
    private ResourceLocator genericFmLogoResourceLocator = null;
    private ResourceLocator genericDabLogoResourceLocator = null;

    public StationLogoBuffer() {
        this.createStationLogoDataArray();
    }

    private void createStationLogoDataArray() {
        this.logoBuffer = new StationLogoData[400];
    }

    public ResourceLocator getGenericAmLogoResourceLocator() {
        return this.genericAmLogoResourceLocator;
    }

    public void setGenericAmLogoResourceLocator(ResourceLocator resourceLocator) {
        this.genericAmLogoResourceLocator = resourceLocator;
    }

    public ResourceLocator getGenericFmLogoResourceLocator() {
        return this.genericFmLogoResourceLocator;
    }

    public void setGenericFmLogoResourceLocator(ResourceLocator resourceLocator) {
        this.genericFmLogoResourceLocator = resourceLocator;
    }

    public ResourceLocator getGenericDabLogoResourceLocator() {
        return this.genericDabLogoResourceLocator;
    }

    public void setGenericDabLogoResourceLocator(ResourceLocator resourceLocator) {
        this.genericDabLogoResourceLocator = resourceLocator;
    }

    public StationLogoData getAmStationLogo(RadioStationDataRequest radioStationDataRequest) {
        if (null != radioStationDataRequest && null != this.logoBuffer) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationDataRequest radioStationDataRequest2;
                if (null == this.logoBuffer[i2] || null == (radioStationDataRequest2 = this.logoBuffer[i2].getRadioStationData()) || radioStationDataRequest2.getFrequency() != radioStationDataRequest.getFrequency() || radioStationDataRequest2.getCountry() != radioStationDataRequest.getCountry() || !radioStationDataRequest2.getStationType().equals("AM")) continue;
                return this.logoBuffer[i2];
            }
            return null;
        }
        return null;
    }

    public StationLogoData getFmStationLogo(RadioStationDataRequest radioStationDataRequest, AmFmStation amFmStation) {
        if (null != radioStationDataRequest && null != this.logoBuffer && null != amFmStation) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationDataRequest radioStationDataRequest2;
                if (null == this.logoBuffer[i2] || null == (radioStationDataRequest2 = this.logoBuffer[i2].getRadioStationData())) continue;
                int n = radioStationDataRequest.getPiSid();
                if (ProgramIdentification.isValidPI(n) && RadioCodingAdapter.isPiActivated()) {
                    String string = amFmStation.getName();
                    String string2 = radioStationDataRequest2.getLongName();
                    if (!amFmStation.isScrollingPS() && null != string && string.length() > 0 && null != string2) {
                        string = string.trim();
                        string2 = string2.trim();
                        if (radioStationDataRequest2.getPiSid() != n || !string2.equalsIgnoreCase(string) || radioStationDataRequest2.getCountry() != radioStationDataRequest.getCountry() || !radioStationDataRequest2.getStationType().equals("FM")) continue;
                        return this.logoBuffer[i2];
                    }
                    if (radioStationDataRequest2.getPiSid() != n || radioStationDataRequest2.getCountry() != radioStationDataRequest.getCountry() || !radioStationDataRequest2.getStationType().equals("FM")) continue;
                    return this.logoBuffer[i2];
                }
                if (radioStationDataRequest2.getFrequency() != radioStationDataRequest.getFrequency() || radioStationDataRequest2.getCountry() != radioStationDataRequest.getCountry() || !radioStationDataRequest2.getStationType().equals("FM")) continue;
                return this.logoBuffer[i2];
            }
            return null;
        }
        return null;
    }

    public StationLogoData getFmStationData(AmFmStation amFmStation, int n) {
        if (null != this.logoBuffer && null != amFmStation) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationDataRequest radioStationDataRequest;
                if (null == this.logoBuffer[i2] || null == (radioStationDataRequest = this.logoBuffer[i2].getRadioStationData())) continue;
                int n2 = amFmStation.getPi();
                if (ProgramIdentification.isValidPI(n2) && RadioCodingAdapter.isPiActivated()) {
                    String string = amFmStation.getName();
                    String string2 = radioStationDataRequest.getLongName();
                    if (!amFmStation.isScrollingPS() && null != string && string.length() > 0 && null != string2) {
                        string = string.trim();
                        string2 = string2.trim();
                        if (radioStationDataRequest.getPiSid() != n2 || !string2.equalsIgnoreCase(string) || radioStationDataRequest.getCountry() != n || !radioStationDataRequest.getStationType().equals("FM")) continue;
                        return this.logoBuffer[i2];
                    }
                    if (radioStationDataRequest.getPiSid() != n2 || radioStationDataRequest.getCountry() != n || !radioStationDataRequest.getStationType().equals("FM")) continue;
                    return this.logoBuffer[i2];
                }
                if (radioStationDataRequest.getFrequency() != (long)amFmStation.getFrequency() || radioStationDataRequest.getCountry() != n || !radioStationDataRequest.getStationType().equals("FM")) continue;
                return this.logoBuffer[i2];
            }
            return null;
        }
        return null;
    }

    public StationLogoData getDabStationLogo(ServiceInfo serviceInfo) {
        if (null != serviceInfo && null != this.logoBuffer) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationDataRequest radioStationDataRequest;
                if (null == this.logoBuffer[i2] || null == (radioStationDataRequest = this.logoBuffer[i2].getRadioStationData()) || (long)radioStationDataRequest.getPiSid() != serviceInfo.getSID() || radioStationDataRequest.getExtendedCountryCode() != serviceInfo.getEnsECC() || !radioStationDataRequest.getStationType().equals("DAB")) continue;
                return this.logoBuffer[i2];
            }
            return null;
        }
        return null;
    }

    public RadioStationLogoResponse getDabStationData(ServiceInfo serviceInfo) {
        if (null != serviceInfo && null != this.logoBuffer) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationDataRequest radioStationDataRequest;
                if (null == this.logoBuffer[i2] || null == (radioStationDataRequest = this.logoBuffer[i2].getRadioStationData()) || (long)radioStationDataRequest.getPiSid() != serviceInfo.getSID() || radioStationDataRequest.getExtendedCountryCode() != serviceInfo.getEnsECC() || !radioStationDataRequest.getStationType().equals("DAB")) continue;
                return this.logoBuffer[i2].getStationLogoResponse();
            }
            return null;
        }
        return null;
    }

    public RadioStationData[] getDabRadioStationData(ServiceInfo serviceInfo) {
        RadioStationLogoResponse radioStationLogoResponse;
        if (null != serviceInfo && null != this.logoBuffer && null != (radioStationLogoResponse = this.getDabStationData(serviceInfo))) {
            return radioStationLogoResponse.getRadioStationData();
        }
        return null;
    }

    public RadioStationData getDabStationData(int n) {
        if (null != this.logoBuffer) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationData[] radioStationDataArray;
                RadioStationLogoResponse radioStationLogoResponse;
                if (null == this.logoBuffer[i2] || null == (radioStationLogoResponse = this.logoBuffer[i2].getStationLogoResponse()) || null == (radioStationDataArray = radioStationLogoResponse.getRadioStationData()) || radioStationDataArray.length != 1 || null == radioStationDataArray[0] || radioStationDataArray[0].getStationId() != n) continue;
                return radioStationDataArray[0];
            }
            return null;
        }
        return null;
    }

    public RadioStationDataRequest getDabRadioStationDataRequest(int n) {
        if (null != this.logoBuffer) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationData[] radioStationDataArray;
                RadioStationLogoResponse radioStationLogoResponse;
                if (null == this.logoBuffer[i2] || null == (radioStationLogoResponse = this.logoBuffer[i2].getStationLogoResponse()) || null == (radioStationDataArray = radioStationLogoResponse.getRadioStationData()) || radioStationDataArray.length != 1 || null == radioStationDataArray[0] || radioStationDataArray[0].getStationId() != n) continue;
                return this.logoBuffer[i2].getRadioStationData();
            }
            return null;
        }
        return null;
    }

    public void setAmStationLogo(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, RadioStationLogoResponse radioStationLogoResponse) {
        boolean bl = false;
        if (null != radioStationDataRequest) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                if (null == this.logoBuffer[i2]) {
                    this.logoBuffer[i2] = new StationLogoData();
                    this.setAmStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[i2], radioStationLogoResponse);
                    bl = true;
                    return;
                }
                RadioStationDataRequest radioStationDataRequest2 = this.logoBuffer[i2].getRadioStationData();
                if (null == radioStationDataRequest2 || radioStationDataRequest2.getFrequency() != radioStationDataRequest.getFrequency() || radioStationDataRequest2.getCountry() != radioStationDataRequest.getCountry() || !radioStationDataRequest2.getStationType().equals("AM")) continue;
                this.logoBuffer[i2] = new StationLogoData();
                this.setAmStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[i2], radioStationLogoResponse);
                bl = true;
                return;
            }
        }
        if (!bl) {
            this.createStationLogoDataArray();
            this.logoBuffer[0] = new StationLogoData();
            this.setAmStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[0], radioStationLogoResponse);
        }
    }

    private void setAmStationLogo(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, StationLogoData stationLogoData, RadioStationLogoResponse radioStationLogoResponse) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("StationLogoBuffer - setAmStationLogo() - resourceLocator : ").append(resourceLocator).append(" radioStationDataRequest : ").append(radioStationDataRequest).append(" stationLogoResponse : ").append(radioStationLogoResponse).log();
        }
        if (null != resourceLocator) {
            stationLogoData.setResourceLocator(new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl()));
        } else {
            stationLogoData.setResourceLocator(null);
        }
        RadioStationDataRequest radioStationDataRequest2 = new RadioStationDataRequest();
        radioStationDataRequest2.stationType = "AM";
        radioStationDataRequest2.country = radioStationDataRequest.getCountry();
        radioStationDataRequest2.frequency = radioStationDataRequest.getFrequency();
        stationLogoData.setRadioStationData(radioStationDataRequest2);
        stationLogoData.setStationLogoResponse(radioStationLogoResponse);
    }

    public void setAmStationLogo(ResourceLocator resourceLocator, AmFmStation amFmStation) {
        if (null != amFmStation) {
            RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
            radioStationDataRequest.stationId = -1;
            radioStationDataRequest.country = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
            radioStationDataRequest.extendedCountryCode = -1;
            radioStationDataRequest.piSid = amFmStation.getPi();
            radioStationDataRequest.ensembleId = -1;
            radioStationDataRequest.scidi = -1;
            radioStationDataRequest.longName = "";
            radioStationDataRequest.shortName = "";
            radioStationDataRequest.frequency = amFmStation.getFrequency();
            radioStationDataRequest.subChannelId = -1;
            radioStationDataRequest.stationType = "AM";
            radioStationDataRequest.logoId = -1;
            RadioStationLogoResponse radioStationLogoResponse = new RadioStationLogoResponse();
            if (null != resourceLocator) {
                radioStationLogoResponse.resourceLocators = new ResourceLocator[]{resourceLocator};
            }
            this.setAmStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse);
        }
    }

    public void setFmStationLogo(ResourceLocator resourceLocator, AmFmStation amFmStation, boolean bl) {
        if (null != amFmStation) {
            RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
            radioStationDataRequest.stationId = -1;
            radioStationDataRequest.country = RadioDataSessionManager.getInstance().homeCountryCalc.getHomeCountry();
            radioStationDataRequest.extendedCountryCode = -1;
            radioStationDataRequest.piSid = amFmStation.getPi();
            radioStationDataRequest.ensembleId = -1;
            radioStationDataRequest.scidi = -1;
            radioStationDataRequest.longName = "";
            radioStationDataRequest.shortName = "";
            if (!amFmStation.isScrollingPS()) {
                radioStationDataRequest.longName = amFmStation.getName();
                radioStationDataRequest.shortName = amFmStation.getName();
            }
            radioStationDataRequest.frequency = amFmStation.getFrequency();
            radioStationDataRequest.subChannelId = -1;
            radioStationDataRequest.stationType = "FM";
            radioStationDataRequest.logoId = -1;
            RadioStationLogoResponse radioStationLogoResponse = new RadioStationLogoResponse();
            if (null != resourceLocator) {
                radioStationLogoResponse.resourceLocators = new ResourceLocator[]{resourceLocator};
            }
            this.setFmStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse, bl);
        }
    }

    public void setFmStationLogo(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, RadioStationLogoResponse radioStationLogoResponse, boolean bl) {
        boolean bl2 = false;
        if (null != radioStationDataRequest) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                if (null == this.logoBuffer[i2]) {
                    this.logoBuffer[i2] = new StationLogoData();
                    this.setFmStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[i2], radioStationLogoResponse, bl);
                    bl2 = true;
                    return;
                }
                RadioStationDataRequest radioStationDataRequest2 = this.logoBuffer[i2].getRadioStationData();
                if (null == radioStationDataRequest2) continue;
                int n = radioStationDataRequest.getPiSid();
                if (ProgramIdentification.isValidPI(n) && RadioCodingAdapter.isPiActivated()) {
                    String string = radioStationDataRequest2.getShortName();
                    String string2 = radioStationDataRequest2.getLongName();
                    if (null != string && string.length() > 0 && null != string2) {
                        string = string.trim();
                        string2 = string2.trim();
                        if (null == radioStationDataRequest2 || radioStationDataRequest2.getPiSid() != n || !string2.equalsIgnoreCase(string) || radioStationDataRequest2.getCountry() != radioStationDataRequest.getCountry() || !radioStationDataRequest2.getStationType().equals("FM")) continue;
                        this.logoBuffer[i2] = new StationLogoData();
                        this.setFmStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[i2], radioStationLogoResponse, bl);
                        bl2 = true;
                        return;
                    }
                    if (radioStationDataRequest2.getPiSid() != n || radioStationDataRequest2.getCountry() != radioStationDataRequest.getCountry() || !radioStationDataRequest2.getStationType().equals("FM")) continue;
                    this.logoBuffer[i2] = new StationLogoData();
                    this.setFmStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[i2], radioStationLogoResponse, bl);
                    bl2 = true;
                    return;
                }
                if (radioStationDataRequest2.getFrequency() != radioStationDataRequest.getFrequency() || radioStationDataRequest2.getCountry() != radioStationDataRequest.getCountry() || !radioStationDataRequest2.getStationType().equals("FM")) continue;
                this.logoBuffer[i2] = new StationLogoData();
                this.setFmStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[i2], radioStationLogoResponse, bl);
                bl2 = true;
                return;
            }
        }
        if (!bl2) {
            this.createStationLogoDataArray();
            this.logoBuffer[0] = new StationLogoData();
            this.setFmStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[0], radioStationLogoResponse, bl);
        }
    }

    private void setFmStationLogo(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, StationLogoData stationLogoData, RadioStationLogoResponse radioStationLogoResponse, boolean bl) {
        if (ServiceManager.logger.isTraceEnabled(128)) {
            ServiceManager.logger.trace(128).append("StationLogoBuffer - setFmStationLogo() - resourceLocator : ").append(resourceLocator).append(" radioStationDataRequest : ").append(radioStationDataRequest).append(" stationLogoResponse : ").append(radioStationLogoResponse).log();
        }
        if (null != resourceLocator) {
            stationLogoData.setResourceLocator(new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl()));
        } else {
            stationLogoData.setResourceLocator(null);
        }
        RadioStationDataRequest radioStationDataRequest2 = new RadioStationDataRequest();
        radioStationDataRequest2.frequency = radioStationDataRequest.getFrequency();
        radioStationDataRequest2.piSid = radioStationDataRequest.getPiSid();
        radioStationDataRequest2.extendedCountryCode = radioStationDataRequest.getExtendedCountryCode();
        radioStationDataRequest2.country = radioStationDataRequest.getCountry();
        radioStationDataRequest2.stationType = "FM";
        radioStationDataRequest2.longName = radioStationDataRequest.getLongName();
        stationLogoData.setRadioStationData(radioStationDataRequest2);
        stationLogoData.setStationLogoResponse(radioStationLogoResponse);
        stationLogoData.setResponseContainedMoreThanOneLogo(bl);
    }

    public void setDabStationLogo(ResourceLocator resourceLocator, ServiceInfo serviceInfo) {
        if (null != serviceInfo) {
            RadioStationDataRequest radioStationDataRequest = new RadioStationDataRequest();
            radioStationDataRequest.stationId = -1;
            radioStationDataRequest.country = -1;
            radioStationDataRequest.extendedCountryCode = serviceInfo.getEnsECC();
            radioStationDataRequest.piSid = (int)serviceInfo.getSID();
            radioStationDataRequest.ensembleId = -1;
            radioStationDataRequest.scidi = -1;
            radioStationDataRequest.longName = serviceInfo.getFullName();
            radioStationDataRequest.shortName = serviceInfo.getShortName();
            radioStationDataRequest.frequency = -1L;
            radioStationDataRequest.subChannelId = -1;
            radioStationDataRequest.stationType = "DAB";
            radioStationDataRequest.logoId = -1;
            RadioStationLogoResponse radioStationLogoResponse = new RadioStationLogoResponse();
            if (null != resourceLocator) {
                radioStationLogoResponse.resourceLocators = new ResourceLocator[]{resourceLocator};
            }
            this.setDabStationLogo(resourceLocator, radioStationDataRequest, radioStationLogoResponse);
        }
    }

    public void setDabStationLogo(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, RadioStationLogoResponse radioStationLogoResponse) {
        boolean bl = false;
        if (null != radioStationDataRequest) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                if (null == this.logoBuffer[i2]) {
                    this.logoBuffer[i2] = new StationLogoData();
                    this.setDabStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[i2], radioStationLogoResponse);
                    bl = true;
                    return;
                }
                RadioStationDataRequest radioStationDataRequest2 = this.logoBuffer[i2].getRadioStationData();
                if (null == radioStationDataRequest2 || radioStationDataRequest2.getPiSid() != radioStationDataRequest.getPiSid() || radioStationDataRequest2.getExtendedCountryCode() != radioStationDataRequest.getExtendedCountryCode() || !radioStationDataRequest2.getStationType().equals("DAB")) continue;
                this.logoBuffer[i2] = new StationLogoData();
                this.setDabStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[i2], radioStationLogoResponse);
                bl = true;
                return;
            }
        }
        if (!bl) {
            this.createStationLogoDataArray();
            this.logoBuffer[0] = new StationLogoData();
            this.setDabStationLogo(resourceLocator, radioStationDataRequest, this.logoBuffer[0], radioStationLogoResponse);
        }
    }

    private void setDabStationLogo(ResourceLocator resourceLocator, RadioStationDataRequest radioStationDataRequest, StationLogoData stationLogoData, RadioStationLogoResponse radioStationLogoResponse) {
        if (null != resourceLocator) {
            stationLogoData.setResourceLocator(new ResourceLocator(resourceLocator.getId(), resourceLocator.getUrl()));
        } else {
            stationLogoData.setResourceLocator(null);
        }
        RadioStationDataRequest radioStationDataRequest2 = new RadioStationDataRequest();
        radioStationDataRequest2.piSid = radioStationDataRequest.getPiSid();
        radioStationDataRequest2.extendedCountryCode = radioStationDataRequest.getExtendedCountryCode();
        radioStationDataRequest2.stationType = "DAB";
        radioStationDataRequest2.longName = radioStationDataRequest.getLongName();
        radioStationDataRequest2.shortName = radioStationDataRequest.getShortName();
        radioStationDataRequest2.ensembleId = radioStationDataRequest.getEnsembleId();
        stationLogoData.setRadioStationData(radioStationDataRequest2);
        stationLogoData.setStationLogoResponse(radioStationLogoResponse);
    }

    public void deleteHmiLogoBuffer() {
        requestedRadioAmGenericStationLogo = false;
        requestedRadioFmGenericStationLogo = false;
        requestedRadioDabGenericStationLogo = false;
        this.genericAmLogoResourceLocator = null;
        this.genericFmLogoResourceLocator = null;
        this.genericDabLogoResourceLocator = null;
        this.createStationLogoDataArray();
    }

    public void deleteFmStationLogo(AmFmStation amFmStation) {
        if (null != amFmStation) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationDataRequest radioStationDataRequest;
                if (null == this.logoBuffer[i2] || null == (radioStationDataRequest = this.logoBuffer[i2].getRadioStationData())) continue;
                if (ProgramIdentification.isValidPI(amFmStation.getPi()) && RadioCodingAdapter.isPiActivated()) {
                    if (radioStationDataRequest.getPiSid() != amFmStation.getPi() || !radioStationDataRequest.getStationType().equals("FM")) continue;
                    this.logoBuffer[i2] = null;
                    continue;
                }
                if (radioStationDataRequest.getFrequency() != (long)amFmStation.getFrequency() || !radioStationDataRequest.getStationType().equals("FM")) continue;
                this.logoBuffer[i2] = null;
            }
        }
    }

    public void deleteAmStationLogo(AmFmStation amFmStation) {
        if (null != amFmStation) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationDataRequest radioStationDataRequest;
                if (null == this.logoBuffer[i2] || null == (radioStationDataRequest = this.logoBuffer[i2].getRadioStationData()) || radioStationDataRequest.getFrequency() != (long)amFmStation.getFrequency() || !radioStationDataRequest.getStationType().equals("AM")) continue;
                this.logoBuffer[i2] = null;
            }
        }
    }

    public void deleteDabStationLogo(ServiceInfo serviceInfo) {
        if (null != serviceInfo) {
            for (int i2 = 0; i2 < this.logoBuffer.length; ++i2) {
                RadioStationDataRequest radioStationDataRequest;
                if (null == this.logoBuffer[i2] || null == (radioStationDataRequest = this.logoBuffer[i2].getRadioStationData()) || (long)radioStationDataRequest.getPiSid() != serviceInfo.getSID() || radioStationDataRequest.getExtendedCountryCode() != serviceInfo.getEnsECC() || !radioStationDataRequest.getStationType().equals("DAB")) continue;
                this.logoBuffer[i2] = null;
            }
        }
    }
}

