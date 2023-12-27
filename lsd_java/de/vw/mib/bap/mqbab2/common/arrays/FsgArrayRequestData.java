/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.common.arrays;

import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArray;
import de.vw.mib.bap.datatypes.BAPArrayData;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayDeltaContext;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayList;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete;
import de.vw.mib.bap.mqbab2.common.arrays.FsgArrayListComplete$BAPArrayListIterator;
import java.util.List;

public final class FsgArrayRequestData {
    private final int start;
    private final int end;
    private final int direction;
    private final int elements;
    private static final int MIN_NUMBER_OF_ELEMENTS_WITHOUT_POS;
    private static final int INVALID_POS;
    private static final int BACKWARD_DIRECTION;
    private static final int FORWARD_DIRECTION;
    private static final int SUCCESSOR_NUMBER;
    private static final int FULL_RANGE_THRESHOLD;
    private static final int TRANSMIT_LONG_POS_THRESHOLD;

    private FsgArrayRequestData(int n, int n2, int n3, int n4) {
        this.start = n;
        this.end = n2;
        this.elements = n3;
        this.direction = n4;
    }

    private FsgArrayRequestData(int n, int n2, int n3) {
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

    boolean isValid() {
        boolean bl = this.getDirectionIncrement() != -1 ? this.getEndOfList() >= 0 : true;
        boolean bl2 = this.getStartOfList() >= 0;
        return bl2 && bl;
    }

    public void fillRequestData(BAPStatusArray bAPStatusArray, BAPChangedArray bAPChangedArray) {
        BAPArrayData bAPArrayData = bAPStatusArray.getArrayData();
        BAPArrayData bAPArrayData2 = bAPChangedArray.getArrayData();
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

    public static FsgArrayRequestData computeArrayRequestData(ArrayHeader arrayHeader, int n, int n2, int n3) {
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
        return new FsgArrayRequestData(n5, n4, n6);
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

    public void setStatusArrayHeaderData(BAPStatusArray bAPStatusArray, BAPGetArray bAPGetArray, FsgArrayList fsgArrayList) {
        ArrayHeader arrayHeader = bAPStatusArray.getArrayHeader();
        ArrayHeader arrayHeader2 = bAPGetArray.getArrayHeader();
        arrayHeader.start = arrayHeader2.start;
        arrayHeader.setRecordAddress(arrayHeader2.getRecordAddress());
        arrayHeader.mode.arrayDirectionIsBackward = arrayHeader2.mode.arrayDirectionIsBackward;
        arrayHeader.mode.arrayPositionIsTransmitted = arrayHeader2.mode.arrayPositionIsTransmitted;
        arrayHeader.mode.indexSize16BitForStartElements = fsgArrayList != null && fsgArrayList.getIDGenerator() != null && fsgArrayList.getIDGenerator().isLongID() || this.getStartOfList() > 255 || this.getEndOfList() > 255;
        arrayHeader.mode.shift = arrayHeader2.mode.shift;
        arrayHeader.elements = this.getNumberOfElements();
        bAPStatusArray.setAsgId(bAPGetArray.getAsgId());
        bAPStatusArray.setTransactionId(bAPGetArray.getTransactionId());
        bAPStatusArray.setNumberOfElements(fsgArrayList != null ? fsgArrayList.getSize() : 0);
    }

    public void setStatusArrayHeaderDataAndFillRequestData(BAPStatusArray bAPStatusArray, BAPGetArray bAPGetArray, FsgArrayListComplete fsgArrayListComplete) {
        this.setStatusArrayHeaderData(bAPStatusArray, bAPGetArray, fsgArrayListComplete);
        this.fillRequestData(bAPStatusArray, fsgArrayListComplete);
    }

    public static FsgArrayRequestData computeArrayRequestData(ArrayHeader arrayHeader, FsgArrayList fsgArrayList, int n) {
        int n2;
        int n3;
        int n4;
        int n5 = fsgArrayList.getSize();
        int n6 = n5;
        int n7 = arrayHeader.elements > n6 ? n6 : arrayHeader.elements;
        int n8 = n4 = arrayHeader.mode.arrayDirectionIsBackward ? -1 : 1;
        if (arrayHeader.start == 0 && arrayHeader.mode.shift && arrayHeader.mode.arrayDirectionIsBackward) {
            n3 = fsgArrayList.lastBAPPosID();
            n2 = fsgArrayList.numberOfElementsInDirection(n3, arrayHeader.mode.arrayDirectionIsBackward, n7);
        } else {
            int n9 = n3 = arrayHeader.start == 0 ? fsgArrayList.firstBAPPosID() : arrayHeader.start;
            n3 = arrayHeader.mode.shift ? (arrayHeader.mode.arrayDirectionIsBackward ? fsgArrayList.previousBapPosID(n3) : fsgArrayList.nextBapPosID(n3)) : n3;
            n2 = fsgArrayList.numberOfElementsInDirection(n3, arrayHeader.mode.arrayDirectionIsBackward, n7);
        }
        return new FsgArrayRequestData(n3, 0, n2, n4);
    }

    public void fillRequestData(BAPStatusArray bAPStatusArray, FsgArrayListComplete fsgArrayListComplete) {
        FsgArrayListComplete$BAPArrayListIterator fsgArrayListComplete$BAPArrayListIterator = this.direction == 1 ? fsgArrayListComplete.getForwardIteratorStartingAt(this.start) : fsgArrayListComplete.getBackwardIteratorStartingAt(this.start);
        BAPArrayData bAPArrayData = bAPStatusArray.getArrayData();
        ArrayHeader arrayHeader = bAPStatusArray.getArrayHeader();
        for (int i2 = 0; fsgArrayListComplete$BAPArrayListIterator.hasNext() && i2 < this.elements; ++i2) {
            BAPArrayElement bAPArrayElement = fsgArrayListComplete$BAPArrayListIterator.next();
            bAPArrayElement.setArrayHeader(arrayHeader);
            bAPArrayData.add(bAPArrayElement);
        }
    }

    public static boolean computeChangeArrayData(BAPChangedArray bAPChangedArray, FsgArrayDeltaContext fsgArrayDeltaContext, FsgArrayListComplete fsgArrayListComplete, boolean bl) {
        boolean bl2;
        boolean bl3;
        BAPArrayData bAPArrayData = bAPChangedArray.getArrayData();
        ArrayHeader arrayHeader = bAPChangedArray.getArrayHeader();
        int n = fsgArrayListComplete.computeFinalDeltaContext(fsgArrayDeltaContext, 5);
        List list = fsgArrayDeltaContext.getAddedElements();
        int n2 = list.size();
        List list2 = fsgArrayDeltaContext.getRemovedElements();
        int n3 = list2.size();
        List list3 = fsgArrayDeltaContext.getChangedElements();
        int n4 = list3.size();
        boolean bl4 = n2 != 0;
        boolean bl5 = n3 != 0;
        boolean bl6 = bl3 = n4 != 0;
        boolean bl7 = bl3 ? bl4 || bl5 : (bl2 = bl4 && bl5);
        if (bl2 || n2 > 5 || n3 > 5 || n4 > 5 || bl3 && n == 15) {
            arrayHeader.setFullRangeUpdate(bl);
        } else if (bl5) {
            arrayHeader.start = fsgArrayDeltaContext.getBAPIdOfElement(list2.get(0));
            arrayHeader.elements = n3;
            arrayHeader.mode.shift = true;
            arrayHeader.mode.arrayDirectionIsBackward = true;
            arrayHeader.mode.arrayPositionIsTransmitted = true;
            arrayHeader.mode.indexSize16BitForStartElements = fsgArrayListComplete.getIDGenerator().isLongID();
            arrayHeader.setRecordAddress(15);
            for (int i2 = 0; i2 < n3; ++i2) {
                BAPArrayElement bAPArrayElement = fsgArrayDeltaContext.getBAPArrayElement(list2.get(i2));
                bAPArrayElement.setArrayHeader(arrayHeader);
                bAPArrayData.add(bAPArrayElement);
            }
        } else if (bl4 || bl3) {
            int n5;
            List list4;
            if (bl4) {
                arrayHeader.start = fsgArrayDeltaContext.getPrevBAPIdOfElement(list.get(0));
                arrayHeader.elements = n2 + 1;
                arrayHeader.mode.shift = true;
                arrayHeader.mode.arrayDirectionIsBackward = false;
                arrayHeader.mode.arrayPositionIsTransmitted = true;
                arrayHeader.mode.indexSize16BitForStartElements = fsgArrayListComplete.getIDGenerator().isLongID();
                arrayHeader.setRecordAddress(15);
                list4 = list;
                n5 = n2;
            } else {
                arrayHeader.start = fsgArrayDeltaContext.getPrevBAPIdOfElement(list3.get(0));
                arrayHeader.elements = n4 + 1;
                arrayHeader.mode.shift = false;
                arrayHeader.mode.arrayDirectionIsBackward = false;
                arrayHeader.mode.arrayPositionIsTransmitted = true;
                arrayHeader.mode.indexSize16BitForStartElements = fsgArrayListComplete.getIDGenerator().isLongID();
                arrayHeader.setRecordAddress(n, 15);
                list4 = list3;
                n5 = n4;
            }
            int n6 = fsgArrayDeltaContext.getBAPIdOfElement(list4.get(0));
            for (int i3 = 0; i3 < n5; ++i3) {
                Object object = list4.get(i3);
                BAPArrayElement bAPArrayElement = fsgArrayDeltaContext.getBAPArrayElement(object);
                if (n6 != bAPArrayElement.getPos()) {
                    arrayHeader.setFullRangeUpdate(bl);
                    bAPArrayData.reset();
                    n6 = -1;
                    break;
                }
                n6 = fsgArrayDeltaContext.getNextBAPIdOfElement(object);
                bAPArrayElement.setArrayHeader(arrayHeader);
                bAPArrayData.add(bAPArrayElement);
            }
            if (n6 != -1) {
                BAPArrayElement bAPArrayElement = bAPChangedArray.createArrayElement();
                bAPArrayElement.setPos(fsgArrayDeltaContext.getNextBAPIdOfElement(list4.get(list4.size() - 1)));
                bAPArrayData.add(bAPArrayElement);
            }
        } else {
            return false;
        }
        return true;
    }
}

