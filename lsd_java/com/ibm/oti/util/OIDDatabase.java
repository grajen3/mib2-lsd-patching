/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.util;

import com.ibm.oti.util.OIDDatabase$DBEntry;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class OIDDatabase {
    private static OIDDatabase instance = new OIDDatabase();
    private Set oids = new HashSet();
    private Set algorithms = new HashSet();

    private OIDDatabase() {
        OIDDatabase$DBEntry oIDDatabase$DBEntry = new OIDDatabase$DBEntry("1.2.840.113549.1.1.2");
        OIDDatabase$DBEntry oIDDatabase$DBEntry2 = new OIDDatabase$DBEntry("MD2withRSA");
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry2);
        oIDDatabase$DBEntry = new OIDDatabase$DBEntry("1.2.840.113549.1.1.4");
        oIDDatabase$DBEntry2 = new OIDDatabase$DBEntry("MD5withRSA");
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry2);
        oIDDatabase$DBEntry = new OIDDatabase$DBEntry("1.2.840.113549.1.1.5");
        oIDDatabase$DBEntry2 = new OIDDatabase$DBEntry("SHA1withRSA");
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry2);
        oIDDatabase$DBEntry = new OIDDatabase$DBEntry("1.2.840.10040.4.3");
        oIDDatabase$DBEntry2 = new OIDDatabase$DBEntry("SHA1withDSA");
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry2);
        oIDDatabase$DBEntry = new OIDDatabase$DBEntry("1.3.14.3.2.26");
        oIDDatabase$DBEntry2 = new OIDDatabase$DBEntry("SHA");
        OIDDatabase$DBEntry oIDDatabase$DBEntry3 = new OIDDatabase$DBEntry("SHA-1");
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry2);
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry3);
        oIDDatabase$DBEntry = new OIDDatabase$DBEntry("1.2.840.113549.2.5");
        oIDDatabase$DBEntry2 = new OIDDatabase$DBEntry("MD5");
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry2);
        oIDDatabase$DBEntry = new OIDDatabase$DBEntry("1.2.840.113549.1.1.1");
        oIDDatabase$DBEntry2 = new OIDDatabase$DBEntry("RSA");
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry2);
        oIDDatabase$DBEntry = new OIDDatabase$DBEntry("1.2.840.10040.4.1");
        OIDDatabase$DBEntry oIDDatabase$DBEntry4 = new OIDDatabase$DBEntry("1.3.14.3.2.12");
        oIDDatabase$DBEntry2 = new OIDDatabase$DBEntry("DSA");
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry2);
        this.wireTogether(oIDDatabase$DBEntry4, oIDDatabase$DBEntry2);
        oIDDatabase$DBEntry = new OIDDatabase$DBEntry("1.2.840.10046.2.1");
        oIDDatabase$DBEntry2 = new OIDDatabase$DBEntry("DiffieHellman");
        this.wireTogether(oIDDatabase$DBEntry, oIDDatabase$DBEntry2);
    }

    private void wireTogether(OIDDatabase$DBEntry oIDDatabase$DBEntry, OIDDatabase$DBEntry oIDDatabase$DBEntry2) {
        this.oids.add(oIDDatabase$DBEntry);
        this.algorithms.add(oIDDatabase$DBEntry2);
        oIDDatabase$DBEntry.addEquivalent(oIDDatabase$DBEntry2);
        oIDDatabase$DBEntry2.addEquivalent(oIDDatabase$DBEntry);
    }

    public static OIDDatabase getInstance() {
        return instance;
    }

    public String getFirstAlgorithmForOID(String string) {
        String string2 = null;
        Iterator iterator = this.getAllAlgorithmsForOID(string).iterator();
        if (iterator.hasNext()) {
            string2 = (String)iterator.next();
        }
        return string2;
    }

    public Set getAllAlgorithmsForOID(String string) {
        Set set = null;
        Iterator iterator = this.oids.iterator();
        set = this.getAllEquivalents(string, iterator);
        if (set == null) {
            throw new IllegalArgumentException(new StringBuffer("Unknown OID : ").append(string).toString());
        }
        return set;
    }

    public String getFirstOIDForAlgorithm(String string) {
        String string2 = null;
        Iterator iterator = this.getAllOIDsForAlgorithm(string).iterator();
        if (iterator.hasNext()) {
            string2 = (String)iterator.next();
        }
        return string2;
    }

    public Set getAllOIDsForAlgorithm(String string) {
        Set set = null;
        Iterator iterator = this.algorithms.iterator();
        set = this.getAllEquivalents(string, iterator);
        if (set == null) {
            throw new IllegalArgumentException(new StringBuffer("Unsupported algorithm : ").append(string).toString());
        }
        return set;
    }

    private Set getAllEquivalents(String string, Iterator iterator) {
        HashSet hashSet = null;
        while (iterator.hasNext()) {
            OIDDatabase$DBEntry oIDDatabase$DBEntry = (OIDDatabase$DBEntry)iterator.next();
            if (!oIDDatabase$DBEntry.getValue().equals(string)) continue;
            Set set = oIDDatabase$DBEntry.getAllEquivalents();
            hashSet = new HashSet();
            Iterator iterator2 = set.iterator();
            while (iterator2.hasNext()) {
                OIDDatabase$DBEntry oIDDatabase$DBEntry2 = (OIDDatabase$DBEntry)iterator2.next();
                hashSet.add(oIDDatabase$DBEntry2.getValue());
            }
        }
        return hashSet;
    }
}

