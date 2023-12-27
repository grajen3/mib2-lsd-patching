/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.internal.media.persistence.MediaPersistence;
import de.vw.mib.asl.media.persistence.PlayerPersistence;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class PlayerPersistenceUserHandler
extends AbstractPersistenceDataHandler {
    private final PlayerPersistence handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$media$persistence$PlayerPersistenceUserHandler;

    PlayerPersistenceUserHandler(PlayerPersistence playerPersistence, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && playerPersistence == null) {
            throw new AssertionError();
        }
        this.handledPersistable = playerPersistence;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 3: {
                this.handledPersistable.setIncludeSubfolder(bl);
                this.markAsProcessed(n);
                break;
            }
            case 7: {
                this.handledPersistable.setVideoMaximized(bl);
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
            case 4: {
                if (!this.performValidation() || (long)n2 >= 0L && (long)n2 <= 0) {
                    this.handledPersistable.setVideoFormat(n2);
                    this.markAsProcessed(n);
                    break;
                }
                this.getLogger().warn(32).append("Cannot set value for field ID (").append(n).append("): The value is not within the valid range.").log();
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
            case 8: {
                this.handledPersistable.getSelections().put((Integer)map$Entry.getKey(), map$Entry.getValue());
                this.markAsProcessed(n);
                break;
            }
            default: {
                this.logUnknownField(n, "Map");
            }
        }
    }

    @Override
    public void handleEmptyCollection(int n) {
        switch (n) {
            case 8: {
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
        return new int[]{3, 4, 8, 7};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 3: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setIncludeSubfolder(MediaPersistence.getIncludeSubfoldersDefault());
                break;
            }
            case 4: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setVideoFormat(MediaPersistence.getVideoFormatDefault());
                break;
            }
            case 8: {
                break;
            }
            case 7: {
                if (!this.invokeExternalMethods()) break;
                this.handledPersistable.setVideoMaximized(MediaPersistence.isVideoMaximizedDefault());
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
        $assertionsDisabled = !(class$de$vw$mib$asl$media$persistence$PlayerPersistenceUserHandler == null ? (class$de$vw$mib$asl$media$persistence$PlayerPersistenceUserHandler = PlayerPersistenceUserHandler.class$("de.vw.mib.asl.media.persistence.PlayerPersistenceUserHandler")) : class$de$vw$mib$asl$media$persistence$PlayerPersistenceUserHandler).desiredAssertionStatus();
    }
}

