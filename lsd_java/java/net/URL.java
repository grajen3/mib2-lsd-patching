/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.NetPermission;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.security.AccessController;
import java.util.Hashtable;
import java.util.StringTokenizer;

public final class URL
implements Serializable {
    private static final long serialVersionUID;
    private static final NetPermission specifyStreamHandlerPermission;
    private int hashCode;
    private String file;
    private String protocol = null;
    private String host;
    private int port = -1;
    private String authority = null;
    private transient String userInfo = null;
    private transient String path = null;
    private transient String query = null;
    private String ref = null;
    private static Hashtable streamHandlers;
    transient URLStreamHandler strmHandler;
    private static URLStreamHandlerFactory streamHandlerFactory;

    static {
        specifyStreamHandlerPermission = new NetPermission("specifyStreamHandler");
        streamHandlers = new Hashtable();
    }

    public static synchronized void setURLStreamHandlerFactory(URLStreamHandlerFactory uRLStreamHandlerFactory) {
        if (streamHandlerFactory != null) {
            throw new Error(Msg.getString("K004b"));
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSetFactory();
        }
        streamHandlers.clear();
        streamHandlerFactory = uRLStreamHandlerFactory;
    }

    public URL(String string) {
        this((URL)null, string, (URLStreamHandler)null);
    }

    public URL(URL uRL, String string) {
        this(uRL, string, null);
    }

    public URL(URL uRL, String string, URLStreamHandler uRLStreamHandler) {
        int n;
        if (uRLStreamHandler != null) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(specifyStreamHandlerPermission);
            }
            this.strmHandler = uRLStreamHandler;
        }
        if (string == null) {
            throw new MalformedURLException();
        }
        string = string.trim();
        try {
            n = string.indexOf(58);
        }
        catch (NullPointerException nullPointerException) {
            throw new MalformedURLException(nullPointerException.toString());
        }
        int n2 = string.indexOf(91);
        if (n >= 0 && (n2 == -1 || n < n2)) {
            this.protocol = string.substring(0, n);
            if (this.protocol.indexOf(47) >= 0) {
                this.protocol = null;
                n = -1;
            } else {
                this.protocol = this.protocol.toLowerCase();
            }
        }
        if (this.protocol != null) {
            if (uRL != null && this.protocol.equals(uRL.getProtocol())) {
                String string2 = uRL.getPath();
                if (string2 != null && string2.startsWith("/")) {
                    this.set(this.protocol, uRL.getHost(), uRL.getPort(), uRL.getAuthority(), uRL.getUserInfo(), string2, uRL.getQuery(), null);
                }
                if (this.strmHandler == null) {
                    this.strmHandler = uRL.strmHandler;
                }
            }
        } else {
            if (uRL == null) {
                throw new MalformedURLException(Msg.getString("K00b3", string));
            }
            this.set(uRL.getProtocol(), uRL.getHost(), uRL.getPort(), uRL.getAuthority(), uRL.getUserInfo(), uRL.getPath(), uRL.getQuery(), null);
            if (this.strmHandler == null) {
                this.strmHandler = uRL.strmHandler;
            }
        }
        if (this.strmHandler == null) {
            this.setupStreamHandler();
            if (this.strmHandler == null) {
                throw new MalformedURLException(Msg.getString("K00b3", this.protocol));
            }
        }
        try {
            this.strmHandler.parseURL(this, string, ++n, string.length());
        }
        catch (Exception exception) {
            throw new MalformedURLException(exception.toString());
        }
        if (this.port < -1) {
            throw new MalformedURLException(Msg.getString("K0325", this.port));
        }
    }

    public URL(String string, String string2, String string3) {
        this(string, string2, -1, string3, null);
    }

    public URL(String string, String string2, int n, String string3) {
        this(string, string2, n, string3, null);
    }

    public URL(String string, String string2, int n, String string3, URLStreamHandler uRLStreamHandler) {
        if (n < -1) {
            throw new MalformedURLException(Msg.getString("K0325", n));
        }
        if (string2 != null && string2.indexOf(":") != -1 && string2.charAt(0) != '[') {
            string2 = new StringBuffer("[").append(string2).append("]").toString();
        }
        this.protocol = string;
        this.host = string2;
        this.port = n;
        int n2 = -1;
        n2 = string3.indexOf("#", string3.lastIndexOf("/"));
        if (n2 >= 0) {
            this.file = string3.substring(0, n2);
            this.ref = string3.substring(n2 + 1);
        } else {
            this.file = string3;
        }
        this.fixURL(false);
        if (uRLStreamHandler == null) {
            this.setupStreamHandler();
            if (this.strmHandler == null) {
                throw new MalformedURLException(Msg.getString("K00b3", string));
            }
        } else {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(specifyStreamHandlerPermission);
            }
            this.strmHandler = uRLStreamHandler;
        }
    }

    void fixURL(boolean bl) {
        int n;
        if (this.host != null && this.host.length() > 0) {
            this.authority = this.host;
            if (this.port != -1) {
                this.authority = new StringBuffer(String.valueOf(this.authority)).append(":").append(this.port).toString();
            }
        }
        if (bl) {
            if (this.host != null && (n = this.host.lastIndexOf(64)) > -1) {
                this.userInfo = this.host.substring(0, n);
                this.host = this.host.substring(n + 1);
            } else {
                this.userInfo = null;
            }
        }
        if (this.file != null && (n = this.file.indexOf(63)) > -1) {
            this.query = this.file.substring(n + 1);
            this.path = this.file.substring(0, n);
        } else {
            this.query = null;
            this.path = this.file;
        }
    }

    protected void set(String string, String string2, int n, String string3, String string4) {
        if (this.protocol == null) {
            this.protocol = string;
        }
        this.host = string2;
        this.file = string3;
        this.port = n;
        this.ref = string4;
        this.hashCode = 0;
        this.fixURL(true);
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        if (this == object) {
            return true;
        }
        if (super.getClass() != object.getClass()) {
            return false;
        }
        return this.strmHandler.equals(this, (URL)object);
    }

    public boolean sameFile(URL uRL) {
        return this.strmHandler.sameFile(this, uRL);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.strmHandler.hashCode(this);
        }
        return this.hashCode;
    }

    void setupStreamHandler() {
        Object object;
        String string;
        this.strmHandler = (URLStreamHandler)streamHandlers.get(this.protocol);
        if (this.strmHandler != null) {
            return;
        }
        if (streamHandlerFactory != null) {
            this.strmHandler = streamHandlerFactory.createURLStreamHandler(this.protocol);
            if (this.strmHandler != null) {
                streamHandlers.put(this.protocol, this.strmHandler);
                return;
            }
        }
        if ((string = (String)AccessController.doPrivileged(new PriviAction("java.protocol.handler.pkgs"))) != null) {
            object = new StringTokenizer(string, "|");
            while (((StringTokenizer)object).hasMoreTokens()) {
                String string2 = new StringBuffer(String.valueOf(((StringTokenizer)object).nextToken())).append(".").append(this.protocol).append(".Handler").toString();
                try {
                    this.strmHandler = (URLStreamHandler)Class.forName(string2, true, ClassLoader.getSystemClassLoader()).newInstance();
                    streamHandlers.put(this.protocol, this.strmHandler);
                    return;
                }
                catch (Exception exception) {}
            }
        }
        try {
            object = new StringBuffer("com.ibm.oti.net.www.protocol.").append(this.protocol).append(".Handler").toString();
            this.strmHandler = (URLStreamHandler)Class.forName((String)object).newInstance();
            streamHandlers.put(this.protocol, this.strmHandler);
        }
        catch (Exception exception) {}
    }

    public final Object getContent() {
        return this.openConnection().getContent();
    }

    public final Object getContent(Class[] classArray) {
        return this.openConnection().getContent(classArray);
    }

    public final InputStream openStream() {
        return this.openConnection().getInputStream();
    }

    public URLConnection openConnection() {
        return this.strmHandler.openConnection(this);
    }

    public String toString() {
        return this.toExternalForm();
    }

    public String toExternalForm() {
        if (this.strmHandler == null) {
            return new StringBuffer("unknown protocol(").append(this.protocol).append(")://").append(this.host).append(this.file).toString();
        }
        return this.strmHandler.toExternalForm(this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        try {
            objectInputStream.defaultReadObject();
            if (this.host != null && this.authority == null) {
                this.fixURL(true);
            } else if (this.authority != null) {
                int n = this.authority.lastIndexOf(64);
                if (n > -1) {
                    this.userInfo = this.authority.substring(0, n);
                }
                if (this.file != null && (n = this.file.indexOf(63)) > -1) {
                    this.query = this.file.substring(n + 1);
                    this.path = this.file.substring(0, n);
                } else {
                    this.path = this.file;
                }
            }
            this.setupStreamHandler();
            if (this.strmHandler == null) {
                throw new IOException(Msg.getString("K00b3", this.protocol));
            }
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new IOException(classNotFoundException.toString());
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    public String getFile() {
        return this.file;
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getProtocol() {
        return this.protocol;
    }

    public String getRef() {
        return this.ref;
    }

    public String getQuery() {
        return this.query;
    }

    public String getPath() {
        return this.path;
    }

    public String getUserInfo() {
        return this.userInfo;
    }

    public String getAuthority() {
        return this.authority;
    }

    protected void set(String string, String string2, int n, String string3, String string4, String string5, String string6, String string7) {
        String string8 = string5;
        if (string6 != null && !string6.equals("")) {
            string8 = string8 != null ? new StringBuffer(String.valueOf(string8)).append("?").append(string6).toString() : new StringBuffer("?").append(string6).toString();
        }
        this.set(string, string2, n, string8, string7);
        this.authority = string3;
        this.userInfo = string4;
        this.path = string5;
        this.query = string6;
    }

    URLStreamHandler getStreamHandler() {
        return this.strmHandler;
    }

    public int getDefaultPort() {
        return this.strmHandler.getDefaultPort();
    }
}

