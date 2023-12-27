/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayElementComparator;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayListElement;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayListIterator;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$DeltaContext;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayListIDGenerator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.longs.LongIntOptHashMap;

public final class BAPArrayList {
    public static final int INVALID_BAP_POS_ID;
    public static final int INVALID_BAP_ABS_POS;
    public static final int INVALID_ELEMENT_ANCHOR_ID;
    private static final int INVALID_INDEX;
    private static final int NOT_IN_HASH_MAP;
    private BAPArrayListIDGenerator idGenerator;
    private IntObjectOptHashMap bapPosIDhashMap;
    private LongIntOptHashMap entryIDHashMap;
    private BAPArrayList$BAPArrayListElement lastElement;
    private BAPArrayList$BAPArrayListElement firstElement;

    public BAPArrayList(BAPArrayListIDGenerator bAPArrayListIDGenerator) {
        this.idGenerator = bAPArrayListIDGenerator;
        this.bapPosIDhashMap = new IntObjectOptHashMap();
        this.entryIDHashMap = new LongIntOptHashMap();
        this.lastElement = null;
        this.firstElement = null;
    }

    private BAPArrayList(BAPArrayListIDGenerator bAPArrayListIDGenerator, IntObjectOptHashMap intObjectOptHashMap, LongIntOptHashMap longIntOptHashMap) {
        this.idGenerator = bAPArrayListIDGenerator;
        this.bapPosIDhashMap = intObjectOptHashMap;
        this.entryIDHashMap = longIntOptHashMap;
        this.lastElement = null;
        this.firstElement = null;
    }

    public BAPArrayList copy() {
        return new BAPArrayList(this.idGenerator, new IntObjectOptHashMap(this.bapPosIDhashMap.size()), this.entryIDHashMap);
    }

    private int _putElement(long l, int n, BAPArrayElement bAPArrayElement, long l2) {
        int n2 = n;
        if (n2 != 0 && this.idGenerator.isBAPPosIDValid(n2, l)) {
            if (this.bapPosIDhashMap.containsKey(n2)) {
                return 0;
            }
        } else {
            n2 = this.idGenerator.createBAPPosID(bAPArrayElement, l);
            this.entryIDHashMap.put(l, n2);
        }
        bAPArrayElement.setPos(n2);
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = new BAPArrayList$BAPArrayListElement();
        if (this.lastElement == null) {
            bAPArrayList$BAPArrayListElement.takeParams(0, 0, n2, 0, l2, bAPArrayElement);
            this.firstElement = bAPArrayList$BAPArrayListElement;
        } else {
            bAPArrayList$BAPArrayListElement.takeParams(this.lastElement.bapPosID, 0, n2, this.bapPosIDhashMap.size(), l2, bAPArrayElement);
            this.lastElement.nextBapPosID = n2;
        }
        this.bapPosIDhashMap.put(n2, bAPArrayList$BAPArrayListElement);
        this.lastElement = bAPArrayList$BAPArrayListElement;
        return n2;
    }

    public int putElement(long l, BAPArrayElement bAPArrayElement, long l2) {
        int n = this.entryIDHashMap.get(l);
        return this._putElement(l, n, bAPArrayElement, l2);
    }

    public int putElement(long l, long l2, BAPArrayElement bAPArrayElement, long l3) {
        boolean bl = false;
        int n = this.entryIDHashMap.get(l);
        if (n == 0 && l != l2) {
            n = this.entryIDHashMap.get(l2);
            boolean bl2 = bl = n != 0;
        }
        if ((n = this._putElement(l, n, bAPArrayElement, l3)) != 0) {
            if (l != l2) {
                this.entryIDHashMap.put(l2, n);
            }
            if (bl) {
                this.entryIDHashMap.put(l, n);
            }
        }
        return n;
    }

