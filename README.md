![icons-bild](https://user-images.githubusercontent.com/58586856/113117464-c0fdfb80-920e-11eb-9c42-ea917944e540.png)

# **Projekt Fanicon**


Von Rouven Wicki &amp; Cedric Gasser

Klasse S-Inf18aL

23.04.2021

# Contents

[Starten](#Starten)

[Beschreibung](#Beschreibung)

[API](#API)

[Designentscheidungen](#Designentscheidungen)

[Nutzer](#Nutzer)

[- Gruppen](#Gruppen)

[- Personas](#Personas)

[User Stories](#User-Stories)

[- Allgemein](#Allgemein)

[- Design-Editor](#Design-Editor)

[Architektur](#Architektur)

# Starten

  * `Docker`, `Docker-Compose` und `Java 11` sind vorausgesetzt
  * `cd backend; ./gradlew bootJar` backend builden
  * `docker-compose up -d` ausführen
  * [localhost](http://localhost) öffnen

Folgende User wurden stehen zum Testen zur Verfügung:

Name | Passwort | Gruppe
-----|----------|--------
Fanicon|secret|ADMIN
admin|secret|ADMIN
testli|secret|NORMAL
vip testli|secret|VIP

# Beschreibung

Wir erstellen im M151 das Backend und im M152 das Frontend, was zusammen eine Webapp ergibt. Auf dieser Webapp soll man Icons auf einer Fläche anordnen, um sein eigenes Design zu kreieren. Die Webseite hat ein Login und eine Registrierungsfunktion.

Unsere: [Präsentation](dok/Fanicon.pdf)

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

# Designentscheidungen

Bei dem Design wollten wir ein Zeitneutrales und schlichtes aber doch modernes Design haben. Deshalb haben wir nur eine Akzentfarbe verwendet.  
![](dok/fanicon-color.png)  
Um alle Seiten einheitlich zu gestalten, haben wir auf css Variabeln gesetzt. Jegliche Farben oder Masse basieren auf wenigen Variabeln die einfach geändert werden können.  
Als Akzentfarbe haben wir das Pink von unserem Logo genommen. Damit in CSS dunklere oder hellere Varianten der Farben berechnet werden können, haben wir diverse Farben im HSL format hinterlegt.  
```CSS
--accentH: 314;
--accentS: 100%;
--accentL: 46%;
--c-accent: hsl(var(--accentH), var(--accentS), var(--accentL));
```
Somit sind solche Sachen möglich:
```CSS
.nav-item.active{
    border-color: var(--c-accent);
}
```
Beim Design der Webseite haben wir [dieses Tool](https://hihayk.github.io/shaper) verwendet um die CSS Variabeln festzulegen.  
Da wir nun CSS Variabeln verwendeten, konnten wir einfach einen Dark Mode mithilfe von media queries implementieren wie [hier](https://css-tricks.com/a-complete-guide-to-dark-mode-on-the-web/) beschrieben:
```CSS
@media (prefers-color-scheme: dark) {
    
    body{
        --c-border: hsla(var(--greyH), var(--greyS), var(--grey1L), 0.1);
        --c-overlay: hsla(var(--greyH), var(--greyS), var(--grey1L), 0.07);
        --c-background: var(--c-grey8);
        --c-body: var(--c-grey1);
        --c-bodyDimmed: hsla(var(--greyH), var(--greyS), var(--grey1L), 0.5);
        --c-fieldBorder: var(--c-grey6);
        --c-buttonBg: var(--c-grey6);
    }
}
```
Bilder sollen im Dark Mode etwas gedimmter dargestellt werden. Das wird hiermit in der media query erreicht:
```CSS
img {
    filter: brightness(.8) contrast(1.2);
}
```

Im Editor sind verwandte Einstellungen beispielsweise in einem `<details>`. So kann Zusammengehörigkeit aufgezeigt werden.

Auch im Editor oder auf der Admin Seite zu sehen ist ein spacer der den oberen Teil vom unteren Teil trennt. So haben wir Elemente visuell voneinander getrennt.

Beim Platzieren der Buttons sowie beim Platzieren der Navbar haben wir nach dem Prinzip des Standarts gearbeitet. Die Bedienung unserer Seite soll also wie bei anderen Webseiten gestaltet sein und so eine gute User Experience bieten.  
Da wir Personas in der Altersgruppe 10 - 45 Jahren haben, entschieden wir uns das Design modern aber einfach zu machen. Dass heisst, dass wir keine Animationen wollten, sowie auch, dass die Buttons an dem Ort sind, an dem sie normalerweise auch sind (also wie bei bekannten Webseiten). Da wir ein Seriöses Geschäft darstellen wollen, wollten wir auch keine zu aufdringlichen Farben und wollten deshalb Farben welche man in der Heutigen Zeit auf fast allen Webseiten sieht, also Weiss und Grau und eine Akzentfarbe.

Bei unserer Webseite ist nur die Landingpage voll responsive. Dies haben wir so gemacht, da es so gedacht ist, dass man die Webseite über den PC braucht. Trotzdem ist die Webseite teilweise responsive aufgrund von Bootsrap.

# Nutzer

## Gruppen

### Normaler User

Der normale User kann aus Icons ein Design erstellen. Auch kann er Designs die andere veröffentlicht haben auswählen und für sich weiterbearbeiten. Designs werden verworfen, wenn man die Webseite verlässt.

### VIP User

Der VIP User kann auch ein Design erstellen und zusätzlich dieses abspeichern. Auch kann man als VIP User seine Designs veröffentlichen, damit andere diese suchen und verwenden können.

### Admin

Der Admin kann Icons hinzufügen und löschen. Als Admin soll man auch Designs erstellen können. Er soll auch Zugriff auf eine Liste von allen Usern haben, wo er die User filtern und suchen kann. Dort soll er auch die Nutzergruppe eines Users ändern können (Admin, VIP oder normaler User). Generell gesehen kann ein Admin alles machen was andere User auch können und mehr.

## Personas

### Lana Ming
Nutzergruppe: Admin

![lana](dok/lana.png) 

Sie ist ein Content-Creator und Designerin. Nutzt häufig unsere App, um ihre Designs und Icons hochzuladen. Sie braucht praktisch immer einen Desktop-PC und kennt sich sehr gut aus mit Computer.

### Jacob Balisong
Nutzergruppe: Admin

![jacob](dok/jacob.png) 

Er ist der Besitzer der App und hat diese mitentwickelt. Demensprechend hat er auch gute Computerkenntnisse. Er verwaltet hauptsächlich die User-Accounts und nutzt dazu das Admin-Interface seiner App, in welchem er alle User anzeigen kann.

### Frizli
Nutzergruppe: Normaler User

![fritzli](dok/frizli.png) 

Der Frizli kann sich noch nicht selbst einen VIP Account kaufen. Er kennt sich aber schon genügend mit der Technik aus und erstellt gerne Designs, welche er als Hintergrund bei seinem Schul-PC einstellt.

### Cole Sprouse
Nutzergruppe: VIP User

![cole](dok/cole.png) 

Cole hat Freude an cleanen Designs und kreiert immer wieder für sich und seine Kollegen Design, welche er auch als Sticker ausdruckt und auf diverse Gegenstände wie z.B. auf seinen Laptop draufklebt. Er kennt sich ebenfalls gut mit Computern aus und braucht unsere Web-App auch am Smartphone, um ein Design seinen Kollegen zu zeigen.

# User Stories

## Allgemein

### Registrieren

Als neuer Benutzer möchte ich mich mit Vornamen, Nachname, E-Mail-Adresse und Passwort registrieren können, um Zugang zum Design-Editor zu erhalten.

### Login

Als registrierter Benutzer möchte ich mit einloggen und den Design-Editor navigieren können, um dort ein neues Icon-Design zu erstellen.

### VIP (kaufen)

Als eingeloggter Standard-Benutzer soll ich penetrant (immer wieder/aufdringlich) auf die Möglichkeit hingewiesen werden, das VIP upgrade zu kaufen, sodass ich jederzeit ganz einfach dafür Geld ausgeben kann.

### Designs von VIPs verwenden

Als User möchte ich Designs, die von VIPs erstellt und abgespeichert wurden, auswählen, um dieses dann selbst in meinem Editor zu bearbeiten und zu verwenden.

## Design-Editor

### Design erstellen

Als eingeloggter Benutzer möchte ich im Editor Icons meiner Wahl auf einer Fläche anordnen, um ein Design zu kreieren und davon einen Screenshot aufnehmen zu können.

### Design speichern als VIP

Als VIP User kann ich ein Design, welches ich erstellt habe, abspeichern, um es später weiter zu bearbeiten und auch für andere User zu veröffentlichen.

### Icon-Library

Als User im Editor kann ich effizient und schnell nach Icons suchen, um diese meinem Design hinzuzufügen.

### Anpassbare Parameter

Als User im Editor kann ich diverse Parameter wie Farbe, Grösse und Abstand etc. einstellen, um mein Design einzigartig nach meinem Geschmack zu gestallten.

### Drag &amp; Drop aus Icon-Library (Optional)

Als User im Editor kann ich Icons aus der Library oder aus dem Design per Drag &amp; Drop herumschieben, um schnell und einfach die Icons anzuordnen.

# Copyright
Das Bild welches auf der Startwebseite gebraucht wird, wurde uns von der Website zur Verfügung gestellt.

Link Webseite: https://pixabay.com/photos/mushrooms-eat-food-vegetarian-6320451/

Link Licence: https://pixabay.com/service/license/

# Architektur

Auf einem Ubuntu-Server lauft jeder teil der Applikation in einem Docker-Container wie unten beschrieben.

![](dok/architecture.png)

Name | Image
-----|------
Reverse-Proxy | `jwilder/nginx-proxy`
Fanicon-Frontend | `docker.pkg.github.com/cedric-gasser/fanicon/fanicon-frontend`
Fanicon-Backend | `docker.pkg.github.com/cedric-gasser/fanicon/fanicon-backend`
Redis Cache | `redis:6-alpine`
Postgres DB | `postgres:13-alpine`

Während dem entwickeln wird zusätzlich ein container `dpage/pgadmin4:5.2` verwendet, um die Datenbank zu inspektieren.

Folgende Technologien verwenden wir, welche für uns grösstenteils neu sind:

- Docker
- Docker-Compose
- Fanicon Backend
  - Java
  - Spring
  - Flyway
- Postgres DB
- Fanicon Frontend
  - nginx webserver
  - JavaScript
  - HTML &amp; CSS (Bootstrap)



# ERD

![](dok/erd.png)
Hier ist bei der Design tabelle eine icon_Color spalte vom Typ VARCHAR(255) hinzu gekommen.

# Wireframe

![](dok/Start.png)
![](dok/Login.png)
![](dok/SignUp.png) 
![](dok/Home.png)
Without VIP
![](dok/Editor(no_VIP).png)
To buy VIP
![](dok/BuyVIP.png) 
With VIP
![](dok/Editor(VIP).png)
If you want to Publish
![](dok/Publish.png) 
![](dok/Designoverview.png) 
If you are an Admin you are going to see this
![](dok/Admin.png) 
If you want to add a Icon as an Admin
![](dok/Add_Icon.png)

Wir haben bei den Wireframes alles so umgesetzt, bis auf die Suchfunktion welche wir aus der Designoverview Seite geschtrichen haben, da diese dort nicht relevant war.
Zudem haben wir bei der Index Seite noch unserem Sponsor gedankt und noch Details zu unserer Webseite aufgelistet und wir haben bei der Admin seite die Icons nicht anzeigen lassen, da dies unserer Meinung nach nur unnötig Platz braucht.
