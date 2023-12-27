/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2.collections.lists;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.collections.PersistenceCollection;
import java.util.ArrayList;
import java.util.Collection;

public class PersistenceArrayList
extends ArrayList
implements PersistenceCollection {
    private AbstractPersistable rootPersistable;

    @Override
    public void add(int n, Object object) {
        super.add(n, object);
        this.onCollectionChanged();
    }

    @Override
    public boolean add(Object object) {
        boolean bl = super.add(object);
        this.onCollectionChanged();
        return bl;
    }

    @Override
    public boolean addAll(int n, Collection collection) {
        boolean bl = super.addAll(n, collection);
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
    public void clear() {
        super.clear();
        this.onCollectionChanged();
    }

    @Override
    public Object remove(int n) {
        Object object = super.remove(n);
        this.onCollectionChanged();
        return object;
    }

    @Override
    public Object set(int n, Object object) {
        Object object2 = super.set(n, object);
        this.onCollectionChanged();
        return object2;
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
    public void setRootPersistable(Persistable persistable) {
        this.rootPersistable = (AbstractPersistable)persistable;
    }

    private void onCollectionChanged() {
        if (this.rootPersistable != null) {
            this.rootPersistable.markDirty();
        }
    }
}

