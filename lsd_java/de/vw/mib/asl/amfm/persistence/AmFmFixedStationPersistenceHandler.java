/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.amfm.persistence;

import de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistence;
import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class AmFmFixedStationPersistenceHandler
extends AbstractPersistenceDataHandler {
    private final AmFmFixedStationPersistence handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$amfm$persistence$AmFmFixedStationPersistenceHandler;

    AmFmFixedStationPersistenceHandler(AmFmFixedStationPersistence amFmFixedStationPersistence, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && amFmFixedStationPersistence == null) {
            throw new AssertionError();
        }
        this.handledPersistable = amFmFixedStationPersistence;
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
            case 6: {
                this.handledPersistable.setRatingCounter(s);
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "short");
            }
        }
    }

    @Override
    public void handle(int n, int n2) {
        switch (n) {
            case 1: {
                this.handledPersistable.setFrequency(n2);
                this.markAsProcessed(n);
                break;
            }
            case 2: {
                this.handledPersistable.setPi(n2);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setSubChannel(n2);
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
            case 3: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setName(string);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value must not be null.").log();
                break;
            }
            case 4: {
                if (!this.performValidation() || string != null) {
                    this.handledPersistable.setShortName(string);
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
        return new int[]{1, 2, 3, 4, 5, 6};
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
                String string = "";
                this.handledPersistable.setName(string);
                break;
            }
            case 4: {
                String string = "";
                this.handledPersistable.setShortName(string);
                break;
            }
            case 5: {
                break;
            }
            case 6: {
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
        return 7;
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
        $assertionsDisabled = !(class$de$vw$mib$asl$amfm$persistence$AmFmFixedStationPersistenceHandler == null ? (class$de$vw$mib$asl$amfm$persistence$AmFmFixedStationPersistenceHandler = AmFmFixedStationPersistenceHandler.class$("de.vw.mib.asl.amfm.persistence.AmFmFixedStationPersistenceHandler")) : class$de$vw$mib$asl$amfm$persistence$AmFmFixedStationPersistenceHandler).desiredAssertionStatus();
    }
}

