<style>
    title{
        text-align: center;
        width: 300px;
        height: 40px;
        margin-top: 10px;
        margin-left: 50px;
        color: #fff;
    }

    .login_box {
        width: 100%;
        height: 100%;
        background-color: #fff;
        margin: auto;
        margin-top: 5%;
        border-radius: 5px;
        overflow: hidden;
    }

    .input_box {
        width: 300px;
        height: 40px;
        padding-left: 10px;
        margin-left: 50px;
        margin-bottom: 10px;
    }
    .button_box {
        width: 300px;
        height: 40px;
        margin-top: 10px;
        margin-left: 50px;
        border-radius: 5px;
        background-color: #64a9d9;
        cursor: pointer;
        color: #fff;
    }
</style>
<script>
    import { onMount } from 'svelte';
    import { authStore } from '$lib/stores/authStore';
    import { goto } from '$app/navigation';

    let newPassword = '';
    let confirmPassword = '';
    let message = '';
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

    async function updatePassword() {
        if (newPassword !== confirmPassword) {
            message = '新密码和确认密码不匹配。';
            return;
        }

        const response = await fetch('http://localhost:8080/seller/changePassword/' + newPassword, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
        });

        const result = await response.json();
        if (response.ok) {
            message = '密码修改成功';
        } else {
            message = result.message || '修改密码失败';
        }
    }
</script>

{#if isLoggedIn}
    <div class="login_box">
        <h2>修改密码</h2>
        <input
                class="input_box"
                type="password"
                placeholder="新密码"
                bind:value={newPassword}
                required
        />
        <br />
        <input
                class="input_box"
                type="password"
                placeholder="确认密码"
                bind:value={confirmPassword}
                required
        />
        <br />
        <input
                class="button_box"
                type="button"
                value="提交"
                on:click={updatePassword}
        />
        <br />

        {#if message}
            <p style="color: red;">{message}</p>
        {/if}
    </div>
{:else}
    <p>正在重定向到登录页面...</p>
{/if}
