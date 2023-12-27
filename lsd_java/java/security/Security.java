/*
 * Decompiled with CFR 0.152.
 */
package java.security;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.PriviAction;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.AccessController;
import java.security.InvalidParameterException;
import java.security.Provider;
import java.security.Security$1;
import java.security.SecurityPermission;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

public final class Security {
    private static final String[] defaultProperties = new String[]{"package.access", "com.ibm.oti.", "policy.provider", "com.ibm.oti.util.DefaultPolicy", "security.provider.1", "com.ibm.oti.security.provider.OTI"};
    private static final Properties securityProperties = Security.loadSecurityProperties();
    private static final Vector providersByPriority = new Vector();
    private static final Hashtable providersByName = new Hashtable(20);
    private static boolean providersLoaded = false;
    private static final int CRYPTO_SERVICE;
    private static final int ALGORITHM_OR_TYPE;
    private static final int ATTRIBUTE_NAME;
    private static final int ATTRIBUTE_VALUE;

    private Security() {
    }

    public static String getProperty(String string) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new SecurityPermission(new StringBuffer("getProperty.").append(string).toString()));
        }
        return securityProperties.getProperty(string);
    }

    public static void setProperty(String string, String string2) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkPermission(new SecurityPermission(new StringBuffer("setProperty.").append(string).toString()));
        }
        securityProperties.put(string, string2);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static int addProvider(Provider provider) {
        if (!providersLoaded) {
            Security.loadSecurityProviders();
        }
        Vector vector = providersByPriority;
        synchronized (vector) {
            return Security.insertProviderAt(provider, providersByPriority.size() + 1);
        }
    }

    public static Provider getProvider(String string) {
        if (!providersLoaded) {
            Security.loadSecurityProviders();
        }
        return (Provider)providersByName.get(string);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static Provider[] getProviders() {
        if (!providersLoaded) {
            Security.loadSecurityProviders();
        }
        Vector vector = providersByPriority;
        synchronized (vector) {
            Object[] objectArray = new Provider[providersByPriority.size()];
            providersByPriority.copyInto(objectArray);
            return objectArray;
        }
    }

    private static boolean checkAttribute(String string, String string2, String string3) {
        if (string2.length() == 0) {
            return true;
        }
        try {
            int n = Integer.parseInt(string3);
            int n2 = Integer.parseInt(string2);
            return n >= n2;
        }
        catch (NumberFormatException numberFormatException) {
            return string3.equals(string2);
        }
    }

    private static String[] parserOfFilter(String string) {
        String[] stringArray = new String[4];
        char[] cArray = new char[]{'.', ' ', ':'};
        int n = 0;
        int n2 = 0;
        int n3 = string.length();
        int n4 = 0;
        n4 = 0;
        while (n4 < cArray.length && n < n3 && n2 != -1) {
            n2 = string.indexOf(cArray[n4], n);
            if (n2 == -1) {
                stringArray[n4] = new String(string.substring(n, n3));
                break;
            }
            stringArray[n4] = new String(string.substring(n, n2));
            n = n2 + 1;
            while (n < n3 && string.charAt(n) == ' ') {
                ++n;
            }
            ++n4;
        }
        if (n2 != -1) {
            stringArray[n4] = new String(string.substring(n, n3));
        }
        return stringArray;
    }

    private static Provider[] getProvidersUsingFilters(Provider[] providerArray, String[] stringArray, int n) {
        int n2 = providerArray.length;
        if (n2 > 0) {
            String string = new StringBuffer(String.valueOf(stringArray[0])).append(".").append(stringArray[1]).toString();
            String string2 = new StringBuffer("Alg.Alias.").append(string).toString();
            boolean bl = true;
            int n3 = 0;
            while (n3 < providerArray.length) {
                String string3;
                bl = true;
                String string4 = string;
                String string5 = providerArray[n3].getProperty(string2);
                if (string5 != null) {
                    string4 = new StringBuffer(String.valueOf(stringArray[0])).append(".").append(string5).toString();
                }
                if ((string3 = providerArray[n3].getProperty(string4)) != null) {
                    String string6;
                    if (n == 1) {
                        bl = false;
                    } else if (n == 2 && (string6 = providerArray[n3].getProperty(string4 = new StringBuffer(String.valueOf(string4)).append(' ').append(stringArray[2]).toString())) != null && Security.checkAttribute(stringArray[2], stringArray[3], string6)) {
                        bl = false;
                    }
                }
                if (bl) {
                    providerArray[n3] = null;
                    --n2;
                }
                ++n3;
            }
            if (n2 > 0) {
                Provider[] providerArray2 = new Provider[n2];
                int n4 = 0;
                int n5 = 0;
                while (n5 < providerArray.length) {
                    if (providerArray[n5] != null) {
                        providerArray2[n4++] = providerArray[n5];
                    }
                    ++n5;
                }
                providerArray = providerArray2;
            } else {
                providerArray = null;
            }
        } else {
            providerArray = null;
        }
        return providerArray;
    }

    public static Provider[] getProviders(String string) {
        Provider[] providerArray = Security.getProviders();
        if (providerArray.length == 0) {
            return null;
        }
        String[] stringArray = Security.parserOfFilter(string);
        int n = 0;
        if (stringArray[0] != null && stringArray[1] != null) {
            if (stringArray[2] != null || stringArray[3] != null) {
                if (stringArray[2] != null && stringArray[3] != null) {
                    if (stringArray[2].length() > 0) {
                        n = 2;
                    } else if (stringArray[3].length() == 0) {
                        n = 1;
                    }
                }
            } else if (stringArray[1].length() > 0) {
                n = 1;
            }
        }
        if (n == 0) {
            throw new InvalidParameterException(Msg.getString("K01a6"));
        }
        return Security.getProvidersUsingFilters(providerArray, stringArray, n);
    }

    public static Provider[] getProviders(Map map) {
        Provider[] providerArray = Security.getProviders();
        if (providerArray.length == 0) {
            return null;
        }
        if (map == null) {
            return providerArray;
        }
        Set set = map.keySet();
        if (set == null) {
            return providerArray;
        }
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            String string2 = (String)map.get(string);
            String[] stringArray = Security.parserOfFilter(string);
            int n = 0;
            if (stringArray[0] != null && stringArray[1] != null) {
                if (stringArray[2] != null) {
                    if (stringArray[3] != null) {
                        throw new InvalidParameterException(Msg.getString("K01a6"));
                    }
                    if (string2.length() >= 0) {
                        n = 2;
                        stringArray[3] = string2;
                    }
                } else if (string2.length() == 0 && stringArray[1].length() > 0) {
                    n = 1;
                }
            }
            if (n == 0) {
                throw new InvalidParameterException(Msg.getString("K01a6"));
            }
            if ((providerArray = Security.getProvidersUsingFilters(providerArray, stringArray, n)) != null) continue;
            return null;
        }
        return providerArray;
    }

    public static int insertProviderAt(Provider provider, int n) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess(new StringBuffer("insertProvider.").append(provider.getName()).toString());
        }
        if (!providersLoaded) {
            Security.loadSecurityProviders();
        }
        return Security.insertAt(provider, n);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static int insertAt(Provider provider, int n) {
        Vector vector = providersByPriority;
        synchronized (vector) {
            block5: {
                if (providersByName.get(provider.getName()) == null) break block5;
                return -1;
            }
            if (--n < 0 || n > providersByPriority.size()) {
                n = providersByPriority.size();
            }
            providersByPriority.insertElementAt(provider, n);
            providersByName.put(provider.getName(), provider);
        }
        return ++n;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public static void removeProvider(String string) {
        SecurityManager securityManager = System.getSecurityManager();
        if (securityManager != null) {
            securityManager.checkSecurityAccess(new StringBuffer("removeProvider.").append(string).toString());
        }
        if (!providersLoaded) {
            Security.loadSecurityProviders();
        }
        Vector vector = providersByPriority;
        synchronized (vector) {
            int n = -1;
            int n2 = 0;
            while (n2 < providersByPriority.size()) {
                Provider provider = (Provider)providersByPriority.elementAt(n2);
                if (string.equals(provider.getName())) {
                    n = n2;
                    break;
                }
                ++n2;
            }
            if (n >= 0) {
                providersByPriority.removeElementAt(n);
                providersByName.remove(string);
            }
        }
    }

    public static Set getAlgorithms(String string) {
        TreeSet treeSet = new TreeSet();
        Provider[] providerArray = Security.getProviders();
        int n = 0;
        while (n < providerArray.length) {
            Provider provider = providerArray[n];
            Set set = provider.keySet();
            String string2 = string.toLowerCase();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                String string3 = (String)iterator.next();
                String string4 = string3.toLowerCase();
                if (string4.indexOf(string2) != 0) continue;
                int n2 = string3.indexOf(46);
                String string5 = string3.substring(n2 + 1);
                treeSet.add(string5);
            }
            ++n;
        }
        return treeSet;
    }

    private static void loadDefaultProperties(Properties properties) {
        int n = 0;
        while (n < defaultProperties.length) {
            properties.put(defaultProperties[n], defaultProperties[n + 1]);
            n += 2;
        }
    }

    private static void loadSecurityProperties(String string, Properties properties, boolean bl) {
        File file = new File(string);
        if (!file.exists()) {
            if (bl) {
                Security.loadDefaultProperties(properties);
            }
        } else {
            InputStream inputStream = null;
            try {
                try {
                    inputStream = new BufferedInputStream(new FileInputStream(file));
                    properties.load(inputStream);
                    Enumeration enumeration = properties.keys();
                    while (enumeration.hasMoreElements()) {
                        String string2 = (String)enumeration.nextElement();
                        properties.put(string2, ((String)properties.get(string2)).trim());
                    }
                }
                catch (FileNotFoundException fileNotFoundException) {
                }
                catch (IOException iOException) {}
            }
            catch (Throwable throwable) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    }
                    catch (IOException iOException) {}
                }
                throw throwable;
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
    }

    private static Properties loadSecurityProperties() {
        File file;
        String string = (String)AccessController.doPrivileged(new PriviAction("java.home"));
        String string2 = (String)AccessController.doPrivileged(new PriviAction("java.security.properties"));
        String string3 = (String)AccessController.doPrivileged(new PriviAction("user.dir"));
        Properties properties = new Properties();
        Security.loadSecurityProperties(new StringBuffer(String.valueOf(string)).append("/lib/security/java.security").toString(), properties, true);
        if (string2 == null || string2.length() == 0) {
            return properties;
        }
        String string4 = properties.getProperty("security.overridePropertiesFile");
        if (string4 == null || !string4.equalsIgnoreCase("true")) {
            return properties;
        }
        if (string2.charAt(0) == '=') {
            properties = new Properties();
            string2 = string2.substring(1);
        }
        if ((file = new File(string2)).isAbsolute()) {
            Security.loadSecurityProperties(string2, properties, false);
        } else {
            Security.loadSecurityProperties(new StringBuffer(String.valueOf(string3)).append(File.separator).append(string2).toString(), properties, false);
        }
        return properties;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private static void loadSecurityProviders() {
        Vector vector = providersByPriority;
        synchronized (vector) {
            if (providersLoaded) {
                return;
            }
            providersLoaded = true;
            AccessController.doPrivileged(new Security$1());
        }
    }

    static /* synthetic */ Vector access$0() {
        return providersByPriority;
    }

    static /* synthetic */ int access$1(Provider provider, int n) {
        return Security.insertAt(provider, n);
    }
}

