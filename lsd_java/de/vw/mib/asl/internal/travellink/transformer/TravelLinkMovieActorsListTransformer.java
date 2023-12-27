/*
 * Decompiled with CFR 0.152.
 */
package de.vw.mib.asl.internal.travellink.transformer;

import generated.de.vw.mib.asl.internal.travellink.transformer.AbstractTravelLinkMovieActorsListTransformer;

public final class TravelLinkMovieActorsListTransformer
extends AbstractTravelLinkMovieActorsListTransformer {
    @Override
    public String getString(int n, Object object) {
        switch (n) {
            case 0: {
                return (String)object;
            }
        }
        throw new IllegalArgumentException();
    }
}

