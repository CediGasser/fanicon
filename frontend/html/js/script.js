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

export async function buyvip(name, theme, style, svgcode){
    const data = {
        'usergroup': usergroup,
        'copyrightSource': null,
        'copyrighted': false
    }

    const response = await fetch("api/icons", {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    
    if (response.status == 200){
        location.href = "/login.html"
    }
}

export async function getusers(){

    const response = await fetch("api/users", {
        method: 'GET',
        headers: { 'Content-Type': 'application/json' }
    })
    
    if (response.status == 200){
        return await response.json()
    }
}

export async function getIcons(q){
    const response = await fetch(`api/icons?q=${q}`)

    if (response.status == 200){
        const icons = await response.json()
        return icons
    }
}