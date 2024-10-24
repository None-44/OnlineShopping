<style>

    .input_box {
        width: 300px;
        height: 40px;
        padding-left: 10px;
        margin-left: 50px;
    }
    .button_box {
        width: 300px;
        height: 40px;
        margin-top: 10px;
        margin-left: 50px;
        border-radius: 5px;
        margin-bottom: 10px;
        background-color: #64a9d9;
        cursor: pointer;
        color: #fff;
    }

</style>

<h2>填写用户信息</h2>
<form action="/">
<p>姓名:
    <input class="input_box" type="text" id="name" name="name" required></p>
<label>性别:</label>
    <input type="radio" id="male" name="gender" value="male" checked>
    <label for="male">男</label>
    <input type="radio" id="female" name="gender" value="female">
    <label for="female">女</label>
<p>电话号码:
    <input class="input_box" type="text" id="phone" name="phone" required></p>
<p>面交地址:
    <input class="input_box" type="text" id="add" name="add" required></p>
    <input class="button_box" type="submit" value="提交">
    <br>
</form>