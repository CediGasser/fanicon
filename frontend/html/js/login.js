import { login } from './script.js';

const btnLogin = document.getElementById('btnLogin')

btnLogin.addEventListener('click', () => {
    const name = document.getElementById('name').value;
    const password = document.getElementById('password').value;

    login(name, password)
})

document.addEventListener('keydown', e => {
    if (e.code == 'Enter'){
        btnLogin.click()
    }
})