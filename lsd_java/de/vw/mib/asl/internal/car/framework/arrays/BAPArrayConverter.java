/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.framework.arrays;

import de.vw.mib.asl.api.car.arrays.ASLCarBAPArrayConverter;
import de.vw.mib.asl.framework.api.framework.ASLFrameworkFactory;
import de.vw.mib.asl.internal.car.framework.arrays.BapArrayFactory;
import de.vw.mib.bap.array.requests.BAPChangedArray;
import de.vw.mib.bap.array.requests.BAPGetArray;
import de.vw.mib.bap.array.requests.BAPStatusArray;
import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.log4mib.Logger;

final class BAPArrayConverter
implements ASLCarBAPArrayConverter {
    private static final int ARRAY_CONTENT_INIT;
    private static final int ARRAY_CONTENT_ALL;
    private static final int ARRAY_CONTENT_ALL_FORWARD;
    private static final int ARRAY_CONTENT_ALL_BACKWARD;
    private static final int ARRAY_CONTENT_ONLY_CHANGES;
    private static final int ARRAY_CONTENT_ELEMENTS_REMOVED;
    private static final int ARRAY_CONTENT_BLOCK_INSERTED;
    private static final int ARRAY_CONTENT_BACKWARD;
    private static final int ONE_ELEMENT_CHANGE_NUMBER;
    private static final int FULL_RANGE_NUMBER_OF_ELEMENTS;

    BAPArrayConverter() {
    }

    @Override
    public BAPChangedArray convertChangedArrayUpdateInfo(int n, int n2, int n3, int n4, boolean bl) {
        boolean bl2 = false;
        BAPChangedArray bAPChangedArray = BapArrayFactory.getInstance().createBapChangedArray();
        switch (n3) {
            case 1: {
                bl2 = true;
                break;
            }
            case 6: {
                if (bl) {
                    bAPChangedArray.getArrayHeader().setElementsInsertedBlockRequest(n, n2, false);
                    break;
                }
                if (n2 == 1) {
                    bAPChangedArray.getArrayHeader().setElementInsertedRequest(n, false);
                    break;
                }
                bl2 = true;
                break;
            }
            case 5: {
                if (bl) {
                    bAPChangedArray.getArrayHeader().setElementsDeleteBlockRequest(n, n2, false);
                    break;
                }
                bAPChangedArray.getArrayHeader().setElementsDeleteRangeRequest(n, n2, false);
                break;
            }
            case 4: {
                if (n2 == -1 && n == 0 && n4 == 0) {
                    bAPChangedArray.getArrayHeader().setFullRangeUpdate(false);
                    break;
                }
                if (bl) {
                    bAPChangedArray.getArrayHeader().setElementsChangedBlockRequest(n, n2, false, n4);
                    break;
                }
                if (n2 == 1) {
                    bAPChangedArray.getArrayHeader().setElementChangedRequest(n, false, n4);
                    break;
                }
                bl2 = true;
                break;
            }
            default: {
                bl2 = true;
            }
        }
        if (bl2) {
            bAPChangedArray.getArrayHeader().setFullRangeUpdate(false);
            this.getContextLogger().error(1).append("ArrayConversion: Do fallback to full range update. Received invalid updateInfo = ").append(", startElement=").append(n).append(", numOfElements=").append(n2).append(", arrayContent=").append(n3).append(", recordContent=").append(n4).log();
        }
        return bAPChangedArray;
    }

    private static void setAsgId(BAPStatusArray bAPStatusArray, int n) {
        bAPStatusArray.setAsgId(n);
        bAPStatusArray.setBroadcast(n == 0);
    }

    @Override
    public BAPStatusArray convertStatusArrayResponse(int n, int n2, int n3, int n4, int n5, int n6, int n7) {
        BAPStatusArray bAPStatusArray = BapArrayFactory.getInstance().createBapStatusArray();
        BAPArrayConverter.setAsgId(bAPStatusArray, n6);
        bAPStatusArray.setTransactionId(n5);
        bAPStatusArray.setNumberOfElements(n7);
        ArrayHeader arrayHeader = bAPStatusArray.getArrayHeader();
        arrayHeader.start = n;
        arrayHeader.elements = n2;
        arrayHeader.setRecordAddress(n4);
        arrayHeader.mode.indexSize16BitForStartElements = false;
        arrayHeader.mode.arrayPositionIsTransmitted = true;
        arrayHeader.mode.arrayDirectionIsBackward = n3 == 3 || n3 == 7;
        arrayHeader.mode.shift = n3 == 2 || n3 == 3;
        return bAPStatusArray;
    }

    @Override
    public int toArrayContent(BAPGetArray bAPGetArray) {
        ArrayHeader arrayHeader = bAPGetArray.getArrayHeader();
        int n = arrayHeader.mode.shift ? (arrayHeader.mode.arrayDirectionIsBackward ? 3 : 2) : (arrayHeader.mode.arrayDirectionIsBackward ? 7 : 1);
        return n;
    }

    private Logger getContextLogger() {
        return ASLFrameworkFactory.getASLFrameworkAPI().getASLLogger();
    }
}

