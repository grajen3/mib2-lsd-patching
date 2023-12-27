/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.net.www.protocol.jar;

import com.ibm.oti.net.www.protocol.jar.JarURLConnection$1;
import com.ibm.oti.net.www.protocol.jar.JarURLConnection$2;
import com.ibm.oti.net.www.protocol.jar.JarURLConnection$3;
import com.ibm.oti.net.www.protocol.jar.JarURLConnection$CacheEntry;
import com.ibm.oti.net.www.protocol.jar.JarURLConnection$LRUComparitor;
import com.ibm.oti.net.www.protocol.jar.JarURLConnection$LRUKey;
import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.VM;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.ReferenceQueue;
import java.net.URL;
import java.security.AccessController;
import java.security.Permission;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

public class JarURLConnection
extends java.net.JarURLConnection {
    static Hashtable jarCache = new Hashtable();
    private static final String encoding;
    InputStream jarInput;
    private JarFile jarFile;
    private JarEntry jarEntry;
    ReferenceQueue cacheQueue = new ReferenceQueue();
    static TreeSet lru;
    static int Limit;

    static {
        lru = new TreeSet(new JarURLConnection$LRUComparitor());
        Limit = (Integer)AccessController.doPrivileged(new JarURLConnection$1());
        VM.closeJars();
    }

    public JarURLConnection(URL uRL) {
        super(uRL);
    }

    @Override
    public void connect() {
        this.jarFileURLConnection = this.getJarFileURL().openConnection();
        this.findJarFile();
        this.findJarEntry();
        this.connected = true;
    }

    @Override
    public JarFile getJarFile() {
        if (!this.connected) {
            this.connect();
        }
        return this.jarFile;
    }

    private void findJarFile() {
        URL uRL = this.getJarFileURL();
        if (uRL.getProtocol().equals("file")) {
            String string = uRL.getFile();
            String string2 = uRL.getHost();
            if (string2 != null && string2.length() > 0) {
                string = new StringBuffer("//").append(string2).append(string).toString();
            }
            string = Util.decode(string, false, "UTF8");
            this.jarFile = this.getUseCaches() ? this.openJarFile(string, string, false) : new JarFile(string);
            return;
        }
        String string = this.jarFileURLConnection.getURL().toExternalForm();
        if (this.getUseCaches()) {
            this.jarFile = (JarFile)AccessController.doPrivileged(new JarURLConnection$2(this, string));
            if (this.jarFile != null) {
                return;
            }
        }
        InputStream inputStream = this.jarFileURLConnection.getInputStream();
        try {
            this.jarFile = (JarFile)AccessController.doPrivileged(new JarURLConnection$3(this, inputStream, string));
        }
        finally {
            inputStream.close();
        }
        if (this.jarFile == null) {
            throw new IOException();
        }
    }

    JarFile openJarFile(String string, String string2, boolean bl) {
        JarURLConnection$CacheEntry jarURLConnection$CacheEntry;
        while ((jarURLConnection$CacheEntry = (JarURLConnection$CacheEntry)this.cacheQueue.poll()) != null) {
            jarCache.remove(jarURLConnection$CacheEntry.key);
        }
        jarURLConnection$CacheEntry = (JarURLConnection$CacheEntry)jarCache.get(string2);
        JarFile jarFile = null;
        if (jarURLConnection$CacheEntry != null) {
            jarFile = (JarFile)jarURLConnection$CacheEntry.get();
        }
        if (jarFile == null && string != null) {
            int n = 1 + (bl ? 4 : 0);
            jarFile = new JarFile(new File(string), true, n);
            jarCache.put(string2, new JarURLConnection$CacheEntry(jarFile, string2, this.cacheQueue));
        } else {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(this.getPermission());
            }
            if (bl) {
                lru.remove(new JarURLConnection$LRUKey(jarFile, 0L));
            }
        }
        if (bl) {
            lru.add(new JarURLConnection$LRUKey(jarFile, new Date().getTime()));
            if (lru.size() > Limit) {
                lru.remove(lru.first());
            }
        }
        return jarFile;
    }

    @Override
    public JarEntry getJarEntry() {
        if (!this.connected) {
            this.connect();
        }
        return this.jarEntry;
    }

    private void findJarEntry() {
        if (this.getEntryName() == null) {
            return;
        }
        this.jarEntry = this.jarFile.getJarEntry(this.getEntryName());
        if (this.jarEntry == null) {
            throw new FileNotFoundException(this.getEntryName());
        }
    }

    @Override
    public InputStream getInputStream() {
        if (!this.connected) {
            this.connect();
        }
        if (this.jarInput != null) {
            return this.jarInput;
        }
        if (this.jarEntry == null) {
            throw new IOException(Msg.getString("K00fc"));
        }
        this.jarInput = this.jarFile.getInputStream(this.jarEntry);
        return this.jarInput;
    }

    @Override
    public String getContentType() {
        try {
            if (this.url.getFile().endsWith("!/")) {
                return this.getJarFileURL().openConnection().getContentType();
            }
        }
        catch (IOException iOException) {}
        return JarURLConnection.guessContentTypeFromName(this.url.getFile());
    }

    @Override
    public int getContentLength() {
        try {
            if (this.url.getFile().endsWith("!/")) {
                return this.getJarFileURL().openConnection().getContentLength();
            }
        }
        catch (IOException iOException) {}
        return -1;
    }

    @Override
    public Object getContent() {
        if (!this.connected) {
            this.connect();
        }
        if (this.jarEntry == null) {
            return this.jarFile;
        }
        return super.getContent();
    }

    @Override
    public Permission getPermission() {
        if (this.jarFileURLConnection != null) {
            return this.jarFileURLConnection.getPermission();
        }
        return this.getJarFileURL().openConnection().getPermission();
    }

    public static void closeCachedFiles() {
        Enumeration enumeration = jarCache.elements();
        while (enumeration.hasMoreElements()) {
            try {
                ZipFile zipFile = (ZipFile)((JarURLConnection$CacheEntry)enumeration.nextElement()).get();
                if (zipFile == null) continue;
                zipFile.close();
            }
            catch (IOException iOException) {}
        }
    }
}

