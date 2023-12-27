/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.tracing.config;

import de.esolutions.fw.util.config.ConfigValue;
import de.esolutions.fw.util.config.query.ConfigPathQuery;
import de.esolutions.fw.util.config.query.IConfigQuery;
import de.esolutions.fw.util.tracing.core.TraceCore;
import de.esolutions.fw.util.tracing.filetransfer.FileTransferManager;
import java.io.File;

public class TraceConfigFileTransfer {
    private IConfigQuery query = null;
    private boolean enabled = false;
    private String downloadDirectory = "tmp";
    private int blockSize = 2048;
    private byte digestType = 1;
    static /* synthetic */ Class class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager;

    private boolean isWindows() {
        String string = System.getProperty("os.name").toLowerCase();
        return string.indexOf("win") >= 0;
    }

    public TraceConfigFileTransfer(ConfigValue configValue) {
        this.query = new ConfigPathQuery(configValue);
        this.enabled = this.query.getBooleanValue("enabled", false);
        this.blockSize = this.query.getIntegerValue("blockSize", 2048);
        this.digestType = (byte)this.query.getIntegerValue("digestType", 1);
        String string = "/tmp/";
        if (this.isWindows()) {
            string = "C:\\temp\\";
        }
        this.downloadDirectory = this.query.getStringValue("downloadDirectory", string);
        if (!this.downloadDirectory.endsWith(File.separator)) {
            this.downloadDirectory = new StringBuffer().append(this.downloadDirectory).append(File.separator).toString();
        }
    }

    public void realize(TraceCore traceCore) {
        if (this.enabled) {
            FileTransferManager fileTransferManager = new FileTransferManager(this.blockSize, this.digestType, this.downloadDirectory);
            traceCore.setComponent((class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager == null ? (class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager = TraceConfigFileTransfer.class$("de.esolutions.fw.util.tracing.filetransfer.AbstractFileTransferManager")) : class$de$esolutions$fw$util$tracing$filetransfer$AbstractFileTransferManager).getName(), fileTransferManager);
        }
    }

    static /* synthetic */ Class class$(String string) {
        try {
            return Class.forName(string);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new NoClassDefFoundError().initCause(classNotFoundException);
        }
    }
}

