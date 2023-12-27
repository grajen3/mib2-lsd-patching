/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.api.framework.component;

import de.vw.mib.asl.framework.api.framework.Services;
import de.vw.mib.asl.framework.api.framework.component.ASLComponent;
import de.vw.mib.log4mib.Logger;

public abstract class ASLComponentAdapter
implements ASLComponent {
    @Override
    public int getComplianceLevel() {
        return 1;
    }

    @Override
    public void init(Logger logger, Services services) {
    }

    @Override
    public void start() {
    }

    @Override
    public void stop() {
    }

    @Override
    public void shutdown() {
    }
}

