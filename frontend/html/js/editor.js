import { getIcons } from './script.js';

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

btnSearchIcon.click()

function addToDesign(e){
    let svg = e.target.closest('div').querySelector('svg').cloneNode(true)
    divDesign.appendChild(svg)
}

document.getElementById('inputBgColor').addEventListener('input', e => {
    divDesign.style.backgroundColor = e.target.value
});

document.getElementById('inputIconColor').addEventListener('input', e =>{
    let color = e.target.value
    CCSStylesheetRuleStyle('styles', '#designContainer .icon g', 'fill', color);
})

document.getElementById('inputIconMargin').addEventListener('input', e => {
    let margin = e.target.value + 'px'
    console.log('margin: ' + margin)
    CCSStylesheetRuleStyle('styles', '#designContainer .icon', 'margin', margin);
})

document.getElementById('inputIconSize').addEventListener('input', e => {
    let size = e.target.value + 'px'
    console.log('size: ' + size)
    CCSStylesheetRuleStyle('styles', '#designContainer .icon', 'height', size);
    CCSStylesheetRuleStyle('styles', '#designContainer .icon', 'width', size);
})

function CCSStylesheetRuleStyle(stylesheet, selectorText, style, value){
    /* returns the value of the element style of the rule in the stylesheet
    *  If no value is given, reads the value
    *  If value is given, the value is changed and returned
    *  If '' (empty string) is given, erases the value.
    *  The browser will apply the default one
    *
    * string stylesheet: part of the .css name to be recognized, e.g. 'default'
    * string selectorText: css selector, e.g. '#myId', '.myClass', 'thead td'
    * string style: camelCase element style, e.g. 'fontSize'
    * string value optionnal : the new value
    */
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