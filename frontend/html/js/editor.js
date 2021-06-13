import { getIcons, postDesign } from './script.js';

const txtSearchIcon = document.getElementById('txtSearchIcon')
const btnSearchIcon = document.getElementById('btnSearchIcon')
const divDesign = document.getElementById('designContainer')

btnSearchIcon.addEventListener('click', async () => {
    const icons = await getIcons(txtSearchIcon.value)

    let str = ''

    icons.forEach(icon => {
        str += `
        <div class="card cardStyle iconCard text-center" data-id="${icon.id}">
            ${icon.svg}
            <h5 class="card-title">${icon.name}</h5>
            <h6 class="card-subtitle mb-2 text-muted">${icon.theme.name}</h6>
        </div>`
    })


    let iconCardsContainer = document.getElementById('icons-add-container')

    iconCardsContainer.innerHTML = str

    let iconCards = iconCardsContainer.querySelectorAll('div[class="card cardStyle iconCard text-center"]');
    iconCards.forEach(card => {
        card.addEventListener ('click', addToDesign);
    });
})

txtSearchIcon.addEventListener('keyup', e => {
    if (e.keyCode === 13) {
        // Cancel the default action, if needed
        e.preventDefault();
        // Trigger the button element with a click
        btnSearchIcon.click();
      }
})

btnSearchIcon.click()

function addToDesign(e){
    let div = e.target.closest('div')
    let svg = div.querySelector('svg').cloneNode(true)
    svg.onclick = deleteItselfe
    svg.dataset.id = div.dataset.id
    divDesign.appendChild(svg)
}

document.getElementById('inputBgColor').addEventListener('input', e => {
    divDesign.style.backgroundColor = e.target.value
});

document.getElementById('inputIconColor').addEventListener('input', e =>{
    let color = e.target.value
    CCSStylesheetRuleStyle('styles', '#designContainer .icon g', 'fill', color)
})

document.getElementById('inputIconMargin').addEventListener('input', e => {
    let margin = e.target.value + 'px'
    CCSStylesheetRuleStyle('styles', '#designContainer .icon', 'margin', margin)
})

document.getElementById('inputIconSize').addEventListener('input', e => {
    let size = e.target.value + 'px'
    CCSStylesheetRuleStyle('styles', '#designContainer .icon', 'height', size)
    CCSStylesheetRuleStyle('styles', '#designContainer .icon', 'width', size)
})

export function onPostDesign() {
    let name = document.getElementById('txtDesignName').value
    let bgColor = divDesign.style.backgroundColor
    let iconSize = CCSStylesheetRuleStyle('styles', '#designContainer .icon', 'height')
    let iconMargin = CCSStylesheetRuleStyle('styles', '#designContainer .icon', 'margin')
    let iconColor = CCSStylesheetRuleStyle('styles', '#designContainer .icon g', 'fill')
    let iconSvgs = divDesign.childNodes
    let icons = []

    
    let i = 1
    for (const icon of iconSvgs) {
        icons.push({
            iconId: icon.dataset.id,
            position: i
        })
        i += 1
    }

    postDesign(name, bgColor, iconSize, iconMargin, iconColor, icons)
}

function CCSStylesheetRuleStyle(stylesheet, selectorText, style, value){
    var CCSstyle = undefined, rules;
    for(var m in document.styleSheets){
      if(document.styleSheets[m].ownerNode.id == stylesheet){
       rules = document.styleSheets[m][document.all ? 'rules' : 'cssRules'];
       for(var n in rules){
         if(rules[n].selectorText == selectorText){
           CCSstyle = rules[n].style;
           break;
         }
       }
       break;
      }
    }
    if(value == undefined)
      return CCSstyle[style]
    else
      return CCSstyle[style] = value
  }

  function deleteItselfe(e) {
      let svg = e.target.closest('svg')
      svg.parentNode.removeChild(svg)
  }

  