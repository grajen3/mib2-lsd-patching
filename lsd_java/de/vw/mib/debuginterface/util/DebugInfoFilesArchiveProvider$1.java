/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.util;

import de.vw.mib.debuginterface.util.DebugInfoFilesArchiveProvider;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

class DebugInfoFilesArchiveProvider$1
implements Runnable {
    private final /* synthetic */ int val$port;
    private final /* synthetic */ File val$debugInfoFile;
    private final /* synthetic */ boolean val$sendFileSize;
    private final /* synthetic */ DebugInfoFilesArchiveProvider this$0;

    DebugInfoFilesArchiveProvider$1(DebugInfoFilesArchiveProvider debugInfoFilesArchiveProvider, int n, File file, boolean bl) {
        this.this$0 = debugInfoFilesArchiveProvider;
        this.val$port = n;
        this.val$debugInfoFile = file;
        this.val$sendFileSize = bl;
    }

    @Override
    public void run() {
        try {
            DebugInfoFilesArchiveProvider.logger.normal(1).append("[DebugInfoFileProvider] Open server ... ").log();
            this.this$0.server = new ServerSocket(this.val$port);
        }
        catch (IOException iOException) {
            DebugInfoFilesArchiveProvider.logger.error(1, "[DebugInfoFileProvider] Error while opening server socket!", iOException);
            return;
        }
        try {
            this.this$0.socket = this.this$0.server.accept();
            DebugInfoFilesArchiveProvider.logger.normal(1).append("[DebugInfoFileProvider] Connected with ").append(this.this$0.socket).log();
        }
        catch (IOException iOException) {
            DebugInfoFilesArchiveProvider.logger.error(1, "[DebugInfoFileProvider] Error while creating socket!", iOException);
            return;
        }
        try {
            DebugInfoFilesArchiveProvider.logger.normal(1).append("[DebugInfoFileProvider] Sending debug info file ...").log();
            this.this$0.sendFile(this.this$0.socket, this.val$debugInfoFile, this.val$sendFileSize);
            DebugInfoFilesArchiveProvider.logger.normal(1).append("[DebugInfoFileProvider] Debug info file transfer finished!").log();
        }
        catch (IOException iOException) {
            DebugInfoFilesArchiveProvider.logger.error(1, "[DebugInfoFileProvider] Error while sending debug info file!", iOException);
        }
        try {
            this.this$0.socket.close();
            this.this$0.server.close();
            this.this$0.socket = null;
            DebugInfoFilesArchiveProvider.logger.normal(1).append("[DebugInfoFileProvider] Connection closed!").log();
        }
        catch (IOException iOException) {
            DebugInfoFilesArchiveProvider.logger.error(1, "[DebugInfoFileProvider] Error while closing socket!", iOException);
        }
    }
}

