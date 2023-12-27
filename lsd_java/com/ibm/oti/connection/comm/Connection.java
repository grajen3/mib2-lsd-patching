/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.comm;

import com.ibm.oti.connection.ConnectionUtil;
import com.ibm.oti.connection.CreateConnection;
import com.ibm.oti.connection.DataConnection;
import com.ibm.oti.connection.comm.CommInputStream;
import com.ibm.oti.connection.comm.CommOutputStream;
import com.ibm.oti.util.Msg;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.util.Hashtable;
import javax.microedition.io.CommConnection;

public class Connection
extends DataConnection
implements CreateConnection,
CommConnection {
    private static final int DEFAULT_TIMEOUT;
    private static final int PARITY_NONE;
    private static final int PARITY_ODD;
    private static final int PARITY_EVEN;
    private static final int UNOPENED;
    private static final int OPEN;
    private static final int CLOSED;
    private boolean open = false;
    private boolean throwTimeout = false;
    private int access = 3;
    private int osHandle = 0;
    private int timeout = 5000;
    private int inputStatus = 0;
    private int outputStatus = 0;
    private int finalBaud = -1;
    private String portName = "";
    private static Hashtable openConnections;

    static {
        openConnections = new Hashtable();
    }

    @Override
    public javax.microedition.io.Connection setParameters2(String string, int n, boolean bl) {
        String[][] stringArray = ConnectionUtil.NO_PARAMETERS;
        int n2 = string.indexOf(59);
        if (n2 != -1) {
            stringArray = ConnectionUtil.getParameters(string.substring(n2 + 1));
            string = string.substring(0, n2);
        }
        this.setParameters(string, stringArray, n, bl);
        return this;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private void setParameters(String string, String[][] stringArray, int n, boolean bl) {
        int n2;
        this.access = n;
        this.throwTimeout = bl;
        try {
            n2 = Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            n2 = -1;
        }
        int n3 = 9600;
        int n4 = 8;
        int n5 = 1;
        int n6 = 0;
        boolean bl2 = false;
        boolean bl3 = false;
        boolean bl4 = true;
        int n7 = 0;
        while (n7 < stringArray.length) {
            String string2 = stringArray[n7][0].toLowerCase();
            String string3 = stringArray[n7][1].toLowerCase();
            if (string2.equals("baudrate")) {
                try {
                    n3 = Integer.parseInt(string3);
                }
                catch (NumberFormatException numberFormatException) {
                    throw new IllegalArgumentException(string3);
                }
            }
            if (string2.equals("bitsperchar")) {
                if (string3.equals("5")) {
                    n4 = 5;
                } else if (string3.equals("6")) {
                    n4 = 6;
                } else if (string3.equals("7")) {
                    n4 = 7;
                } else {
                    if (!string3.equals("8")) throw new IllegalArgumentException(string3);
                    n4 = 8;
                }
            } else if (string2.equals("parity")) {
                if (string3.equals("odd")) {
                    n6 = 1;
                } else if (string3.equals("even")) {
                    n6 = 2;
                } else {
                    if (!string3.equals("none")) throw new IllegalArgumentException(string3);
                    n6 = 0;
                }
            } else if (string2.equals("stopbits")) {
                if (string3.equals("1")) {
                    n5 = 1;
                } else {
                    if (!string3.equals("2")) throw new IllegalArgumentException(string3);
                    n5 = 2;
                }
            } else if (string2.equals("autocts")) {
                if (string3.equals("on")) {
                    bl3 = true;
                } else if (!string3.equals("off")) {
                    throw new IllegalArgumentException(string3);
                }
            } else if (string2.equals("autorts")) {
                if (string3.equals("on")) {
                    bl2 = true;
                } else if (!string3.equals("off")) {
                    throw new IllegalArgumentException(string3);
                }
            } else if (string2.equals("blocking")) {
                if (string3.equals("off")) {
                    bl4 = false;
                } else if (!string3.equals("on")) {
                    throw new IllegalArgumentException(string3);
                }
            } else {
                if (!string2.equals("timeout")) throw new IllegalArgumentException(string2);
                try {
                    this.timeout = Integer.parseInt(string3);
                }
                catch (NumberFormatException numberFormatException) {
                    this.timeout = -1;
                }
                if (this.timeout < 0) {
                    throw new IllegalArgumentException(string3);
                }
            }
            ++n7;
        }
        switch (n3) {
            case 300: 
            case 1200: 
            case 2400: 
            case 4800: 
            case 9600: 
            case 19200: 
            case 38400: 
            case 57600: 
            case 115200: {
                break;
            }
            default: {
                throw new IllegalArgumentException(Integer.toString(n3));
            }
        }
        if (bl4 && this.timeout == 0) {
            this.timeout = 3000;
        }
        if (!bl4) {
            this.timeout = 0;
        }
        if (n2 == -1) {
            if (openConnections.containsKey(string)) {
                throw new IOException(Msg.getString("K002c", string));
            }
            this.osHandle = this.openImpl2(string);
            this.portName = string;
            openConnections.put(this.portName, "");
        } else {
            this.osHandle = this.openImpl(n2);
        }
        this.configureImpl(this.osHandle, n3, n4, n5, n6, bl2, bl3, this.timeout);
        this.open = true;
    }

    private native int openImpl(int n) {
    }

    private native int openImpl2(String string) {
    }

    private native void configureImpl(int n, int n2, int n3, int n4, int n5, boolean bl, boolean bl2, int n6) {
    }

    @Override
    public void close() {
        if (this.open) {
            if (this.inputStatus != 1 && this.outputStatus != 1) {
                this.finalBaud = this.getBaud(this.osHandle);
                this.closeImpl(this.osHandle);
                openConnections.remove(this.portName);
            }
            this.open = false;
        }
    }

    private native void closeImpl(int n) {
    }

    void closeStream(boolean bl) {
        boolean bl2 = false;
        if (bl) {
            this.inputStatus = 2;
            bl2 = this.outputStatus != 1 && !this.open;
        } else {
            this.outputStatus = 2;
            boolean bl3 = bl2 = this.inputStatus != 1 && !this.open;
        }
        if (bl2) {
            this.finalBaud = this.getBaud(this.osHandle);
            this.closeImpl(this.osHandle);
            openConnections.remove(this.portName);
        }
    }

    @Override
    public InputStream openInputStream() {
        if (this.open) {
            if (this.inputStatus != 0) {
                throw new IOException(Msg.getString("K0192"));
            }
            if (this.access == 1 || this.access == 3) {
                this.inputStatus = 1;
                return new CommInputStream(this);
            }
            throw new IOException(Msg.getString("K00a9"));
        }
        throw new IOException(Msg.getString("K00ac"));
    }

    @Override
    public OutputStream openOutputStream() {
        if (this.open) {
            if (this.outputStatus != 0) {
                throw new IOException(Msg.getString("K0192"));
            }
            if (this.access == 2 || this.access == 3) {
                this.outputStatus = 1;
                return new CommOutputStream(this);
            }
            throw new IOException(Msg.getString("K00aa"));
        }
        throw new IOException(Msg.getString("K00ac"));
    }

    int read(byte[] byArray, int n, int n2) {
        if (n2 != 0) {
            int n3;
            long l = System.currentTimeMillis();
            do {
                if ((n3 = this.readImpl(this.osHandle, byArray, n, n2)) <= 0) continue;
                return n3;
            } while (n3 == 0 && System.currentTimeMillis() - l < (long)this.timeout);
            if (!this.throwTimeout) {
                return n3;
            }
            InterruptedIOException interruptedIOException = new InterruptedIOException(Msg.getString("K00df"));
            interruptedIOException.bytesTransferred = n3;
            throw interruptedIOException;
        }
        return 0;
    }

    private native int readImpl(int n, byte[] byArray, int n2, int n3) {
    }

    int write(byte[] byArray, int n, int n2) {
        if (n2 != 0) {
            int n3 = this.writeImpl(this.osHandle, byArray, n, n2);
            if (!this.throwTimeout || n3 == n2) {
                return n3;
            }
            InterruptedIOException interruptedIOException = new InterruptedIOException(Msg.getString("K00df"));
            interruptedIOException.bytesTransferred = n3;
            throw interruptedIOException;
        }
        return 0;
    }

    private native int writeImpl(int n, byte[] byArray, int n2, int n3) {
    }

    int available() {
        return this.availableImpl(this.osHandle);
    }

    private native int availableImpl(int n) {
    }

    @Override
    public int getBaudRate() {
        if (this.open || this.outputStatus == 1 || this.inputStatus == 1) {
            return this.getBaud(this.osHandle);
        }
        return this.finalBaud;
    }

    @Override
    public int setBaudRate(int n) {
        if (this.open || this.inputStatus == 1 || this.outputStatus == 1) {
            switch (n) {
                case 300: 
                case 1200: 
                case 2400: 
                case 4800: 
                case 9600: 
                case 19200: 
                case 38400: 
                case 57600: 
                case 115200: {
                    break;
                }
                default: {
                    throw new IllegalArgumentException(Integer.toString(n));
                }
            }
            return this.setBaud(this.osHandle, n);
        }
        return this.finalBaud;
    }

    private native int setBaud(int n, int n2) {
    }

    private native int getBaud(int n) {
    }
}

