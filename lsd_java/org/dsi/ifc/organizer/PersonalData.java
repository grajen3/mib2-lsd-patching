/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.organizer;

import org.dsi.ifc.global.DateTime;
import org.dsi.ifc.global.ResourceLocator;

public class PersonalData {
    public String lastName;
    public String lastNameSound;
    public String firstName;
    public String firstNameSound;
    public DateTime birthday;
    public String organization;
    public String organizationSound;
    public ResourceLocator contactPicture;

    public PersonalData() {
        this.lastName = null;
        this.lastNameSound = null;
        this.firstName = null;
        this.firstNameSound = null;
        this.birthday = null;
        this.organization = null;
        this.contactPicture = null;
    }

    public PersonalData(String string, String string2, String string3, String string4, DateTime dateTime, String string5, String string6, ResourceLocator resourceLocator) {
        this.lastName = string;
        this.lastNameSound = string2;
        this.firstName = string3;
        this.firstNameSound = string4;
        this.birthday = dateTime;
        this.organization = string5;
        this.organizationSound = string6;
        this.contactPicture = resourceLocator;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getLastNameSound() {
        return this.lastNameSound;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getFirstNameSound() {
        return this.firstNameSound;
    }

    public DateTime getBirthday() {
        return this.birthday;
    }

    public String getOrganization() {
        return this.organization;
    }

    public String getOrganizationSound() {
        return this.organizationSound;
    }

    public ResourceLocator getContactPicture() {
        return this.contactPicture;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(2600);
        stringBuffer.append("PersonalData");
        stringBuffer.append('(');
        stringBuffer.append("lastName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.lastName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("lastNameSound");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.lastNameSound);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("firstName");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.firstName);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("firstNameSound");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.firstNameSound);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("birthday");
        stringBuffer.append('=');
        stringBuffer.append(this.birthday);
        stringBuffer.append(',');
        stringBuffer.append("organization");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.organization);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("organizationSound");
        stringBuffer.append('=');
        stringBuffer.append('\"');
        stringBuffer.append(this.organizationSound);
        stringBuffer.append('\"');
        stringBuffer.append(',');
        stringBuffer.append("contactPicture");
        stringBuffer.append('=');
        stringBuffer.append(this.contactPicture);
        stringBuffer.append(')');
        return stringBuffer.toString();
    }
}

