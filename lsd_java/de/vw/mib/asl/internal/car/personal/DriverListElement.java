/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.car.personal;

import de.vw.mib.bap.datatypes.ArrayHeader;
import de.vw.mib.bap.datatypes.BAPArrayElement;
import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.stream.BitStream;
import org.dsi.ifc.carcomfort.DoorLockingUserListRA1;

public class DriverListElement
implements BAPArrayElement {
    public int posValue;
    public int userType;
    public String userProfileName;
    public boolean isActive;
    private ArrayHeader myArrayHeader;
    private DoorLockingUserListRA1 myDoorLockingUserListRA1;

    public DoorLockingUserListRA1 getDoorLockingUserListRA1() {
        return this.myDoorLockingUserListRA1;
    }

    public DriverListElement() {
        this(new ArrayHeader(), new DoorLockingUserListRA1());
    }

    public DriverListElement(ArrayHeader arrayHeader, DoorLockingUserListRA1 doorLockingUserListRA1) {
        this.posValue = doorLockingUserListRA1.getPos();
        this.userType = doorLockingUserListRA1.getType();
        this.userProfileName = doorLockingUserListRA1.getName();
        this.isActive = false;
        this.myArrayHeader = arrayHeader;
        this.myDoorLockingUserListRA1 = doorLockingUserListRA1;
    }

    @Override
    public void reset() {
    }

    @Override
    public boolean equalTo(BAPEntity bAPEntity) {
        return false;
    }

    @Override
    public void serialize(BitStream bitStream) {
    }

    @Override
    public void deserialize(BitStream bitStream) {
    }

    @Override
    public int bitSize() {
        return 0;
    }

    @Override
    public void setPos(int n) {
        this.posValue = n;
    }

    @Override
    public int getPos() {
        return this.posValue;
    }

    @Override
    public void setArrayHeader(ArrayHeader arrayHeader) {
        this.myArrayHeader = arrayHeader;
    }

    @Override
    public ArrayHeader getArrayHeader() {
        return this.myArrayHeader;
    }
}

