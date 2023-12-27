/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.requests.StatusProperty;
import de.vw.mib.bap.stream.BitStream;

public final class OnlineNavigationState_Status
implements StatusProperty {
    public int state;
    public static final int STATE_OFF;
    public static final int STATE_INIT_LOADING;
    public static final int STATE_ACTIVE;
    public static final int STATE_NO_DATA_CONNECTION;
    public int progress;
    public int onlineNavigationSystem;
    public static final int ONLINE_NAVIGATION_SYSTEM_ONLINE_NAVIGATION_NOT_BUILT_IN;
    public static final int ONLINE_NAVIGATION_SYSTEM_GOOGLE_NAVIGATION;
    public static final int ONLINE_NAVIGATION_SYSTEM_UNKNOWN_TECHNICAL_SYSTEM_FOR_ONLINE_NAVIGATION;

    public OnlineNavigationState_Status() {
        this.internalReset();
        this.customInitialization();
    }

    public OnlineNavigationState_Status(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.state = 0;
        this.progress = 0;
        this.onlineNavigationSystem = 0;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        OnlineNavigationState_Status onlineNavigationState_Status = (OnlineNavigationState_Status)bAPEntity;
        return this.state == onlineNavigationState_Status.state && this.progress == onlineNavigationState_Status.progress && this.onlineNavigationSystem == onlineNavigationState_Status.onlineNavigationSystem;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "OnlineNavigationState_Status:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.pushByte((byte)this.state);
        bitStream.pushByte((byte)this.progress);
        bitStream.pushByte((byte)this.onlineNavigationSystem);
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    public static int functionId() {
        return 48;
    }

    @Override
    public int getFunctionId() {
        return OnlineNavigationState_Status.functionId();
    }
}

