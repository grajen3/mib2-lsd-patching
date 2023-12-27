/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.debug.connection.spi;

import de.vw.mib.debug.connection.spi.DebugSPI_Connection;
import de.vw.mib.debug.spi.messages.DebugSPI_HeaderException;
import java.io.EOFException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;

class DebugSPI_Connection$1
implements Runnable {
    private final /* synthetic */ Socket val$socket;
    private final /* synthetic */ DebugSPI_Connection this$0;

    DebugSPI_Connection$1(DebugSPI_Connection debugSPI_Connection, Socket socket) {
        this.this$0 = debugSPI_Connection;
        this.val$socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println(new StringBuffer().append("[DebugSPI_Connection] start reading from ").append(this.val$socket).append(" ...").toString());
            while (this.this$0.reading) {
                try {
                    this.this$0.codec.decode(this.this$0.input);
                }
                catch (DebugSPI_HeaderException debugSPI_HeaderException) {
                    this.this$0.handleConnectionError(debugSPI_HeaderException);
                }
                catch (SocketTimeoutException socketTimeoutException) {
                    this.this$0.handleConnectionLoss();
                }
            }
        }
        catch (SocketException socketException) {
            System.err.println(new StringBuffer().append("[DebugSPI_Connection] socket exception while reading from ").append(this.val$socket).append("!").toString());
            System.err.println(new StringBuffer().append("[DebugSPI_Connection] ").append(socketException.getMessage()).toString());
            this.this$0.handleConnectionLoss();
        }
        catch (EOFException eOFException) {
            System.err.println(new StringBuffer().append("[DebugSPI_Connection] eof exception while reading from ").append(this.val$socket).append("!").toString());
            System.err.println(new StringBuffer().append("[DebugSPI_Connection] ").append(eOFException.getMessage()).toString());
            this.this$0.handleConnectionLoss();
        }
        catch (Exception exception) {
            System.err.println(new StringBuffer().append("[DebugSPI_Connection] exception while reading from ").append(this.val$socket).append("!").toString());
            exception.printStackTrace();
            this.this$0.handleConnectionError(exception);
            this.this$0.handleConnectionLoss();
        }
        System.out.println(new StringBuffer().append("[DebugSPI_Connection] reading from ").append(this.val$socket).append(" stopped!").toString());
    }
}

