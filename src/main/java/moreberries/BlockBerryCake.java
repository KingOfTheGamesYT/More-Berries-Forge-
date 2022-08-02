package moreberries;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.event.GameEvent;

import java.util.HashMap;

public class BlockBerryCake extends CakeBlock {


	public BlockBerryCake(Block.Settings settings) {
		super(settings);
		this.setDefaultState(this.getDefaultState().with(BITES, 0));
	}

	public static ActionResult tryEat(WorldAccess worldAccess, BlockPos blockPos, BlockState blockState, PlayerEntity playerEntity) {
		if (!playerEntity.canConsume(false)) {
			return ActionResult.PASS;
		} else {
			playerEntity.incrementStat(Stats.EAT_CAKE_SLICE);
			playerEntity.getHungerManager().add(2, 0.1F);
			int i = (Integer)blockState.get(BITES);
			worldAccess.emitGameEvent(playerEntity, GameEvent.EAT, blockPos);
			if (i < 6) {
				worldAccess.setBlockState(blockPos, (BlockState)blockState.with(BITES, i + 1), 3);
			} else {
				worldAccess.removeBlock(blockPos, false);
				worldAccess.emitGameEvent(playerEntity, GameEvent.BLOCK_DESTROY, blockPos);
			}

			return ActionResult.SUCCESS;
		}
	}

}
