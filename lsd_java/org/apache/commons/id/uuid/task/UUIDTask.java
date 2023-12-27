/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.tools.ant.Task
 */
package org.apache.commons.id.uuid.task;

import org.apache.commons.id.uuid.UUID;
import org.apache.commons.id.uuid.task.UUIDTask$UUIDVersion;
import org.apache.tools.ant.Task;

public class UUIDTask
extends Task {
    private String uuidVersion = "VERSION_FOUR";
    private String name = "www.apache.org";
    private String namespace = "urn:uuid:B4F00409-CEF8-4822-802C-DEB20704C365";

    public void setName(String string) {
        this.name = string;
    }

    public void setNamespace(String string) {
        this.namespace = string;
    }

    public void setVersion(UUIDTask$UUIDVersion uUIDTask$UUIDVersion) {
        this.uuidVersion = uUIDTask$UUIDVersion.getValue();
    }

    public void execute() {
        UUID uUID = null;
        if (this.uuidVersion.equals("VERSION_THREE")) {
            uUID = UUID.nameUUIDFromString(this.name, new UUID(this.namespace), "MD5");
        } else if (this.uuidVersion.equals("VERSION_FIVE")) {
            uUID = UUID.nameUUIDFromString(this.name, new UUID(this.namespace), "SHA1");
        } else if (this.uuidVersion.equals("VERSION_FOUR")) {
            uUID = UUID.randomUUID();
        } else if (this.uuidVersion.equals("VERSION_ONE")) {
            uUID = UUID.timeUUID();
        }
        this.setProperty("uuid", uUID.toString());
    }

    private void setProperty(String string, String string2) {
        this.getProject().setProperty(string, string2);
    }
}

