import { addicon } from './script.js';

const btnaddicon = document.getElementById('btnaddicon')

btnaddicon.addEventListener('click', () => {
    const name = document.getElementById('name').value;
    const theme = document.getElementById('theme').value;
    const style = document.getElementById('style').value;
    const svgcode = document.getElementById('svgcode').value;

    addicon(name, theme, style, svgcode)
})