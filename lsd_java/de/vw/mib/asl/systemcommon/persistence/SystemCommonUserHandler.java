/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.system.persistence.PersistenceDefaults;
import de.vw.mib.asl.internal.system.persistence.PersistenceValidator;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class SystemCommonUserHandler
extends AbstractPersistenceDataHandler {
    private final SystemCommon handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$systemcommon$persistence$SystemCommonUserHandler;

    SystemCommonUserHandler(SystemCommon systemCommon, Logger logger, PersistenceModule persistenceModule) {
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
            case 2: {
                this.handledPersistable.setShowClock(bl);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setAcousticTouchscreenFeedback(bl);
                this.markAsProcessed(n);
                break;
            }
            case 13: {
                this.handledPersistable.setProximityEnabled(bl);
                this.markAsProcessed(n);
                break;
            }
            case 14: {
                this.handledPersistable.setAcousticSensorButtonFeedback(bl);
                this.markAsProcessed(n);
                break;
            }
            case 16: {
                this.handledPersistable.setGestureActive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 17: {
                this.handledPersistable.setGestureInformationActive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 18: {
                this.handledPersistable.setGestureSoundeffectActive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 22: {
                this.handledPersistable.setDisplayOffClock(bl);
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
                if (!this.performValidation() || (long)n2 >= 0L && (long)n2 <= 0) {
                    this.handledPersistable.setDisplayBrightness(n2);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is not within the valid range.").log();
                break;
            }
            case 11: {
                this.handledPersistable.setOffclockLayout(n2);
                this.markAsProcessed(n);
                break;
            }
            case 3: {
                if (!this.performValidation() || (long)n2 >= 0L && (long)n2 <= 1L) {
                    this.handledPersistable.setSpellerLayout(n2);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is not within the valid range.").log();
                break;
            }
            case 12: {
                this.handledPersistable.setMenuMode(n2);
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
            case 4: {
                this.handledPersistable.setBitfieldLanguagesThatWereSetBefore(l);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "long");
            }
        }
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
            case 20: {
                if (!this.performValidation() || PersistenceValidator.validateLastContentId(string)) {
                    this.handledPersistable.setLastContentId(string);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is invalid.").log();
                break;
            }
            default: {
                this.logUnknownField(n, "String");
            }
        }
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
        return new int[]{1, 2, 11, 3, 4, 5, 13, 12, 14, 16, 17, 18, 20, 22};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 1: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDisplayBrightness(PersistenceDefaults.getDefaultBrightness());
                break;
            }
            case 2: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setShowClock(PersistenceDefaults.getDefaultShowClock());
                break;
            }
            case 11: {
                this.handledPersistable.setOffclockLayout(0);
                break;
            }
            case 3: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSpellerLayout(PersistenceDefaults.getDefaultSpellerLayout());
                break;
            }
            case 4: {
                break;
            }
            case 5: {
                break;
            }
            case 13: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setProximityEnabled(PersistenceDefaults.getDefaultProximityEnablement());
                break;
            }
            case 12: {
                break;
            }
            case 14: {
                break;
            }
            case 16: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setGestureActive(PersistenceDefaults.getDefaultGestureActive());
                break;
            }
            case 17: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setGestureInformationActive(PersistenceDefaults.getDefaultGestureInformationActive());
                break;
            }
            case 18: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setGestureSoundeffectActive(PersistenceDefaults.getDefaultGestureSoundEffectActive());
                break;
            }
            case 20: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setLastContentId(PersistenceDefaults.getDefaultLastContentId());
                break;
            }
            case 22: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDisplayOffClock(PersistenceDefaults.getDefaultDisplayOffClock());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$systemcommon$persistence$SystemCommonUserHandler == null ? (class$de$vw$mib$asl$systemcommon$persistence$SystemCommonUserHandler = SystemCommonUserHandler.class$("de.vw.mib.asl.systemcommon.persistence.SystemCommonUserHandler")) : class$de$vw$mib$asl$systemcommon$persistence$SystemCommonUserHandler).desiredAssertionStatus();
    }
}

