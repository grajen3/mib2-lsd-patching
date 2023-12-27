/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class AmFmStationPersistenceImpl
extends AbstractPersistable
implements AmFmStationPersistence {
    private final PersistenceModule module;
    private String stationName;
    private long stationFrequency;
    private int stationPi;
    private int stationReceptionQuality;
    private int stationPtyCode;
    private int stationWaveband;
    private boolean stationRds;
    private boolean stationTp;
    private boolean stationTa;
    private boolean stationTmc;
    private boolean stationScrollingPs;
    private boolean stationRadioText;
    private String stationRealPs;
    private boolean stationHd;
    private String stationShortNameHd;
    private String stationLongNameHd;
    private boolean stationFullDigital;
    private int stationServiceId;
    private int stationSubscription;
    private boolean stationEon;
    private boolean stationCoChannel;
    private String realName;
    private String regString;
    private int hdStatus;
    private int subChannelCount;
    private int channelMask;
    private long uniqueId;
    private boolean mpsWithSPSAlreadyStored;
    private boolean mpsWithoutSPSAlreadyStored;
    private ResourceLocatorPersistence stationImage;

    AmFmStationPersistenceImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 2;
    }

    @Override
    public boolean hasUserSpecificData() {
        return false;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        if (this.getStationImage() != null) {
            this.getStationImage().updateRootPersistable(persistable);
        }
    }

    @Override
    public String getStationName() {
        return this.stationName;
    }

    @Override
    public void setStationName(String string) {
        this.stationName = string;
        this.markDirty();
    }

    @Override
    public long getStationFrequency() {
        return this.stationFrequency;
    }

    @Override
    public void setStationFrequency(long l) {
        this.stationFrequency = l;
        this.markDirty();
    }

    @Override
    public int getStationPi() {
        return this.stationPi;
    }

    @Override
    public void setStationPi(int n) {
        this.stationPi = n;
        this.markDirty();
    }

    @Override
    public int getStationReceptionQuality() {
        return this.stationReceptionQuality;
    }

    @Override
    public void setStationReceptionQuality(int n) {
        this.stationReceptionQuality = n;
        this.markDirty();
    }

    @Override
    public int getStationPtyCode() {
        return this.stationPtyCode;
    }

    @Override
    public void setStationPtyCode(int n) {
        this.stationPtyCode = n;
        this.markDirty();
    }

    @Override
    public int getStationWaveband() {
        return this.stationWaveband;
    }

    @Override
    public void setStationWaveband(int n) {
        this.stationWaveband = n;
        this.markDirty();
    }

    @Override
    public boolean isStationRds() {
        return this.stationRds;
    }

    @Override
    public void setStationRds(boolean bl) {
        this.stationRds = bl;
        this.markDirty();
    }

    @Override
    public boolean isStationTp() {
        return this.stationTp;
    }

    @Override
    public void setStationTp(boolean bl) {
        this.stationTp = bl;
        this.markDirty();
    }

    @Override
    public boolean isStationTa() {
        return this.stationTa;
    }

    @Override
    public void setStationTa(boolean bl) {
        this.stationTa = bl;
        this.markDirty();
    }

    @Override
    public boolean isStationTmc() {
        return this.stationTmc;
    }

    @Override
    public void setStationTmc(boolean bl) {
        this.stationTmc = bl;
        this.markDirty();
    }

    @Override
    public boolean isStationScrollingPs() {
        return this.stationScrollingPs;
    }

    @Override
    public void setStationScrollingPs(boolean bl) {
        this.stationScrollingPs = bl;
        this.markDirty();
    }

    @Override
    public boolean isStationRadioText() {
        return this.stationRadioText;
    }

    @Override
    public void setStationRadioText(boolean bl) {
        this.stationRadioText = bl;
        this.markDirty();
    }

    @Override
    public String getStationRealPs() {
        return this.stationRealPs;
    }

    @Override
    public void setStationRealPs(String string) {
        this.stationRealPs = string;
        this.markDirty();
    }

    @Override
    public boolean isStationHd() {
        return this.stationHd;
    }

    @Override
    public void setStationHd(boolean bl) {
        this.stationHd = bl;
        this.markDirty();
    }

    @Override
    public String getStationShortNameHd() {
        return this.stationShortNameHd;
    }

    @Override
    public void setStationShortNameHd(String string) {
        this.stationShortNameHd = string;
        this.markDirty();
    }

    @Override
    public String getStationLongNameHd() {
        return this.stationLongNameHd;
    }

    @Override
    public void setStationLongNameHd(String string) {
        this.stationLongNameHd = string;
        this.markDirty();
    }

    @Override
    public boolean isStationFullDigital() {
        return this.stationFullDigital;
    }

    @Override
    public void setStationFullDigital(boolean bl) {
        this.stationFullDigital = bl;
        this.markDirty();
    }

    @Override
    public int getStationServiceId() {
        return this.stationServiceId;
    }

    @Override
    public void setStationServiceId(int n) {
        this.stationServiceId = n;
        this.markDirty();
    }

    @Override
    public int getStationSubscription() {
        return this.stationSubscription;
    }

    @Override
    public void setStationSubscription(int n) {
        this.stationSubscription = n;
        this.markDirty();
    }

    @Override
    public boolean isStationEon() {
        return this.stationEon;
    }

    @Override
    public void setStationEon(boolean bl) {
        this.stationEon = bl;
        this.markDirty();
    }

    @Override
    public boolean isStationCoChannel() {
        return this.stationCoChannel;
    }

    @Override
    public void setStationCoChannel(boolean bl) {
        this.stationCoChannel = bl;
        this.markDirty();
    }

    @Override
    public String getRealName() {
        return this.realName;
    }

    @Override
    public void setRealName(String string) {
        this.realName = string;
        this.markDirty();
    }

    @Override
    public String getRegString() {
        return this.regString;
    }

    @Override
    public void setRegString(String string) {
        this.regString = string;
        this.markDirty();
    }

    @Override
    public int getHdStatus() {
        return this.hdStatus;
    }

    @Override
    public void setHdStatus(int n) {
        this.hdStatus = n;
        this.markDirty();
    }

    @Override
    public int getSubChannelCount() {
        return this.subChannelCount;
    }

    @Override
    public void setSubChannelCount(int n) {
        this.subChannelCount = n;
        this.markDirty();
    }

    @Override
    public int getChannelMask() {
        return this.channelMask;
    }

    @Override
    public void setChannelMask(int n) {
        this.channelMask = n;
        this.markDirty();
    }

    @Override
    public long getUniqueId() {
        return this.uniqueId;
    }

    @Override
    public void setUniqueId(long l) {
        this.uniqueId = l;
        this.markDirty();
    }

    @Override
    public boolean isMpsWithSPSAlreadyStored() {
        return this.mpsWithSPSAlreadyStored;
    }

    @Override
    public void setMpsWithSPSAlreadyStored(boolean bl) {
        this.mpsWithSPSAlreadyStored = bl;
        this.markDirty();
    }

    @Override
    public boolean isMpsWithoutSPSAlreadyStored() {
        return this.mpsWithoutSPSAlreadyStored;
    }

    @Override
    public void setMpsWithoutSPSAlreadyStored(boolean bl) {
        this.mpsWithoutSPSAlreadyStored = bl;
        this.markDirty();
    }

    @Override
    public ResourceLocatorPersistence getStationImage() {
        return this.stationImage;
    }

    @Override
    public void setStationImage(ResourceLocatorPersistence resourceLocatorPersistence) {
        this.stationImage = resourceLocatorPersistence;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
    }
}

