/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.net.www.MimeTable;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import com.ibm.oti.util.Util;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ContentHandler;
import java.net.ContentHandlerFactory;
import java.net.FileNameMap;
import java.net.URL;
import java.net.URLConnection$1;
import java.net.URLConnection$DefaultContentHandler;
import java.net.UnknownServiceException;
import java.security.AccessController;
import java.security.AllPermission;
import java.security.Permission;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.StringTokenizer;

public abstract class URLConnection {
    protected URL url;
    private String contentType;
    private static String defaultRequestProperty = "";
    private static boolean defaultAllowUserInteraction = false;
    private static boolean defaultUseCaches = true;
    ContentHandler defaultHandler = new URLConnection$DefaultContentHandler(this);
    private long lastModified = -1L;
    protected long ifModifiedSince;
    private String requestProperty = defaultRequestProperty;
    protected boolean useCaches = defaultUseCaches;
    protected boolean connected = false;
    protected boolean doOutput = false;
    protected boolean doInput = true;
    protected boolean allowUserInteraction = defaultAllowUserInteraction;
    private static ContentHandlerFactory contentHandlerFactory;
    static Hashtable contentHandlers;
    private static FileNameMap fileNameMap;

    static {
        contentHandlers = new Hashtable();
    }

    protected URLConnection(URL uRL) {
        this.url = uRL;
    }

    public abstract void connect() {
    }

    public boolean getAllowUserInteraction() {
        return this.allowUserInteraction;
    }

    public Object getContent() {
        if (!this.connected) {
            this.connect();
        }
        if ((this.contentType = this.getContentType()) == null && (this.contentType = URLConnection.guessContentTypeFromName(this.url.getFile())) == null) {
            this.contentType = URLConnection.guessContentTypeFromStream(this.getInputStream());
        }
        if (this.contentType != null) {
            return this.getContentHandler(this.contentType).getContent(this);
        }
        return null;
    }

    public Object getContent(Class[] classArray) {
        if (!this.connected) {
            this.connect();
        }
        if ((this.contentType = this.getContentType()) == null && (this.contentType = URLConnection.guessContentTypeFromName(this.url.getFile())) == null) {
            this.contentType = URLConnection.guessContentTypeFromStream(this.getInputStream());
        }
        if (this.contentType != null) {
            return this.getContentHandler(this.contentType).getContent(this, classArray);
        }
        return null;
    }

    public String getContentEncoding() {
        return this.getHeaderField("Content-Encoding");
    }

    private ContentHandler getContentHandler(String string) {
        String string2 = this.parseTypeString(string.replace('/', '.'));
        Object object = contentHandlers.get(string);
        if (object != null) {
            return (ContentHandler)object;
        }
        if (contentHandlerFactory != null) {
            object = contentHandlerFactory.createContentHandler(string);
            if (!(object instanceof ContentHandler)) {
                throw new UnknownServiceException();
            }
            contentHandlers.put(string, object);
            return (ContentHandler)object;
        }
        String string3 = (String)AccessController.doPrivileged(new PriviAction("java.content.handler.pkgs"));
        if (string3 != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(string3, "|");
            while (stringTokenizer.countTokens() > 0) {
                try {
                    Class clazz = Class.forName(new StringBuffer(String.valueOf(stringTokenizer.nextToken())).append(".").append(string2).toString(), true, ClassLoader.getSystemClassLoader());
                    object = (ContentHandler)clazz.newInstance();
                }
                catch (Exception exception) {}
            }
        }
        if (object == null) {
            object = AccessController.doPrivileged(new URLConnection$1(this, string2));
        }
        if (object != null) {
            if (!(object instanceof ContentHandler)) {
                throw new UnknownServiceException();
            }
            contentHandlers.put(string, object);
            return (ContentHandler)object;
        }
        return this.defaultHandler;
    }

    public int getContentLength() {
        return this.getHeaderFieldInt("Content-Length", -1);
    }

    public String getContentType() {
        return this.getHeaderField("Content-Type");
    }

    public long getDate() {
        return this.getHeaderFieldDate("Date", 0L);
    }

    public static boolean getDefaultAllowUserInteraction() {
        return defaultAllowUserInteraction;
    }

    public boolean getDefaultUseCaches() {
        return defaultUseCaches;
    }

    public boolean getDoInput() {
        return this.doInput;
    }

    public boolean getDoOutput() {
        return this.doOutput;
    }

    public long getExpiration() {
        return this.getHeaderFieldDate("Expires", 0L);
    }

    public static FileNameMap getFileNameMap() {
        if (fileNameMap == null) {
            fileNameMap = new MimeTable();
        }
        return fileNameMap;
    }

