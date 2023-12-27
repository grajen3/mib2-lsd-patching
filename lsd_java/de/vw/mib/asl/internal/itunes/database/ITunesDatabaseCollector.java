/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.itunes.database;

import de.vw.mib.asl.framework.api.persistence.AbstractSharedPersistable;
import de.vw.mib.asl.framework.api.persistence.PersistenceInputStream;
import de.vw.mib.asl.framework.api.persistence.PersistenceOutputStream;
import de.vw.mib.asl.framework.internal.framework.ServiceManager;
import de.vw.mib.asl.internal.itunes.database.ITunesDatabase;
import de.vw.mib.collections.ints.IntIterator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import java.util.Iterator;

public class ITunesDatabaseCollector
extends AbstractSharedPersistable {
    private static final short VERSION;
    private final IntObjectOptHashMap mContexts = new IntObjectOptHashMap();

    public ITunesDatabaseCollector() {
        super(5019, 0);
    }

    public boolean contains(int n) {
        return this.mContexts.containsKey(n);
    }

    public int add(int n, ITunesDatabase iTunesDatabase) {
        int n2 = 13;
        if (!this.contains(n)) {
            this.mContexts.put(n, iTunesDatabase);
            n2 = 0;
            this.markDirty(true);
        }
        return n2;
    }

    public ITunesDatabase get(int n) {
        return (ITunesDatabase)this.mContexts.get(n);
    }

    public int size() {
        return this.mContexts.size();
    }

    public Iterator iterator() {
        return this.mContexts.values().iterator();
    }

    public IntIterator keyIterator() {
        return this.mContexts.keySet().iterator();
    }

    public void remove(int n) {
        this.mContexts.remove(n);
        this.markDirty(true);
    }

    public void removeAll() {
        this.clear();
    }

    @Override
    public void clear() {
        this.mContexts.clear();
        this.markDirty(true);
    }

    @Override
    public void fromStreamInternal(PersistenceInputStream persistenceInputStream, short s) {
        this.clear();
        int n = persistenceInputStream.readByte();
        for (int i2 = 0; i2 < n; ++i2) {
            int n2 = persistenceInputStream.readInt();
            ITunesDatabase iTunesDatabase = new ITunesDatabase(persistenceInputStream);
            this.add(n2, iTunesDatabase);
        }
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" ITunes database instances read from persistence : ").append(n).log();
        }
    }

    @Override
    public void toStreamInternal(PersistenceOutputStream persistenceOutputStream) {
        int n = this.size();
        persistenceOutputStream.writeByte(n);
        IntIterator intIterator = this.keyIterator();
        while (intIterator.hasNext()) {
            int n2 = intIterator.next();
            persistenceOutputStream.writeInt(n2);
            ITunesDatabase iTunesDatabase = this.get(n2);
            iTunesDatabase.toStream(persistenceOutputStream);
        }
        if (ServiceManager.logger2.isTraceEnabled(8192)) {
            ServiceManager.logger2.trace(8192).append("ITUNES : ").append(" ITunes database instances written to persistence : ").append(n).log();
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
        return 2;
    }
}

