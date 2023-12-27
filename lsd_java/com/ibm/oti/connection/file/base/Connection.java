/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.connection.file.base;

import com.ibm.oti.connection.ConnectionUtil;
import com.ibm.oti.connection.CreateConnection;
import com.ibm.oti.connection.DataConnection;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.StreamConnection;

public class Connection
extends DataConnection
implements CreateConnection,
StreamConnection {
    private File file;
    private int access;
    private boolean append = false;

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

    private void setParameters(String string, String[][] stringArray, int n, boolean bl) {
        int n2;
        int n3 = 0;
        if ((string = Util.decode(string, false)).startsWith("//")) {
            boolean bl2 = false;
            n2 = string.length();
            n3 = 2;
            while (n3 < n2) {
                char c2 = string.charAt(n3);
                if (c2 == '/' || c2 == '\\') {
                    bl2 = true;
                    break;
                }
                if (c2 == ':' || c2 == ' ') break;
                ++n3;
            }
            if (!bl2) {
                throw new IllegalArgumentException(string);
            }
        }
        String string2 = n3 == 2 ? string.substring(2) : string;
        this.file = new File(string2);
        this.access = n;
        n2 = 0;
        while (n2 < stringArray.length) {
            String string3 = stringArray[n2][0].toLowerCase();
            if (string3.equals("append") && stringArray[n2][1] != null) {
                String string4 = stringArray[n2][1].toLowerCase();
                if (string4.equals("true")) {
                    this.append = true;
                } else if (!string4.equals("false")) {
                    throw new IllegalArgumentException(Msg.getString("K00b5"));
                }
            } else {
                throw new IllegalArgumentException(Msg.getString("K00a5", stringArray[n2][0]));
            }
            ++n2;
        }
        if (n == 1 && !this.file.exists()) {
            throw new ConnectionNotFoundException(string2);
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            if (n == 3) {
                securityManager.checkRead(this.file.getPath());
            }
            if (n == 2 || n == 3) {
                securityManager.checkWrite(this.file.getPath());
            }
        }
    }

    @Override
    public void close() {
        this.file = null;
    }

    @Override
    public InputStream openInputStream() {
        if (this.file == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.access != 1 && this.access != 3) {
            throw new IOException(Msg.getString("K00a9"));
        }
        return new FileInputStream(this.file);
    }

    @Override
    public OutputStream openOutputStream() {
        if (this.file == null) {
            throw new IOException(Msg.getString("K00ac"));
        }
        if (this.access != 2 && this.access != 3) {
            throw new IOException(Msg.getString("K00aa"));
        }
        return new FileOutputStream(this.file, this.append);
    }
}

