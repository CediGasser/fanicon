import { getusers } from './script.js';

const btnSearchIcon = document.getElementById('btnSearchIcon')

const users = await getusers()
console.log(users)

let str = ''

users.forEach(user => {
    str += `
    <tr>
    <td>${user.name}</td>
    <td>${user.email}</td>
    <td>${user.userGroup}</td>
    </tr>`
})

console.log(str)

document.getElementById('userlist').innerHTML = str