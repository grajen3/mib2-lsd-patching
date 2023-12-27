/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbpq.common.arrays;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$BAPArrayListIterator;
import de.vw.mib.bap.mqbpq.common.arrays.BAPArrayList$DeltaContext;
import java.util.List;

public final class ArrayRequestData {
    private final int start;
    private final int end;
    private int direction;
    private int elements;
    private static final int MIN_NUMBER_OF_ELEMENTS_WITHOUT_POS;
    private static final int INVALID_POS;
    private static final int BACKWARD_DIRECTION;
    private static final int FORWARD_DIRECTION;
    private static final int ONE_ELEMENT_CHANGE_NUMBER;
    private static final int FULL_RANGE_THRESHOLD;

    private ArrayRequestData(int n, int n2, int n3, int n4) {
        this.start = n;
        this.end = n2;
        this.elements = n3;
        this.direction = n4;
    }

    private ArrayRequestData(int n, int n2, int n3) {
        this(n, n2, Math.abs(n - n2), n3);
    }

    public int getStartOfList() {
        return this.start;
    }

    public int getEndOfList() {
        return this.end;
    }

    public int getDirectionIncrement() {
        return this.direction;
    }

    public int getNumberOfElements() {
        return this.elements;
    }

    public void fillRequestData(BAPStatusArray bAPStatusArray, BAPStatusArray bAPStatusArray2) {
        BAPArrayData bAPArrayData = bAPStatusArray.getArrayData();
        BAPArrayData bAPArrayData2 = bAPStatusArray2.getArrayData();
        for (int i2 = this.start; i2 != this.end; i2 += this.direction) {
            bAPArrayData.add(bAPArrayData2.get(i2));
        }
    }

    public void fillRequestData(BAPStatusArray bAPStatusArray, BAPChangedArray bAPChangedArray, int n) {
        BAPArrayData bAPArrayData = bAPStatusArray.getArrayData();
        BAPArrayData bAPArrayData2 = bAPChangedArray.getArrayData();
        int n2 = this.end != -1 ? this.end - n : this.end;
        for (int i2 = this.start - n; i2 != n2; i2 += this.direction) {
            bAPArrayData.add(bAPArrayData2.get(i2));
        }
    }

    public static ArrayRequestData computeArrayRequestData(ArrayHeader arrayHeader, int n, int n2, int n3) {
        int n4;
        int n5;
        int n6;
        int n7 = n;
        int n8 = arrayHeader.elements > n7 ? n7 : arrayHeader.elements;
        int n9 = n6 = arrayHeader.mode.arrayDirectionIsBackward ? -1 : 1;
        if ((arrayHeader.start == 0 || n2 == 0) && arrayHeader.mode.shift && arrayHeader.mode.arrayDirectionIsBackward) {
            n5 = n + n6;
            n4 = n5 + n6 * n8;
        } else {
            n5 = arrayHeader.start == 0 ? 0 : n2;
            n4 = (n5 += arrayHeader.mode.shift ? n6 : 0) + n6 * n8;
        }
        if (n5 >= n && n4 >= n) {
            n5 = 0;
            n4 = 0;
        } else {
            if (n4 > n) {
                n4 = n;
            } else if (n4 < 0) {
                n4 = n > 0 && arrayHeader.mode.arrayDirectionIsBackward ? -1 : 0;
            }
            if (n5 < 0 || n == 0) {
                n5 = 0;
            } else if (n5 >= n) {
                n5 = n - 1;
            }
        }
        return new ArrayRequestData(n5, n4, n6);
    }

    public void setTransmissionPosForConsecutiveArrayInterpretedAsArbitrary(BAPArray bAPArray) {
        ArrayHeader arrayHeader = bAPArray.getArrayHeader();
        if (this.getNumberOfElements() != 0 && (arrayHeader.mode.shift || arrayHeader.start == 0)) {
            arrayHeader.mode.arrayPositionIsTransmitted = true;
        }
    }

    public void setTransmissionPosForConsecutiveArray(BAPArray bAPArray) {
        ArrayHeader arrayHeader = bAPArray.getArrayHeader();
        arrayHeader.mode.arrayPositionIsTransmitted = this.getNumberOfElements() != 0 && arrayHeader.start == 0 && arrayHeader.mode.shift && arrayHeader.mode.arrayDirectionIsBackward;
    }

    public void setTransmissionPosForArbitraryArray(BAPArray bAPArray) {
        ArrayHeader arrayHeader = bAPArray.getArrayHeader();
        arrayHeader.mode.arrayPositionIsTransmitted = this.getNumberOfElements() != 0 && (arrayHeader.mode.shift || arrayHeader.elements != 1 || arrayHeader.start == 0);
    }

    public void setStatusArrayHeaderData(BAPArray bAPArray, ArrayHeader arrayHeader, boolean bl) {
        ArrayHeader arrayHeader2 = bAPArray.getArrayHeader();
        arrayHeader2.start = arrayHeader.start;
        arrayHeader2.setRecordAddress(arrayHeader.getRecordAddress());
        arrayHeader2.mode.arrayDirectionIsBackward = arrayHeader.mode.arrayDirectionIsBackward;
        arrayHeader2.mode.arrayPositionIsTransmitted = arrayHeader.mode.arrayPositionIsTransmitted;
        arrayHeader2.mode.indexSize16BitForStartElements = arrayHeader.mode.indexSize16BitForStartElements;
        arrayHeader2.mode.shift = arrayHeader.mode.shift;
        arrayHeader2.elements = this.getNumberOfElements();
        arrayHeader2.mode.indexSize16BitForStartElements = bl;
    }

