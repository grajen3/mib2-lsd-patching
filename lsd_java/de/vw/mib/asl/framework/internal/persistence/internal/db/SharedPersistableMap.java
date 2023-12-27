/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.db;

import de.vw.mib.asl.framework.api.persistence.SharedPersistable;
import de.vw.mib.asl.framework.internal.persistence.internal.db.ApiPersDbImpl;
import de.vw.mib.asl.framework.internal.persistence.internal.db.Compression;
import de.vw.mib.asl.framework.internal.persistence.internal.db.PrivateOutputStream;
import de.vw.mib.asl.framework.internal.persistence.internal.db.RecordByteArray;
import de.vw.mib.asl.framework.internal.persistence.internal.debug.PersDebug;
import de.vw.mib.collections.copyonwrite.CowArray;

final class SharedPersistableMap {
    private final CowArray mPersistables = new CowArray(15);

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void reloadAllSharedPersistables() {
        Object[] objectArray = this.mPersistables.getArray();
        if (objectArray == null) {
            return;
        }
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            SharedPersistable sharedPersistable;
            if (objectArray[i2] == null) continue;
            SharedPersistable sharedPersistable2 = sharedPersistable = (SharedPersistable)objectArray[i2];
            synchronized (sharedPersistable2) {
                ApiPersDbImpl.INSTANCE.loadPersistable(sharedPersistable.getNamespace(), sharedPersistable.getKey(), sharedPersistable);
                continue;
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void serializeRecordsToCache() {
        Object[] objectArray = this.mPersistables.getArray();
        if (objectArray == null) {
            return;
        }
        for (int i2 = 0; i2 < objectArray.length; ++i2) {
            SharedPersistable sharedPersistable;
            if (objectArray[i2] == null) continue;
            SharedPersistable sharedPersistable2 = sharedPersistable = (SharedPersistable)objectArray[i2];
            synchronized (sharedPersistable2) {
                if (sharedPersistable.isDirty()) {
                    int n = sharedPersistable.getNamespace();
                    long l = sharedPersistable.getKey();
                    try {
                        byte[] byArray = this.toByteArray(sharedPersistable, false);
                        RecordByteArray recordByteArray = new RecordByteArray(n, l, byArray, sharedPersistable.isCompressionEnabled());
                        ApiPersDbImpl.INSTANCE.putIntoCache(n, l, recordByteArray, false);
                        sharedPersistable.markDirty(false);
                    }
                    catch (Exception exception) {
                        PersDebug.error(new StringBuffer().append("Error saving a SharedPersistable: ").append(PersDebug.namespaceKeyString(n, l)).toString(), exception);
                    }
                }
                continue;
            }
        }
    }

    public byte[] toByteArray(SharedPersistable sharedPersistable, boolean bl) {
        PrivateOutputStream privateOutputStream = new PrivateOutputStream();
        sharedPersistable.toStream(privateOutputStream);
        byte[] byArray = privateOutputStream.toByteArray();
        if (bl) {
            byArray = Compression.compress(byArray);
        }
        return byArray;
    }

    public void add(SharedPersistable sharedPersistable) {
        this.mPersistables.add(sharedPersistable);
    }

    public Object[] getArray() {
        return this.mPersistables.getArray();
    }
}

