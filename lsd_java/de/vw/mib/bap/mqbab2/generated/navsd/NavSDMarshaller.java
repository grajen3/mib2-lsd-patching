/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.bap.mqbab2.generated.navsd;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.marshalling.BAPIndicationMarshaller;
import de.vw.mib.bap.marshalling.BAPService;
import de.vw.mib.bap.stream.BitStreamTransformer;

public class NavSDMarshaller
implements BAPIndicationMarshaller {
    private final BAPService _bapService;
    private final BitStreamTransformer _bitSreamTransformer;

    public NavSDMarshaller(BAPService bAPService, BitStreamTransformer bitStreamTransformer) {
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
            case 34: {
                this.getBapService().request(n, 0, 9, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 35: {
                this.getBapService().request(n, 0, 9, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 41: {
                this.getBapService().requestByteSequence(n, 9, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 42: {
                this.getBapService().requestByteSequence(n, 9, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 51: {
                this.getBapService().requestByteSequence(n, 9, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            default: {
                throw new UnsupportedOperationException("Result not supported for given fctID");
            }
        }
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
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 15: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 16: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 17: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
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
            case 21: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 22: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 23: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 24: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 25: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 26: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 27: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 28: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 29: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 30: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 31: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 32: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 33: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 36: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 37: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 38: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 39: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 40: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 43: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 44: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 45: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 46: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 47: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 48: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 49: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 50: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 52: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 53: {
                this.getBapService().requestByteSequence(n, 7, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 54: {
                this.getBapService().request(n, 0, 7, this.getBitSreamTransformer().toInteger(bAPEntity, NavSDMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 55: {
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
            case 24: {
                this.getBapService().requestByteSequence(n, 10, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 29: {
                this.getBapService().requestByteSequence(n, 10, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 30: {
                this.getBapService().requestByteSequence(n, 10, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 32: {
                this.getBapService().requestByteSequence(n, 10, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 33: {
                this.getBapService().requestByteSequence(n, 10, this.getBitSreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 52: {
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

