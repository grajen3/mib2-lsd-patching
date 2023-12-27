/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.util;

import de.vw.mib.debuginterface.util.DebugInfoFilesArchiveFetcher;
import java.io.File;
import java.io.IOException;
import java.net.Socket;

class DebugInfoFilesArchiveFetcher$1
implements Runnable {
    private final /* synthetic */ String val$host;
    private final /* synthetic */ int val$port;
    private final /* synthetic */ boolean val$readFileSize;
    private final /* synthetic */ File val$localFile;
    private final /* synthetic */ DebugInfoFilesArchiveFetcher this$0;

    DebugInfoFilesArchiveFetcher$1(DebugInfoFilesArchiveFetcher debugInfoFilesArchiveFetcher, String string, int n, boolean bl, File file) {
        this.this$0 = debugInfoFilesArchiveFetcher;
        this.val$host = string;
        this.val$port = n;
        this.val$readFileSize = bl;
        this.val$localFile = file;
    }

    @Override
    public void run() {
        Socket socket = null;
        try {
            socket = new Socket(this.val$host, this.val$port);
            this.this$0.listener.connected();
        }
        catch (IOException iOException) {
            this.this$0.listener.connectionFailed(iOException);
            return;
        }
        try {
            if (this.val$readFileSize) {
                this.this$0.receiveFileWithReadingFileSize(socket, this.val$localFile);
            } else {
                this.this$0.receiveFile(socket, this.val$localFile);
            }
            this.this$0.listener.fileTransferFinished();
        }
        catch (IOException iOException) {
            this.this$0.listener.fileTransferError(iOException);
        }
        try {
            socket.close();
            this.this$0.listener.connectionClosed();
        }
        catch (IOException iOException) {
            this.this$0.listener.connectionFailed(iOException);
        }
    }
}

