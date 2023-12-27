/*
 * Decompiled with CFR 0.152.
 */
package de.esolutions.fw.comm.asi.navigation.ncfs;

import de.esolutions.fw.comm.asi.navigation.ncfs.NCFSProviderReply;
import de.esolutions.fw.comm.asi.navigation.ncfs.sBoundingBox;

public interface NCFSProviderS {
    default public void requestVZORestrictions(sBoundingBox sBoundingBox2, NCFSProviderReply nCFSProviderReply) {
    }

    default public void requestLGI(sBoundingBox sBoundingBox2, NCFSProviderReply nCFSProviderReply) {
    }
}

