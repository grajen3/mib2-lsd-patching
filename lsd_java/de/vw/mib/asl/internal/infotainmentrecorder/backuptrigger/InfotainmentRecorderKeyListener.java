/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.infotainmentrecorder.backuptrigger;

import de.vw.mib.asl.api.system.KeyAdapter;
import de.vw.mib.asl.internal.infotainmentrecorder.backuptrigger.BackupService;
import de.vw.mib.configuration.ConfigurationManagerDiag;

public class InfotainmentRecorderKeyListener
extends KeyAdapter {
    private final BackupService backupService;
    private final ConfigurationManagerDiag configurationManager;

    public InfotainmentRecorderKeyListener(BackupService backupService, ConfigurationManagerDiag configurationManagerDiag) {
        this.backupService = backupService;
        this.configurationManager = configurationManagerDiag;
    }

    @Override
    public void onLongPressed(int n) {
        if (n == 5 && this.isTestModeAvailable()) {
            this.backupService.backup();
        }
    }

    @Override
    public void onUltraLongPressed(int n) {
        if (n == 16 && !this.isTestModeAvailable()) {
            this.backupService.backup();
        }
    }

    private boolean isTestModeAvailable() {
        return this.configurationManager.isFeatureFlagSet(400);
    }
}

