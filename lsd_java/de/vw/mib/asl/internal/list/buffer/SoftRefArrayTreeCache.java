/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.list.buffer;

import de.vw.mib.asl.internal.list.IndexIterator;
import de.vw.mib.asl.internal.list.buffer.ASLListCache;
import de.vw.mib.asl.internal.list.buffer.ASLListCacheIterator;
import de.vw.mib.asl.internal.list.buffer.SoftRefArrayTreeCache$1;
import de.vw.mib.asl.internal.list.buffer.SoftRefArrayTreeCache$ItemArray;
import de.vw.mib.asl.internal.list.buffer.SoftRefArrayTreeCache$Key;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;

public class SoftRefArrayTreeCache
implements ASLListCache {
    private static final int ITEM_ARRAY_SIZE_LOG2;
    private static final int ITEM_ARRAY_SIZE;
    private static final int ITEM_ARRAY_INDEX_MASK;
    private static final Comparator ITEM_ARRAY_COMPARATOR;
    private final TreeMap arrayMap = new TreeMap(ITEM_ARRAY_COMPARATOR);
    private final SoftRefArrayTreeCache$Key indexKey = new SoftRefArrayTreeCache$Key();

    private static int indexToArrayStart(int n) {
        return n & 0xFFFFFFE0;
    }

    private static int arrayStartToIndex(int n) {
        return n;
    }

    private static int indexToArrayOffset(int n) {
        return n & 0x1F;
    }

    @Override
    public synchronized void clear() {
        Iterator iterator = this.arrayMap.keySet().iterator();
        while (iterator.hasNext()) {
            SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = (SoftRefArrayTreeCache$ItemArray)iterator.next();
            softRefArrayTreeCache$ItemArray.release();
        }
        this.arrayMap.clear();
    }

    @Override
    public synchronized void cutToSize(int n) {
        if (this.getMinIndex() >= n) {
            this.clear();
        } else {
            Object object;
            this.indexKey.startIndex = SoftRefArrayTreeCache.indexToArrayStart(n);
            int n2 = SoftRefArrayTreeCache.indexToArrayOffset(n);
            if (0 != n2) {
                object = (SoftRefArrayTreeCache$ItemArray)this.arrayMap.get(this.indexKey);
                if (null != object && ((SoftRefArrayTreeCache$ItemArray)object).cutToSize(n2)) {
                    this.remove((SoftRefArrayTreeCache$ItemArray)object);
                }
                this.indexKey.startIndex = SoftRefArrayTreeCache.indexToArrayStart(n + 32);
            }
            object = this.arrayMap.tailMap(this.indexKey).keySet().iterator();
            while (object.hasNext()) {
                SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = (SoftRefArrayTreeCache$ItemArray)object.next();
                object.remove();
                softRefArrayTreeCache$ItemArray.release();
            }
        }
    }

    private SoftRefArrayTreeCache$ItemArray getArray(int n) {
        this.indexKey.startIndex = SoftRefArrayTreeCache.indexToArrayStart(n);
        return (SoftRefArrayTreeCache$ItemArray)this.arrayMap.get(this.indexKey);
    }

    private SoftRefArrayTreeCache$ItemArray getOrCreateArray(int n, boolean bl) {
        this.indexKey.startIndex = SoftRefArrayTreeCache.indexToArrayStart(n);
        SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = (SoftRefArrayTreeCache$ItemArray)this.arrayMap.get(this.indexKey);
        if (null == softRefArrayTreeCache$ItemArray && bl) {
            softRefArrayTreeCache$ItemArray = SoftRefArrayTreeCache$ItemArray.borrow().setData(this.indexKey.startIndex, 0);
            this.arrayMap.put(softRefArrayTreeCache$ItemArray, softRefArrayTreeCache$ItemArray);
        }
        return softRefArrayTreeCache$ItemArray;
    }

    @Override
    public synchronized Object getItem(int n) {
        SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = this.getArray(n);
        return softRefArrayTreeCache$ItemArray != null ? softRefArrayTreeCache$ItemArray.get(SoftRefArrayTreeCache.indexToArrayOffset(n)) : null;
    }

    @Override
    public synchronized int getItemCount() {
        int n = this.getMaxIndex();
        int n2 = this.getMinIndex();
        return n2 <= n ? n - n2 + 1 : 0;
    }

    @Override
    public synchronized boolean getItems(int n, Object[] objectArray, int n2) {
        boolean bl = true;
        if (objectArray.length < n2) {
            n2 = objectArray.length;
        }
        int n3 = 0;
        while (0 < n2) {
            SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = this.getArray(n);
            int n4 = SoftRefArrayTreeCache.indexToArrayOffset(n);
            int n5 = Math.min(n2, 32 - n4);
            if (null == softRefArrayTreeCache$ItemArray) {
                bl = false;
                Arrays.fill(objectArray, n3, n3 + n5, null);
            } else {
                bl = softRefArrayTreeCache$ItemArray.getItems(n4, objectArray, n3, n5) && bl;
            }
            n3 += n5;
            n += n5;
            n2 -= n5;
        }
        return bl;
    }

    int getMaxIndex() {
        int n = -1;
        SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = null;
        while (null == softRefArrayTreeCache$ItemArray && !this.arrayMap.isEmpty()) {
            softRefArrayTreeCache$ItemArray = (SoftRefArrayTreeCache$ItemArray)this.arrayMap.lastKey();
            n = softRefArrayTreeCache$ItemArray.getMaxOffset();
            if (0 <= n) continue;
            this.remove(softRefArrayTreeCache$ItemArray);
            softRefArrayTreeCache$ItemArray = null;
        }
        return null != softRefArrayTreeCache$ItemArray ? SoftRefArrayTreeCache.arrayStartToIndex(softRefArrayTreeCache$ItemArray.startIndex) + n : 128;
    }

    int getMinIndex() {
        int n = -1;
        SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = null;
        while (null == softRefArrayTreeCache$ItemArray && !this.arrayMap.isEmpty()) {
            softRefArrayTreeCache$ItemArray = (SoftRefArrayTreeCache$ItemArray)this.arrayMap.firstKey();
            n = softRefArrayTreeCache$ItemArray.getMinOffset();
            if (0 <= n) continue;
            this.remove(softRefArrayTreeCache$ItemArray);
            softRefArrayTreeCache$ItemArray = null;
        }
        return null != softRefArrayTreeCache$ItemArray ? SoftRefArrayTreeCache.arrayStartToIndex(softRefArrayTreeCache$ItemArray.startIndex) + n : -129;
    }

    @Override
    public synchronized void insertItems(int n, Object[] objectArray) {
        if (this.getMaxIndex() >= n) {
            int n2;
            int n3;
            int n4 = objectArray.length;
            int n5 = SoftRefArrayTreeCache.indexToArrayOffset(n4);
            SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = (SoftRefArrayTreeCache$ItemArray)this.arrayMap.lastKey();
            int n6 = SoftRefArrayTreeCache.arrayStartToIndex(softRefArrayTreeCache$ItemArray.startIndex);
            if (0 == n5) {
                while (null != softRefArrayTreeCache$ItemArray && n <= n6) {
                    this.arrayMap.remove(softRefArrayTreeCache$ItemArray);
                    softRefArrayTreeCache$ItemArray.startIndex = SoftRefArrayTreeCache.indexToArrayStart(n6 + n4);
                    this.arrayMap.put(softRefArrayTreeCache$ItemArray, softRefArrayTreeCache$ItemArray);
                    while (null == (softRefArrayTreeCache$ItemArray = this.getArray(n6 -= 32)) && n <= n6) {
                    }
                }
                n5 = 32;
            } else {
                n3 = 32 - n5;
                while (null != softRefArrayTreeCache$ItemArray && n <= n6) {
                    n2 = n6 + n4;
                    SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray2 = this.getOrCreateArray(n2 + n3, true);
                    SoftRefArrayTreeCache$ItemArray.move(softRefArrayTreeCache$ItemArray, n3, softRefArrayTreeCache$ItemArray2, 0, n5);
                    softRefArrayTreeCache$ItemArray2 = this.getOrCreateArray(n2, true);
                    SoftRefArrayTreeCache$ItemArray.move(softRefArrayTreeCache$ItemArray, 0, softRefArrayTreeCache$ItemArray2, n5, n3);
                    while (null == (softRefArrayTreeCache$ItemArray = this.getArray(n6 -= 32)) && n <= n6) {
                    }
                }
            }
            if (null != softRefArrayTreeCache$ItemArray && n6 + 32 > n) {
                n3 = SoftRefArrayTreeCache.indexToArrayOffset(n);
                n2 = Math.min(n5, 32 - n3);
                int n7 = 32 - n2;
                int n8 = n6 + n4;
                SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray3 = this.getOrCreateArray(n8 + n7, true);
                SoftRefArrayTreeCache$ItemArray.move(softRefArrayTreeCache$ItemArray, n7, softRefArrayTreeCache$ItemArray3, n5 - n2, n2);
                if (n3 < n7) {
                    n2 = n7 - n3;
                    softRefArrayTreeCache$ItemArray3 = this.getOrCreateArray(n8 + n3, true);
                    SoftRefArrayTreeCache$ItemArray.move(softRefArrayTreeCache$ItemArray, n3, softRefArrayTreeCache$ItemArray3, 32 - n2, n2);
                }
            }
        }
        this.setItems(n, objectArray, objectArray.length);
    }

    @Override
    public synchronized void removeItems(int n, int n2) {
        int n3 = this.getMaxIndex();
        if (n3 >= n && 0 < n2) {
            int n4 = this.getMinIndex();
            if (n4 >= n && n3 - n < n2) {
                this.clear();
            } else {
                int n5;
                int n6;
                SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray;
                SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray2;
                int n7;
                int n8 = n;
                int n9 = SoftRefArrayTreeCache.indexToArrayOffset(n8);
                if (0 < n9) {
                    n7 = n + n2;
                    softRefArrayTreeCache$ItemArray2 = this.getArray(n7);
                    softRefArrayTreeCache$ItemArray = this.getOrCreateArray(n8, null != softRefArrayTreeCache$ItemArray2);
                    n6 = SoftRefArrayTreeCache.indexToArrayOffset(n7);
                    n5 = 32 - Math.max(n6, n9);
                    if (null != softRefArrayTreeCache$ItemArray) {
                        SoftRefArrayTreeCache$ItemArray.move(softRefArrayTreeCache$ItemArray2, n6, softRefArrayTreeCache$ItemArray, n9, n5);
                    }
                    n8 += n5;
                    if ((n9 += n5) < 32) {
                        softRefArrayTreeCache$ItemArray2 = this.getArray(n7 += n5);
                        softRefArrayTreeCache$ItemArray = null != softRefArrayTreeCache$ItemArray ? softRefArrayTreeCache$ItemArray : this.getOrCreateArray(n8, null != softRefArrayTreeCache$ItemArray2);
                        n5 = 32 - n9;
                        if (null != softRefArrayTreeCache$ItemArray) {
                            SoftRefArrayTreeCache$ItemArray.move(softRefArrayTreeCache$ItemArray2, 0, softRefArrayTreeCache$ItemArray, n9, n5);
                        }
                        n8 += n5;
                    }
                }
                if (0 == (n6 = SoftRefArrayTreeCache.indexToArrayOffset(n2))) {
                    while (n8 <= n3) {
                        softRefArrayTreeCache$ItemArray = this.getArray(n8);
                        if (null != softRefArrayTreeCache$ItemArray) {
                            this.remove(softRefArrayTreeCache$ItemArray);
                        }
                        if (null != (softRefArrayTreeCache$ItemArray = this.getArray(n8 + n2))) {
                            this.arrayMap.remove(softRefArrayTreeCache$ItemArray);
                            softRefArrayTreeCache$ItemArray.startIndex -= n2;
                            this.arrayMap.put(softRefArrayTreeCache$ItemArray, softRefArrayTreeCache$ItemArray);
                        }
                        n8 += 32;
                    }
                } else {
                    n5 = 32 - n6;
                    for (n7 = n8 + n2; n7 <= n3; n7 += 32) {
                        softRefArrayTreeCache$ItemArray2 = this.getArray(n7);
                        softRefArrayTreeCache$ItemArray = this.getOrCreateArray(n8, null != softRefArrayTreeCache$ItemArray2);
                        if (null != softRefArrayTreeCache$ItemArray) {
                            SoftRefArrayTreeCache$ItemArray.move(softRefArrayTreeCache$ItemArray2, n6, softRefArrayTreeCache$ItemArray, 0, n5);
                        }
                        softRefArrayTreeCache$ItemArray2 = this.getArray(n7 + n5);
                        SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray3 = null != softRefArrayTreeCache$ItemArray ? softRefArrayTreeCache$ItemArray : (softRefArrayTreeCache$ItemArray = this.getOrCreateArray(n8, null != softRefArrayTreeCache$ItemArray2));
                        if (null != softRefArrayTreeCache$ItemArray) {
                            SoftRefArrayTreeCache$ItemArray.move(softRefArrayTreeCache$ItemArray2, 0, softRefArrayTreeCache$ItemArray, n5, n6);
                        }
                        n8 += 32;
                    }
                    while (n8 <= n3) {
                        softRefArrayTreeCache$ItemArray = this.getArray(n8);
                        if (null != softRefArrayTreeCache$ItemArray) {
                            this.remove(softRefArrayTreeCache$ItemArray);
                        }
                        n8 += 32;
                    }
                    this.purge();
                }
            }
        }
    }

    @Override
    public synchronized void clearItems(int n, int n2) {
        boolean bl;
        int n3;
        int n4 = n + n2;
        SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = this.getArray(n);
        if (null != softRefArrayTreeCache$ItemArray) {
            int n5 = SoftRefArrayTreeCache.indexToArrayOffset(n);
            bl = softRefArrayTreeCache$ItemArray.store(n5, null, 0, n3 = Math.min(n2, 32 - n5));
            if (bl) {
                this.remove(softRefArrayTreeCache$ItemArray);
            }
            n += n3;
            n2 -= n3;
        }
        if (n < n4) {
            this.indexKey.startIndex = SoftRefArrayTreeCache.indexToArrayStart(n);
            Iterator iterator = this.arrayMap.tailMap(this.indexKey).keySet().iterator();
            while (n < n4 && iterator.hasNext()) {
                softRefArrayTreeCache$ItemArray = (SoftRefArrayTreeCache$ItemArray)iterator.next();
                n = SoftRefArrayTreeCache.arrayStartToIndex(softRefArrayTreeCache$ItemArray.startIndex);
                n3 = Math.min(n4 - n, 32);
                if (0 >= n3) continue;
                bl = 32 == n3 ? true : softRefArrayTreeCache$ItemArray.store(0, null, 0, n3);
                if (bl) {
                    iterator.remove();
                    softRefArrayTreeCache$ItemArray.release();
                }
                n += n3;
            }
        }
    }

    private void purge() {
        Iterator iterator = this.arrayMap.keySet().iterator();
        while (iterator.hasNext()) {
            SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = (SoftRefArrayTreeCache$ItemArray)iterator.next();
            if (!softRefArrayTreeCache$ItemArray.purge()) continue;
            iterator.remove();
            softRefArrayTreeCache$ItemArray.release();
        }
    }

    private void remove(SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray) {
        this.arrayMap.remove(softRefArrayTreeCache$ItemArray);
        softRefArrayTreeCache$ItemArray.release();
    }

    @Override
    public synchronized void setItems(int n, Object[] objectArray, int n2) {
        if (objectArray.length < n2) {
            n2 = objectArray.length;
        }
        int n3 = 0;
        while (0 < n2) {
            int n4;
            int n5;
            SoftRefArrayTreeCache$ItemArray softRefArrayTreeCache$ItemArray = this.getOrCreateArray(n, true);
            if (softRefArrayTreeCache$ItemArray.store(n5 = SoftRefArrayTreeCache.indexToArrayOffset(n), objectArray, n3, n4 = Math.min(n2, 32 - n5))) {
                this.remove(softRefArrayTreeCache$ItemArray);
            }
            n += n4;
            n3 += n4;
            n2 -= n4;
        }
    }

    @Override
    public synchronized IndexIterator indexIterator(int n, int n2) {
        int n3 = this.getMinIndex();
        int n4 = this.getMaxIndex() + 1;
        n = -1 == n ? n3 : Math.max(n, n3);
        n2 = -1 == n2 ? n4 : Math.min(n2, n4);
        return n2 <= n ? ASLListCacheIterator.EMPTY_LIST_ITERATOR : new ASLListCacheIterator(this, n, n2);
    }

    @Override
    public IndexIterator indexIterator() {
        return this.indexIterator(-1, -1);
    }

    static {
        ITEM_ARRAY_COMPARATOR = new SoftRefArrayTreeCache$1();
    }
}

