/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmSettingsPersistable;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class SatPersistenceHandler
extends AbstractPersistenceDataHandler {
    private final SatPersistence handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$SatPersistenceHandler;

    SatPersistenceHandler(SatPersistence satPersistence, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && satPersistence == null) {
            throw new AssertionError();
        }
        this.handledPersistable = satPersistence;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 38: {
                this.handledPersistable.setSubscriptionShowPopupSubscriptionChanged(bl);
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
            case 39: {
                this.handledPersistable.setSatNoOfPresets(n2);
                this.markAsProcessed(n);
                break;
            }
            case 30: {
                this.handledPersistable.setSubscriptionDay(n2);
                this.markAsProcessed(n);
                break;
            }
            case 31: {
                this.handledPersistable.setSubscriptionMonth(n2);
                this.markAsProcessed(n);
                break;
            }
            case 32: {
                this.handledPersistable.setSubscriptionYear(n2);
                this.markAsProcessed(n);
                break;
            }
            case 34: {
                this.handledPersistable.setSubscriptionReasonCode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 36: {
                this.handledPersistable.setSubscriptionState(n2);
                this.markAsProcessed(n);
                break;
            }
            case 37: {
                this.handledPersistable.setSubscriptionTrafficState(n2);
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
            case 33: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setSubscriptionPhone(string);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value must not be null.").log();
                break;
            }
            case 35: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setSubscriptionReasonText(string);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value must not be null.").log();
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
            case 27: {
                this.handledPersistable.getSatImages().add(persistable);
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
            case 27: {
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
        return new int[]{39, 30, 31, 32, 33, 34, 35, 36, 37, 38, 27};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 39: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSatNoOfPresets(AmFmSettingsPersistable.getDefaultNoOfPresetsValue());
                break;
            }
            case 30: {
                break;
            }
            case 31: {
                break;
            }
            case 32: {
                break;
            }
            case 33: {
                String string = "";
                this.handledPersistable.setSubscriptionPhone(string);
                break;
            }
            case 34: {
                break;
            }
            case 35: {
                String string = "";
                this.handledPersistable.setSubscriptionReasonText(string);
                break;
            }
            case 36: {
                break;
            }
            case 37: {
                break;
            }
            case 38: {
                break;
            }
            case 27: {
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
        return 14;
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$SatPersistenceHandler == null ? (class$de$vw$mib$asl$amfm$persistence$SatPersistenceHandler = SatPersistenceHandler.class$("de.vw.mib.asl.amfm.persistence.SatPersistenceHandler")) : class$de$vw$mib$asl$amfm$persistence$SatPersistenceHandler).desiredAssertionStatus();
    }
}

