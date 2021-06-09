import { getIcons } from './script.js';

const txtSearchIcon = document.getElementById('txtSearchIcon')
const btnSearchIcon = document.getElementById('btnSearchIcon')

btnSearchIcon.addEventListener('click', async () => {
    const icons = await getIcons(txtSearchIcon.value)
    console.log(icons)

    let str = ''

    icons.forEach(icon => {
        str += icon.svg
    })

    console.log(str)

    document.getElementById('icons-add-container').innerHTML = str
})