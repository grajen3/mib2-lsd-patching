/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.util.transport.debug;

public interface ITransportDebug {
    public static final int TX_FLAG;
    public static final int RX_FLAG;
    public static final int INSIDE_FLAG;
    public static final int ENTER_FLAG;
    public static final int LEAVE_FLAG;
    public static final int ERROR_FLAG;
    public static final int SYSCALL_FLAG;
    public static final int PACKET_FLAG;
    public static final int QUEUE_FLAG;
    public static final int APP_FLAG;
    public static final int CALLBACK_FLAG;
    public static final int RX_ENTER_SYSCALL;
    public static final int RX_LEAVE_SYSCALL;
    public static final int RX_ERROR_SYSCALL;
    public static final int TX_ENTER_SYSCALL;
    public static final int TX_LEAVE_SYSCALL;
    public static final int TX_ERROR_SYSCALL;
    public static final int RX_ENTER_PACKET;
    public static final int RX_INSIDE_PACKET;
    public static final int RX_LEAVE_PACKET;
    public static final int RX_ERROR_PACKET;
    public static final int TX_ENTER_PACKET;
    public static final int TX_INSIDE_PACKET;
    public static final int TX_LEAVE_PACKET;
    public static final int TX_ERROR_PACKET;
    public static final int RX_ENTER_QUEUE;
    public static final int RX_LEAVE_QUEUE;
    public static final int RX_ERROR_QUEUE;
    public static final int TX_ENTER_QUEUE;
    public static final int TX_LEAVE_QUEUE;
    public static final int TX_ERROR_QUEUE;
    public static final int RX_ENTER_APP;
    public static final int RX_INSIDE_APP;
    public static final int RX_LEAVE_APP;
    public static final int RX_ERROR_APP;
    public static final int TX_ENTER_APP;
    public static final int TX_INSIDE_APP;
    public static final int TX_LEAVE_APP;
    public static final int TX_ERROR_APP;
    public static final int RX_ENTER_CALLBACK;
    public static final int RX_INSIDE_CALLBACK;
    public static final int RX_LEAVE_CALLBACK;
    public static final int RX_ERROR_CALLBACK;
    public static final int TX_ENTER_CALLBACK;
    public static final int TX_INSIDE_CALLBACK;
    public static final int TX_LEAVE_CALLBACK;
    public static final int TX_ERROR_CALLBACK;

    default public void log(long l, int n, int n2, Object object) {
    }
}

