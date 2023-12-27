/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot;

import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementPersistence;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot.AbstractScreenshotService;

public class ExternalScreenshotService
extends AbstractScreenshotService {
    public ExternalScreenshotService(DisplayManagementServices displayManagementServices, DisplayManagementPersistence displayManagementPersistence) {
        super(displayManagementServices, displayManagementPersistence);
    }

    @Override
    protected void doTakeScreenshot(String string) {
        this.getDsiDisplayManagement().takeScreenshotOnExternalStorage(0, string);
    }
}

