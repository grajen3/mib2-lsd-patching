/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni.serializer;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;

public final class UserList_UserLoginState
implements BAPEntity {
    private static final int RESERVED_BIT_1__7_BITSIZE;
    public boolean userIsLoggedIn;

    public UserList_UserLoginState() {
        this.internalReset();
        this.customInitialization();
    }

    public UserList_UserLoginState(BitStream bitStream) {
        this();
        this.deserialize(bitStream);
    }

    private void internalReset() {
        this.userIsLoggedIn = false;
    }

    @Override
    public void reset() {
        this.internalReset();
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        UserList_UserLoginState userList_UserLoginState = (UserList_UserLoginState)bAPEntity;
        return this.userIsLoggedIn == userList_UserLoginState.userIsLoggedIn;
    }

    private void customInitialization() {
    }

    @Override
    public String toString() {
        return "UserList_Empty:";
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void serialize(BitStream bitStream) {
        bitStream.resetBits(7);
        bitStream.pushBoolean(this.userIsLoggedIn);
    }

    @Override
    public void deserialize(BitStream bitStream) {
        bitStream.discardBits(7);
        this.userIsLoggedIn = bitStream.popFrontBoolean();
    }
}

