/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence.ASLPersistenceAPI;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.log4mib.Logger;

public abstract class AbstractPersistable
implements Persistable {
    private final Logger logger;
    private final ASLPersistenceAPI aslPersistenceAPI;
    private AbstractPersistable rootPersistable;
    private boolean isDirty;
    private boolean isLocked;

    protected AbstractPersistable(Logger logger, ASLPersistenceAPI aSLPersistenceAPI) {
        this.logger = logger;
        this.aslPersistenceAPI = aSLPersistenceAPI;
    }

    public void clearDirty() {
        this.isDirty = false;
    }

    public boolean isDirty() {
        return this.isDirty;
    }

    public void markDirty() {
        if (!this.isLocked) {
            this.isDirty = true;
            if (this.rootPersistable != null && this.rootPersistable != this) {
                this.rootPersistable.markDirty();
            }
            if (this.aslPersistenceAPI != null) {
                this.aslPersistenceAPI.writeViaDsi();
            }
        } else {
            this.logger.error(32, new StringBuffer().append("Persitable '").append(super.getClass().getName()).append("' was accessed after it was locked. Changes will be discarded!").toString());
        }
    }

    protected void setRootPersistable(Persistable persistable) {
        this.rootPersistable = (AbstractPersistable)persistable;
    }

    public void lock() {
        this.isLocked = true;
        if (this.logger.isTraceEnabled(32)) {
            this.logger.trace(32, new StringBuffer().append("Persitable '").append(super.getClass().getName()).append("' was locked.").toString());
        }
    }

    @Override
    public void resetToDefaults() {
    }
}

