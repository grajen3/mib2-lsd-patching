/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.system.persistence.PersistenceDefaults;
import de.vw.mib.asl.systemcommon.persistence.Units;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class UnitsUserHandler
extends AbstractPersistenceDataHandler {
    private final Units handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$systemcommon$persistence$UnitsUserHandler;

    UnitsUserHandler(Units units, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && units == null) {
            throw new AssertionError();
        }
        this.handledPersistable = units;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            default: 
        }
        this.logUnknownField(n, "boolean");
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
            case 1: {
                this.handledPersistable.setDistanceUnit(n2);
                this.markAsProcessed(n);
                break;
            }
            case 2: {
                this.handledPersistable.setTemperatureUnit(n2);
                this.markAsProcessed(n);
                break;
            }
            case 3: {
                this.handledPersistable.setVolumeUnit(n2);
                this.markAsProcessed(n);
                break;
            }
            case 4: {
                this.handledPersistable.setPetrolConsumptionUnit(n2);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setGasConsumptionUnit(n2);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                this.handledPersistable.setElectricConsumptionUnit(n2);
                this.markAsProcessed(n);
                break;
            }
            case 7: {
                this.handledPersistable.setPressureUnit(n2);
                this.markAsProcessed(n);
                break;
            }
            case 8: {
                this.handledPersistable.setSpeedUnit(n2);
                this.markAsProcessed(n);
                break;
            }
            case 9: {
                this.handledPersistable.setAstaWeightUnit(n2);
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
            default: 
        }
        this.logUnknownField(n, "Persistable");
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
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 1: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDistanceUnit(PersistenceDefaults.getDefaultDistanceUnit());
                break;
            }
            case 2: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTemperatureUnit(PersistenceDefaults.getDefaultTemperatureUnit());
                break;
            }
            case 3: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setVolumeUnit(PersistenceDefaults.getDefaultVolumeUnit());
                break;
            }
            case 4: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPetrolConsumptionUnit(PersistenceDefaults.getDefaultPetrolConsumptionUnit());
                break;
            }
            case 5: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setGasConsumptionUnit(PersistenceDefaults.getDefaultGasConsumptionUnit());
                break;
            }
            case 6: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setElectricConsumptionUnit(PersistenceDefaults.getDefaultElectricConsumptionUnit());
                break;
            }
            case 7: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setPressureUnit(PersistenceDefaults.getDefaultPressureUnit());
                break;
            }
            case 8: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSpeedUnit(PersistenceDefaults.getDefaultSpeedUnit());
                break;
            }
            case 9: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAstaWeightUnit(PersistenceDefaults.getDefaultAstaWeightUnit());
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
        return 3;
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
        $assertionsDisabled = !(class$de$vw$mib$asl$systemcommon$persistence$UnitsUserHandler == null ? (class$de$vw$mib$asl$systemcommon$persistence$UnitsUserHandler = UnitsUserHandler.class$("de.vw.mib.asl.systemcommon.persistence.UnitsUserHandler")) : class$de$vw$mib$asl$systemcommon$persistence$UnitsUserHandler).desiredAssertionStatus();
    }
}

