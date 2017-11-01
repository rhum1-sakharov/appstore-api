# appstore-api

Requete pour tester le serveur d'authorization :

     curl trusted-app:secret@localhost:8080/api/oauth/token -d "grant_type=password&username=admin&password=admin"