    public BAPArrayElement getElement(int n) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        BAPArrayElement bAPArrayElement = bAPArrayList$BAPArrayListElement != null ? bAPArrayList$BAPArrayListElement.listElement : null;
        return bAPArrayElement;
    }

    public long getElementAnchorID(int n) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        long l = bAPArrayList$BAPArrayListElement != null ? bAPArrayList$BAPArrayListElement.elementAnchorID : -1L;
        return l;
    }

    public int getBapPosID(long l) {
        int n = this.entryIDHashMap.containsKey(l) ? this.entryIDHashMap.get(l) : 0;
        return n;
    }

    public int getAbsPosition(int n) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        int n2 = bAPArrayList$BAPArrayListElement != null ? bAPArrayList$BAPArrayListElement.absPosition : -1;
        return n2;
    }

    private void removeElement(BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement) {
        if (bAPArrayList$BAPArrayListElement.nextBapPosID != 0) {
            BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement2 = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(bAPArrayList$BAPArrayListElement.nextBapPosID);
            bAPArrayList$BAPArrayListElement2.prevBapPosID = bAPArrayList$BAPArrayListElement.prevBapPosID;
            if (bAPArrayList$BAPArrayListElement.prevBapPosID != 0) {
                BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement3 = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(bAPArrayList$BAPArrayListElement.prevBapPosID);
                bAPArrayList$BAPArrayListElement3.nextBapPosID = bAPArrayList$BAPArrayListElement2.bapPosID;
            }
        } else if (bAPArrayList$BAPArrayListElement.prevBapPosID != 0) {
            BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement4 = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(bAPArrayList$BAPArrayListElement.prevBapPosID);
            bAPArrayList$BAPArrayListElement4.nextBapPosID = 0;
            this.lastElement = bAPArrayList$BAPArrayListElement4;
        }
        this.bapPosIDhashMap.remove(bAPArrayList$BAPArrayListElement.bapPosID);
    }

    public void removeElement(int n) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        this.removeElement(bAPArrayList$BAPArrayListElement);
    }

    public int numberOfMappedIDValues() {
        return this.entryIDHashMap.size();
    }

    public void clear() {
        this.bapPosIDhashMap.clear();
        this.entryIDHashMap.clear();
        this.firstElement = null;
        this.lastElement = null;
    }

    public void clearContent() {
        this.firstElement = null;
        this.lastElement = null;
        this.bapPosIDhashMap.clear();
    }

    public int size() {
        return this.bapPosIDhashMap.size();
    }

    public int lastBAPPosID() {
        if (this.lastElement != null) {
            return this.lastElement.bapPosID;
        }
        return 0;
    }

    public int firstBAPPosID() {
        if (this.firstElement != null) {
            return this.firstElement.bapPosID;
        }
        return 0;
    }

    public int nextBapPosID(int n) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        int n2 = bAPArrayList$BAPArrayListElement != null ? bAPArrayList$BAPArrayListElement.nextBapPosID : 0;
        return n2;
    }

    public int previousBapPosID(int n) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        int n2 = bAPArrayList$BAPArrayListElement != null ? bAPArrayList$BAPArrayListElement.prevBapPosID : 0;
        return n2;
    }

    public int nextBapPosID(int n, int n2) {
        int n3;
        BAPArrayList$BAPArrayListIterator bAPArrayList$BAPArrayListIterator = n2 >= 0 ? this.getForwardIteratorStartingAt(n) : this.getBackwardIteratorStartingAt(n);
        BAPArrayElement bAPArrayElement = null;
        for (n3 = Math.abs(n2); n3 >= 0 && bAPArrayList$BAPArrayListIterator.hasNext(); --n3) {
            bAPArrayElement = bAPArrayList$BAPArrayListIterator.next();
        }
        int n4 = n3 == -1 && bAPArrayElement != null ? bAPArrayElement.getPos() : 0;
        return n4;
    }

    public int numberOfElementsInDirection(int n, boolean bl, int n2) {
        BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement = (BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        int n3 = bAPArrayList$BAPArrayListElement != null ? (bl ? bAPArrayList$BAPArrayListElement.absPosition - Math.max(bAPArrayList$BAPArrayListElement.absPosition - n2, -1) : Math.min(this.size() - bAPArrayList$BAPArrayListElement.absPosition, n2)) : 0;
        return n3;
    }

    public BAPArrayList$BAPArrayListIterator getForwardIteratorStartingAt(int n) {
        return new BAPArrayList$BAPArrayListIterator((BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(n), this.bapPosIDhashMap, true);
    }

    public BAPArrayList$BAPArrayListIterator getBackwardIteratorStartingAt(int n) {
        return new BAPArrayList$BAPArrayListIterator((BAPArrayList$BAPArrayListElement)this.bapPosIDhashMap.get(n), this.bapPosIDhashMap, false);
    }

    public BAPArrayListIDGenerator getIDGenerator() {
        return this.idGenerator;
    }

    public BAPArrayList$DeltaContext createNewDeltaContext(BAPArrayList$BAPArrayElementComparator bAPArrayList$BAPArrayElementComparator) {
        BAPArrayList$DeltaContext bAPArrayList$DeltaContext = new BAPArrayList$DeltaContext(this.bapPosIDhashMap, this.firstElement, bAPArrayList$BAPArrayElementComparator);
        this.firstElement = null;
        this.lastElement = null;
        this.bapPosIDhashMap = new IntObjectOptHashMap(this.bapPosIDhashMap.size());
        return bAPArrayList$DeltaContext;
    }

    public int computeFinalDeltaContext(BAPArrayList$DeltaContext bAPArrayList$DeltaContext, int n) {
        int n2;
        block7: {
            BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement;
            int n3;
            BAPArrayList$BAPArrayListIterator bAPArrayList$BAPArrayListIterator;
            block8: {
                bAPArrayList$BAPArrayListIterator = new BAPArrayList$BAPArrayListIterator(this.firstElement, this.bapPosIDhashMap, true);
                BAPArrayList$BAPArrayListIterator bAPArrayList$BAPArrayListIterator2 = bAPArrayList$DeltaContext.getIterator();
                BAPArrayList$BAPArrayElementComparator bAPArrayList$BAPArrayElementComparator = bAPArrayList$DeltaContext.getComparator();
                n2 = -1;
                n3 = 0;
                bAPArrayList$BAPArrayListElement = this.lastElement;
                BAPArrayList$BAPArrayListElement bAPArrayList$BAPArrayListElement2 = this.lastElement;
                while (bAPArrayList$BAPArrayListIterator.hasNext() && bAPArrayList$BAPArrayListIterator2.hasNext() && n3 <= n) {
                    bAPArrayList$BAPArrayListElement = bAPArrayList$BAPArrayListIterator.currentArrayListElement();
                    bAPArrayList$BAPArrayListElement2 = bAPArrayList$BAPArrayListIterator2.currentArrayListElement();
                    if (bAPArrayList$BAPArrayListElement2.bapPosID == bAPArrayList$BAPArrayListElement.bapPosID) {
                        int n4 = bAPArrayList$BAPArrayElementComparator.compare(bAPArrayList$BAPArrayListElement.listElement, bAPArrayList$BAPArrayListElement2.listElement, n2);
                        if (n4 != -1) {
                            n2 = n4;
                            bAPArrayList$DeltaContext.getChangedElements().add(bAPArrayList$BAPArrayListElement2);
                            ++n3;
                        }
                        bAPArrayList$BAPArrayListElement = bAPArrayList$BAPArrayListIterator.nextArrayListElement();
                        bAPArrayList$BAPArrayListElement2 = bAPArrayList$BAPArrayListIterator2.nextArrayListElement();
                        continue;
                    }
                    if (this.bapPosIDhashMap.containsKey(bAPArrayList$BAPArrayListElement2.bapPosID)) {
                        if (bAPArrayList$DeltaContext.containsBapPosID(bAPArrayList$BAPArrayListElement.bapPosID)) {
                            bAPArrayList$DeltaContext.getChangedElements().add(bAPArrayList$BAPArrayListElement2);
                            ++n3;
                            bAPArrayList$BAPArrayListElement = bAPArrayList$BAPArrayListIterator.nextArrayListElement();
                            bAPArrayList$BAPArrayListElement2 = bAPArrayList$BAPArrayListIterator2.nextArrayListElement();
                            continue;
                        }
                        bAPArrayList$DeltaContext.getAddedElements().add(bAPArrayList$BAPArrayListElement);
                        ++n3;
                        bAPArrayList$BAPArrayListElement = bAPArrayList$BAPArrayListIterator.nextArrayListElement();
                        continue;
                    }
                    bAPArrayList$DeltaContext.getRemovedElements().add(bAPArrayList$BAPArrayListElement2);
                    ++n3;
                    bAPArrayList$BAPArrayListElement2 = bAPArrayList$BAPArrayListIterator2.nextArrayListElement();
                }
                if (n3 > n) break block7;
                if (!bAPArrayList$BAPArrayListIterator2.hasNext()) break block8;
                while (bAPArrayList$BAPArrayListIterator2.hasNext() && n3 <= n) {
                    bAPArrayList$BAPArrayListElement2 = bAPArrayList$BAPArrayListIterator2.nextArrayListElement();
                    bAPArrayList$DeltaContext.getRemovedElements().add(bAPArrayList$BAPArrayListElement2);
                    ++n3;
                }
                break block7;
            }
            if (!bAPArrayList$BAPArrayListIterator.hasNext()) break block7;
            while (bAPArrayList$BAPArrayListIterator.hasNext() && n3 <= n) {
                bAPArrayList$BAPArrayListElement = bAPArrayList$BAPArrayListIterator.nextArrayListElement();
                bAPArrayList$DeltaContext.getAddedElements().add(bAPArrayList$BAPArrayListElement);
                ++n3;
            }
        }
        return n2 != -1 ? n2 : 15;
    }
}

