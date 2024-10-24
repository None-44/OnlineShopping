<!-- src/App.svelte -->
<script>
    import { onMount } from 'svelte';
    import { paint } from '$lib/gradient.js'; // 引入绘制函数

    let canvas;
    let context;
    let animationFrameId;

    // 在页面加载时运行
    onMount(() => {
        context = canvas.getContext('2d');

        // 动画更新函数
        const render = (t) => {
            paint(context, t);  // 调用你定义的 paint 函数
            animationFrameId = requestAnimationFrame(render); // 循环动画
        };

        // 启动动画
        animationFrameId = requestAnimationFrame(render);

        // 清除动画
        return () => {
            cancelAnimationFrame(animationFrameId);
        };
    });
</script>

<!-- 定义一个 canvas 作为背景 -->
<canvas bind:this={canvas} width="32" height="32" ></canvas>

<!-- 样式: 设置 canvas 的位置和遮罩效果 -->
<style>
    canvas {
        position: fixed;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        background-color: #666;
        mask: url(./svelte-logo-mask.svg) 50% 50% no-repeat;
        mask-size: 60vmin;
        -webkit-mask: url(./svelte-logo-mask.svg) 50% 50% no-repeat;
        -webkit-mask-size: 60vmin;
        z-index: -1;
    }
</style>
