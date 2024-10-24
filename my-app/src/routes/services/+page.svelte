<style>
    .lie{
        font-size: 20px;
        background-color: #64a9d9;
        width: 220px;
        height:200px;
        margin-bottom: 10px;
        float: left;
        margin-left: 20px;
        text-align: center;
    }
    a {
        background-color: #40a944;
        color: #fff;
        font-size: 1rem;
        padding: 10px;
        display: flex;
        align-items: center;
        float: right;
        justify-content: center;
        width: 100px;
    }

    a:hover {
        background-color: #cfe9d0;
        color: #000;
    }
</style>
<script>
    import { onMount } from 'svelte';
    import { authStore } from '$lib/stores/authStore';
    import { goto } from '$app/navigation'; // 导入 goto 方法

    let isLoggedIn = false;

    // 订阅 store 来检查登录状态
    const unsubscribe = authStore.subscribe(value => {
        isLoggedIn = value.isLoggedIn;
    });

    onMount(() => {
        // 如果未登录，重定向到登录页面
        if (!isLoggedIn) {
            goto('/login');
        }
        return () => unsubscribe(); // 清理订阅
    });
</script>

{#if isLoggedIn}
    <!-- 登录后允许访问的功能 -->
{:else}
    <p>正在重定向到登录页面...</p>
{/if}
<p>商家后台 <a href="/update">上传商品</a></p>

<div class="lie">
<p>购买用户信息</p>
</div>

<div class="lie">
    <p>历史商品信息</p>
</div>
<div class="login_box">
    <title>重置密码</title>
    <input class="button_box" type="button" value="重置密码" on:click={async () => {
        const response = await fetch('http://localhost:8080/seller/resetPassword', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
        });
        if (response.ok) {
            alert('密码已重置为默认密码');
        } else {
            alert('重置失败，请重试');
        }
    }}>
</div>
