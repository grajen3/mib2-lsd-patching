/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  org.apache.tools.ant.types.EnumeratedAttribute
 */
package org.apache.commons.id.uuid.task;

import org.apache.tools.ant.types.EnumeratedAttribute;

public class UUIDTask$UUIDVersion
extends EnumeratedAttribute {
    public String[] getValues() {
        return new String[]{"VERSION_ONE", "VERSION_THREE", "VERSION_FOUR", "VERSION_FIVE"};
    }
}