    public String getHeaderField(int n) {
        return null;
    }

    public Map getHeaderFields() {
        return Collections.EMPTY_MAP;
    }

    public Map getRequestProperties() {
        return Collections.EMPTY_MAP;
    }

    public void addRequestProperty(String string, String string2) {
    }

    public String getHeaderField(String string) {
        return null;
    }

    public long getHeaderFieldDate(String string, long l) {
        String string2 = this.getHeaderField(string);
        if (string2 == null) {
            return l;
        }
        return Util.parseDate(string2);
    }

    public int getHeaderFieldInt(String string, int n) {
        try {
            return Integer.parseInt(this.getHeaderField(string));
        }
        catch (NumberFormatException numberFormatException) {
            return n;
        }
    }

    public String getHeaderFieldKey(int n) {
        return null;
    }

    public long getIfModifiedSince() {
        return this.ifModifiedSince;
    }

    public InputStream getInputStream() {
        throw new UnknownServiceException(Msg.getString("K004d"));
    }

    public long getLastModified() {
        if (this.lastModified != -1L) {
            return this.lastModified;
        }
        this.lastModified = this.getHeaderFieldDate("Last-Modified", 0L);
        return this.lastModified;
    }

    public OutputStream getOutputStream() {
        throw new UnknownServiceException(Msg.getString("K005f"));
    }

    public Permission getPermission() {
        return new AllPermission();
    }

    public String getRequestProperty(String string) {
        return null;
    }

    public URL getURL() {
        return this.url;
    }

    public boolean getUseCaches() {
        return this.useCaches;
    }

    public static String guessContentTypeFromName(String string) {
        return URLConnection.getFileNameMap().getContentTypeFor(string);
    }

    public static String guessContentTypeFromStream(InputStream inputStream) {
        if (!inputStream.markSupported()) {
            return null;
        }
        inputStream.mark(4);
        char[] cArray = new char[4];
        int n = 0;
        while (n < cArray.length) {
            cArray[n] = (char)inputStream.read();
            ++n;
        }
        inputStream.reset();
        if (cArray[0] == 'P' && cArray[1] == 'K') {
            return "application/zip";
        }
        if (cArray[0] == 'G' && cArray[1] == 'I') {
            return "image/gif";
        }
        if (new String(cArray).trim().startsWith("<")) {
            return "text/html";
        }
        return null;
    }

    private String parseTypeString(String string) {
        StringBuffer stringBuffer = new StringBuffer(string);
        int n = 0;
        while (n < stringBuffer.length()) {
            char c2 = stringBuffer.charAt(n);
            if (!Character.isLetter(c2) && !Character.isDigit(c2) && c2 != '.') {
                stringBuffer.setCharAt(n, '_');
            }
            ++n;
        }
        return stringBuffer.toString();
    }

    public void setAllowUserInteraction(boolean bl) {
        if (this.connected) {
            throw new IllegalStateException(Msg.getString("K0037"));
        }
        this.allowUserInteraction = bl;
    }

    public static synchronized void setContentHandlerFactory(ContentHandlerFactory contentHandlerFactory) {
        if (URLConnection.contentHandlerFactory != null) {
            throw new Error(Msg.getString("K004e"));
        }
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSetFactory();
        }
        URLConnection.contentHandlerFactory = contentHandlerFactory;
    }

    public static void setDefaultAllowUserInteraction(boolean bl) {
        defaultAllowUserInteraction = bl;
    }

    public void setDefaultUseCaches(boolean bl) {
        if (this.connected) {
            throw new IllegalAccessError(Msg.getString("K0037"));
        }
        defaultUseCaches = bl;
    }

    public void setDoInput(boolean bl) {
        if (this.connected) {
            throw new IllegalAccessError(Msg.getString("K0037"));
        }
        this.doInput = bl;
    }

    public void setDoOutput(boolean bl) {
        if (this.connected) {
            throw new IllegalAccessError(Msg.getString("K0037"));
        }
        this.doOutput = bl;
    }

    public static void setFileNameMap(FileNameMap fileNameMap) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSetFactory();
        }
        URLConnection.fileNameMap = fileNameMap;
    }

    public void setIfModifiedSince(long l) {
        if (this.connected) {
            throw new IllegalAccessError(Msg.getString("K0037"));
        }
        this.ifModifiedSince = l;
    }

    public void setRequestProperty(String string, String string2) {
    }

    public void setUseCaches(boolean bl) {
        if (this.connected) {
            throw new IllegalStateException(Msg.getString("K0037"));
        }
        this.useCaches = bl;
    }

    public String toString() {
        return new StringBuffer(String.valueOf(super.getClass().getName())).append(":").append(this.url.toString()).toString();
    }
}

