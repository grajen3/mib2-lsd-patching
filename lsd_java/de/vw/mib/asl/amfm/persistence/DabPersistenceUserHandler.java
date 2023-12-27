/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.ComponentPersistence;
import de.vw.mib.asl.amfm.persistence.DabPersistence;
import de.vw.mib.asl.amfm.persistence.EnsemblePersistence;
import de.vw.mib.asl.amfm.persistence.FrequencyPersistence;
import de.vw.mib.asl.amfm.persistence.ServicePersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.radio.amfm.persistence.AmFmSettingsPersistable;
import de.vw.mib.asl.internal.radio.dab.DabPersistable;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class DabPersistenceUserHandler
extends AbstractPersistenceDataHandler {
    private final DabPersistence handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$DabPersistenceUserHandler;

    DabPersistenceUserHandler(DabPersistence dabPersistence, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && dabPersistence == null) {
            throw new AssertionError();
        }
        this.handledPersistable = dabPersistence;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 7: {
                this.handledPersistable.setLBandOptionState(bl);
                this.markAsProcessed(n);
                break;
            }
            case 8: {
                this.handledPersistable.setOtherAnnouncementOption(bl);
                this.markAsProcessed(n);
                break;
            }
            case 9: {
                this.handledPersistable.setTrafficAnnouncementOption(bl);
                this.markAsProcessed(n);
                break;
            }
            case 10: {
                this.handledPersistable.setDabFollowing(bl);
                this.markAsProcessed(n);
                break;
            }
            case 11: {
                this.handledPersistable.setFmLinking(bl);
                this.markAsProcessed(n);
                break;
            }
            case 13: {
                this.handledPersistable.setLsmSupportsSlideshow(bl);
                this.markAsProcessed(n);
                break;
            }
            case 18: {
                this.handledPersistable.setSoftLinkingOption(bl);
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
            case 12: {
                this.handledPersistable.setViewMode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 16: {
                this.handledPersistable.setCurrentPresetIndexSelectedByHmi(n2);
                this.markAsProcessed(n);
                break;
            }
            case 17: {
                this.handledPersistable.setVisibleBankIndex(n2);
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
                this.handledPersistable.setCurrentFrequency((FrequencyPersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 2: {
                this.handledPersistable.setCurrentEnsemble((EnsemblePersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 3: {
                this.handledPersistable.setCurrentService((ServicePersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 4: {
                this.handledPersistable.setCurrentComponent((ComponentPersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setLinkingEnsemble((EnsemblePersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                this.handledPersistable.setLinkingService((ServicePersistence)persistable);
                this.markAsProcessed(n);
                break;
            }
            case 19: {
                this.handledPersistable.getDabPresets().add(persistable);
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
            case 19: {
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
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 16, 17, 18, 19};
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
            case 5: {
                break;
            }
            case 6: {
                break;
            }
            case 7: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setLBandOptionState(DabPersistable.getDefaultLBandOptionStateValue());
                break;
            }
            case 8: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setOtherAnnouncementOption(DabPersistable.getDefaultOtherAnnouncementOptionValue());
                break;
            }
            case 9: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setTrafficAnnouncementOption(DabPersistable.getDefaultTrafficAnnouncementOptionValue());
                break;
            }
            case 10: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setDabFollowing(DabPersistable.getDefaultDabFollowingValue());
                break;
            }
            case 11: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setFmLinking(DabPersistable.getDefaultFmLinkingValue());
                break;
            }
            case 12: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setViewMode(DabPersistable.getDefaultDabViewModeValue());
                break;
            }
            case 13: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setLsmSupportsSlideshow(DabPersistable.getDefaultLsmSupportsSlideshowValue());
                break;
            }
            case 16: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setCurrentPresetIndexSelectedByHmi(AmFmSettingsPersistable.getDefaultPresetIndexValue());
                break;
            }
            case 17: {
                this.handledPersistable.setVisibleBankIndex(0);
                break;
            }
            case 18: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setSoftLinkingOption(DabPersistable.getDefaultSoftLinkingOptionValue());
                break;
            }
            case 19: {
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
        return 8;
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$DabPersistenceUserHandler == null ? (class$de$vw$mib$asl$amfm$persistence$DabPersistenceUserHandler = DabPersistenceUserHandler.class$("de.vw.mib.asl.amfm.persistence.DabPersistenceUserHandler")) : class$de$vw$mib$asl$amfm$persistence$DabPersistenceUserHandler).desiredAssertionStatus();
    }
}

