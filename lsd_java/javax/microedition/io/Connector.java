/*
 * Decompiled with CFR 0.152.
 */
package javax.microedition.io;

import com.ibm.oti.connection.CreateConnection;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.AccessController;
import javax.microedition.io.Connection;
import javax.microedition.io.ConnectionNotFoundException;
import javax.microedition.io.InputConnection;
import javax.microedition.io.OutputConnection;

public class Connector {
    public static final int READ;
    public static final int WRITE;
    public static final int READ_WRITE;

    private Connector() {
    }

    public static Connection open(String string) {
        String string2 = Connector.getScheme(string);
        Class clazz = Connector.findConnectionClass(string2.toLowerCase());
        return Connector.open(string, 3, false, string2, clazz);
    }

    public static Connection open(String string, int n) {
        String string2 = Connector.getScheme(string);
        Class clazz = Connector.findConnectionClass(string2.toLowerCase());
        return Connector.open(string, n, false, string2, clazz);
    }

    public static Connection open(String string, int n, boolean bl) {
        String string2 = Connector.getScheme(string);
        Class clazz = Connector.findConnectionClass(string2.toLowerCase());
        return Connector.open(string, n, bl, string2, clazz);
    }

    public static DataInputStream openDataInputStream(String string) {
        String string2 = Connector.getScheme(string);
        Class clazz = Connector.findConnectionClass(string2.toLowerCase());
        return new DataInputStream(Connector.openInputStream(string, string2, clazz));
    }

    public static DataOutputStream openDataOutputStream(String string) {
        String string2 = Connector.getScheme(string);
        Class clazz = Connector.findConnectionClass(string2.toLowerCase());
        return new DataOutputStream(Connector.openOutputStream(string, string2, clazz));
    }

    public static InputStream openInputStream(String string) {
        String string2 = Connector.getScheme(string);
        Class clazz = Connector.findConnectionClass(string2.toLowerCase());
        return Connector.openInputStream(string, string2, clazz);
    }

    private static InputStream openInputStream(String string, String string2, Class clazz) {
        Connection connection = Connector.open(string, 1, false, string2, clazz);
        try {
            if (!(connection instanceof InputConnection)) {
                throw new IllegalArgumentException(Msg.getString("K0004"));
            }
            InputStream inputStream = ((InputConnection)connection).openInputStream();
            return inputStream;
        }
        finally {
            connection.close();
        }
    }

    public static OutputStream openOutputStream(String string) {
        String string2 = Connector.getScheme(string);
        Class clazz = Connector.findConnectionClass(string2.toLowerCase());
        return Connector.openOutputStream(string, string2, clazz);
    }

    private static OutputStream openOutputStream(String string, String string2, Class clazz) {
        Connection connection = Connector.open(string, 2, false, string2, clazz);
        try {
            if (!(connection instanceof OutputConnection)) {
                throw new IllegalArgumentException(Msg.getString("K0005"));
            }
            OutputStream outputStream = ((OutputConnection)connection).openOutputStream();
            return outputStream;
        }
        finally {
            connection.close();
        }
    }

    private static Connection open(String string, int n, boolean bl, String string2, Class clazz) {
        if (n != 1 && n != 2 && n != 3) {
            throw new IllegalArgumentException(Msg.getString("K0198"));
        }
        CreateConnection createConnection = null;
        try {
            createConnection = (CreateConnection)clazz.newInstance();
        }
        catch (InstantiationException instantiationException) {
            throw new ConnectionNotFoundException(Msg.getString("K0003", clazz));
        }
        catch (IllegalAccessException illegalAccessException) {
            throw new ConnectionNotFoundException(Msg.getString("K0003", clazz));
        }
        string = string.substring(string2.length() + 1);
        return createConnection.setParameters2(string, n, bl);
    }

    private static String getScheme(String string) {
        if (string == null) {
            throw new IllegalArgumentException(Msg.getString("K0067"));
        }
        int n = string.indexOf(58);
        if (n == -1) {
            throw new IllegalArgumentException(Msg.getString("K0001", string));
        }
        String string2 = string.substring(0, n);
        if (string2.length() == 0) {
            throw new IllegalArgumentException(Msg.getString("K0001", string));
        }
        return string2;
    }

    private static Class findConnectionClass(String string) {
        String string2 = (String)AccessController.doPrivileged(new PriviAction("microedition.connection.pkgs"));
        if (string2 != null) {
            int n = 0;
            int n2 = string2.indexOf(124);
            int n3 = string2.length();
            while (n < n3) {
                if (n2 == -1) {
                    n2 = n3;
                }
                String string3 = new StringBuffer(String.valueOf(string2.substring(n, n2))).append(".").append(string).append(".Connection").toString();
                try {
                    return Class.forName(string3, true, ClassLoader.getSystemClassLoader());
                }
                catch (Exception exception) {
                    n = n2 + 1;
                    n2 = string2.indexOf(124, n);
                }
            }
        }
        try {
            String string4 = new StringBuffer("com.ibm.oti.connection.").append(string).append(".Connection").toString();
            return Class.forName(string4);
        }
        catch (ClassNotFoundException classNotFoundException) {
            if (string.equals("file")) {
                try {
                    String string5 = "com.ibm.oti.connection.file.base.Connection";
                    return Class.forName(string5);
                }
                catch (ClassNotFoundException classNotFoundException2) {}
            }
            throw new ConnectionNotFoundException(Msg.getString("K0002", string));
        }
    }
}

