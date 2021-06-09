import { getIcons } from './script.js';

const txtSearchIcon = document.getElementById('txtSearchIcon')
const btnSearchIcon = document.getElementById('btnSearchIcon')
const divDesign = document.getElementById('designContainer')

function addToDesign(e){
    console.log(e)
    let str = divDesign.innerHTML
    str += e.target.closest('div').children['0']
    divDesign.innerHTML = str
    console.log(e.target.children['0'])
}

btnSearchIcon.addEventListener('click', async () => {
    const icons = await getIcons(txtSearchIcon.value)

    let str = ''

    icons.forEach(icon => {
        str += `
        <div class="card cardStyle iconCard text-center" data-id="${icon.id}">
            ${icon.svg}
            <div class="card-body">
                <h5 class="card-title">${icon.name}</h5>
                <h6 class="card-subtitle mb-2 text-muted">${icon.theme.name}</h6>
            </div>
        </div>`
    })


    let iconCardsContainer = document.getElementById('icons-add-container')

    iconCardsContainer.innerHTML = str

    let iconCards = iconCardsContainer.querySelectorAll('div[class="card cardStyle iconCard text-center"]');
    iconCards.forEach(card => {
        card.addEventListener ('click', addToDesign);
    });
})

btnSearchIcon.click()

