/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.telephone;

public class EmergencyNumbers {
    public String mainEmergencyNumber;
    public String[] additionalEmergencyNumber;

    public EmergencyNumbers() {
        this.mainEmergencyNumber = null;
        this.additionalEmergencyNumber = null;
    }

    public EmergencyNumbers(String string, String[] stringArray) {
        this.mainEmergencyNumber = string;
        this.additionalEmergencyNumber = stringArray;
    }

    public String getMainEmergencyNumber() {
        return this.mainEmergencyNumber;
    }

    public String[] getAdditionalEmergencyNumber() {
        return this.additionalEmergencyNumber;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(200);
        stringBuffer.append("EmergencyNumbers");
        stringBuffer.append('(');
        stringBuffer.append("mainEmergencyNumber");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.mainEmergencyNumber);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("additionalEmergencyNumber");
        stringBuffer.append('[');
        if (this.additionalEmergencyNumber != null) {
            stringBuffer.append(this.additionalEmergencyNumber.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.additionalEmergencyNumber != null) {
            int n = this.additionalEmergencyNumber.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append('\"');
                stringBuffer.append(this.additionalEmergencyNumber[i2]);
                stringBuffer.append('\"');
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.additionalEmergencyNumber);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

