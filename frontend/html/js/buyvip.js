import { addicon, buyvip } from './script.js';

const btnaddicon = document.getElementById('btnbuyvip')

btnbuyvip.addEventListener('click', () => {
    const usergroup = document.getElementById('usergroup').value;

    buyvip(usergroup)
})