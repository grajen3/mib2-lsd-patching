/*
 * Decompiled with CFR 0.152.
 */
package de.eso.mib;

import de.vw.mib.extstartup.spi.ExtendedStartupSPI;
import de.vw.mib.extstartup.spi.StartupResumeListener;

public class ExtendedStartupSPIImpl
implements ExtendedStartupSPI {
    public static boolean CREATE_DEBUG_OUTPUT = true;

    @Override
    public void addBootResumeListener(StartupResumeListener startupResumeListener) {
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println("ExtendedStartupSPI NOT AVAILABLE");
        }
    }

    @Override
    public boolean isResumeFromSnapshotBoot() {
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println("ExtendedStartupSPI NOT AVAILABLE");
        }
        return false;
    }

    @Override
    public boolean isSnapshotBoot() {
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println("ExtendedStartupSPI NOT AVAILABLE");
        }
        return false;
    }

    @Override
    public boolean providesExtendedBootSupport() {
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println("ExtendedStartupSPI NOT AVAILABLE");
        }
        return false;
    }

    @Override
    public void readyToMakeSnaphot() {
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println("ExtendedStartupSPI NOT AVAILABLE");
        }
    }

    @Override
    public void setSnapshotCorrupted() {
        if (CREATE_DEBUG_OUTPUT) {
            System.out.println("ExtendedStartupSPI NOT AVAILABLE");
        }
    }
}

