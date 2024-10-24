import { writable } from 'svelte/store';

export const authStore = writable({
    isLoggedIn: false,
    // 用于登录状态
});
