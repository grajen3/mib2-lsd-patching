/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.server;

import org.dsi.ifc.global.DateTime;

public interface License {
    default public String getLicenseID() {
    }

    default public void setLicenseID(String string) {
    }

    default public int getLicenseState() {
    }

    default public void setLicenseState(int n) {
    }

    default public int getLicenseType() {
    }

    default public void setLicenseType(int n) {
    }

    default public DateTime getLicenseExpiry() {
    }

    default public void setLicenseExpiry(DateTime dateTime) {
    }

    default public DateTime getPeriodOfValidityDate() {
    }

    default public void setPeriodOfValidityDate(DateTime dateTime) {
    }

    default public DateTime getActivationDate() {
    }

    default public void setActivationDate(DateTime dateTime) {
    }

    default public boolean isLicenseValid() {
    }

    default public void setLicenseValidity(boolean bl) {
    }

    default public void copyTo(License license) {
    }

    default public boolean equalsTo(License license) {
    }
}

