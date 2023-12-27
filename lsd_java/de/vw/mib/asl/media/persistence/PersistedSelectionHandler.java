/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.media.persistence;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistenceModule;
import de.vw.mib.asl.media.persistence.PersistedSelection;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

class PersistedSelectionHandler
extends AbstractPersistenceDataHandler {
    private final PersistedSelection handledPersistable;
    private final PersistenceModule module;
    static final /* synthetic */ boolean $assertionsDisabled;
    static /* synthetic */ Class class$de$vw$mib$asl$media$persistence$PersistedSelectionHandler;

    PersistedSelectionHandler(PersistedSelection persistedSelection, Logger logger, PersistenceModule persistenceModule) {
        super(logger);
        if (!$assertionsDisabled && persistedSelection == null) {
            throw new AssertionError();
        }
        this.handledPersistable = persistedSelection;
        this.module = persistenceModule;
    }

    @Override
    public void handle(int n, boolean bl) {
        switch (n) {
            case 3: {
                this.handledPersistable.setCompositeSelection(bl);
                this.markAsProcessed(n);
                break;
            }
            case 6: {
                this.handledPersistable.setRecursive(bl);
                this.markAsProcessed(n);
                break;
            }
            case 7: {
                this.handledPersistable.setSelected(bl);
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
            case 14: {
                this.handledPersistable.setPlaymode(n2);
                this.markAsProcessed(n);
                break;
            }
            case 2: {
                this.handledPersistable.setInstanceId(n2);
                this.markAsProcessed(n);
                break;
            }
            case 4: {
                this.handledPersistable.setSelectionScope(n2);
                this.markAsProcessed(n);
                break;
            }
            case 8: {
                this.handledPersistable.setSelectionResult(n2);
                this.markAsProcessed(n);
                break;
            }
            case 9: {
                this.handledPersistable.setSelectionState(n2);
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
            case 10: {
                this.handledPersistable.setSizeAvailable(l);
                this.markAsProcessed(n);
                break;
            }
            case 11: {
                this.handledPersistable.setSizeSelected(l);
                this.markAsProcessed(n);
                break;
            }
            case 12: {
                this.handledPersistable.setEntriesAvailable(l);
                this.markAsProcessed(n);
                break;
            }
            case 13: {
                this.handledPersistable.setEntriesSelected(l);
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
                this.handledPersistable.setUniqeMediaId(string);
                this.markAsProcessed(n);
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
            case 5: {
                this.handledPersistable.getSelectionPath().add(persistable);
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
            case 5: {
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
        return new int[]{14, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    }

    @Override
    protected void installDefaultValue(int n) {
        switch (n) {
            case 14: {
                break;
            }
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
        $assertionsDisabled = !(class$de$vw$mib$asl$media$persistence$PersistedSelectionHandler == null ? (class$de$vw$mib$asl$media$persistence$PersistedSelectionHandler = PersistedSelectionHandler.class$("de.vw.mib.asl.media.persistence.PersistedSelectionHandler")) : class$de$vw$mib$asl$media$persistence$PersistedSelectionHandler).desiredAssertionStatus();
    }
}

