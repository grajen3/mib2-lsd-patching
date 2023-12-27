/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.system.persistence.PersistenceDefaults;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class SystemCommonHandler
extends AbstractPersistenceDataHandler {
    private final SystemCommon handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$systemcommon$persistence$SystemCommonHandler;

    SystemCommonHandler(SystemCommon systemCommon, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && systemCommon == null) {
            throw new AssertionError();
        }
        this.handledPersistable = systemCommon;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 6: {
                this.handledPersistable.setValetParkingActive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 19: {
                this.handledPersistable.setRearSeatControlLocked(bl);
                this.markAsProcessed(n);
                break;
            }
            case 15: {
                this.handledPersistable.setOnlineAvailable(bl);
                this.markAsProcessed(n);
                break;
            }
            case 21: {
                this.handledPersistable.setClimateECUhasMenuHK(bl);
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
            default: 
        }
        this.logUnknownField(n, "int");
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
        return new int[]{6, 19, 15, 21};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 6: {
                this.handledPersistable.setValetParkingActive(false);
                break;
            }
            case 19: {
                this.handledPersistable.setRearSeatControlLocked(false);
                break;
            }
            case 15: {
                break;
            }
            case 21: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setClimateECUhasMenuHK(PersistenceDefaults.getIsSystemClimateMenuIconVisible());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$systemcommon$persistence$SystemCommonHandler == null ? (class$de$vw$mib$asl$systemcommon$persistence$SystemCommonHandler = SystemCommonHandler.class$("de.vw.mib.asl.systemcommon.persistence.SystemCommonHandler")) : class$de$vw$mib$asl$systemcommon$persistence$SystemCommonHandler).desiredAssertionStatus();
    }
}

