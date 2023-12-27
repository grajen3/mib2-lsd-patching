/*
 * Decompiled with CFR 0.152.
 */
package java.net;

import com.ibm.oti.net.www.protocol.jxe.JxeURLConnection;
import com.ibm.oti.util.AccessibleByteArrayInputStream;
import com.ibm.oti.util.InvalidJarIndexException;
import com.ibm.oti.util.Msg;
import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.JxeException;
import com.ibm.oti.vm.JxePermission;
import com.ibm.oti.vm.JxeUtil;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.SocketPermission;
import java.net.URL;
import java.net.URLClassLoader$1;
import java.net.URLClassLoader$2;
import java.net.URLClassLoader$3;
import java.net.URLClassLoader$4;
import java.net.URLClassLoader$5;
import java.net.URLConnection;
import java.net.URLStreamHandler;
import java.net.URLStreamHandlerFactory;
import java.security.AccessControlContext;
import java.security.AccessController;
import java.security.CodeSource;
import java.security.PermissionCollection;
import java.security.SecureClassLoader;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.IdentityHashMap;
import java.util.ListIterator;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.jar.Attributes;
import java.util.jar.Attributes$Name;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.zip.ZipEntry;

public class URLClassLoader
extends SecureClassLoader {
    private static URL[] NO_PATH = new URL[0];
    private static Class JxeHandler;
    URL[] urls;
    URL[] orgUrls;
    private IdentityHashMap resCache = new IdentityHashMap(32);
    private URLStreamHandlerFactory factory;
    HashMap extensions;
    Hashtable[] indexes;
    private Hashtable jxeManifestCache = new Hashtable(8);
    private AccessControlContext currentContext = null;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    public URLClassLoader(URL[] uRLArray) {
        this(uRLArray, ClassLoader.getSystemClassLoader(), null);
    }

    public URLClassLoader(URL[] uRLArray, ClassLoader classLoader) {
        this(uRLArray, classLoader, null);
    }

    protected void addURL(URL uRL) {
        try {
            URL uRL2 = this.createSearchURL(uRL);
            this.urls = this.addURL(this.urls, uRL2);
            this.orgUrls = this.addURL(this.orgUrls, uRL);
            this.extensions.put(uRL2, null);
        }
        catch (MalformedURLException malformedURLException) {}
    }

    URL[] addURL(URL[] uRLArray, URL uRL) {
        URL[] uRLArray2 = new URL[uRLArray.length + 1];
        System.arraycopy((Object)uRLArray, 0, (Object)uRLArray2, 0, uRLArray.length);
        uRLArray2[uRLArray.length] = uRL;
        Hashtable[] hashtableArray = new Hashtable[this.indexes.length + 1];
        System.arraycopy((Object)this.indexes, 0, (Object)hashtableArray, 0, this.indexes.length);
        this.indexes = hashtableArray;
        return uRLArray2;
    }

    @Override
    public Enumeration findResources(String string) {
        SecurityManager securityManager;
        if (string == null) {
            return null;
        }
        Vector vector = (Vector)AccessController.doPrivileged(new URLClassLoader$1(this, string), this.currentContext);
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

    Vector findResources(URL[] uRLArray, String string, Vector vector) {
        boolean bl = uRLArray == this.urls;
        int n = 0;
        while (n < uRLArray.length) {
            if (uRLArray[n] != null) {
                URL[] uRLArray2 = new URL[]{uRLArray[n]};
                URL uRL = this.findResourceImpl(uRLArray2, string);
                if (uRLArray2[0] == null) {
                    uRLArray[n] = null;
                } else {
                    if (uRL != null && !vector.contains(uRL)) {
                        vector.addElement(uRL);
                    }
                    if (bl) {
                        this.findInExtensions(this.explore(uRLArray[n], n), string, n, vector, false);
                    }
                }
            }
            ++n;
        }
        return vector;
    }

    Object findInIndex(int n, String string, Vector vector, boolean bl) {
        Hashtable hashtable = this.indexes[n];
        if (hashtable != null) {
            String string2;
            int n2 = string.lastIndexOf("/");
            String string3 = string2 = n2 > 0 ? string.substring(0, n2) : string;
            if (vector != null) {
                URL[] uRLArray = (URL[])hashtable.get(string2);
                if (uRLArray != null) {
                    this.findResources(uRLArray, string, vector);
                }
            } else if (bl) {
                URL[] uRLArray = (URL[])hashtable.get(string2);
                if (uRLArray != null) {
                    return this.findResourceImpl(uRLArray, string);
                }
            } else {
                URL[] uRLArray;
                Object object;
                String string4 = string.replace('.', '/');
                boolean bl2 = false;
                int n3 = string4.lastIndexOf(47);
                if (n3 != -1) {
                    object = string4.substring(0, n3);
                    uRLArray = (URL[])hashtable.get(object);
                } else {
                    object = new StringBuffer(String.valueOf(string4)).append(".class").toString();
                    uRLArray = (URL[])hashtable.get(object);
                    bl2 = true;
                }
                if (uRLArray != null) {
                    object = this.findClassImpl(uRLArray, string);
                    if (object == null && bl2) {
                        throw new InvalidJarIndexException();
                    }
                    return object;
                }
            }
        }
        return null;
    }

    Object findInExtensions(URL[] uRLArray, String string, int n, Vector vector, boolean bl) {
        if (uRLArray != null) {
            int n2 = 0;
            while (n2 < uRLArray.length) {
                if (uRLArray[n2] != null) {
                    Object object;
                    URL[] uRLArray2 = new URL[]{uRLArray[n2]};
                    if (vector != null) {
                        object = this.findResourceImpl(uRLArray2, string);
                        if (uRLArray2[0] == null) {
                            uRLArray[n2] = null;
                        } else {
                            if (object != null && !vector.contains(object)) {
                                vector.addElement(object);
                            }
                            this.findInExtensions(this.explore(uRLArray[n2], n), string, n, vector, bl);
                        }
                    } else {
                        object = bl ? this.findResourceImpl(uRLArray2, string) : this.findClassImpl(uRLArray2, string);
                        if (object != null) {
                            return object;
                        }
                        if (uRLArray2[0] == null) {
                            uRLArray[n2] = null;
                        } else {
                            object = this.findInExtensions(this.explore(uRLArray[n2], n), string, n, vector, bl);
                            if (object != null) {
                                return object;
                            }
                        }
                    }
                }
                ++n2;
            }
        } else {
            return this.findInIndex(n, string, vector, bl);
        }
        return null;
    }

    private static byte[] getBytes(InputStream inputStream, boolean bl) {
        int n;
        if (bl) {
            if (inputStream instanceof AccessibleByteArrayInputStream) {
                return ((AccessibleByteArrayInputStream)inputStream).getByteArray();
            }
            byte[] byArray = new byte[inputStream.available()];
            inputStream.read(byArray, 0, byArray.length);
            inputStream.close();
            return byArray;
        }
        byte[] byArray = new byte[4096];
        int n2 = inputStream.available();
        if (n2 < 1024) {
            n2 = 1024;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(n2);
        while ((n = inputStream.read(byArray)) > 0) {
            byteArrayOutputStream.write(byArray, 0, n);
        }
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    protected PermissionCollection getPermissions(CodeSource codeSource) {
        PermissionCollection permissionCollection = super.getPermissions(codeSource);
        URL uRL = codeSource.getLocation();
        if (uRL.getProtocol().equals("jar")) {
            try {
                uRL = ((JarURLConnection)uRL.openConnection()).getJarFileURL();
            }
            catch (IOException iOException) {}
        }
        if (uRL.getProtocol().equals("file")) {
            String string = uRL.getFile();
            String string2 = uRL.getHost();
            if (string2 != null && string2.length() > 0) {
                string = new StringBuffer("//").append(string2).append(string).toString();
            }
            if (File.separatorChar != '/') {
                string = string.replace('/', File.separatorChar);
            }
            if (URLClassLoader.isDirectory(uRL)) {
                permissionCollection.add(new FilePermission(new StringBuffer(String.valueOf(string)).append("-").toString(), "read"));
            } else {
                permissionCollection.add(new FilePermission(string, "read"));
            }
        } else if (uRL.getProtocol().equals("jxe")) {
            permissionCollection.add(new JxePermission(uRL.getHost()));
        } else {
            String string = uRL.getHost();
            if (string.length() == 0) {
                string = "localhost";
            }
            permissionCollection.add(new SocketPermission(string, "connect, accept"));
        }
        return permissionCollection;
    }

    public URL[] getURLs() {
        return this.orgUrls;
    }

    private static boolean isDirectory(URL uRL) {
        String string = uRL.getFile();
        return string.length() > 0 && string.charAt(string.length() - 1) == '/';
    }

    public static URLClassLoader newInstance(URL[] uRLArray) {
        URLClassLoader uRLClassLoader = (URLClassLoader)AccessController.doPrivileged(new URLClassLoader$2(uRLArray));
        uRLClassLoader.currentContext = AccessController.getContext();
        return uRLClassLoader;
    }

    public static URLClassLoader newInstance(URL[] uRLArray, ClassLoader classLoader) {
        URLClassLoader uRLClassLoader = (URLClassLoader)AccessController.doPrivileged(new URLClassLoader$3(uRLArray, classLoader));
        uRLClassLoader.currentContext = AccessController.getContext();
        return uRLClassLoader;
    }

    public URLClassLoader(URL[] uRLArray, ClassLoader classLoader, URLStreamHandlerFactory uRLStreamHandlerFactory) {
        super(classLoader);
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkCreateClassLoader();
        }
        this.factory = uRLStreamHandlerFactory;
        this.currentContext = AccessController.getContext();
        int n = uRLArray.length;
        this.urls = new URL[n];
        this.orgUrls = new URL[n];
        this.extensions = new HashMap(n * 2);
        int n2 = 0;
        while (n2 < n) {
            try {
                this.urls[n2] = this.createSearchURL(uRLArray[n2]);
                this.extensions.put(this.urls[n2], null);
            }
            catch (MalformedURLException malformedURLException) {}
            this.orgUrls[n2] = uRLArray[n2];
            ++n2;
        }
        this.indexes = new Hashtable[n];
    }

    @Override
    protected Class findClass(String string) {
        Class clazz = (Class)AccessController.doPrivileged(new URLClassLoader$4(this, string), this.currentContext);
        if (clazz != null) {
            return clazz;
        }
        throw new ClassNotFoundException(string);
    }

    private URL createSearchURL(URL uRL) {
        if (uRL == null) {
            return uRL;
        }
        String string = uRL.getProtocol();
        if (string.equals("jxe")) {
            try {
                Jxe jxe = ((JxeURLConnection)uRL.openConnection()).getJxe();
                JxeUtil.romImageLoad(jxe, this);
            }
            catch (IOException iOException) {
                throw new MalformedURLException(iOException.toString());
            }
            catch (JxeException jxeException) {
                throw new MalformedURLException(jxeException.toString());
            }
            return uRL;
        }
        if (URLClassLoader.isDirectory(uRL) || string.equals("jar")) {
            return uRL;
        }
        if (this.factory == null) {
            return new URL("jar", "", -1, new StringBuffer(String.valueOf(uRL.toString())).append("!/").toString());
        }
        return new URL("jar", "", -1, new StringBuffer(String.valueOf(uRL.toString())).append("!/").toString(), this.factory.createURLStreamHandler(string));
    }

    @Override
    public URL findResource(String string) {
        SecurityManager securityManager;
        if (string == null) {
            return null;
        }
        URL uRL = (URL)AccessController.doPrivileged(new URLClassLoader$5(this, string), this.currentContext);
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

    URL findResourceImpl(URL[] uRLArray, String string) {
        boolean bl = uRLArray == this.urls;
        int n = 0;
        while (n < uRLArray.length) {
            if (uRLArray[n] != null) {
                URL uRL;
                JarFile jarFile;
                block24: {
                    jarFile = null;
                    try {
                        int n2;
                        Object object;
                        Object object2;
                        uRL = uRLArray[n];
                        String string2 = uRL.getProtocol();
                        if (string2.equals("jar")) {
                            jarFile = (JarFile)this.resCache.get(uRL);
                            if (jarFile == null) {
                                object2 = ((JarURLConnection)uRL.openConnection()).getJarFileURL();
                                try {
                                    object = (JarURLConnection)new URL("jar", "", new StringBuffer(String.valueOf(((URL)object2).toExternalForm())).append("!/").toString()).openConnection();
                                    jarFile = ((JarURLConnection)object).getJarFile();
                                    this.resCache.put(uRL, jarFile);
                                }
                                catch (IOException iOException) {
                                    uRLArray[n] = null;
                                    throw iOException;
                                }
                            }
                            if (uRL.getFile().endsWith("!/")) {
                                object2 = string;
                            } else {
                                object = uRL.getFile();
                                n2 = ((String)object).lastIndexOf("!/");
                                if (n2 == -1) {
                                    uRLArray[n] = null;
                                    continue;
                                }
                                object2 = new StringBuffer(((String)object).length() - (n2 += 2) + string.length()).append(((String)object).substring(n2)).append(string).toString();
                            }
                            if (jarFile.getEntry((String)object2) != null) {
                                return this.targetURL(uRL, string);
                            }
                            break block24;
                        }
                        if (string2.equals("file")) {
                            object2 = uRL.getFile();
                            object = uRL.getHost();
                            n2 = 0;
                            if (object != null) {
                                n2 = ((String)object).length();
                            }
                            StringBuffer stringBuffer = new StringBuffer(2 + n2 + ((String)object2).length() + string.length());
                            if (n2 > 0) {
                                stringBuffer.append("//").append((String)object);
                            }
                            stringBuffer.append((String)object2);
                            String string3 = string;
                            while (string3.startsWith("/") || string3.startsWith("\\")) {
                                string3 = string3.substring(1);
                            }
                            stringBuffer.append(string3);
                            String string4 = stringBuffer.toString();
                            if (new File(string4).exists()) {
                                return this.targetURL(uRL, string3);
                            }
                            break block24;
                        }
                        object2 = this.targetURL(uRL, string);
                        object = ((URL)object2).openConnection();
                        try {
                            ((URLConnection)object).getInputStream().close();
                        }
                        catch (SecurityException securityException) {
                            return null;
                        }
                        if (!((URL)object2).getProtocol().equals("http")) {
                            return object2;
                        }
                        n2 = ((HttpURLConnection)object).getResponseCode();
                        if (n2 >= 200 && n2 < 300) {
                            return object2;
                        }
                    }
                    catch (MalformedURLException malformedURLException) {
                    }
                    catch (IOException iOException) {
                    }
                    catch (SecurityException securityException) {}
                }
                if (jarFile != null && bl && (this.indexes[n] != null ? (uRL = (URL)this.findInIndex(n, string, null, true)) != null : (uRL = (URL)this.findInExtensions(this.explore(uRLArray[n], n), string, n, null, true)) != null)) {
                    return uRL;
                }
            }
            ++n;
        }
        return null;
    }

    protected Package definePackage(String string, Manifest manifest, URL uRL) {
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        String string7;
        Attributes attributes = manifest.getMainAttributes();
        String string8 = new StringBuffer(String.valueOf(string.replace('.', '/'))).append("/").toString();
        Attributes attributes2 = manifest.getAttributes(string8);
        boolean bl = false;
        if (attributes2 == null) {
            bl = true;
            attributes2 = attributes;
        }
        if ((string7 = attributes2.getValue(Attributes$Name.SPECIFICATION_TITLE)) == null && !bl) {
            string7 = attributes.getValue(Attributes$Name.SPECIFICATION_TITLE);
        }
        if ((string6 = attributes2.getValue(Attributes$Name.SPECIFICATION_VERSION)) == null && !bl) {
            string6 = attributes.getValue(Attributes$Name.SPECIFICATION_VERSION);
        }
        if ((string5 = attributes2.getValue(Attributes$Name.SPECIFICATION_VENDOR)) == null && !bl) {
            string5 = attributes.getValue(Attributes$Name.SPECIFICATION_VENDOR);
        }
        if ((string4 = attributes2.getValue(Attributes$Name.IMPLEMENTATION_TITLE)) == null && !bl) {
            string4 = attributes.getValue(Attributes$Name.IMPLEMENTATION_TITLE);
        }
        if ((string3 = attributes2.getValue(Attributes$Name.IMPLEMENTATION_VERSION)) == null && !bl) {
            string3 = attributes.getValue(Attributes$Name.IMPLEMENTATION_VERSION);
        }
        if ((string2 = attributes2.getValue(Attributes$Name.IMPLEMENTATION_VENDOR)) == null && !bl) {
            string2 = attributes.getValue(Attributes$Name.IMPLEMENTATION_VENDOR);
        }
        return this.definePackage(string, string7, string6, string5, string4, string3, string2, this.isSealed(manifest, string8) ? uRL : null);
    }

    private boolean isSealed(Manifest manifest, String string) {
        Attributes attributes = manifest.getMainAttributes();
        String string2 = attributes.getValue(Attributes$Name.SEALED);
        boolean bl = string2 != null && string2.toLowerCase().equals("true");
        Attributes attributes2 = manifest.getAttributes(string);
        if (attributes2 != null && (string2 = attributes2.getValue(Attributes$Name.SEALED)) != null) {
            bl = string2.toLowerCase().equals("true");
        }
        return bl;
    }

    private URL[] getInternalURLs(URL uRL, String string) {
        URL[] uRLArray;
        StringTokenizer stringTokenizer = new StringTokenizer(string);
        Vector vector = new Vector();
        String string2 = uRL.getFile();
        string2 = string2.substring(0, string2.lastIndexOf("/", string2.lastIndexOf("!/") - 1) + 1);
        String string3 = uRL.getProtocol();
        String string4 = uRL.getHost();
        int n = uRL.getPort();
        while (stringTokenizer.hasMoreElements()) {
            uRLArray = stringTokenizer.nextToken();
            if (uRLArray.equals("")) continue;
            try {
                URL uRL2 = new URL(string3, string4, n, new StringBuffer(String.valueOf(string2)).append((String)uRLArray).append("!/").toString());
                if (this.extensions.containsKey(uRL2)) continue;
                this.extensions.put(uRL2, null);
                vector.add(uRL2);
            }
            catch (MalformedURLException malformedURLException) {}
        }
        uRLArray = (URL[])vector.toArray(new URL[0]);
        return uRLArray;
    }

    private ArrayList readLines(InputStream inputStream) {
        int n;
        byte[] byArray = new byte[144];
        ArrayList arrayList = new ArrayList();
        int n2 = 0;
        while ((n = inputStream.read()) != -1) {
            if (n == 10) {
                arrayList.add(new String(byArray, 0, n2, "UTF8"));
                n2 = 0;
                continue;
            }
            if (n == 13) {
                arrayList.add(new String(byArray, 0, n2, "UTF8"));
                n2 = 0;
                n = inputStream.read();
                if (n == 10) continue;
            }
            if (n2 == byArray.length) {
                byte[] byArray2 = new byte[byArray.length * 2];
                System.arraycopy((Object)byArray, 0, (Object)byArray2, 0, byArray.length);
                byArray = byArray2;
            }
            byArray[n2++] = (byte)n;
        }
        if (n2 > 0) {
            arrayList.add(new String(byArray, 0, n2, "UTF8"));
        }
        return arrayList;
    }

    private URL targetURL(URL uRL, String string) {
        String string2 = new StringBuffer(uRL.getFile().length() + string.length()).append(uRL.getFile()).append(string).toString();
        if (JxeHandler == null) {
            try {
                Class clazz = class$0;
                if (clazz == null) {
                    try {
                        clazz = class$0 = Class.forName("com.ibm.oti.net.www.protocol.jxe.Handler");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                JxeHandler = clazz;
            }
            catch (Throwable throwable) {
                Class clazz = class$1;
                if (clazz == null) {
                    try {
                        clazz = class$1 = Class.forName("java.lang.Object");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                JxeHandler = clazz;
            }
        }
        URLStreamHandler uRLStreamHandler = null;
        if (super.getClass() == JxeHandler) {
            uRLStreamHandler = uRL.getStreamHandler();
        }
        return new URL(uRL.getProtocol(), uRL.getHost(), uRL.getPort(), string2, uRLStreamHandler);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    Class findClassImpl(URL[] uRLArray, String string) {
        boolean bl = false;
        boolean bl2 = uRLArray == this.urls;
        String string2 = new StringBuffer(string.replace('.', '/')).append(".class").toString();
        int n = 0;
        while (n < uRLArray.length) {
            block39: {
                if (uRLArray[n] != null) {
                    Object object;
                    Object object2;
                    Certificate[] certificateArray;
                    Serializable serializable;
                    byte[] byArray;
                    Jxe jxe;
                    JarFile jarFile;
                    JarEntry jarEntry;
                    InputStream inputStream;
                    Manifest manifest;
                    block40: {
                        manifest = null;
                        inputStream = null;
                        jarEntry = null;
                        jarFile = null;
                        jxe = null;
                        byArray = null;
                        try {
                            serializable = uRLArray[n];
                            certificateArray = ((URL)serializable).getProtocol();
                            if (certificateArray.equals("jar")) {
                                jarFile = (JarFile)this.resCache.get(serializable);
                                if (jarFile == null) {
                                    object2 = ((JarURLConnection)((URL)serializable).openConnection()).getJarFileURL();
                                    try {
                                        JarURLConnection jarURLConnection = (JarURLConnection)new URL("jar", "", new StringBuffer(String.valueOf(((URL)object2).toExternalForm())).append("!/").toString()).openConnection();
                                        jarFile = jarURLConnection.getJarFile();
                                        this.resCache.put(serializable, jarFile);
                                    }
                                    catch (IOException iOException) {
                                        uRLArray[n] = null;
                                        throw iOException;
                                    }
                                }
                                if (((URL)serializable).getFile().endsWith("!/")) {
                                    jarEntry = jarFile.getJarEntry(string2);
                                } else {
                                    object2 = ((URL)serializable).getFile();
                                    int n2 = ((String)object2).lastIndexOf("!/");
                                    if (n2 == -1) {
                                        uRLArray[n] = null;
                                        break block39;
                                    }
                                    object = new StringBuffer(((String)object2).length() - (n2 += 2) + string2.length()).append(((String)object2).substring(n2)).append(string2).toString();
                                    jarEntry = jarFile.getJarEntry((String)object);
                                }
                                if (jarEntry != null) {
                                    bl = true;
                                    inputStream = jarFile.getInputStream(jarEntry);
                                    manifest = jarFile.getManifest();
                                }
                                break block40;
                            }
                            if (certificateArray.equals("jxe")) {
                                jxe = ((JxeURLConnection)((URL)serializable).openConnection()).getJxe();
                                if (jxe != null) {
                                    byArray = JxeUtil.getRomClass(jxe, string);
                                    if (byArray != null) {
                                        manifest = (Manifest)this.jxeManifestCache.get(jxe);
                                        if (manifest == null && (object2 = jxe.getResourceAsStream("META-INF/MANIFEST.MF")) != null) {
                                            manifest = new Manifest((InputStream)object2);
                                            ((InputStream)object2).close();
                                            this.jxeManifestCache.put(jxe, manifest);
                                        }
                                    } else {
                                        jxe = null;
                                    }
                                }
                                break block40;
                            }
                            if (certificateArray.equals("file")) {
                                object2 = ((URL)serializable).getFile();
                                String string3 = ((URL)serializable).getHost();
                                object2 = string3 != null && string3.length() > 0 ? new StringBuffer(string3.length() + ((String)object2).length() + string2.length() + 2).append("//").append(string3).append((String)object2).append(string2).toString() : new StringBuffer(((String)object2).length() + string2.length()).append((String)object2).append(string2).toString();
                                object = new File((String)object2);
                                if (!((File)object).exists()) break block39;
                                inputStream = new FileInputStream((File)object);
                                bl = true;
                                break block40;
                            }
                            inputStream = this.targetURL((URL)serializable, string2).openStream();
                        }
                        catch (MalformedURLException malformedURLException) {
                        }
                        catch (IOException iOException) {}
                    }
                    if (inputStream != null || jxe != null) {
                        serializable = null;
                        certificateArray = null;
                        object2 = null;
                        try {
                            serializable = bl2 ? this.orgUrls[n] : ((JarURLConnection)uRLArray[n].openConnection()).getJarFileURL();
                        }
                        catch (IOException iOException) {
                            serializable = uRLArray[n];
                        }
                        if (inputStream != null) {
                            try {
                                byArray = URLClassLoader.getBytes(inputStream, bl);
                                inputStream.close();
                            }
                            catch (IOException iOException) {
                                return null;
                            }
                        }
                        if (jarEntry != null) {
                            certificateArray = jarEntry.getCertificates();
                        }
                        object2 = new CodeSource((URL)serializable, certificateArray);
                        int n3 = string.lastIndexOf(".");
                        if (n3 != -1) {
                            object = string.substring(0, n3);
                            URLClassLoader uRLClassLoader = this;
                            synchronized (uRLClassLoader) {
                                Package package_ = this.getPackage((String)object);
                                if (package_ == null) {
                                    if (manifest != null) {
                                        this.definePackage((String)object, manifest, (URL)serializable);
                                    } else {
                                        this.definePackage((String)object, null, null, null, null, null, null, null);
                                    }
                                } else {
                                    boolean bl3 = false;
                                    if (manifest != null) {
                                        String string4 = new StringBuffer(String.valueOf(((String)object).replace('.', '/'))).append("/").toString();
                                        if (this.isSealed(manifest, string4)) {
                                            bl3 = !package_.isSealed((URL)serializable);
                                        }
                                    } else {
                                        bl3 = package_.isSealed();
                                    }
                                    if (bl3) {
                                        throw new SecurityException(Msg.getString("K004c"));
                                    }
                                }
                            }
                        }
                        return this.defineClass(string, byArray, 0, byArray.length, (CodeSource)object2);
                    }
                    if (jarFile != null && bl2 && (this.indexes[n] != null ? (serializable = (Class)this.findInIndex(n, string, null, false)) != null : (serializable = (Class)this.findInExtensions(this.explore(uRLArray[n], n), string, n, null, false)) != null)) {
                        return serializable;
                    }
                }
            }
            ++n;
        }
        return null;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    URL[] explore(URL uRL, int n) {
        URL[] uRLArray;
        Object object = this.extensions;
        synchronized (object) {
            uRLArray = (URL[])this.extensions.get(uRL);
        }
        if (uRLArray != null) {
            return uRLArray;
        }
        if (this.indexes[n] != null) {
            return null;
        }
        if (!uRL.getProtocol().equals("jar")) {
            return null;
        }
        object = (JarFile)this.resCache.get(uRL);
        ZipEntry zipEntry = ((JarFile)object).getEntry("META-INF/INDEX.LIST");
        if (zipEntry != null) {
            if (uRL.equals(this.urls[n])) {
                try {
                    Hashtable hashtable = new Hashtable(15);
                    InputStream inputStream = ((JarFile)object).getInputStream(zipEntry);
                    ArrayList arrayList = this.readLines(inputStream);
                    inputStream.close();
                    ListIterator listIterator = arrayList.listIterator();
                    listIterator.next();
                    listIterator.next();
                    URL uRL2 = ((JarURLConnection)uRL.openConnection()).getJarFileURL();
                    String string = uRL2.getFile();
                    String string2 = new File(string).getParent();
                    string2 = string2.replace(File.separatorChar, '/');
                    if (string2.charAt(0) != '/') {
                        string2 = new StringBuffer("/").append(string2).toString();
                    }
                    URL uRL3 = new URL(uRL2.getProtocol(), uRL2.getHost(), uRL2.getPort(), string2);
                    while (listIterator.hasNext()) {
                        URL uRL4 = new URL(new StringBuffer("jar:").append(uRL3.toExternalForm()).append("/").append((String)listIterator.next()).append("!/").toString());
                        String string3 = null;
                        while (listIterator.hasNext() && !(string3 = (String)listIterator.next()).equals("")) {
                            URL[] uRLArray2;
                            if (hashtable.containsKey(string3)) {
                                uRLArray2 = (URL[])hashtable.get(string3);
                                URL[] uRLArray3 = new URL[uRLArray2.length + 1];
                                System.arraycopy((Object)uRLArray2, 0, (Object)uRLArray3, 0, uRLArray2.length);
                                uRLArray3[uRLArray2.length] = uRL4;
                                hashtable.put(string3, uRLArray3);
                                continue;
                            }
                            uRLArray2 = new URL[]{uRL4};
                            hashtable.put(string3, uRLArray2);
                        }
                    }
                    this.indexes[n] = hashtable;
                }
                catch (MalformedURLException malformedURLException) {
                }
                catch (IOException iOException) {}
            }
            return null;
        }
        Manifest manifest = null;
        try {
            manifest = ((JarFile)object).getManifest();
        }
        catch (IOException iOException) {}
        String string = null;
        if (manifest != null) {
            string = manifest.getMainAttributes().getValue(Attributes$Name.CLASS_PATH);
        }
        HashMap hashMap = this.extensions;
        synchronized (hashMap) {
            uRLArray = (URL[])this.extensions.get(uRL);
            if (uRLArray == null) {
                uRLArray = string != null ? this.getInternalURLs(uRL, string) : NO_PATH;
                this.extensions.put(uRL, uRLArray);
            }
        }
        return uRLArray;
    }
}

