package moreberries;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;


public class BlockBerryCake extends CakeBlock {


	public BlockBerryCake(AbstractBlock.Properties properties) {
		super(properties);
		this.setDefaultState(this.getDefaultState().with(BITES, 0));
	}

	private ActionResultType eatSlice(IWorld world, BlockPos pos, BlockState state, PlayerEntity player) {
		if (!player.canEat(false)) {
			return ActionResultType.PASS;
		} else {
			player.addStat(Stats.EAT_CAKE_SLICE);
			player.getFoodStats().addStats(2, 0.1F);
			int i = (Integer)state.get(BITES);
			if (i < 6) {
				world.setBlockState(pos, (BlockState)state.with(BITES, i + 1), 3);
			} else {
				world.removeBlock(pos, false);
			}

			return ActionResultType.SUCCESS;
		}
	}

}
