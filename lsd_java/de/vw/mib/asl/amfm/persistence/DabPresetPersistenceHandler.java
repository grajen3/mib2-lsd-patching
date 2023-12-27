/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.DabPresetPersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmSettingsPersistable;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class DabPresetPersistenceHandler
extends AbstractPersistenceDataHandler {
    private final DabPresetPersistence handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$DabPresetPersistenceHandler;

    DabPresetPersistenceHandler(DabPresetPersistence dabPresetPersistence, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && dabPresetPersistence == null) {
            throw new AssertionError();
        }
        this.handledPersistable = dabPresetPersistence;
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
            default: 
        }
        this.logUnknownField(n, "int");
    }

    @Override
    public void handle(int n, long l) {
        switch (n) {
            case 6: {
                this.handledPersistable.setDatabaseStationId(l);
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
            default: 
        }
        this.logUnknownField(n, "String");
    }

    @Override
    public void handle(int n, Persistable persistable) {
        switch (n) {
            case 1: {
                this.handledPersistable.setService((ServicePersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 2: {
                this.handledPersistable.setEnsemble((EnsemblePersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 3: {
                this.handledPersistable.setFrequency((FrequencyPersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 4: {
                this.handledPersistable.setStationImage((ResourceLocatorPersistence)persistable);
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
        return new int[]{1, 2, 3, 4, 6};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 1: {
                break;
            }
            case 2: {
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                break;
            }
            case 6: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDatabaseStationId(AmFmSettingsPersistable.getDefaultDatabaseStationIdValue());
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
        return 13;
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$DabPresetPersistenceHandler == null ? (class$de$vw$mib$asl$amfm$persistence$DabPresetPersistenceHandler = DabPresetPersistenceHandler.class$("de.vw.mib.asl.amfm.persistence.DabPresetPersistenceHandler")) : class$de$vw$mib$asl$amfm$persistence$DabPresetPersistenceHandler).desiredAssertionStatus();
    }
}

