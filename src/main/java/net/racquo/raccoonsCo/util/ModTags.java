package net.racquo.raccoonsCo.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.racquo.raccoonsCo.RaccoonsCo;

public class ModTags {
    public static class Items {
        public static final TagKey<Item> RACCOON_PELT_REPAIR = createTag("raccoon_pelt_repair");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(RaccoonsCo.MOD_ID, name));
        }
    }
}
