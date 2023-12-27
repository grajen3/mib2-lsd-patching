/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.online.coreInterfaces.core.server;

import de.vw.mib.asl.internal.online.coreInterfaces.core.server.License;

public interface Service {
    default public void setServiceID(String string) {
    }

    default public String getServiceID() {
    }

    default public void setServiceName(String string) {
    }

    default public String getServiceName() {
    }

    default public void setDeviceID(int n) {
    }

    default public int getDeviceID() {
    }

    default public void setInvisible(boolean bl) {
    }

    default public boolean isInvisible() {
    }

    default public void setMainLicense(License license) {
    }

    default public License getMainLicense() {
    }

    default public void setServiceState(int n) {
    }

    default public int getServiceState() {
    }

    default public void setEnabledState(int n) {
    }

    default public int getEnabledState() {
    }

    default public void setDisabledActivation(boolean bl) {
    }

    default public boolean isDisabledActivation() {
    }

    default public void setLicenseAvailability(boolean bl) {
    }

    default public boolean isLicenseAvailable() {
    }

    default public void setTrackingService(boolean bl) {
    }

    default public boolean isTrackingService() {
    }

    default public void setTrackingToActive(boolean bl) {
    }

    default public boolean isTrackingActive() {
    }

    default public void setPrivacyGroups(int[] nArray) {
    }

    default public int[] getPrivacyGroups() {
    }

    default public void setServicePackage(int[] nArray) {
    }

    default public int[] getServicePackages() {
    }

    default public void setCategories(int[] nArray) {
    }

    default public int[] getCategories() {
    }

    default public void setServiceType(int n) {
    }

    default public int getServiceType() {
    }

    default public void setServiceDisablingBlocked(boolean bl) {
    }

    default public boolean isServiceDisablingBlocked() {
    }

    default public void setPrimaryUserRequired(boolean bl) {
    }

    default public boolean isPrimaryUserRequired() {
    }

    default public void setTermsAndConditionsRequired(boolean bl) {
    }

    default public boolean isTermsAndConditionsRequired() {
    }

    default public void setESIMUsageAllowed(boolean bl) {
    }

    default public boolean isESIMUsageAllowed() {
    }

    default public void setAPN(int n) {
    }

    default public int getAPN() {
    }

    default public boolean isServiceChanged() {
    }

    default public void setServiceChanged(boolean bl) {
    }

    default public boolean equalsTo(Service service) {
    }

    default public void copyTo(Service service) {
    }
}

