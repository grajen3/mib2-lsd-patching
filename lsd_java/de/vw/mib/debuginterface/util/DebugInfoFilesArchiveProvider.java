/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debuginterface.util;

import de.vw.mib.debuginterface.internal.ServiceManager;
import de.vw.mib.debuginterface.util.DebugInfoFilesArchiveProvider$1;
import de.vw.mib.log4mib.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public final class DebugInfoFilesArchiveProvider {
    public static final int BUFFER_SIZE;
    static Logger logger;
    Socket socket;
    ServerSocket server;

    public DebugInfoFilesArchiveProvider(int n, File file) {
        this(n, file, false);
    }

    public DebugInfoFilesArchiveProvider(int n, File file, boolean bl) {
        logger.normal(1).append("[DebugInfoFileProvider] Looking for debug info file: ").append(file.getAbsolutePath()).log();
        if (!file.exists()) {
            logger.error(1).append("[DebugInfoFileProvider] Debug info file not found! ").append(file.getAbsolutePath()).log();
            return;
        }
        this.startServer(n, file, bl);
    }

    private void startServer(int n, File file, boolean bl) {
        Thread thread = new Thread(new DebugInfoFilesArchiveProvider$1(this, n, file, bl), "DebugInfoFileProvider");
        thread.setPriority(3);
        thread.start();
    }

    public boolean isSocketOpen() {
        return this.server != null && this.server.isBound();
    }

    private void writeInt(OutputStream outputStream, int n) {
        outputStream.write((byte)(n >> 24));
        outputStream.write((byte)(n >> 16));
        outputStream.write((byte)(n >> 8));
        outputStream.write((byte)n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void sendFile(Socket socket, File file, boolean bl) {
        OutputStream outputStream = null;
        FileInputStream fileInputStream = null;
        try {
            outputStream = socket.getOutputStream();
            fileInputStream = new FileInputStream(file);
            int n = ((InputStream)fileInputStream).available();
            logger.normal(1).append("[DebugInfoFileProvider] debug info file size: ").append(n).log();
            if (bl) {
                this.writeInt(outputStream, n);
            }
            int n2 = 0;
            byte[] byArray = new byte[256];
            while (((InputStream)fileInputStream).available() > 0) {
                int n3 = ((InputStream)fileInputStream).read(byArray);
                outputStream.write(byArray, 0, n3);
                n2 += n3;
                if (!logger.isTraceEnabled(1)) continue;
                logger.trace(1).append("[DebugInfoFileProvider] bytes sent: ").append(n2).log();
            }
            logger.normal(1).append("[DebugInfoFileProvider] bytes sent: ").append(n2).log();
        }
        finally {
            if (outputStream != null) {
                outputStream.close();
            }
            if (fileInputStream != null) {
                ((InputStream)fileInputStream).close();
            }
        }
    }

    static {
        logger = ServiceManager.loggerFactory.getLogger(64);
    }
}

