/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.phone.api.model;

import de.vw.mib.asl.api.phone.model.PhoneNumber;
import de.vw.mib.asl.api.phone.services.CommonContact;

public final class PhoneNumberImpl
implements PhoneNumber {
    private final String number;
    private final CommonContact commonContact;
    private final int telPhoneType;
    private final int location;
    private final int deviceType;

    public PhoneNumberImpl(String string, CommonContact commonContact, int n) {
        this.number = string;
        this.commonContact = commonContact;
        this.telPhoneType = n;
        this.location = PhoneNumberImpl.locationFromAdbNumberType(n);
        this.deviceType = PhoneNumberImpl.deviceTypeFromAdbNumberType(n);
    }

    private static int locationFromAdbNumberType(int n) {
        if ((n & 2) != 0) {
            return 2;
        }
        if ((n & 0x400) != 0) {
            return 3;
        }
        if ((n & 4) != 0) {
            return 1;
        }
        return 99;
    }

    private static int deviceTypeFromAdbNumberType(int n) {
        if ((n & 0x40) != 0) {
            return 1;
        }
        if ((n & 0x10) != 0) {
            return 3;
        }
        if ((n & 0x80) != 0) {
            return 5;
        }
        if ((n & 0x808) != 0) {
            return 2;
        }
        return 99;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public CommonContact getCommonContact() {
        return this.commonContact;
    }

    @Override
    public int getTelPhoneType() {
        return this.telPhoneType;
    }

    @Override
    public int getLocation() {
        return this.location;
    }

    @Override
    public int getDeviceType() {
        return this.deviceType;
    }

    public String toString() {
        return new StringBuffer().append("PhoneNumberImpl [number=").append(this.number).append(", location=").append(this.location).append(", deviceType=").append(this.deviceType).append("]").toString();
    }
}

