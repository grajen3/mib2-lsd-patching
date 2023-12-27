/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.navigation;

public class Category {
    public int categoryUid;
    public int iconIndex;
    public int subIconIndex;
    public boolean parent;
    public boolean visible;
    public boolean audible;
    public boolean personal;
    public boolean monitored;
    public String description;
    public int additionalFlags;
    public int parentId;

    public Category() {
        this.categoryUid = 0;
        this.iconIndex = 0;
        this.subIconIndex = 0;
        this.parent = false;
        this.visible = true;
        this.audible = false;
        this.personal = false;
        this.monitored = false;
        this.description = "";
        this.additionalFlags = 0;
        this.parentId = 0;
    }

    public Category(int n, int n2, int n3, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, String string, int n4) {
        this.categoryUid = n;
        this.iconIndex = n2;
        this.subIconIndex = n3;
        this.parent = bl;
        this.visible = bl2;
        this.audible = bl3;
        this.personal = bl4;
        this.monitored = bl5;
        this.description = string;
        this.additionalFlags = n4;
        this.parentId = 0;
    }

    public Category(int n, int n2, int n3, boolean bl, boolean bl2, boolean bl3, boolean bl4, boolean bl5, String string, int n4, int n5) {
        this.categoryUid = n;
        this.iconIndex = n2;
        this.subIconIndex = n3;
        this.parent = bl;
        this.visible = bl2;
        this.audible = bl3;
        this.personal = bl4;
        this.monitored = bl5;
        this.description = string;
        this.additionalFlags = n4;
        this.parentId = n5;
    }

    public int getCategoryUid() {
        return this.categoryUid;
    }

    public int getIconIndex() {
        return this.iconIndex;
    }

    public int getSubIconIndex() {
        return this.subIconIndex;
    }

    public boolean isParent() {
        return this.parent;
    }

    public boolean isVisible() {
        return this.visible;
    }

    public boolean isAudible() {
        return this.audible;
    }

    public boolean isPersonal() {
        return this.personal;
    }

    public boolean isMonitored() {
        return this.monitored;
    }

    public String getDescription() {
        return this.description;
    }

    public int getAdditionalFlags() {
        return this.additionalFlags;
    }

    public int getParentId() {
        return this.parentId;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(550);
        stringBuffer.append("Category");
        stringBuffer.append('(');
        stringBuffer.append("categoryUid");
        stringBuffer.append('=');
        stringBuffer.append(this.categoryUid);
        stringBuffer.append(',');
        stringBuffer.append("iconIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.iconIndex);
        stringBuffer.append(',');
        stringBuffer.append("subIconIndex");
        stringBuffer.append('=');
        stringBuffer.append(this.subIconIndex);
        stringBuffer.append(',');
        stringBuffer.append("parent");
        stringBuffer.append('=');
        stringBuffer.append(this.parent);
        stringBuffer.append(',');
        stringBuffer.append("visible");
        stringBuffer.append('=');
        stringBuffer.append(this.visible);
        stringBuffer.append(',');
        stringBuffer.append("audible");
        stringBuffer.append('=');
        stringBuffer.append(this.audible);
        stringBuffer.append(',');
        stringBuffer.append("personal");
        stringBuffer.append('=');
        stringBuffer.append(this.personal);
        stringBuffer.append(',');
        stringBuffer.append("monitored");
        stringBuffer.append('=');
        stringBuffer.append(this.monitored);
        stringBuffer.append(',');
        stringBuffer.append("description");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.description);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("additionalFlags");
        stringBuffer.append('=');
        stringBuffer.append(this.additionalFlags);
        stringBuffer.append(',');
        stringBuffer.append("parentId");
        stringBuffer.append('=');
        stringBuffer.append(this.parentId);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

