/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.eso.mib.DebugSPIImpl;
import org.dsi.ifc.persistence.DSIPersistence;
import org.dsi.ifc.persistence.DSIPersistenceListener;

public class PersistenceListener
implements DSIPersistenceListener {
    private DSIPersistence persistence;
    protected DebugSPIImpl debugSPI;
    protected static final int RESOURCE_INFO_NAMESPACE;
    protected static final long RESOURCE_INFO_KEY;

    public PersistenceListener(DebugSPIImpl debugSPIImpl) {
        this.debugSPI = debugSPIImpl;
    }

    public void addDsi(DSIPersistence dSIPersistence) {
        this.persistence = dSIPersistence;
    }

    public void subscribeKeys() {
        int[] nArray = new int[]{262};
        long[] lArray = new long[]{0};
        this.persistence.subscribe(System.identityHashCode(this), nArray, lArray, -2);
    }

    @Override
    public void readString(int n, long l, String string, int n2) {
    }

    @Override
    public void readStringArray(int n, long l, String[] stringArray, int n2) {
    }

    @Override
    public void readInt(int n, long l, int n2, int n3) {
    }

    @Override
    public void writeInt(int n, long l, int n2) {
    }

    @Override
    public void readArray(int n, long l, int[] nArray, int n2) {
    }

    @Override
    public void unsubscribe(int n, int[] nArray, long[] lArray, int[] nArray2) {
    }

    @Override
    public void readBuffer(int n, long l, byte[] byArray, int n2) {
    }

    @Override
    public void getVisibleSystemLanguages(String string) {
    }

    @Override
    public void updateActiveSQLDatabaseMedium(int n, int n2) {
    }

    @Override
    public void writeBuffer(int n, long l, int n2) {
    }

    @Override
    public void writeString(int n, long l, int n2) {
    }

    @Override
    public void writeArray(int n, long l, int n2) {
    }

    @Override
    public void writeStringArray(int n, long l, int n2) {
    }

    @Override
    public void flushSQLDatabase(int n) {
    }

    @Override
    public void beginTransaction(int n, int n2) {
    }

    @Override
    public void endTransaction(int n, int n2) {
    }

    @Override
    public void valueChangedInt(int n, long l, int n2, int n3) {
        if (n3 == 0 && n == 262 && l == 0 && n2 >= 0 && n2 <= 4) {
            this.debugSPI.performanceIndicatorChange(n2);
        }
    }

    @Override
    public void valueChangedString(int n, long l, String string, int n2) {
    }

    @Override
    public void valueChangedArray(int n, long l, int[] nArray, int n2) {
    }

    @Override
    public void valueChangedStringArray(int n, long l, String[] stringArray, int n2) {
    }

    @Override
    public void valueChangedBuffer(int n, long l, byte[] byArray, int n2) {
    }

    @Override
    public void asyncException(int n, String string, int n2) {
    }
}

