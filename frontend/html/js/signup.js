import { register } from './script.js';

const btnSignup = document.getElementById('btnSignup')

btnSignup.addEventListener('click', () => {
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    register(name, email, password)
})

document.addEventListener('keydown', e => {
    if (e.code == 'Enter'){
        btnSignup.click()
    }
})