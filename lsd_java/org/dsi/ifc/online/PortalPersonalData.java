/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.online;

public class PortalPersonalData {
    public String lastName;
    public String lastNameSnd;
    public String firstName;
    public String firstNameSnd;
    public String organizationName;
    public String position;

    public PortalPersonalData() {
        this.lastName = null;
        this.lastNameSnd = null;
        this.firstName = null;
        this.firstNameSnd = null;
        this.organizationName = null;
        this.position = null;
    }

    public PortalPersonalData(String string, String string2, String string3, String string4, String string5, String string6) {
        this.lastName = string;
        this.lastNameSnd = string2;
        this.firstName = string3;
        this.firstNameSnd = string4;
        this.organizationName = string5;
        this.position = string6;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getLastNameSnd() {
        return this.lastNameSnd;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFirstNameSnd() {
        return this.firstNameSnd;
    }

    public String getOrganizationName() {
        return this.organizationName;
    }

    public String getPosition() {
        return this.position;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(500);
        stringBuffer.append("PortalPersonalData");
        stringBuffer.append('(');
        stringBuffer.append("lastName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.lastName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("lastNameSnd");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.lastNameSnd);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("firstName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.firstName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("firstNameSnd");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.firstNameSnd);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("organizationName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.organizationName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("position");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.position);
        stringBuffer.append('\"');
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

