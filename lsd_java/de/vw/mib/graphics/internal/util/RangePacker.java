/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.graphics.internal.util;

import de.vw.mib.collections.ints.IntObjectMap;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.graphics.internal.util.RangePacker$Chunk;
import de.vw.mib.graphics.internal.util.RangePacker$ChunkPool;
import de.vw.mib.graphics.internal.util.RangePacker$ListEntryPool;
import de.vw.mib.graphics.internal.util.RangePacker$RangePackerList;
import de.vw.mib.graphics.internal.util.RangePacker$RangePackerListEntry;
import de.vw.mib.graphics.math.Util;
import de.vw.mib.pool.ObjectPool;

public final class RangePacker {
    private static final int CHUNK_POOL_MAX_CAPACITY;
    private static final RangePacker$ChunkPool CHUNK_POOL;
    private static final int LIST_ENTRY_POOL_MAXIMUM_CAPACITY;
    private static final ObjectPool LIST_ENTRY_POOL;
    private static final int CHUNK_MAP_INITIAL_SIZE;
    private static final int LOG2_MINIMUM_BIN_SIZE;
    private final int size;
    private final int log2MaxBinSize;
    private int binCount;
    private final RangePacker$RangePackerList[] bins;
    private final RangePacker$RangePackerList chunks;
    private final IntObjectMap chunkMap;

    public RangePacker(int n) {
        RangePacker$RangePackerListEntry rangePacker$RangePackerListEntry;
        this.size = n;
        this.binCount = -129;
        this.log2MaxBinSize = this.findNewEmptyChunkBin(n);
        this.binCount = this.log2MaxBinSize + 1;
        this.bins = new RangePacker$RangePackerList[this.binCount];
        for (int i2 = 0; i2 < this.binCount; ++i2) {
            this.bins[i2] = new RangePacker$RangePackerList();
        }
        this.chunks = new RangePacker$RangePackerList();
        RangePacker$Chunk rangePacker$Chunk = new RangePacker$Chunk();
        rangePacker$Chunk.position = 0;
        rangePacker$Chunk.range = n;
        RangePacker$RangePackerListEntry rangePacker$RangePackerListEntry2 = new RangePacker$RangePackerListEntry();
        rangePacker$RangePackerListEntry2.chunk = rangePacker$Chunk;
        rangePacker$Chunk.chunkEntry = rangePacker$RangePackerListEntry2;
        this.chunks.add(rangePacker$RangePackerListEntry2);
        rangePacker$Chunk.binEntry = rangePacker$RangePackerListEntry = new RangePacker$RangePackerListEntry();
        rangePacker$RangePackerListEntry.chunk = rangePacker$Chunk;
        this.bins[this.log2MaxBinSize].add(rangePacker$RangePackerListEntry);
        this.chunkMap = new IntObjectOptHashMap(100);
    }

    public void reset() {
        while (this.chunks.size() != 0) {
            RangePacker$RangePackerListEntry rangePacker$RangePackerListEntry = (RangePacker$RangePackerListEntry)this.chunks.getFirst();
            RangePacker$Chunk rangePacker$Chunk = rangePacker$RangePackerListEntry.chunk;
            if (rangePacker$Chunk.binEntry != null) {
                this.removeFromBinList(rangePacker$RangePackerListEntry.chunk);
            }
            this.removeFromChunkList(rangePacker$RangePackerListEntry.chunk);
            CHUNK_POOL.releaseObject(rangePacker$Chunk);
        }
        this.chunkMap.clear();
    }

    private int findNewEmptyChunkBin(int n) {
        return Util.clamp(RangePacker.nextIntLB(n) - 4, 0, this.binCount - 1);
    }

    private int findChunkBin(int n) {
        return Util.clamp(RangePacker.nextIntLB(n - 1) - 4 + 1, 0, this.binCount - 1);
    }

    public int insert(int n) {
        int n2;
        for (n2 = this.findChunkBin(n); n2 < this.binCount - 1 && this.bins[n2].size() == 0; ++n2) {
        }
        if (this.bins[n2].size() == 0) {
            return -1;
        }
        RangePacker$RangePackerListEntry rangePacker$RangePackerListEntry = (RangePacker$RangePackerListEntry)this.bins[n2].getFirst();
        while (rangePacker$RangePackerListEntry.chunk.range < n && rangePacker$RangePackerListEntry.next != null) {
            rangePacker$RangePackerListEntry = (RangePacker$RangePackerListEntry)rangePacker$RangePackerListEntry.next;
        }
        if (rangePacker$RangePackerListEntry.chunk.range < n) {
            return -1;
        }
        RangePacker$Chunk rangePacker$Chunk = rangePacker$RangePackerListEntry.chunk;
        this.bins[n2].remove(rangePacker$RangePackerListEntry);
        LIST_ENTRY_POOL.releaseObject(rangePacker$RangePackerListEntry);
        rangePacker$Chunk.binEntry = null;
        if (rangePacker$Chunk.range != n) {
            RangePacker$Chunk rangePacker$Chunk2 = CHUNK_POOL.borrowChunk(rangePacker$Chunk.position, rangePacker$Chunk.range - n);
            this.insertIntoBinList(rangePacker$Chunk2);
            this.insertIntoChunkList(rangePacker$Chunk2, rangePacker$Chunk.chunkEntry);
            rangePacker$Chunk.position += rangePacker$Chunk2.range;
            rangePacker$Chunk.range = n;
        }
        this.chunkMap.put(rangePacker$Chunk.position, rangePacker$Chunk);
        return rangePacker$Chunk.position;
    }

