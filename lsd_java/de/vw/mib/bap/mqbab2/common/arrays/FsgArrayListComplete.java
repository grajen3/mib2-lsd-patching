/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayDeltaContext;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayList;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete$BAPArrayListElement;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete$BAPArrayListIterator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListElementComparator;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListIdGenerator;
import de.vw.mib.collections.ints.IntObjectOptHashMap;
import de.vw.mib.collections.longs.LongIntOptHashMap;

public final class FsgArrayListComplete
implements FsgArrayList {
    public static final int INVALID_ELEMENT_ANCHOR_ID;
    private static final int INVALID_INDEX;
    private static final int NOT_IN_HASH_MAP;
    private FsgArrayListIdGenerator idGenerator;
    private IntObjectOptHashMap bapPosIDhashMap;
    private LongIntOptHashMap entryIDHashMap;
    private FsgArrayListComplete$BAPArrayListElement lastElement;
    private FsgArrayListComplete$BAPArrayListElement firstElement;

    public FsgArrayListComplete(FsgArrayListIdGenerator fsgArrayListIdGenerator) {
        this.idGenerator = fsgArrayListIdGenerator;
        this.bapPosIDhashMap = new IntObjectOptHashMap();
        this.entryIDHashMap = new LongIntOptHashMap();
        this.lastElement = null;
        this.firstElement = null;
    }

    private FsgArrayListComplete(FsgArrayListIdGenerator fsgArrayListIdGenerator, IntObjectOptHashMap intObjectOptHashMap, LongIntOptHashMap longIntOptHashMap) {
        this.idGenerator = fsgArrayListIdGenerator;
        this.bapPosIDhashMap = intObjectOptHashMap;
        this.entryIDHashMap = longIntOptHashMap;
        this.lastElement = null;
        this.firstElement = null;
    }

    public FsgArrayListComplete copy() {
        return new FsgArrayListComplete(this.idGenerator, new IntObjectOptHashMap(this.bapPosIDhashMap.size()), this.entryIDHashMap);
    }

    private int _putElement(long l, int n, BAPArrayElement bAPArrayElement, long l2) {
        int n2 = n;
        if (n2 != 0 && this.idGenerator.isBAPPosIDValid(n2, l)) {
            if (this.bapPosIDhashMap.containsKey(n2)) {
                return 0;
            }
        } else {
            n2 = this.idGenerator.createBAPPosID(l);
            this.entryIDHashMap.put(l, n2);
        }
        bAPArrayElement.setPos(n2);
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = new FsgArrayListComplete$BAPArrayListElement();
        if (this.lastElement == null) {
            fsgArrayListComplete$BAPArrayListElement.takeParams(0, 0, n2, 0, l2, bAPArrayElement);
            this.firstElement = fsgArrayListComplete$BAPArrayListElement;
        } else {
            fsgArrayListComplete$BAPArrayListElement.takeParams(this.lastElement.bapPosID, 0, n2, this.bapPosIDhashMap.size(), l2, bAPArrayElement);
            this.lastElement.nextBapPosID = n2;
        }
        this.bapPosIDhashMap.put(n2, fsgArrayListComplete$BAPArrayListElement);
        this.lastElement = fsgArrayListComplete$BAPArrayListElement;
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

    @Override
    public BAPArrayElement getElement(int n) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        BAPArrayElement bAPArrayElement = fsgArrayListComplete$BAPArrayListElement != null ? fsgArrayListComplete$BAPArrayListElement.listElement : null;
        return bAPArrayElement;
    }

    public long getInternalUserId(int n) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        long l = fsgArrayListComplete$BAPArrayListElement != null ? fsgArrayListComplete$BAPArrayListElement.elementAnchorID : -1L;
        return l;
    }

    public int getBapPosID(long l) {
        int n = this.entryIDHashMap.containsKey(l) ? this.entryIDHashMap.get(l) : 0;
        return n;
    }

    @Override
    public int getIndexOfBapPosId(int n) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        int n2 = fsgArrayListComplete$BAPArrayListElement != null ? fsgArrayListComplete$BAPArrayListElement.absPosition : -1;
        return n2;
    }

    private void removeElement(FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement) {
        if (fsgArrayListComplete$BAPArrayListElement.nextBapPosID != 0) {
            FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement2 = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(fsgArrayListComplete$BAPArrayListElement.nextBapPosID);
            fsgArrayListComplete$BAPArrayListElement2.prevBapPosID = fsgArrayListComplete$BAPArrayListElement.prevBapPosID;
            if (fsgArrayListComplete$BAPArrayListElement.prevBapPosID != 0) {
                FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement3 = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(fsgArrayListComplete$BAPArrayListElement.prevBapPosID);
                fsgArrayListComplete$BAPArrayListElement3.nextBapPosID = fsgArrayListComplete$BAPArrayListElement2.bapPosID;
            }
        } else if (fsgArrayListComplete$BAPArrayListElement.prevBapPosID != 0) {
            FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement4 = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(fsgArrayListComplete$BAPArrayListElement.prevBapPosID);
            fsgArrayListComplete$BAPArrayListElement4.nextBapPosID = 0;
            this.lastElement = fsgArrayListComplete$BAPArrayListElement4;
        }
        this.bapPosIDhashMap.remove(fsgArrayListComplete$BAPArrayListElement.bapPosID);
    }

    public void removeElement(int n) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        this.removeElement(fsgArrayListComplete$BAPArrayListElement);
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

    @Override
    public int getSize() {
        return this.bapPosIDhashMap.size();
    }

    @Override
    public int lastBAPPosID() {
        if (this.lastElement != null) {
            return this.lastElement.bapPosID;
        }
        return 0;
    }

    @Override
    public int firstBAPPosID() {
        if (this.firstElement != null) {
            return this.firstElement.bapPosID;
        }
        return 0;
    }

    @Override
    public int nextBapPosID(int n) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        int n2 = fsgArrayListComplete$BAPArrayListElement != null ? fsgArrayListComplete$BAPArrayListElement.nextBapPosID : 0;
        return n2;
    }

    @Override
    public int previousBapPosID(int n) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        int n2 = fsgArrayListComplete$BAPArrayListElement != null ? fsgArrayListComplete$BAPArrayListElement.prevBapPosID : 0;
        return n2;
    }

    @Override
    public int nextBapPosID(int n, int n2) {
        int n3;
        FsgArrayListComplete$BAPArrayListIterator fsgArrayListComplete$BAPArrayListIterator = n2 >= 0 ? this.getForwardIteratorStartingAt(n) : this.getBackwardIteratorStartingAt(n);
        BAPArrayElement bAPArrayElement = null;
        for (n3 = Math.abs(n2); n3 >= 0 && fsgArrayListComplete$BAPArrayListIterator.hasNext(); --n3) {
            bAPArrayElement = fsgArrayListComplete$BAPArrayListIterator.next();
        }
        int n4 = n3 == -1 && bAPArrayElement != null ? bAPArrayElement.getPos() : 0;
        return n4;
    }

    @Override
    public int numberOfElementsInDirection(int n, boolean bl, int n2) {
        FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement = (FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(n);
        int n3 = fsgArrayListComplete$BAPArrayListElement != null ? (bl ? fsgArrayListComplete$BAPArrayListElement.absPosition - Math.max(fsgArrayListComplete$BAPArrayListElement.absPosition - n2, -1) : Math.min(this.getSize() - fsgArrayListComplete$BAPArrayListElement.absPosition, n2)) : 0;
        return n3;
    }

    public FsgArrayListComplete$BAPArrayListIterator getForwardIteratorStartingAt(int n) {
        return new FsgArrayListComplete$BAPArrayListIterator((FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(n), this.bapPosIDhashMap, true);
    }

    public FsgArrayListComplete$BAPArrayListIterator getBackwardIteratorStartingAt(int n) {
        return new FsgArrayListComplete$BAPArrayListIterator((FsgArrayListComplete$BAPArrayListElement)this.bapPosIDhashMap.get(n), this.bapPosIDhashMap, false);
    }

    @Override
    public FsgArrayListIdGenerator getIDGenerator() {
        return this.idGenerator;
    }

    public FsgArrayDeltaContext createNewDeltaContext(FsgArrayListElementComparator fsgArrayListElementComparator) {
        FsgArrayDeltaContext fsgArrayDeltaContext = new FsgArrayDeltaContext(this.bapPosIDhashMap, this.firstElement, fsgArrayListElementComparator);
        this.firstElement = null;
        this.lastElement = null;
        this.bapPosIDhashMap = new IntObjectOptHashMap(this.bapPosIDhashMap.size());
        return fsgArrayDeltaContext;
    }

    public int computeFinalDeltaContext(FsgArrayDeltaContext fsgArrayDeltaContext, int n) {
        int n2;
        block7: {
            FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement;
            int n3;
            FsgArrayListComplete$BAPArrayListIterator fsgArrayListComplete$BAPArrayListIterator;
            block8: {
                fsgArrayListComplete$BAPArrayListIterator = new FsgArrayListComplete$BAPArrayListIterator(this.firstElement, this.bapPosIDhashMap, true);
                FsgArrayListComplete$BAPArrayListIterator fsgArrayListComplete$BAPArrayListIterator2 = fsgArrayDeltaContext.getIterator();
                FsgArrayListElementComparator fsgArrayListElementComparator = fsgArrayDeltaContext.getComparator();
                n2 = -1;
                n3 = 0;
                fsgArrayListComplete$BAPArrayListElement = this.lastElement;
                FsgArrayListComplete$BAPArrayListElement fsgArrayListComplete$BAPArrayListElement2 = this.lastElement;
                while (fsgArrayListComplete$BAPArrayListIterator.hasNext() && fsgArrayListComplete$BAPArrayListIterator2.hasNext() && n3 <= n) {
                    fsgArrayListComplete$BAPArrayListElement = fsgArrayListComplete$BAPArrayListIterator.currentArrayListElement();
                    fsgArrayListComplete$BAPArrayListElement2 = fsgArrayListComplete$BAPArrayListIterator2.currentArrayListElement();
                    if (fsgArrayListComplete$BAPArrayListElement2.bapPosID == fsgArrayListComplete$BAPArrayListElement.bapPosID) {
                        int n4 = fsgArrayListElementComparator.compare(fsgArrayListComplete$BAPArrayListElement.listElement, fsgArrayListComplete$BAPArrayListElement2.listElement, n2);
                        if (n4 != -1) {
                            n2 = n4;
                            fsgArrayDeltaContext.getChangedElements().add(fsgArrayListComplete$BAPArrayListElement2);
                            ++n3;
                        }
                        fsgArrayListComplete$BAPArrayListElement = fsgArrayListComplete$BAPArrayListIterator.nextArrayListElement();
                        fsgArrayListComplete$BAPArrayListElement2 = fsgArrayListComplete$BAPArrayListIterator2.nextArrayListElement();
                        continue;
                    }
                    if (this.bapPosIDhashMap.containsKey(fsgArrayListComplete$BAPArrayListElement2.bapPosID)) {
                        if (fsgArrayDeltaContext.containsBapPosID(fsgArrayListComplete$BAPArrayListElement.bapPosID)) {
                            fsgArrayDeltaContext.getChangedElements().add(fsgArrayListComplete$BAPArrayListElement2);
                            ++n3;
                            fsgArrayListComplete$BAPArrayListElement = fsgArrayListComplete$BAPArrayListIterator.nextArrayListElement();
                            fsgArrayListComplete$BAPArrayListElement2 = fsgArrayListComplete$BAPArrayListIterator2.nextArrayListElement();
                            continue;
                        }
                        fsgArrayDeltaContext.getAddedElements().add(fsgArrayListComplete$BAPArrayListElement);
                        ++n3;
                        fsgArrayListComplete$BAPArrayListElement = fsgArrayListComplete$BAPArrayListIterator.nextArrayListElement();
                        continue;
                    }
                    fsgArrayDeltaContext.getRemovedElements().add(fsgArrayListComplete$BAPArrayListElement2);
                    ++n3;
                    fsgArrayListComplete$BAPArrayListElement2 = fsgArrayListComplete$BAPArrayListIterator2.nextArrayListElement();
                }
                if (n3 > n) break block7;
                if (!fsgArrayListComplete$BAPArrayListIterator2.hasNext()) break block8;
                while (fsgArrayListComplete$BAPArrayListIterator2.hasNext() && n3 <= n) {
                    fsgArrayListComplete$BAPArrayListElement2 = fsgArrayListComplete$BAPArrayListIterator2.nextArrayListElement();
                    fsgArrayDeltaContext.getRemovedElements().add(fsgArrayListComplete$BAPArrayListElement2);
                    ++n3;
                }
                break block7;
            }
            if (!fsgArrayListComplete$BAPArrayListIterator.hasNext()) break block7;
            while (fsgArrayListComplete$BAPArrayListIterator.hasNext() && n3 <= n) {
                fsgArrayListComplete$BAPArrayListElement = fsgArrayListComplete$BAPArrayListIterator.nextArrayListElement();
                fsgArrayDeltaContext.getAddedElements().add(fsgArrayListComplete$BAPArrayListElement);
                ++n3;
            }
        }
        return n2 != -1 ? n2 : 15;
    }
}

