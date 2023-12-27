/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.DefaultPolicy$1;
import com.ibm.oti.util.DefaultPolicy$GrantHolder;
import com.ibm.oti.util.DefaultPolicy$PolicyTokenizer;
import com.ibm.oti.util.Msg;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.net.JarURLConnection;
import java.net.MalformedURLException;
import java.net.SocketPermission;
import java.net.URL;
import java.security.AccessController;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.security.Security;
import java.security.UnresolvedPermission;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.PropertyPermission;
import java.util.Vector;
import java.util.WeakHashMap;

public class DefaultPolicy
extends Policy {
    private Vector grantList = new Vector();
    private boolean policyRead = false;
    private Map cache = Collections.synchronizedMap(new WeakHashMap());
    static /* synthetic */ Class class$0;

    @Override
    public PermissionCollection getPermissions(CodeSource codeSource) {
        PermissionCollection permissionCollection = (PermissionCollection)this.cache.get(codeSource);
        if (permissionCollection != null) {
            return this.copyCollection(permissionCollection);
        }
        PermissionCollection permissionCollection2 = (PermissionCollection)AccessController.doPrivileged(new DefaultPolicy$1(this, codeSource));
        this.cache.put(codeSource, this.copyCollection(permissionCollection2));
        return permissionCollection2;
    }

    private PermissionCollection copyCollection(PermissionCollection permissionCollection) {
        Permissions permissions = new Permissions();
        Enumeration enumeration = permissionCollection.elements();
        while (enumeration.hasMoreElements()) {
            ((PermissionCollection)permissions).add((Permission)enumeration.nextElement());
        }
        return permissions;
    }

    PermissionCollection getPermissionsImpl(CodeSource codeSource) {
        this.getSystemPolicy();
        URL uRL = codeSource.getLocation() != null ? DefaultPolicy.toCanonicalURL(codeSource.getLocation()) : null;
        Permissions permissions = new Permissions();
        CodeSource codeSource2 = new CodeSource(uRL, codeSource.getCertificates());
        int n = 0;
        while (n < this.grantList.size()) {
            DefaultPolicy$GrantHolder defaultPolicy$GrantHolder = (DefaultPolicy$GrantHolder)this.grantList.elementAt(n);
            if (defaultPolicy$GrantHolder.getCodeSource() == null || defaultPolicy$GrantHolder.getCodeSource().implies(codeSource2)) {
                Permissions permissions2 = defaultPolicy$GrantHolder.getPermissions();
                Enumeration enumeration = permissions2.elements();
                while (enumeration.hasMoreElements()) {
                    ((PermissionCollection)permissions).add((Permission)enumeration.nextElement());
                }
            }
            ++n;
        }
        return permissions;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private KeyStore loadKeystore(URL uRL, String[] stringArray) {
        Object object;
        BufferedInputStream bufferedInputStream = null;
        try {
            object = new URL(uRL, stringArray[0]);
            bufferedInputStream = new BufferedInputStream(((URL)object).openStream());
        }
        catch (MalformedURLException malformedURLException) {
        }
        catch (IOException iOException) {}
        try {
            object = stringArray[1];
            if (object == null) {
                object = KeyStore.getDefaultType();
            }
            KeyStore keyStore = KeyStore.getInstance((String)object);
            keyStore.load(bufferedInputStream, null);
            KeyStore keyStore2 = keyStore;
            if (bufferedInputStream == null) return keyStore2;
            try {
                bufferedInputStream.close();
                return keyStore2;
            }
            catch (IOException iOException) {}
            return keyStore2;
        }
        catch (KeyStoreException keyStoreException) {
            try {
                catch (NoSuchAlgorithmException noSuchAlgorithmException) {
                }
                catch (CertificateException certificateException) {
                }
                catch (IOException iOException) {
                }
            }
            catch (Throwable throwable) {
                if (bufferedInputStream == null) throw throwable;
                try {
                    bufferedInputStream.close();
                    throw throwable;
                }
                catch (IOException iOException) {}
                throw throwable;
            }
        }
        if (bufferedInputStream == null) return null;
        try {
            bufferedInputStream.close();
            return null;
        }
        catch (IOException iOException) {}
        return null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void readPolicy(InputStream inputStream, URL uRL, boolean bl) {
        Certificate[] certificateArray;
        Object object;
        int n;
        Certificate[] certificateArray2;
        Object[] objectArray;
        DefaultPolicy$GrantHolder defaultPolicy$GrantHolder;
        if (inputStream == null) {
            return;
        }
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(inputStream, "UTF8");
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return;
        }
        DefaultPolicy$PolicyTokenizer defaultPolicy$PolicyTokenizer = new DefaultPolicy$PolicyTokenizer(inputStreamReader);
        String[] stringArray = null;
        Vector vector = new Vector();
        Vector vector2 = new Vector();
        int n2 = defaultPolicy$PolicyTokenizer.nextToken();
        while (!defaultPolicy$PolicyTokenizer.isAtEOF()) {
            block32: {
                block35: {
                    block36: {
                        if (n2 != 1) break block35;
                        if (!defaultPolicy$PolicyTokenizer.sval.equalsIgnoreCase("grant")) break block36;
                        this.parseGrant(defaultPolicy$PolicyTokenizer, uRL, vector, vector2, bl);
                        break block32;
                    }
                    if (defaultPolicy$PolicyTokenizer.sval.equalsIgnoreCase("keystore")) {
                        if (stringArray != null) {
                            defaultPolicy$PolicyTokenizer.skipTokens(';');
                            break block32;
                        } else {
                            stringArray = new String[2];
                            this.parseKeystore(defaultPolicy$PolicyTokenizer, stringArray, bl);
                        }
                        break block32;
                    } else {
                        this.grantList.removeAllElements();
                        break;
                    }
                }
                this.grantList.removeAllElements();
                break;
            }
            n2 = defaultPolicy$PolicyTokenizer.nextToken();
        }
        n2 = 0;
        KeyStore keyStore = null;
        int n3 = 0;
        while (n3 < vector2.size()) {
            defaultPolicy$GrantHolder = (DefaultPolicy$GrantHolder)((Object[])vector2.get(n3))[0];
            objectArray = (String[])((Object[])vector2.get(n3))[1];
            certificateArray2 = null;
            Object object2 = objectArray[3];
            if (object2 != null && n2 == 0) {
                n2 = 1;
                keyStore = this.loadKeystore(uRL, stringArray);
            }
            if (object2 != null && keyStore != null) {
                n = ((String)object2).length();
                int n4 = 0;
                int n5 = 0;
                while (n5 < n) {
                    n5 = ((String)object2).indexOf(44, n4);
                    if (n5 == -1) {
                        n5 = n;
                    }
                    if (n4 < n5) {
                        object = ((String)object2).substring(n4, n5).trim();
                        certificateArray = null;
                        try {
                            certificateArray = keyStore.getCertificate((String)object);
                        }
                        catch (KeyStoreException keyStoreException) {
                            certificateArray = null;
                        }
                        if (certificateArray == null) {
                            certificateArray2 = null;
                            break;
                        }
                        if (certificateArray2 == null) {
                            certificateArray2 = new Certificate[]{certificateArray};
                        } else {
                            Certificate[] certificateArray3 = new Certificate[certificateArray2.length + 1];
                            System.arraycopy((Object)certificateArray2, 0, (Object)certificateArray3, 0, certificateArray2.length);
                            certificateArray3[certificateArray3.length - 1] = certificateArray;
                            certificateArray2 = certificateArray3;
                        }
                    }
                    n4 = n5 + 1;
                }
            }
            if (certificateArray2 != null) {
                Object object3 = objectArray[0];
                Object object4 = objectArray[1];
                Object object5 = objectArray[2];
                defaultPolicy$GrantHolder.addPermission(new UnresolvedPermission((String)object3, (String)object4, (String)object5, certificateArray2));
            }
            ++n3;
        }
        Enumeration enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            defaultPolicy$GrantHolder = (DefaultPolicy$GrantHolder)enumeration.nextElement();
            objectArray = null;
            certificateArray2 = defaultPolicy$GrantHolder.getSigner();
            if (certificateArray2 != null && n2 == 0) {
                n2 = 1;
                keyStore = this.loadKeystore(uRL, stringArray);
            }
            if (certificateArray2 != null && keyStore != null) {
                int n6 = certificateArray2.length();
                n = 0;
                int n7 = 0;
                while (n7 < n6) {
                    n7 = certificateArray2.indexOf(44, n);
                    if (n7 == -1) {
                        n7 = n6;
                    }
                    if (n < n7) {
                        String string = certificateArray2.substring(n, n7).trim();
                        object = null;
                        try {
                            object = keyStore.getCertificate(string);
                        }
                        catch (KeyStoreException keyStoreException) {
                            object = null;
                        }
                        if (object == null) {
                            objectArray = null;
                            break;
                        }
                        if (objectArray == null) {
                            objectArray = new Certificate[]{object};
                        } else {
                            certificateArray = new Certificate[objectArray.length + 1];
                            System.arraycopy((Object)objectArray, 0, (Object)certificateArray, 0, objectArray.length);
                            certificateArray[certificateArray.length - 1] = object;
                            objectArray = certificateArray;
                        }
                    }
                    n = n7 + 1;
                }
            }
            if (objectArray != null) {
                CodeSource codeSource = new CodeSource(defaultPolicy$GrantHolder.getCodeSource().getLocation(), (Certificate[])objectArray);
                defaultPolicy$GrantHolder.setCodeSource(codeSource);
            }
            if (certificateArray2 != null && objectArray == null) continue;
            this.addGrant(defaultPolicy$GrantHolder);
        }
        this.policyRead = true;
    }

    private void addGrant(DefaultPolicy$GrantHolder defaultPolicy$GrantHolder) {
        defaultPolicy$GrantHolder.setSigner(null);
        int n = 0;
        while (n < this.grantList.size()) {
            DefaultPolicy$GrantHolder defaultPolicy$GrantHolder2 = (DefaultPolicy$GrantHolder)this.grantList.elementAt(n);
            if (defaultPolicy$GrantHolder2.getCodeSource().equals(defaultPolicy$GrantHolder.getCodeSource())) {
                Enumeration enumeration = defaultPolicy$GrantHolder.getPermissions().elements();
                while (enumeration.hasMoreElements()) {
                    defaultPolicy$GrantHolder2.addPermission((Permission)enumeration.nextElement());
                }
                return;
            }
            ++n;
        }
        this.grantList.addElement(defaultPolicy$GrantHolder);
    }

    private void parseKeystore(DefaultPolicy$PolicyTokenizer defaultPolicy$PolicyTokenizer, String[] stringArray, boolean bl) {
        int n = 1;
        while (!defaultPolicy$PolicyTokenizer.isAtEOF()) {
            switch (defaultPolicy$PolicyTokenizer.nextToken()) {
                case 0: {
                    if (defaultPolicy$PolicyTokenizer.cval != ';') break;
                    return;
                }
                case 2: {
                    if (n == 1) {
                        n = 2;
                        String string = this.expandTags(defaultPolicy$PolicyTokenizer.sval, true, bl);
                        stringArray[0] = string.replace('\\', '/');
                        break;
                    }
                    if (n != 2) break;
                    n = 3;
                    stringArray[1] = defaultPolicy$PolicyTokenizer.sval;
                    break;
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void parseGrant(DefaultPolicy$PolicyTokenizer defaultPolicy$PolicyTokenizer, URL uRL, Vector vector, Vector vector2, boolean bl) {
        Object object;
        boolean bl2 = false;
        String string = null;
        String string2 = null;
        while (!defaultPolicy$PolicyTokenizer.isAtEOF()) {
            if (defaultPolicy$PolicyTokenizer.nextToken() == 0) {
                if (defaultPolicy$PolicyTokenizer.cval == '{') break;
                if (defaultPolicy$PolicyTokenizer.cval == ',' && (string != null || string2 != null)) continue;
                defaultPolicy$PolicyTokenizer.sval = String.valueOf(defaultPolicy$PolicyTokenizer.cval);
            }
            if (defaultPolicy$PolicyTokenizer.sval.equalsIgnoreCase("codeBase")) {
                if (defaultPolicy$PolicyTokenizer.nextToken() != 2) {
                    System.out.println(Msg.getString("K00a2", new Object[]{uRL, "codeBase", defaultPolicy$PolicyTokenizer.sval}));
                    bl2 = true;
                    break;
                }
                string = this.expandTags(defaultPolicy$PolicyTokenizer.sval, false, bl);
                if (string == null) {
                    bl2 = true;
                    break;
                }
                string = string.replace('\\', '/');
                continue;
            }
            if (defaultPolicy$PolicyTokenizer.sval.equalsIgnoreCase("signedBy")) {
                if (defaultPolicy$PolicyTokenizer.nextToken() != 2) {
                    System.out.println(Msg.getString("K00a2", new Object[]{uRL, "signedBy", defaultPolicy$PolicyTokenizer.sval}));
                    bl2 = true;
                    continue;
                }
                string2 = defaultPolicy$PolicyTokenizer.sval;
                continue;
            }
            System.out.println(Msg.getString("K00a3", uRL, defaultPolicy$PolicyTokenizer.sval));
            bl2 = true;
            break;
        }
        DefaultPolicy$GrantHolder defaultPolicy$GrantHolder = null;
        try {
            CodeSource codeSource = null;
            object = null;
            if (string != null) {
                object = DefaultPolicy.toCanonicalURL(new URL(string));
            }
            codeSource = new CodeSource((URL)object, null);
            if (defaultPolicy$GrantHolder == null) {
                defaultPolicy$GrantHolder = new DefaultPolicy$GrantHolder();
            }
            defaultPolicy$GrantHolder.setCodeSource(codeSource);
        }
        catch (MalformedURLException malformedURLException) {
            bl2 = true;
            System.out.println(Msg.getString("K00a8", uRL, string));
        }
        if (bl2) {
            defaultPolicy$PolicyTokenizer.skipTokens('}');
            defaultPolicy$PolicyTokenizer.skipTokens(';');
            return;
        }
        defaultPolicy$GrantHolder.setSigner(string2);
        int n = 2;
        object = null;
        String string3 = null;
        String string4 = null;
        String string5 = null;
        block13: while (!defaultPolicy$PolicyTokenizer.isAtEOF()) {
            int n2 = defaultPolicy$PolicyTokenizer.nextToken();
            if (n2 == 0) {
                if (defaultPolicy$PolicyTokenizer.cval == '}') {
                    if (defaultPolicy$PolicyTokenizer.nextToken() == 0) {
                        if (defaultPolicy$PolicyTokenizer.cval == ';') break;
                        defaultPolicy$PolicyTokenizer.sval = String.valueOf(defaultPolicy$PolicyTokenizer.cval);
                    }
                    n2 = -1;
                } else {
                    if (defaultPolicy$PolicyTokenizer.cval == ';') {
                        if (!(string3 != null && (string3 = this.expandTags(string3, false, bl)) == null || string4 != null && (string4 = this.expandTags(string4, false, bl)) == null)) {
                            Permission permission = this.createPermission((String)object, string3, string4);
                            if (permission != null) {
                                defaultPolicy$GrantHolder.addPermission(permission);
                            } else if (string5 == null) {
                                defaultPolicy$GrantHolder.addPermission(new UnresolvedPermission((String)object, string3, string4, null));
                            } else if (!string5.equals("")) {
                                String[] stringArray = new String[]{object, string3, string4, string5};
                                Object[] objectArray = new Object[]{defaultPolicy$GrantHolder, stringArray};
                                vector2.add(objectArray);
                            }
                        }
                        object = null;
                        string3 = null;
                        string4 = null;
                        n = 2;
                        continue;
                    }
                    if (defaultPolicy$PolicyTokenizer.cval == ',') continue;
                    defaultPolicy$PolicyTokenizer.sval = String.valueOf(defaultPolicy$PolicyTokenizer.cval);
                }
            }
            if (n2 == 2) {
                switch (n) {
                    case 4: {
                        string3 = defaultPolicy$PolicyTokenizer.sval;
                        n = 5;
                        continue block13;
                    }
                    case 5: {
                        string4 = defaultPolicy$PolicyTokenizer.sval;
                        n = 3;
                        continue block13;
                    }
                    case 6: {
                        string5 = defaultPolicy$PolicyTokenizer.sval;
                        n = 0;
                        continue block13;
                    }
                }
            } else if (n2 == 1) {
                switch (n) {
                    case 1: {
                        object = defaultPolicy$PolicyTokenizer.sval;
                        n = 4;
                        continue block13;
                    }
                    case 2: {
                        if (!defaultPolicy$PolicyTokenizer.sval.equalsIgnoreCase("permission")) break;
                        n = 1;
                        continue block13;
                    }
                    case 3: 
                    case 4: 
                    case 5: {
                        if (!defaultPolicy$PolicyTokenizer.sval.equalsIgnoreCase("signedBy")) break;
                        n = 6;
                        continue block13;
                    }
                }
            }
            System.out.println(Msg.getString("K00a3", new Object[]{uRL, defaultPolicy$PolicyTokenizer.sval}));
            bl2 = true;
            break;
        }
        if (!bl2 || defaultPolicy$GrantHolder.getPermissions() == null) {
            vector.addElement(defaultPolicy$GrantHolder);
        }
    }

    Permission createPermission(String string, String string2, String string3) {
        try {
            Class clazz = Class.forName(string);
            Class[] classArray = new Class[2];
            Class clazz2 = class$0;
            if (clazz2 == null) {
                try {
                    clazz2 = class$0 = Class.forName("java.lang.String");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            classArray[0] = clazz2;
            Class clazz3 = class$0;
            if (clazz3 == null) {
                try {
                    clazz3 = class$0 = Class.forName("java.lang.String");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            classArray[1] = clazz3;
            Constructor constructor = clazz.getConstructor(classArray);
            return (Permission)constructor.newInstance(new Object[]{string2, string3});
        }
        catch (Exception exception) {
            return null;
        }
    }

    private synchronized void getSystemPolicy() {
        String string;
        Object object;
        Object object2;
        String string2;
        boolean bl;
        if (this.policyRead) {
            return;
        }
        boolean bl2 = !"false".equalsIgnoreCase(Security.getProperty("policy.expandProperties"));
        boolean bl3 = bl = !"false".equalsIgnoreCase(Security.getProperty("allowSystemProperty"));
        if (bl && (string2 = System.getProperty("java.security.policy")) != null) {
            boolean bl4;
            boolean bl5 = bl4 = string2.charAt(0) == '=';
            if (bl4) {
                string2 = string2.substring(1);
            }
            try {
                try {
                    object2 = new URL(string2);
                }
                catch (MalformedURLException malformedURLException) {
                    object2 = new URL(new StringBuffer("file:").append(string2).toString());
                }
                object = ((URL)object2).openStream();
                this.readPolicy((InputStream)object, (URL)object2, bl2);
                ((InputStream)object).close();
            }
            catch (IOException iOException) {}
            if (bl4) {
                return;
            }
        }
        int n = 1;
        while ((string = Security.getProperty(new StringBuffer("policy.url.").append(n++).toString())) != null) {
            try {
                object2 = new URL(this.expandTags(string, false, true).replace('\\', '/'));
                object = ((URL)object2).openStream();
                this.readPolicy((InputStream)object, (URL)object2, bl2);
                ((InputStream)object).close();
            }
            catch (IOException iOException) {}
        }
        if (!this.policyRead) {
            this.grantList.removeAllElements();
            object2 = new DefaultPolicy$GrantHolder();
            object = DefaultPolicy.defaultSystemPermissionList();
            int n2 = 0;
            while (n2 < ((Permission[])object).length) {
                ((DefaultPolicy$GrantHolder)object2).addPermission(object[n2]);
                ++n2;
            }
            this.policyRead = true;
            this.grantList.addElement(object2);
            try {
                String string3 = System.getProperty("java.home");
                CodeSource codeSource = new CodeSource(new File(string3, "lib/ext/*").toURL(), null);
                DefaultPolicy$GrantHolder defaultPolicy$GrantHolder = new DefaultPolicy$GrantHolder();
                defaultPolicy$GrantHolder.setCodeSource(codeSource);
                defaultPolicy$GrantHolder.addPermission(new AllPermission());
                this.grantList.addElement(defaultPolicy$GrantHolder);
            }
            catch (MalformedURLException malformedURLException) {}
        }
    }

    @Override
    public void refresh() {
        this.policyRead = false;
        this.cache.clear();
        this.grantList.removeAllElements();
    }

    String expandTags(String string, boolean bl, boolean bl2) {
        if (!bl2) {
            return string;
        }
        StringBuffer stringBuffer = null;
        int n = 0;
        int n2 = string.length();
        while (n < n2) {
            int n3 = string.indexOf("${", n);
            if (n3 == -1) {
                if (n == 0) {
                    return string;
                }
                stringBuffer.append(string.substring(n));
                break;
            }
            if (stringBuffer == null) {
                stringBuffer = new StringBuffer(string.length() * 2);
            }
            int n4 = string.indexOf(125, n3);
            stringBuffer.append(string.substring(n, n3));
            if (n4 > n3) {
                n = n4 + 1;
                String string2 = this.expandProperty(string.substring(n3 + 2, n4));
                if (string2 != null) {
                    char c2;
                    stringBuffer.append(string2);
                    if (string2.length() <= 0 || (c2 = string2.charAt(string2.length() - 1)) != '\\' && c2 != '/' || n >= n2 || (c2 = string.charAt(n)) != '\\' && c2 != '/') continue;
                    ++n;
                    continue;
                }
                if (bl) continue;
                return null;
            }
            n = n3 + 2;
            stringBuffer.append("${");
        }
        return stringBuffer == null ? string : stringBuffer.toString();
    }

    String expandProperty(String string) {
        if (string.equals("/")) {
            string = "file.separator";
        }
        return System.getProperty(string);
    }

    private static Permission[] defaultSystemPermissionList() {
        return new Permission[]{new RuntimePermission("exitVM"), new SocketPermission("localhost:1024-", "listen"), new PropertyPermission("java.version", "read"), new PropertyPermission("java.vendor", "read"), new PropertyPermission("java.vendor.url", "read"), new PropertyPermission("java.class.version", "read"), new PropertyPermission("os.name", "read"), new PropertyPermission("os.version", "read"), new PropertyPermission("os.arch", "read"), new PropertyPermission("file.separator", "read"), new PropertyPermission("path.separator", "read"), new PropertyPermission("line.separator", "read"), new PropertyPermission("java.specification.version", "read"), new PropertyPermission("java.specification.vendor", "read"), new PropertyPermission("java.specification.name", "read"), new PropertyPermission("java.vm.specification.version", "read"), new PropertyPermission("java.vm.specification.vendor", "read"), new PropertyPermission("java.vm.specification.name", "read"), new PropertyPermission("java.vm.version", "read"), new PropertyPermission("java.vm.vendor", "read"), new PropertyPermission("java.vm.name", "read")};
    }

    private static URL toCanonicalURL(URL uRL) {
        if (uRL.getProtocol().equals("jar")) {
            try {
                JarURLConnection jarURLConnection = (JarURLConnection)uRL.openConnection();
                String string = DefaultPolicy.toCanonicalURL(jarURLConnection.getJarFileURL()).toString();
                String string2 = jarURLConnection.getEntryName();
                if (string2 == null) {
                    string2 = "";
                }
                string = new StringBuffer(string.length() + string2.length() + 2).append(string).append("!/").append(string2).toString();
                return new URL("jar", null, -1, string);
            }
            catch (IOException iOException) {}
        }
        if (uRL.getProtocol().equals("file")) {
            String string;
            String string3 = uRL.getFile();
            if (string3 == null) {
                string3 = "";
            }
            if ((string = uRL.getHost()) != null && string.length() > 0) {
                string3 = new StringBuffer(string.length() + string3.length() + 2).append("//").append(string).append(string3).toString();
            }
            try {
                return new File(string3).toURL();
            }
            catch (MalformedURLException malformedURLException) {}
        }
        return uRL;
    }
}

