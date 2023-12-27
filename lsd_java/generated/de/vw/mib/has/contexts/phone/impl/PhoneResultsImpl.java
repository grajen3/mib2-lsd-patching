/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.phone.impl;

import de.vw.mib.has.HASBaseContainerFactory;
import de.vw.mib.has.HASContextResults;
import generated.de.vw.mib.has.contexts.impl.AbstractContextResults;
import generated.de.vw.mib.has.contexts.phone.PhoneResults;

public class PhoneResultsImpl
extends AbstractContextResults
implements PhoneResults {
    public PhoneResultsImpl(HASContextResults hASContextResults, HASBaseContainerFactory hASBaseContainerFactory) {
        super(hASContextResults, hASBaseContainerFactory);
    }

    @Override
    public void callContactResult(int n, int n2) {
        this.callResult(n, 4, n2);
    }
}

