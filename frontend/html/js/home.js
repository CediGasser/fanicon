import { getDesigns, getUser } from './script.js';

let designCardsContainer = document.getElementById('designsContainer')
getUser().then(auth => {
    console.log(auth)
    getDesigns(auth.name).then(designs => {
        console.log(designs)
        let str = ''
    
        designs.forEach(design => {
    
            let iconStr = ''
            let iconCount = 4
            for (const icon of design.icons ) {
                if (icon.name !== 'Placeholder') {
                    iconStr += icon.svg
                    iconCount -= 1
                }
                if (iconCount <= 0){
                    break;
                }
            }
    
            str += `
            <a class="nolink" href="./editor.html?id=${design.id}"><div class="card cardStyle iconCard text-center designCard" style="background-color: ${design.bgColor};">
                <div class="iconsInDesign svgsFor${design.id}">
                    ${iconStr}
                </div>
                <p class="card-title tm" style="color: ${design.iconColor};">${design.name}</p>
                <p class="card-subtitle mb-2 ts text-muted" style="color: ${design.iconColor};">made by</p>
                <p class="card-title tm" style="color: ${design.iconColor};">${design.userName}</p>
            </div></a>`

            CCSStylesheetRuleStyle('styles', `.svgsFor${design.id} .icon g`, 'fill', design.iconColor)
        })
    
        designCardsContainer.innerHTML = str
    })
})

function CCSStylesheetRuleStyle(stylesheet, selectorText, style, value){
    var sheet = document.getElementById(stylesheet).sheet
    console.log(sheet)
    const rules = sheet[document.all ? 'rules' : 'cssRules'];
    sheet.insertRule(`${selectorText} { ${style}: ${value}; }`, rules.length);
}