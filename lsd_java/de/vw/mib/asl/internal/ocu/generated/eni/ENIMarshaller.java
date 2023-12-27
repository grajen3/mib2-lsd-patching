/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.ocu.generated.eni;

import de.vw.mib.bap.datatypes.BAPEntity;
import de.vw.mib.bap.marshalling.BAPRequestMarshaller;
import de.vw.mib.bap.marshalling.BAPService;
import de.vw.mib.bap.stream.BitStreamTransformer;

public class ENIMarshaller
implements BAPRequestMarshaller {
    private final BAPService _bapService;
    private final BitStreamTransformer _bitstreamTransformer;

    public ENIMarshaller(BAPService bAPService, BitStreamTransformer bitStreamTransformer) {
        this._bapService = bAPService;
        this._bitstreamTransformer = bitStreamTransformer;
    }

    private BAPService getBapService() {
        return this._bapService;
    }

    private BitStreamTransformer getBitstreamTransformer() {
        return this._bitstreamTransformer;
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
    public void startResult(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 18: {
                this.getBapService().requestByteSequence(n, 4, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            default: {
                throw new UnsupportedOperationException("StartResult not supported for given fctID");
            }
        }
    }

    @Override
    public void abortResult(int n, BAPEntity bAPEntity) {
        throw new UnsupportedOperationException("Abort not supported for given fctID");
    }

    @Override
    public void getEntity(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 2: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 3: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 4: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 13: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 14: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 15: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 17: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 19: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 20: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 23: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 24: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 26: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 27: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 28: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 29: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 32: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 33: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 34: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 36: {
                this.getBapService().requestVoid(n, 2);
                break;
            }
            case 16: {
                this.getBapService().requestByteSequence(n, 2, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 21: {
                this.getBapService().requestByteSequence(n, 2, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 22: {
                this.getBapService().requestByteSequence(n, 2, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 25: {
                this.getBapService().requestByteSequence(n, 2, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 30: {
                this.getBapService().requestByteSequence(n, 2, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 31: {
                this.getBapService().requestByteSequence(n, 2, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 35: {
                this.getBapService().requestByteSequence(n, 2, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 37: {
                this.getBapService().requestByteSequence(n, 2, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            default: {
                throw new UnsupportedOperationException("Get not supported for given fctID");
            }
        }
    }

    @Override
    public void setGetEntity(int n, BAPEntity bAPEntity) {
        switch (n) {
            case 13: {
                this.getBapService().request(n, 0, 0, this.getBitstreamTransformer().toInteger(bAPEntity, ENIMarshaller.getBitstreamTransformerDatatype(0)));
                break;
            }
            case 17: {
                this.getBapService().request(n, 1, 0, this.getBitstreamTransformer().toInteger(bAPEntity, ENIMarshaller.getBitstreamTransformerDatatype(1)));
                break;
            }
            case 24: {
                this.getBapService().requestByteSequence(n, 0, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 33: {
                this.getBapService().requestByteSequence(n, 0, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 34: {
                this.getBapService().requestByteSequence(n, 0, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 16: {
                this.getBapService().requestByteSequence(n, 0, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 22: {
                this.getBapService().requestByteSequence(n, 0, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 35: {
                this.getBapService().requestByteSequence(n, 0, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            case 37: {
                this.getBapService().requestByteSequence(n, 0, this.getBitstreamTransformer().toByteArray(bAPEntity));
                break;
            }
            default: {
                throw new UnsupportedOperationException("setGetEntity not supported for given fctID");
            }
        }
    }

    @Override
    public void ackEntity(int n, BAPEntity bAPEntity) {
        throw new UnsupportedOperationException("Ack not supported for given fctID");
    }
}

