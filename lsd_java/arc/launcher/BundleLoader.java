/*
 * Decompiled with CFR 0.152.
 */
package arc.launcher;

import arc.launcher.BundleLoader$1;
import arc.launcher.ErrorHelper;
import arc.launcher.JarValidator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Properties;
import java.util.StringTokenizer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class BundleLoader
implements BundleActivator {
    public static boolean DEBUG = false;
    private static final String STANDARD_BUNDLESTORE;
    public static final String PROP_KEY_ARC_DEBUG;
    public static final String PROP_KEY_CONFIG_FILE;
    public static final String PROP_KEY_LAUNCHERCLASS;
    public static final String PROP_KEY_BUNDLESTORE;
    public static final String PROP_KEY_JAR_VALIDATOR;
    private static final String DEFAULT_CONFIG_FILE;
    private static final String DEFAULT_LAUNCHERCLASS;
    private static final String DEFAULT_BUNDLESTORE;
    private static final String DEFAULT_JAR_VALIDATOR;
    private static final String DEBUG_PREFIX_STRING;
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;
    static /* synthetic */ Class class$2;

    private static int compareVersion(Object[] objectArray, Object[] objectArray2) {
        int n = ((Integer)objectArray[0]).compareTo((Integer)objectArray2[0]);
        if (n != 0) {
            return n;
        }
        n = ((Integer)objectArray[1]).compareTo((Integer)objectArray2[1]);
        if (n != 0) {
            return n;
        }
        n = ((Integer)objectArray[2]).compareTo((Integer)objectArray2[2]);
        if (n != 0) {
            return n;
        }
        return ((String)objectArray[3]).compareTo((String)objectArray2[3]);
    }

    private static Object[] getVersionElements(String string) {
        Object[] objectArray = new Object[]{new Integer(0), new Integer(0), new Integer(0), ""};
        if (string == null || string.length() == 0) {
            return objectArray;
        }
        StringTokenizer stringTokenizer = new StringTokenizer(string, ".");
        int n = 0;
        while (stringTokenizer.hasMoreTokens() && n < 4) {
            String string2 = stringTokenizer.nextToken();
            if (n < 3) {
                try {
                    objectArray[n++] = new Integer(string2);
                    continue;
                }
                catch (Exception exception) {
                    break;
                }
            }
            objectArray[n++] = string2;
        }
        return objectArray;
    }

    private static HashMap collectJars(String string, boolean bl) {
        HashMap hashMap = new HashMap();
        String string2 = string;
        File file = new File(string2);
        if (string2.indexOf(37) != -1 && !file.exists()) {
            return hashMap;
        }
        if (file.isDirectory()) {
            URL[] uRLArray = BundleLoader.getLocationURLs(file);
            int n = 0;
            while (n < uRLArray.length) {
                File file2 = new File(uRLArray[n].getPath());
                if (bl && !JarValidator.isSignedJarFileValid(file2)) {
                    ErrorHelper.println(new StringBuffer(String.valueOf(file2.getAbsolutePath())).append(" is not valid").toString());
                    file2.delete();
                } else {
                    String string3 = file2.getName();
                    hashMap.put(string3, uRLArray[n]);
                }
                ++n;
            }
        }
        return hashMap;
    }

    private static URL[] collectBundleLocations(String string, boolean bl) {
        if (string == null || string.length() == 0) {
            return null;
        }
        try {
            string = string.trim();
            HashMap hashMap = BundleLoader.collectJars(string, bl);
            List list = BundleLoader.compareBundles(hashMap.keySet().iterator());
            if (!"/mnt/app/eso/bundles".equals(string)) {
                HashMap hashMap2 = BundleLoader.collectJars("/mnt/app/eso/bundles", false);
                List list2 = BundleLoader.compareBundles(hashMap2.keySet().iterator());
                hashMap = BundleLoader.convertListintoHMap(hashMap, list);
                hashMap2 = BundleLoader.convertListintoHMap(hashMap2, list2);
                HashMap hashMap3 = new HashMap(Math.max(hashMap.size(), hashMap2.size()));
                hashMap3.putAll(hashMap2);
                hashMap3.putAll(hashMap);
                List list3 = BundleLoader.compareBundles(hashMap3.keySet().iterator());
                hashMap3 = BundleLoader.convertListintoHMap(hashMap3, list3);
                URL[] uRLArray = new URL[hashMap3.size()];
                Iterator iterator = hashMap3.values().iterator();
                int n = 0;
                while (iterator.hasNext()) {
                    uRLArray[n] = (URL)iterator.next();
                    ++n;
                }
                return uRLArray;
            }
            HashMap hashMap4 = BundleLoader.convertListintoHMap(hashMap, list);
            URL[] uRLArray = new URL[hashMap4.size()];
            Iterator iterator = hashMap4.values().iterator();
            int n = 0;
            while (iterator.hasNext()) {
                uRLArray[n] = (URL)iterator.next();
                ++n;
            }
            return uRLArray;
        }
        catch (MalformedURLException malformedURLException) {
            ErrorHelper.printStackTrace(malformedURLException);
            return null;
        }
    }

    private static List compareBundles(Iterator iterator) {
        Object object;
        Object object2;
        HashMap hashMap = new HashMap(20);
        while (iterator.hasNext()) {
            object2 = (String)iterator.next();
            int n = ((String)object2).indexOf(95);
            if (n != -1) {
                Object[] objectArray;
                if (n == 0) continue;
                object = ((String)object2).substring(n + 1, ((String)object2).length() - 4);
                String string = ((String)object2).substring(0, n);
                String string2 = (String)hashMap.get(string);
                if (string2 == null) {
                    hashMap.put(string, object);
                    continue;
                }
                Object[] objectArray2 = BundleLoader.getVersionElements(string2);
                int n2 = BundleLoader.compareVersion(objectArray2, objectArray = BundleLoader.getVersionElements((String)object));
                if (n2 >= 0) continue;
                hashMap.put(string, object);
                continue;
            }
            object = ((String)object2).substring(0, ((String)object2).length() - 4);
            if (hashMap.containsKey(object)) continue;
            hashMap.put(object, null);
        }
        object2 = new ArrayList(hashMap.size());
        Iterator iterator2 = hashMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            object = (Map$Entry)iterator2.next();
            if (object.getValue() == null) {
                ((ArrayList)object2).add(new StringBuffer().append(object.getKey()).append(".jar").toString());
                continue;
            }
            ((ArrayList)object2).add(new StringBuffer(String.valueOf(String.valueOf(object.getKey()))).append('_').append(String.valueOf(object.getValue())).append(".jar").toString());
        }
        return object2;
    }

    private static HashMap convertListintoHMap(HashMap hashMap, List list) {
        HashMap hashMap2 = new HashMap(list.size());
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            hashMap2.put(string, hashMap.get(string));
        }
        return hashMap2;
    }

    private static URL[] getLocationURLs(File file) {
        return BundleLoader.getLocationURLs(file, new String[]{".jar"});
    }

    private static URL[] getLocationURLs(File file, String[] stringArray) {
        URL[] uRLArray = new URL[]{};
        if (!file.exists()) {
            return uRLArray;
        }
        if (!file.isDirectory()) {
            uRLArray = new URL[1];
            String string = file.getPath();
            int n = 0;
            while (n < stringArray.length) {
                if (string.toLowerCase().endsWith(stringArray[n])) {
                    uRLArray[0] = file.toURL();
                    break;
                }
                ++n;
            }
            return uRLArray;
        }
        File[] fileArray = file.listFiles(new BundleLoader$1(stringArray));
        if (fileArray != null) {
            uRLArray = new URL[fileArray.length];
            int n = 0;
            while (n < fileArray.length) {
                uRLArray[n] = fileArray[n].toURL();
                ++n;
            }
        } else {
            uRLArray = new URL[]{};
        }
        return uRLArray;
    }

    @Override
    public void start(BundleContext bundleContext) {
        if (System.getProperty("arc.debug") != null) {
            DEBUG = true;
        }
        ErrorHelper.setDebugPrefix("[arc.launcher] ");
        Properties properties = this.loadProperties();
        URL[] uRLArray = null;
        try {
            uRLArray = BundleLoader.collectBundleLocations(properties.getProperty("arc.bundle.store"), Boolean.getBoolean(properties.getProperty("arc.jar.validator")));
        }
        catch (Exception exception) {
            ErrorHelper.println("Error while collecting jars.");
            ErrorHelper.printStackTrace(exception);
        }
        this.startArc(bundleContext, properties, uRLArray);
    }

    private void startArc(BundleContext bundleContext, Properties properties, URL[] uRLArray) {
        if (uRLArray != null && uRLArray.length > 0) {
            URLClassLoader uRLClassLoader = new URLClassLoader(uRLArray, super.getClass().getClassLoader());
            try {
                Class clazz = uRLClassLoader.loadClass(properties.getProperty("launcherClass"));
                Class[] classArray = new Class[3];
                Class clazz2 = class$0;
                if (clazz2 == null) {
                    try {
                        clazz2 = class$0 = Class.forName("org.osgi.framework.BundleContext");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray[0] = clazz2;
                Class clazz3 = class$1;
                if (clazz3 == null) {
                    try {
                        clazz3 = class$1 = Class.forName("java.util.Dictionary");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray[1] = clazz3;
                Class clazz4 = class$2;
                if (clazz4 == null) {
                    try {
                        clazz4 = class$2 = Class.forName("[Ljava.net.URL;");
                    }
                    catch (ClassNotFoundException classNotFoundException) {
                        throw new NoClassDefFoundError(classNotFoundException.getMessage());
                    }
                }
                classArray[2] = clazz4;
                Method method = clazz.getMethod("start", classArray);
                Object object = clazz.newInstance();
                method.invoke(object, new Object[]{bundleContext, properties, uRLArray});
            }
            catch (Throwable throwable) {
                ErrorHelper.println(new StringBuffer("Error while starting: ").append(properties.getProperty("launcherClass")).toString());
                ErrorHelper.printStackTrace(throwable);
            }
        }
    }

    private Properties loadProperties() {
        String string = System.getProperty("arc.config", "/mnt/ota/app/config.ini");
        Properties properties = new Properties();
        properties.put("launcherClass", "arc.internal.ArcStarter");
        properties.put("arc.bundle.store", "/mnt/ota/app/bundles");
        properties.put("arc.jar.validator", "true");
        Properties properties2 = new Properties();
        properties2.putAll(properties);
        File file = new File(string);
        if (file.exists()) {
            properties2.put("arc.config", file.getAbsolutePath());
            FileInputStream fileInputStream = null;
            try {
                try {
                    fileInputStream = new FileInputStream(file);
                    properties2.load(fileInputStream);
                }
                catch (IOException iOException) {}
            }
            catch (Throwable throwable) {
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    }
                    catch (IOException iOException) {}
                }
                throw throwable;
            }
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                }
                catch (IOException iOException) {}
            }
        }
        return properties2;
    }

    @Override
    public void stop(BundleContext bundleContext) {
    }

    public String toString() {
        return "1.0.2";
    }
}

