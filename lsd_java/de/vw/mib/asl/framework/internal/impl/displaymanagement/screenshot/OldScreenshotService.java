/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot;

import de.vw.mib.asl.framework.api.displaymanagement.WritableHelper;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementPersistence;
import de.vw.mib.asl.framework.internal.displaymanagement.DisplayManagementServices;
import de.vw.mib.asl.framework.internal.impl.displaymanagement.screenshot.AbstractScreenshotService;
import de.vw.mib.log4mib.Logger;
import de.vw.mib.util.Util;
import java.io.File;
import java.io.IOException;

public class OldScreenshotService
extends AbstractScreenshotService {
    private static final int WRITABLE_NO;
    private static final int WRITABLE_YES;
    private static final int WRITABLE_EXISTS;
    private static final String LOGGING_DELIM;
    private final Logger logger;
    private final WritableHelper writableHelper;

    public OldScreenshotService(DisplayManagementServices displayManagementServices, DisplayManagementPersistence displayManagementPersistence) {
        super(displayManagementServices, displayManagementPersistence);
        this.logger = displayManagementServices.getLogger();
        this.writableHelper = displayManagementServices.getWritableHelper();
    }

    @Override
    protected void doTakeScreenshot(String string) {
        String string2 = this.createAbsolutePath(string);
        if (string2 == null) {
            this.logger.warn(4096).append("[OldScreenshotService] ").append("No valid screenshot path found!").log();
        } else {
            this.getDsiDisplayManagement().takeScreenshot(0, string2);
        }
    }

    private String createAbsolutePath(String string) {
        String[] stringArray = this.getExternalScreenshotPaths();
        if (stringArray == null) {
            this.logger.warn(4096, "No screenshot paths available!");
            return null;
        }
        int n = stringArray.length;
        String string2 = null;
        for (int i2 = 0; i2 < n && string2 == null; ++i2) {
            String string3 = stringArray[i2];
            string2 = this.retrieveWritablePath(string, string3);
        }
        return string2;
    }

    private String retrieveWritablePath(String string, String string2) {
        if (!Util.isNullOrEmpty(string2)) {
            string2 = this.addLeadingSeparator(string2);
            File file = new File(new StringBuffer().append(string2).append(File.separator).append(string).toString());
            int n = this.checkWritable(file);
            File file2 = file;
            int n2 = 0;
            while (n == 2 && n2 < 100) {
                file2 = new File(new StringBuffer().append(file.getAbsoluteFile()).append("_").append(n2++).toString());
                n = this.checkWritable(file2);
            }
            if (n == 1) {
                if (this.logger.isTraceEnabled(4096)) {
                    this.logger.trace(4096).append("[OldScreenshotService] ").append("Path for Screenshots: ").append(string2).log();
                }
                return file2.getAbsolutePath();
            }
            if (this.writableHelper != null && this.writableHelper.makeWritable(string2) && this.checkWritable(file2 = new File(new StringBuffer().append(string2).append(File.separator).append(string).toString())) == 1) {
                return file2.getAbsolutePath();
            }
        }
        return null;
    }

    private String addLeadingSeparator(String string) {
        if (!string.startsWith(File.separator)) {
            string = new StringBuffer().append(File.separator).append(string).toString();
        }
        return string;
    }

    private int checkWritable(File file) {
        try {
            return file.createNewFile() ? 1 : 2;
        }
        catch (IOException iOException) {
            return 0;
        }
    }
}

