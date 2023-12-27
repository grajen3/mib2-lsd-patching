/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.persistence2.collections.maps;

import de.vw.mib.asl.framework.api.persistence2.AbstractPersistable;
import de.vw.mib.asl.framework.api.persistence2.Persistable;
import de.vw.mib.asl.framework.api.persistence2.collections.PersistenceCollection;
import java.util.HashMap;
import java.util.Map;

public class PersistenceHashMap
extends HashMap
implements PersistenceCollection {
    private AbstractPersistable rootPersistable;

    @Override
    public void clear() {
        super.clear();
        this.onCollectionChanged();
    }

    @Override
    public Object put(Object object, Object object2) {
        Object object3 = super.put(object, object2);
        this.onCollectionChanged();
        return object3;
    }

    @Override
    public void putAll(Map map) {
        super.putAll(map);
        this.onCollectionChanged();
    }

    @Override
    public Object remove(Object object) {
        Object object2 = super.remove(object);
        this.onCollectionChanged();
        return object2;
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

