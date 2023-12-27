/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.radio.amfm.common;

import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.framework.internal.framework.util.LogUtil;
import de.vw.mib.asl.internal.radio.RadioCodingAdapter;
import de.vw.mib.asl.internal.radio.RadioData;
import de.vw.mib.asl.internal.radio.RadioUtil;
import de.vw.mib.asl.internal.radio.amfm.data.StationNameFreqList;
import de.vw.mib.asl.internal.radio.amfm.settings.AmFmAlternativeFrequencySwitch;
import de.vw.mib.asl.internal.radio.amfm.settings.AmfmRDSOption;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMMath;
import de.vw.mib.asl.internal.radio.amfm.util.AMFMUtil;
import de.vw.mib.asl.internal.radio.amfm.util.ProgramIdentification;
import de.vw.mib.asl.internal.radio.bap.transformer.RadioItem;
import de.vw.mib.asl.internal.radio.radiodata.RadioDataApi;
import de.vw.mib.log4mib.LogMessage;
import de.vw.mib.log4mib.Loggable;
import de.vw.mib.log4mib.Logger;
import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.radio.Station;
import org.dsi.ifc.radiodata.RadioStationData;

public final class AmFmStation
implements RadioItem,
Loggable {
    private final Logger logger = ServiceManager.logger;
    private Station mStation = new Station();
    private String mRealName = null;
    private boolean mOldRdsOptionRealName = false;
    private String mRegString = "";
    private int mHDStatus = 3;
    private int subChannelCount = 0;
    private int mChannelMask = 0;
    private long uniqueId = -1L;
    private boolean isMPSwithSPSAlreadyStored = false;
    private boolean isMPSWithoutSPSAlreadyStored = false;

    public AmFmStation() {
        this.init();
    }

    public AmFmStation(Station station) {
        this.init();
        this.setStation(station);
    }

    public AmFmStation(AmFmStation amFmStation) {
        this.copyOf(amFmStation);
    }

    public AmFmStation(long l) {
        this.setStation(l);
    }

    public AmFmStation(int n, long l) {
        this.init();
        this.mStation.waveband = n;
        this.setFrequency(l);
    }

    public AmFmStation(int n, int n2, int n3, int n4) {
        this.init();
        this.mStation.waveband = n;
        this.setFrequency(n2);
        this.setPI(n3);
        this.mStation.serviceId = n4;
    }

    public AmFmStation(int n, int n2, int n3, String string, String string2, boolean bl, ResourceLocator resourceLocator, boolean bl2) {
        this.setStation(n);
        this.setPI(n2);
        this.mStation.serviceId = n3;
        this.mStation.name = string;
        this.mStation.hd = bl;
        this.mStation.stationArt = resourceLocator;
        this.mStation.shortNameHD = string2;
        this.mStation.rds = bl2;
    }

    public AmFmStation(PersistenceInputStream persistenceInputStream) {
        this.init();
        this.fromStream(persistenceInputStream);
    }

    public void copyOf(AmFmStation amFmStation) {
        if (null != amFmStation) {
            this.setStation(amFmStation.mStation);
            this.mRealName = amFmStation.mRealName;
            this.mOldRdsOptionRealName = amFmStation.mOldRdsOptionRealName;
            this.mRegString = amFmStation.mRegString;
            this.mHDStatus = amFmStation.mHDStatus;
            this.subChannelCount = amFmStation.subChannelCount;
            this.mChannelMask = amFmStation.mChannelMask;
        } else {
            this.init();
        }
    }

    private void init() {
        this.setFrequency(0L);
        this.mStation.fullDigital = false;
        this.mStation.hd = false;
        this.mStation.longNameHD = "";
        this.mStation.name = "";
        this.mStation.pi = -1;
        this.mStation.ptyCode = 0;
        this.mStation.radioText = false;
        this.mStation.rds = false;
        this.mStation.realPS = "";
        this.mStation.receptionQuality = 75;
        this.mStation.scrollingPS = false;
        this.mStation.serviceId = 0;
        this.mStation.shortNameHD = "";
        this.mStation.subscription = 3;
        this.mStation.ta = false;
        this.mStation.tmc = false;
        this.mStation.tp = false;
        this.mStation.coChannel = false;
        this.mStation.waveband = 1;
        this.mHDStatus = 3;
        this.uniqueId = -1L;
        this.mStation.stationArt = null;
    }

    public void setStation(Station station) {
        if (null != station) {
            this.mStation.waveband = station.waveband;
            this.mStation.serviceId = station.serviceId;
            this.setFrequency((int)station.frequency);
            this.mStation.fullDigital = station.fullDigital;
            this.mStation.hd = station.hd;
            this.mStation.longNameHD = station.longNameHD.trim();
            this.mStation.name = station.name.trim();
            this.setPI(station.pi);
            this.mStation.ptyCode = station.ptyCode;
            this.mStation.radioText = station.radioText;
            this.mStation.rds = station.rds;
            this.mStation.realPS = station.realPS.trim();
            this.mStation.receptionQuality = station.receptionQuality;
            this.mStation.scrollingPS = station.scrollingPS;
            this.mStation.shortNameHD = station.shortNameHD.trim();
            this.mStation.subscription = station.subscription;
            this.mStation.ta = station.ta;
            this.mStation.tmc = station.tmc;
            this.mStation.tp = station.tp;
            this.mStation.coChannel = station.coChannel;
            this.mStation.eon = station.eon;
            this.mStation.stationArt = station.stationArt;
            this.calcRegionalisation();
        } else {
            this.init();
        }
    }

    public void fillStationInfo(Station station) {
        this.setStation(station);
    }

    private void setStation(long l) {
        this.init();
        this.setFrequency(l);
        this.mStation.waveband = l >= RadioData.getAmfmDatabase().getFmBandInfo().getLowerLimit() && l <= RadioData.getAmfmDatabase().getFmBandInfo().getUpperLimit() ? 1 : (l >= RadioData.getAmfmDatabase().getAmBandInfo().getLowerLimit() && l <= RadioData.getAmfmDatabase().getAmBandInfo().getUpperLimit() ? 3 : 3);
    }

    public AmFmStation setFrequency(long l) {
        this.mStation.frequency = l;
        this.setUniqueId();
        return this;
    }

    public AmFmStation setHD(boolean bl) {
        this.mStation.hd = bl;
        return this;
    }

    public void setRadioText(boolean bl) {
        this.mStation.radioText = bl;
    }

    public AmFmStation setPI(int n) {
        this.mStation.pi = ProgramIdentification.isValidPI(n) ? n : -1;
        this.setUniqueId();
        return this;
    }

    public AmFmStation setPtyCode(int n) {
        this.mStation.ptyCode = n;
        return this;
    }

    public AmFmStation setRDS(boolean bl) {
        this.mStation.rds = bl;
        return this;
    }

    public AmFmStation setRealName(String string) {
        this.mStation.realPS = string;
        return this;
    }

    public AmFmStation setSubchannel(int n) {
        this.mStation.serviceId = n;
        return this;
    }

    public AmFmStation setTA(boolean bl) {
        this.mStation.ta = bl;
        return this;
    }

    public AmFmStation setTP(boolean bl) {
        this.mStation.tp = bl;
        return this;
    }

    public AmFmStation setWaveband(int n) {
        this.mStation.waveband = n;
        return this;
    }

    public void fromStream(PersistenceInputStream persistenceInputStream) {
        StationNameFreqList stationNameFreqList;
        this.mStation.name = persistenceInputStream.readString();
        this.setFrequency(persistenceInputStream.readInt());
        if (ServiceManager.configManagerDiag.isFeatureFlagSet(423) && null != this.mStation.name && this.mStation.name.length() > 0 && null != (stationNameFreqList = RadioData.getAmfmDatabase().getStationNameFreqList())) {
            stationNameFreqList.addCurrentStation((int)this.mStation.frequency, this.mStation.name);
        }
        this.setPI(persistenceInputStream.readInt());
        this.mStation.waveband = persistenceInputStream.readByte();
        this.mStation.rds = persistenceInputStream.readBoolean();
        this.mStation.hd = persistenceInputStream.readBoolean();
        this.mStation.serviceId = persistenceInputStream.readInt();
    }

    private String calcRegionalisation(int n) {
        if (!ProgramIdentification.isValidPI(n)) {
            return "";
        }
        int n2 = n & 0xF00;
        n2 >>= 8;
        if ((n2 -= 3) > 0 && n2 < 13) {
            return Integer.toString(n2, 10);
        }
        return "";
    }

    public String getRegionalisation() {
        if (RadioCodingAdapter.isPiActivated() && !ProgramIdentification.isValidPI(this.getPi())) {
            return "";
        }
        if (!RadioCodingAdapter.isPiActivated() || !AmfmRDSOption.get() && RadioCodingAdapter.isPiActivated()) {
            return "";
        }
        return this.mRegString;
    }

    public void calcRegionalisation() {
        this.mRegString = this.calcRegionalisation(this.mStation.pi);
    }

    public int calcRegonalisationIntForBap() {
        String string = this.calcRegionalisation(this.mStation.pi);
        if (string.length() != 0) {
            return Integer.parseInt(string, 16);
        }
        return 0;
    }

    public String getName() {
        if (this.mStation.name != null) {
            if (!AmfmRDSOption.get() && RadioCodingAdapter.isPiActivated()) {
                return "";
            }
            return this.mStation.name;
        }
        return "";
    }

    public String getStationName() {
        if (null == this.mStation.name) {
            return "";
        }
        return this.mStation.name;
    }

    public int getNameLength() {
        int n = 0;
        if (this.mStation.name != null && AmfmRDSOption.get()) {
            n = this.mStation.name.length();
        }
        return n;
    }

    public String getRealName() {
        if (this.isCoChannel()) {
            return "";
        }
        String string = "";
        if (AmfmRDSOption.get() && (string = RadioData.getAmfmDatabase().getFixedStationList().getName(this.getPi(), (int)this.mStation.frequency)) == null && this.mStation.name != null) {
            string = this.mStation.name.trim();
        }
        if (string == null) {
            string = "";
        }
        return string;
    }

    public String getShortNameHD() {
        if (this.mStation.shortNameHD != null) {
            return this.mStation.shortNameHD;
        }
        return "";
    }

    public String getLongNameHD() {
        if (this.mStation.longNameHD != null) {
            return this.mStation.longNameHD;
        }
        return "";
    }

    public int getTPState() {
        if (this.mStation.isTp() || this.mStation.isTa()) {
            return 0;
        }
        return 1;
    }

    public boolean getTA() {
        return this.mStation.ta;
    }

    public boolean getTP() {
        return this.mStation.tp;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(RadioUtil.getWavebandNameForDSIIdentifier(this.mStation.waveband)).append(" Station '").append(this.mStation.name).append("'  f: ").append(this.mStation.frequency).append(" dbID: ").append(this.getDbStationId()).append(" uniqueId: ").append(this.getUniqueId());
        if (this.mStation.rds) {
            stringBuffer.append("  RDS:  PI: ").append(AMFMMath.getPICode(this.mStation.pi)).append("  PS: ").append(this.mStation.realPS).append("  scrll PS: ").append(this.mStation.scrollingPS).append("  PTY: ").append(this.mStation.ptyCode).append("  TP: ").append(this.mStation.tp).append("  TA: ").append(this.mStation.ta).append("  CoChannel: ").append(this.mStation.coChannel).append("  TMC: ").append(this.mStation.tmc);
        }
        stringBuffer.append(new StringBuffer().append("  HD:  ").append(this.mStation.hd).append(" ServiceID: ").toString()).append(this.mStation.serviceId);
        stringBuffer.append("  qlty:").append(this.mStation.receptionQuality);
        return stringBuffer.toString();
    }

    public int getFrequency() {
        return (int)this.mStation.getFrequency();
    }

    public int getPi() {
        if (RadioCodingAdapter.isPiActivated()) {
            return this.mStation.getPi();
        }
        return -1;
    }

    public int getPtyCode() {
        return this.mStation.getPtyCode();
    }

    public int getReceptionQuality() {
        return this.mStation.getReceptionQuality();
    }

    public int getWaveband() {
        return this.mStation.getWaveband();
    }

    public int getAslWaveband() {
        return AMFMUtil.convertDSIBandConstantToHMIBandConstant(this.mStation.getWaveband());
    }

    public boolean isAM() {
        return this.mStation.waveband == 3 || this.mStation.waveband == 4;
    }

    public boolean isFM() {
        return this.mStation.waveband == 1;
    }

    public boolean isValidFmFrequency() {
        return this.mStation.frequency >= RadioData.getAmfmDatabase().getFmBandInfo().getLowerLimit() && this.mStation.frequency <= RadioData.getAmfmDatabase().getFmBandInfo().getUpperLimit();
    }

    public boolean isValidAmFrequency() {
        return this.mStation.frequency >= RadioData.getAmfmDatabase().getAmBandInfo().getLowerLimit() && this.mStation.frequency <= RadioData.getAmfmDatabase().getAmBandInfo().getUpperLimit();
    }

    public boolean isValidFmStation() {
        return this.isFM() && this.isValidFmFrequency();
    }

    public boolean isValidAmStation() {
        return this.isAM() && this.isValidAmFrequency();
    }

    public boolean isRds() {
        return this.mStation.isRds();
    }

    public boolean isScrollingPS() {
        return this.mStation.isScrollingPS();
    }

    public void setScrollingPs(boolean bl) {
        this.mStation.scrollingPS = bl;
    }

    public boolean isTa() {
        return this.mStation.isTa();
    }

    public boolean isCoChannel() {
        if (!RadioCodingAdapter.isPiActivated()) {
            return false;
        }
        return this.mStation.coChannel;
    }

    public void setCoChannel(boolean bl) {
        this.mStation.coChannel = bl;
    }

    public boolean isTmc() {
        return this.mStation.isTmc();
    }

    public boolean isTp() {
        return this.mStation.isTp();
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + (int)(this.mStation.frequency ^ this.mStation.frequency >>> 32);
        n2 = 31 * n2 + this.mStation.pi;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        if (AmfmRDSOption.get() && RadioCodingAdapter.isPiActivated()) {
            return this.equalsByPI(object);
        }
        return this.equalsByFreq(object);
    }

    public boolean equalsByPI(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AmFmStation amFmStation = (AmFmStation)object;
        if (this.mStation.rds && this.mStation.pi > -1 && amFmStation.mStation.rds && amFmStation.mStation.pi > -1) {
            if (this.mStation.pi != amFmStation.mStation.pi) {
                return false;
            }
            return this.equalsByFreq(object);
        }
        if (!this.mStation.rds && !amFmStation.mStation.rds) {
            return this.equalsByFreq(amFmStation);
        }
        return false;
    }

    public boolean equalsByFreq(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AmFmStation amFmStation = (AmFmStation)object;
        if (this.mStation.frequency != amFmStation.mStation.frequency) {
            return false;
        }
        return this.equalsBySubChannelID(object);
    }

    public boolean equalsBySubChannelID(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null) {
            return false;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        AmFmStation amFmStation = (AmFmStation)object;
        if (this.isHD() && amFmStation.isHD()) {
            return this.mStation.serviceId == amFmStation.mStation.serviceId;
        }
        return this.isHD() == amFmStation.isHD();
    }

    public void setRegionalisation(String string) {
        this.mRegString = string;
    }

    public void clear() {
        this.mStation = new Station();
    }

    public void clearAslStation() {
        this.init();
    }

    public void setName(String string) {
        this.mStation.name = string;
        this.mRealName = null;
    }

    public boolean equals(AmFmStation amFmStation, boolean bl) {
        boolean bl2 = false;
        bl2 = !bl ? this.equalsByFreq(amFmStation) : this.equalsByPI(amFmStation);
        return bl2;
    }

    public int getHMiConstantForStationWaveBand() {
        return AMFMUtil.convertDSIBandConstantToHMIBandConstant(this.mStation.getWaveband());
    }

    @Override
    public byte type() {
        byte by;
        switch (this.mStation.getWaveband()) {
            case 1: {
                by = 5;
                break;
            }
            case 2: 
            case 3: 
            case 4: {
                by = 4;
                break;
            }
            default: {
                by = 0;
            }
        }
        return by;
    }

    public Station getAsDSIStation() {
        return this.mStation;
    }

    public boolean isHD() {
        return this.mStation.hd;
    }

    private int getSubscriptionState() {
        return this.mStation.getSubscription();
    }

    public int getSubscriptionStateAsHMIConstant() {
        boolean bl = false;
        switch (this.mStation.getSubscription()) {
            default: 
        }
        return 0;
    }

    public boolean isCAInfoAvailable() {
        switch (this.getSubscriptionState()) {
            case 1: 
            case 2: {
                return true;
            }
        }
        return false;
    }

    public int getHDStateForAMList() {
        AmFmStation amFmStation = RadioData.getAmfmDatabase().getCurrentAMStation();
        if (this.mStation.hd || this.mStation.isFullDigital()) {
            if ((long)amFmStation.getFrequency() == this.mStation.getFrequency() && this.getHDStatus() == 0) {
                return 2;
            }
            if ((long)amFmStation.getFrequency() == this.mStation.getFrequency() && this.getHDStatus() == 2) {
                return 2;
            }
            return 1;
        }
        return 0;
    }

    public int getHDStateForFMList() {
        if (this.mStation.hd || this.mStation.isFullDigital()) {
            if (this.getHDStatus() == 0) {
                return 0;
            }
            if (this.getHDStatus() == 2) {
                return 2;
            }
            return 1;
        }
        return 3;
    }

    public int getHDStateForFMMulticastList() {
        if (this.mStation.isFullDigital()) {
            return 0;
        }
        if (this.mStation.hd) {
            return 1;
        }
        return 3;
    }

    public int getSubChannel() {
        if (this.isHD()) {
            if (this.mStation.getServiceId() == 0) {
                return 0;
            }
            return AMFMMath.log2(this.mStation.getServiceId()) + 1;
        }
        return -1;
    }

    @Override
    public void toString(LogMessage logMessage) {
        if (null == this.mStation.name) {
            this.mStation.name = "";
        }
        if (null == this.mStation.realPS) {
            this.mStation.realPS = "";
        }
        logMessage.append(" Frequency: ").append(this.mStation.getFrequency()).append(" ShortName: ").append(this.mStation.getShortNameHD()).append(" Name: ").append(this.mStation.getName()).append(" HD: ").append(this.mStation.isHd()).append(" ServiceID: ").append(this.mStation.getServiceId()).append("  Quality: ").append(LogUtil.fixLength(Integer.toString(this.mStation.receptionQuality), 2, true));
        if (this.mStation.rds) {
            logMessage.append("  RDS:  PI: ").append(AMFMMath.getPICode(this.mStation.pi)).append("  PS: ").append(LogUtil.fixLength(this.mStation.realPS, 8, false)).append("  scrll PS: ").append(LogUtil.fixLength(Boolean.toString(this.mStation.scrollingPS), 5, false)).append("  PTY: ").append(LogUtil.fixLength(Integer.toString(this.mStation.ptyCode), 2, true)).append("  TP: ").append(LogUtil.fixLength(Boolean.toString(this.mStation.tp), 5, false)).append("  TA: ").append(LogUtil.fixLength(Boolean.toString(this.mStation.ta), 5, false)).append("  CoChannel: ").append(LogUtil.fixLength(Boolean.toString(this.mStation.coChannel), 5, false)).append("  TMC: ").append(LogUtil.fixLength(Boolean.toString(this.mStation.tmc), 5, false));
        }
    }

    public LogMessage toLogString(LogMessage logMessage) {
        this.toString(logMessage);
        return logMessage;
    }

    public AmFmStation setShortNameHD(String string) {
        this.mStation.shortNameHD = string;
        return this;
    }

    public void setLongNameHD(String string) {
        this.mStation.longNameHD = string;
    }

    public AmFmStation setServiceId(int n) {
        this.mStation.serviceId = n;
        return this;
    }

    public int getServiceId() {
        return this.mStation.serviceId;
    }

    public boolean isSubService() {
        return this.mStation.serviceId > 1;
    }

    public AmFmStation setSubChannelBitMask(int n) {
        this.mChannelMask = n;
        this.setSubChannelCount(n);
        return this;
    }

    public int getSubChannelBitMask() {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("AslStation - sub channel mask : ").append(this.mChannelMask).log();
        }
        return this.mChannelMask;
    }

    public AmFmStation setHDStatus(int n) {
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("AslStation - Frequency : ").append(this.getFrequency()).append(" ServiceID : ").append(this.getServiceId()).append(" Set HD Status : ").append(n).log();
        }
        this.mHDStatus = n;
        return this;
    }

    public int getHDStatus() {
        return this.mHDStatus;
    }

    public AmFmStation setSubChannelCount(int n) {
        if (n > 0) {
            this.subChannelCount = AMFMMath.bitCount(n) - 1;
        }
        if (this.logger.isTraceEnabled(128)) {
            this.logger.trace(128).append("AslStation - set sub channel count : ").append(this.subChannelCount).log();
        }
        return this;
    }

    public int getSubChannelCount() {
        return this.subChannelCount;
    }

    public void setRdsPiIgnoreProperties() {
        if (null != RadioCodingAdapter.mAmFmCodingData) {
            if (RadioCodingAdapter.isPiActivated() && !ProgramIdentification.isValidPI(this.getPi())) {
                this.setName("");
            }
            if (RadioCodingAdapter.isPiActivated() && !AmfmRDSOption.get()) {
                this.setName("");
            }
            if (!RadioCodingAdapter.isPiActivated() || !AmfmRDSOption.get() && RadioCodingAdapter.isPiActivated()) {
                this.setTP(false);
                this.setTA(false);
                this.setPtyCode(-1);
            }
        }
    }

    public boolean match(AmFmStation amFmStation, int n) {
        if (this.getFrequency() > 0 && null != amFmStation) {
            if (RadioCodingAdapter.isPiActivated() && AmfmRDSOption.get() && n == 1 && (ProgramIdentification.isValidPI(amFmStation.getPi()) || ProgramIdentification.isValidPI(this.getPi()))) {
                if (!amFmStation.isRds() && ProgramIdentification.isValidPI(this.getPi())) {
                    return false;
                }
                if (ProgramIdentification.isLocalStation(amFmStation.getPi()) && ProgramIdentification.isLocalStation(this.getPi()) || !AmFmAlternativeFrequencySwitch.get()) {
                    return amFmStation.getFrequency() == this.getFrequency() && amFmStation.getPi() == this.getPi();
                }
                return amFmStation.getPi() == this.getPi();
            }
            if (this.getWaveband() == 1 && (amFmStation.getServiceId() > 0 || this.getServiceId() > 0)) {
                return amFmStation.getFrequency() == this.getFrequency() && amFmStation.getServiceId() == this.getServiceId() && this.getShortNameHD().equals(amFmStation.getShortNameHD());
            }
            if (ServiceManager.configManagerDiag.isFeatureFlagSet(2)) {
                return amFmStation.getFrequency() == this.getFrequency() && amFmStation.getServiceId() == this.getServiceId() && this.getShortNameHD().equals(amFmStation.getShortNameHD());
            }
            return amFmStation.getFrequency() == this.getFrequency();
        }
        return false;
    }

    private void setUniqueId() {
        this.uniqueId = RadioUtil.computeUniqueID(this);
    }

    public void setUniqueId(long l) {
        this.uniqueId = l;
    }

    public long getUniqueId() {
        return this.uniqueId;
    }

    public int getDbStationId() {
        RadioStationData radioStationData = RadioDataApi.getFmStationDataFromHmiDataBuffer(this);
        if (null != radioStationData) {
            return radioStationData.stationId;
        }
        return -1;
    }

    public boolean getMpsWithSpsAlreadyStored() {
        return this.isMPSwithSPSAlreadyStored;
    }

    public void setMpsWithSPSAlreadyStored(boolean bl) {
        this.isMPSwithSPSAlreadyStored = bl;
    }

    public boolean getMpsWithoutSPSAlreadyStored() {
        return this.isMPSWithoutSPSAlreadyStored;
    }

    public void setMpsWithoutSPSAlreadyStored(boolean bl) {
        this.isMPSWithoutSPSAlreadyStored = bl;
    }

    public ResourceLocator getStationArt() {
        return this.mStation.getStationArt();
    }

    public ResourceLocator setStationArt(ResourceLocator resourceLocator) {
        this.mStation.stationArt = resourceLocator;
        return this.mStation.stationArt;
    }
}

