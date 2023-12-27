/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.ftp;

import com.ibm.oti.net.www.protocol.ftp.FtpURLInputStream;
import com.ibm.oti.util.Msg;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketPermission;
import java.net.URL;
import java.net.URLConnection;
import java.security.Permission;

public class FtpURLConnection
extends URLConnection {
    Socket controlSocket;
    Socket dataSocket;
    ServerSocket acceptSocket;
    InputStream ctrlInput;
    InputStream inputStream;
    OutputStream ctrlOutput;
    private String replyCode;
    private String hostName;
    int dataPort;
    private static final int FTP_PORT;
    private String PASSWORD = "";
    private String USERNAME = "anonymous";
    private static final int FTP_DATAOPEN;
    private static final int FTP_OPENDATA;
    private static final int FTP_OK;
    private static final int FTP_USERREADY;
    private static final int FTP_TRANSFEROK;
    private static final int FTP_PASV;
    private static final int FTP_LOGGEDIN;
    private static final int FTP_FILEOK;
    private static final int FTP_PASWD;
    private static final int FTP_DATAERROR;
    private static final int FTP_ERROR;
    private static final int FTP_NOTFOUND;

    protected FtpURLConnection(URL uRL) {
        super(uRL);
        this.hostName = uRL.getHost();
        String string = uRL.getUserInfo();
        if (string != null) {
            int n = string.indexOf(58);
            if (n >= 0) {
                this.USERNAME = string.substring(0, n);
                this.PASSWORD = string.substring(n + 1);
            } else {
                this.USERNAME = string;
            }
        }
    }

    private void cd() {
        int n = this.url.getFile().lastIndexOf(47);
        if (n > 0) {
            String string = this.url.getFile().substring(0, n);
            this.write(new StringBuffer("CWD ").append(string).append("\r\n").toString());
            int n2 = this.getReply();
            if (n2 != 250 && string.length() > 0 && string.charAt(0) == '/') {
                this.write(new StringBuffer("CWD ").append(string.substring(1)).append("\r\n").toString());
                n2 = this.getReply();
            }
            if (n2 != 250) {
                throw new IOException(Msg.getString("K0094"));
            }
        }
    }

    @Override
    public void connect() {
        int n = this.url.getPort();
        if (n <= 0) {
            n = 21;
        }
        this.controlSocket = new Socket(this.hostName, n);
        this.connected = true;
        this.ctrlOutput = this.controlSocket.getOutputStream();
        this.ctrlInput = this.controlSocket.getInputStream();
        this.login();
        this.setType();
        if (!this.getDoInput()) {
            this.cd();
        }
        try {
            this.acceptSocket = new ServerSocket(0);
            this.dataPort = this.acceptSocket.getLocalPort();
            this.port();
            this.acceptSocket.setSoTimeout(3000);
            if (this.getDoInput()) {
                this.getFile();
            } else {
                this.sendFile();
            }
            this.dataSocket = this.acceptSocket.accept();
            this.acceptSocket.close();
        }
        catch (InterruptedIOException interruptedIOException) {
            throw new IOException(Msg.getString("K0095"));
        }
        if (this.getDoInput()) {
            this.inputStream = new FtpURLInputStream(new BufferedInputStream(this.dataSocket.getInputStream()), this.controlSocket);
        }
    }

    @Override
    public String getContentType() {
        String string = FtpURLConnection.guessContentTypeFromName(this.url.getFile());
        if (string == null) {
            return "content/unknown";
        }
        return string;
    }

    private void getFile() {
        String string = this.url.getFile();
        this.write(new StringBuffer("RETR ").append(string).append("\r\n").toString());
        int n = this.getReply();
        if (n == 550 && string.length() > 0 && string.charAt(0) == '/') {
            this.write(new StringBuffer("RETR ").append(string.substring(1)).append("\r\n").toString());
            n = this.getReply();
        }
        if (n != 150 && n != 226) {
            throw new FileNotFoundException(Msg.getString("K0096", n));
        }
    }

    @Override
    public InputStream getInputStream() {
        if (!this.connected) {
            this.connect();
        }
        return this.inputStream;
    }

    @Override
    public Permission getPermission() {
        int n = this.url.getPort();
        if (n <= 0) {
            n = 21;
        }
        return new SocketPermission(new StringBuffer(String.valueOf(this.hostName)).append(":").append(n).toString(), "connect, resolve");
    }

    @Override
    public OutputStream getOutputStream() {
        if (!this.connected) {
            this.connect();
        }
        return this.dataSocket.getOutputStream();
    }

    private int getReply() {
        byte[] byArray = new byte[3];
        this.ctrlInput.read(byArray, 0, byArray.length);
        this.replyCode = new String(byArray, "ISO8859_1");
        boolean bl = false;
        if (this.ctrlInput.read() == 45) {
            bl = true;
        }
        this.readLine();
        if (bl) {
            while (this.readMultiLine()) {
            }
        }
        return Integer.parseInt(new String(byArray, "ISO8859_1"));
    }

    private void login() {
        int n = this.getReply();
        if (n != 220) {
            throw new IOException(Msg.getString("K0097", this.url.getHost()));
        }
        this.write(new StringBuffer("USER ").append(this.USERNAME).append("\r\n").toString());
        n = this.getReply();
        if (n != 331 && n != 230) {
            throw new IOException(Msg.getString("K0098", this.url.getHost()));
        }
        if (n == 331) {
            this.write(new StringBuffer("PASS ").append(this.PASSWORD).append("\r\n").toString());
            n = this.getReply();
            if (n != 200 && n != 220 && n != 230) {
                throw new IOException(Msg.getString("K0098", this.url.getHost()));
            }
        }
    }

    private void port() {
        this.write(new StringBuffer("PORT ").append(this.controlSocket.getLocalAddress().getHostAddress().replace('.', ',')).append(',').append(this.dataPort >> 8).append(',').append(this.dataPort & 0xFF).append("\r\n").toString());
        if (this.getReply() != 200) {
            throw new IOException(Msg.getString("K0099"));
        }
    }

    private String readLine() {
        int n;
        StringBuffer stringBuffer = new StringBuffer();
        while ((n = this.ctrlInput.read()) != 10) {
            stringBuffer.append((char)n);
        }
        return stringBuffer.toString();
    }

    private boolean readMultiLine() {
        String string = this.readLine();
        if (string.length() < 4) {
            return true;
        }
        return !string.substring(0, 3).equals(this.replyCode) || string.charAt(3) != ' ';
    }

    private void sendFile() {
        this.write(new StringBuffer("STOR ").append(this.url.getFile().substring(this.url.getFile().lastIndexOf(47) + 1, this.url.getFile().length())).append("\r\n").toString());
        int n = this.getReply();
        if (n != 150 && n != 200 && n != 125) {
            throw new IOException(Msg.getString("K009a"));
        }
    }

    @Override
    public void setDoInput(boolean bl) {
        if (this.connected) {
            throw new IllegalAccessError();
        }
        this.doInput = bl;
        this.doOutput = !bl;
    }

    @Override
    public void setDoOutput(boolean bl) {
        if (this.connected) {
            throw new IllegalAccessError();
        }
        this.doOutput = bl;
        this.doInput = !bl;
    }

    private void setType() {
        this.write("TYPE I\r\n");
        if (this.getReply() != 200) {
            throw new IOException(Msg.getString("K009b"));
        }
    }

    private void write(String string) {
        this.ctrlOutput.write(string.getBytes("ISO8859_1"));
    }
}

