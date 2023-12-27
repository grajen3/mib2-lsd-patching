/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.api.online.testbridge;

import de.vw.mib.genericevents.AbstractTarget;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class OnlineServiceCallbackCommunicator {
    private static final String PY_CONSOLE_DELIMITER;
    private static final String TOKEN;
    private Socket socket;
    private DataOutputStream dataOutStream;
    private AbstractTarget myTarget;
    private static OnlineServiceCallbackCommunicator myInstance;

    public static OnlineServiceCallbackCommunicator getMyInstance() {
        return myInstance;
    }

    public OnlineServiceCallbackCommunicator(AbstractTarget abstractTarget, String string, int n) {
        this.myTarget = abstractTarget;
        try {
            this.socket = new Socket(string, n);
            this.dataOutStream = new DataOutputStream(this.socket.getOutputStream());
        }
        catch (UnknownHostException unknownHostException) {
            abstractTarget.error(unknownHostException);
        }
        catch (IOException iOException) {
            abstractTarget.error(iOException);
        }
        myInstance = this;
    }

    public void closeSocket() {
        try {
            this.socket.close();
        }
        catch (IOException iOException) {
            this.myTarget.error(iOException);
        }
    }

    public void sendCallback(int n, int n2, String string) {
        this.sendData(new StringBuffer().append("###").append(this.padId(n)).append("_").append(n2).append("_").append(string).append(">>>").toString());
    }

    private void sendData(String string) {
        try {
            this.dataOutStream.write(string.getBytes());
        }
        catch (IOException iOException) {
            this.myTarget.error(iOException);
        }
    }

    private String padId(int n) {
        String string = n < 10 ? new StringBuffer().append("000").append(n).toString() : (n < 100 ? new StringBuffer().append("00").append(n).toString() : (n < 1000 ? new StringBuffer().append("0").append(n).toString() : (n < 10000 ? new StringBuffer().append("").append(n).toString() : new StringBuffer().append("").append(n % 10000).toString())));
        return string;
    }

    public static String createParameterString(int n, String string) {
        return new StringBuffer().append("_").append(n).append("_").append(string).toString();
    }

    public static String createParameterString(int n, String string, int n2, String string2) {
        return new StringBuffer().append("_").append(n).append("_").append(string).append("_").append(n2).append("_").append(string2).toString();
    }

    public static String createParameterString(int n, String string, int n2, String string2, int n3, String string3) {
        return new StringBuffer().append("_").append(n).append("_").append(string).append("_").append(n2).append("_").append(string2).append("_").append(n3).append("_").append(string3).toString();
    }

    public static String bool2String(boolean bl) {
        return bl ? "1" : "0";
    }
}

