/*
 * Decompiled with CFR 0.152.
 */
package generated.de.vw.mib.has.contexts.exlap;

import de.vw.mib.has.HASContainer;
import de.vw.mib.has.HASException;
import generated.de.vw.mib.has.contexts.exlap.ExlapServices;

public class ExlapServicesAdapter
implements ExlapServices {
    @Override
    public void actionRequest(int n, int n2, HASContainer hASContainer) {
        switch (n2) {
            default: 
        }
        throw HASException.invalidActionRequest(n2);
    }

    @Override
    public void propertyRequest(int n) {
        switch (n) {
            case 30: {
                this.getExlapRestrictionMode();
                break;
            }
            default: {
                throw HASException.invalidPropertyRequest(n);
            }
        }
    }

    @Override
    public void getExlapRestrictionMode() {
    }
}

