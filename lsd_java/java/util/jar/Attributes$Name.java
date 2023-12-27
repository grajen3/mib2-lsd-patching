/*
 * Decompiled with CFR 0.152.
 */
package java.util.jar;

import com.ibm.oti.util.Msg;

public class Attributes$Name {
    private String name;
    private int hashCode;
    public static final Attributes$Name CLASS_PATH = new Attributes$Name("Class-Path", false);
    public static final Attributes$Name MANIFEST_VERSION = new Attributes$Name("Manifest-Version", false);
    public static final Attributes$Name MAIN_CLASS = new Attributes$Name("Main-Class", false);
    public static final Attributes$Name SIGNATURE_VERSION = new Attributes$Name("Signature-Version", false);
    public static final Attributes$Name CONTENT_TYPE = new Attributes$Name("Content-Type", false);
    public static final Attributes$Name SEALED = new Attributes$Name("Sealed", false);
    public static final Attributes$Name IMPLEMENTATION_TITLE = new Attributes$Name("Implementation-Title", false);
    public static final Attributes$Name IMPLEMENTATION_VERSION = new Attributes$Name("Implementation-Version", false);
    public static final Attributes$Name IMPLEMENTATION_VENDOR = new Attributes$Name("Implementation-Vendor", false);
    public static final Attributes$Name SPECIFICATION_TITLE = new Attributes$Name("Specification-Title", false);
    public static final Attributes$Name SPECIFICATION_VERSION = new Attributes$Name("Specification-Version", false);
    public static final Attributes$Name SPECIFICATION_VENDOR = new Attributes$Name("Specification-Vendor", false);
    public static final Attributes$Name EXTENSION_LIST = new Attributes$Name("Extension-List", false);
    public static final Attributes$Name EXTENSION_NAME = new Attributes$Name("Extension-Name", false);
    public static final Attributes$Name EXTENSION_INSTALLATION = new Attributes$Name("Extension-Installation", false);
    public static final Attributes$Name IMPLEMENTATION_VENDOR_ID = new Attributes$Name("Implementation-Vendor-Id", false);
    public static final Attributes$Name IMPLEMENTATION_URL = new Attributes$Name("Implementation-URL", false);
    private static final int NAME_MAX_LENGTH;

    /*
     * Unable to fully structure code
     */
    public Attributes$Name(String var1_1) {
        super();
        var2_2 = var1_1.length();
        if (var2_2 != 0 && var2_2 <= 70) ** GOTO lbl8
        throw new IllegalArgumentException(Msg.getString("K0404", Integer.toString(70), var1_1));
lbl-1000:
        // 1 sources

        {
            var3_3 = var1_1.charAt(var2_2);
            if (var3_3 >= 'a' && var3_3 <= 'z' || var3_3 >= 'A' && var3_3 <= 'Z' || var3_3 == '_' || var3_3 == '-' || var3_3 >= '0' && var3_3 <= '9') continue;
            throw new IllegalArgumentException(var1_1);
lbl8:
            // 2 sources

            ** while (--var2_2 >= 0)
        }
lbl9:
        // 1 sources

        this.name = var1_1;
    }

    Attributes$Name(String string, boolean bl) {
        this.name = string;
    }

    public String toString() {
        return this.name;
    }

    public boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        return object.getClass() == super.getClass() && this.name.equalsIgnoreCase(((Attributes$Name)object).name);
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.name.toLowerCase().hashCode();
        }
        return this.hashCode;
    }
}

