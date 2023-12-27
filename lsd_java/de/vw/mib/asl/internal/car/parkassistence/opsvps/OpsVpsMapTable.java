/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.parkassistence.opsvps;

final class OpsVpsMapTable {
    private static final int MODEL_COLUMN;
    private static final int DSI_COLUMN;
    public static final int POPUP;
    public static final int SCREEN;
    public static final int VIEW;
    public static final int DEFAULT_VIEW;
    public static final int MODE;
    private static final int[][] TABLE_POPUP_VALUES;
    private static final int[][] TABLE_SCREEN_VALUES;
    private static final int[][] TABLE_CURRENT_VIEW_VALUES;
    private static final int[][] TABLE_MODE_VALUES;

    OpsVpsMapTable() {
    }

    public static int getModelValue(int n, int n2) {
        int n3;
        switch (n) {
            case 0: {
                n3 = OpsVpsMapTable.findValueInArray(TABLE_POPUP_VALUES, n2, 1);
                break;
            }
            case 1: {
                n3 = OpsVpsMapTable.findValueInArray(TABLE_SCREEN_VALUES, n2, 1);
                break;
            }
            case 2: {
                n3 = OpsVpsMapTable.findValueInArray(TABLE_CURRENT_VIEW_VALUES, n2, 1);
                break;
            }
            case 4: {
                n3 = OpsVpsMapTable.findValueInArray(TABLE_MODE_VALUES, n2, 1);
                break;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
        return n3;
    }

    public static int getDsiValue(int n, int n2) {
        int n3;
        switch (n) {
            case 0: {
                n3 = OpsVpsMapTable.findValueInArray(TABLE_POPUP_VALUES, n2, 0);
                break;
            }
            case 1: {
                n3 = OpsVpsMapTable.findValueInArray(TABLE_SCREEN_VALUES, n2, 0);
                break;
            }
            case 2: {
                n3 = OpsVpsMapTable.findValueInArray(TABLE_CURRENT_VIEW_VALUES, n2, 0);
                break;
            }
            case 4: {
                n3 = OpsVpsMapTable.findValueInArray(TABLE_MODE_VALUES, n2, 0);
                break;
            }
            default: {
                throw new UnsupportedOperationException();
            }
        }
        return n3;
    }

    private static int findValueInArray(int[][] nArray, int n, int n2) {
        int n3 = -1;
        int n4 = nArray.length;
        for (int i2 = 0; i2 < n4; ++i2) {
            if (nArray[i2][n2] != n) continue;
            n3 = i2;
            break;
        }
        if (n3 == -1) {
            n3 = 0;
        }
        return nArray[n3][n2 == 0 ? 1 : 0];
    }

    static {
        TABLE_POPUP_VALUES = new int[][]{{0, 0}, {1, 1}, {2, 4}, {3, 2}, {4, 3}, {5, 5}, {6, 7}, {7, 8}, {8, 18}, {-1, 6}};
        TABLE_SCREEN_VALUES = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 15}};
        TABLE_CURRENT_VIEW_VALUES = new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 6}};
        TABLE_MODE_VALUES = new int[][]{{0, 0}, {2, 2}, {1, 1}, {3, 8}, {4, 7}, {5, 5}, {6, 4}, {7, 6}, {8, 3}, {9, 13}, {10, 9}, {11, 11}, {12, 10}, {15, 15}};
    }
}

