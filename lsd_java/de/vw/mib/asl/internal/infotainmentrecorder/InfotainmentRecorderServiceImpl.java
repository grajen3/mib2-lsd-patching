/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.infotainmentrecorder;

import de.vw.mib.asl.api.infotainmentrecorder.InfotainmentRecorderService;
import de.vw.mib.asl.internal.infotainmentrecorder.backuptrigger.BackupService;

public class InfotainmentRecorderServiceImpl
implements InfotainmentRecorderService {
    private boolean backupPending;
    private BackupService backupService;

    @Override
    public void backupInfotainmentRecorder() {
        if (this.backupService != null) {
            this.backupService.backup();
        } else {
            this.backupPending = true;
        }
    }

    public void installBackupService(BackupService backupService) {
        this.backupService = backupService;
        if (this.backupPending) {
            this.backupInfotainmentRecorder();
        }
    }
}

