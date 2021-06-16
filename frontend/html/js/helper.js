import { getAuth } from './script.js';

export async function isUserGroupThenWriteAtId(userGroup, html, id){
    return await getAuth().then(ctx => {
        for (let a in ctx) {
            console.log('User is: ' + ctx[a].authority)
            if (ctx[a].authority == userGroup) {
                document.getElementById(id).outerHTML = html
            }
        }
    })
}