    public static ArrayRequestData computeArrayRequestData(ArrayHeader arrayHeader, BAPArrayList bAPArrayList, int n) {
        int n2;
        int n3;
        int n4;
        int n5 = bAPArrayList.size();
        int n6 = n5;
        int n7 = arrayHeader.elements > n6 ? n6 : arrayHeader.elements;
        int n8 = n4 = arrayHeader.mode.arrayDirectionIsBackward ? -1 : 1;
        if (arrayHeader.start == 0 && arrayHeader.mode.shift && arrayHeader.mode.arrayDirectionIsBackward) {
            n3 = bAPArrayList.lastBAPPosID();
            n2 = bAPArrayList.numberOfElementsInDirection(n3, arrayHeader.mode.arrayDirectionIsBackward, n7);
        } else {
            int n9 = n3 = arrayHeader.start == 0 ? bAPArrayList.firstBAPPosID() : arrayHeader.start;
            n3 = arrayHeader.mode.shift ? (arrayHeader.mode.arrayDirectionIsBackward ? bAPArrayList.previousBapPosID(n3) : bAPArrayList.nextBapPosID(n3)) : n3;
            n2 = bAPArrayList.numberOfElementsInDirection(n3, arrayHeader.mode.arrayDirectionIsBackward, n7);
        }
        return new ArrayRequestData(n3, -1, n2, n4);
    }

    public void fillRequestData(BAPStatusArray bAPStatusArray, BAPArrayList bAPArrayList) {
        BAPArrayList$BAPArrayListIterator bAPArrayList$BAPArrayListIterator = this.direction == 1 ? bAPArrayList.getForwardIteratorStartingAt(this.start) : bAPArrayList.getBackwardIteratorStartingAt(this.start);
        BAPArrayData bAPArrayData = bAPStatusArray.getArrayData();
        ArrayHeader arrayHeader = bAPStatusArray.getArrayHeader();
        for (int i2 = 0; bAPArrayList$BAPArrayListIterator.hasNext() && i2 < this.elements; ++i2) {
            BAPArrayElement bAPArrayElement = bAPArrayList$BAPArrayListIterator.next();
            bAPArrayElement.setArrayHeader(arrayHeader);
            bAPArrayData.add(bAPArrayElement);
        }
    }

    public static boolean computChangeArrayData(BAPChangedArray bAPChangedArray, BAPArrayList$DeltaContext bAPArrayList$DeltaContext, BAPArrayList bAPArrayList, boolean bl) {
        boolean bl2;
        boolean bl3;
        ArrayHeader arrayHeader = bAPChangedArray.getArrayHeader();
        int n = bAPArrayList.computeFinalDeltaContext(bAPArrayList$DeltaContext, 5);
        List list = bAPArrayList$DeltaContext.getAddedElements();
        int n2 = list.size();
        List list2 = bAPArrayList$DeltaContext.getRemovedElements();
        int n3 = list2.size();
        List list3 = bAPArrayList$DeltaContext.getChangedElements();
        int n4 = list3.size();
        boolean bl4 = n2 != 0;
        boolean bl5 = n3 != 0;
        boolean bl6 = bl3 = n4 != 0;
        boolean bl7 = bl3 ? bl4 || bl5 : (bl2 = bl4 && bl5);
        if (bl2 || n2 > 5 || n3 > 5 || n4 > 5 || bl3 && n == 15) {
            arrayHeader.setFullRangeUpdate(bl);
        } else if (bl5) {
            arrayHeader.setElementsDeleteRangeRequest(bAPArrayList$DeltaContext.getBAPIdOfElement(list2.get(0)), n3, bAPArrayList.getIDGenerator().isLongID());
            int n5 = bAPArrayList$DeltaContext.getBAPIdOfElement(list2.get(0));
            for (int i2 = 0; i2 < n3; ++i2) {
                Object object = list2.get(i2);
                BAPArrayElement bAPArrayElement = bAPArrayList$DeltaContext.getBAPArrayElement(object);
                if (n5 != bAPArrayElement.getPos()) {
                    arrayHeader.setFullRangeUpdate(bl);
                    break;
                }
                n5 = bAPArrayList$DeltaContext.getNextBAPIdOfElement(object);
            }
        } else if (bl4) {
            arrayHeader.setElementInsertedRequest(bAPArrayList$DeltaContext.getBAPIdOfElement(list.get(0)), bAPArrayList.getIDGenerator().isLongID());
        } else if (bl3) {
            arrayHeader.setElementChangedRequest(bAPArrayList$DeltaContext.getBAPIdOfElement(list3.get(0)), bAPArrayList.getIDGenerator().isLongID(), n);
        } else if (bl4 || bl3) {
            if (bl4 && n2 == 1) {
                arrayHeader.setElementInsertedRequest(bAPArrayList$DeltaContext.getBAPIdOfElement(list.get(0)), bAPArrayList.getIDGenerator().isLongID());
            } else if (bl3 && n4 == 1) {
                arrayHeader.setElementChangedRequest(bAPArrayList$DeltaContext.getBAPIdOfElement(list3.get(0)), bAPArrayList.getIDGenerator().isLongID(), n);
            } else {
                arrayHeader.setFullRangeUpdate(bl);
            }
        } else {
            return false;
        }
        return true;
    }
}

