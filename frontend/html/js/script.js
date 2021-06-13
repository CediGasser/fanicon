export async function login(name, password){
    const data = {
        'name': name,
        'password': password
    }

    const response = await fetch("api/auth/login", {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    
    if (response.status == 200){
        location.href = "/home.html"
    }
}

export async function register(name, email, password){
    const data = {
        'name': name,
        'email': email,
        'password': password
    }

    const response = await fetch("api/auth/register", {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    
    if (response.status == 200){
        login(name, password)
    }
}

export async function addicon(name, theme, style, svgcode){
    const data = {
        'name': name,
        'themeId': theme,
        'style': style,
        'svg': svgcode,
        'copyrightSource': null,
        'copyrighted': false
    }

    const response = await fetch("api/icons", {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    
    if (response.status == 200){
        location.href = "/admin.html"
    }
}

export async function getusers(){
    const response = await fetch('api/users')

    if (response.status == 200){
        const users = await response.json()
        return users
    }
}

export async function getIcons(q){
    let url = `api/icons?q=${q}`
    if (q == null) {
        url = 'api/icons'
    }

    const response = await fetch(url)

    if (response.status == 200){
        const icons = await response.json()
        return icons
    }
}

export async function upgradeToVip(){
    const response = await fetch('api/auth/upgrade', {method: 'PUT'})

    if (response.status == 200){
        location.href = "/home.html"
    }
}

export async function getAuth(){
    const response = await fetch('api/auth/info')

    if (response.status == 200){
        const body = await response.json()
        return body.authorities
    }
}

export async function postDesign(name, bgColor, iconSize, iconMargin, iconColor, icons){
    let data = {
        name: name,
        bgColor: bgColor,
        iconSize: iconSize,
        iconMargin: iconMargin,
        iconColor: iconColor,
        icons: icons
    }

    const response = await fetch("api/designs", {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    
    if (response.status == 200){
        return response
    }
}