/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;

public final class PersistableEngineType
extends AbstractSharedPersistable {
    private static final short VERSION;
    private static final short[] SUPPORTED_VERSIONS;
    private static final String TRACE_LITERAL_PERSISTABLE_ENGINE_TYPE;
    private static PersistableEngineType myInstance;
    private int primaryEngineType = -1;
    private int secondaryEngineType = -1;
    private boolean validEngineTypeCombination = false;
    private boolean flagEngineCombustion = false;
    private boolean flagEngineBEV = false;
    private boolean flagEnginePHEV = false;
    private int engineType = 0;
    private int primaryFuelType = 0;
    private int secondaryFuelType = 5;
    private boolean evaluateFlags = true;
    private int overwriteValue = Integer.parseInt(System.getProperty("de.vw.mib.OverwriteBevPhev", "-1"));

    private PersistableEngineType() {
        super(5000, 0);
    }

    @Override
    public short[] getSupportedVersions() {
        return SUPPORTED_VERSIONS;
    }

    @Override
    public short getVersion() {
        return 1;
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.primaryEngineType = persistenceInputStream.readByte();
        this.secondaryEngineType = persistenceInputStream.readByte();
        this.evaluateFeatureFlags();
        this.evaluateOverwrite();
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        persistenceOutputStream.writeByte(this.primaryEngineType);
        persistenceOutputStream.writeByte(this.secondaryEngineType);
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public void clear() {
        this.primaryEngineType = 7;
        this.secondaryEngineType = 0;
        this.evaluateFeatureFlags();
        this.evaluateOverwrite();
    }

    public static PersistableEngineType getInstance() {
        return myInstance;
    }

    public boolean getFeatureFlagValueCombustion() {
        return this.flagEngineCombustion;
    }

    public boolean getFeatureFlagValueBEV() {
        return this.flagEngineBEV;
    }

    public boolean getFeatureFlagValuePHEV() {
        return this.flagEnginePHEV;
    }

    public int getPrimaryEngineType() {
        return this.primaryEngineType;
    }

    public int getSecondaryEngineType() {
        return this.secondaryEngineType;
    }

    public void setEngineTypes(int n, int n2) {
        if (this.isTraceEnabled()) {
            ServiceManager.logger.trace(2048).append("[PersistableEngineType] ").append("GOT engine types: ").append(n).append(", ").append(n2).log();
        }
        if (this.primaryEngineType != n || this.secondaryEngineType != n2) {
            this.primaryEngineType = n;
            this.secondaryEngineType = n2;
            this.evaluateFlags = true;
            this.evaluateFeatureFlags();
            this.markDirty(true);
        }
        this.evaluateOverwrite();
    }

    private boolean isTraceEnabled() {
        return ServiceManager.logger.isTraceEnabled(2048);
    }

    private void evaluateOverwrite() {
        if (this.overwriteValue != -1) {
            ServiceManager.logger.info(2048).append("[PersistableEngineType] ").append("Flag de.vw.mib.OverwriteBevPhev set to ").append(this.overwriteValue).append(". Overwrite BEV/PHEV!").log();
            int n = 10;
            this.primaryEngineType = this.overwriteValue / 10;
            this.secondaryEngineType = this.overwriteValue % 10;
            this.evaluateFlags = true;
            this.evaluateFeatureFlags();
        }
    }

    private void evaluateFeatureFlags() {
        if (this.evaluateFlags) {
            this.validEngineTypeCombination = false;
            this.flagEngineCombustion = false;
            this.flagEngineBEV = false;
            this.flagEnginePHEV = false;
            block0 : switch (this.primaryEngineType) {
                case 3: {
                    switch (this.secondaryEngineType) {
                        case 0: {
                            this.setBEVType();
                            break block0;
                        }
                        case 6: 
                        case 7: {
                            this.setPHEVType(this.secondaryEngineType);
                            break block0;
                        }
                    }
                    break;
                }
                case 8: 
                case 9: {
                    if (this.secondaryEngineType != 7) break;
                    this.setBivalentType(this.primaryEngineType);
                    break;
                }
                case 6: {
                    switch (this.secondaryEngineType) {
                        case 0: {
                            this.setCombustionType(this.primaryEngineType, true);
                            break block0;
                        }
                        case 3: {
                            this.setPHEVType(this.primaryEngineType);
                            break block0;
                        }
                    }
                    break;
                }
                case 7: {
                    switch (this.secondaryEngineType) {
                        case 0: {
                            this.setCombustionType(this.primaryEngineType, true);
                            break block0;
                        }
                        case 8: 
                        case 9: {
                            this.setBivalentType(this.secondaryEngineType);
                            break block0;
                        }
                        case 3: {
                            this.setPHEVType(this.primaryEngineType);
                            break block0;
                        }
                    }
                    break;
                }
                case 2: {
                    ServiceManager.logger.warn(2048).append("[PersistableEngineType] ").append("Primary Enginetype GAS (0x02) is deprecated and wont work, use Enginetype GAS_CNG (0x08)/GAS_LPG (0x09) instead!").log();
                    break;
                }
                case 1: {
                    ServiceManager.logger.warn(2048).append("[PersistableEngineType] ").append("Primary Enginetype PETROL (0x01) is deprecated and wont work, use Enginetype PETROL_DIESEL (0x06)/PETROL_GASOLINE (0x07) instead!").log();
                    break;
                }
                case 5: {
                    ServiceManager.logger.warn(2048).append("[PersistableEngineType] ").append("Primary Enginetype NOT_SUPPORTED detected!").log();
                    break;
                }
                case 0: {
                    ServiceManager.logger.warn(2048).append("[PersistableEngineType] ").append("Primary Enginetype NOT_INSTALLED detected!").log();
                    break;
                }
                case 4: {
                    ServiceManager.logger.warn(2048).append("[PersistableEngineType] ").append("Primary Enginetype UNKNOWN detected!").log();
                    break;
                }
            }
            switch (this.secondaryEngineType) {
                case 2: {
                    ServiceManager.logger.warn(2048).append("[PersistableEngineType] ").append("Secondary Enginetype GAS (0x02) is deprecated and wont work, use Enginetype GAS_CNG (0x08)/GAS_LPG (0x09) instead!").log();
                    break;
                }
                case 1: {
                    ServiceManager.logger.warn(2048).append("[PersistableEngineType] ").append("Secondary Enginetype PETROL (0x01) is deprecated and wont work, use Enginetype PETROL_DIESEL (0x06)/PETROL_GASOLINE (0x07) instead!").log();
                    break;
                }
                case 4: {
                    ServiceManager.logger.warn(2048).append("[PersistableEngineType] ").append("Secondary Enginetype UNKNOWN detected!").log();
                    break;
                }
            }
            if (!this.validEngineTypeCombination) {
                ServiceManager.logger.error(2048).append("[PersistableEngineType] ").append("Invalid engine type combination: ").append(this.primaryEngineType).append("/").append(this.secondaryEngineType).append(", setting to default (combustion petrol gasoline)").log();
                this.setCombustionType(7, false);
            }
            ServiceManager.aslPropertyManager.valueChangedBoolean(345053184, this.flagEngineCombustion);
            ServiceManager.aslPropertyManager.valueChangedBoolean(361830400, this.flagEngineBEV);
            ServiceManager.aslPropertyManager.valueChangedBoolean(378607616, this.flagEnginePHEV);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isEngineCombustion", this.flagEngineCombustion);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isEngineBEV", this.flagEngineBEV);
            ServiceManager.configManagerDiag.setFeatureFlagValue("ASL.Configuration.isEnginePHEV", this.flagEnginePHEV);
            ServiceManager.configManagerDiag.setEngineType(this.engineType);
            ServiceManager.configManagerDiag.setPrimaryFuelType(this.primaryFuelType);
            ServiceManager.configManagerDiag.setSecondaryFuelType(this.secondaryFuelType);
            this.evaluateFlags = false;
        }
    }

    private void traceInfoDetected(String string) {
        ServiceManager.logger.info(2048).append("[PersistableEngineType] ").append(" engineTypes: (").append(this.primaryEngineType).append("/").append(this.secondaryEngineType).append(") ").append(string).append(" detected").log();
    }

    private void setBEVType() {
        this.traceInfoDetected("BEV");
        this.validEngineTypeCombination = true;
        this.flagEngineCombustion = false;
        this.flagEngineBEV = true;
        this.flagEnginePHEV = false;
        this.engineType = 1;
        this.primaryFuelType = 4;
        this.secondaryFuelType = 5;
    }

    private void setBivalentType(int n) {
        this.traceInfoDetected("BIVALENT");
        this.validEngineTypeCombination = true;
        this.flagEngineCombustion = true;
        this.flagEngineBEV = false;
        this.flagEnginePHEV = false;
        this.engineType = 0;
        this.secondaryFuelType = 0;
        this.primaryFuelType = n == 8 ? 2 : 3;
    }

    private void setCombustionType(int n, boolean bl) {
        if (bl) {
            this.traceInfoDetected("COMBUSTION");
        }
        this.validEngineTypeCombination = true;
        this.flagEngineCombustion = true;
        this.flagEngineBEV = false;
        this.flagEnginePHEV = false;
        this.engineType = 0;
        this.secondaryFuelType = 5;
        this.primaryFuelType = n == 7 ? 0 : 1;
    }

    private void setPHEVType(int n) {
        this.traceInfoDetected("PHEV");
        this.validEngineTypeCombination = true;
        this.flagEngineCombustion = false;
        this.flagEngineBEV = false;
        this.flagEnginePHEV = true;
        this.engineType = 2;
        this.secondaryFuelType = 4;
        this.primaryFuelType = n == 7 ? 0 : 1;
    }

    static {
        SUPPORTED_VERSIONS = NO_SUPPORTED_VERSION;
        myInstance = new PersistableEngineType();
    }
}

