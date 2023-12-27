/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.extstartup.spi;

import de.vw.mib.extstartup.spi.StartupResumeListener;

public interface ExtendedStartupSPI {
    default public void addBootResumeListener(StartupResumeListener startupResumeListener) {
    }

    default public boolean isResumeFromSnapshotBoot() {
    }

    default public boolean isSnapshotBoot() {
    }

    default public boolean providesExtendedBootSupport() {
    }

    default public void readyToMakeSnaphot() {
    }

    default public void setSnapshotCorrupted() {
    }
}

