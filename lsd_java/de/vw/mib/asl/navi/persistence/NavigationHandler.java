/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.navi.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.navigation.util.PersistenceDefaults;
import de.vw.mib.asl.navi.persistence.Navigation;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class NavigationHandler
extends AbstractPersistenceDataHandler {
    private final Navigation handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$navi$persistence$NavigationHandler;

    NavigationHandler(Navigation navigation, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && navigation == null) {
            throw new AssertionError();
        }
        this.handledPersistable = navigation;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 46: {
                this.handledPersistable.setSeasonalRestrictions(bl);
                this.markAsProcessed(n);
                break;
            }
            case 47: {
                this.handledPersistable.setStatisticalData(bl);
                this.markAsProcessed(n);
                break;
            }
            case 50: {
                this.handledPersistable.setMergingTraffic(bl);
                this.markAsProcessed(n);
                break;
            }
            case 51: {
                this.handledPersistable.setReduceLane(bl);
                this.markAsProcessed(n);
                break;
            }
            case 52: {
                this.handledPersistable.setRailwayCrossing(bl);
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
            case 1: {
                this.handledPersistable.getRouteOptionsVignetteAvailableCountryIds().add(n2);
                this.markAsProcessed(n);
                break;
            }
            case 45: {
                this.handledPersistable.setOnlineToursAvailable(n2);
                this.markAsProcessed(n);
                break;
            }
            case 53: {
                this.handledPersistable.setSpeedCameraWarningType(n2);
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
            case 1: {
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "Container");
            }
        }
    }

    @Override
    protected int[] getFieldIds() {
        return new int[]{1, 45, 46, 47, 50, 51, 52, 53};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 1: {
                break;
            }
            case 45: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setOnlineToursAvailable(PersistenceDefaults.getOnlineToursAvailableDefault());
                break;
            }
            case 46: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSeasonalRestrictions(PersistenceDefaults.getSeasonalRestrictionsDefault());
                break;
            }
            case 47: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setStatisticalData(PersistenceDefaults.getStatisticalDataDefault());
                break;
            }
            case 50: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setMergingTraffic(PersistenceDefaults.getMergingTrafficDefault());
                break;
            }
            case 51: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setReduceLane(PersistenceDefaults.getReduceLaneDefault());
                break;
            }
            case 52: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRailwayCrossing(PersistenceDefaults.getRailwayCrossingDefault());
                break;
            }
            case 53: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSpeedCameraWarningType(PersistenceDefaults.getSpeedCameraWarningTypeDefault());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$navi$persistence$NavigationHandler == null ? (class$de$vw$mib$asl$navi$persistence$NavigationHandler = NavigationHandler.class$("de.vw.mib.asl.navi.persistence.NavigationHandler")) : class$de$vw$mib$asl$navi$persistence$NavigationHandler).desiredAssertionStatus();
    }
}

