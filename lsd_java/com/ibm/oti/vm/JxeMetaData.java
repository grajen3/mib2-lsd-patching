/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.vm;

import com.ibm.oti.util.Msg;
import com.ibm.oti.util.Util;
import com.ibm.oti.vm.Jxe;
import com.ibm.oti.vm.JxeException;
import com.ibm.oti.vm.VM;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.UTFDataFormatException;
import java.util.Hashtable;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class JxeMetaData {
    private static final String META_NAME;
    private static final boolean useNative;
    private Hashtable table;
    private boolean bigEndian;
    private int intSize;
    private String jxeName;
    private String startupClass;
    private String uuid;
    private String version;
    private String description;
    private String target;
    private Vector prereqs;
    private int ramClassSize;
    private boolean interpretable = true;
    private boolean posIndependent = false;
    private char[] buf;

    static {
        useNative = VM.useNatives();
    }

    protected JxeMetaData(Jxe jxe) {
        InputStream inputStream = jxe.internalGetResourceAsStream("META-INF/JXE.MF");
        if (inputStream != null) {
            this.initializeTable(inputStream);
        }
    }

    private JxeMetaData() {
    }

    public static JxeMetaData fromFile(File file) {
        ZipFile zipFile = new ZipFile(file);
        ZipEntry zipEntry = zipFile.getEntry("META-INF/JXE.MF");
        if (zipEntry == null) {
            throw new JxeException(Msg.getString("K01c5", file));
        }
        JxeMetaData jxeMetaData = new JxeMetaData();
        jxeMetaData.initializeTable(zipFile.getInputStream(zipEntry));
        return jxeMetaData;
    }

    private String convertToString(byte[] byArray, int n, int n2) {
        try {
            if (useNative) {
                return Util.convertFromUTF8(byArray, n, n2);
            }
            if (n2 > this.buf.length) {
                this.buf = new char[n2];
            }
            return Util.convertUTF8WithBuf(byArray, this.buf, n, n2);
        }
        catch (UTFDataFormatException uTFDataFormatException) {
            return "";
        }
    }

    private void initializeTable(InputStream inputStream) {
        byte[] byArray;
        this.table = new Hashtable();
        try {
            byArray = new byte[inputStream.available()];
            inputStream.read(byArray, 0, byArray.length);
            inputStream.close();
        }
        catch (IOException iOException) {
            return;
        }
        int n = 0;
        if (!useNative) {
            // empty if block
        }
        this.buf = new char[256];
        while (n < byArray.length) {
            int n2 = 0;
            while (byArray[n + n2] != 0) {
                ++n2;
            }
            String string = this.convertToString(byArray, n, n2);
            n += n2 + 1;
            n2 = 0;
            while (byArray[n + n2] != 0) {
                ++n2;
            }
            String string2 = this.convertToString(byArray, n, n2);
            this.setLocalVal(string, string2);
            n += n2 + 2;
            Vector vector = (Vector)this.table.get(string);
            if (vector == null) {
                vector = new Vector();
                this.table.put(string, vector);
            }
            vector.addElement(string2);
        }
        this.buf = null;
    }

    private int parseInt(String string) {
        try {
            return Integer.parseInt(string);
        }
        catch (NumberFormatException numberFormatException) {
            return 0;
        }
    }

    private void setLocalVal(String string, String string2) {
        if (string.equals("bigEndian")) {
            int n = this.parseInt(string2);
            this.bigEndian = n != 0;
        } else if (string.equals("intSize")) {
            this.intSize = this.parseInt(string2);
        } else if (string.equals("jxeName")) {
            this.jxeName = string2;
        } else if (string.equals("startupClass")) {
            if (string2 != null) {
                string2 = string2.replace('/', '.');
            }
            this.startupClass = string2;
        } else if (string.equals("uuid")) {
            this.uuid = string2;
        } else if (string.equals("version")) {
            this.version = string2;
        } else if (string.equals("description")) {
            this.description = string2;
        } else if (string.equals("ramClassSize")) {
            this.ramClassSize = this.parseInt(string2);
        } else if (string.equals("prereq")) {
            if (this.prereqs == null) {
                this.prereqs = new Vector();
            }
            this.prereqs.addElement(string2);
        } else if (string.equals("interpretable")) {
            int n = this.parseInt(string2);
            this.interpretable = n != 0;
        } else if (string.equals("posIndependent")) {
            int n = this.parseInt(string2);
            this.posIndependent = n != 0;
        } else if (string.equals("target")) {
            this.target = string2;
        }
    }

    public Vector getValues(String string) {
        return (Vector)this.table.get(string);
    }

    public boolean isBigEndian() {
        return this.bigEndian;
    }

    public int getIntSize() {
        return this.intSize;
    }

    public String getJxeName() {
        return this.jxeName;
    }

    public String getStartupClass() {
        return this.startupClass;
    }

    public String getUuid() {
        return this.uuid;
    }

    public String getVersion() {
        return this.version;
    }

    public String getDescription() {
        return this.description;
    }

    public int getRamClassSize() {
        return this.ramClassSize;
    }

    public Vector getPrereqs() {
        return this.prereqs;
    }

    public boolean isInterpretable() {
        return this.interpretable;
    }

    public boolean isPositionIndependent() {
        return this.posIndependent;
    }

    public int getRomImageVersion() {
        int n;
        if (this.version != null && (n = this.version.lastIndexOf(46)) > 0) {
            String string = this.version.substring(n);
            return this.parseInt(string);
        }
        return 0;
    }

    public String getTarget() {
        return this.target;
    }
}

