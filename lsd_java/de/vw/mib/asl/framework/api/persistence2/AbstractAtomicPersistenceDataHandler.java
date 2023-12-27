/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistenceDataHandler;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.log4mib.Logger;
import java.util.Map$Entry;

public abstract class AbstractAtomicPersistenceDataHandler
extends AbstractPersistenceDataHandler {
    protected AbstractAtomicPersistenceDataHandler(Logger logger) {
        super(logger);
    }

    @Override
    public void finish() {
        if (this.hasUnprocessedFields()) {
            this.getLogger().warn(32).append("Not all values have been set for the atomic persistable ").append(this.getPersistableId()).append("failed. Falling back to default values.").log();
            this.installDefaultValues();
        } else {
            this.applyValues();
            if (!this.validate()) {
                this.getLogger().warn(32).append("Validation for persistable ").append(this.getPersistableId()).append("failed. Falling back to default values.").log();
                this.installDefaultValues();
            }
        }
    }

    @Override
    public void handle(int n, Persistable persistable) {
        this.logUnknownField(n, "Persistable");
    }

    @Override
    public void handle(int n, Map$Entry map$Entry) {
        this.logUnknownField(n, "Map");
    }

    @Override
    public void handleEmptyCollection(int n) {
        this.logUnknownField(n, "Collection");
    }

    protected abstract void applyValues() {
    }

    protected abstract void installDefaultValues() {
    }

    @Override
    protected void installDefaultValue(int n) {
    }
}

