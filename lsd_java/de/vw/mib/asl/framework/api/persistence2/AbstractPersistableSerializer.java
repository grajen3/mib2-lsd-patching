/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2;

import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.PersistableSerializer;
import de.vw.mib.asl.framework.api.persistence2.PersistenceException;

public abstract class AbstractPersistableSerializer
implements PersistableSerializer {
    public abstract int getPersistableId() {
    }

    protected void checkPersistable(Persistable persistable) {
        if (persistable == null) {
            throw new PersistenceException("The given persistable is null and thus cannot be serialized.");
        }
        if (persistable.getId() != this.getPersistableId()) {
            throw new PersistenceException(new StringBuffer().append("This serializer supports the persistable '").append(this.getPersistableId()).append("', but the given persistable has the id '").append(persistable.getId()).append("'.").toString());
        }
    }
}

