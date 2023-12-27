/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import java.io.UnsupportedEncodingException;

class Socks4Message {
    protected byte[] buffer = new byte[256];
    private static final int SOCKS_VERSION;
    public static final int COMMAND_CONNECT;
    public static final int COMMAND_BIND;
    public static final int RETURN_SUCCESS;
    public static final int RETURN_FAILURE;
    public static final int RETURN_CANNOT_CONNECT_TO_IDENTD;
    public static final int RETURN_DIFFERENT_USER_IDS;
    protected static final int INDEX_VERSION;
    private static final int INDEX_COMMAND;
    private static final int INDEX_PORT;
    private static final int INDEX_IP;
    private static final int INDEX_USER_ID;
    private static final int BUFFER_LENGTH;
    public static final int REPLY_LENGTH;
    private static final int MAX_USER_ID_LENGTH;

    public Socks4Message() {
        this.setVersionNumber(4);
    }

    public int getCommandOrResult() {
        return this.buffer[1];
    }

    public void setCommandOrResult(int n) {
        this.buffer[1] = (byte)n;
    }

    public int getPort() {
        return this.getInt16(2);
    }

    public void setPort(int n) {
        this.setInt16(2, n);
    }

    public int getIP() {
        return this.getInt32(4);
    }

    public void setIP(byte[] byArray) {
        this.buffer[4] = byArray[0];
        this.buffer[5] = byArray[1];
        this.buffer[6] = byArray[2];
        this.buffer[7] = byArray[3];
    }

    public String getUserId() {
        return this.getString(8, 248);
    }

    public void setUserId(String string) {
        this.setString(8, 248, string);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("");
        stringBuffer.append("Version: ");
        stringBuffer.append(Integer.toHexString(this.getVersionNumber()));
        stringBuffer.append(" Command: ");
        stringBuffer.append(Integer.toHexString(this.getCommandOrResult()));
        stringBuffer.append(" Port: ");
        stringBuffer.append(this.getPort());
        stringBuffer.append(" IP: ");
        stringBuffer.append(Integer.toHexString(this.getIP()));
        stringBuffer.append(" User ID: ");
        stringBuffer.append(this.getUserId());
        return stringBuffer.toString();
    }

    public int getLength() {
        int n = 0;
        n = 8;
        while (this.buffer[n] != 0) {
            ++n;
        }
        return ++n;
    }

    public String getErrorString(int n) {
        switch (n) {
            case 91: {
                return Msg.getString("K00cd");
            }
            case 92: {
                return Msg.getString("K00ce");
            }
            case 93: {
                return Msg.getString("K00cf");
            }
        }
        return Msg.getString("K00d0");
    }

    public byte[] getBytes() {
        return this.buffer;
    }

    private int getInt16(int n) {
        return ((this.buffer[n] & 0xFF) << 8) + (this.buffer[n + 1] & 0xFF);
    }

    private int getInt32(int n) {
        return (this.buffer[n + 3] & 0xFF) + ((this.buffer[n + 2] & 0xFF) << 8) + ((this.buffer[n + 1] & 0xFF) << 16) + ((this.buffer[n + 0] & 0xFF) << 24);
    }

    private String getString(int n, int n2) {
        String string;
        int n3 = n;
        int n4 = n3 + n2;
        while (n3 < n4 && this.buffer[n3] != 0) {
            ++n3;
        }
        try {
            string = new String(this.buffer, n, n3 - n, "ISO8859_1");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.toString());
        }
        return string;
    }

    private int getVersionNumber() {
        return this.buffer[0];
    }

    private void setInt16(int n, int n2) {
        this.buffer[n] = (byte)(n2 >>> 8 & 0xFF);
        this.buffer[n + 1] = (byte)(n2 & 0xFF);
    }

    private void setString(int n, int n2, String string) {
        byte[] byArray;
        try {
            byArray = string.getBytes("ISO8859_1");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException(unsupportedEncodingException.toString());
        }
        int n3 = Math.min(byArray.length, n2);
        System.arraycopy((Object)byArray, 0, (Object)this.buffer, n, n3);
        this.buffer[n + n3] = 0;
    }

    private void setVersionNumber(int n) {
        this.buffer[0] = (byte)n;
    }
}

