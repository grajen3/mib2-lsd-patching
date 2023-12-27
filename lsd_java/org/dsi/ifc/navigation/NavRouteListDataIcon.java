/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class NavRouteListDataIcon {
    public int type;
    public int criteria1;
    public int criteria2;
    public int[] iconDecoratorInformation;

    public NavRouteListDataIcon() {
        this.type = 0;
        this.criteria1 = 0;
        this.criteria2 = 0;
        this.iconDecoratorInformation = null;
    }

    public NavRouteListDataIcon(int n, int n2, int n3, int[] nArray) {
        this.type = n;
        this.criteria1 = n2;
        this.criteria2 = n3;
        this.iconDecoratorInformation = nArray;
    }

    public int getType() {
        return this.type;
    }

    public int getCriteria1() {
        return this.criteria1;
    }

    public int getCriteria2() {
        return this.criteria2;
    }

    public int[] getIconDecoratorInformation() {
        return this.iconDecoratorInformation;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(250);
        stringBuffer.append("NavRouteListDataIcon");
        stringBuffer.append('(');
        stringBuffer.append("type");
        stringBuffer.append('=');
        stringBuffer.append(this.type);
        stringBuffer.append(',');
        stringBuffer.append("criteria1");
        stringBuffer.append('=');
        stringBuffer.append(this.criteria1);
        stringBuffer.append(',');
        stringBuffer.append("criteria2");
        stringBuffer.append('=');
        stringBuffer.append(this.criteria2);
        stringBuffer.append(',');
        stringBuffer.append("iconDecoratorInformation");
        stringBuffer.append('[');
        if (this.iconDecoratorInformation != null) {
            stringBuffer.append(this.iconDecoratorInformation.length);
        }
        stringBuffer.append(']');
        stringBuffer.append('=');
        stringBuffer.append('{');
        if (this.iconDecoratorInformation != null) {
            int n = this.iconDecoratorInformation.length;
            int n2 = n - 1;
            for (int i2 = 0; i2 < n; ++i2) {
                stringBuffer.append(this.iconDecoratorInformation[i2]);
                if (i2 >= n2) continue;
                stringBuffer.append(',');
            }
        } else {
            stringBuffer.append(this.iconDecoratorInformation);
        }
        stringBuffer.append('}');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

