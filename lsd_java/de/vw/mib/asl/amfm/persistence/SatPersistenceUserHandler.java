/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.SatPersistence;
import de.vw.mib.asl.amfm.persistence.StationInfoPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmSettingsPersistable;
import de.vw.mib.asl.internal.radio.sdars.helper.SatPersistable;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class SatPersistenceUserHandler
extends AbstractPersistenceDataHandler {
    private final SatPersistence handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$SatPersistenceUserHandler;

    SatPersistenceUserHandler(SatPersistence satPersistence, Logger logger, PersistenceModule persistenceModule) {
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
            case 4: {
                this.handledPersistable.setSeekEnabled(bl);
                this.markAsProcessed(n);
                break;
            }
            case 9: {
                this.handledPersistable.setUseChannelFilter(bl);
                this.markAsProcessed(n);
                break;
            }
            case 23: {
                this.handledPersistable.setIsNoneFilterSelected(bl);
                this.markAsProcessed(n);
                break;
            }
            case 24: {
                this.handledPersistable.setAllChannelsFilteredOut(bl);
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
            case 8: {
                this.handledPersistable.setCurrentPresetsBankIndex(by);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "byte");
            }
        }
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
            case 3: {
                this.handledPersistable.setSorting(n2);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setViewMode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 28: {
                this.handledPersistable.setCurrentPresetIndex(n2);
                this.markAsProcessed(n);
                break;
            }
            case 10: {
                this.handledPersistable.getSkippedChannels().add(n2);
                this.markAsProcessed(n);
                break;
            }
            case 29: {
                this.handledPersistable.getNonSkippedChannels().add(n2);
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
            case 1: {
                this.handledPersistable.setUserChannel((StationInfoPersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 2: {
                this.handledPersistable.setPlayingChannel((StationInfoPersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                this.handledPersistable.getSatPresets().add(persistable);
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
            case 6: {
                this.markAsProcessed(n);
                break;
            }
            case 10: {
                this.markAsProcessed(n);
                break;
            }
            case 29: {
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
        return new int[]{1, 2, 3, 4, 5, 6, 28, 8, 9, 10, 29, 23, 24};
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
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSorting(SatPersistable.getDefaultSortOrder());
                break;
            }
            case 4: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSeekEnabled(SatPersistable.getDefaultSeekEnableStatus());
                break;
            }
            case 5: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setViewMode(SatPersistable.getDefaultViewMode());
                break;
            }
            case 6: {
                break;
            }
            case 28: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setCurrentPresetIndex(AmFmSettingsPersistable.getDefaultPresetIndexValue());
                break;
            }
            case 8: {
                this.handledPersistable.setCurrentPresetsBankIndex((byte)0);
                break;
            }
            case 9: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setUseChannelFilter(SatPersistable.getDefaultchannelFilterUsage());
                break;
            }
            case 10: {
                break;
            }
            case 29: {
                break;
            }
            case 23: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setIsNoneFilterSelected(SatPersistable.getDefaultNoneFilterSelected());
                break;
            }
            case 24: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setAllChannelsFilteredOut(SatPersistable.getDefaultallChannelsFilteredOut());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$SatPersistenceUserHandler == null ? (class$de$vw$mib$asl$amfm$persistence$SatPersistenceUserHandler = SatPersistenceUserHandler.class$("de.vw.mib.asl.amfm.persistence.SatPersistenceUserHandler")) : class$de$vw$mib$asl$amfm$persistence$SatPersistenceUserHandler).desiredAssertionStatus();
    }
}

