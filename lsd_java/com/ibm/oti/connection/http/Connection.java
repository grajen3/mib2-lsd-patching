/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.http;

import com.ibm.oti.connection.ConnectionUtil;
import com.ibm.oti.connection.CreateConnection;
import com.ibm.oti.connection.DataConnection;
import com.ibm.oti.connection.http.Connection$1;
import com.ibm.oti.connection.http.Connection$2;
import com.ibm.oti.connection.http.Connection$3;
import com.ibm.oti.connection.http.Connection$ChunkedInputStream;
import com.ibm.oti.connection.http.Connection$HttpOutputStream;
import com.ibm.oti.connection.http.Connection$LimitedInputStream;
import com.ibm.oti.connection.http.Header;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.VM;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import javax.microedition.io.HttpConnection;
import javax.microedition.io.StreamConnection;

public class Connection
extends DataConnection
implements CreateConnection,
StreamConnection,
HttpConnection {
    private static boolean allowProxyParameter = false;
    private static final int UNOPENED;
    private static final int OPEN;
    private static final int CLOSED;
    int access;
    String host;
    String file;
    int httpVersion = 1;
    boolean sentRequest = false;
    boolean conClosed = false;
    String method = "GET";
    int responseCode = -1;
    String responseMessage;
    Header reqHeader = new Header(false);
    Header resHeader;
    boolean timeout;
    InputStream is;
    InputStream uis;
    OutputStream socketOut;
    Connection$HttpOutputStream os;
    String proxyName;
    int port;
    int proxyPort;
    boolean followRedirects = true;
    boolean sendChunked = false;
    String socketOptions = "";
    StreamConnection socket;
    boolean connected = false;
    private int inputStatus = 0;
    private int outputStatus = 0;
    private boolean updateProxy = true;

    @Override
    public void close() {
        this.conClosed = true;
        if (this.inputStatus != 1 && (this.os == null || this.os.closed)) {
            if (this.os != null) {
                this.os.close();
            }
            if (this.uis != null) {
                this.uis.close();
            }
            this.closeSocket();
        }
    }

    void closeConnection() {
        this.conClosed = true;
        this.closeSocket();
    }

    void closeSocket() {
        if (this.is != null) {
            this.is.close();
        }
        if (this.socketOut != null) {
            this.socketOut.close();
        }
        if (this.socket != null) {
            this.socket.close();
        }
    }

    @Override
    public long getDate() {
        return this.getHeaderFieldDate("Date", 0L);
    }

    @Override
    public long getExpiration() {
        return this.getHeaderFieldDate("Expires", 0L);
    }

    @Override
    public String getFile() {
        if (this.file == null) {
            return null;
        }
        int n = this.file.indexOf(63);
        if (n != -1) {
            return this.file.substring(0, n);
        }
        n = this.file.indexOf(35);
        if (n == -1) {
            return this.file;
        }
        return this.file.substring(0, n);
    }

    @Override
    public String getHeaderField(int n) {
        if (this.conClosed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        this.doRequest();
        return this.resHeader.get(n + 1);
    }

    @Override
    public String getHeaderField(String string) {
        if (this.conClosed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        this.doRequest();
        if (string == null) {
            return null;
        }
        return this.resHeader.get(string);
    }

    @Override
    public long getHeaderFieldDate(String string, long l) {
        String string2 = this.getHeaderField(string);
        if (string2 == null) {
            return l;
        }
        return Util.parseDate(string2);
    }

    @Override
    public int getHeaderFieldInt(String string, int n) {
        try {
            return Integer.parseInt(this.getHeaderField(string));
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    @Override
    public String getHeaderFieldKey(int n) {
        if (this.conClosed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        this.doRequest();
        return this.resHeader.getKey(n + 1);
    }

    @Override
    public String getHost() {
        return this.host;
    }

    @Override
    public long getLastModified() {
        return this.getHeaderFieldDate("Last-Modified", 0L);
    }

    @Override
    public int getPort() {
        return this.port;
    }

    @Override
    public String getProtocol() {
        return "http";
    }

    @Override
    public String getQuery() {
        if (this.file == null) {
            return null;
        }
        int n = this.file.indexOf(63);
        if (n == -1) {
            return null;
        }
        String string = this.file.substring(n + 1);
        if ((n = string.indexOf(35)) == -1) {
            return string;
        }
        return string.substring(0, n);
    }

    @Override
    public String getRef() {
        if (this.file == null) {
            return null;
        }
        int n = this.file.indexOf(35);
        if (n == -1) {
            return null;
        }
        return this.file.substring(n + 1);
    }

    @Override
    public String getRequestMethod() {
        return this.method;
    }

    @Override
    public String getRequestProperty(String string) {
        return this.reqHeader.get(string);
    }

    @Override
    public int getResponseCode() {
        int n;
        if (this.conClosed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        this.doRequest();
        if (this.responseCode != -1) {
            return this.responseCode;
        }
        String string = this.resHeader.get(0);
        if (string == null || !string.startsWith("HTTP/")) {
            return -1;
        }
        string.trim();
        int n2 = string.indexOf(" ") + 1;
        if (n2 == 0) {
            return -1;
        }
        if (string.charAt(n2 - 2) != '1') {
            this.httpVersion = 0;
        }
        if ((n = n2 + 3) > string.length()) {
            n = string.length();
        }
        this.responseCode = Integer.parseInt(string.substring(n2, n));
        if (n + 1 <= string.length()) {
            this.responseMessage = string.substring(n + 1);
        }
        return this.responseCode;
    }

    @Override
    public String getResponseMessage() {
        if (this.conClosed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.responseMessage != null) {
            return this.responseMessage;
        }
        this.getResponseCode();
        return this.responseMessage;
    }

    @Override
    public String getURL() {
        StringBuffer stringBuffer = new StringBuffer(this.getProtocol());
        stringBuffer.append(':');
        if (this.host != null) {
            stringBuffer.append("//");
            stringBuffer.append(this.host);
        }
        if (this.port != this.getDefaultPort()) {
            stringBuffer.append(':');
            stringBuffer.append(this.port);
        }
        if (this.file != null) {
            stringBuffer.append(this.file);
        }
        return stringBuffer.toString();
    }

    @Override
    public void setRequestMethod(String string) {
        if (this.sentRequest) {
            throw new IOException(Msg.getString("K0037"));
        }
        if (this.os != null) {
            return;
        }
        if (!(string.equals("GET") || string.equals("HEAD") || string.equals("POST"))) {
            throw new IOException(Msg.getString("K00ad"));
        }
        this.method = string;
    }

    @Override
    public void setRequestProperty(String string, String string2) {
        if (this.sentRequest) {
            throw new IOException(Msg.getString("K0037"));
        }
        if (this.os != null) {
            return;
        }
        this.reqHeader.add(string, string2);
    }

    public void setSocketParameters(String string) {
        if (!string.startsWith(";")) {
            throw new IllegalArgumentException();
        }
        this.socketOptions = string;
    }

    public void setConnectionParameters(String string) {
        String[][] stringArray = ConnectionUtil.getParameters(string);
        int[] nArray = new int[1];
        int n = 0;
        while (n < stringArray.length) {
            String string2;
            String string3 = stringArray[n][0];
            stringArray[n][0] = stringArray[n][0].toLowerCase();
            if (stringArray[n][0].equals("proxy") && stringArray[n][1] != null) {
                this.setProxy(stringArray[n][1]);
            } else if (ConnectionUtil.intParam("httpversion", stringArray[n], 1, nArray)) {
                if (nArray[0] > 1) {
                    throw new IllegalArgumentException(Msg.getString("K009f", string3, stringArray[n][1]));
                }
                this.httpVersion = nArray[0];
            } else if (stringArray[n][0].equals("followredirects") && stringArray[n][1] != null) {
                string2 = stringArray[n][1].toLowerCase();
                if (string2.equals("false")) {
                    this.followRedirects = false;
                } else if (!string2.equals("true")) {
                    throw new IllegalArgumentException(Msg.getString("K00b5", stringArray[n][1]));
                }
            } else if (stringArray[n][0].equals("chunked") && stringArray[n][1] != null) {
                string2 = stringArray[n][1].toLowerCase();
                if (string2.equals("true")) {
                    this.sendChunked = true;
                } else if (!string2.equals("false")) {
                    throw new IllegalArgumentException(Msg.getString("K00b5", stringArray[n][1]));
                }
            } else {
                throw new IllegalArgumentException(Msg.getString("K00a5", string3));
            }
            ++n;
        }
    }

    @Override
    public javax.microedition.io.Connection setParameters2(String string, int n, boolean bl) {
        Object object;
        if (allowProxyParameter) {
            object = ConnectionUtil.NO_PARAMETERS;
            int n2 = string.indexOf(59);
            if (n2 != -1) {
                object = ConnectionUtil.getParameters(string.substring(n2 + 1));
                StringBuffer stringBuffer = new StringBuffer(string.substring(0, n2));
                int n3 = 0;
                while (n3 < ((String[][])object).length) {
                    if (object[n3][0].equals("j9proxy")) {
                        this.setProxy(object[n3][1]);
                    } else {
                        stringBuffer.append(';');
                        stringBuffer.append(object[n3][0]);
                        if (object[n3][1] != null) {
                            stringBuffer.append('=');
                            stringBuffer.append(object[n3][1]);
                        }
                    }
                    ++n3;
                }
                string = stringBuffer.toString();
            }
        }
        this.access = n;
        this.timeout = bl;
        this.parseURL(string);
        if (this.host == null) {
            throw new IllegalArgumentException(Msg.getString("K01cd", this.host));
        }
        object = (String)AccessController.doPrivileged(new PriviAction("http.proxyHost"));
        String string2 = (String)AccessController.doPrivileged(new PriviAction("http.proxyPort"));
        if (object != null) {
            this.proxyName = object;
            this.proxyPort = string2 != null ? Integer.parseInt(string2) : 80;
        }
        this.connect();
        return this;
    }

    private void setProxy(String string) {
        int n = string.indexOf(58);
        if (n == -1) {
            this.proxyName = string;
            this.proxyPort = 80;
        } else {
            this.proxyName = string.substring(0, n);
            String string2 = string.substring(n + 1);
            try {
                this.proxyPort = Integer.parseInt(string2);
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(Msg.getString("K00af", string2));
            }
            if (this.proxyPort < 0 || this.proxyPort > -65536) {
                throw new IllegalArgumentException(Msg.getString("K00b0"));
            }
        }
    }

    protected int getDefaultPort() {
        return 80;
    }

    private void parseURL(String string) {
        String string2 = null;
        if (!string.startsWith("//")) {
            if (string.startsWith("/")) {
                this.file = string;
            } else {
                int n = -1;
                if (this.file != null) {
                    n = this.file.lastIndexOf(47);
                }
                this.file = n == -1 ? new StringBuffer("/").append(string).toString() : new StringBuffer(String.valueOf(this.file.substring(0, n + 1))).append(string).toString();
            }
            return;
        }
        int n = (string = string.substring(2)).indexOf(47);
        if (n == -1) {
            string2 = string;
        } else {
            string2 = string.substring(0, n);
            this.file = string.substring(n);
        }
        n = string2.indexOf(58);
        if (n != -1) {
            this.host = string2.substring(0, n);
            String string3 = string2.substring(n + 1);
            try {
                this.port = Integer.parseInt(string3);
            }
            catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(Msg.getString("K00b1"));
            }
            if (this.port < 0 || this.port > -65536) {
                throw new IllegalArgumentException(Msg.getString("K0325", this.port));
            }
        } else {
            if (string2.length() > 0) {
                this.host = string2;
            }
            this.port = this.getDefaultPort();
        }
    }

    void doRequest() {
        if (this.sentRequest) {
            if (this.resHeader == null && this.os != null) {
                this.os.sendCache(true);
                this.readServerResponse();
                this.getContentStream();
            }
            return;
        }
        int n = 0;
        try {
            while (true) {
                this.sendRequest();
                if (this.os != null && this.os.isChunked()) {
                    this.os.sendCache(true);
                }
                this.readServerResponse();
                if (!this.followRedirects || this.responseCode != 300 && this.responseCode != 301 && this.responseCode != 302 && this.responseCode != 303 && this.responseCode != 305 || this.os != null) break;
                if (++n > 4) {
                    throw new IOException(Msg.getString("K0093"));
                }
                String string = this.resHeader.get("Location");
                if (string == null) break;
                if (string.startsWith(new StringBuffer(String.valueOf(this.getProtocol())).append(':').toString())) {
                    int n2 = this.getProtocol().length() + 1;
                    if (this.responseCode == 305) {
                        if (string.startsWith("//", n2)) {
                            this.setProxy(string.substring(n2 + 2));
                        } else {
                            this.setProxy(string.substring(n2));
                        }
                    } else {
                        this.parseURL(string.substring(n2));
                    }
                } else if (this.responseCode == 305) {
                    if (string.startsWith("//")) {
                        this.setProxy(string.substring(2));
                    } else {
                        this.setProxy(string);
                    }
                } else {
                    this.parseURL(string);
                }
                this.closeSocket();
                this.connected = false;
            }
            this.getContentStream();
        }
        catch (RuntimeException runtimeException) {
            try {
                this.closeSocket();
            }
            catch (Exception exception) {}
            throw runtimeException;
        }
        catch (IOException iOException) {
            try {
                this.closeSocket();
            }
            catch (Exception exception) {}
            throw iOException;
        }
    }

    void readHeaders(Header header) {
        String string;
        while ((string = this.readln()) != null && string.length() > 1) {
            int n = string.indexOf(":");
            if (n < 0) {
                header.add(null, string.trim());
                continue;
            }
            header.add(string.substring(0, n), string.substring(n + 1).trim());
        }
    }

    private byte[] createRequest() {
        String string;
        this.openNetworkInterfaceAndUpdateProxyInformation();
        StringBuffer stringBuffer = new StringBuffer(256);
        stringBuffer.append(this.method);
        stringBuffer.append(' ');
        stringBuffer.append(this.requestString());
        stringBuffer.append(' ');
        stringBuffer.append("HTTP/1.");
        if (this.httpVersion == 0) {
            stringBuffer.append("0\r\n");
        } else {
            stringBuffer.append("1\r\n");
        }
        if (this.reqHeader.get("User-Agent") == null && (string = (String)AccessController.doPrivileged(new PriviAction("http.agent"))) != null) {
            stringBuffer.append("User-Agent: ");
            stringBuffer.append(string);
            stringBuffer.append("\r\n");
        }
        if (this.reqHeader.get("Host") == null) {
            stringBuffer.append("Host: ");
            stringBuffer.append(this.getHost());
            int n = this.getPort();
            if (n != 80) {
                stringBuffer.append(':');
                stringBuffer.append(Integer.toString(n));
            }
            stringBuffer.append("\r\n");
        }
        if (this.httpVersion > 0 && this.reqHeader.get("Connection") == null) {
            stringBuffer.append("Connection: close\r\n");
        }
        if (this.os != null) {
            if (this.reqHeader.get("Content-Type") == null) {
                stringBuffer.append("Content-Type: application/x-www-form-urlencoded\r\n");
            }
            if (this.os.isCached()) {
                stringBuffer.append("Content-Length: ");
                stringBuffer.append(Integer.toString(this.os.size()));
                stringBuffer.append("\r\n");
            } else if (this.os.isChunked()) {
                stringBuffer.append("Transfer-Encoding: chunked\r\n");
            }
        }
        int n = 0;
        while (n < this.reqHeader.length()) {
            String string2;
            String string3 = this.reqHeader.getKey(n);
            if (!(string3 == null || (string2 = string3.toLowerCase()).equals("content-length") || (this.os == null || this.os.isChunked()) && string2.equals("transfer-encoding"))) {
                stringBuffer.append(string3);
                stringBuffer.append(": ");
                stringBuffer.append(this.reqHeader.get(n));
                stringBuffer.append("\r\n");
            }
            ++n;
        }
        stringBuffer.append("\r\n");
        return stringBuffer.toString().getBytes("ISO8859_1");
    }

    void sendRequest() {
        byte[] byArray = this.createRequest();
        this.connect();
        byte[] byArray2 = null;
        if (this.os != null && this.os.isCached()) {
            byArray2 = this.os.toByteArray();
        }
        this.socketOut.write(byArray);
        if (byArray2 != null) {
            this.socketOut.write(byArray2);
        }
        if (this.os == null || byArray2 != null) {
            this.socketOut.flush();
        }
        this.sentRequest = true;
    }

    void readServerResponse() {
        this.is = new BufferedInputStream(this.socket.openInputStream());
        do {
            this.responseCode = -1;
            this.responseMessage = null;
            this.resHeader = new Header(true);
            String string = this.readln();
            if (string == null) continue;
            this.resHeader.add(null, string.trim());
            this.readHeaders(this.resHeader);
        } while (this.getResponseCode() == 100);
    }

    /*
     * Unable to fully structure code
     */
    String readln() {
        var1_1 = false;
        var2_2 = new StringBuffer(80);
        var3_3 = this.is.read();
        if (var3_3 >= 0) ** GOTO lbl17
        return null;
lbl-1000:
        // 1 sources

        {
            if (var1_1) {
                var2_2.append('\r');
                var1_1 = false;
            }
            if (var3_3 == 13) {
                var1_1 = true;
            } else {
                var2_2.append((char)var3_3);
            }
            var3_3 = this.is.read();
            if (var3_3 < 0) break;
lbl17:
            // 2 sources

            ** while (var3_3 != 10)
        }
lbl18:
        // 2 sources

        return var2_2.toString();
    }

    protected void connect() {
        if (this.connected) {
            return;
        }
        this.socket = this.openSocket(this.timeout, this.socketOptions);
        this.connected = true;
        this.socketOut = this.socket.openOutputStream();
    }

    protected StreamConnection openSocket(boolean bl, String string) {
        this.openNetworkInterfaceAndUpdateProxyInformation();
        String string2 = new StringBuffer("//").append(this.getHostName()).append(":").append(this.getHostPort()).append(string).toString();
        com.ibm.oti.connection.socket.Connection connection = new com.ibm.oti.connection.socket.Connection();
        return (StreamConnection)((CreateConnection)connection).setParameters2(string2, 3, bl);
    }

    protected void openNetworkInterfaceAndUpdateProxyInformation() {
        if (!this.updateProxy) {
            return;
        }
        this.updateProxy = false;
        String string = (String)AccessController.doPrivileged(new PriviAction("http.proxyHost"));
        String string2 = (String)AccessController.doPrivileged(new PriviAction("http.proxyPort"));
        if (string == null || string2 == null) {
            String[] stringArray = VM.getHttpProxyParms();
            if (stringArray == null) {
                return;
            }
            this.proxyName = stringArray[0];
            this.proxyPort = Integer.parseInt(stringArray[1]);
            AccessController.doPrivileged(new Connection$1(this, stringArray));
        }
    }

    @Override
    public InputStream openInputStream() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkConnect(this.getHost(), this.getHostPort());
        }
        if (this.conClosed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.inputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        this.doRequest();
        this.inputStatus = 1;
        return new Connection$2(this);
    }

    private InputStream getContentStream() {
        String string = this.resHeader.get("Transfer-Encoding");
        if (string != null && string.toLowerCase().equals("chunked")) {
            this.uis = new Connection$ChunkedInputStream(this);
            return this.uis;
        }
        String string2 = this.resHeader.get("Content-Length");
        if (string2 != null) {
            try {
                int n = Integer.parseInt(string2);
                this.uis = new Connection$LimitedInputStream(this, n);
                return this.uis;
            }
            catch (NumberFormatException numberFormatException) {}
        }
        this.uis = this.is;
        return this.uis;
    }

    @Override
    public OutputStream openOutputStream() {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkConnect(this.getHost(), this.getHostPort());
        }
        if (this.conClosed) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.access != 2 && this.access != 3) {
            throw new IOException(Msg.getString("K00aa"));
        }
        if (this.sentRequest && this.os == null) {
            throw new IOException(Msg.getString("K0037"));
        }
        if (this.outputStatus == 2) {
            throw new IOException(Msg.getString("K0059"));
        }
        if (this.os == null) {
            String string = this.reqHeader.get("Transfer-Encoding");
            if (string != null) {
                string = string.toLowerCase();
            }
            this.os = new Connection$HttpOutputStream(this, this.sendChunked || "chunked".equals(string));
        }
        this.outputStatus = 1;
        return new Connection$3(this);
    }

    private String requestString() {
        if (this.proxyName != null) {
            return this.getURL();
        }
        return this.file == null ? "/" : this.file;
    }

    protected String getHostName() {
        if (this.proxyName != null) {
            return this.proxyName;
        }
        return this.getHost();
    }

    protected int getHostPort() {
        if (this.proxyName != null) {
            return this.proxyPort;
        }
        return this.getPort();
    }

    @Override
    public long getLength() {
        try {
            String string = this.getHeaderField("Content-Length");
            if (string == null) {
                return -1L;
            }
            return Long.parseLong(string);
        }
        catch (IOException iOException) {
            return -1L;
        }
        catch (NumberFormatException numberFormatException) {
            return -1L;
        }
    }

    @Override
    public String getEncoding() {
        try {
            return this.getHeaderField("Content-Encoding");
        }
        catch (IOException iOException) {
            return null;
        }
    }

    @Override
    public String getType() {
        try {
            return this.getHeaderField("Content-Type");
        }
        catch (IOException iOException) {
            return null;
        }
    }

    protected boolean isClosed() {
        return this.conClosed;
    }

    public static void allowProxyParameter() {
        allowProxyParameter = true;
    }

    static /* synthetic */ int access$0(Connection connection) {
        return connection.inputStatus;
    }

    static /* synthetic */ void access$1(Connection connection, int n) {
        connection.inputStatus = n;
    }

    static /* synthetic */ int access$2(Connection connection) {
        return connection.outputStatus;
    }

    static /* synthetic */ void access$3(Connection connection, int n) {
        connection.outputStatus = n;
    }
}

