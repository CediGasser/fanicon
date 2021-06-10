import { getIcons } from './script.js';

const txtSearchIcon = document.getElementById('txtSearchIcon')
const btnSearchIcon = document.getElementById('btnSearchIcon')
const divDesign = document.getElementById('designContainer')

btnSearchIcon.addEventListener('click', async () => {
    const icons = await getIcons(txtSearchIcon.value)

    let str = ''

    icons.forEach(icon => {
        str += `
        <button data-id="${icon.id}"><div class="card cardStyle iconCard text-center">
            ${icon.svg}
            <h5 class="card-title">${icon.name}</h5>
            <h6 class="card-subtitle mb-2 text-muted">${icon.theme.name}</h6>
        </div></button>`
    })


    let iconCardsContainer = document.getElementById('icons-add-container')

    iconCardsContainer.innerHTML = str

    let iconCards = iconCardsContainer.querySelectorAll('button')
    iconCards.forEach(card => {
        card.addEventListener ('click', addToDesign);
    });
})

btnSearchIcon.click()

function addToDesign(e){
    debugger
    console.log(e)
    svg = e.target.querySelectorAll('svg')
    divDesign.appendChild(svg)
}