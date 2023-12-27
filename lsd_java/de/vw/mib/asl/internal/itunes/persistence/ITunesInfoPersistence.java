/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.persistence;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;

public class ITunesInfoPersistence
extends AbstractSharedPersistable {
    private static final short VERSION;
    private IntObjectOptHashMap instanceContextMap = new IntObjectOptHashMap();

    public ITunesInfoPersistence() {
        super(5019, 0);
        this.clear();
    }

    @Override
    public void clear() {
        this.instanceContextMap.clear();
    }

    public IntObjectOptHashMap getInstanceContextMap() {
        return this.instanceContextMap;
    }

    public void addInstance(int n, String string) {
        this.instanceContextMap.put(n, string);
        this.markDirty(true);
    }

    public void removeInstance(int n) {
        this.instanceContextMap.remove(n);
        this.markDirty(true);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        int n = persistenceInputStream.readByte();
        for (int i2 = 0; i2 < n; ++i2) {
            this.instanceContextMap.put(persistenceInputStream.readInt(), persistenceInputStream.readString());
        }
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        int n = this.instanceContextMap.size();
        persistenceOutputStream.writeByte(n);
        IntIterator intIterator = this.instanceContextMap.keySet().iterator();
        while (intIterator.hasNext()) {
            int n2 = intIterator.next();
            persistenceOutputStream.writeInt(n2);
            persistenceOutputStream.writeString((String)this.instanceContextMap.get(n2));
        }
    }

    @Override
    public void clearUnknownValues(short s) {
    }

    @Override
    public short[] getSupportedVersions() {
        return NO_SUPPORTED_VERSION;
    }

    @Override
    public short getVersion() {
        return 1;
    }
}

