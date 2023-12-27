/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.systemcommon.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.system.persistence.PersistenceDefaults;
import de.vw.mib.asl.systemcommon.persistence.AbtFeatures;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class AbtFeaturesHandler
extends AbstractPersistenceDataHandler {
    private final AbtFeatures handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$systemcommon$persistence$AbtFeaturesHandler;

    AbtFeaturesHandler(AbtFeatures abtFeatures, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && abtFeatures == null) {
            throw new AssertionError();
        }
        this.handledPersistable = abtFeatures;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 2: {
                this.handledPersistable.setHandWritingRecognition(bl);
                this.markAsProcessed(n);
                break;
            }
            case 3: {
                this.handledPersistable.setHapticFeedback(bl);
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
                    this.handledPersistable.setProximitySensor(n2);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is not within the valid range.").log();
                break;
            }
            case 4: {
                this.handledPersistable.setDisplayResolutionX(n2);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setDisplayResolutionY(n2);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                if (!this.performValidation() || (long)n2 >= 0L && (long)n2 <= 0) {
                    this.handledPersistable.setAbtType(n2);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is not within the valid range.").log();
                break;
            }
            case 7: {
                if (!this.performValidation() || (long)n2 >= 0L && (long)n2 <= 0) {
                    this.handledPersistable.setDisplayShape(n2);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is not within the valid range.").log();
                break;
            }
            case 8: {
                this.handledPersistable.setNubmerOfHardKeys(n2);
                this.markAsProcessed(n);
                break;
            }
            case 9: {
                if (!this.performValidation() || (long)n2 >= 0L && (long)n2 <= 0) {
                    this.handledPersistable.setButtonTechnology(n2);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is not within the valid range.").log();
                break;
            }
            case 10: {
                if (!this.performValidation() || (long)n2 >= 0L && (long)n2 <= 0) {
                    this.handledPersistable.setRotaryEncoderType(n2);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is not within the valid range.").log();
                break;
            }
            case 11: {
                if (!this.performValidation() || (long)n2 >= 0L && (long)n2 <= 0) {
                    this.handledPersistable.setTouchController(n2);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is not within the valid range.").log();
                break;
            }
            case 12: {
                this.handledPersistable.setTouchMultiplicatorX(n2);
                this.markAsProcessed(n);
                break;
            }
            case 13: {
                this.handledPersistable.setTouchMultiplicatorY(n2);
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
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 1: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setProximitySensor(PersistenceDefaults.getDefaultProximitySensor());
                break;
            }
            case 2: {
                this.handledPersistable.setHandWritingRecognition(false);
                break;
            }
            case 3: {
                this.handledPersistable.setHapticFeedback(false);
                break;
            }
            case 4: {
                this.handledPersistable.setDisplayResolutionX(800);
                break;
            }
            case 5: {
                this.handledPersistable.setDisplayResolutionY(480);
                break;
            }
            case 6: {
                this.handledPersistable.setAbtType(0);
                break;
            }
            case 7: {
                this.handledPersistable.setDisplayShape(0);
                break;
            }
            case 8: {
                this.handledPersistable.setNubmerOfHardKeys(8);
                break;
            }
            case 9: {
                this.handledPersistable.setButtonTechnology(1);
                break;
            }
            case 10: {
                this.handledPersistable.setRotaryEncoderType(2);
                break;
            }
            case 11: {
                this.handledPersistable.setTouchController(1);
                break;
            }
            case 12: {
                this.handledPersistable.setTouchMultiplicatorX(1);
                break;
            }
            case 13: {
                this.handledPersistable.setTouchMultiplicatorY(1);
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
        return 2;
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
        $assertionsDisabled = !(class$de$vw$mib$asl$systemcommon$persistence$AbtFeaturesHandler == null ? (class$de$vw$mib$asl$systemcommon$persistence$AbtFeaturesHandler = AbtFeaturesHandler.class$("de.vw.mib.asl.systemcommon.persistence.AbtFeaturesHandler")) : class$de$vw$mib$asl$systemcommon$persistence$AbtFeaturesHandler).desiredAssertionStatus();
    }
}

