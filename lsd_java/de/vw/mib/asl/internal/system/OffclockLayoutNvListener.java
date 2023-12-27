/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.system;

import de.vw.mib.asl.internal.system.util.Preconditions;
import de.vw.mib.asl.systemcommon.persistence.SystemCommon;
import de.vw.mib.configuration.ConfigurationManager;
import de.vw.mib.configuration.NvListener;

public class OffclockLayoutNvListener
implements NvListener {
    private final ConfigurationManager configurationManager;
    private final SystemCommon persistence;

    public OffclockLayoutNvListener(SystemCommon systemCommon, ConfigurationManager configurationManager) {
        Preconditions.checkArgumentNotNull(configurationManager);
        Preconditions.checkArgumentNotNull(systemCommon);
        this.configurationManager = configurationManager;
        this.persistence = systemCommon;
    }

    @Override
    public void notifyNvListener(int n) {
        if (n == 5) {
            int n2 = this.configurationManager.getOffClockLayout();
            this.persistence.setOffclockLayout(n2);
        }
    }
}

