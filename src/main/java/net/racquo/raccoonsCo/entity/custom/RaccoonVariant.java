package net.racquo.raccoonsCo.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum RaccoonVariant {
    DEFAULT(0),
    GRAY(1),
    SWAMP(2),
    BROWN(3),
    CINNAMON(4),
    BLOND(5),
    ALBINO(6),
    BLACK(7);

    private static final RaccoonVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(RaccoonVariant::getId)).toArray(RaccoonVariant[]::new);
    private final int id;

    RaccoonVariant(int id) {
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static RaccoonVariant byId(int id){
        return BY_ID[id % BY_ID.length];
    }

}
