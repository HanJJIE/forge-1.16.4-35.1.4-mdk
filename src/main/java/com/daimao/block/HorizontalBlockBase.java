package com.daimao.block;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IWorld;
import org.apache.commons.lang3.StringUtils;

import javax.annotation.Nullable;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class HorizontalBlockBase extends Block {

    protected static final Map<Block, Map<Direction, VoxelShape>> SHAPES = new HashMap<>();

    public HorizontalBlockBase(Properties properties) {
        super(properties);
        // 设置默认状态（水平面朝北）
        this.setDefaultState(this.getStateContainer().getBaseState().with(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH));
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        return state.rotate(mirrorIn.toRotation(state.get(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, IWorld world, BlockPos pos, Rotation direction) {
        return state.with(BlockStateProperties.HORIZONTAL_FACING, direction.rotate(state.get(BlockStateProperties.HORIZONTAL_FACING)));
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(BlockStateProperties.HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(BlockStateProperties.HORIZONTAL_FACING);
    }

    protected static VoxelShape calculateShapes(Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, VoxelShapes.empty()};

        int times = (to.getHorizontalIndex() - Direction.NORTH.getHorizontalIndex() + 4) % 4;
        for (int i = 0; i < times; i++) {
            buffer[0].forEachBox((minX, minY, minZ, maxX, maxY, maxZ)
                    -> buffer[1] = VoxelShapes.or(buffer[1], VoxelShapes.create(1 - maxZ, minY, minX, 1 - minZ, maxY, maxX))
            );
            buffer[0] = buffer[1];
            buffer[1] = VoxelShapes.empty();
        }

        return buffer[0];
    }

    protected void runCalculation(VoxelShape shape) {
        SHAPES.put(this, new HashMap<>());
        Map<Direction, VoxelShape> facingMap = SHAPES.get(this);
        for (Direction direction : Direction.values()) {
            facingMap.put(direction, calculateShapes(direction, shape));
        }
    }

    /**
     * 返回 3d像素形状
     * @author 黄汉杰
     * @date 2022/6/6 0006 15:15
     * @param configPath 配置文件路径
     * @return net.minecraft.util.math.shapes.VoxelShape
     */
    protected static VoxelShape createShape(String configPath) {
        VoxelShape shape = null;
        InputStream inputStream = PointToOneself.class.getResourceAsStream(configPath);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String temp;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while (StringUtils.isNotBlank(temp = bufferedReader.readLine())) {
                stringBuilder.append(temp);
            }
            JSONArray elements = JSONObject.parseObject(stringBuilder.toString()).getJSONArray("elements");
            VoxelShape shape0 = getByElement(elements.getJSONObject(0));
            LinkedList<VoxelShape> shapeList = new LinkedList<>();
            for (int i = 1; i < elements.size(); i++) {
                shapeList.add(getByElement(elements.getJSONObject(i)));
            }
            shape = VoxelShapes.or(shape0, shapeList.toArray(new VoxelShape[0]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shape;
    }

    protected static VoxelShape getByElement(JSONObject element) {
        JSONArray from = element.getJSONArray("from");
        JSONArray to = element.getJSONArray("to");
        return Block.makeCuboidShape(
                from.getDouble(0),
                from.getDouble(1),
                from.getDouble(2),
                to.getDouble(0),
                to.getDouble(1),
                to.getDouble(2)
        );
    }

}