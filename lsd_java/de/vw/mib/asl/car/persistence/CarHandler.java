/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.car.persistence;

import de.vw.mib.asl.car.persistence.Car;
import de.vw.mib.asl.car.persistence.CarOffroad;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class CarHandler
extends AbstractPersistenceDataHandler {
    private final Car handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$car$persistence$CarHandler;

    CarHandler(Car car, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && car == null) {
            throw new AssertionError();
        }
        this.handledPersistable = car;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 31: {
                this.handledPersistable.setFrontWindowHeater(bl);
                this.markAsProcessed(n);
                break;
            }
            case 32: {
                this.handledPersistable.setSteeringWheelheater(bl);
                this.markAsProcessed(n);
                break;
            }
            case 33: {
                this.handledPersistable.setFifthCamera(bl);
                this.markAsProcessed(n);
                break;
            }
            case 34: {
                this.handledPersistable.setHDC(bl);
                this.markAsProcessed(n);
                break;
            }
            case 35: {
                this.handledPersistable.setAmbientLight(bl);
                this.markAsProcessed(n);
                break;
            }
            case 37: {
                this.handledPersistable.setPersonalization(bl);
                this.markAsProcessed(n);
                break;
            }
            case 38: {
                this.handledPersistable.setTurboCharger(bl);
                this.markAsProcessed(n);
                break;
            }
            case 39: {
                this.handledPersistable.setPowerInstrument(bl);
                this.markAsProcessed(n);
                break;
            }
            case 40: {
                this.handledPersistable.setClimateSetupButton(bl);
                this.markAsProcessed(n);
                break;
            }
            case 50: {
                this.handledPersistable.setTrailerModeRouteCalculation(bl);
                this.markAsProcessed(n);
                break;
            }
            case 51: {
                this.handledPersistable.setButtonStartStopNoticeHighlighted(bl);
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
            case 49: {
                this.handledPersistable.setIntLightColor(n2);
                this.markAsProcessed(n);
                break;
            }
            case 41: {
                this.handledPersistable.setRDKSystem(n2);
                this.markAsProcessed(n);
                break;
            }
            case 42: {
                this.handledPersistable.setRDKLoadChange(n2);
                this.markAsProcessed(n);
                break;
            }
            case 43: {
                this.handledPersistable.setSportLeftTube(n2);
                this.markAsProcessed(n);
                break;
            }
            case 44: {
                this.handledPersistable.setSportMiddleTube(n2);
                this.markAsProcessed(n);
                break;
            }
            case 45: {
                this.handledPersistable.setSportRightTube(n2);
                this.markAsProcessed(n);
                break;
            }
            case 46: {
                this.handledPersistable.setOffroadLeftTube(n2);
                this.markAsProcessed(n);
                break;
            }
            case 47: {
                this.handledPersistable.setOffroadMiddleTube(n2);
                this.markAsProcessed(n);
                break;
            }
            case 48: {
                this.handledPersistable.setOffroadRightTube(n2);
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
            case 60: {
                if (!this.performValidation() || persistable != null) {
                    this.handledPersistable.setCarOffroad((CarOffroad)persistable);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value must not be null.").log();
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
        return new int[]{31, 32, 33, 34, 35, 49, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 50, 51, 60};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 31: {
                this.handledPersistable.setFrontWindowHeater(false);
                break;
            }
            case 32: {
                this.handledPersistable.setSteeringWheelheater(false);
                break;
            }
            case 33: {
                this.handledPersistable.setFifthCamera(false);
                break;
            }
            case 34: {
                this.handledPersistable.setHDC(false);
                break;
            }
            case 35: {
                this.handledPersistable.setAmbientLight(false);
                break;
            }
            case 49: {
                this.handledPersistable.setIntLightColor(0);
                break;
            }
            case 37: {
                this.handledPersistable.setPersonalization(false);
                break;
            }
            case 38: {
                this.handledPersistable.setTurboCharger(false);
                break;
            }
            case 39: {
                this.handledPersistable.setPowerInstrument(false);
                break;
            }
            case 40: {
                this.handledPersistable.setClimateSetupButton(false);
                break;
            }
            case 41: {
                this.handledPersistable.setRDKSystem(0);
                break;
            }
            case 42: {
                this.handledPersistable.setRDKLoadChange(0);
                break;
            }
            case 43: {
                this.handledPersistable.setSportLeftTube(0);
                break;
            }
            case 44: {
                this.handledPersistable.setSportMiddleTube(0);
                break;
            }
            case 45: {
                this.handledPersistable.setSportRightTube(0);
                break;
            }
            case 46: {
                this.handledPersistable.setOffroadLeftTube(2);
                break;
            }
            case 47: {
                this.handledPersistable.setOffroadMiddleTube(0);
                break;
            }
            case 48: {
                this.handledPersistable.setOffroadRightTube(1);
                break;
            }
            case 50: {
                this.handledPersistable.setTrailerModeRouteCalculation(true);
                break;
            }
            case 51: {
                this.handledPersistable.setButtonStartStopNoticeHighlighted(false);
                break;
            }
            case 60: {
                CarOffroad carOffroad = null;
                try {
                    carOffroad = (CarOffroad)this.module.getPersistableFactory().createPersistableWithDefaults(2);
                }
                catch (PersistenceException persistenceException) {
                    this.getLogger().error(32).append("Could not create default value for field carOffroad").attachThrowable(persistenceException).log();
                }
                this.handledPersistable.setCarOffroad(carOffroad);
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
        $assertionsDisabled = !(class$de$vw$mib$asl$car$persistence$CarHandler == null ? (class$de$vw$mib$asl$car$persistence$CarHandler = CarHandler.class$("de.vw.mib.asl.car.persistence.CarHandler")) : class$de$vw$mib$asl$car$persistence$CarHandler).desiredAssertionStatus();
    }
}

