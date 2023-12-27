/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.sdssd;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;
import de.vw.mib.bap.marshalling.BAPService;
import de.vw.mib.bap.stream.BitStreamTransformer;

public class SDSSDMarshaller
implements BAPIndicationMarshaller {
    private final BAPService _bapService;
    private final BitStreamTransformer _bitSreamTransformer;

    public SDSSDMarshaller(BAPService bAPService, BitStreamTransformer bitStreamTransformer) {
        this._bapService = bAPService;
        this._bitSreamTransformer = bitStreamTransformer;
    }

    private BAPService getBapService() {
        return this._bapService;
    }

    private BitStreamTransformer getBitSreamTransformer() {
        return this._bitSreamTransformer;
    }

    private static int getBitstreamTransformerDatatype(int n) {
        int n2;
        switch (n) {
            case 0: {
                n2 = 8;
                break;
            }
            case 1: {
                n2 = 16;
                break;
            }
            case 2: {
                n2 = 32;
                break;
            }
            default: {
                n2 = 32;
            }
        }
        return n2;
    }

    @Override
    public void resultEntity(int n, BAPEntity bAPEntity) {
        switch (n) {
            default: 
        }
        throw new UnsupportedOperationException("Result not supported for given fctID");
    }

    @Override
    public void statusEntity(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 2: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 3: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 4: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, SDSSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 14: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 15: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, SDSSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 16: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 17: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 18: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 19: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 20: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            default: {
                throw new UnsupportedOperationException("Status not supported for given fctID");
            }
        }
    }

    @Override
    public void changedEntity(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 18: {
                this.getBapService().requestByteSequence(n, 10, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 19: {
                this.getBapService().requestByteSequence(n, 10, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            default: {
                throw new UnsupportedOperationException("Changed not supported for given fctID");
            }
        }
    }

    @Override
    public void statusAckEntity(int n, BAPEntity bAPEntity) {
        switch (n) {
            default: 
        }
        throw new UnsupportedOperationException("StatusAck not supported for given fctID");
    }

    @Override
    public void error(int n, int n2) {
        this.getBapService().requestError(n, n2);
    }
}

