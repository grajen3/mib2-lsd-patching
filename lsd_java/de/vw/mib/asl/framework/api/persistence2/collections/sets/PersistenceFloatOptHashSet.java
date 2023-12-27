/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2.collections.sets;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.collections.PersistenceCollection;
import de.vw.mib.collections.floats.FloatOptHashSet;

public class PersistenceFloatOptHashSet
extends FloatOptHashSet
implements PersistenceCollection {
    private AbstractPersistable rootPersistable;

    @Override
    public void onCollectionChanged() {
        super.onCollectionChanged();
        if (this.rootPersistable != null) {
            this.rootPersistable.markDirty();
        }
    }

    @Override
    public void setRootPersistable(Persistable persistable) {
        this.rootPersistable = (AbstractPersistable)persistable;
    }
}

