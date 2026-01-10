package net.racquo.raccoonsCo.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum CrawfishVariant {

    DEFAULT(0),
    BLUE(1);

    private static final CrawfishVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(CrawfishVariant::getId)).toArray(CrawfishVariant[]::new);
    private final int id;

    CrawfishVariant(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static CrawfishVariant byId(int id){
        return BY_ID[id % BY_ID.length];
    }
}
