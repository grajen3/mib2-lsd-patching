/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.framework.component;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.log4mib.Logger;

public interface ASLComponent {
    public static final int COMPLIANCE_LEVEL_1;

    default public int getComplianceLevel() {
    }

    default public String getName() {
    }

    default public void init(Logger logger, Services services) {
    }

    default public void start() {
    }

    default public void stop() {
    }

    default public void shutdown() {
    }
}

