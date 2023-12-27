/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.RadioAmFmSettings;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmSettingsPersistable;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class RadioAmFmSettingsHandler
extends AbstractPersistenceDataHandler {
    private final RadioAmFmSettings handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsHandler;

    RadioAmFmSettingsHandler(RadioAmFmSettings radioAmFmSettings, Logger logger, PersistenceModule persistenceModule) {
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
            case 43: {
                this.handledPersistable.setRdsValueInCoding(bl);
                this.markAsProcessed(n);
                break;
            }
            case 44: {
                this.handledPersistable.setAfValueInCoding(bl);
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
                this.handledPersistable.setAmRangeOption(n2);
                this.markAsProcessed(n);
                break;
            }
            case 2: {
                this.handledPersistable.setFmRange(n2);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                this.handledPersistable.setAmFmNoOfPresets(n2);
                this.markAsProcessed(n);
                break;
            }
            case 7: {
                this.handledPersistable.setDabNoOfPresets(n2);
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
        return new int[]{43, 44, 1, 2, 6, 7};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 43: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setRdsValueInCoding(AmFmSettingsPersistable.getDefaultRdsOptionValue());
                break;
            }
            case 44: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAfValueInCoding(AmFmSettingsPersistable.getDefaultAfOptionValue());
                break;
            }
            case 1: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAmRangeOption(AmFmSettingsPersistable.getDefaultAmTunerBandSettings());
                break;
            }
            case 2: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setFmRange(AmFmSettingsPersistable.getDefaultFmTunerBandSettings());
                break;
            }
            case 6: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAmFmNoOfPresets(AmFmSettingsPersistable.getDefaultNoOfPresetsValue());
                break;
            }
            case 7: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDabNoOfPresets(AmFmSettingsPersistable.getDefaultNoOfPresetsValue());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsHandler == null ? (class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsHandler = RadioAmFmSettingsHandler.class$("de.vw.mib.asl.amfm.persistence.RadioAmFmSettingsHandler")) : class$de$vw$mib$asl$amfm$persistence$RadioAmFmSettingsHandler).desiredAssertionStatus();
    }
}