    public int getSize() {
        return this.size;
    }

    public int getCoverage() {
        return 0;
    }

    public boolean isEmpty() {
        return this.chunks.size() == 1 && ((RangePacker$RangePackerListEntry)this.chunks.getFirst()).chunk.binEntry != null;
    }

    public void remove(int n) {
        RangePacker$Chunk rangePacker$Chunk;
        RangePacker$RangePackerListEntry rangePacker$RangePackerListEntry;
        RangePacker$Chunk rangePacker$Chunk2 = (RangePacker$Chunk)this.chunkMap.remove(n);
        RangePacker$RangePackerListEntry rangePacker$RangePackerListEntry2 = rangePacker$Chunk2.chunkEntry;
        if (rangePacker$RangePackerListEntry2.previous != null) {
            rangePacker$RangePackerListEntry = (RangePacker$RangePackerListEntry)rangePacker$RangePackerListEntry2.previous;
            rangePacker$Chunk = rangePacker$RangePackerListEntry.chunk;
            if (rangePacker$Chunk.binEntry != null) {
                rangePacker$Chunk2.position = rangePacker$Chunk.position;
                rangePacker$Chunk2.range += rangePacker$Chunk.range;
                this.removeFromBinList(rangePacker$Chunk);
                this.removeFromChunkList(rangePacker$Chunk);
                CHUNK_POOL.releaseObject(rangePacker$Chunk);
            }
        }
        if (rangePacker$RangePackerListEntry2.next != null) {
            rangePacker$RangePackerListEntry = (RangePacker$RangePackerListEntry)rangePacker$RangePackerListEntry2.next;
            rangePacker$Chunk = rangePacker$RangePackerListEntry.chunk;
            if (rangePacker$Chunk.binEntry != null) {
                rangePacker$Chunk2.range += rangePacker$Chunk.range;
                this.removeFromBinList(rangePacker$Chunk);
                this.removeFromChunkList(rangePacker$Chunk);
                CHUNK_POOL.releaseObject(rangePacker$Chunk);
            }
        }
        this.insertIntoBinList(rangePacker$Chunk2);
    }

    private void insertIntoChunkList(RangePacker$Chunk rangePacker$Chunk, RangePacker$RangePackerListEntry rangePacker$RangePackerListEntry) {
        RangePacker$RangePackerListEntry rangePacker$RangePackerListEntry2 = (RangePacker$RangePackerListEntry)LIST_ENTRY_POOL.borrowObject();
        rangePacker$RangePackerListEntry2.chunk = rangePacker$Chunk;
        rangePacker$Chunk.chunkEntry = rangePacker$RangePackerListEntry2;
        this.chunks.insert(rangePacker$RangePackerListEntry, rangePacker$RangePackerListEntry2);
    }

    private void insertIntoBinList(RangePacker$Chunk rangePacker$Chunk) {
        RangePacker$RangePackerListEntry rangePacker$RangePackerListEntry = (RangePacker$RangePackerListEntry)LIST_ENTRY_POOL.borrowObject();
        rangePacker$RangePackerListEntry.chunk = rangePacker$Chunk;
        rangePacker$Chunk.binEntry = rangePacker$RangePackerListEntry;
        this.bins[this.findNewEmptyChunkBin(rangePacker$Chunk.range)].addFirst(rangePacker$RangePackerListEntry);
    }

    private void removeFromBinList(RangePacker$Chunk rangePacker$Chunk) {
        this.bins[this.findNewEmptyChunkBin(rangePacker$Chunk.range)].remove(rangePacker$Chunk.binEntry);
        LIST_ENTRY_POOL.releaseObject(rangePacker$Chunk.binEntry);
        rangePacker$Chunk.binEntry = null;
    }

    private void removeFromChunkList(RangePacker$Chunk rangePacker$Chunk) {
        this.chunks.remove(rangePacker$Chunk.chunkEntry);
        LIST_ENTRY_POOL.releaseObject(rangePacker$Chunk.chunkEntry);
        rangePacker$Chunk.chunkEntry = null;
    }

    private static int nextIntLB(int n) {
        int n2 = 1;
        int n3 = 0;
        while (n2 < n) {
            n2 <<= 1;
            ++n3;
        }
        return n3;
    }

    static {
        CHUNK_POOL = new RangePacker$ChunkPool(100);
        LIST_ENTRY_POOL = new RangePacker$ListEntryPool(100);
    }
}

