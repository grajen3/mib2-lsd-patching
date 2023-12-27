/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.phone.model;

import de.vw.mib.asl.api.phone.services.CommonContact;

public interface PhoneNumber {
    public static final int LOC_PRIVATE;
    public static final int LOC_BUSINESS;
    public static final int LOC_CAR;
    public static final int LOC_OTHER;
    public static final int DEVICE_MOBILE;
    public static final int DEVICE_LANDLINE;
    public static final int DEVICE_FAX;
    public static final int DEVICE_FIX;
    public static final int DEVICE_PAGER;
    public static final int DEVICE_OTHER;

    default public String getNumber() {
    }

    default public CommonContact getCommonContact() {
    }

    default public int getTelPhoneType() {
    }

    default public int getLocation() {
    }

    default public int getDeviceType() {
    }
}

