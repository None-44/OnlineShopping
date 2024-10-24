<script>
    import App from '$lib/App.svelte'; // 引入 App.svelte 组件
</script>

<App />

<style>
    a {
        background-color: #40a944;
        color: #fff;
        font-size: 1rem;
        margin-top: 10px;
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

    .container{

    }

    main {
        position: relative;
        z-index: 1; /* 确保文本在背景上方 */
        color: white;
        text-align: center;
        padding-top: 50vh;
    }

</style>

<main>
    <div class="container"></div>
<a href="/user">购买</a>

</main>




