/*
 * Decompiled with CFR 0.152.
 */
package java.lang;

import java.net.URL;

public class Package {
    private String name;
    private String specificationTitle;
    private String specificationVendor;
    private String specificationVersion;
    private String implementationTitle;
    private String implementationVendor;
    private String implementationVersion;
    private URL sealBase;

    Package(String string, String string2, String string3, String string4, String string5, String string6, String string7, URL uRL) {
        this.name = string;
        this.specificationTitle = string2;
        this.specificationVersion = string3;
        this.specificationVendor = string4;
        this.implementationTitle = string5;
        this.implementationVersion = string6;
        this.implementationVendor = string7;
        this.sealBase = uRL;
    }

    public String getImplementationTitle() {
        return this.implementationTitle;
    }

    public String getImplementationVendor() {
        return this.implementationVendor;
    }

    public String getImplementationVersion() {
        return this.implementationVersion;
    }

    public String getName() {
        return this.name;
    }

    public static Package getPackage(String string) {
        return ClassLoader.getStackClassLoader(1).getPackage(string);
    }

    public static Package[] getPackages() {
        return ClassLoader.getStackClassLoader(1).getPackages();
    }

    public String getSpecificationTitle() {
        return this.specificationTitle;
    }

    public String getSpecificationVendor() {
        return this.specificationVendor;
    }

    public String getSpecificationVersion() {
        return this.specificationVersion;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public boolean isCompatibleWith(String string) {
        int n;
        int n2;
        if (this.specificationVersion == null || string == null || this.specificationVersion.length() == 0 || string.length() == 0) {
            throw new NumberFormatException();
        }
        if (this.specificationVersion.equals(string)) {
            return true;
        }
        int n3 = this.specificationVersion.length();
        int n4 = string.length();
        int n5 = 0;
        int n6 = 0;
        do {
            int n7;
            int n8;
            if ((n8 = this.specificationVersion.indexOf(46, n6)) == -1) {
                n8 = n3;
            }
            if ((n2 = string.indexOf(46, n5)) == -1) {
                n2 = n4;
            }
            if ((n7 = Integer.parseInt(this.specificationVersion.substring(n6, n8))) < (n = Integer.parseInt(string.substring(n5, n2)))) {
                return false;
            }
            if (n7 > n) {
                return true;
            }
            n6 = n8 + 1;
            n5 = n2 + 1;
            if (n5 < n4) continue;
            return true;
        } while (n6 < n3);
        while (n5 < n4) {
            n2 = string.indexOf(46, n5);
            if (n2 == -1) {
                n2 = n4;
            }
            if ((n = Integer.parseInt(string.substring(n5, n2))) > 0) {
                return false;
            }
            n5 = n2 + 1;
        }
        return true;
    }

    public boolean isSealed() {
        return this.sealBase != null;
    }

    public boolean isSealed(URL uRL) {
        return this.sealBase != null && this.sealBase.sameFile(uRL);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("package ");
        stringBuffer.append(this.name);
        if (this.specificationTitle != null && this.specificationTitle.length() > 0) {
            stringBuffer.append(", ");
            stringBuffer.append(this.specificationTitle);
        }
        if (this.specificationVersion != null && this.specificationVersion.length() > 0) {
            stringBuffer.append(", version ");
            stringBuffer.append(this.specificationVersion);
        }
        return stringBuffer.toString();
    }
}

