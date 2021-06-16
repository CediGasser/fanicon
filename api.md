# API

These are the endpoints used by our Frontend. There are a few more implemented in the Backend.

## Auth

`POST` `/auth/login` send credentials and receive sessions cookie  
`POST` `/auth/register` creates user  
`PUT` `/auth/upgrade` upgrades current normal user to vip  
`GET` `/auth/info` gets authentication info such as name or usergroup  

## Icons

`GET` `/icons` returns all Icons  
`GET` `/icons?q=sword` returns all Icons with "sword" in the Name or in the Theme Name  
`POST` `/icons` creates icon  

## Users

`GET` `/users` returns all users  

## Designs

`GET` `/designs` returns all designs  
`GET` `/users/:name/designs` returns all designs from user :name  
`GET` `/designs/:id` returns design by :id  
`POST` `/designs` send design and it either creates a design or overwrites an existing design  

