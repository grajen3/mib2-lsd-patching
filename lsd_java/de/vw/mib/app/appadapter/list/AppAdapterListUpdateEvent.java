/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.app.appadapter.list;

public final class AppAdapterListUpdateEvent {
    public static final int CONTENT_CHANGED;
    public static final int ROWS_CHANGED;
    public static final int LIST_SIZE_CHANGED;
    public static final int FOCUS_ROW_CHANGED;
    public static final int STRING_INDEX_CHANGED;
    private static final int UNUSED;
    private final int updateType;
    private final int indexOrStatus;
    private final int countOrListSize;

    private AppAdapterListUpdateEvent(int n, int n2, int n3) {
        this.updateType = n;
        this.indexOrStatus = n2;
        this.countOrListSize = n3;
    }

    public static AppAdapterListUpdateEvent focusRowChanged(int n) {
        return new AppAdapterListUpdateEvent(8, n, -1);
    }

    public static AppAdapterListUpdateEvent rowsChanged(int n, int n2) {
        return new AppAdapterListUpdateEvent(2, n, n2);
    }

    public static AppAdapterListUpdateEvent listSizeChanged(int n) {
        return new AppAdapterListUpdateEvent(4, -1, n);
    }

    public static AppAdapterListUpdateEvent stringIndexChanged() {
        return new AppAdapterListUpdateEvent(16, -1, -1);
    }

    public static AppAdapterListUpdateEvent contentChanged() {
        return new AppAdapterListUpdateEvent(1, -1, -1);
    }

    public int getUpdateType() {
        return this.updateType;
    }

    public int getIndex() {
        this.checkUpdateType(10);
        return this.indexOrStatus;
    }

    public int getCount() {
        this.checkUpdateType(2);
        return this.countOrListSize;
    }

    public int getListSize() {
        this.checkUpdateType(4);
        return this.countOrListSize;
    }

    private void checkUpdateType(int n) {
        if ((n & this.updateType) == 0) {
            throw new IllegalStateException(new StringBuffer().append("Value not available for current update type ").append(this.updateType).toString());
        }
    }

    public int hashCode() {
        int n = 31;
        int n2 = 1;
        n2 = 31 * n2 + this.countOrListSize;
        n2 = 31 * n2 + this.indexOrStatus;
        n2 = 31 * n2 + this.updateType;
        return n2;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AppAdapterListUpdateEvent)) {
            return false;
        }
        AppAdapterListUpdateEvent appAdapterListUpdateEvent = (AppAdapterListUpdateEvent)object;
        return this.updateType == appAdapterListUpdateEvent.updateType && this.indexOrStatus == appAdapterListUpdateEvent.indexOrStatus && this.countOrListSize == appAdapterListUpdateEvent.countOrListSize;
    }

    public String toString() {
        switch (this.updateType) {
            case 1: {
                return "AppAdapterListUpdateEvent [CONTENT_CHANGED]";
            }
            case 2: {
                return new StringBuffer().append("AppAdapterListUpdateEvent [ROWS_CHANGED index=").append(this.indexOrStatus).append(", count=").append(this.countOrListSize).append("]").toString();
            }
            case 4: {
                return new StringBuffer().append("AppAdapterListUpdateEvent [LIST_SIZE_CHANGED size=").append(this.countOrListSize).append("]").toString();
            }
            case 8: {
                return new StringBuffer().append("AppAdapterListUpdateEvent [FOCUS_ROW_CHANGED index=").append(this.indexOrStatus).append("]").toString();
            }
            case 16: {
                return "AppAdapterListUpdateEvent [STRING_INDEX_CHANGED]";
            }
        }
        return super.toString();
    }
}

