<script>
    import { authStore } from '$lib/stores/authStore';
    import { onDestroy} from 'svelte';

    let password = '';
    let errorMessage = '';
    let isLoggedIn = false;

    const unsubscribe = authStore.subscribe(value => {
        isLoggedIn = value.isLoggedIn;
    });

    onDestroy(() => {
        unsubscribe();
    });

    async function handleLogin() {
        errorMessage = '';
        const response = await fetch('http://localhost:8080/seller/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded',
            },
            body: new URLSearchParams({ password }),
        });

        const result = await response.json();

        // 根据后端返回的值判断登录状态
        if (response.ok) {
            authStore.set({isLoggedIn: true});
            localStorage.setItem('isLoggedIn', 'true');
            isLoggedIn = true;
            errorMessage = '';
            // 可选：在这里跳转到用户主页
            // window.location.href = '/home';
        } else {
            errorMessage = result.message || '密码错误，请重试。';
        }
    }
</script>

<style>
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
    }
    .button_box {
        width: 300px;
        height: 40px;
        margin-top: 20px;
        margin-left: 50px;
        border-radius: 5px;
        background-color: #64a9d9;
        cursor: pointer;
        color: #fff;
    }
</style>

<div class="login_box">
    {#if !isLoggedIn}
        <input
                class="input_box"
                type="password"
                placeholder="密码"
                bind:value={password}
                required
        />
        <br />
        <input
                class="button_box"
                type="button"
                value="登录"
                on:click={handleLogin}
        />
        <br />
        {#if errorMessage}
            <p style="color: red;">{errorMessage}</p>
        {/if}
    {:else}
        <p>登录成功！</p>
    {/if}
    <br>
</div>








