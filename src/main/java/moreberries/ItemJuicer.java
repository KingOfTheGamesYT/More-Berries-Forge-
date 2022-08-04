package moreberries;

import net.minecraft.item.Item;

public class ItemJuicer extends Item {

	public ItemJuicer(Item.Properties settings) {
		super(settings);
		((ItemExtension) this).setRecipeRemainder(this);
	}
}
