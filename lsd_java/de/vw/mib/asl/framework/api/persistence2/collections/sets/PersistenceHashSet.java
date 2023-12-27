/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2.collections.sets;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.collections.PersistenceCollection;
import java.util.Collection;
import java.util.HashSet;

public class PersistenceHashSet
extends HashSet
implements PersistenceCollection {
    private AbstractPersistable rootPersistable;

    @Override
    public boolean add(Object object) {
        boolean bl = super.add(object);
        this.onCollectionChanged();
        return bl;
    }

    @Override
    public void clear() {
        super.clear();
        this.onCollectionChanged();
    }

    @Override
    public boolean remove(Object object) {
        boolean bl = super.remove(object);
        this.onCollectionChanged();
        return bl;
    }

    @Override
    public boolean removeAll(Collection collection) {
        boolean bl = super.removeAll(collection);
        this.onCollectionChanged();
        return bl;
    }

    @Override
    public boolean addAll(Collection collection) {
        boolean bl = super.addAll(collection);
        this.onCollectionChanged();
        return bl;
    }

    @Override
    public boolean retainAll(Collection collection) {
        boolean bl = super.retainAll(collection);
        this.onCollectionChanged();
        return bl;
    }

    @Override
    public void setRootPersistable(Persistable persistable) {
        this.rootPersistable = (AbstractPersistable)persistable;
    }

    private void onCollectionChanged() {
        if (this.rootPersistable != null) {
            this.rootPersistable.markDirty();
        }
    }
}

