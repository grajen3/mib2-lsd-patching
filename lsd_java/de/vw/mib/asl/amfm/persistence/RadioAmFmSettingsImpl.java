/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettings;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.framework.api.persistence.ASLPersistenceFactory;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.HandlerFactory;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;

class RadioAmFmSettingsImpl
extends AbstractPersistable
implements RadioAmFmSettings {
    private final PersistenceModule module;
    private boolean radiotextOption;
    private boolean tpOption;
    private boolean rdsOption;
    private boolean rdsValueInCoding;
    private boolean afOption;
    private boolean afValueInCoding;
    private int regOption;
    private int amRangeOption;
    private int scopeOfArrowButton;
    private int waveBand;
    private boolean pty31Option;
    private int fmRange;
    private int fmViewState;
    private int amViewState;
    private boolean amHdOption;
    private boolean radioTextPlusOption;
    private int fmStationListSortOrder;
    private boolean autoStoreStationLogosActive;
    private boolean autoStoreStationLogosActiveChangedByUser;
    private boolean afOnBeforeRdsOff;
    private boolean regFixBeforeRdsOff;
    private boolean radiotextOnBeforeRdsOff;
    private boolean tpOnBeforeRdsOff;
    private boolean autoStoreStationLogosActiveBeforeRdsOff;
    private boolean enhancedRadioTextActive;
    private boolean enhancedRadioTextActiveBeforeRdsOff;
    private boolean homeCountryAutoSelectionActive;
    private boolean fmHdOption;
    private boolean fmHdFilter;
    private boolean amHdFilter;
    private AmFmStationPersistence currentFmStation;
    private AmFmStationPersistence currentAmStation;
    private int japanTiFrequency;
    private int userSelectedHomeCountry;
    private int calculatedHomeCountry;
    private int databaseVersionMajor;
    private int databaseVersionMinor;
    private int databaseVersionRevision;
    private int amFmNoOfPresets;
    private int dabNoOfPresets;

    RadioAmFmSettingsImpl(PersistenceModule persistenceModule) {
        super(ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger(), ASLPersistenceFactory.getPersistenceApi());
        this.module = persistenceModule;
    }

    @Override
    public int getId() {
        return 1;
    }

    @Override
    public boolean hasUserSpecificData() {
        return true;
    }

    @Override
    public void updateRootPersistable(Persistable persistable) {
        this.setRootPersistable(persistable);
        if (this.getCurrentFmStation() != null) {
            this.getCurrentFmStation().updateRootPersistable(persistable);
        }
        if (this.getCurrentAmStation() != null) {
            this.getCurrentAmStation().updateRootPersistable(persistable);
        }
    }

    @Override
    public boolean isRadiotextOption() {
        return this.radiotextOption;
    }

    @Override
    public void setRadiotextOption(boolean bl) {
        this.radiotextOption = bl;
        this.markDirty();
    }

    @Override
    public boolean isTpOption() {
        return this.tpOption;
    }

    @Override
    public void setTpOption(boolean bl) {
        this.tpOption = bl;
        this.markDirty();
    }

    @Override
    public boolean isRdsOption() {
        return this.rdsOption;
    }

    @Override
    public void setRdsOption(boolean bl) {
        this.rdsOption = bl;
        this.markDirty();
    }

    @Override
    public boolean isRdsValueInCoding() {
        return this.rdsValueInCoding;
    }

    @Override
    public void setRdsValueInCoding(boolean bl) {
        this.rdsValueInCoding = bl;
        this.markDirty();
    }

    @Override
    public boolean isAfOption() {
        return this.afOption;
    }

    @Override
    public void setAfOption(boolean bl) {
        this.afOption = bl;
        this.markDirty();
    }

    @Override
    public boolean isAfValueInCoding() {
        return this.afValueInCoding;
    }

    @Override
    public void setAfValueInCoding(boolean bl) {
        this.afValueInCoding = bl;
        this.markDirty();
    }

    @Override
    public int getRegOption() {
        return this.regOption;
    }

    @Override
    public void setRegOption(int n) {
        this.regOption = n;
        this.markDirty();
    }

    @Override
    public int getAmRangeOption() {
        return this.amRangeOption;
    }

    @Override
    public void setAmRangeOption(int n) {
        this.amRangeOption = n;
        this.markDirty();
    }

    @Override
    public int getScopeOfArrowButton() {
        return this.scopeOfArrowButton;
    }

    @Override
    public void setScopeOfArrowButton(int n) {
        this.scopeOfArrowButton = n;
        this.markDirty();
    }

    @Override
    public int getWaveBand() {
        return this.waveBand;
    }

    @Override
    public void setWaveBand(int n) {
        this.waveBand = n;
        this.markDirty();
    }

    @Override
    public boolean isPty31Option() {
        return this.pty31Option;
    }

    @Override
    public void setPty31Option(boolean bl) {
        this.pty31Option = bl;
        this.markDirty();
    }

    @Override
    public int getFmRange() {
        return this.fmRange;
    }

    @Override
    public void setFmRange(int n) {
        this.fmRange = n;
        this.markDirty();
    }

    @Override
    public int getFmViewState() {
        return this.fmViewState;
    }

    @Override
    public void setFmViewState(int n) {
        this.fmViewState = n;
        this.markDirty();
    }

    @Override
    public int getAmViewState() {
        return this.amViewState;
    }

    @Override
    public void setAmViewState(int n) {
        this.amViewState = n;
        this.markDirty();
    }

    @Override
    public boolean isAmHdOption() {
        return this.amHdOption;
    }

    @Override
    public void setAmHdOption(boolean bl) {
        this.amHdOption = bl;
        this.markDirty();
    }

    @Override
    public boolean isRadioTextPlusOption() {
        return this.radioTextPlusOption;
    }

    @Override
    public void setRadioTextPlusOption(boolean bl) {
        this.radioTextPlusOption = bl;
        this.markDirty();
    }

    @Override
    public int getFmStationListSortOrder() {
        return this.fmStationListSortOrder;
    }

    @Override
    public void setFmStationListSortOrder(int n) {
        this.fmStationListSortOrder = n;
        this.markDirty();
    }

    @Override
    public boolean isAutoStoreStationLogosActive() {
        return this.autoStoreStationLogosActive;
    }

    @Override
    public void setAutoStoreStationLogosActive(boolean bl) {
        this.autoStoreStationLogosActive = bl;
        this.markDirty();
    }

    @Override
    public boolean isAutoStoreStationLogosActiveChangedByUser() {
        return this.autoStoreStationLogosActiveChangedByUser;
    }

    @Override
    public void setAutoStoreStationLogosActiveChangedByUser(boolean bl) {
        this.autoStoreStationLogosActiveChangedByUser = bl;
        this.markDirty();
    }

    @Override
    public boolean isAfOnBeforeRdsOff() {
        return this.afOnBeforeRdsOff;
    }

    @Override
    public void setAfOnBeforeRdsOff(boolean bl) {
        this.afOnBeforeRdsOff = bl;
        this.markDirty();
    }

    @Override
    public boolean isRegFixBeforeRdsOff() {
        return this.regFixBeforeRdsOff;
    }

    @Override
    public void setRegFixBeforeRdsOff(boolean bl) {
        this.regFixBeforeRdsOff = bl;
        this.markDirty();
    }

    @Override
    public boolean isRadiotextOnBeforeRdsOff() {
        return this.radiotextOnBeforeRdsOff;
    }

    @Override
    public void setRadiotextOnBeforeRdsOff(boolean bl) {
        this.radiotextOnBeforeRdsOff = bl;
        this.markDirty();
    }

    @Override
    public boolean isTpOnBeforeRdsOff() {
        return this.tpOnBeforeRdsOff;
    }

    @Override
    public void setTpOnBeforeRdsOff(boolean bl) {
        this.tpOnBeforeRdsOff = bl;
        this.markDirty();
    }

    @Override
    public boolean isAutoStoreStationLogosActiveBeforeRdsOff() {
        return this.autoStoreStationLogosActiveBeforeRdsOff;
    }

    @Override
    public void setAutoStoreStationLogosActiveBeforeRdsOff(boolean bl) {
        this.autoStoreStationLogosActiveBeforeRdsOff = bl;
        this.markDirty();
    }

    @Override
    public boolean isEnhancedRadioTextActive() {
        return this.enhancedRadioTextActive;
    }

    @Override
    public void setEnhancedRadioTextActive(boolean bl) {
        this.enhancedRadioTextActive = bl;
        this.markDirty();
    }

    @Override
    public boolean isEnhancedRadioTextActiveBeforeRdsOff() {
        return this.enhancedRadioTextActiveBeforeRdsOff;
    }

    @Override
    public void setEnhancedRadioTextActiveBeforeRdsOff(boolean bl) {
        this.enhancedRadioTextActiveBeforeRdsOff = bl;
        this.markDirty();
    }

    @Override
    public boolean isHomeCountryAutoSelectionActive() {
        return this.homeCountryAutoSelectionActive;
    }

    @Override
    public void setHomeCountryAutoSelectionActive(boolean bl) {
        this.homeCountryAutoSelectionActive = bl;
        this.markDirty();
    }

    @Override
    public boolean isFmHdOption() {
        return this.fmHdOption;
    }

    @Override
    public void setFmHdOption(boolean bl) {
        this.fmHdOption = bl;
        this.markDirty();
    }

    @Override
    public boolean isFmHdFilter() {
        return this.fmHdFilter;
    }

    @Override
    public void setFmHdFilter(boolean bl) {
        this.fmHdFilter = bl;
        this.markDirty();
    }

    @Override
    public boolean isAmHdFilter() {
        return this.amHdFilter;
    }

    @Override
    public void setAmHdFilter(boolean bl) {
        this.amHdFilter = bl;
        this.markDirty();
    }

    @Override
    public AmFmStationPersistence getCurrentFmStation() {
        return this.currentFmStation;
    }

    @Override
    public void setCurrentFmStation(AmFmStationPersistence amFmStationPersistence) {
        this.currentFmStation = amFmStationPersistence;
        this.markDirty();
    }

    @Override
    public AmFmStationPersistence getCurrentAmStation() {
        return this.currentAmStation;
    }

    @Override
    public void setCurrentAmStation(AmFmStationPersistence amFmStationPersistence) {
        this.currentAmStation = amFmStationPersistence;
        this.markDirty();
    }

    @Override
    public int getJapanTiFrequency() {
        return this.japanTiFrequency;
    }

    @Override
    public void setJapanTiFrequency(int n) {
        this.japanTiFrequency = n;
        this.markDirty();
    }

    @Override
    public int getUserSelectedHomeCountry() {
        return this.userSelectedHomeCountry;
    }

    @Override
    public void setUserSelectedHomeCountry(int n) {
        this.userSelectedHomeCountry = n;
        this.markDirty();
    }

    @Override
    public int getCalculatedHomeCountry() {
        return this.calculatedHomeCountry;
    }

    @Override
    public void setCalculatedHomeCountry(int n) {
        this.calculatedHomeCountry = n;
        this.markDirty();
    }

    @Override
    public int getDatabaseVersionMajor() {
        return this.databaseVersionMajor;
    }

    @Override
    public void setDatabaseVersionMajor(int n) {
        this.databaseVersionMajor = n;
        this.markDirty();
    }

    @Override
    public int getDatabaseVersionMinor() {
        return this.databaseVersionMinor;
    }

    @Override
    public void setDatabaseVersionMinor(int n) {
        this.databaseVersionMinor = n;
        this.markDirty();
    }

    @Override
    public int getDatabaseVersionRevision() {
        return this.databaseVersionRevision;
    }

    @Override
    public void setDatabaseVersionRevision(int n) {
        this.databaseVersionRevision = n;
        this.markDirty();
    }

    @Override
    public int getAmFmNoOfPresets() {
        return this.amFmNoOfPresets;
    }

    @Override
    public void setAmFmNoOfPresets(int n) {
        this.amFmNoOfPresets = n;
        this.markDirty();
    }

    @Override
    public int getDabNoOfPresets() {
        return this.dabNoOfPresets;
    }

    @Override
    public void setDabNoOfPresets(int n) {
        this.dabNoOfPresets = n;
        this.markDirty();
    }

    @Override
    public void resetToDefaults() {
        HandlerFactory handlerFactory = this.module.getHandlerFactory();
        handlerFactory.createCommonHandler(this).finish();
        handlerFactory.createUserHandler(this).finish();
    }
}

