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