/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmStationPersistence;
import de.vw.mib.asl.amfm.persistence.ResourceLocatorPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class AmFmStationPersistenceHandler
extends AbstractPersistenceDataHandler {
    private final AmFmStationPersistence handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$AmFmStationPersistenceHandler;

    AmFmStationPersistenceHandler(AmFmStationPersistence amFmStationPersistence, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && amFmStationPersistence == null) {
            throw new AssertionError();
        }
        this.handledPersistable = amFmStationPersistence;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 7: {
                this.handledPersistable.setStationRds(bl);
                this.markAsProcessed(n);
                break;
            }
            case 8: {
                this.handledPersistable.setStationTp(bl);
                this.markAsProcessed(n);
                break;
            }
            case 9: {
                this.handledPersistable.setStationTa(bl);
                this.markAsProcessed(n);
                break;
            }
            case 10: {
                this.handledPersistable.setStationTmc(bl);
                this.markAsProcessed(n);
                break;
            }
            case 11: {
                this.handledPersistable.setStationScrollingPs(bl);
                this.markAsProcessed(n);
                break;
            }
            case 12: {
                this.handledPersistable.setStationRadioText(bl);
                this.markAsProcessed(n);
                break;
            }
            case 14: {
                this.handledPersistable.setStationHd(bl);
                this.markAsProcessed(n);
                break;
            }
            case 17: {
                this.handledPersistable.setStationFullDigital(bl);
                this.markAsProcessed(n);
                break;
            }
            case 20: {
                this.handledPersistable.setStationEon(bl);
                this.markAsProcessed(n);
                break;
            }
            case 21: {
                this.handledPersistable.setStationCoChannel(bl);
                this.markAsProcessed(n);
                break;
            }
            case 28: {
                this.handledPersistable.setMpsWithSPSAlreadyStored(bl);
                this.markAsProcessed(n);
                break;
            }
            case 29: {
                this.handledPersistable.setMpsWithoutSPSAlreadyStored(bl);
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
            case 3: {
                this.handledPersistable.setStationPi(n2);
                this.markAsProcessed(n);
                break;
            }
            case 4: {
                this.handledPersistable.setStationReceptionQuality(n2);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setStationPtyCode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                this.handledPersistable.setStationWaveband(n2);
                this.markAsProcessed(n);
                break;
            }
            case 18: {
                this.handledPersistable.setStationServiceId(n2);
                this.markAsProcessed(n);
                break;
            }
            case 19: {
                this.handledPersistable.setStationSubscription(n2);
                this.markAsProcessed(n);
                break;
            }
            case 24: {
                this.handledPersistable.setHdStatus(n2);
                this.markAsProcessed(n);
                break;
            }
            case 25: {
                this.handledPersistable.setSubChannelCount(n2);
                this.markAsProcessed(n);
                break;
            }
            case 26: {
                this.handledPersistable.setChannelMask(n2);
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
            case 2: {
                this.handledPersistable.setStationFrequency(l);
                this.markAsProcessed(n);
                break;
            }
            case 27: {
                this.handledPersistable.setUniqueId(l);
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
            case 1: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setStationName(string);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value must not be null.").log();
                break;
            }
            case 13: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setStationRealPs(string);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value must not be null.").log();
                break;
            }
            case 15: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setStationShortNameHd(string);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value must not be null.").log();
                break;
            }
            case 16: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setStationLongNameHd(string);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value must not be null.").log();
                break;
            }
            case 22: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setRealName(string);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value must not be null.").log();
                break;
            }
            case 23: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setRegString(string);
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
            case 30: {
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
        return new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 1: {
                String string = "";
                this.handledPersistable.setStationName(string);
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
                break;
            }
            case 8: {
                break;
            }
            case 9: {
                break;
            }
            case 10: {
                break;
            }
            case 11: {
                break;
            }
            case 12: {
                break;
            }
            case 13: {
                String string = "";
                this.handledPersistable.setStationRealPs(string);
                break;
            }
            case 14: {
                break;
            }
            case 15: {
                String string = "";
                this.handledPersistable.setStationShortNameHd(string);
                break;
            }
            case 16: {
                String string = "";
                this.handledPersistable.setStationLongNameHd(string);
                break;
            }
            case 17: {
                break;
            }
            case 18: {
                break;
            }
            case 19: {
                break;
            }
            case 20: {
                break;
            }
            case 21: {
                break;
            }
            case 22: {
                String string = "";
                this.handledPersistable.setRealName(string);
                break;
            }
            case 23: {
                String string = "";
                this.handledPersistable.setRegString(string);
                break;
            }
            case 24: {
                break;
            }
            case 25: {
                break;
            }
            case 26: {
                break;
            }
            case 27: {
                break;
            }
            case 28: {
                break;
            }
            case 29: {
                break;
            }
            case 30: {
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$AmFmStationPersistenceHandler == null ? (class$de$vw$mib$asl$amfm$persistence$AmFmStationPersistenceHandler = AmFmStationPersistenceHandler.class$("de.vw.mib.asl.amfm.persistence.AmFmStationPersistenceHandler")) : class$de$vw$mib$asl$amfm$persistence$AmFmStationPersistenceHandler).desiredAssertionStatus();
    }
}

