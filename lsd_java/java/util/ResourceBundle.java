/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.util.Msg;
import com.ibm.oti.vm.VM;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle$1;
import java.util.ResourceBundle$2;
import java.util.ResourceBundle$MissingBundle;

public abstract class ResourceBundle {
    protected ResourceBundle parent;
    private Locale locale;
    private static ResourceBundle MISSING = new ResourceBundle$MissingBundle();
    private static ResourceBundle MISSINGBASE = new ResourceBundle$MissingBundle();
    private static Hashtable bootCache = new Hashtable();
    private static Method getCacheMethod = ResourceBundle.initGetCacheMethod();
    static /* synthetic */ Class class$0;
    static /* synthetic */ Class class$1;

    public static final ResourceBundle getBundle(String string) {
        return ResourceBundle.getBundleImpl(string, Locale.getDefault(), VM.callerClassLoader());
    }

    public static final ResourceBundle getBundle(String string, Locale locale) {
        return ResourceBundle.getBundleImpl(string, locale, VM.callerClassLoader());
    }

    public static ResourceBundle getBundle(String string, Locale locale, ClassLoader classLoader) {
        if (classLoader == null) {
            throw new NullPointerException();
        }
        if (string != null) {
            ResourceBundle resourceBundle;
            if (!locale.equals(Locale.getDefault()) && (resourceBundle = ResourceBundle.handleGetBundle(string, new StringBuffer("_").append(locale).toString(), false, classLoader)) != null) {
                return resourceBundle;
            }
            resourceBundle = ResourceBundle.handleGetBundle(string, new StringBuffer("_").append(Locale.getDefault()).toString(), true, classLoader);
            if (resourceBundle != null) {
                return resourceBundle;
            }
            throw new MissingResourceException(Msg.getString("K0405", string, locale), string, "");
        }
        throw new NullPointerException();
    }

    private static ResourceBundle getBundleImpl(String string, Locale locale, ClassLoader classLoader) {
        if (string != null) {
            ResourceBundle resourceBundle;
            String string2;
            if (!locale.equals(Locale.getDefault())) {
                string2 = locale.toString();
                if (string2.length() > 0) {
                    string2 = new StringBuffer("_").append(string2).toString();
                }
                if ((resourceBundle = ResourceBundle.handleGetBundle(string, string2, false, classLoader)) != null) {
                    return resourceBundle;
                }
            }
            if ((string2 = Locale.getDefault().toString()).length() > 0) {
                string2 = new StringBuffer("_").append(string2).toString();
            }
            if ((resourceBundle = ResourceBundle.handleGetBundle(string, string2, true, classLoader)) != null) {
                return resourceBundle;
            }
            throw new MissingResourceException(Msg.getString("K0405", string, locale), string, "");
        }
        throw new NullPointerException();
    }

    public abstract Enumeration getKeys() {
    }

    public Locale getLocale() {
        return this.locale;
    }

    public final Object getObject(String string) {
        ResourceBundle resourceBundle;
        Object object;
        ResourceBundle resourceBundle2 = this;
        do {
            if ((object = resourceBundle2.handleGetObject(string)) != null) {
                return object;
            }
            resourceBundle = resourceBundle2;
        } while ((resourceBundle2 = resourceBundle2.parent) != null);
        object = super.getClass().getName();
        throw new MissingResourceException(Msg.getString("K0406", string, object), (String)object, string);
    }

    public final String getString(String string) {
        return (String)this.getObject(string);
    }

    public final String[] getStringArray(String string) {
        return (String[])this.getObject(string);
    }

    private static ResourceBundle handleGetBundle(String string, String string2, boolean bl, ClassLoader classLoader) {
        Object object;
        Object object2;
        ResourceBundle resourceBundle = null;
        String string3 = new StringBuffer(String.valueOf(string)).append(string2).toString();
        Hashtable hashtable = null;
        if (classLoader == null) {
            hashtable = bootCache;
        } else {
            try {
                hashtable = (Hashtable)getCacheMethod.invoke(classLoader, new Object[0]);
            }
            catch (IllegalAccessException illegalAccessException) {
            }
            catch (InvocationTargetException invocationTargetException) {}
        }
        ResourceBundle resourceBundle2 = (ResourceBundle)hashtable.get(string3);
        if (resourceBundle2 != null) {
            if (resourceBundle2 == MISSINGBASE) {
                return null;
            }
            if (resourceBundle2 == MISSING) {
                if (!bl) {
                    return null;
                }
                String string4 = ResourceBundle.strip(string2);
                if (string4 == null) {
                    return null;
                }
                return ResourceBundle.handleGetBundle(string, string4, bl, classLoader);
            }
            return resourceBundle2;
        }
        try {
            object2 = Class.forName(string3, true, classLoader);
            Class clazz = class$0;
            if (clazz == null) {
                try {
                    clazz = class$0 = Class.forName("java.util.ResourceBundle");
                }
                catch (ClassNotFoundException classNotFoundException) {
                    throw new NoClassDefFoundError(classNotFoundException.getMessage());
                }
            }
            if (clazz.isAssignableFrom((Class)object2)) {
                resourceBundle = (ResourceBundle)((Class)object2).newInstance();
                resourceBundle.setLocale(string2);
            }
        }
        catch (Exception exception) {
        }
        catch (LinkageError linkageError) {}
        if (resourceBundle == null) {
            object2 = string3.replace('.', '/');
            object = null;
            object = (InputStream)AccessController.doPrivileged(new ResourceBundle$1(classLoader, (String)object2));
            if (object != null) {
                try {
                    try {
                        resourceBundle = new PropertyResourceBundle((InputStream)object);
                    }
                    finally {
                        ((InputStream)object).close();
                    }
                    resourceBundle.setLocale(string2);
                }
                catch (IOException iOException) {}
            }
        }
        object2 = ResourceBundle.strip(string2);
        if (resourceBundle != null) {
            if (object2 != null && (object = ResourceBundle.handleGetBundle(string, (String)object2, true, classLoader)) != null) {
                resourceBundle.setParent((ResourceBundle)object);
            }
            hashtable.put(string3, resourceBundle);
            return resourceBundle;
        }
        if (object2 != null && (bl || ((String)object2).length() > 0) && (resourceBundle = ResourceBundle.handleGetBundle(string, (String)object2, bl, classLoader)) != null) {
            hashtable.put(string3, resourceBundle);
            return resourceBundle;
        }
        hashtable.put(string3, bl ? MISSINGBASE : MISSING);
        return null;
    }

    private static Method initGetCacheMethod() {
        return (Method)AccessController.doPrivileged(new ResourceBundle$2());
    }

    protected abstract Object handleGetObject(String string) {
    }

    protected void setParent(ResourceBundle resourceBundle) {
        this.parent = resourceBundle;
    }

    private static String strip(String string) {
        int n = string.lastIndexOf(95);
        if (n != -1) {
            return string.substring(0, n);
        }
        return null;
    }

    private void setLocale(String string) {
        String string2 = "";
        String string3 = "";
        String string4 = "";
        if (string.length() > 1) {
            int n = string.indexOf(95, 1);
            if (n == -1) {
                n = string.length();
            }
            string2 = string.substring(1, n);
            if (n + 1 < string.length()) {
                int n2 = n;
                if ((n = string.indexOf(95, n + 1)) == -1) {
                    n = string.length();
                }
                string3 = string.substring(n2 + 1, n);
                if (n + 1 < string.length()) {
                    string4 = string.substring(n + 1, string.length());
                }
            }
        }
        this.locale = new Locale(string2, string3, string4);
    }
}

