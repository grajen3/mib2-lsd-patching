/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.phone;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.containers.ContactContainer;
import generated.de.vw.mib.has.contexts.phone.PhoneServices;

public class PhoneServicesAdapter
implements PhoneServices {
    @Override
    public void actionRequest(int n, int n2, HASContainer hASContainer) {
        switch (n2) {
            case 4: {
                this.callContact(n, (ContactContainer)hASContainer);
                break;
            }
            default: {
                throw HASException.invalidActionRequest(n2);
            }
        }
    }

    @Override
    public void propertyRequest(int n) {
        switch (n) {
            default: 
        }
        throw HASException.invalidPropertyRequest(n);
    }

    @Override
    public void callContact(int n, ContactContainer contactContainer) {
        throw new UnsupportedOperationException();
    }
}

