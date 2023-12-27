/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.util;

import de.vw.mib.debuginterface.util.DebugInfoFilesArchiveFetcher$1;
import de.vw.mib.debuginterface.util.DebugInfoFilesArchiveFetcherListener;
import de.vw.mib.log4mib.Logger;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public final class DebugInfoFilesArchiveFetcher {
    public static final int BUFFER_SIZE;
    final DebugInfoFilesArchiveFetcherListener listener;
    private final Logger logger;

    public DebugInfoFilesArchiveFetcher(DebugInfoFilesArchiveFetcherListener debugInfoFilesArchiveFetcherListener) {
        this(debugInfoFilesArchiveFetcherListener, null);
    }

    public DebugInfoFilesArchiveFetcher(DebugInfoFilesArchiveFetcherListener debugInfoFilesArchiveFetcherListener, Logger logger) {
        this.listener = debugInfoFilesArchiveFetcherListener;
        this.logger = logger;
    }

    public void startFileTransfer(String string, int n, File file) {
        this.startFileTransfer(string, n, file, false);
    }

    public void startFileTransfer(String string, int n, File file, boolean bl) {
        try {
            if (!file.createNewFile()) {
                this.listener.localFileError(null);
                return;
            }
            if (!file.canWrite()) {
                this.listener.localFileError(null);
                return;
            }
        }
        catch (IOException iOException) {
            this.listener.localFileError(iOException);
            return;
        }
        Thread thread = new Thread(new DebugInfoFilesArchiveFetcher$1(this, string, n, bl, file));
        thread.setName("DebugInfoFilesArchiveFetcher");
        thread.start();
    }

    void receiveFile(Socket socket, File file) {
        int n;
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int n2 = 0;
        byte[] byArray = new byte[256];
        while (socket.isConnected() && (n = inputStream.read(byArray)) != -1) {
            fileOutputStream.write(byArray, 0, n);
            n2 += n;
            if (this.logger == null || !this.logger.isTraceEnabled(1)) continue;
            this.logger.trace(1).append("[DebugInfoFilesArchiveFetcher] bytes received: ").append(n2).log();
        }
        if (this.logger != null) {
            this.logger.info(1).append("[DebugInfoFilesArchiveFetcher] bytes received: ").append(n2).log();
        }
        fileOutputStream.close();
    }

    void receiveFileWithReadingFileSize(Socket socket, File file) {
        int n;
        int n2;
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        int n3 = this.readInt(inputStream);
        if (this.logger != null) {
            this.logger.info(1).append("[DebugInfoFilesArchiveFetcher] debug info file size: ").append(n3).log();
        }
        byte[] byArray = new byte[256];
        for (n = 0; socket.isConnected() && n < n3; n += n2) {
            n2 = inputStream.read(byArray);
            if (n2 == -1) {
                throw new EOFException();
            }
            fileOutputStream.write(byArray, 0, n2);
            if (this.logger == null || !this.logger.isTraceEnabled(1)) continue;
            this.logger.trace(1).append("[DebugInfoFilesArchiveFetcher] bytes received: ").append(n).log();
        }
        if (this.logger != null) {
            this.logger.info(1).append("[DebugInfoFilesArchiveFetcher] bytes received: ").append(n).log();
        }
        fileOutputStream.close();
    }

    private int readInt(InputStream inputStream) {
        int n;
        int n2;
        int n3;
        int n4 = inputStream.read();
        if ((n4 | (n3 = inputStream.read()) | (n2 = inputStream.read()) | (n = inputStream.read())) >= 0) {
            return (n4 << 24) + (n3 << 16) + (n2 << 8) + n;
        }
        throw new EOFException();
    }
}

