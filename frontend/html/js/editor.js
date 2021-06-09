import { getIcons } from './script.js';

const txtSearchIcon = document.getElementById('txtSearchIcon')
const btnSearchIcon = document.getElementById('btnSearchIcon')

btnSearchIcon.addEventListener('click', async () => {
    const icons = await getIcons(txtSearchIcon.value)
    console.log(icons)

    let str = ''

    icons.forEach(icon => {
        str += `
        <div class="card iconCard text-center">
            ${icon.svg}
            <div class="card-body">
                <h5 class="card-title">${icon.name}</h5>
                <h6 class="card-subtitle mb-2 text-muted">${icon.theme.name}</h6>
            </div>
        </div>`
    })

    console.log(str)

    document.getElementById('icons-add-container').innerHTML = str
})