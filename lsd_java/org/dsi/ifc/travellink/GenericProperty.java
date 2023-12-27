/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.travellink;

import org.dsi.ifc.global.ResourceLocator;
import org.dsi.ifc.travellink.TravelLinkDate;

public class GenericProperty {
    public int key;
    public String[] valuesString;
    public int[] valuesInt;
    public long[] valuesLong;
    public float[] valuesFloat;
    public boolean[] valuesBoolean;
    public ResourceLocator[] valuesResourceLocator;
    public TravelLinkDate[] valuesDate;

    public GenericProperty() {
        this.key = 0;
        this.valuesString = null;
        this.valuesInt = null;
        this.valuesLong = null;
        this.valuesFloat = null;
        this.valuesBoolean = null;
        this.valuesResourceLocator = null;
        this.valuesDate = null;
    }

    public GenericProperty(int n, String[] stringArray, int[] nArray, long[] lArray, float[] fArray, boolean[] blArray, ResourceLocator[] resourceLocatorArray, TravelLinkDate[] travelLinkDateArray) {
        this.key = n;
        this.valuesString = stringArray;
        this.valuesInt = nArray;
        this.valuesLong = lArray;
        this.valuesFloat = fArray;
        this.valuesBoolean = blArray;
        this.valuesResourceLocator = resourceLocatorArray;
        this.valuesDate = travelLinkDateArray;
    }

    public int getKey() {
        return this.key;
    }

    public String[] getValuesString() {
        return this.valuesString;
    }

    public int[] getValuesInt() {
        return this.valuesInt;
    }

    public long[] getValuesLong() {
        return this.valuesLong;
    }

    public float[] getValuesFloat() {
        return this.valuesFloat;
    }

    public boolean[] getValuesBoolean() {
        return this.valuesBoolean;
    }

    public ResourceLocator[] getValuesResourceLocator() {
        return this.valuesResourceLocator;
    }

    public TravelLinkDate[] getValuesDate() {
        return this.valuesDate;
    }

    public String toString() {
        int n;
        int n2;
        int n3;
        StringBuffer stringBuffer = new StringBuffer(450);
        stringBuffer.append("GenericProperty");
        stringBuffer.append('(');
        stringBuffer.append("key");
        stringBuffer.append('=');
        stringBuffer.append(this.key);
        stringBuffer.append(',');
        stringBuffer.append("valuesString");
        stringBuffer.append('[');
        if (this.valuesString != null) {
            stringBuffer.append(this.valuesString.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.valuesString != null) {
            n3 = this.valuesString.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append('\"');
                stringBuffer.append(this.valuesString[n]);
                stringBuffer.append('\"');
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.valuesString);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("valuesInt");
        stringBuffer.append('[');
        if (this.valuesInt != null) {
            stringBuffer.append(this.valuesInt.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.valuesInt != null) {
            n3 = this.valuesInt.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.valuesInt[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.valuesInt);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("valuesLong");
        stringBuffer.append('[');
        if (this.valuesLong != null) {
            stringBuffer.append(this.valuesLong.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.valuesLong != null) {
            n3 = this.valuesLong.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.valuesLong[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.valuesLong);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("valuesFloat");
        stringBuffer.append('[');
        if (this.valuesFloat != null) {
            stringBuffer.append(this.valuesFloat.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.valuesFloat != null) {
            n3 = this.valuesFloat.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.valuesFloat[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.valuesFloat);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("valuesBoolean");
        stringBuffer.append('[');
        if (this.valuesBoolean != null) {
            stringBuffer.append(this.valuesBoolean.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.valuesBoolean != null) {
            n3 = this.valuesBoolean.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.valuesBoolean[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.valuesBoolean);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("valuesResourceLocator");
        stringBuffer.append('[');
        if (this.valuesResourceLocator != null) {
            stringBuffer.append(this.valuesResourceLocator.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.valuesResourceLocator != null) {
            n3 = this.valuesResourceLocator.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.valuesResourceLocator[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.valuesResourceLocator);
        }
        stringBuffer.append('}');
        stringBuffer.append(',');
        stringBuffer.append("valuesDate");
        stringBuffer.append('[');
        if (this.valuesDate != null) {
            stringBuffer.append(this.valuesDate.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.valuesDate != null) {
            n3 = this.valuesDate.length;
            n2 = n3 - 1;
            for (n = 0; n < n3; ++n) {
                stringBuffer.append(this.valuesDate[n]);
                if (n >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.valuesDate);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

