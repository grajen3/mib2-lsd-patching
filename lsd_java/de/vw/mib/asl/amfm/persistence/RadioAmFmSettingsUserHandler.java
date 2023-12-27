/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.RadioAmFmSettings;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmSettingsPersistable;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class RadioAmFmSettingsUserHandler
extends AbstractPersistenceDataHandler {
    private final RadioAmFmSettings handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsUserHandler;

    RadioAmFmSettingsUserHandler(RadioAmFmSettings radioAmFmSettings, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && radioAmFmSettings == null) {
            throw new AssertionError();
        }
        this.handledPersistable = radioAmFmSettings;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 8: {
                this.handledPersistable.setRadiotextOption(bl);
                this.markAsProcessed(n);
                break;
            }
            case 9: {
                this.handledPersistable.setTpOption(bl);
                this.markAsProcessed(n);
                break;
            }
            case 10: {
                this.handledPersistable.setRdsOption(bl);
                this.markAsProcessed(n);
                break;
            }
            case 11: {
                this.handledPersistable.setAfOption(bl);
                this.markAsProcessed(n);
                break;
            }
            case 15: {
                this.handledPersistable.setPty31Option(bl);
                this.markAsProcessed(n);
                break;
            }
            case 18: {
                this.handledPersistable.setAmHdOption(bl);
                this.markAsProcessed(n);
                break;
            }
            case 19: {
                this.handledPersistable.setRadioTextPlusOption(bl);
                this.markAsProcessed(n);
                break;
            }
            case 21: {
                this.handledPersistable.setAutoStoreStationLogosActive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 39: {
                this.handledPersistable.setAutoStoreStationLogosActiveChangedByUser(bl);
                this.markAsProcessed(n);
                break;
            }
            case 22: {
                this.handledPersistable.setAfOnBeforeRdsOff(bl);
                this.markAsProcessed(n);
                break;
            }
            case 23: {
                this.handledPersistable.setRegFixBeforeRdsOff(bl);
                this.markAsProcessed(n);
                break;
            }
            case 24: {
                this.handledPersistable.setRadiotextOnBeforeRdsOff(bl);
                this.markAsProcessed(n);
                break;
            }
            case 25: {
                this.handledPersistable.setTpOnBeforeRdsOff(bl);
                this.markAsProcessed(n);
                break;
            }
            case 26: {
                this.handledPersistable.setAutoStoreStationLogosActiveBeforeRdsOff(bl);
                this.markAsProcessed(n);
                break;
            }
            case 27: {
                this.handledPersistable.setEnhancedRadioTextActive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 28: {
                this.handledPersistable.setEnhancedRadioTextActiveBeforeRdsOff(bl);
                this.markAsProcessed(n);
                break;
            }
            case 29: {
                this.handledPersistable.setHomeCountryAutoSelectionActive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 30: {
                this.handledPersistable.setFmHdOption(bl);
                this.markAsProcessed(n);
                break;
            }
            case 31: {
                this.handledPersistable.setFmHdFilter(bl);
                this.markAsProcessed(n);
                break;
            }
            case 32: {
                this.handledPersistable.setAmHdFilter(bl);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "boolean");
            }
        }
    }

    @Override
    public void handle(int n, char c2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "char");
    }

    @Override
    public void handle(int n, byte by) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "byte");
    }

    @Override
    public void handle(int n, short s) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "short");
    }

    @Override
    public void handle(int n, int n2) {
        switch (n) {
            case 12: {
                this.handledPersistable.setRegOption(n2);
                this.markAsProcessed(n);
                break;
            }
            case 13: {
                this.handledPersistable.setScopeOfArrowButton(n2);
                this.markAsProcessed(n);
                break;
            }
            case 14: {
                this.handledPersistable.setWaveBand(n2);
                this.markAsProcessed(n);
                break;
            }
            case 16: {
                this.handledPersistable.setFmViewState(n2);
                this.markAsProcessed(n);
                break;
            }
            case 17: {
                this.handledPersistable.setAmViewState(n2);
                this.markAsProcessed(n);
                break;
            }
            case 20: {
                this.handledPersistable.setFmStationListSortOrder(n2);
                this.markAsProcessed(n);
                break;
            }
            case 36: {
                this.handledPersistable.setJapanTiFrequency(n2);
                this.markAsProcessed(n);
                break;
            }
            case 37: {
                this.handledPersistable.setUserSelectedHomeCountry(n2);
                this.markAsProcessed(n);
                break;
            }
            case 38: {
                this.handledPersistable.setCalculatedHomeCountry(n2);
                this.markAsProcessed(n);
                break;
            }
            case 40: {
                this.handledPersistable.setDatabaseVersionMajor(n2);
                this.markAsProcessed(n);
                break;
            }
            case 41: {
                this.handledPersistable.setDatabaseVersionMinor(n2);
                this.markAsProcessed(n);
                break;
            }
            case 42: {
                this.handledPersistable.setDatabaseVersionRevision(n2);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "int");
            }
        }
    }

    @Override
    public void handle(int n, long l) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "long");
    }

    @Override
    public void handle(int n, float f2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "float");
    }

    @Override
    public void handle(int n, double d2) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "double");
    }

    @Override
    public void handle(int n, String string) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "String");
    }

    @Override
    public void handle(int n, Persistable persistable) {
        switch (n) {
            case 33: {
                this.handledPersistable.setCurrentFmStation((AmFmStationPersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 34: {
                this.handledPersistable.setCurrentAmStation((AmFmStationPersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "Persistable");
            }
        }
    }

    @Override
    public void handle(int n, Map$Entry map$Entry) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Map");
    }

    @Override
    public void handleEmptyCollection(int n) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "Container");
    }

    @Override
    protected int[] getFieldIds() {
        return new int[]{8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 39, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 36, 37, 38, 40, 41, 42};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 8: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRadiotextOption(AmFmSettingsPersistable.getDefaultRadiotextOptionValue());
                break;
            }
            case 9: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTpOption(AmFmSettingsPersistable.getDefaultTpOptionValue());
                break;
            }
            case 10: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRdsOption(AmFmSettingsPersistable.getDefaultRdsOptionValue());
                break;
            }
            case 11: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAfOption(AmFmSettingsPersistable.getDefaultAfOptionValue());
                break;
            }
            case 12: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRegOption(AmFmSettingsPersistable.getDefaultRegOptionValue());
                break;
            }
            case 13: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setScopeOfArrowButton(AmFmSettingsPersistable.getDefaultScopeOfArrowKeyModeValue());
                break;
            }
            case 14: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setWaveBand(AmFmSettingsPersistable.getDefaultWavebandValue());
                break;
            }
            case 15: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPty31Option(AmFmSettingsPersistable.getDefaultPty31OptionValue());
                break;
            }
            case 16: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setFmViewState(AmFmSettingsPersistable.getDefaultFmViewStateValue());
                break;
            }
            case 17: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAmViewState(AmFmSettingsPersistable.getDefaultAmViewStateValue());
                break;
            }
            case 18: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAmHdOption(AmFmSettingsPersistable.getDefaultAmHdOptionValue());
                break;
            }
            case 19: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRadioTextPlusOption(AmFmSettingsPersistable.getDefaultRadioTextPlusOptionValue());
                break;
            }
            case 20: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setFmStationListSortOrder(AmFmSettingsPersistable.getDefaultFmStationListSortOrderValue());
                break;
            }
            case 21: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAutoStoreStationLogosActive(AmFmSettingsPersistable.getDefaultAutoStoreStationLogosActiveValue());
                break;
            }
            case 39: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAutoStoreStationLogosActiveChangedByUser(AmFmSettingsPersistable.getDefaultAutoStoreStationLogosActiveChangedByUserValue());
                break;
            }
            case 22: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAfOnBeforeRdsOff(AmFmSettingsPersistable.getDefaultAfOnBeforeRdsOffValue());
                break;
            }
            case 23: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRegFixBeforeRdsOff(AmFmSettingsPersistable.getDefaultRegFixBeforeRdsOffValue());
                break;
            }
            case 24: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRadiotextOnBeforeRdsOff(AmFmSettingsPersistable.getDefaultRadiotextOnBeforeRdsOffValue());
                break;
            }
            case 25: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTpOnBeforeRdsOff(AmFmSettingsPersistable.getDefaultTpOnBeforeRdsOffValue());
                break;
            }
            case 26: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAutoStoreStationLogosActiveBeforeRdsOff(AmFmSettingsPersistable.getDefaultAutoStoreStationLogosActiveBeforeRdsOffValue());
                break;
            }
            case 27: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setEnhancedRadioTextActive(AmFmSettingsPersistable.getDefaultEnhancedRadioTextActiveValue());
                break;
            }
            case 28: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setEnhancedRadioTextActiveBeforeRdsOff(AmFmSettingsPersistable.getDefaultEnhancedRadioTextActiveBeforeRdsOffValue());
                break;
            }
            case 29: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setHomeCountryAutoSelectionActive(AmFmSettingsPersistable.getDefaultHomeCountryAutoSelectionActiveValue());
                break;
            }
            case 30: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setFmHdOption(AmFmSettingsPersistable.getDefaultFmHdOptionValue());
                break;
            }
            case 31: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setFmHdFilter(AmFmSettingsPersistable.getDefaultFmHdFilterValue());
                break;
            }
            case 32: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAmHdFilter(AmFmSettingsPersistable.getDefaultAmHdFilterValue());
                break;
            }
            case 33: {
                break;
            }
            case 34: {
                break;
            }
            case 36: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setJapanTiFrequency(AmFmSettingsPersistable.getDefaultJapanTiFrequencyValue());
                break;
            }
            case 37: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setUserSelectedHomeCountry(AmFmSettingsPersistable.getDefaultUserSelectedHomeCountryValue());
                break;
            }
            case 38: {
                this.handledPersistable.setCalculatedHomeCountry(-1);
                break;
            }
            case 40: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDatabaseVersionMajor(AmFmSettingsPersistable.getDefaultDatabaseVersionValue());
                break;
            }
            case 41: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDatabaseVersionMinor(AmFmSettingsPersistable.getDefaultDatabaseVersionValue());
                break;
            }
            case 42: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDatabaseVersionRevision(AmFmSettingsPersistable.getDefaultDatabaseVersionValue());
                break;
            }
            default: {
                this.getLogger().warn(32).append("Cannot install default value: Unknown field ID (").append(n).append(")").log();
            }
        }
    }

    @Override
    protected boolean validate() {
        return true;
    }

    @Override
    protected int getPersistableId() {
        return 1;
    }

    protected boolean performValidation() {
        return true;
    }

    protected boolean invokeExternalMethods() {
        return true;
    }

    void preventUnusedModuleWarning__doNotInvoke() {
        this.module.getVersion();
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }

    static {
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsUserHandler == null ? (class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsUserHandler = RadioAmFmSettingsUserHandler.class$("de.vw.mib.asl.amfm.persistence.RadioAmFmSettingsUserHandler")) : class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsUserHandler).desiredAssertionStatus();
    }
}

