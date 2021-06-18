import { toast } from './toast.js';

function fail(text){
    const options = {
        style: {
            main: {
                background: "#c00",
                color: "#fff"
            }
        }
    }
    toast.toast(text, options);
}

function success(text){
    const options = {
        style: {
            main: {
                background: "#0c0",
                color: "#fff"
            }
        }
    }
    toast.toast(text, options);
}

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
    } else {
        fail('Login failed, check Username and Password')
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
    } else {
        fail('Creating User failed')
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
        success('Icon added successfully')
    } else {
        fail('Icon could not be added')
    }
}

export async function getusers(){
    const response = await fetch('api/users')

    if (response.status == 200){
        const users = await response.json()
        return users
    } else {
        fail('Could not get Users, maybe you are not ADMIN?')
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
    } else {
        fail('Could not get Icons')
    }
}

export async function upgradeToVip(){
    const response = await fetch('api/auth/upgrade', {method: 'PUT'})

    if (response.status == 200){
        location.href = "/index.html"
    } else {
        fail('Could not upgrade you to VIP')
    }
}

export async function getAuth(){
    const response = await fetch('api/auth/info')

    if (response.status == 200){
        const body = await response.json()
        return body.authorities
    }
}

export async function getUser(){
    const response = await fetch('api/auth/info')

    if (response.status == 200){
        const body = await response.json()
        return body
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

    const response = await fetch('api/designs', {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(data)
    })
    
    if (response.status == 200){
        success(`Design "${name}" has been saved`)
    } else {
        fail('Design could not be saved, are you perhaps a NORMAL user?')
    }
}

export async function getDesigns(userName){
    let url = `api/designs`
    if (userName) {
        url = `api/users/${userName}/designs`
    }

    const response = await fetch(url)

    if (response.status == 200){
        const designs = await response.json()
        return designs
    } else {
        fail('Could not get Designs')
    }
}

export async function getDesign(id){
    const response = await fetch(`api/designs/${id}`)

    if (response.status == 200){
        const design = await response.json()
        return design
    } else {
        fail(`Could not load Design with id: ${id}`)
    }
}