/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.net.www.protocol.jxe.Handler;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.AbstractClassLoader$1;
import com.ibm.oti.vm.AbstractClassLoader$2;
import com.ibm.oti.vm.AbstractClassLoader$3;
import com.ibm.oti.vm.AbstractClassLoader$CacheLock;
import com.ibm.oti.vm.AbstractClassLoader$ManifestLock;
import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.JxePermission;
import com.ibm.oti.vm.VM;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.ProtectionDomain;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.Attributes$Name;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public abstract class AbstractClassLoader
extends ClassLoader {
    private static ClassLoader systemClassLoader;
    String[] parsedPath;
    int[] types;
    Object[] cache;
    static Object cacheLock;
    FilePermission[] permissions;
    private static final RuntimePermission permissionToExitVM;
    private static Object manifestLock;

    static {
        cacheLock = new AbstractClassLoader$CacheLock();
        permissionToExitVM = new RuntimePermission("exitVM");
        manifestLock = new AbstractClassLoader$ManifestLock();
    }

    public AbstractClassLoader() {
    }

    public AbstractClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }

    String parsePath(String string) {
        char c2 = File.pathSeparatorChar;
        int n = 0;
        int n2 = 0;
        int n3 = string.length();
        while (n < n3) {
            int n4 = string.indexOf(c2, n);
            if (n4 == -1) {
                n4 = n3;
            }
            if (n4 - n > 0) {
                ++n2;
            }
            n = n4 + 1;
        }
        this.parsedPath = new String[n2];
        this.types = new int[n2];
        this.cache = new Object[n2];
        n2 = 0;
        n = 0;
        StringBuffer stringBuffer = new StringBuffer();
        while (n < n3) {
            int n5 = string.indexOf(c2, n);
            if (n5 == -1) {
                n5 = n3;
            }
            if (n5 - n > 0) {
                String string2 = string.substring(n, n5);
                stringBuffer.append(string2);
                if (n5 < n3) {
                    stringBuffer.append(c2);
                }
                this.parsedPath[n2++] = string2;
            }
            n = n5 + 1;
        }
        return stringBuffer.toString();
    }

    void fillCache(int n) {
        this.setTypeElement(n, VM.getClassPathEntryType(this, n));
        switch (this.types[n]) {
            case 0: {
                this.setCacheElement(n, this.cache);
                return;
            }
            case 1: 
            case 2: {
                String string;
                if (this.parsedPath[n] == null) {
                    this.setParsedPathElement(n, Util.toString(VM.getPathFromClassPath(n)));
                }
                File file = new File(this.parsedPath[n]);
                try {
                    string = file.getCanonicalPath();
                }
                catch (IOException iOException) {
                    string = file.getAbsolutePath();
                }
                if (this.types[n] == 1) {
                    if (string.charAt(string.length() - 1) != File.separatorChar) {
                        string = new StringBuffer(string.length() + 1).append(string).append(File.separatorChar).toString();
                    }
                    this.setParsedPathElement(n, string);
                    this.setCacheElement(n, this.cache);
                } else {
                    this.setParsedPathElement(n, string);
                    try {
                        JarFile jarFile = new JarFile(this.parsedPath[n]);
                        this.setCacheElement(n, jarFile);
                        return;
                    }
                    catch (IOException iOException) {
                        this.setTypeElement(n, 5);
                        this.setCacheElement(n, this.cache);
                    }
                }
                return;
            }
            case 4: 
            case 8: {
                Jxe jxe = VM.getJxeFromClassPath(this, n);
                if (jxe != null) {
                    this.setCacheElement(n, jxe);
                    return;
                }
            }
            case 3: 
            case 5: {
                this.setCacheElement(n, this.cache);
                return;
            }
        }
    }

    @Override
    public InputStream getResourceAsStream(String string) {
        InputStream inputStream;
        if (string == null || string.length() < 1 || string.charAt(0) == '/') {
            return null;
        }
        if (this != systemClassLoader && (inputStream = this.getParent() == null ? systemClassLoader.getResourceAsStream(string) : this.getParent().getResourceAsStream(string)) != null) {
            return inputStream;
        }
        int n = this.cache.length;
        int n2 = 0;
        while (n2 < n) {
            try {
                if (this.cache[n2] == null) {
                    this.fillCache(n2);
                }
                switch (this.types[n2]) {
                    case 2: {
                        Object object;
                        ZipFile zipFile = (ZipFile)this.cache[n2];
                        ZipEntry zipEntry = zipFile.getEntry(string);
                        if (zipEntry != null) {
                            object = System.getSecurityManager();
                            if (object != null) {
                                this.initalizePermissions();
                                if (this.permissions[n2] == null) {
                                    this.setPermissionElement(n2, new FilePermission(this.parsedPath[n2], "read"));
                                }
                                ((SecurityManager)object).checkPermission(this.permissions[n2]);
                            }
                            try {
                                return zipFile.getInputStream(zipEntry);
                            }
                            catch (IOException iOException) {
                            }
                        }
                        break;
                    }
                    case 4: 
                    case 8: {
                        Object object = (Jxe)this.cache[n2];
                        InputStream inputStream2 = ((Jxe)object).getResourceAsStream(string);
                        if (inputStream2 != null) {
                            return inputStream2;
                        }
                        break;
                    }
                    case 1: {
                        String string2 = new StringBuffer(this.parsedPath[n2].length() + string.length()).append(this.parsedPath[n2]).append(string).toString();
                        InputStream inputStream3 = this.openFile(string2);
                        if (inputStream3 != null) {
                            return inputStream3;
                        }
                        break;
                    }
                }
            }
            catch (SecurityException securityException) {}
            ++n2;
        }
        return null;
    }

    private void setCacheElement(int n, Object object) {
        this.cache[n] = object;
    }

    private void setTypeElement(int n, int n2) {
        this.types[n] = n2;
    }

    private void setParsedPathElement(int n, String string) {
        this.parsedPath[n] = string;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void initalizePermissions() {
        Object object = cacheLock;
        synchronized (object) {
            if (this.permissions == null) {
                this.permissions = new FilePermission[this.cache.length];
            }
        }
    }

    private void setPermissionElement(int n, FilePermission filePermission) {
        this.permissions[n] = filePermission;
    }

    private InputStream openFile(String string) {
        File file = new File(string);
        if (file.exists()) {
            try {
                return new BufferedInputStream(new FileInputStream(file));
            }
            catch (FileNotFoundException fileNotFoundException) {}
        }
        return null;
    }

    @Override
    protected URL findResource(String string) {
        SecurityManager securityManager;
        URL uRL = (URL)AccessController.doPrivileged(new AbstractClassLoader$1(this, string));
        if (uRL != null && (securityManager = System.getSecurityManager()) != null) {
            try {
                securityManager.checkPermission(uRL.openConnection().getPermission());
            }
            catch (IOException iOException) {
                return null;
            }
            catch (SecurityException securityException) {
                return null;
            }
        }
        return uRL;
    }

    private URL findResourceImpl(int n, String string) {
        if (string.length() > 0 && string.charAt(0) == '/') {
            return null;
        }
        if (this.cache[n] == null) {
            this.fillCache(n);
        }
        try {
            switch (this.types[n]) {
                case 2: {
                    ZipFile zipFile = (ZipFile)this.cache[n];
                    if (zipFile.getEntry(string) != null) {
                        return new URL("jar", null, -1, new StringBuffer(String.valueOf(AbstractClassLoader.toURLString(this.parsedPath[n]))).append("!/").append(string).toString(), null);
                    }
                    return null;
                }
                case 4: 
                case 8: {
                    Jxe jxe = (Jxe)this.cache[n];
                    InputStream inputStream = jxe.getResourceAsStream(string);
                    if (inputStream != null) {
                        return new URL("jxe", jxe.getUuid(), -1, new StringBuffer("/").append(string).toString(), new Handler(jxe));
                    }
                    return null;
                }
                case 1: {
                    String string2 = new StringBuffer(this.parsedPath[n].length() + string.length()).append(this.parsedPath[n]).append(string).toString();
                    File file = new File(string2);
                    if (file.exists()) {
                        return new URL(AbstractClassLoader.toURLString(string2));
                    }
                    return null;
                }
            }
        }
        catch (MalformedURLException malformedURLException) {}
        return null;
    }

    @Override
    protected Enumeration findResources(String string) {
        SecurityManager securityManager;
        Vector vector = (Vector)AccessController.doPrivileged(new AbstractClassLoader$2(this, string));
        int n = vector.size();
        if (n > 0 && (securityManager = System.getSecurityManager()) != null) {
            Vector vector2 = new Vector(n);
            int n2 = 0;
            while (n2 < n) {
                URL uRL = (URL)vector.elementAt(n2);
                try {
                    securityManager.checkPermission(uRL.openConnection().getPermission());
                    vector2.addElement(uRL);
                }
                catch (IOException iOException) {
                }
                catch (SecurityException securityException) {}
                ++n2;
            }
            vector = vector2;
        }
        return vector.elements();
    }

    static String toURLString(String string) {
        String string2 = string;
        if (File.separatorChar != '/') {
            string2 = string2.replace(File.separatorChar, '/');
        }
        StringBuffer stringBuffer = new StringBuffer(string2.length() + 6).append("file:");
        if (!string2.startsWith("/")) {
            stringBuffer.append('/');
        }
        string2 = stringBuffer.append(string2).toString();
        return string2;
    }

    public static void setBootstrapClassLoader(ClassLoader classLoader) {
        if (systemClassLoader != null) {
            throw new IllegalArgumentException();
        }
        systemClassLoader = classLoader;
    }

    Object getFilePD(int n) {
        String string;
        boolean bl = false;
        if (n >= 0) {
            if (this.cache[n] == null) {
                this.fillCache(n);
            }
            if (this.types[n] == 4 || this.types[n] == 8) {
                bl = true;
                string = ((Jxe)this.cache[n]).getUuid();
            } else {
                string = this.parsedPath[n];
            }
        } else {
            string = File.separator;
        }
        ProtectionDomain protectionDomain = (ProtectionDomain)this.getProtectionDomainCache().get(string);
        if (protectionDomain == null) {
            URL uRL = null;
            String string2 = bl ? new StringBuffer("jxe://").append(string).append("/").toString() : AbstractClassLoader.toURLString(string);
            try {
                uRL = new URL(string2);
            }
            catch (MalformedURLException malformedURLException) {}
            CodeSource codeSource = new CodeSource(uRL, null);
            Permissions permissions = new Permissions();
            if (bl) {
                ((PermissionCollection)permissions).add(new JxePermission(string));
            } else if (string != null && uRL.getProtocol().equals("file")) {
                if (string.endsWith(File.separator)) {
                    ((PermissionCollection)permissions).add(new FilePermission(new StringBuffer(String.valueOf(string)).append("-").toString(), "read"));
                } else {
                    ((PermissionCollection)permissions).add(new FilePermission(string, "read"));
                }
            }
            if (this.addExitPermission()) {
                ((PermissionCollection)permissions).add(permissionToExitVM);
            }
            protectionDomain = new ProtectionDomain(codeSource, permissions);
            this.getProtectionDomainCache().put(string, protectionDomain);
        }
        return protectionDomain;
    }

    boolean addExitPermission() {
        return false;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    void definePackage(String string, int n) {
        Object object;
        if (n >= 0 && this.cache[n] == null) {
            AccessController.doPrivileged(new AbstractClassLoader$3(this, n));
        }
        if (n >= 0 && this.types[n] == 2) {
            Object object2;
            object = null;
            try {
                object2 = (JarFile)this.cache[n];
                object = ((JarFile)object2).getManifest();
            }
            catch (IOException iOException) {}
            if (object != null) {
                object2 = manifestLock;
                synchronized (object2) {
                    String string2 = null;
                    String string3 = null;
                    String string4 = null;
                    String string5 = null;
                    String string6 = null;
                    String string7 = null;
                    if (super.getPackage(string) != null) {
                        return;
                    }
                    Attributes attributes = ((Manifest)object).getMainAttributes();
                    String string8 = attributes.getValue(Attributes$Name.SEALED);
                    boolean bl = string8 != null && string8.toLowerCase().equals("true");
                    String string9 = new StringBuffer(String.valueOf(string.replace('.', '/'))).append("/").toString();
                    Attributes attributes2 = ((Manifest)object).getAttributes(string9);
                    if (attributes2 != null) {
                        string8 = attributes2.getValue(Attributes$Name.SEALED);
                        if (string8 != null) {
                            bl = string8.toLowerCase().equals("true");
                        }
                        string2 = attributes2.getValue(Attributes$Name.SPECIFICATION_TITLE);
                        string3 = attributes2.getValue(Attributes$Name.SPECIFICATION_VERSION);
                        string4 = attributes2.getValue(Attributes$Name.SPECIFICATION_VENDOR);
                        string5 = attributes2.getValue(Attributes$Name.IMPLEMENTATION_TITLE);
                        string6 = attributes2.getValue(Attributes$Name.IMPLEMENTATION_VERSION);
                        string7 = attributes2.getValue(Attributes$Name.IMPLEMENTATION_VENDOR);
                    }
                    URL uRL = null;
                    try {
                        if (bl) {
                            uRL = new URL(AbstractClassLoader.toURLString(this.parsedPath[n]));
                        }
                    }
                    catch (MalformedURLException malformedURLException) {}
                    if (string2 == null) {
                        string2 = attributes.getValue(Attributes$Name.SPECIFICATION_TITLE);
                    }
                    if (string3 == null) {
                        string3 = attributes.getValue(Attributes$Name.SPECIFICATION_VERSION);
                    }
                    if (string4 == null) {
                        string4 = attributes.getValue(Attributes$Name.SPECIFICATION_VENDOR);
                    }
                    if (string5 == null) {
                        string5 = attributes.getValue(Attributes$Name.IMPLEMENTATION_TITLE);
                    }
                    if (string6 == null) {
                        string6 = attributes.getValue(Attributes$Name.IMPLEMENTATION_VERSION);
                    }
                    if (string7 == null) {
                        string7 = attributes.getValue(Attributes$Name.IMPLEMENTATION_VENDOR);
                    }
                    this.definePackage(string, string2, string3, string4, string5, string6, string7, uRL);
                    return;
                }
            }
        }
        object = manifestLock;
        synchronized (object) {
            if (super.getPackage(string) != null) {
                return;
            }
            this.definePackage(string, null, null, null, null, null, null, null);
        }
    }

    Hashtable getProtectionDomainCache() {
        return null;
    }

    String getPackageName(Class clazz) {
        String string = clazz.getName();
        int n = string.lastIndexOf(46);
        if (n == -1) {
            return null;
        }
        return string.substring(0, n);
    }

    static /* synthetic */ URL access$0(AbstractClassLoader abstractClassLoader, int n, String string) {
        return abstractClassLoader.findResourceImpl(n, string);
    }
}

