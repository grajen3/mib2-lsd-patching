/*
 * Decompiled with CFR 0.152.
 */
package java.util;

import com.ibm.oti.locale.Country;
import com.ibm.oti.locale.Language;
import com.ibm.oti.util.PriviAction;
import com.ibm.oti.vm.JxeUtil;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInputStream$GetField;
import java.io.ObjectOutputStream;
import java.io.ObjectOutputStream$PutField;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.security.AccessController;
import java.util.Enumeration;
import java.util.Locale$1;
import java.util.Locale$2;
import java.util.MissingResourceException;
import java.util.PropertyPermission;
import java.util.ResourceBundle;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class Locale
implements Cloneable,
Serializable {
    private static final long serialVersionUID;
    private transient String countryCode;
    private transient String languageCode;
    private transient String variantCode;
    private static Locale[] availableLocales;
    private static Locale defaultLocale;
    public static final Locale CANADA;
    public static final Locale CANADA_FRENCH;
    public static final Locale CHINA;
    public static final Locale CHINESE;
    public static final Locale ENGLISH;
    public static final Locale FRANCE;
    public static final Locale FRENCH;
    public static final Locale GERMAN;
    public static final Locale GERMANY;
    public static final Locale ITALIAN;
    public static final Locale ITALY;
    public static final Locale JAPAN;
    public static final Locale JAPANESE;
    public static final Locale KOREA;
    public static final Locale KOREAN;
    public static final Locale PRC;
    public static final Locale SIMPLIFIED_CHINESE;
    public static final Locale TAIWAN;
    public static final Locale TRADITIONAL_CHINESE;
    public static final Locale UK;
    public static final Locale US;
    private static final PropertyPermission setLocalePermission;
    private static final ObjectStreamField[] serialPersistentFields;
    static /* synthetic */ Class class$0;

    static {
        defaultLocale = new Locale();
        CANADA = new Locale("en", "CA");
        CANADA_FRENCH = new Locale("fr", "CA");
        CHINA = new Locale("zh", "CN");
        CHINESE = new Locale("zh", "");
        ENGLISH = new Locale("en", "");
        FRANCE = new Locale("fr", "FR");
        FRENCH = new Locale("fr", "");
        GERMAN = new Locale("de", "");
        GERMANY = new Locale("de", "DE");
        ITALIAN = new Locale("it", "");
        ITALY = new Locale("it", "IT");
        JAPAN = new Locale("ja", "JP");
        JAPANESE = new Locale("ja", "");
        KOREA = new Locale("ko", "KR");
        KOREAN = new Locale("ko", "");
        PRC = new Locale("zh", "CN");
        SIMPLIFIED_CHINESE = new Locale("zh", "CN");
        TAIWAN = new Locale("zh", "TW");
        TRADITIONAL_CHINESE = new Locale("zh", "TW");
        UK = new Locale("en", "GB");
        US = new Locale("en", "US");
        setLocalePermission = new PropertyPermission("user.language", "write");
        String string = (String)AccessController.doPrivileged(new PriviAction("user.language", "en"));
        String string2 = (String)AccessController.doPrivileged(new PriviAction("user.country", "US"));
        String string3 = (String)AccessController.doPrivileged(new PriviAction("user.variant", ""));
        defaultLocale = new Locale(string, string2, string3);
        ObjectStreamField[] objectStreamFieldArray = new ObjectStreamField[4];
        Class clazz = class$0;
        if (clazz == null) {
            try {
                clazz = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[0] = new ObjectStreamField("country", clazz);
        objectStreamFieldArray[1] = new ObjectStreamField("hashcode", Integer.TYPE);
        Class clazz2 = class$0;
        if (clazz2 == null) {
            try {
                clazz2 = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[2] = new ObjectStreamField("language", clazz2);
        Class clazz3 = class$0;
        if (clazz3 == null) {
            try {
                clazz3 = class$0 = Class.forName("java.lang.String");
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new NoClassDefFoundError(classNotFoundException.getMessage());
            }
        }
        objectStreamFieldArray[3] = new ObjectStreamField("variant", clazz3);
        serialPersistentFields = objectStreamFieldArray;
    }

    private Locale() {
        this.languageCode = "en";
        this.countryCode = "US";
        this.variantCode = "";
    }

    public Locale(String string) {
        this(string, "", "");
    }

    public Locale(String string, String string2) {
        this(string, string2, "");
    }

    public Locale(String string, String string2, String string3) {
        this.languageCode = string.toLowerCase();
        if (this.languageCode.equals("he")) {
            this.languageCode = "iw";
        } else if (this.languageCode.equals("id")) {
            this.languageCode = "in";
        } else if (this.languageCode.equals("yi")) {
            this.languageCode = "ji";
        }
        this.countryCode = string2.toUpperCase();
        if (string3 == null) {
            throw new NullPointerException();
        }
        this.variantCode = string3;
    }

    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            return null;
        }
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object instanceof Locale) {
            Locale locale = (Locale)object;
            return this.languageCode.equals(locale.languageCode) && this.countryCode.equals(locale.countryCode) && this.variantCode.equals(locale.variantCode);
        }
        return false;
    }

    static Locale[] find(String string) {
        String[] stringArray;
        Locale[] localeArray;
        int n = string.lastIndexOf(47);
        String string2 = string.substring(0, n + 1);
        String string3 = string.substring(n + 1, string.length());
        Locale$1 locale$1 = new Locale$1(string3);
        Vector vector = new Vector();
        StringTokenizer stringTokenizer = new StringTokenizer(System.getProperty("com.ibm.oti.system.class.path", ""), System.getProperty("path.separator", ";"));
        while (stringTokenizer.hasMoreTokens()) {
            Object object;
            Object object2;
            localeArray = stringTokenizer.nextToken();
            String[] stringArray2 = JxeUtil.getClassList((String)localeArray);
            if (stringArray2 != null && stringArray2.length > 0) {
                int n2 = 0;
                while (n2 < stringArray2.length) {
                    object2 = new StringBuffer(String.valueOf(stringArray2[n2])).append(".class").toString();
                    if (((String)object2).startsWith(string)) {
                        vector.addElement(object2);
                    }
                    ++n2;
                }
                continue;
            }
            File file = new File((String)localeArray);
            if (!file.exists()) continue;
            if (file.isDirectory()) {
                try {
                    object = file.getCanonicalPath();
                    object2 = ((String)object).charAt(((String)object).length() - 1) == File.separatorChar ? new File(new StringBuffer(String.valueOf(object)).append(string2).toString()) : new File(new StringBuffer(String.valueOf(object)).append(File.separatorChar).append(string2).toString());
                    if (!((File)object2).isDirectory()) continue;
                    stringArray = ((File)object2).list(locale$1);
                    int n3 = 0;
                    while (n3 < stringArray.length) {
                        vector.addElement(stringArray[n3]);
                        ++n3;
                    }
                }
                catch (IOException iOException) {}
                continue;
            }
            try {
                object2 = new ZipFile(file);
                object = ((ZipFile)object2).entries();
                while (object.hasMoreElements()) {
                    stringArray = ((ZipEntry)object.nextElement()).getName();
                    if (!stringArray.startsWith(string) || !stringArray.endsWith(".class")) continue;
                    vector.addElement(stringArray);
                }
                ((ZipFile)object2).close();
            }
            catch (IOException iOException) {}
        }
        localeArray = new Locale[vector.size()];
        int n4 = 0;
        while (n4 < vector.size()) {
            int n5;
            String string4 = (String)vector.elementAt(n4);
            int n6 = (string4 = string4.substring(0, string4.length() - 6)).indexOf(95, (n5 = string4.indexOf(95)) + 1);
            if (n6 == -1) {
                localeArray[n4] = new Locale(string4.substring(n5 + 1, string4.length()), "");
            } else {
                String string5;
                stringArray = string4.substring(n5 + 1, n6);
                n5 = string4.indexOf(95, n6 + 1);
                if (n5 == -1) {
                    string5 = "";
                    n5 = string4.length();
                } else {
                    string5 = string4.substring(n5 + 1, string4.length());
                }
                String string6 = string4.substring(n6 + 1, n5);
                localeArray[n4] = new Locale((String)stringArray, string6, string5);
            }
            ++n4;
        }
        return localeArray;
    }

    public static Locale[] getAvailableLocales() {
        if (availableLocales == null) {
            availableLocales = (Locale[])AccessController.doPrivileged(new Locale$2());
        }
        return (Locale[])availableLocales.clone();
    }

    public String getCountry() {
        return this.countryCode;
    }

    public static Locale getDefault() {
        return defaultLocale;
    }

    public final String getDisplayCountry() {
        return this.getDisplayCountry(Locale.getDefault());
    }

    public String getDisplayCountry(Locale locale) {
        if (this.countryCode.length() == 0) {
            return this.countryCode;
        }
        try {
            ResourceBundle resourceBundle = Locale.getBundle("Country", locale);
            String string = (String)resourceBundle.handleGetObject(this.countryCode);
            if (string != null) {
                return string;
            }
            if (locale != Locale.getDefault()) {
                resourceBundle = Locale.getBundle("Country", Locale.getDefault());
            }
            return resourceBundle.getString(this.countryCode);
        }
        catch (MissingResourceException missingResourceException) {
            return this.countryCode;
        }
    }

    public final String getDisplayLanguage() {
        return this.getDisplayLanguage(Locale.getDefault());
    }

    public String getDisplayLanguage(Locale locale) {
        if (this.languageCode.length() == 0) {
            return this.languageCode;
        }
        try {
            ResourceBundle resourceBundle = Locale.getBundle("Language", locale);
            String string = (String)resourceBundle.handleGetObject(this.languageCode);
            if (string != null) {
                return string;
            }
            if (locale != Locale.getDefault()) {
                resourceBundle = Locale.getBundle("Language", Locale.getDefault());
            }
            return resourceBundle.getString(this.languageCode);
        }
        catch (MissingResourceException missingResourceException) {
            return this.languageCode;
        }
    }

    public final String getDisplayName() {
        return this.getDisplayName(Locale.getDefault());
    }

    public String getDisplayName(Locale locale) {
        int n = 0;
        StringBuffer stringBuffer = new StringBuffer();
        if (this.languageCode.length() > 0) {
            stringBuffer.append(this.getDisplayLanguage(locale));
            ++n;
        }
        if (this.countryCode.length() > 0) {
            if (n == 1) {
                stringBuffer.append(" (");
            }
            stringBuffer.append(this.getDisplayCountry(locale));
            ++n;
        }
        if (this.variantCode.length() > 0) {
            if (n == 1) {
                stringBuffer.append(" (");
            } else if (n == 2) {
                stringBuffer.append(",");
            }
            stringBuffer.append(this.getDisplayVariant(locale));
            ++n;
        }
        if (n > 1) {
            stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }

    public final String getDisplayVariant() {
        return this.getDisplayVariant(Locale.getDefault());
    }

    public String getDisplayVariant(Locale locale) {
        ResourceBundle resourceBundle;
        if (this.variantCode.length() == 0) {
            return this.variantCode;
        }
        try {
            resourceBundle = Locale.getBundle("Variant", locale);
        }
        catch (MissingResourceException missingResourceException) {
            return this.variantCode.replace('_', ',');
        }
        StringBuffer stringBuffer = new StringBuffer();
        StringTokenizer stringTokenizer = new StringTokenizer(this.variantCode, "_");
        while (stringTokenizer.hasMoreTokens()) {
            String string;
            String string2 = stringTokenizer.nextToken();
            try {
                string = resourceBundle.getString(string2);
            }
            catch (MissingResourceException missingResourceException) {
                string = string2;
            }
            stringBuffer.append(string);
            if (!stringTokenizer.hasMoreTokens()) continue;
            stringBuffer.append(',');
        }
        return stringBuffer.toString();
    }

    public String getISO3Country() {
        if (this.countryCode.length() == 0) {
            return "";
        }
        ResourceBundle resourceBundle = Locale.getBundle("ISO3Countries", this);
        return resourceBundle.getString(this.countryCode);
    }

    public String getISO3Language() {
        if (this.languageCode.length() == 0) {
            return "";
        }
        ResourceBundle resourceBundle = Locale.getBundle("ISO3Languages", this);
        return resourceBundle.getString(this.languageCode);
    }

    public static String[] getISOCountries() {
        Country country = new Country();
        Enumeration enumeration = country.getKeys();
        int n = country.table.size();
        String[] stringArray = new String[n];
        int n2 = 0;
        while (enumeration.hasMoreElements()) {
            String string = (String)enumeration.nextElement();
            stringArray[n2++] = string;
        }
        return stringArray;
    }

    public static String[] getISOLanguages() {
        Language language = new Language();
        Enumeration enumeration = language.getKeys();
        String[] stringArray = new String[language.table.size()];
        int n = 0;
        while (enumeration.hasMoreElements()) {
            stringArray[n++] = (String)enumeration.nextElement();
        }
        return stringArray;
    }

    public String getLanguage() {
        return this.languageCode;
    }

    public String getVariant() {
        return this.variantCode;
    }

    public synchronized int hashCode() {
        return this.countryCode.hashCode() + this.languageCode.hashCode() + this.variantCode.hashCode();
    }

    public static synchronized void setDefault(Locale locale) {
        if (locale != null) {
            SecurityManager securityManager = System.getSecurityManager();
            if (securityManager != null) {
                securityManager.checkPermission(setLocalePermission);
            }
        } else {
            throw new NullPointerException();
        }
        defaultLocale = locale;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.languageCode);
        if (this.countryCode.length() > 0) {
            stringBuffer.append('_');
            stringBuffer.append(this.countryCode);
        }
        if (this.variantCode.length() > 0 && stringBuffer.length() > 0) {
            if (this.countryCode.length() == 0) {
                stringBuffer.append("__");
            } else {
                stringBuffer.append('_');
            }
            stringBuffer.append(this.variantCode);
        }
        return stringBuffer.toString();
    }

    static ResourceBundle getBundle(String string, Locale locale) {
        return (ResourceBundle)AccessController.doPrivileged(new PriviAction(new StringBuffer("com.ibm.oti.locale.").append(string).toString(), locale));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        ObjectOutputStream$PutField objectOutputStream$PutField = objectOutputStream.putFields();
        objectOutputStream$PutField.put("country", this.countryCode);
        objectOutputStream$PutField.put("hashcode", -1);
        objectOutputStream$PutField.put("language", this.languageCode);
        objectOutputStream$PutField.put("variant", this.variantCode);
        objectOutputStream.writeFields();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        ObjectInputStream$GetField objectInputStream$GetField = objectInputStream.readFields();
        this.countryCode = (String)objectInputStream$GetField.get("country", "");
        this.languageCode = (String)objectInputStream$GetField.get("language", "");
        this.variantCode = (String)objectInputStream$GetField.get("variant", "");
    }
}

