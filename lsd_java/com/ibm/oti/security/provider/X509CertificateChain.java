/*
 * Decompiled with CFR 0.152.
 */
package com.ibm.oti.security.provider;

import java.security.Principal;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

public class X509CertificateChain {
    LinkedList chain = null;

    public X509CertificateChain(X509Certificate x509Certificate, Collection collection) {
        if (x509Certificate == null) {
            throw new IllegalArgumentException();
        }
        this.chain = new LinkedList();
        this.chain.add(0, x509Certificate);
        if (x509Certificate.getSubjectDN().equals(x509Certificate.getIssuerDN())) {
            return;
        }
        if (collection == null) {
            return;
        }
        Principal principal = x509Certificate.getIssuerDN();
        X509Certificate x509Certificate2;
        while ((x509Certificate2 = this.findCertForSubject(principal, collection)) != null) {
            this.chain.add(x509Certificate2);
            if (x509Certificate2.getSubjectDN().equals(x509Certificate2.getIssuerDN())) {
                return;
            }
            principal = x509Certificate2.getIssuerDN();
        }
        return;
    }

    public Iterator iterator() {
        return this.chain.iterator();
    }

    private X509Certificate findCertForSubject(Principal principal, Collection collection) {
        Iterator iterator = collection.iterator();
        while (iterator.hasNext()) {
            X509Certificate x509Certificate = (X509Certificate)iterator.next();
            if (!x509Certificate.getSubjectDN().equals(principal)) continue;
            return x509Certificate;
        }
        return null;
    }
}

