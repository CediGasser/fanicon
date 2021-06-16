import { getusers } from './script.js';

getusers().then(users => {
    let str = ''

    users.forEach(user => {
        str += `
            <tr>
                <td>${user.name}</td>
                <td>${user.email}</td>
                <td>${user.userGroup}</td>
            </tr>`
    })

    document.getElementById('userlist').innerHTML = str
})

