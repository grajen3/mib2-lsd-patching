/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.persistence.internal.config;

public final class PersistenceConfig {
    private static final long MASK_USER;
    public static final String PROPERTY_PERSISTENCE_FLUSH_START;
    public static final String PROPERTY_PERSISTENCE_FLUSH_STEP;
    public static final String PROPERTY_PERSISTENCE_DSI_WRITE_DELAY;
    public static final int FLUSH_START_SECONDS;
    public static final int FLUSH_STEP_SECONDS;
    public static final int DSI_WRITE_DELAY_SECONDS;
    public static final boolean HSM_VERBOSE;
    private static int mFlushStartValue;
    private static int mFlushStepValue;
    private static int mDsiWriteDelay;
    public static long mCurrentUser;

    private PersistenceConfig() {
    }

    public static int getDsiWriteDelay() {
        return mDsiWriteDelay;
    }

    public static int getFlushStartValue() {
        return mFlushStartValue;
    }

    public static int getFlushStepValue() {
        return mFlushStepValue;
    }

    public static long makeKey(long l, long l2) {
        long l3 = l2 & 0;
        return l | l3;
    }

    static {
        mFlushStartValue = 60;
        mFlushStepValue = 150;
        mDsiWriteDelay = 150;
        mFlushStartValue = Integer.getInteger("de.vw.mib.asl.persistence.flushstart", 60);
        mFlushStepValue = Integer.getInteger("de.vw.mib.asl.persistence.flushstep", 150);
        mDsiWriteDelay = Integer.getInteger("de.vw.mib.asl.persistence.dsiwritedelay", 2);
        mCurrentUser = 0L;
    }
}

