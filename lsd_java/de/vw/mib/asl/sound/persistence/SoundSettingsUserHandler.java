/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.sound.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.sound.SoundPersistence;
import de.vw.mib.asl.sound.persistence.SoundSettings;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class SoundSettingsUserHandler
extends AbstractPersistenceDataHandler {
    private final SoundSettings handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$sound$persistence$SoundSettingsUserHandler;

    SoundSettingsUserHandler(SoundSettings soundSettings, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && soundSettings == null) {
            throw new AssertionError();
        }
        this.handledPersistable = soundSettings;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 6: {
                this.handledPersistable.setUserMuteActive(bl);
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
            case 2: {
                this.handledPersistable.setEqUserTreble(s);
                this.markAsProcessed(n);
                break;
            }
            case 3: {
                this.handledPersistable.setEqUserMiddle(s);
                this.markAsProcessed(n);
                break;
            }
            case 4: {
                this.handledPersistable.setEqUserBass(s);
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
                this.handledPersistable.setEqMode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 5: {
                this.handledPersistable.setEqPresetCanton(n2);
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
        return new int[]{1, 2, 3, 4, 5, 6};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 1: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setEqMode(SoundPersistence.getEqModeDefault());
                break;
            }
            case 2: {
                this.handledPersistable.setEqUserTreble((short)0);
                break;
            }
            case 3: {
                this.handledPersistable.setEqUserMiddle((short)0);
                break;
            }
            case 4: {
                this.handledPersistable.setEqUserBass((short)0);
                break;
            }
            case 5: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setEqPresetCanton(SoundPersistence.getEqPresetCantonDefault());
                break;
            }
            case 6: {
                this.handledPersistable.setUserMuteActive(false);
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
        $assertionsDisabled = !(class$de$vw$mib$asl$sound$persistence$SoundSettingsUserHandler == null ? (class$de$vw$mib$asl$sound$persistence$SoundSettingsUserHandler = SoundSettingsUserHandler.class$("de.vw.mib.asl.sound.persistence.SoundSettingsUserHandler")) : class$de$vw$mib$asl$sound$persistence$SoundSettingsUserHandler).desiredAssertionStatus();
    }
}

